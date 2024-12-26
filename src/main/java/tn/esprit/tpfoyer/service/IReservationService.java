package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.text.ParseException;
import java.util.List;


public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(String idReservation);
    public Reservation addReservation(Reservation reservation);
    public void removeReservation(String idReservation);
    public Reservation modifyReservation(Reservation reservation);
    //void updateetafficher() throws ParseException;
    public void assignEtudiantToReservation(Long etudiantId ,  String reservationId );

    }

