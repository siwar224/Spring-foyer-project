package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.Date;
import java.util.List;
@Tag(name ="Gestion Etudiant ")  // pour decrire le bloc titre dans swagger
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    IEtudiantService etudiantService;
    // http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }
    // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long eId) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(eId);
        return etudiant;

    }


    @GetMapping("/retrieve-etudiant-by-ecole-and-date/{ecole}/{date}")
    public List <Etudiant> retrieveEtudiant(@PathVariable("ecole") String e , @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date d) {
        List <Etudiant> listeetud = etudiantService.retrieveAllEtudiantsbyecoleetdate(e,d);
        return listeetud;

    }




    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e ) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }

    // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long eId) {
        etudiantService.removeEtudiant(eId);
    }
    // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant  = etudiantService.modifyEtudiant(e);
        return etudiant;
    }
}