package com.luvina.bth.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import com.luvina.bth.logic.DownloadFile2;

public class DownloadPanel extends JPanel {
	private JLabel pathLabel;
	private JLabel savedLabel;
	private JTextField pathTextField;
	private JTextField savedTextField;
	private JProgressBar progress;
	private JButton downloadButton;

	public DownloadPanel() {
		initGUI();
		addComps();
	}

	private void initGUI() {
		setBackground(Color.GRAY);
		setLayout(null);

	}

	private void addComps() {
		pathLabel = createLabel("Path:", 20, 30, 80, 30);
		savedLabel = createLabel("Saved:", 20, 80, 80, 30);

		pathTextField = createTextField(80, 30, 400, 30);
		savedTextField = createTextField(80, 80, 400, 30);

		progress = new JProgressBar();
		progress.setBounds(80, 130, 300, 30);
		progress.setStringPainted(true);

		progress.setForeground(Color.GREEN);
		progress.setMinimum(0);
//		progress.setMaximum(100);

		downloadButton = new JButton("Download");
		downloadButton.setBounds(385, 130, 95, 30);
		downloadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				progress.setValue(progress.getValue() + 10);
				String pathDownload = pathTextField.getText();
				String pathSave = savedTextField.getText();
				if (pathDownload != null && !pathDownload.isEmpty() && pathSave != null && !pathSave.isEmpty()) {
					/*
					 * DownloadFile download = new DownloadFile(); boolean result =
					 * download.downloadFile(pathDownload, pathSaved); if (result) {
					 * progress.setValue(progress.getMaximum()); }
					 */
					DownloadFile2 download = new DownloadFile2(pathDownload, pathSave, progress);
					try {
						download.start();
						download.join();
						JOptionPane.showMessageDialog(DownloadPanel.this, "Download completed");
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
//					updatePercent(download.getSavePath(), download.getFileSize());
				} else {
					JOptionPane.showMessageDialog(DownloadPanel.this, "Kiểm tra lại đường dẫn");
					return;
				}
			}
		});

		add(pathLabel);
		add(pathTextField);
		add(savedLabel);
		add(savedTextField);
		add(progress);
		add(downloadButton);

	}

	public JLabel createLabel(String name, int x, int y, int width, int height) {
		JLabel label = new JLabel(name);
		label.setBounds(x, y, width, height);
		return label;
	}

	public JTextField createTextField(int x, int y, int width, int height) {
		JTextField tf = new JTextField();
		tf.setBounds(x, y, width, height);
		return tf;
	}

	protected void updatePercent(String pathSave, int size) {
		try {
			File file = new File(pathSave);
			System.out.println(file.length());
			long fileSize = file.length();
			int percent = (int) (fileSize / size);
			progress.setValue(percent*100);
		} catch (ArithmeticException e) {
			System.err.println(e.getMessage());
		}
	}

//	protected void download() {
//		DownloadFile2 downloadFile = new DownloadFile2();
//		downloadFile.start();
//	}

}
