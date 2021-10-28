package br.com.candido.bookservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.candido.bookservice.model.dto.CambioDTO;

@FeignClient("cambio-service")
public interface CambioClient {

    @GetMapping("cambio-service/{amount}/{fromCurrency}/{toCurrency}")
    CambioDTO getCambio(@PathVariable Double amount, @PathVariable String fromCurrency,
	    @PathVariable String toCurrency);
}
