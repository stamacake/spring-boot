package com.stamacake.springdata.controllers;


import com.stamacake.springdata.entities.Book;
import com.stamacake.springdata.entities.Genre;
import com.stamacake.springdata.services.BookService;
import com.stamacake.springdata.utils.BookFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping
    public String showAllBooks(Model model,
                               @RequestParam(name = "page", defaultValue = "1") Integer pageIndex,
                               @RequestParam(defaultValue = "") String fantasy,
                               @RequestParam(defaultValue = "") String fantastic,
                               @RequestParam(defaultValue = "") String mystery,
                               @RequestParam(defaultValue = "0") Integer minPrice,
                               @RequestParam(defaultValue = "50000") Integer maxPrice,
                               @RequestParam(defaultValue = "") String titlePart,
                               @RequestParam Map<String, String> params
    ) {

        BookFilter bookFilter = new BookFilter(params);
        Page<Book> page = bookService.findAll(bookFilter.getSpec(), pageIndex - 1, 3);

        model.addAttribute("books", page);
        model.addAttribute("gs", Genre.values());
        model.addAttribute("fantasy", fantasy);
        model.addAttribute("fantastic", fantastic);
        model.addAttribute("mystery", mystery);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("titlePart", titlePart);
        model.addAttribute("pam",params);


        System.out.println(params);
        return "store-page";
    }

    // Эта часть кода будет сильно скорректирована после темы Spring REST
    @GetMapping("/rest")
    @ResponseBody
    @CrossOrigin("*")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
}
