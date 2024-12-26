package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.EtudiantRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository reservationRepository;
    EtudiantRepository etudiantRepository;
    private static final String DLIMITE = "2024-09-01";

    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void removeReservation(String idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

   /* @Scheduled(fixedRate = 50000)
    public void updateetafficher() throws ParseException {
        Date limite = new SimpleDateFormat("yyyy-MM-dd").parse(DLIMITE);

        List<Reservation> reservations = reservationRepository.findAll();

        log.info("Les réservations sont : {}", reservations.size());

        for (Reservation reservation : reservations) {
            if (reservation.getAnneeUniversitaire().before(limite) && Boolean.TRUE.equals(reservation.getEstValide())) {
                reservation.setEstValide(false);
                reservationRepository.save(reservation);

                log.info("La réservation avec l'ID {} a été marquée comme invalide.", reservation.getIdReservation());
            }

            log.info("Réservation : ID = {}, Annee Universitaire = {}, Est Valide = {}",
                    reservation.getIdReservation(),
                    reservation.getAnneeUniversitaire(),
                    reservation.getEstValide());
        }
    }*/
 @Scheduled(fixedRate = 50000)
    public void updateetafficher() throws ParseException {
        Date limite = new SimpleDateFormat("yyyy-MM-dd").parse(DLIMITE);

        List<Reservation> reservations = reservationRepository.findAll();

        log.info("Les réservations sont : {}", reservations.size());

        for (Reservation reservation : reservations) {
            if (reservation.getAnneeUniversitaire().before(limite) && Boolean.TRUE.equals(reservation.getEstValide())) {
                reservation.setEstValide(false);
                reservationRepository.save(reservation);

                log.info("La réservation avec l'ID {} a été marquée comme invalide.", reservation.getIdReservation());
            }

            log.info("Réservation : ID = {}, Annee Universitaire = {}, Est Valide = {}",
                    reservation.getIdReservation(),
                    reservation.getAnneeUniversitaire(),
                    reservation.getEstValide());
        }
    }

    public void assignEtudiantToReservation(Long etudiantId ,  String reservationId ){
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();
        reservation.getEtudiants().add(etudiant);
        reservationRepository.save(reservation);
    }

}
