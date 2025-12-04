/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.eti.lda.airports.controllers;

import br.eti.lda.airports.DTO.AirportNearMeDTO;
import br.eti.lda.airports.entities.Airport;
import br.eti.lda.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);

        if (result == null) {

            return ResponseEntity.notFound().build();

        } else {
            return ResponseEntity.ok(result);
        }
    }

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    /**
     * Endpoint /airports/nearme Retorna os aeroportos próximos a coordenada
     * enviada como parâmetro da requisição GET.
     *
     * @param latitude
     * @param longitude
     * @return
     */
    @GetMapping("/nearme")
    public ResponseEntity<List<AirportNearMeDTO>> findNearMe(
            @RequestParam double latitude,
            @RequestParam double longitude) {

        List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude);

        if (result.isEmpty()) {
            // Ops.. lista vazia...
            // not Found devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Eba! Tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
}

