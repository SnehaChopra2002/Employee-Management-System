package employee.management.system;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "sherlock@221B");
            s=c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
