package TravelManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
	
	JLabel lbusername, lid, labelname;
	JComboBox comboid;
	JTextField tnumber;
	
	AddCustomer() {
		
		setBounds(500, 200, 800, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Add Customer");
		
		JLabel username = new JLabel("Username:");
		username.setBounds(30, 50, 200, 25);
		username.setFont(new Font("Raleway", Font.BOLD, 20));
		username.setForeground(Color.BLACK);
		add(username);
		
		lbusername = new JLabel();
		lbusername.setBounds(220, 50, 100, 25);
		lbusername.setFont(new Font("Raleway", Font.BOLD, 20));
		lbusername.setForeground(Color.BLACK);
		add(lbusername);
		
		lid = new JLabel("Id:");
		lid.setBounds(30, 90, 100, 25);
		lid.setFont(new Font("Raleway", Font.BOLD, 20));
		lid.setForeground(Color.BLACK);
		add(lid);
		
		String[] choice = {"Passport", "Aadhar Card", "PAN Card", "Driver's License"};
		comboid = new JComboBox(choice);
		comboid.setBounds(220, 90, 100, 25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		JLabel number = new JLabel("Number:");
		number.setBounds(30, 130, 100, 25);
		number.setFont(new Font("Raleway", Font.BOLD, 20));
		number.setForeground(Color.BLACK);
		add(number);
		
		tnumber = new JTextField();
		tnumber.setBounds(220, 130, 100, 25);
		add(tnumber);
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(30, 170, 100, 25);
		lbname.setFont(new Font("Raleway", Font.BOLD, 20));
		lbname.setForeground(Color.BLACK);
		add(lbname);
		
		labelname = new JLabel();
		labelname.setBounds(220, 170, 100, 25);
		labelname.setFont(new Font("Raleway", Font.BOLD, 20));
		labelname.setForeground(Color.BLACK);
		add(labelname);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== comboid) {
			
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer();

	}

}
