package br.com.candido.cambioservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "cambio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;
    
    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;
    
    @Column(nullable = false)
    private Double conversionFactor;
    
    @Transient
    private Double convertedValue;
    
    @Transient
    private String enviroment;

    public Cambio(String from, String to, String enviroment) {
	super();
	this.from = from;
	this.to = to;
	this.enviroment = enviroment;
    }
    
    
}
