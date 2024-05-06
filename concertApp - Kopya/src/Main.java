import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/20210305020";
        String username = "admin1";
        String password = "admin12345";
        Concerts_DAL cdal = new Concerts_DAL();
        cdal.ListToConsole();
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Bağlandı");
            connection.close();
        } catch (SQLException e) { System.out.println("Bağlantı hatası: " + e.getMessage());}

            }

    }
