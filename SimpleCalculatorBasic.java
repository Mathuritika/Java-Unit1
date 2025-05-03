import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculatorBasic extends JFrame implements ActionListener {
    JTextField textField;
    String operator = "";

    public SimpleCalculatorBasic() {
        setTitle("Simple Calculator");
        setSize(350, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text field
        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 28)); 
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        // Buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // spacing between buttons
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] buttonLabels = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "C", "=", "/"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 22)); 
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        String currentText = textField.getText();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            textField.setText(currentText + command);
        } else if (command.equals("+") || command.equals("-") ||
                   command.equals("*") || command.equals("/")) {
            if (!currentText.contains("+") && !currentText.contains("-") &&
                !currentText.contains("*") && !currentText.contains("/")) {
                textField.setText(currentText + command);
                operator = command;
            }
        } else if (command.equals("=")) {
            try {
                String[] parts = textField.getText().split("\\" + operator);
                if (parts.length == 2) {
                    double first = Double.parseDouble(parts[0]);
                    double second = Double.parseDouble(parts[1]);
                    double result = 0;

                    if (operator.equals("+")) result = first + second;
                    else if (operator.equals("-")) result = first - second;
                    else if (operator.equals("*")) result = first * second;
                    else if (operator.equals("/")) result = first / second;

                    textField.setText(String.valueOf(result));
                    operator = "";
                }
            } catch (Exception e) {
                textField.setText("Error");
            }
        } else if (command.equals("C")) {
            textField.setText("");
            operator = "";
        }
    }

    public static void main(String[] args) {
        new SimpleCalculatorBasic();
    }
}
