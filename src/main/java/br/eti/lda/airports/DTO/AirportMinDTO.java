/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.lda.airports.DTO;

import br.eti.lda.airports.entities.Airport;
import br.eti.lda.airports.repositories.AirportRepository;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class AirportMinDTO {
 

    private long id;
    private String name;
    private String city;
    private String iataCode;

    public AirportMinDTO() {
    }

    public AirportMinDTO(Airport airport) {
        this.id = airport.getId();
        this.name = airport.getName();
        this.city = airport.getCity();
        this.iataCode = airport.getIataCode();
    }
   
}



   
