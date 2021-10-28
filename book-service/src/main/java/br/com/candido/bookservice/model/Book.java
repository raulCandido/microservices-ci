package br.com.candido.bookservice.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date launchDate;
    
    @Column(name = "author", nullable = false)
    private String author;
    
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Transient
    private String currency;
    
    @Transient
    private String enviroment;
}
