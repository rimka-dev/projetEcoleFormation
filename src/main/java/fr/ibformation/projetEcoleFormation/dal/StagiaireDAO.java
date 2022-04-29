package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.Stagiaire;
import org.springframework.data.repository.CrudRepository;

public interface StagiaireDAO extends CrudRepository<Stagiaire, Integer> {
}
