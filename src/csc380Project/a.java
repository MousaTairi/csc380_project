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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class a extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private LinkedList userNamelist = new LinkedList(); // Your custom linked list

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    a frame = new a();
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
    public a() {
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

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Insert");
        rdbtnNewRadioButton.setBounds(58, 168, 109, 23);
        panel.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Update");
        rdbtnNewRadioButton_1.setBounds(58, 192, 109, 23);
        panel.add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Delete");
        rdbtnNewRadioButton_2.setBounds(58, 218, 109, 23);
        panel.add(rdbtnNewRadioButton_2);

        JLabel lblNewLabel_3 = new JLabel("Select a choice:");
        lblNewLabel_3.setBounds(37, 155, 89, 14);
        panel.add(lblNewLabel_3);

        // Group radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(rdbtnNewRadioButton);
        group.add(rdbtnNewRadioButton_1);
        group.add(rdbtnNewRadioButton_2);

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText(); // Username input

                // Validate username input
                if (username.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, 
                        "Invalid input! UserName can't be empty.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Perform action based on selected radio button
                if (rdbtnNewRadioButton.isSelected()) {
                    boolean result = userNamelist.insert(username); // Use your custom insert logic
                    if (!result) {
                        JOptionPane.showMessageDialog(panel, 
                            "Invalid input! UserName already exists! Try another one.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panel, 
                            "User added successfully!", 
                            "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (rdbtnNewRadioButton_1.isSelected()) {
                    boolean exists = userNamelist.find(username); // Assuming a `contains` method exists
                    if (!exists) {
                        JOptionPane.showMessageDialog(panel, 
                            "UserName not found! Cannot update.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panel, 
                            "User updated successfully (no real action implemented here).", 
                            "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                } else if (rdbtnNewRadioButton_2.isSelected()) {
                    boolean removed = userNamelist.remove(username); // Use your custom delete logic
                    if (!removed) {
                        JOptionPane.showMessageDialog(panel, 
                            "UserName not found! Cannot delete.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(panel, 
                            "User deleted successfully!", 
                            "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, 
                        "Please select an operation (Insert, Update, Delete).", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
