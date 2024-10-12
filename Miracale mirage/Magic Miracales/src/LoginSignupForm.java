import javax.swing.*;
import java.awt.*;import java.awt.event.*;

public class LoginSignupForm extends JFrame {
    JTextField serverNameField;
     JTextField clientNameField;
    JPasswordField clientPasswordField;
     JPasswordField serverPasswordField;
    private JButton loginButton;
    private JPanel cards;
    private CardLayout cardLayout;
    String t2;
    static String t1;

    public LoginSignupForm() {
        setTitle("Create account:");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Set custom font
        Font font = new Font("Arial", Font.PLAIN, 14);

        // Create cards panel with CardLayout
        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        // Create login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(6, 1, 5, 5));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        loginPanel.setBackground(Color.decode("#D3D3D3")); // Light gray background

        JLabel titleLabel = new JLabel("Welcome to Our App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        loginPanel.add(titleLabel);

        JLabel serverNameLabel = new JLabel("Server Name:");
        serverNameLabel.setFont(font);
        serverNameField = new JTextField();
        t1=serverNameField.getText();
        loginPanel.add(serverNameLabel);
        loginPanel.add(serverNameField);

        JLabel clientNameLabel = new JLabel("Client Name:");
        clientNameLabel.setFont(font);
        clientNameField = new JTextField();
        t2=clientNameField.getText();
        loginPanel.add(clientNameLabel);
        loginPanel.add(clientNameField);

        JLabel clientPasswordLabel = new JLabel("Client Password:");
        clientPasswordLabel.setFont(font);
        clientPasswordField = new JPasswordField();
        loginPanel.add(clientPasswordLabel);
        loginPanel.add(clientPasswordField);

        JLabel serverPasswordLabel = new JLabel("Server Password:");
        serverPasswordLabel.setFont(font);
        serverPasswordField = new JPasswordField();
        loginPanel.add(serverPasswordLabel);
        loginPanel.add(serverPasswordField);

        loginButton = new JButton("Login");
        loginButton.setFont(font);
        loginButton.setBackground(Color.BLUE); // Green color
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your login logic here
                String serverName = serverNameField.getText();
                String clientName = clientNameField.getText();
                String clientPassword = new String(clientPasswordField.getPassword());
                String serverPassword = new String(serverPasswordField.getPassword());

                // Validate inputs
                // For simplicity, let's just display them for now
                JOptionPane.showMessageDialog(null, "Server Name: " + serverName
                                + "\n\nClient Name: " + clientName
                                + "\nClient Password: " + clientPassword
                                + "\nServer Password: " + serverPassword,
                        "Login", JOptionPane.INFORMATION_MESSAGE);
                // Switch to another card
                cardLayout.show(cards, "AnotherCard");
            }
        });
        loginPanel.add(loginButton);

        // Add login panel to cards panel
        cards.add(loginPanel, "Login");

        // Create another panel (you can replace this with your desired panel)
        JPanel anotherPanel = new JPanel();
        anotherPanel.setLayout(new BorderLayout());
        anotherPanel.setBackground(Color.WHITE);
        JLabel welcomeLabel = new JLabel("Welcome to another panel");
        welcomeLabel.setFont(font);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        anotherPanel.add(welcomeLabel, BorderLayout.CENTER);
        JButton backButton = new JButton("Back");
        backButton.setFont(font);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch back to login panel
                cardLayout.show(cards, "Login");
                new Server();
                new Clinet();
            }
        });
        anotherPanel.add(backButton, BorderLayout.SOUTH);

        // Add another panel to cards panel
        cards.add(anotherPanel, "AnotherCard");

        // Add cards panel to frame
        add(cards);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginSignupForm l1=new LoginSignupForm();
            }
        });

        System.out.println(t1);
    }
}
