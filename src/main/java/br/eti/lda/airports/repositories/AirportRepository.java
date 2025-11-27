
package br.eti.lda.airports.repositories;

import br.eti.lda.airports.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Aluno
 */
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
}
