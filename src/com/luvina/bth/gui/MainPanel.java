package com.luvina.bth.gui;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;


public class MainPanel extends JPanel{
	public MainPanel() {
		initPanel();
		addComps();
	}

	private void addComps() {
//		PasswordPanel passwordPanel = new PasswordPanel();
//		add(passwordPanel);
//		ProgressBarEx progressBar = new ProgressBarEx();
//		add(progressBar);
//		CheckBoxEx  checkBox = new CheckBoxEx();
//		add(checkBox);
		
//		JListEx jlist = new JListEx();
//		add(jlist);
		
		DownloadPanel downloadPanel = new DownloadPanel();
		add(downloadPanel);
	}

	private void initPanel() {
		setBackground(Color.WHITE);
		setLayout(new CardLayout());
		
	}
}
