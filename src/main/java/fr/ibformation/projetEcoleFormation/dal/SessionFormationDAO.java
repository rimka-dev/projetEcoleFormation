package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.SessionFormation;

import org.springframework.data.repository.CrudRepository;

public interface SessionFormationDAO extends CrudRepository<SessionFormation, Integer> {
}
