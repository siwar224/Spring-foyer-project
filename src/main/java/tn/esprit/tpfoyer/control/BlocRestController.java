package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@Tag(name = "Gestion Bloc")  // pour décrire le bloc titre dans Swagger
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        return blocService.retrieveAllBlocs();
    }

    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/{bloc-id}
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }

    // http://localhost:8089/tpfoyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    // http://localhost:8089/tpfoyer/bloc/remove-bloc/{bloc-id}
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc) {
        return blocService.modifyBloc(bloc);
    }


    // http://localhost:8089/tpfoyer/bloc/affecter-foyer-to-bloc/1
    @PutMapping("/creer-affecter-foyer-to-bloc")
    public Bloc assignBlocToFoyer(@RequestBody Bloc bloc ) {
        try {

        }catch (Exception e)  {

        }
        finally {

        }
        blocService.addBlocAndFoyerAndAssign(bloc);
        return bloc;
    }

      // http://localhost:8089/tpfoyer/bloc/affecter-foyer-to-bloc/1/1
    @PutMapping("/affecter-foyer-to-bloc/{id-bloc}/{id-foyer}")
    public void assignBlocToFoyer(@PathVariable("id-bloc") Long idBloc , @PathVariable("id-foyer") Long idFoyer) {

        blocService.affecterBlocToFoyer(idBloc,idFoyer);
    }

    // http://localhost:8089/tpfoyer/bloc/desaffecter-foyer-to-bloc/1/
    @PutMapping("/desaffecter-foyer-to-bloc/{id-bloc}")
    public void assignBlocToFoyer(@PathVariable("id-bloc") Long idBloc ) {

        blocService.desaffecterBlocToFoyer(idBloc);
    }

}
