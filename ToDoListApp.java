import java.awt.*;
import javax.swing.*;

public class ToDoListApp {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Text field for new task input
        JTextField taskField = new JTextField();
        panel.add(taskField, BorderLayout.NORTH);

        // List model and JList for displaying tasks
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        // Add button logic
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });

        // Remove button logic
        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add panel to frame and display
        frame.add(panel);
        frame.setVisible(true);
    }
}
