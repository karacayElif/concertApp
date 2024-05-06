import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
public class ConcertsScreen extends JFrame {
    private JTable table1;
    private JPanel JPanel1;
    private Concerts_DAL cdal;
    private ArrayList<Concerts> clist;
    private DefaultTableModel tblModel;
    private final String[] tableColNames = {"Name", "Date", "Ticket Stock", "Details"};
    private JScrollBar scrollBar1;

    public ConcertsScreen() {
        JPanel1 = new JPanel();
        table1 = new JTable();

        JScrollPane scrollPane = new JScrollPane(table1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        setContentPane(JPanel1);
        setTitle("Concert Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel1.add(scrollPane, BorderLayout.CENTER);

        cdal = new Concerts_DAL();
        clist = cdal.GetConcerts();

        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(tableColNames);
        table1.setModel(tblModel);

        //center the text for table
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table1.getColumnCount(); i++) {
            table1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        updateTable();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateTable() {
        tblModel.setRowCount(0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Concerts c : clist) {
            String formattedDate = c.getDate().format(formatter);
            String[] data = {c.getName(), formattedDate, String.valueOf(c.getTicketStock()), c.getDetails()};
            tblModel.addRow(data);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ConcertsScreen());
    }
}