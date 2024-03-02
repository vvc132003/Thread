package org.chinh.thread;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class DownloadThread extends Thread {
    private String url;
    private String destination;

    public DownloadThread(String url, String destination) {
        this.url = url;
        this.destination = destination;
    }

    @Override
    public void run() {
        try {
            URL downloadUrl = new URL(url);
            InputStream inputStream = downloadUrl.openStream();
            FileOutputStream outputStream = new FileOutputStream(destination);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("File downloaded to: " + destination);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
