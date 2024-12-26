package tn.esprit.tpfoyer.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bloc {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long idBloc;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne(cascade = CascadeType.ALL)
    private Foyer foyer;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "bloc")
    @JsonIgnore
    @ToString.Exclude
    private Set<Chambre> chambres ;
}
