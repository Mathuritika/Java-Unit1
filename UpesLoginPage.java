import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UpesLoginPage {

    private static final String ADMIN_EMAIL = "admin@upes.ac.in";
    private static final String ADMIN_PASSWORD = "admin";       

    public static void main(String[] args) {
        showLoginPage();
    }

    public static void showLoginPage() {
        JFrame frame = new JFrame("UPES Student Login");
        frame.setSize(500, 270); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel emailLabel = new JLabel("Enter Email:");
        gbc.gridx = 0; gbc.gridy = 0; panel.add(emailLabel, gbc);

        JTextField emailField = new JTextField(35);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(emailField, gbc);

        JLabel passLabel = new JLabel("Enter Password:");
        gbc.gridx = 0; gbc.gridy = 1; panel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(35);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(passField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 1; gbc.gridy = 2; gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        JLabel adminLabel = new JLabel("Admin Login:");
        gbc.gridx = 0; gbc.gridy = 3; panel.add(adminLabel, gbc);
        gbc.gridx = 1;

        JButton adminLoginButton = new JButton("Admin");
        panel.add(adminLoginButton, gbc);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loginButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter both email and password.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (email.endsWith("@stu.upes.ac.in")) {
                if (password.equals("demo")) {
                    JOptionPane.showMessageDialog(frame, "Student Login successful!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                    showLostFoundOptions();
                } else {
                    JOptionPane.showMessageDialog(frame, "Incorrect password for student login.", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Only UPES student email addresses are allowed.", "Invalid Email", JOptionPane.WARNING_MESSAGE);
            }
        });

        adminLoginButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passField.getPassword()).trim();

            if (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) {
                JOptionPane.showMessageDialog(frame, "Admin Login successful!", "Welcome Admin", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
                showAdminFoundItems();
            } else {
                JOptionPane.showMessageDialog(frame, "Admin authentication failed.", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void showAdminFoundItems() {
        JFrame adminFrame = new JFrame("All Found Items");
        adminFrame.setSize(800, 600);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 

        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Item Name", "Description", "Location Found", "Date Found", "Contact Info"}, 0);
        JTable foundItemsTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(foundItemsTable);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lost_and_found", "root", "20081997")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM found_items");

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("item_name"),
                        rs.getString("description"),
                        rs.getString("location_found"),
                        rs.getString("date_found"),
                        rs.getString("contact_info")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(adminFrame, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        adminFrame.add(scrollPane);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setVisible(true);
    }

    public static void showLostFoundOptions() {
        JFrame optionsFrame = new JFrame("Lost and Found");
        optionsFrame.setSize(350, 160);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton lostButton = new JButton("I lost something");
        JButton foundButton = new JButton("I found something");
        JButton backButton = new JButton("Back");

        panel.add(lostButton);
        panel.add(foundButton);
        panel.add(backButton);

        optionsFrame.add(panel);
        optionsFrame.setLocationRelativeTo(null);
        optionsFrame.setVisible(true);

        lostButton.addActionListener(e -> {
            optionsFrame.dispose();
            openLostSearchForm();
        });

        foundButton.addActionListener(e -> {
            optionsFrame.dispose();
            openFoundForm();
        });

        backButton.addActionListener(e -> {
            optionsFrame.dispose();
            showLoginPage();
        });
    }

    public static void openFoundForm() {
        JFrame foundFrame = new JFrame("Found Item - Submit Details");
        foundFrame.setSize(400, 330);

        JPanel contentPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JTextField itemName = new JTextField();
        JTextField description = new JTextField();
        JTextField location = new JTextField();
        JTextField date = new JTextField(); 
        JTextField contact = new JTextField();

        JButton submit = new JButton("Submit");
        JButton back = new JButton("Back");

        contentPanel.add(new JLabel("Item Name:"));
        contentPanel.add(itemName);
        contentPanel.add(new JLabel("Description:"));
        contentPanel.add(description);
        contentPanel.add(new JLabel("Location Found:"));
        contentPanel.add(location);
        contentPanel.add(new JLabel("Date Found:"));
        contentPanel.add(date); 
        contentPanel.add(new JLabel("Contact Info:"));
        contentPanel.add(contact);
        contentPanel.add(back);
        contentPanel.add(submit);

        foundFrame.add(contentPanel);
        foundFrame.setLocationRelativeTo(null);
        foundFrame.setVisible(true);

        submit.addActionListener(e -> {
            String item = itemName.getText().trim();
            String desc = description.getText().trim();
            String loc = location.getText().trim();
            String foundDate = date.getText().trim(); 
            String contactInfo = contact.getText().trim();

            if (item.isEmpty() || desc.isEmpty() || loc.isEmpty() || foundDate.isEmpty() || contactInfo.isEmpty()) {
                JOptionPane.showMessageDialog(foundFrame, "Please fill in all fields, including the date.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lost_and_found", "root", "20081997")) {
                String insertQuery = "INSERT INTO found_items (item_name, description, location_found, date_found, contact_info) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(insertQuery);
                stmt.setString(1, item);
                stmt.setString(2, desc);
                stmt.setString(3, loc);
                stmt.setString(4, foundDate);
                stmt.setString(5, contactInfo);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(foundFrame, "Item submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                foundFrame.dispose();
                showLostFoundOptions();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(foundFrame, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        back.addActionListener(e -> {
            foundFrame.dispose();
            showLostFoundOptions();
        });
    }

    public static void openLostSearchForm() {
        JFrame lostFrame = new JFrame("Search Lost Item");
        lostFrame.setSize(500, 450); // Adjusted height
        lostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel keywordLabel = new JLabel("Enter keyword(s) of lost item:");
        JTextField keywordField = new JTextField(20);
        JTextField dateLostField = new JTextField(15); 
        JButton searchButton = new JButton("Search");

        topPanel.add(keywordLabel);
        topPanel.add(keywordField);
        topPanel.add(searchButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultArea);

        JButton backButton = new JButton("Back");
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        bottomPanel.add(backButton);

        lostFrame.setLayout(new BorderLayout());
        lostFrame.add(topPanel, BorderLayout.NORTH);
        lostFrame.add(scrollPane, BorderLayout.CENTER);
        lostFrame.add(bottomPanel, BorderLayout.SOUTH);
        lostFrame.setLocationRelativeTo(null);
        lostFrame.setVisible(true);

        searchButton.addActionListener(e -> {
            String searchText = keywordField.getText().trim().toLowerCase();
            String lostDateStr = dateLostField.getText().trim(); 
            String[] searchKeywords = searchText.split("\\s+");
            StringBuilder result = new StringBuilder();

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lost_and_found", "root", "20081997")) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM found_items");

                while (rs.next()) {
                    String itemName = rs.getString("item_name").toLowerCase();
                    String description = rs.getString("description").toLowerCase();
                    String locationFound = rs.getString("location_found").toLowerCase();
                    String foundDateDb = rs.getString("date_found");
                    boolean keywordMatch = searchText.isEmpty(); 

                    if (!searchText.isEmpty()) {
                        for (String keyword : searchKeywords) {
                            if (itemName.contains(keyword) || description.contains(keyword) || locationFound.contains(keyword)) {
                                keywordMatch = true;
                                break;
                            }
                        }
                    }

                    if (keywordMatch) {
                        if (lostDateStr.isEmpty() || foundDateDb.equals(lostDateStr)) {
                            result.append("Item: ").append(rs.getString("item_name")).append("\n");
                            result.append("Description: ").append(rs.getString("description")).append("\n");
                            result.append("Location: ").append(rs.getString("location_found")).append("\n");
                            result.append("Date Found: ").append(foundDateDb).append("\n");
                            result.append("Contact: ").append(rs.getString("contact_info")).append("\n\n");
                        }
                    }
                }

                if (result.length() == 0 && !searchText.isEmpty() && !lostDateStr.isEmpty()) {
                    result.append("No items found matching your keywords on ").append(lostDateStr).append(".\n\n");
                    result.append("Showing all items found on ").append(lostDateStr).append(":\n\n");
                    PreparedStatement dateStmt = conn.prepareStatement("SELECT * FROM found_items WHERE date_found = ?");
                    dateStmt.setString(1, lostDateStr);
                    ResultSet dateRs = dateStmt.executeQuery();
                    while (dateRs.next()) {
                        result.append("Item: ").append(dateRs.getString("item_name")).append("\n");
                        result.append("Description: ").append(dateRs.getString("description")).append("\n");
                        result.append("Location: ").append(dateRs.getString("location_found")).append("\n");
                        result.append("Date Found: ").append(dateRs.getString("date_found")).append("\n");
                        result.append("Contact: ").append(dateRs.getString("contact_info")).append("\n\n");
                    }
                    if (result.toString().contains("Showing all items") && !result.toString().contains("Item:")) {
                        result = new StringBuilder("No items found on ").append(lostDateStr).append(".");
                    }
                } else if (result.length() == 0 && !searchText.isEmpty()) {
                    result.append("No items found matching your keywords.");
                } else if (result.length() == 0 && !lostDateStr.isEmpty()) {
                    result.append("No items found on ").append(lostDateStr).append(".");
                } else if (result.length() == 0) {
                    result.append("No items found.");
                }
                resultArea.setText(result.toString());

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(lostFrame, "Error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        backButton.addActionListener(e -> {
            lostFrame.dispose();
            showLostFoundOptions();
        });
    }
}