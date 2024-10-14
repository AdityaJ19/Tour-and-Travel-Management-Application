package TravelManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
	
	JTextField tusername, tname, tquestion, tanswer, tpassword;
	JButton search, retrieve, back;
	
	ForgetPassword() {
		setBounds(350, 200, 850, 350);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Forget Password");

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
		Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(580, 40, 200, 200);
		add(image);

		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(30, 30, 500, 250);
		add(p1);
		
		JLabel username = new JLabel("Username");
		username.setBounds(30,20,100,25);
		username.setFont(new Font("Calibri", Font.BOLD, 16));
		p1.add(username);
		
		tusername = new JTextField();
		tusername.setBounds(180,20,150,25);
		tusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tusername);
		
		search = new JButton("Search");
		search.setBounds(380,20,80,25);
		search.setBackground(Color.GRAY);
		search.setForeground(Color.WHITE);
		search.setBorder(new LineBorder(Color.WHITE));
		search.addActionListener(this);
		p1.add(search);
		
		JLabel name = new JLabel("Name");
		name.setBounds(30,60,100,25);
		name.setFont(new Font("Calibri", Font.BOLD, 16));
		p1.add(name);
		
		tname = new JTextField();
		tname.setBounds(180,60,150,25);
		tname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tname);
		
		JLabel question = new JLabel("Security Question");
		question.setBounds(30,100,100,25);
		question.setFont(new Font("Calibri", Font.BOLD, 16));
		p1.add(question);
		
		tquestion = new JTextField();
		tquestion.setBounds(180,100,150,25);
		tquestion.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tquestion);
		
		JLabel answer = new JLabel("Answer");
		answer.setBounds(30,140,100,25);
		answer.setFont(new Font("Calibri", Font.BOLD, 16));
		p1.add(answer);
		
		tanswer = new JTextField();
		tanswer.setBounds(180,140,150,25);
		tanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tanswer);
		
		retrieve = new JButton("Retrieve");
		retrieve.setBounds(380,140,80,25);
		retrieve.setBackground(Color.GRAY);
		retrieve.setForeground(Color.WHITE);
		retrieve.setBorder(new LineBorder(Color.WHITE));
		retrieve.addActionListener(this);
		p1.add(retrieve);
		
		JLabel password = new JLabel("Password");
		password.setBounds(30,180,100,25);
		password.setFont(new Font("Calibri", Font.BOLD, 16));
		p1.add(password);
		
		tpassword = new JTextField();
		tpassword.setBounds(180,180,150,25);
		tpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tpassword);
		
		back = new JButton("Back");
		back.setBounds(150,220,80,25);
		back.setBackground(Color.GRAY);
		back.setForeground(Color.WHITE);
		back.setBorder(new LineBorder(Color.WHITE));
		back.addActionListener(this);
		p1.add(back);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == search) {
			try {
				String query = "select * from account where username = '"+tusername.getText()+"'";
				Conn con = new Conn();
				
				ResultSet rs = con.stat.executeQuery(query);
				while(rs.next()) {
					tname.setText(rs.getString("name"));
					tquestion.setText(rs.getString("security"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == retrieve) {
			try {
				String query = "select * from account where answer = '"+tanswer.getText()+"' AND username = '"+ tusername.getText()+"'";
				Conn con = new Conn();
				
				ResultSet rs = con.stat.executeQuery(query);
				while(rs.next()) {
					tpassword.setText(rs.getString("password"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] args) {
		new ForgetPassword();

	}

}
