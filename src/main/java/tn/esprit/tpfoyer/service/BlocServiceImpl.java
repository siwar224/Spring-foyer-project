package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BlocServiceImpl implements IBlocService{
    BlocRepository blocRepository;
    FoyerRepository foyerRepository;

    @Scheduled(fixedRate = 60000)
    public List<Bloc> retrieveAllBlocs() {
        List<Bloc> listbloc = blocRepository.findAll();
        log.info("Nombre de bloc ; {} ", listbloc.size());
        for(Bloc b : listbloc){
            log.info("Bloc disponible  : {}", b);
        }
        return listbloc;
    }



    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).get();
    }

    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    public Bloc modifyBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }


    public Bloc addBlocAndFoyerAndAssign(Bloc bloc){

        return blocRepository.save(bloc);
    }
    //Affecter un Bloc à un Foyer (Les deux sont déjà dans la base de données)
  public void affecterBlocToFoyer(Long blocId , Long foyerId){
      Foyer foyer = foyerRepository.findById(foyerId).get();
      Bloc bloc = blocRepository.findById(blocId).get();
      bloc.setFoyer(foyer);
      blocRepository.save(bloc);
  }

  // Désaffecter un Bloc de son Foyer
    public Bloc desaffecterBlocToFoyer(Long blocId){
        Bloc bloc = blocRepository.findById(blocId).get();
        bloc.setFoyer(null);
        return blocRepository.save(bloc);
    }
}
