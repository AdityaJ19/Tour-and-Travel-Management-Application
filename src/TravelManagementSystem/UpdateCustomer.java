package TravelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class UpdateCustomer extends JFrame implements ActionListener{
	
	JLabel lbusername, lid, labelname;
	JComboBox comboid;
	JTextField tnumber, tcountry, taddress, temail, tphonenumber, tid, tgender;
	JRadioButton jmale, jfemale, jother;
	JButton badd, back;
	
	UpdateCustomer(String username) {
		
		setBounds(450, 200, 800, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Update Customer Details");
		
		JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
		text.setBounds(50, 0, 300, 25);
		text.setFont(new Font("Taboma", Font.PLAIN, 20));
		add(text);
		
		JLabel jusername = new JLabel("Username:");
		jusername.setBounds(30, 30, 200, 25);
		jusername.setFont(new Font("Raleway", Font.BOLD, 14));
		jusername.setForeground(Color.BLACK);
		add(jusername);
		lbusername = new JLabel();
		lbusername.setBounds(220, 30, 100, 25);
		lbusername.setFont(new Font("Raleway", Font.BOLD, 14));
		lbusername.setForeground(Color.BLACK);
		add(lbusername);
		
		lid = new JLabel("Id:");
		lid.setBounds(30, 70, 100, 25);
		lid.setFont(new Font("Raleway", Font.BOLD, 14));
		lid.setForeground(Color.BLACK);
		add(lid);
		tid = new JTextField();
		tid.setBounds(220, 70, 150, 25);
		add(tid);
		
		JLabel number = new JLabel("Credentials:");
		number.setBounds(30, 110, 150, 25);
		number.setFont(new Font("Raleway", Font.BOLD, 14));
		number.setForeground(Color.BLACK);
		add(number);
		
		tnumber = new JTextField();
		tnumber.setBounds(220, 110, 150, 25);
		add(tnumber);
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(30, 150, 100, 25);
		lbname.setFont(new Font("Raleway", Font.BOLD, 14));
		lbname.setForeground(Color.BLACK);
		add(lbname);
		
		labelname = new JLabel();
		labelname.setBounds(220, 150, 100, 25);
		labelname.setFont(new Font("Raleway", Font.BOLD, 14));
		labelname.setForeground(Color.BLACK);
		add(labelname);
		
		JLabel lgender = new JLabel("Gender:");
		lgender.setBounds(30, 190, 100, 25);
		lgender.setFont(new Font("Raleway", Font.BOLD, 14));
		lgender.setForeground(Color.BLACK);
		add(lgender);
		tgender = new JTextField();
		tgender.setBounds(220, 190, 150, 25);
		add(tgender);
	
		JLabel country = new JLabel("Country:");
		country.setBounds(30, 230, 100, 25);
		country.setFont(new Font("Raleway", Font.BOLD, 14));
		country.setForeground(Color.BLACK);
		add(country);
		
		tcountry = new JTextField();
		tcountry.setBounds(220, 230, 150, 25);
		add(tcountry);
		
		JLabel address = new JLabel("Address:");
		address.setBounds(30, 270, 100, 25);
		address.setFont(new Font("Raleway", Font.BOLD, 14));
		address.setForeground(Color.BLACK);
		add(address);
		
		taddress = new JTextField();
		taddress.setBounds(220, 270, 150, 25);
		add(taddress);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(30, 310, 100, 25);
		email.setFont(new Font("Raleway", Font.BOLD, 14));
		email.setForeground(Color.BLACK);
		add(email);
		
		temail = new JTextField();
		temail.setBounds(220, 310, 150, 25);
		add(temail);
		
		JLabel pnumber = new JLabel("Phone Number:");
		pnumber.setBounds(30, 350, 150, 25);
		pnumber.setFont(new Font("Raleway", Font.BOLD, 14));
		pnumber.setForeground(Color.BLACK);
		add(pnumber);
		
		tphonenumber = new JTextField();
		tphonenumber.setBounds(220, 350, 150, 25);
		add(tphonenumber);
		
		badd = new JButton("Update");
		badd.setBounds(60, 400, 100, 25);
		badd.setBackground(Color.GRAY);
		badd.setForeground(Color.BLACK);
		badd.setFont(new Font("Raleway", Font.BOLD, 14));
		badd.addActionListener(this);
		add(badd);
		
		back = new JButton("Back");
		back.setBounds(260, 400, 100, 25);
		back.setBackground(Color.GRAY);
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Raleway", Font.BOLD, 14));
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 40, 450, 400);
		add(image);
		
		try {
			Conn con = new Conn();
			ResultSet rs = con.stat.executeQuery("select * from Customer where username = '"+username+"'");
			while(rs.next()) {
				lbusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
				tid.setText(rs.getString("Id"));
				tnumber.setText(rs.getString("Credential"));
				tcountry.setText(rs.getString("Country"));
				taddress.setText(rs.getString("Address"));
				tphonenumber.setText(rs.getString("PhoneNumber"));
				temail.setText(rs.getString("EMail"));
				tgender.setText(rs.getString("Gender"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== badd) {
			String username = lbusername.getText();
			String id = tid.getText();
			String number = tnumber.getText();
			String name = labelname.getText();
			String gender = tgender.getText();
			String country = tcountry.getText();
			String address = taddress.getText();
			String phone = tphonenumber.getText();
			String email = temail.getText();
			
			try {
				Conn con = new Conn();
				String query = "update  Customer set Username = '"+username+"', Id = '"+id+"', Credential = '"+number+"', Name = '"+name+"', Gender = '"+gender+"', Country = '"+country+"', Address = '"+address+"', PhoneNumber = '"+phone+"', EMail = '"+email+"'";
				con.stat.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new UpdateCustomer("rekt");

	}

}
