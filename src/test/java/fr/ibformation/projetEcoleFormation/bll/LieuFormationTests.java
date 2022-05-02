package fr.ibformation.projetEcoleFormation.bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.ibformation.projetEcoleFormation.bo.SalleFormation;

@SpringBootTest
class LieuFormationTests {

	@Autowired
	LieuFormationManger lieuManager;

	//============= test sur la salle ==========================
	@Test
	@Transactional
	void addSalle() {
		SalleFormation salleRouge = new SalleFormation("Salle Rouge", 1);
		lieuManager.addSalleFormation(salleRouge);
		assertNotNull(salleRouge.getIdSalleFormation());
		
	}
	
	@Test
	@Transactional
	void getSalleById() {
		SalleFormation salle = new SalleFormation("Salle bleu", 5);
		lieuManager.addSalleFormation(salle);
		SalleFormation salleBis = lieuManager.getSallaById(salle.getIdSalleFormation());
		assertEquals(salleBis.getIdSalleFormation(), salle.getIdSalleFormation());
		
	}
	

	@Test
	@Transactional
	void updateSalle() {
		SalleFormation salleAteilier = new SalleFormation("Salle de travaux", 4);
		lieuManager.addSalleFormation(salleAteilier);
		salleAteilier.setEtage(6);
		lieuManager.updateSalleFormation(salleAteilier);
		assertEquals(salleAteilier.getEtage(), 6);
		
	}
	
	@Test
	@Transactional
	void deleteSalle() {
		SalleFormation salleAteilier = new SalleFormation("Salle de travaux", 4);
		lieuManager.addSalleFormation(salleAteilier);
		//lieuManager.deleteSalle(salleAteilier);
		assertNull(lieuManager.getSallaById(salleAteilier.getIdSalleFormation()));
	}
	
	
	

}
