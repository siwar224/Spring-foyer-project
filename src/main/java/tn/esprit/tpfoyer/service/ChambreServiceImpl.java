package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.*;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    ReservationRepository reservationRepository;

    public List<Chambre> retrieveAllChambres() {

        return chambreRepository.findAll();
    }

    public Chambre retrieveChambre(Long chambreId) {

        return chambreRepository.findById(chambreId).get();
    }

   /* public List<Chambre> getbyTypeC(TypeChambre typeChambre){
        return chambreRepository.findAllByTypeC(typeChambre);
    }*/

    public Chambre trouverChseleonE(long cin){
        return chambreRepository.trouverChselonEt(cin);
    }

    public Chambre addChambre(Chambre c) {

        return chambreRepository.save(c);
    }

    public void removeChambre(Long chambreId) {

        chambreRepository.deleteById(chambreId);
    }

    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public Chambre creerAffecter(Chambre c) {
        return chambreRepository.save(c);
    }
    public void affecterBlocToFoyer(Long blocId, Long chambreId) {
        Chambre chambre = chambreRepository.findById(chambreId).get();
        Bloc bloc = blocRepository.findById(blocId).get();
        chambre.setBloc(bloc);
        chambreRepository.save(chambre);
    }

    //affecter chambre à reservation
    public void affecterChambreAreservation(Long chambreId , String reservationId){
        Chambre chambre = chambreRepository.findById(chambreId).get();
        Reservation reservation=reservationRepository.findById(reservationId).get();

       chambre.getReservations().add(reservation);
       chambreRepository.save(chambre);
    }

    //desaffecter chambre a reseervation
    public Chambre desaffecterChambreToReservation(Long chambreId){
        Chambre chambre=chambreRepository.findById(chambreId).get();
        chambre.setReservations(null);
        return  chambreRepository.save(chambre);
    }


}