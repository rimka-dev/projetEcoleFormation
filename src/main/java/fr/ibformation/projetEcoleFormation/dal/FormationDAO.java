package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.Formation;

import org.springframework.data.repository.CrudRepository;

public interface FormationDAO extends CrudRepository<Formation, Integer> {
}
