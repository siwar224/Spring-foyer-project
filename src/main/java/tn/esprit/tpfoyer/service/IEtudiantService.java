package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Etudiant; // Assurez-vous que le bon import est utilisé.

import java.util.Date;
import java.util.List;

public interface IEtudiantService {
    public List<Etudiant> retrieveAllEtudiants();
    public Etudiant retrieveEtudiant(Long etudiantId);
    public Etudiant addEtudiant(Etudiant e);
    public void removeEtudiant(Long etudiantId);
    public Etudiant modifyEtudiant(Etudiant etudiant);
    public List<Etudiant> retrieveAllEtudiantsbyecoleetdate(String e , Date date) ;

        // Here we will add later methods calling keywords and methods calling JPQL
}
