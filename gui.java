package csc380Project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class gui extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    gui frame = new gui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public gui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(108, 42, 96, 20);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("UserName:");
        lblNewLabel.setBounds(10, 44, 79, 17);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Password:");
        lblNewLabel_1.setBounds(10, 76, 79, 17);
        panel.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(108, 74, 96, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Phone Number:");
        lblNewLabel_2.setBounds(10, 106, 103, 14);
        panel.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(108, 105, 96, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JButton btnNewButton = new JButton("Ok");
        btnNewButton.setBounds(299, 151, 89, 23);
        panel.add(btnNewButton);

        // Add ActionListener to the button
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField_2.getText(); // Get text from the textField_2

                // Validate input
                if (input.matches("\\d{10}")) { // Regex for exactly 10 digits
                    // Show success message if valid
                    JOptionPane.showMessageDialog(panel, 
                        "Input is valid!", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Show error message if invalid
                    JOptionPane.showMessageDialog(panel, 
                        "Invalid input! Please enter exactly 10 digits.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
