package com.luvina.bth.logic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JProgressBar;

public class DownloadFile2 extends Thread {

	private String link, savePath;

	private int fileSize;

	private JProgressBar progress;

	public DownloadFile2(String link, String savePath, JProgressBar progress) {
		this.link = link;
		this.savePath = savePath;
		this.progress = progress;
	}

	@Override
	public void run() {
		// Đọc file từ Internet về
		try {
			URLConnection conn = new URL(link).openConnection();
			InputStream in = conn.getInputStream();
			// Tạo folder
			new File(savePath).mkdirs();
			String fileName = link.substring(link.lastIndexOf("/"));
			savePath += "\\" + fileName;

			// lấy kích thước file
			fileSize = conn.getContentLength();
			progress.setMaximum(fileSize);
			writeFile(savePath, in, progress);
			System.out.println(fileSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.run();
	}

	// write file
	public void writeFile(String path, InputStream in, JProgressBar progress) {
		try {
			File file = new File(path);
			File parentFile = file.getParentFile();
			if (!file.exists()) {
				parentFile.mkdirs();
				boolean result = file.createNewFile();
				if (result) {
					System.out.println("The file was created successfully");
				} else {
					System.out.println("Failed to create file");
					return;
				}
			}
			FileOutputStream out = new FileOutputStream(file, true);
//			byte[] dt = in.readAllBytes();

			byte[] buff = new byte[1024];
			int length;
			while ((length = in.read(buff)) > 0) {
				out.write(buff, 0, length);
				int value = (int) file.length();
				progress.setValue(value);
				System.out.println(length);
			}
			System.out.println(file.length());
			out.close();
		} catch (IOException | ArithmeticException e) {
			e.printStackTrace();

		}
	}

}
