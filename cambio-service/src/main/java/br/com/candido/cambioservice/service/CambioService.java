package br.com.candido.cambioservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.candido.cambioservice.model.Cambio;
import br.com.candido.cambioservice.repository.CambioRepository;

@Service
public class CambioService {

    @Autowired
    private CambioRepository cambioRepository;
    
    @Autowired
    private Environment environment;
    
    private Logger logger = LoggerFactory.getLogger(CambioService.class);

    public Cambio createConvertedCambio(String from, String to, Double amount) {
	Cambio cambio = cambioRepository.findByFromAndTo(from, to);

	Double conversionFactor = cambio.getConversionFactor();
	Double convertedValue = conversionFactor * amount;
	
	cambio.setEnviroment(catchEnviroment());
	cambio.setConvertedValue(convertedValue);
	
	
	logger.info("createConvertedCambio -> {}, {}, {}", amount, from, to);
	return cambio;
    }
    
    private String catchEnviroment() {
	return environment.getProperty("local.server.port");
    }

}
