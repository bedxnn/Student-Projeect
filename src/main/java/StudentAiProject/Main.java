package StudentAiProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
    //    String sql = "select name from product where id=1";
        String url = "jdbc:postgresql://localhost:5433/master"; // port from Step 1
        String username = "postgres";
        String password = "247470";



        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();

            System.out.println("Connected to postre");
            st.execute("SELECT 1");
            System.out.println("Query ok");

        } catch (SQLException e) {
            System.out.println("catch" + e.getMessage());

        }
    }
}
