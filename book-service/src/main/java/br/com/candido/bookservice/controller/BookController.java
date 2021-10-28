package br.com.candido.bookservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.candido.bookservice.model.Book;
import br.com.candido.bookservice.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(description = "Find a specific book by your ID")
    @GetMapping("{id}/{currency}")
    public Book getBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
	return bookService.searchBook(id, currency);
    }

}
