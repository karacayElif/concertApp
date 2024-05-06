import java.sql.*;
import java.util.ArrayList;
public class Concerts_DAL {

    String user = "admin1";
    String pass = "admin12345";
    String conUrl = "jdbc:mysql://localhost/20210305020";

    public void Test() {
        try (Connection conn = DriverManager.getConnection(conUrl, user, pass)) {
            //System.out.println("MySQL sunucusuna bağlanıldı.....");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ListToConsole() {
        String cmd = "SELECT `name`, `date`, `ticketStock`, `details` FROM `concerts`";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass)) {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            // System.out.println("Sonuç kümesi hazır");
            while (res.next()) {
                String name = res.getString("name");
                int date = res.getInt("date");
                int ticketStock = res.getInt("ticketStock");
                String details = res.getString("details");
                System.out.printf("Name= %s, Date= %d, Ticket Stock= %d, Details= %s%n", name, date, ticketStock, details);
            }
            //System.out.println("Listeleme sonu.");
            res.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Concerts> GetConcerts() {
        ArrayList<Concerts> clist = new ArrayList<>();

        String cmd = "SELECT `name`, `date`, `ticketStock`, `details` FROM `concerts`";

        try (Connection conn = DriverManager.getConnection(conUrl, user, pass)) {
            Statement statement = conn.createStatement();
            ResultSet res = statement.executeQuery(cmd);

            while (res.next()) {
                Concerts c = new Concerts();
                c.name = res.getString("name");
                c.ticketStock = res.getInt("ticketStock");
                c.details = res.getString("details");
                java.sql.Date sqlDate = res.getDate("date");
                if (sqlDate != null) {
                    c.setDate(sqlDate.toLocalDate());
                }
                clist.add(c);
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clist;
    }
}
