package TravelManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener{
	
	JLabel vusername, vid, vnumber, vname, vgender, vcountry, vaddress, vphone, vemail;
	JLabel viewusername, viewid, viewnumber, viewname, viewgender, viewcountry, viewaddress, viewphone, viewemail;
	JButton back;
	
	ViewCustomer(String username){
		
		setTitle("View Customer");
		
		setBounds(400, 200, 800, 600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		vusername = new JLabel("Username:");
		vusername.setBounds(30, 30, 100, 20);
		vusername.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vusername);
		viewusername = new JLabel();
		viewusername.setBounds(200, 30, 100, 20);
		viewusername.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewusername);
		
		vid = new JLabel("Id:");
		vid.setBounds(30, 90, 100, 20);
		vid.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vid);
		viewid = new JLabel();
		viewid.setBounds(200, 90, 100, 20);
		viewid.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewid);
		
		vnumber = new JLabel("Credential:");
		vnumber.setBounds(30, 150, 100, 20);
		vnumber.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vnumber);
		viewnumber = new JLabel();
		viewnumber.setBounds(200, 150, 100, 20);
		viewnumber.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewnumber);
		
		vname = new JLabel("Name:");
		vname.setBounds(30, 210, 100, 20);
		vname.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vname);
		viewname = new JLabel();
		viewname.setBounds(200, 210, 100, 20);
		viewname.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewname);
		
		vgender = new JLabel("Gender:");
		vgender.setBounds(30, 270, 100, 20);
		vgender.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vgender);
		viewgender = new JLabel();
		viewgender.setBounds(200, 270, 100, 20);
		viewgender.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewgender);
		
		vcountry = new JLabel("Country:");
		vcountry.setBounds(370, 30, 100, 20);
		vcountry.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vcountry);
		viewcountry = new JLabel();
		viewcountry.setBounds(540, 30, 100, 20);
		viewcountry.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewcountry);
		
		vaddress = new JLabel("Address:");
		vaddress.setBounds(370, 90, 100, 20);
		vaddress.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vaddress);
		viewaddress = new JLabel();
		viewaddress.setBounds(540, 90, 250, 20);
		viewaddress.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewaddress);
		
		vphone = new JLabel("Phone:");
		vphone.setBounds(370, 150, 100, 20);
		vphone.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vphone);
		viewphone= new JLabel();
		viewphone.setBounds(540, 150, 100, 20);
		viewphone.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewphone);
		
		vemail = new JLabel("Email:");
		vemail.setBounds(370, 210, 100, 20);
		vemail.setFont(new Font("Raleway", Font.BOLD, 16));
		add(vemail);
		viewemail= new JLabel();
		viewemail.setBounds(540, 210, 250, 20);
		viewemail.setFont(new Font("Raleway", Font.BOLD, 16));
		add(viewemail);
		
		back = new JButton("Back");
		back.setBounds(300, 350, 100, 20);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Raleway", Font.PLAIN, 16));
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(30, 350, 700, 300);
		add(image);
		
		try {
			Conn con = new Conn();
			String query = "select * from Customer where username = '"+username+"'";
			ResultSet rs = con.stat.executeQuery(query);
			while(rs.next()) {
				viewusername.setText(rs.getString("Username"));
				viewid.setText(rs.getString("Id"));
				viewnumber.setText(rs.getString("Credential"));
				viewname.setText(rs.getString("Name"));
				viewgender.setText(rs.getString("Gender"));
				viewcountry.setText(rs.getString("Country"));
				viewaddress.setText(rs.getString("Address"));
				viewphone.setText(rs.getString("PhoneNumber"));
				viewemail.setText(rs.getString("EMail"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		
		new ViewCustomer("rekt");
	}

}
