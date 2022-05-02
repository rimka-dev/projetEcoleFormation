package fr.ibformation.projetEcoleFormation.bll;

import fr.ibformation.projetEcoleFormation.bo.*;

import java.util.List;

public interface UtilisateurManager {
    // CRUD Stagiaire
    public void addStagiaire(Stagiaire stagiaire);
    public void deleteStagiaire(Stagiaire stagiaire);
    public void modifyStagiaire(Stagiaire stagiaire);
    public void deleteStagiaireById(Integer id);
    public void getStagiaireById(Integer id);
    public List<Stagiaire> getAllStagiaire();

    // CRUD Formateur
    public void addFormateur(Stagiaire stagiaire);
    public void deleteFormateur(Stagiaire stagiaire);
    public void modifyFormateur(Stagiaire stagiaire);
    public void deleteFormateurById(Integer id);
    public void getFormateurById(Integer id);
    public List<Formateur> getAllFormateur();

    // CRUD EvaluationSession
    public void addEvaluation(EvaluationSession evaluationSession);
    public void deleteEvaluationSession(EvaluationSession evaluationSession);;
    public void modifyEvaluationSession(EvaluationSession evaluationSession);;
    public void deleteEvaluationSession(Integer id);
    public void getEvaluationSessionById(Integer id);
    public List<EvaluationSession> getAllEvaluationSession();


    // CRUD EvaluationFormateur
    public void addEvaluationFormateur(EvaluationFormateur evaluationSession);
    public void deleteEvaluationFormateur(EvaluationFormateur evaluationSession);;
    public void modifyEvaluationFormateur(EvaluationFormateur evaluationSession);;
    public void deleteEvaluationFormateur(Integer id);
    public void getEvaluationFormateurById(Integer id);
    public List<EvaluationFormateur> getAllEvaluationFormateur();

}
