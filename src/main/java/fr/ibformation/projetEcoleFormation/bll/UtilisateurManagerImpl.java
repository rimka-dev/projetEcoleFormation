package fr.ibformation.projetEcoleFormation.bll;

import fr.ibformation.projetEcoleFormation.bo.*;
import fr.ibformation.projetEcoleFormation.dal.EvaluationFormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.EvaluationSessionDAO;
import fr.ibformation.projetEcoleFormation.dal.FormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UtilisateurManagerImpl implements UtilisateurManager {
    @Autowired
    FormateurDAO formateurDAO;
    @Autowired
    StagiaireDAO stagiaireDAO;
    @Autowired
    EvaluationSessionDAO evaluationSessionDAO;
    @Autowired
    EvaluationFormateurDAO evaluationFormateurDAO;

    @Override
    public void addStagiaire(Stagiaire stagiaire) {
        
    }

    @Override
    public void deleteStagiaire(Stagiaire stagiaire) {

    }

    @Override
    public void modifyStagiaire(Stagiaire stagiaire) {

    }

    @Override
    public void deleteStagiaireById(Integer id) {

    }

    @Override
    public void getStagiaireById(Integer id) {

    }

    @Override
    public List<Stagiaire> getAllStagiaire() {
        return null;
    }

    @Override
    public void addFormateur(Stagiaire stagiaire) {

    }

    @Override
    public void deleteFormateur(Stagiaire stagiaire) {

    }

    @Override
    public void modifyFormateur(Stagiaire stagiaire) {

    }

    @Override
    public void deleteFormateurById(Integer id) {

    }

    @Override
    public void getFormateurById(Integer id) {

    }

    @Override
    public List<Formateur> getAllFormateur() {
        return null;
    }

    @Override
    public void addEvaluation(EvaluationSession evaluationSession) {

    }

    @Override
    public void deleteEvaluationSession(EvaluationSession evaluationSession) {

    }

    @Override
    public void modifyEvaluationSession(EvaluationSession evaluationSession) {

    }

    @Override
    public void deleteEvaluationSession(Integer id) {

    }

    @Override
    public void getEvaluationSessionById(Integer id) {

    }

    @Override
    public List<EvaluationSession> getAllEvaluationSession() {
        return null;
    }

    @Override
    public void addEvaluationFormateur(EvaluationFormateur evaluationSession) {

    }

    @Override
    public void deleteEvaluationFormateur(EvaluationFormateur evaluationSession) {

    }

    @Override
    public void modifyEvaluationFormateur(EvaluationFormateur evaluationSession) {

    }

    @Override
    public void deleteEvaluationFormateur(Integer id) {

    }

    @Override
    public void getEvaluationFormateurById(Integer id) {

    }

    @Override
    public List<EvaluationFormateur> getAllEvaluationFormateur() {
        return null;
    }
}
