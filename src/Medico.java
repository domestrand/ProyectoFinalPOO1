import com.toedter.calendar.JCalendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Medico {
    
    public void registrarMedico(String nombre, String apellido, String especialidad, String dni, String fechaNacimiento, String sexo) {
        try 
        {
            Connection con = Conexion.conectar();

            String sql = "INSERT INTO medicos (nomMedico, apeMedico, especialidad, dniMedico, fechaNacMedico, sexoMedico) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, especialidad);
            ps.setString(4, dni);
            ps.setString(5, fechaNacimiento);
            ps.setString(6, sexo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso.");
            ps.close();
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void mostrarMedicos(JTable paramTablaMedicos)
    {
        String sql = "SELECT idmedicos, nomMedico, apeMedico, especialidad, dniMedico, fechaNacMedico, sexoMedico FROM medicos";
        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        paramTablaMedicos.setRowSorter(ordenarTabla);
        
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Especialidad");
        modelo.addColumn("DNI");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Sexo");

        paramTablaMedicos.setModel(modelo);
        String[] datos = new String[7];

        try 
        {
            Connection con = Conexion.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next())
                {
                    datos[0] = String.valueOf(rs.getInt("idmedicos"));
                    datos[1] = rs.getString("nomMedico");
                    datos[2] = rs.getString("apeMedico");
                    datos[3] = rs.getString("especialidad");
                    datos[4] = rs.getString("dniMedico");
                    datos[5] = rs.getString("fechaNacMedico");
                    datos[6] = rs.getString("sexoMedico");
                    modelo.addRow(datos);
                }
            paramTablaMedicos.setModel(modelo);
            rs.close();
            st.close();
            con.close();
        } 
        
        catch (Exception e) 
        {
        JOptionPane.showMessageDialog(null, "Error al mostrar médicos.");
        }
    }
    
    public void EliminarMedico(JTable tabla) 
    {
        try 
        {
            int fila = tabla.getSelectedRow(); 

            if (fila >= 0) 
            {
                String idTexto = tabla.getValueAt(fila, 0).toString(); 
                int idMedico = Integer.parseInt(idTexto);
                Connection con = Conexion.conectar();
                String sqlVerificar = "SELECT COUNT(*) FROM citas WHERE idmedicos = ?";
                PreparedStatement psVerificar = con.prepareStatement(sqlVerificar);
                psVerificar.setInt(1, idMedico);
                ResultSet rs = psVerificar.executeQuery();

                if (rs.next() && rs.getInt(1) > 0) 
                {
                    JOptionPane.showMessageDialog(null, "No puedes eliminar este médico porque tiene citas registradas.");
                    rs.close();
                    psVerificar.close();
                    con.close();
                    return;
                }

                rs.close();
                psVerificar.close();

                int confirmar = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar al medico con ID: " + idMedico + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                if (confirmar == JOptionPane.YES_OPTION) 
                {
                    String sqlEliminar = "DELETE FROM medicos WHERE idmedicos = ?";
                    PreparedStatement psEliminar = con.prepareStatement(sqlEliminar);
                    psEliminar.setInt(1, idMedico);

                    int rowsAffected = psEliminar.executeUpdate();

                    if (rowsAffected > 0) 
                    {
                        JOptionPane.showMessageDialog(null, "Médico eliminado correctamente.");
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "No se encontró el médico.");
                    }

                    psEliminar.close();
                }

                con.close();
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Selecciona un médico en la tabla.");
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al eliminar médico: " + e.toString());
        }
    }
    
    public void seleccionarMedico(JTable tabla, JTextField txtId, JTextField txtNomMedico, JTextField txtApeMedico, JTextField txtEspecialidad, JTextField txtDniMedico, JCalendar clFNMedico, JRadioButton rbtnMMedico, JRadioButton rbtnFMedico) 
    {
        try 
        {
            int fila = tabla.getSelectedRow();

            if (fila >= 0) 
            {
                txtId.setText(tabla.getValueAt(fila, 0).toString());
                txtNomMedico.setText(tabla.getValueAt(fila, 1).toString());
                txtApeMedico.setText(tabla.getValueAt(fila, 2).toString());              
                txtEspecialidad.setText(tabla.getValueAt(fila, 3).toString());
                txtDniMedico.setText(tabla.getValueAt(fila, 4).toString());

                String sexo = tabla.getValueAt(fila, 5).toString();
                if (sexo.equalsIgnoreCase("Masculino")) 
                {
                    rbtnMMedico.setSelected(true);
                } 
                else if (sexo.equalsIgnoreCase("Femenino")) 
                {
                    rbtnFMedico.setSelected(true);
                }

                String fechaTexto = tabla.getValueAt(fila, 6).toString();
                java.util.Date fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(fechaTexto);
                java.util.Calendar calendario = java.util.Calendar.getInstance();
                calendario.setTime(fecha);
                clFNMedico.setCalendar(calendario);

            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla.");
            }

        } 
        catch (Exception e) 
        {
            
        }
    }
    
    public void actualizarMedico(String id, String nombre, String apellido, String especialidad, String dni, String fechaNacimiento, String sexo) 
    {
        String sql = "UPDATE medicos SET nomMedico=?, apeMedico=?, especialidad=?, dniMedico=?, fechaNacMedico=?, sexoMedico=? WHERE idmedicos=?";

        try 
        {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, especialidad);
            ps.setString(4, dni);
            ps.setString(5, fechaNacimiento);
            ps.setString(6, sexo);
            ps.setInt(7, Integer.parseInt(id));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Medico actualizado correctamente.");
            ps.close();
            con.close();

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
        }
    }
}