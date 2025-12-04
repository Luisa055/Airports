/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.lda.airports.controllers;

import br.eti.lda.airports.entities.Airport;
import br.eti.lda.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    /**
     * Endpoint: /airports/airport Retorna todos os aeroportos cadastrados na
     * base de dados.
     *
     * @return Lista de aeroportos
     */
    @GetMapping("/airport")
    public List<Airport> findAll() {
        return airportService.findAll();
    }

    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);

        if (result.isEmpty()) {

            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/coutry/{countryName}")
    public ResponseEntity<List<Airport>> findByCoutryIgnoreCase(@PathVariable String countryName) {
        List<Airport> result = airportService.findByCity(countryName);

        if (result.isEmpty()) {

            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(result);
        }

    }

}
