package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.Formateur;
import org.springframework.data.repository.CrudRepository;

public interface FormateurDAO extends CrudRepository<Formateur, Integer> {
}
