package TravelManagementSystem;

import java.awt.*;

import javax.swing.*;

public class Loading extends JFrame implements Runnable{

	Thread t;
	JProgressBar bar;
	String username;
	
	public void run() {
		try {
			for(int i = 1; i <= 101; i++) {
				int max = bar.getMaximum();
				int value = bar.getValue();
				
				if(value < max) {
					bar.setValue(bar.getValue() + 1);
				}else {
					setVisible(false);
				}
				Thread.sleep(50);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Loading(String username){
		this.username = username;
		t = new Thread(this);
		
		setBounds(450, 200, 600, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setTitle("Loading");
		
		JLabel text = new JLabel("Travel and Tourism Application");
		text.setBounds(60, 20, 500, 40);
		text.setForeground(Color.BLUE);
		text.setFont(new Font("Raleway", Font.BOLD, 30));
		add(text);
		
		bar = new JProgressBar();
		bar.setBounds(140, 80, 300, 35);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel loading = new JLabel("Loading, please wait...");
		loading.setBounds(200, 110, 450, 40);
		loading.setForeground(Color.RED);
		loading.setFont(new Font("Raleway", Font.BOLD, 16));
		add(loading);
		
		JLabel lusername = new JLabel("Welcome " + username);
		lusername.setBounds(20, 360, 400, 40);
		lusername.setForeground(Color.RED);
		lusername.setFont(new Font("Raleway", Font.BOLD, 16));
		add(lusername);
		
		t.start();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Loading("");
	}

}
