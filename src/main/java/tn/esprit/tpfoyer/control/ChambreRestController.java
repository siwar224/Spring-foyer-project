package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;
import tn.esprit.tpfoyer.service.IChambreService;

import java.util.List;
@Tag(name ="Gestion Chambre ")  // pour decrire le bloc titre dans swagger
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;
    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    /*@GetMapping("/retrieve-by-typeC/{typec}")
    public List<Chambre> getChambresbyTypeC(@PathVariable("typec")TypeChambre typeChambre) {
        List<Chambre> listChambres = chambreService.getbyTypeC(typeChambre);
        return listChambres;
    }*/
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;

    }

    @GetMapping("/retrieve-chambre-selon-cin/{cin-etudiant}")
    public Chambre retrieveChambreseloncin(@PathVariable("cin-etudiant") Long cin) {
        Chambre chambre = chambreService.trouverChseleonE(cin);
        return chambre;

    }

    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

    @PutMapping("/creer-affecter-chambre-to-reservation")
    public Chambre assignBlocToFoyer(@RequestBody Chambre chambre ) {
        chambreService.creerAffecter(chambre);
        return chambre;
    }

    @PutMapping("/affecter-bloc-to-chambre/{id-bloc}/{id-chambre}")
    public void assignBlocToFoyer(@PathVariable("id-bloc") Long idBloc , @PathVariable("id-chambre") Long idChambre) {

        chambreService.affecterBlocToFoyer(idBloc,idChambre);
    }

    // http://localhost:8089/tpfoyer/chambre/affecter-chambre-to-reservation/1/1
    @PutMapping("/affecter-chambre-to-reservation/{id-chambre}/{id-reservation}")
    public void assignBlocToFoyer(@PathVariable("id-chambre") Long idChambre , @PathVariable("id-reservation") String idReservation) {

        chambreService.affecterChambreAreservation(idChambre,idReservation);
    }
    // http://localhost:8089/tpfoyer/bloc/desaffecter-chambre-to-reservation/1/
    @PutMapping("/desaffecter-chambre-to-reservation/{id-chambre}")
    public void assignBlocToFoyer(@PathVariable("id-chambre") Long idChambre ) {
        chambreService.desaffecterChambreToReservation(idChambre);
    }


}