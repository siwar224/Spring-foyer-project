package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {

   // List<Chambre> findAllByTypeC(TypeChambre tc);
    //List <Chambre> findAllByNumeroChambre(long numerochambre);
   @Query("SELECT distinct (ch) FROM Chambre ch " +
           "INNER JOIN ch.reservations r " +
           "INNER JOIN r.etudiants e " +
           "WHERE e.cin=:cin" )
   Chambre trouverChselonEt(long cin);
}
