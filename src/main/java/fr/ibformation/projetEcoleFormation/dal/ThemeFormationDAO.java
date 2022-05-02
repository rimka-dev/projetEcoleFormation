package fr.ibformation.projetEcoleFormation.dal;

import fr.ibformation.projetEcoleFormation.bo.SousThemeFormation;

import org.springframework.data.repository.CrudRepository;

public interface ThemeFormationDAO extends CrudRepository<SousThemeFormation, Integer> {
}
