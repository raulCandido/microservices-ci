package br.com.candido.cambioservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.candido.cambioservice.model.Cambio;
import br.com.candido.cambioservice.service.CambioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cambio Endpoint")
@RestController
@RequestMapping("cambio-service")
public class CambioController {
    
   
    @Autowired
    private CambioService cambioService;
    
    
    @Operation(description = "Convert currency")
    @GetMapping("/{amount}/{fromCurrency}/{toCurrency}")
    public Cambio getCambio(@PathVariable("amount") Double amount,
	    @PathVariable("fromCurrency") String fromCurrency, @PathVariable("toCurrency") String toCurrency) {
	return cambioService.createConvertedCambio(fromCurrency, toCurrency, amount);
    }
}
