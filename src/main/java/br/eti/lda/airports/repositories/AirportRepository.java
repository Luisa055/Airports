
package br.eti.lda.airports.repositories;

import br.eti.lda.airports.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Aluno
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
   
    List<Airport> findByCityIgnoreCase(String city);
    List<Airport> findByCountryIgnoreCase(String country);
    Airport findByIataCode (String iataCode);
    
}
