package TravelManagementSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.sql.*;

public class Login extends JFrame implements ActionListener{
	
	JTextField tusername, tpassword;
	JButton login, signUp, fpassword;
	Login(){
		
		setSize(800, 400);
		setLocation(400, 200);
		//custom layout
		setLayout(null);
		setTitle("Login");
		
		getContentPane().setBackground(Color.WHITE);
		
		//Panel for the left side of the login
		JPanel p1 = new JPanel();
		//p1.setBackground(Color.WHITE);
		p1.setBackground(new Color(131,193,233));
		p1.setBounds(0,0, 350, 350);
		p1.setLayout(null);
		add(p1);
		
		//image icon for the left side of the login page
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(70, 120, 200, 200);
		p1.add(image);
		
		//Panel for the right side of the login
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(350, 30, 450, 300);
		add(p2);
		
		//Text for UserName
		JLabel username = new JLabel("Username");
		username.setBounds(60,20,100,25);
		username.setFont(new Font("Calibri", Font.PLAIN, 20));
		p2.add(username);
		
		//TextField for UserName where we write our UserName
		tusername = new JTextField();
		//(60- width from the left side, 60- from top, 300- own length, 30- own width)
		tusername.setBounds(60,60,300,30);
		tusername.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tusername);
		
		//Text for Password
		JLabel password = new JLabel("Password");
		password.setBounds(60,110,100,25);
		password.setFont(new Font("Calibri", Font.PLAIN, 20));
		p2.add(password);
		
		//TextField for Password
		tpassword = new JTextField();
		tpassword.setBounds(60,150,300,30);
		tpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tpassword);
		
		//Button for login
		login = new JButton("Login");
		login.setBounds(60,200,130,30);
		login.setBackground(new Color(133, 193, 233));
		login.setForeground(Color.WHITE);
		login.setBorder(new LineBorder(new Color(133,193,233)));
		login.addActionListener(this);
		p2.add(login);
		
		//Button for signup
		signUp = new JButton("Sign Up");
		signUp.setBounds(220,200,130,30);
		signUp.setBackground(new Color(133, 193, 233));
		signUp.setForeground(Color.WHITE);
		signUp.setBorder(new LineBorder(new Color(133,193,233)));
		signUp.addActionListener(this);
		p2.add(signUp);
		
		//buttton for forgot password
		fpassword = new JButton("Forgot Password");
		fpassword.setBounds(140,240,130,30);
		fpassword.setBackground(new Color(133, 193, 233));
		fpassword.setForeground(Color.WHITE);
		fpassword.setBorder(new LineBorder(new Color(133,193,233)));
		fpassword.addActionListener(this);
		p2.add(fpassword);
		
		//if we are facing trouble while loging
		JLabel text = new JLabel("Trouble in Login...");
		text.setBounds(270, 240, 150, 20);
		text.setForeground(Color.RED);
		p2.add(text);
		
		//makes the whole frame visible
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == signUp) {
			setVisible(false);
			new SignUp();
		}else if(ae.getSource() == login) {
			try {
				String username = tusername.getText();
				String pass = tpassword.getText();
				
				String query = "select* from account where username = '"+ username +"' AND password = '"+ pass + "'";
				Conn con = new Conn();
				//result puri row return krega
				ResultSet rs = con.stat.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
			new ForgetPassword();
		}
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
