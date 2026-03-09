package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookService bookService;
    private final CategoryRepository categoryRepository;

    public DataInitializer(BookService bookService, CategoryRepository categoryRepository) {
        this.bookService = bookService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Khởi tạo danh mục nếu chưa có
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category("Điện tử"));
            categoryRepository.save(new Category("Thời trang"));
            categoryRepository.save(new Category("Thực phẩm"));
            categoryRepository.save(new Category("Đồ gia dụng"));
            categoryRepository.save(new Category("Sách & Văn phòng phẩm"));
            System.out.println(">> Đã thêm 5 danh mục mẫu.");
        }

        System.out.println("========================================");
        System.out.println("Total Books: " + bookService.getAllBooks().size());
        System.out.println("Total Categories: " + categoryRepository.count());
        System.out.println("Mock Data Loaded Successfully!");
        System.out.println("========================================");
    }
}
