package com.luvina.bth.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class PasswordPanel extends JPanel {
	private JLabel passLabel;
	private JLabel displayLabel;
	private JPasswordField passField;
	private JTextField displayField;
	
	private JButton displayButton;
	private JButton nextButton;
	private JButton closeButton;
	
	public PasswordPanel() {
		initPanel();
		addComps();
	}

	private void addComps() {
		passLabel = new JLabel();
		passLabel.setText("Nhập Password:");
		passLabel.setBounds(30,20,150,30);
		passLabel.setForeground(Color.BLACK);
		passLabel.setFont(new Font("Aria",Font.BOLD,14));
		
		displayLabel = new JLabel();
		displayLabel.setText("Hiển thị:");
		displayLabel.setBounds(30,80,100,30);
		displayLabel.setForeground(Color.BLACK);
		displayLabel.setFont(new Font("Aria",Font.BOLD,14));
		
		passField = new JPasswordField();
		passField.setEchoChar('#');
		passField.setBounds(200,20,200,30);
		passField.setForeground(Color.BLACK);
		passField.setFont(new Font("Aria",Font.PLAIN,14));
		
		displayField = new JTextField();
		displayField.setBounds(200,80,200,30);
		displayField.setForeground(Color.BLACK);
		displayField.setFont(new Font("Aria",Font.PLAIN,14));
		
		displayButton = new JButton("Hiển thị");
		displayButton.setBounds(50,140,100,30);
		displayButton.setForeground(Color.BLACK);
		displayButton.setFont(new Font("Aria",Font.PLAIN,14));
		displayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String password = passField.getText();
				displayField.setText(password);
			}
		});
		
		nextButton = new JButton("Tiếp");
		nextButton.setBounds(200,140,100,30);
		nextButton.setForeground(Color.BLACK);
		nextButton.setFont(new Font("Aria",Font.PLAIN,14));
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				passField.setText("");
				displayField.setText("");
			}
		});
		
		closeButton = new JButton("Đóng");
		closeButton.setBounds(350,140,100,30);
		closeButton.setForeground(Color.BLACK);
		closeButton.setFont(new Font("Aria",Font.PLAIN,14));
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		}); 

		
		add(passLabel);
		add(displayLabel); 
		add(passField);
		add(displayField);
		add(displayButton);
		add(nextButton);
		add(closeButton);
		
	}

	private void initPanel() {
		setBackground(Color.GRAY);
		setLayout(null);
		
		
		
	}
}
