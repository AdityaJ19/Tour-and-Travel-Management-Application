package TravelManagementSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class DashBoard extends JFrame implements ActionListener{
	
	JButton psDetails, updDetails, vpDetails, dsDetails, vpakages, bpakages, cpakages, vhotels, bhotel,
			vbhotel, dlocation, payment, calculate, notepad, about;
	String username;
	
	DashBoard(String username) {
		
		this.username = username;
		//setBounds(200, 100, 1200, 700);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		setTitle("DashBoard");
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(0,0,102));
		p1.setBounds(0,0,1900,60);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel icon = new JLabel(i3);
		icon.setBounds(5,0,70,70);
		p1.add(icon);
		
		JLabel heading  = new JLabel("DashBoard");
		heading.setBounds(80, 10, 300, 40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Taboma", Font.BOLD, 30));
		p1.add(heading);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(0,0,102));
		p2.setBounds(0,60,300,800);
		add(p2);
		
		psDetails = new JButton("Add Personal Details");
		psDetails.setBounds(0,0,300,50);
		psDetails.setBackground(new Color(0,0,102));
		psDetails.setForeground(Color.WHITE);
		psDetails.setFont(new Font("Tobama", Font.BOLD, 20));
		psDetails.setMargin(new Insets(0, 0, 0, 60));
		psDetails.addActionListener(this);
		p2.add(psDetails);
		
		updDetails = new JButton("Update Personal Details");
		updDetails.setBounds(0,50,300,50);
		updDetails.setBackground(new Color(0,0,102));
		updDetails.setForeground(Color.WHITE);
		updDetails.setFont(new Font("Tobama", Font.BOLD, 20));
		updDetails.setMargin(new Insets(0, 0, 0, 30));
		p2.add(updDetails);
		
		vpDetails = new JButton("View Details");
		vpDetails.setBounds(0,100,300,50);
		vpDetails.setBackground(new Color(0,0,102));
		vpDetails.setForeground(Color.WHITE);
		vpDetails.setFont(new Font("Tobama", Font.BOLD, 20));
		vpDetails.setMargin(new Insets(0, 0, 0, 140));
		p2.add(vpDetails);
		
		dsDetails = new JButton("Delete Personal Details");
		dsDetails.setBounds(0,150,300,50);
		dsDetails.setBackground(new Color(0,0,102));
		dsDetails.setForeground(Color.WHITE);
		dsDetails.setFont(new Font("Tobama", Font.BOLD, 20));
		dsDetails.setMargin(new Insets(0, 0, 0, 40));
		p2.add(dsDetails);
		
		cpakages = new JButton("Check Pakage");
		cpakages.setBounds(0,200,300,50);
		cpakages.setBackground(new Color(0,0,102));
		cpakages.setForeground(Color.WHITE);
		cpakages.setFont(new Font("Tobama", Font.BOLD, 20));
		cpakages.setMargin(new Insets(0, 0, 0, 120));
		p2.add(cpakages);
		
		bpakages = new JButton("Book Pakage");
		bpakages.setBounds(0,250,300,50);
		bpakages.setBackground(new Color(0,0,102));
		bpakages.setForeground(Color.WHITE);
		bpakages.setFont(new Font("Tobama", Font.BOLD, 20));
		bpakages.setMargin(new Insets(0, 0, 0, 130));
		p2.add(bpakages);
		
		vhotels = new JButton("View Hotels");
		vhotels.setBounds(0,300,300,50);
		vhotels.setBackground(new Color(0,0,102));
		vhotels.setForeground(Color.WHITE);
		vhotels.setFont(new Font("Tobama", Font.BOLD, 20));
		vhotels.setMargin(new Insets(0, 0, 0, 140));
		p2.add(vhotels);
		
		bhotel = new JButton("Book Hotel");
		bhotel.setBounds(0,350,300,50);
		bhotel.setBackground(new Color(0,0,102));
		bhotel.setForeground(Color.WHITE);
		bhotel.setFont(new Font("Tobama", Font.BOLD, 20));
		bhotel.setMargin(new Insets(0, 0, 0, 150));
		p2.add(bhotel);
		
		vbhotel = new JButton("View Booked Hotel");
		vbhotel.setBounds(0,400,300,50);
		vbhotel.setBackground(new Color(0,0,102));
		vbhotel.setForeground(Color.WHITE);
		vbhotel.setFont(new Font("Tobama", Font.BOLD, 20));
		vbhotel.setMargin(new Insets(0, 0, 0, 75));
		p2.add(vbhotel);
		
		dlocation = new JButton("View Destinations");
		dlocation.setBounds(0,450,300,50);
		dlocation.setBackground(new Color(0,0,102));
		dlocation.setForeground(Color.WHITE);
		dlocation.setFont(new Font("Tobama", Font.BOLD, 20));
		dlocation.setMargin(new Insets(0, 0, 0, 80));
		p2.add(dlocation);
		
		payment = new JButton("Payment");
		payment.setBounds(0,500,300,50);
		payment.setBackground(new Color(0,0,102));
		payment.setForeground(Color.WHITE);
		payment.setFont(new Font("Tobama", Font.BOLD, 20));
		payment.setMargin(new Insets(0, 0, 0, 165));
		p2.add(payment);
		
		calculate = new JButton("Calculator");
		calculate.setBounds(0,550,300,50);
		calculate.setBackground(new Color(0,0,102));
		calculate.setForeground(Color.WHITE);
		calculate.setFont(new Font("Tobama", Font.BOLD, 20));
		calculate.setMargin(new Insets(0, 0, 0, 155));
		p2.add(calculate);
		
		notepad = new JButton("Notepad");
		notepad.setBounds(0,600,300,50);
		notepad.setBackground(new Color(0,0,102));
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tobama", Font.BOLD, 20));
		notepad.setMargin(new Insets(0, 0, 0, 175));
		p2.add(notepad);
		
		about = new JButton("About");
		about.setBounds(0,650,300,50);
		about.setBackground(new Color(0,0,102));
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tobama", Font.BOLD, 20));
		about.setMargin(new Insets(0, 0, 0, 195));
		p2.add(about);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image = new JLabel(i6);
		image.setBounds(0, 0, 1650, 1000);
		add(image);
		
		JLabel text = new JLabel("Travel and Tourism Management System");
		text.setBounds(400, 70, 1200, 70);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Raleway", Font.PLAIN, 55));
		image.add(text);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == psDetails) {
			new AddCustomer(username);
		}
	}

	public static void main(String[] args) {
		new DashBoard("");

	}

}
