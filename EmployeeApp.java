import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class EmployeeApp {

    // Declaring fields
    static JTextField idField, nameField, deptField, salaryField;
    static JTable table;
    static DefaultListModel<String> listModel;
    static DefaultTableModel tableModel;

    public static void main(String[] args) {
        // Create Frame
        JFrame frame = new JFrame("Employee Record System");
        frame.setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        inputPanel.add(new JLabel("Employee ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Department:"));
        deptField = new JTextField();
        inputPanel.add(deptField);

        inputPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        inputPanel.add(salaryField);

        JButton insertButton = new JButton("Insert");
        inputPanel.add(insertButton);

        JButton loadButton = new JButton("Load Records");
        inputPanel.add(loadButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Table
        tableModel = new javax.swing.table.DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[]{"ID", "Name", "Department", "Salary"});
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Button Actions
        insertButton.addActionListener(e -> insertEmployee());
        loadButton.addActionListener(e -> loadEmployees());

        // Framing Settings
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Inserting data into DB
    public static void insertEmployee() {
        String id = idField.getText();
        String name = nameField.getText();
        String dept = deptField.getText();
        String salary = salaryField.getText();

        try {
            Connection con = getConnection();
            String query = "INSERT INTO employees (id, name, department, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, Integer.parseInt(id));
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.setDouble(4, Double.parseDouble(salary));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Inserted Successfully");
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Loading all data into JTable
    public static void loadEmployees() {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

            tableModel.setRowCount(0); // clearing previous rows

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("department");
                double salary = rs.getDouble("salary");

                tableModel.addRow(new Object[]{id, name, dept, salary});
            }

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
    }

    // Connecting to MySQL
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/empdb";
        String username = "root"; 
        String password = "20081997";     

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
}
