package fr.ibformation.projetEcoleFormation.bll;

import fr.ibformation.projetEcoleFormation.bo.*;
import fr.ibformation.projetEcoleFormation.dal.EvaluationFormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.EvaluationSessionDAO;
import fr.ibformation.projetEcoleFormation.dal.FormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
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
    @Transactional
    public void addStagiaire(Stagiaire stagiaire) {
        stagiaireDAO.save(stagiaire);
    }

    @Override
    @Transactional
    public void deleteStagiaire(Stagiaire stagiaire) {
        stagiaireDAO.delete(stagiaire);
    }

    @Override
    @Transactional
    public void modifyStagiaire(Stagiaire stagiaire){
        stagiaireDAO.save(stagiaire);

    }

    @Override
    public List<Stagiaire> getAllStagiaire() {
        return (List<Stagiaire>) stagiaireDAO.findAll();
    }

    @Override
    @Transactional
    public void deleteStagiaireById(Integer id) throws UtilisateurManagerException {
        stagiaireDAO.findById(id)
                .orElseThrow(()->new UtilisateurManagerException("Stagiaire introuvable"));
        stagiaireDAO.deleteById(id);
    }

    @Override
    public Stagiaire getStagiaireById(Integer id) {
        return stagiaireDAO.findById(id).orElse(null);
    }



    @Override
    @Transactional
    public void addFormateur(Formateur formateur) {
        formateurDAO.save(formateur);
    }

    @Override
    @Transactional
    public void deleteFormateur(Formateur formateur) {
        formateurDAO.delete(formateur);
    }

    @Override
    @Transactional
    public void modifyFormateur(Formateur formateur) {
        formateurDAO.save(formateur);
    }

    @Override
    @Transactional
    public void deleteFormateurById(Integer id) throws UtilisateurManagerException {
        formateurDAO.findById(id)
                .orElseThrow(()->new UtilisateurManagerException("Formateur introuvable"));
        formateurDAO.deleteById(id);
    }

    @Override
    public Formateur getFormateurById(Integer id) {
        return formateurDAO.findById(id).orElse(null);
    }

    @Override
    public List<Formateur> getAllFormateur() {
        return (List<Formateur>) formateurDAO.findAll();
    }

    @Override
    @Transactional
    public void addEvaluationSession(EvaluationSession evaluationSession) {
        evaluationSessionDAO.save(evaluationSession);
    }

    @Override
    @Transactional
    public void deleteEvaluationSession(EvaluationSession evaluationSession) {
        evaluationSessionDAO.delete(evaluationSession);
    }

    @Override
    @Transactional
    public void modifyEvaluationSession(EvaluationSession evaluationSession) {
        evaluationSessionDAO.save(evaluationSession);
    }

    @Override
    @Transactional
    public void deleteEvaluationSessionById(Integer id) throws UtilisateurManagerException {
        evaluationSessionDAO.findById(id)
                .orElseThrow(()->new UtilisateurManagerException("Evaluation introuvable"));
        evaluationSessionDAO.deleteById(id);
    }

    @Override
    public EvaluationSession getEvaluationSessionById(Integer id) {
        return evaluationSessionDAO.findById(id).orElse(null);
    }

    @Override
    public List<EvaluationSession> getAllEvaluationSession() {
        return (List<EvaluationSession>) evaluationSessionDAO.findAll();
    }

    @Override
    public void addEvaluationSessionToStagiaire(Stagiaire stagiaire, EvaluationSession... evaluationSession) {
        for (EvaluationSession eval : evaluationSession) {
            stagiaire.addEvalSession(eval);
        }
        stagiaireDAO.save(stagiaire);
    }

    @Override
    @Transactional
    public void addEvaluationFormateur(EvaluationFormateur evaluationSession) {
        evaluationFormateurDAO.save(evaluationSession);
    }

    @Override
    @Transactional
    public void deleteEvaluationFormateur(EvaluationFormateur evaluationFormateur) {
        evaluationFormateurDAO.delete(evaluationFormateur);
    }

    @Override
    @Transactional
    public void modifyEvaluationFormateur(EvaluationFormateur evaluationFormateur) {
        evaluationFormateurDAO.save(evaluationFormateur);
    }

    @Override
    @Transactional
    public void deleteEvaluationFormateurById(Integer id) throws UtilisateurManagerException {
        evaluationSessionDAO.findById(id)
                .orElseThrow(()->new UtilisateurManagerException("Evaluation formateur introuvable"));
        evaluationFormateurDAO.deleteById(id);
    }

    @Override
    public EvaluationFormateur getEvaluationFormateurById(Integer id) {
        return evaluationFormateurDAO.findById(id).orElse(null);
    }

    @Override
    public List<EvaluationFormateur> getAllEvaluationFormateur() {
        return (List<EvaluationFormateur>) evaluationFormateurDAO.findAll();
    }
}
