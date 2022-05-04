package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.Formateur;
import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface FormateurDAO extends CrudRepository<Formateur, Integer> {

    @Query("SELECT f FROM Formateur f where f.mail= ?1")
    public String findFormateurByEmail(@Param("formateur") Formateur formateur);
}
