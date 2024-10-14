package TravelManagementSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignUp extends JFrame implements ActionListener {
	
	JButton create, back;
	JTextField tusername, tpassword, tname, tsecques, tanswer;
	Choice security;
	
	SignUp(){
		//setBounds function is the combination of setSize and setLocation function
		setBounds(350, 200, 900, 360);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("SignUp");
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(133,193,233));
		p1.setBounds(0,0,500,400);
		p1.setLayout(null);
		add(p1);
		
		//Text for UserName
		JLabel username = new JLabel("Username:");
		username.setBounds(50,25,100,25);
		username.setFont(new Font("Calibri", Font.BOLD, 16));
		username.setLayout(null);
		p1.add(username);
		
		//TextField for userName
		tusername = new JTextField();
		tusername.setBounds(170,20,250,30);
		tusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tusername);
		
		//Text for Name
		JLabel name = new JLabel("Name:");
		name.setBounds(50,75,100,25);
		name.setFont(new Font("Calibri", Font.BOLD, 16));
		name.setLayout(null);
		p1.add(name);
					
		//TextField for Name
		tname = new JTextField();
		tname.setBounds(170,70,250,30);
		tname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tname);
		
		//Text for Password
		JLabel password = new JLabel("Password");
		password.setBounds(50,125,100,25);
		password.setFont(new Font("Calibri", Font.BOLD, 16));
		p1.add(password);
				
		//TextField for Password
		tpassword = new JTextField();
		tpassword.setBounds(170,120,250,30);
		tpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tpassword);
		
		//Text for Security Question
		JLabel secques = new JLabel("Security Question:");
		secques.setBounds(50,175,100,25);
		secques.setFont(new Font("Calibri", Font.BOLD, 16));
		p1.add(secques);
		
		security = new Choice();
		security.add("What is your pet Name?");
		security.add("What is your favorite Movie?");
		security.add("What is your favorite Marvel character?");
		security.add("What is your worst Acciedent?");
		security.setBounds(170, 175, 250, 30);
		p1.add(security);
				
		//TextField for Security Question
		tsecques = new JTextField();
		tsecques.setBounds(170,170,250,30);
		tsecques.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tsecques);
		
		//Text for Security Question's Answer
		JLabel answer = new JLabel("Answer:");
		answer.setBounds(50,225,100,25);
		answer.setFont(new Font("Calibri", Font.BOLD, 16));
		p1.add(answer);
						
		//TextField for Security Question's Answer
		tanswer = new JTextField();
		tanswer.setBounds(170,220,250,30);
		tanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tanswer);
		
		//Button for Create new Account
		//since we created a global variable for both create and back button we do not need to define them locally
		create = new JButton("Create");
		create.setBounds(150,270,100,30);
		create.setBackground(Color.WHITE);
		create.setForeground(new Color(133,193,233));
		create.setBorder(new LineBorder(Color.BLACK));
		create.addActionListener(this);
		p1.add(create);
				
		//Button for back to the Login Page
		back = new JButton("Back");
		back.setBounds(270,270,100,30);
		back.setBackground(Color.WHITE);
		back.setForeground(new Color(133,193,233));
		back.setBorder(new LineBorder(Color.BLACK));
		back.addActionListener(this);
		p1.add(back);
		
		//image icon for the right side of the signup page
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(600, 50, 200, 200);
		add(image);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == create) {
			String username = tusername.getText();
			String name = tname.getText();
			String password = tpassword.getText();
			String question = security.getSelectedItem();
			String answer = tanswer.getText();
			
			//we have used varchar in our database so to concate varchar we have to use 
			//single quoted commas and not double quoted commas
			String query = "insert into account values('"+username+"', '"+name+"', '"+question+"', '"+password+"', '"+answer+"')";
			try {
				Conn con = new Conn();
				con.stat.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Account created successfully");
				
				setVisible(false);
				new Login();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource() == back) {
			setVisible(false);
			new Login();
		}
	}
	
	public static void main(String[] args) {
		new SignUp();
	}

}
