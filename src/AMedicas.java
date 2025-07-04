import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class AMedicas 
{
    public void registrarArea(String nomArea, String descripcion) 
    {
        try 
        {
            Connection con = Conexion.conectar();
            String sql = "INSERT INTO areasmedicas (nomArea, descripcion) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nomArea);
            ps.setString(2, descripcion);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Área médica registrada correctamente.");
            ps.close();
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar área médica: " + e.getMessage());
        }
    }

    //public void mostrarAreasMedicas(JTable tabla) 
    //{
        ////DefaultTableModel modelo = new DefaultTableModel();
        //modelo.addColumn("ID");
        //modelo.addColumn("Médico");
        //modelo.addColumn("Área Médica");
        //modelo.addColumn("Descripción");
        //tabla.setModel(modelo);

        //String sql = "SELECT am.idareasmedicas, " + "CONCAT(m.nomMedico, ' ', m.apeMedico) AS medicoNombre, " + "am.nomArea, am.descripcion " + "FROM areasmedicas am " + "JOIN medicos m ON am.idmedicos = m.idmedicos";

        //try 
        //{
            //Connection con = Conexion.conectar();
            //Statement st = con.createStatement();
            //ResultSet rs = st.executeQuery(sql);

            //while (rs.next()) 
            //{
              //  Object[] fila = new Object[4];
                //fila[0] = rs.getInt("idareasMedicas");
                //fila[1] = rs.getString("medicoNombre");
                //fila[2] = rs.getString("nomArea");
                //fila[3] = rs.getString("descripcion");
                //modelo.addRow(fila);
           // }
            //rs.close();
            //st.close();
            //con.close();
        //} 
        //catch (Exception e) 
        //{
         //   e.printStackTrace();
           // JOptionPane.showMessageDialog(null, "Error al mostrar áreas médicas: " + e.getMessage());
        //}
    //}   
   
    public void cargarAreasEnCombo(JComboBox  combo) 
    {
        combo.removeAllItems();
        combo.addItem("Todas"); // Opción por defecto
        String sql = "SELECT DISTINCT nomArea FROM areasmedicas";

        try {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                combo.addItem(rs.getString("nomArea"));
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar áreas médicas en el combo: " + e.getMessage());
        }
    }
}
