import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ACitas {
    
public static boolean agendarCita(String fecha, String hora, String motivo, int idPaciente, int idMedico) 
{
        boolean guardado = false;

        try 
        {
            Connection con = Conexion.conectar();
            
            String verificarSql = "SELECT * FROM citas WHERE fechaCita = ? AND hora = ? AND idpacientes = ? AND idmedicos = ?";
            PreparedStatement verificarPs = con.prepareStatement(verificarSql);
            verificarPs.setString(1, fecha);
            verificarPs.setString(2, hora);
            verificarPs.setInt(3, idPaciente);
            verificarPs.setInt(4, idMedico);
            ResultSet rs = verificarPs.executeQuery();

            if (rs.next()) 
            {
                JOptionPane.showMessageDialog(null, "Ya existe una cita con esa fecha, hora, paciente y médico.");
                rs.close();
                verificarPs.close();
                con.close();
                return false;
            }
            
            String sql = "INSERT INTO citas (fechaCita, hora, motivo, idpacientes, idmedicos, estado) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fecha);
            ps.setString(2, hora);
            ps.setString(3, motivo);
            ps.setInt(4, idPaciente);
            ps.setInt(5, idMedico);
            ps.setString(6, "Agendada");

            ps.executeUpdate();
            guardado = true;

            ps.close();
            con.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

        return guardado;
    }
}
