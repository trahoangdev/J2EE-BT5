package com.example.demo;

import com.example.demo.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookService bookService;
    private static final String LOG_PATH = "c:\\CODE PROJECT 3\\JAVA\\.cursor\\debug.log";

    public DataInitializer(BookService bookService) {
        // #region agent log
        try {
            FileWriter fw = new FileWriter(LOG_PATH, true);
            fw.write("{\"sessionId\":\"debug-session\",\"runId\":\"run1\",\"hypothesisId\":\"B\",\"location\":\"DataInitializer.java:15\",\"message\":\"Constructor called\",\"data\":{\"bookServiceNull\":\"" + (bookService == null) + "\"},\"timestamp\":" + Instant.now().toEpochMilli() + "}\n");
            fw.close();
        } catch (IOException e) {}
        // #endregion
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        // #region agent log
        try {
            FileWriter fw = new FileWriter(LOG_PATH, true);
            fw.write("{\"sessionId\":\"debug-session\",\"runId\":\"run1\",\"hypothesisId\":\"A\",\"location\":\"DataInitializer.java:25\",\"message\":\"run() method entry\",\"data\":{\"argsLength\":" + args.length + "},\"timestamp\":" + Instant.now().toEpochMilli() + "}\n");
            fw.close();
        } catch (IOException e) {}
        // #endregion
        
        // #region agent log
        try {
            FileWriter fw = new FileWriter(LOG_PATH, true);
            fw.write("{\"sessionId\":\"debug-session\",\"runId\":\"run1\",\"hypothesisId\":\"B\",\"location\":\"DataInitializer.java:30\",\"message\":\"Before getAllBooks call\",\"data\":{\"bookServiceNull\":\"" + (bookService == null) + "\"},\"timestamp\":" + Instant.now().toEpochMilli() + "}\n");
            fw.close();
        } catch (IOException e) {}
        // #endregion
        
        // Clear existing data
        // Optional: Thêm thêm dữ liệu nếu cần
        System.out.println("========================================");
        System.out.println("Mock Data Loaded Successfully!");
        
        // #region agent log
        java.util.List<com.example.demo.model.Book> booksList = null;
        int booksSize = -1;
        Exception getAllBooksException = null;
        try {
            booksList = bookService.getAllBooks();
            booksSize = booksList != null ? booksList.size() : -999;
        } catch (Exception e) {
            getAllBooksException = e;
            try {
                FileWriter fw = new FileWriter(LOG_PATH, true);
                fw.write("{\"sessionId\":\"debug-session\",\"runId\":\"run1\",\"hypothesisId\":\"C\",\"location\":\"DataInitializer.java:42\",\"message\":\"Exception in getAllBooks\",\"data\":{\"exceptionType\":\"" + e.getClass().getName() + "\",\"exceptionMessage\":\"" + e.getMessage().replace("\"", "\\\"") + "\"},\"timestamp\":" + Instant.now().toEpochMilli() + "}\n");
                fw.close();
            } catch (IOException ioEx) {}
        }
        // #endregion
        
        // #region agent log
        try {
            FileWriter fw = new FileWriter(LOG_PATH, true);
            fw.write("{\"sessionId\":\"debug-session\",\"runId\":\"run1\",\"hypothesisId\":\"C\",\"location\":\"DataInitializer.java:50\",\"message\":\"After getAllBooks call\",\"data\":{\"booksListNull\":\"" + (booksList == null) + "\",\"booksSize\":" + booksSize + "},\"timestamp\":" + Instant.now().toEpochMilli() + "}\n");
            fw.close();
        } catch (IOException e) {}
        // #endregion
        
        System.out.println("Total Books: " + bookService.getAllBooks().size());
        System.out.println("========================================");
        
        // #region agent log
        try {
            FileWriter fw = new FileWriter(LOG_PATH, true);
            fw.write("{\"sessionId\":\"debug-session\",\"runId\":\"run1\",\"hypothesisId\":\"A\",\"location\":\"DataInitializer.java:58\",\"message\":\"run() method exit\",\"data\":{},\"timestamp\":" + Instant.now().toEpochMilli() + "}\n");
            fw.close();
        } catch (IOException e) {}
        // #endregion
    }
}
