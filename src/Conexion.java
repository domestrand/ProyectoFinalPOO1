import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static String url = "jdbc:mysql://localhost:3306/bdhospital";
    static String user = "root";
    static String pwd = "MyNewPass1";
    
    public static Connection conectar()
    {
        Connection con = null;
        try
        {
            con = DriverManager.getConnection(url,user,pwd);
            System.out.println("Conexion exitosa");
        } 
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
