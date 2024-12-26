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
public class Chambre {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long idChambre;

  private Long numeroChambre;

  @Enumerated(EnumType.STRING)
  private TypeChambre typeC;

  @ManyToOne (cascade = CascadeType.ALL)
  @JsonIgnore
  @ToString.Exclude
  Bloc bloc;

  @OneToMany(cascade = CascadeType.ALL)
  //@JsonIgnore
  @ToString.Exclude
  private Set<Reservation> reservations;
 }
