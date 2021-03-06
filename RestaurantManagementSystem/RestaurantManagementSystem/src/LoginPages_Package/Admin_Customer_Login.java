package LoginPages_Package;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin_package.Admin_Display_Pages;
import Customer_Package.Customer_Display_page;
import Db_Models.EmployeeDetails;
import Db_Models.Userdetails;
import Employee_Package.Employe_Display_Page;
import db_Connection_Package.EmployConnections;
import db_Connection_Package.UserConnections;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Admin_Customer_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField username_field;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JPasswordField Employ_passfield;

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Customer_Login frame = new Admin_Customer_Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanels(JPanel jPanel)
	{
		layeredPane.removeAll();
		layeredPane.add(jPanel);
		layeredPane.repaint();
		layeredPane.revalidate();

	}
	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Admin_Customer_Login() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		JButton Customer_btn;
		JButton Admin_btn;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1064, 686);
		setTitle("LOGIN PAGE");
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 443, 659);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Alpha");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 60));
		lblNewLabel_2.setBounds(128, 303, 189, 103);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Restaurant");
		lblNewLabel_3.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 49));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(110, 383, 254, 88);
		panel.add(lblNewLabel_3);
		
		JLabel imagedisplay = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/restaurant_logo.jfif")).getImage();
		imagedisplay.setIcon(new ImageIcon(img));

		imagedisplay.setBounds(61, 113, 303, 180);
		panel.add(imagedisplay);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(444, 99, 616, 560);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Customer = new JPanel();
		layeredPane.add(Customer, "name_28724057870000");
		Customer.setBackground(Color.ORANGE);
		Customer.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER");
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD, 42));
		lblNewLabel.setBounds(207, 54, 231, 64);
		Customer.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("Username");
		lblNewLabel_6.setFont(new Font("Tempus Sans ITC", Font.BOLD, 29));
		lblNewLabel_6.setBounds(79, 181, 161, 42);
		Customer.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setFont(new Font("Tempus Sans ITC", Font.BOLD, 29));
		lblNewLabel_7.setBounds(79, 267, 161, 37);
		Customer.add(lblNewLabel_7);
		
		username_field = new JTextField();
		username_field.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		username_field.setBounds(314, 186, 225, 37);
		Customer.add(username_field);
		username_field.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 18));
		passwordField_1.setBounds(314, 267, 231, 37);
		Customer.add(passwordField_1);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
			//TODO
				Userdetails uds = new Userdetails();
				uds.setName(username_field.getText());
				uds.setPassword(passwordField_1.getText());
				try {
					btnLoginCustomer(evt, uds);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 32));
		btnNewButton_1.setBounds(79, 405, 210, 49);
		Customer.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
               //TODO
				try {
					btnLoginActionPerformed(evt);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tempus Sans ITC", Font.BOLD, 30));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(365, 406, 210, 49);
		Customer.add(btnNewButton_2);
		
		JPanel Admin = new JPanel();
		layeredPane.add(Admin, "name_28743664187500");
		Admin.setBackground(Color.ORANGE);
		Admin.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 44));
		lblNewLabel_1.setBounds(239, 41, 236, 67);
		Admin.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblNewLabel_4.setBounds(79, 163, 161, 51);
		Admin.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		lblNewLabel_5.setBounds(79, 245, 161, 67);
		Admin.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 19));
		textField.setBounds(284, 170, 236, 37);
		Admin.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 20));
		passwordField.setBounds(284, 263, 236, 37);
		Admin.add(passwordField);
		
		JButton Admin_display_login = new JButton("Login");
		Admin_display_login.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//TODO
				btnAdminLogin(evt,textField.getText(),passwordField.getText());
			}
		});
		Admin_display_login.setForeground(new Color(255, 255, 255));
		Admin_display_login.setFont(new Font("Tempus Sans ITC", Font.BOLD, 33));
		Admin_display_login.setBackground(Color.BLACK);
		Admin_display_login.setBounds(241, 403, 193, 67);
		Admin.add(Admin_display_login);
		
		JPanel employ = new JPanel();
		employ.setLayout(null);
		employ.setBackground(Color.ORANGE);
		layeredPane.add(employ, "name_18968391601200");
		
		JLabel lblNewLabel_1_1 = new JLabel("Employ");
		lblNewLabel_1_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 44));
		lblNewLabel_1_1.setBounds(239, 41, 236, 67);
		employ.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Username");
		lblNewLabel_4_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		lblNewLabel_4_1.setBounds(79, 163, 161, 51);
		employ.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Password");
		lblNewLabel_5_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 27));
		lblNewLabel_5_1.setBounds(79, 245, 161, 67);
		employ.add(lblNewLabel_5_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 19));
		textField_1.setColumns(10);
		textField_1.setBounds(284, 170, 236, 37);
		employ.add(textField_1);
		
		Employ_passfield = new JPasswordField();
		Employ_passfield.setFont(new Font("Verdana", Font.PLAIN, 20));
		Employ_passfield.setBounds(284, 263, 236, 37);
		employ.add(Employ_passfield);
		
		JButton btnNewButton_3 = new JButton("Login");
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EmployeeDetails ed = new EmployeeDetails();
				ed.setname(textField_1.getText());
				ed.setPassword(Employ_passfield.getText());
				try {
					btnemployLogin(evt,ed);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
			}
		});
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tempus Sans ITC", Font.BOLD, 33));
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(241, 403, 193, 67);
		employ.add(btnNewButton_3);
		
		Customer_btn = new JButton("Customer");
		Admin_btn = new JButton("Admin");
		JButton Admin_btn_1 = new JButton("Employ");
		Customer_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Customer);
				Customer_btn.setBackground(new Color(255, 255, 255));
				Admin_btn.setBackground(Color.BLACK);
				Customer_btn.setForeground(Color.BLACK);
				Admin_btn.setForeground(new Color(255, 255, 255));
				Admin_btn_1.setBackground(Color.BLACK);
				Admin_btn_1.setForeground(new Color(255, 255, 255));
				
			}
		});
		Customer_btn.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 30));
		Customer_btn.setForeground(Color.BLACK);
		Customer_btn.setBackground(new Color(255,255,255));
		Customer_btn.setBounds(449, 28, 176, 55);
		contentPane.add(Customer_btn);
		
		
		Admin_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Admin);
				Customer_btn.setBackground(Color.BLACK);
				Admin_btn.setBackground(new Color(255, 255, 255));
				Customer_btn.setForeground(new Color(255, 255, 255));
				Admin_btn.setForeground(Color.BLACK);
				Admin_btn_1.setBackground(Color.BLACK);
				Admin_btn_1.setForeground(new Color(255, 255, 255));
				
				
			}
		});
		Admin_btn.setForeground(Color.WHITE);
		Admin_btn.setBackground(Color.BLACK);
		Admin_btn.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 35));
		Admin_btn.setBounds(654, 26, 176, 55);
		contentPane.add(Admin_btn);
		
		
		Admin_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(employ);
				Customer_btn.setBackground(Color.BLACK);
				Admin_btn.setBackground(Color.BLACK);
				Customer_btn.setForeground(Color.WHITE);
				Admin_btn.setForeground(Color.WHITE);
				Admin_btn_1.setBackground(new Color(255, 255, 255));
				Admin_btn_1.setForeground(Color.BLACK);
			}
		});
		Admin_btn_1.setForeground(Color.WHITE);
		Admin_btn_1.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 35));
		Admin_btn_1.setBackground(Color.BLACK);
		Admin_btn_1.setBounds(851, 26, 176, 55);
		
		contentPane.add(Admin_btn_1);
	}

	private void btnAdminLogin(ActionEvent evt, String text, String text2) {
		if (text.equals("Admin") && text2.equals("admin")) {
			try {
				Admin_Display_Pages adp = new Admin_Display_Pages();
				adp.setVisible(true);
				this.dispose();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	private void btnemployLogin(ActionEvent evt, EmployeeDetails ed) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		EmployConnections ecc = new EmployConnections();
		boolean i = ecc.EmplyeeLogin(ed);
		if (i) {
			Employe_Display_Page adp = new Employe_Display_Page(ed.getname());
			adp.setVisible(true);
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Incorrect Credentials");
		}
		
	}

	private void btnLoginActionPerformed(final java.awt.event.ActionEvent evt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    //TODO
		Register_Page rp = new Register_Page();
		rp.setVisible(true);
		this.dispose();
    }
	private void btnLoginCustomer(final java.awt.event.ActionEvent evt,Userdetails ud) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UserConnections uc = new UserConnections();
		boolean i = uc.LoginUser(ud);
		if (i) {
			Customer_Display_page cda = new Customer_Display_page(ud.getName());
			cda.setVisible(true);
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
		}
		
	}
}
