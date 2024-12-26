package tn.esprit.tpfoyer.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {
    EtudiantRepository etudiantRepository;
    public List<Etudiant> retrieveAllEtudiants() {
        return (etudiantRepository.findAll());
    }

    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return (etudiantRepository.findById(idEtudiant).get());
    }

    public Etudiant addEtudiant(Etudiant e) {
        return (etudiantRepository.save(e));
    }

    public List<Etudiant> retrieveAllEtudiantsbyecoleetdate(String e , Date date) {

        return (etudiantRepository.findAllByEcoleAndDateNaissanceAfter(e,date));
    }


    public void removeEtudiant(Long idEtudiant) {
      etudiantRepository.deleteById(idEtudiant);
    }

    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
}