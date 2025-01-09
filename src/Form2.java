import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Form2 extends JFrame {
    private JTable table1;
    private JPanel panel1;

    public Form2() {
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 500);
        setLocationRelativeTo(null);
        loadData();
    }

    private void loadData() {
        // Conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/tarea";
        String user = "root";
        String password = "123456";
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM personas");

            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("nombre");
            model.addColumn("edad");
            model.addColumn("ciudad");

            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getString("ID"),
                        resultSet.getString("nombre"),
                        resultSet.getString("edad"),
                        resultSet.getString("ciudad")
                });
            }

            table1.setModel(model);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}