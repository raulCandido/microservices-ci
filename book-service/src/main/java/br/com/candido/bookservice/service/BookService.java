package br.com.candido.bookservice.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.candido.bookservice.client.CambioClient;
import br.com.candido.bookservice.model.Book;
import br.com.candido.bookservice.model.dto.CambioDTO;
import br.com.candido.bookservice.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private Environment environment;

    @Autowired
    private CambioClient cambioClient;
    
    private static final int TO_ROUND = 3;

    public Book newBooke(Long id, String currency) {
	return Book.builder().id(id).author("Raul Candido").launchDate(new Date()).price(new BigDecimal(10))
		.title("Como virar programador senior").currency(currency).enviroment("8100").build();
    }

    public Book searchBook(Long id, String currency) {
	Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("nada encontrado"));

	CambioDTO cambio = cambioClient.getCambio(book.getPrice().doubleValue(), "USD", currency);

	book.setCurrency(currency);
	book.setPrice(cambio.getConvertedValue().setScale(TO_ROUND, RoundingMode.CEILING));
	book.setEnviroment(environment.getProperty("local.server.port"));

	return book;
    }

}
