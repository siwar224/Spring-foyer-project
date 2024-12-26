package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class FoyerServiceImpl implements IFoyerService{
    FoyerRepository foyerRepository;
    /*public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }
*/
    @Scheduled(fixedRate = 60000)
    public List<Foyer> retrieveAllFoyers() {
        List<Foyer> listFoyer = foyerRepository.findAll();
        log.info("Nombre de foyers: {}", listFoyer.size()); // Utilisation correcte de log avec une chaîne formatée
        for (Foyer f : listFoyer) {
            log.info("Foyer: {}", f);
        }

        return listFoyer;
    }


    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId).get();
    }

    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    public void removeFoyer(Long foyerId) {
           foyerRepository.deleteById(foyerId);
    }

    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
}
