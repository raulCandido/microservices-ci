package br.com.candido.bookservice.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CambioDTO {

    private Long id;

    private String from;

    private String to;

    private Double conversionFactor;

    private BigDecimal convertedValue;

    private String enviroment;
}
