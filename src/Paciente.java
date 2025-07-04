import com.toedter.calendar.JCalendar;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class Paciente {
    public void registrarPaciente(String nombre, String apellido, String dni, String sexo, String fechaNacimiento) 
    {
        try 
        {
            Connection con = Conexion.conectar();

            String sql = "INSERT INTO pacientes (nomPaciente, apePaciente, dni, sexo, fechaNacimiento) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.setString(4, sexo);
            ps.setString(5, fechaNacimiento);
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
    
    
    public void MostrarPacientes(JTable paramTablaPacientes) 
    {
        String sql = "SELECT idpacientes, nomPaciente, apePaciente, dni, sexo, fechaNacimiento FROM pacientes";

        DefaultTableModel modelo = new DefaultTableModel();
        TableRowSorter<TableModel> ordenarTabla = new TableRowSorter<>(modelo);
        paramTablaPacientes.setRowSorter(ordenarTabla);

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DNI");
        modelo.addColumn("Sexo");
        modelo.addColumn("Fecha de Nacimiento");

        paramTablaPacientes.setModel(modelo);

        String[] datos = new String[6];

        try 
        {
            Connection con = Conexion.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos[0] = String.valueOf(rs.getInt("idpacientes"));
                datos[1] = rs.getString("nomPaciente");
                datos[2] = rs.getString("apePaciente");
                datos[3] = rs.getString("dni");
                datos[4] = rs.getString("sexo");
                datos[5] = rs.getString("fechaNacimiento");

                modelo.addRow(datos);
            }

            paramTablaPacientes.setModel(modelo);

            rs.close();
            st.close();
            con.close();
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los pacientes, error: " + e.toString());
        }
    }
   
    public void EliminarPaciente(JTable tabla) 
    {
        try 
        {
        int fila = tabla.getSelectedRow(); 

        if (fila >= 0) 
        {
            String id = tabla.getValueAt(fila, 0).toString(); 
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar al paciente con ID: " + id + "?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) 
            {
                Connection con = Conexion.conectar();

                String sql = "DELETE FROM pacientes WHERE idpacientes = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(id));

                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Paciente eliminado correctamente.");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "No se encontró el paciente.");
                }

                ps.close();
                con.close();
            }
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Selecciona un paciente en la tabla.");
        }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al eliminar paciente: " + e.toString());
        }
    }
      
    public void seleccionarPaciente(JTable tabla, JTextField txtId, JTextField txtPaciente, JTextField txtApellido,JTextField txtDni, JRadioButton rMasculino, JRadioButton rFemenino, JCalendar clFechaNacPaci) 
    {
        try 
        {
            int fila = tabla.getSelectedRow();

            if (fila >= 0) 
            {
                txtId.setText(tabla.getValueAt(fila, 0).toString());
                txtPaciente.setText(tabla.getValueAt(fila, 1).toString());
                txtApellido.setText(tabla.getValueAt(fila, 2).toString());
                txtDni.setText(tabla.getValueAt(fila, 3).toString());

                String sexo = tabla.getValueAt(fila, 4).toString();
                if (sexo.equalsIgnoreCase("Masculino")) 
                {
                    rMasculino.setSelected(true);
                } 
                else if (sexo.equalsIgnoreCase("Femenino")) 
                {
                    rFemenino.setSelected(true);
                }

                String fechaTexto = tabla.getValueAt(fila, 5).toString();
                java.util.Date fecha = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(fechaTexto);
                java.util.Calendar calendario = java.util.Calendar.getInstance();
                calendario.setTime(fecha);
                clFechaNacPaci.setCalendar(calendario);

            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Selecciona una fila de la tabla.");
            }

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error al seleccionar paciente: " + e.getMessage());
        }
    }

    public void actualizarPaciente(String id, String nombre, String apellido, String dni, String sexo, String fechaNacimiento) 
    {
        String sql = "UPDATE pacientes SET nomPaciente=?, apePaciente=?, dni=?, sexo=?, fechaNacimiento=? WHERE idpacientes=?";

        try 
        {
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.setString(4, sexo);
            ps.setString(5, fechaNacimiento);
            ps.setInt(6, Integer.parseInt(id));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente actualizado correctamente.");
            ps.close();
            con.close();

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
        }
    }
}






    



