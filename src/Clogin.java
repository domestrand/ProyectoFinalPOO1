import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Clogin {
    public boolean ValidarUsuario(JTextField usuario, JTextField contraseña)
    {
        try 
        {
            Connection con = Conexion.conectar();
            
            String sql = "SELECT * FROM usuarios WHERE Nombre_Usuario = ? AND Contraseña = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getText());
            ps.setString(2, contraseña.getText());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) 
            {
                return true;
            } 
            else 
            {
                return false;
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
            return false;
        }
    }
}
