package fr.ibformation.projetEcoleFormation;

import fr.ibformation.projetEcoleFormation.bo.*;
import fr.ibformation.projetEcoleFormation.dal.EntrepriseClientDAO;
import fr.ibformation.projetEcoleFormation.dal.FormateurDAO;
import fr.ibformation.projetEcoleFormation.dal.StagiaireDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class ProjetEcoleFormationApplication implements CommandLineRunner {
	@Autowired
	StagiaireDAO stagiaireDAO;
	@Autowired
	FormateurDAO formateurDAO;

	@Autowired
	EntrepriseClientDAO entrepriseClientDAO;

	public static void main(String[] args) {
		SpringApplication.run(ProjetEcoleFormationApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Stagiaire stagiaire1 = new Stagiaire("Dupont","Jean","fdsfsd@fdsfds.com","fdsfdsf","Stagiaire","5 rue fdsfsd","31000","Toulouse");
		Formateur formateur1 = new Formateur("Dufdfds","Pierre","fdsfsd@fdsfds.com","fdsfdsf","Formateur","5 rue fdsfsd","31000","Toulouse");
		stagiaireDAO.save(stagiaire1);
		formateurDAO.save(formateur1);
		EntrepriseClient entreprise1 = new EntrepriseClient("Boufdsf","6 rue de la bergerie","66000","Perpignan");
		entreprise1.addStagiaire(stagiaire1);
		System.out.println(stagiaire1.getEntreprise());
		entrepriseClientDAO.save(entreprise1);
		System.out.println(entreprise1.getListeStagiaires());
		
		
		

	}
}
