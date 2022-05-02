package fr.ibformation.projetEcoleFormation.bll;

import fr.ibformation.projetEcoleFormation.bo.*;

import java.util.List;

public interface UtilisateurManager {
    // CRUD Stagiaire
    public void addStagiaire(Stagiaire stagiaire);
    public void deleteStagiaire(Stagiaire stagiaire);
    public void modifyStagiaire(Stagiaire stagiaire);
    public void deleteStagiaireById(Integer id) throws UtilisateurManagerException;
    public Stagiaire getStagiaireById(Integer id);
    public List<Stagiaire> getAllStagiaire();

    // CRUD Formateur
    public void addFormateur(Formateur formateur);
    public void deleteFormateur(Formateur formateur);
    public void modifyFormateur(Formateur formateur);
    public void deleteFormateurById(Integer id) throws UtilisateurManagerException;
    public Formateur getFormateurById(Integer id);
    public List<Formateur> getAllFormateur();

    // CRUD EvaluationSession
    public void addEvaluationSession(EvaluationSession evaluationSession);
    public void deleteEvaluationSession(EvaluationSession evaluationSession);;
    public void modifyEvaluationSession(EvaluationSession evaluationSession);;
    public void deleteEvaluationSessionById(Integer id) throws UtilisateurManagerException;
    public EvaluationSession getEvaluationSessionById(Integer id);
    public List<EvaluationSession> getAllEvaluationSession();
    public void addEvaluationSessionToStagiaire(Stagiaire stagiaire, EvaluationSession... evaluationSession);


    // CRUD EvaluationFormateur
    public void addEvaluationFormateur(EvaluationFormateur evaluationFormateur);
    public void deleteEvaluationFormateur(EvaluationFormateur evaluationFormateur);;
    public void modifyEvaluationFormateur(EvaluationFormateur evaluationFormateur);;
    public void deleteEvaluationFormateurById(Integer id) throws UtilisateurManagerException;
    public EvaluationFormateur getEvaluationFormateurById(Integer id);
    public List<EvaluationFormateur> getAllEvaluationFormateur();

}
