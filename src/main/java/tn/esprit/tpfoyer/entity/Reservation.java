package tn.esprit.tpfoyer.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private String idReservation = java.util.UUID.randomUUID().toString();
    private Date anneeUniversitaire;
    private Boolean estValide;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @ToString.Exclude // pour eviter les valeur null
   // @JsonIgnore // pour eviter la bouvle infinie
    private Set<Etudiant> etudiants=new HashSet<Etudiant>();
}
