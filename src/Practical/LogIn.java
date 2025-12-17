package Practical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public LogIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\gamal\\Downloads\\Black and White Simple Street Food Circle Logo.jpg"));
		setTitle("Resturant Manegement");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(21, 31, 64, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(21, 94, 64, 28);
		contentPane.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setBounds(108, 31, 109, 28);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPass = new JPasswordField();
		textPass.setBounds(108, 94, 109, 24);
		contentPane.add(textPass);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textUsername= textUser.getText();
				String textPassword =new String(textPass.getPassword());
				
				if(textUsername.equals("admin") && textPassword.equals("1234"))
				{
					JOptionPane.showMessageDialog(btnNewButton,"Success","SuccessFullY",JOptionPane.INFORMATION_MESSAGE);
					DashBoard frame = new DashBoard();
					frame.setVisible(true);
					dispose();
					
				}
				else {
					JOptionPane.showMessageDialog(btnNewButton, "Invalid Password", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(156, 169, 95, 28);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\gamal\\Downloads\\output-onlinepngtools-removebg-preview.png"));
		lblNewLabel_2.setBounds(245, 10, 191, 168);
		contentPane.add(lblNewLabel_2);
		
		
		

	}
}
