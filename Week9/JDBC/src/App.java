import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String url = "jdbc:mysql://localhost:3306/world";
        String user = "root";
        String password = "8064";

       try (Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();) {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM country");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString("name"));
        }

        resultSet.close();
    }
    catch (SQLException ex) {
        System.err.println("Exception: " + ex.getMessage());
    }
    }
}
