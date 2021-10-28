package br.com.candido.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.candido.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
