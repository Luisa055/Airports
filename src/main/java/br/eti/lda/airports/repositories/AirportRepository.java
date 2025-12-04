
package br.eti.lda.airports.repositories;

import br.eti.lda.airports.entities.Airport;
import br.eti.lda.airports.projections.AirportNearMeProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Aluno
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
   
    List<Airport> findByCityIgnoreCase(String city);
    List<Airport> findByCountryIgnoreCase(String country);
    Airport findByIataCode (String iataCode);
    
    @Query(nativeQuery = true, value = """
        SELECT
            airport.id,
            airport.name,
            airport.city,
            airport.iatacode,
            airport.latitude,
            airport.longitude,
            airport.altitude,
            SQRT(
            power(airport.latitude - :latOrigem, 2 ) +
            power(airport.longitude - :lonOrigem, 2)) * 60 * 1.852 as
           distanciaKM
       from AIRPORT
       order by distanciaKM
       limit 10;                              
       """
            )
    List<AirportNearMeProjection> findNearMe(double latOrigem, double lonOrigem);

}
