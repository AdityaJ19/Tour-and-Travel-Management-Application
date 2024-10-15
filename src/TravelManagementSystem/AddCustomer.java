package TravelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
	
	JLabel lbusername, lid, labelname;
	JComboBox comboid;
	JTextField tnumber, tcountry, taddress, temail, tphonenumber;
	JRadioButton jmale, jfemale, jother;
	JButton badd, back;
	
	AddCustomer(String username) {
		
		setBounds(500, 200, 800, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Add Customer");
		
		JLabel jusername = new JLabel("Username:");
		jusername.setBounds(30, 30, 200, 25);
		jusername.setFont(new Font("Raleway", Font.BOLD, 20));
		jusername.setForeground(Color.BLACK);
		add(jusername);
		
		lbusername = new JLabel();
		lbusername.setBounds(220, 30, 100, 25);
		lbusername.setFont(new Font("Raleway", Font.BOLD, 20));
		lbusername.setForeground(Color.BLACK);
		add(lbusername);
		
		lid = new JLabel("Id:");
		lid.setBounds(30, 70, 100, 25);
		lid.setFont(new Font("Raleway", Font.BOLD, 20));
		lid.setForeground(Color.BLACK);
		add(lid);
		
		String[] choice = {"Passport", "Aadhar Card", "PAN Card", "Driver's License"};
		comboid = new JComboBox(choice);
		comboid.setBounds(220, 70, 100, 25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		JLabel number = new JLabel("Credentials:");
		number.setBounds(30, 110, 150, 25);
		number.setFont(new Font("Raleway", Font.BOLD, 20));
		number.setForeground(Color.BLACK);
		add(number);
		
		tnumber = new JTextField();
		tnumber.setBounds(220, 110, 150, 25);
		add(tnumber);
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(30, 150, 100, 25);
		lbname.setFont(new Font("Raleway", Font.BOLD, 20));
		lbname.setForeground(Color.BLACK);
		add(lbname);
		
		labelname = new JLabel();
		labelname.setBounds(220, 150, 100, 25);
		labelname.setFont(new Font("Raleway", Font.BOLD, 20));
		labelname.setForeground(Color.BLACK);
		add(labelname);
		
		JLabel lgender = new JLabel("Gender:");
		lgender.setBounds(30, 190, 100, 25);
		lgender.setFont(new Font("Raleway", Font.BOLD, 20));
		lgender.setForeground(Color.BLACK);
		add(lgender);
		
		//Radio buttons can be used for more diversity
		jmale = new JRadioButton("Male");
		jmale.setBounds(220, 190, 80, 25);
		jmale.setBackground(Color.WHITE);
		jmale.setFont(new Font("Raleway", Font.BOLD, 16));
		jmale.setForeground(Color.BLACK);
		add(jmale);
		
		jfemale = new JRadioButton("Female");
		jfemale.setBounds(300, 190, 90, 25);
		jfemale.setBackground(Color.WHITE);
		jfemale.setFont(new Font("Raleway", Font.BOLD, 16));
		jfemale.setForeground(Color.BLACK);
		add(jfemale);
		
		jother = new JRadioButton("Other");
		jother.setBounds(400, 190, 100, 25);
		jother.setBackground(Color.WHITE);
		jother.setFont(new Font("Raleway", Font.BOLD, 16));
		jother.setForeground(Color.BLACK);
		add(jother);
		
		//for the grouping of the radio buttons so that we can only select one button at one time
		ButtonGroup bg = new  ButtonGroup();
		bg.add(jmale);
		bg.add(jfemale);
		bg.add(jother);
		
		JLabel country = new JLabel("Country:");
		country.setBounds(30, 230, 100, 25);
		country.setFont(new Font("Raleway", Font.BOLD, 20));
		country.setForeground(Color.BLACK);
		add(country);
		
		tcountry = new JTextField();
		tcountry.setBounds(220, 230, 150, 25);
		add(tcountry);
		
		JLabel address = new JLabel("Address:");
		address.setBounds(30, 270, 100, 25);
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setForeground(Color.BLACK);
		add(address);
		
		taddress = new JTextField();
		taddress.setBounds(220, 270, 150, 25);
		add(taddress);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(30, 310, 100, 25);
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setForeground(Color.BLACK);
		add(email);
		
		temail = new JTextField();
		temail.setBounds(220, 310, 150, 25);
		add(temail);
		
		JLabel pnumber = new JLabel("Phone Number:");
		pnumber.setBounds(30, 350, 150, 25);
		pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
		pnumber.setForeground(Color.BLACK);
		add(pnumber);
		
		tphonenumber = new JTextField();
		tphonenumber.setBounds(220, 350, 150, 25);
		add(tphonenumber);
		
		badd = new JButton("Add");
		badd.setBounds(60, 400, 100, 25);
		badd.setBackground(Color.GRAY);
		badd.setForeground(Color.BLACK);
		badd.setFont(new Font("Raleway", Font.BOLD, 20));
		badd.addActionListener(this);
		add(badd);
		
		back = new JButton("Back");
		back.setBounds(260, 400, 100, 25);
		back.setBackground(Color.GRAY);
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Raleway", Font.BOLD, 20));
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 40, 450, 400);
		add(image);
		
		try {
			Conn con = new Conn();
			ResultSet rs = con.stat.executeQuery("select * from account where username = 'rekt'");
			while(rs.next()) {
				lbusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== badd) {
			String username = lbusername.getText();
			String id = (String)comboid.getSelectedItem();
			String number = tnumber.getText();
			String name = labelname.getText();
			String gender = null;
			if(jmale.isSelected()) {
				gender = "Male";
			}else if(jfemale.isSelected()) {
				gender = "Female";
			}else {
				gender = "Other";
			}
			String country = tcountry.getText();
			String address = taddress.getText();
			String phone = tphonenumber.getText();
			String email = temail.getText();
			
			try {
				Conn con = new Conn();
				String query = "insert into Customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', "
						+ "'"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
				con.stat.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer("");

	}

}
