# MultiThreadDownloader

## Overview
This is a multi-threaded download manager implemented in Java. It allows downloading multiple files simultaneously using Java threads. The program utilizes the ExecutorService to manage concurrent downloads efficiently.

## Features
- Supports simultaneous file downloads
- Uses a fixed thread pool for efficient resource management
- Handles HTTP errors and redirects
- Displays download progress and status

## Prerequisites
- Java Development Kit (JDK) 8 or later
- Eclipse IDE (or any Java-supported IDE)
- Stable internet connection

## Installation Steps:
- Clone the repository or download the project files:

```
git clone https://github.com/your-repository/multi-threaded-download-manager.git
```

- Open Eclipse and create a new Java project.
- Copy the Java files (MultiThreadedDownloadManager.java, FileDownloader.java) into the src folder.
- Ensure your project uses JDK 8 or later.

## Usage Steps:

- Modify the URL list in the MultiThreadedDownloadManager.java file:

String[] fileUrls = {
    "http://ipv4.download.thinkbroadband.com/5MB.zip",
    "http://ipv4.download.thinkbroadband.com/10MB.zip",
    "http://ipv4.download.thinkbroadband.com/20MB.zip"
};

- Run the program from Eclipse or using the terminal:
```
java MultiThreadedDownloadManager
```
- The downloaded files will be saved in the project directory.

## Handling Dynamic Links Steps:

### If you need to download files from dynamically generated links (e.g., requiring authentication, cookies, or headers), modify the FileDownloader class to include:

- Custom Headers (e.g., User-Agent, Referer)
- Session Cookies
- Parsing redirect URLs
- Troubleshooting
- Common Issues & Fixes:
- Download Fails? Ensure the URLs are correct and accessible.
- Slow Speed? Reduce THREAD_POOL_SIZE if your network is limited.
- Permission Issues? Run the program with proper write permissions.

## License

This project is licensed under the MIT License. Feel free to modify and distribute it!

