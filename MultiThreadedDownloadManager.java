package com.downloadmanager;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class MultiThreadedDownloadManager {
    private static final int THREAD_POOL_SIZE = 5; // Number of simultaneous downloads

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        
        // Example file URLs to download
        String[] fileUrls = {
            "https://pagalworldmusic.com/downloads/high/KTsDQBcFfVE/KTsDQBcFfVE.mp3",
            "https://pagalworldmusic.com/downloads/medium/KTsDQBcFfVE/KTsDQBcFfVE.mp3",
            "https://pagalworldmusic.com/downloads/low/KTsDQBcFfVE/KTsDQBcFfVE.mp3"
        };
        
        for (String url : fileUrls) {
            executor.execute(new FileDownloader(url));
        }
        
        executor.shutdown();
    }
}

class FileDownloader implements Runnable {
    private String fileUrl;

    public FileDownloader(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(fileUrl);
            String fileName = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream(fileName)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
                System.out.println("Downloaded: " + fileName);
            }
        } catch (IOException e) {
            System.err.println("Error downloading " + fileUrl + ": " + e.getMessage());
        }
    }
}