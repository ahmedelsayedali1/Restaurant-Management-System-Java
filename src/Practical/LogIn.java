package Practical;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class LogIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textUser;
    private JPasswordField textPass;

    // Theme Colors
    Color darkBackground = new Color(43, 43, 43);
    Color panelBackground = new Color(60, 63, 65);
    Color textColor = new Color(230, 230, 230);
    Color accentColor = new Color(75, 110, 175);

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogIn frame = new LogIn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LogIn() {
        // Main Frame Setup
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ahmed\\Downloads\\Resturant_Manegement\\Resturant_Manegement\\Black and White Simple Street Food Circle Logo.jpg"));
        setTitle("Login - Restaurant Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set to Full Screen
        setBounds(100, 100, 800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        contentPane = new JPanel();
        contentPane.setBackground(darkBackground);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        // Use GridBagLayout to center the login card
        contentPane.setLayout(new GridBagLayout());

        // --- Login Card Panel ---
        JPanel loginCard = new JPanel();
        loginCard.setBackground(panelBackground);
        loginCard.setLayout(null); // Absolute positioning inside the card
        loginCard.setPreferredSize(new java.awt.Dimension(400, 500)); 
        loginCard.setBorder(new LineBorder(accentColor, 2, true));

        // 1. Logo Image Handling
        JLabel lblImage = new JLabel("");
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        
        // Load and scale the image
        ImageIcon originalIcon = new ImageIcon("C:\\\\Users\\\\ahmed\\\\Downloads\\\\Resturant_Manegement\\\\Resturant_Manegement\\\\ana.png");
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        
        lblImage.setIcon(scaledIcon);
        lblImage.setBounds(106, 30, 191, 130); 
        loginCard.add(lblImage);

        // 2. Title Label
        JLabel lblTitle = new JLabel("تسجيل الدخول");
        lblTitle.setForeground(textColor);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 170, 400, 30);
        loginCard.add(lblTitle);

        // 3. Username Field
        JLabel lblUser = new JLabel("اسم المستخدم");
        styleLabel(lblUser);
        lblUser.setBounds(40, 220, 320, 20);
        loginCard.add(lblUser);

        textUser = new JTextField();
        styleTextField(textUser);
        textUser.setBounds(40, 245, 320, 30);
        loginCard.add(textUser);

        // 4. Password Field
        JLabel lblPass = new JLabel("كلمة المرور");
        styleLabel(lblPass);
        lblPass.setBounds(40, 290, 320, 20);
        loginCard.add(lblPass);

        textPass = new JPasswordField();
        styleTextField(textPass);
        textPass.setBounds(40, 315, 320, 30);
        loginCard.add(textPass);

        // 5. Login Button & Logic
        JButton btnLogin = new JButton("دخول");
        styleButton(btnLogin);
        btnLogin.setBounds(40, 375, 320, 45);
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textUsername = textUser.getText();
                String textPassword = new String(textPass.getPassword());

                // Hardcoded authentication check
                if(textUsername.equals("admin") && textPassword.equals("1234")) {
                    DashBoard frame = new DashBoard();
                    frame.setVisible(true);
                    dispose(); // Close login window
                } else {
                    JOptionPane.showMessageDialog(btnLogin, "بيانات الدخول غير صحيحة", "خطأ", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginCard.add(btnLogin);

        // Add the card to the main center container
        contentPane.add(loginCard, new GridBagConstraints());
    }

    // --- Styling Helper Methods ---
    
    private void styleLabel(JLabel lbl) {
        lbl.setForeground(textColor);
        lbl.setFont(new Font("Tahoma", Font.BOLD, 14));
        lbl.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    private void styleTextField(JTextField txt) {
        txt.setBackground(panelBackground);
        txt.setForeground(Color.WHITE);
        txt.setCaretColor(Color.WHITE);
        txt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txt.setBorder(new MatteBorder(0, 0, 2, 0, accentColor)); // Bottom border only
        txt.setHorizontalAlignment(SwingConstants.RIGHT);
    }

    private void styleButton(JButton btn) {
        btn.setBackground(accentColor);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.BOLD, 18));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
