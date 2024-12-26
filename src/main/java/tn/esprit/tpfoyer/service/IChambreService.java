package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);

    public Chambre creerAffecter(Chambre c) ;

    public void affecterBlocToFoyer(Long blocId, Long chambreId) ;
    public void affecterChambreAreservation(Long chambreId , String reservationId);
    public Chambre desaffecterChambreToReservation(Long chambreId);
   // public List<Chambre> getbyTypeC(TypeChambre typeChambre);
    public Chambre trouverChseleonE(long cin);


    }