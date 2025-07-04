import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuarios {
    public void registrarUsuarios(String nombreApellido, String usuario, String contraseña, String sexo)
    {
        try 
        {
        Connection con = Conexion.conectar();

        String sql = "INSERT INTO usuarios (Nombres, Nombre_Usuario, Contraseña, Sexo) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreApellido);
        ps.setString(2, usuario);
        ps.setString(3, contraseña);  
        ps.setString(4, sexo);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Registro exitoso.");
        ps.close();
        con.close();

    } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
