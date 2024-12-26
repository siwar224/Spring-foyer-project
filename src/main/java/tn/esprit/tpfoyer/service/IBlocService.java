package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long blocId);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long blocId);
    public Bloc modifyBloc(Bloc bloc);
    public Bloc addBlocAndFoyerAndAssign(Bloc bloc);
   public void affecterBlocToFoyer(Long blocId , Long foyerId);
    public Bloc desaffecterBlocToFoyer(Long blocId);

    }