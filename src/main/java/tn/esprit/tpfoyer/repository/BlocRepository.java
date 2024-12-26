package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {

    //List<Bloc> findAllByCapaciteBlocGreaterThan(long x);
    //List<Bloc> findAllByNomBlocStartingWith(String ch);
    //List<Bloc> findFirstByNomBlocAndCapaciteBlocGreaterThan(String ch,long x);
   // List<Bloc> findAllByNomBlocStartingWithAndCapaciteBlocGreaterThan(String ch , long x);

    //Bloc findBlocByNomBloc(String ch);


}
