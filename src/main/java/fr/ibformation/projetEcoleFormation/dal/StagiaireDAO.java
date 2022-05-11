package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.EvaluationFormateur;
import fr.ibformation.projetEcoleFormation.bo.SessionFormation;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StagiaireDAO extends CrudRepository<Stagiaire, Integer> {

    @Query("SELECT s FROM Stagiaire s where s.mail= ?1")
    Stagiaire findStagiaireByEmail(@Param("stagiaire") String mail);
//
//    @Query("SELECT liste_stagiaires_id_utilisateur, liste_session_formation_id_session\r\n"
//    		+ "FROM formation.stagiaire_liste_session_formation where liste_stagiaires_id_utilisateur=:id")
//    List <SessionFormation> findSessionByIdStagiaire (@Param("id") Integer id);
//    
    
}
