package fr.ibformation.projetEcoleFormation.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ibformation.projetEcoleFormation.bo.CentreFormation;
import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.SalleFormation;
import fr.ibformation.projetEcoleFormation.dal.CentreFormationDAO;
import fr.ibformation.projetEcoleFormation.dal.EntrepriseClientDAO;
import fr.ibformation.projetEcoleFormation.dal.SalleFormationDAO;

@Service
public class LieuFormationManagerImpl implements LieuFormationManager {
	
	@Autowired SalleFormationDAO salleDAO;
	@Autowired CentreFormationDAO centreFormationDAO;
	@Autowired EntrepriseClientDAO entrepriseDAO;
	
//================= salle de formation ================================
	@Override
	@Transactional
	public void addSalleFormation(SalleFormation salle) {
		salleDAO.save(salle);

	}

	@Override
	@Transactional
	public void updateSalleFormation(SalleFormation salle) {
		salleDAO.save(salle);
		
	}

	@Override
	public List<SalleFormation> getAllSalle() {
		
		return (List<SalleFormation>) salleDAO.findAll();
	}

	@Override
	public SalleFormation getSallaById(Integer id) {
		
		return salleDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteSalle(SalleFormation salle) throws LieuException {
		salleDAO.findById(salle.getIdSalleFormation())
				.orElseThrow(()->new LieuException("Cet élément n'exisite plus"));
		salleDAO.delete(salle);
		
	}
//============= Centre de formation ======================================
	@Override
	@Transactional
	public void addCentreFormation(CentreFormation centre) {
		centreFormationDAO.save(centre);
		
	}

	@Override
	@Transactional
	public void updateCentreFormation(CentreFormation centre) {
		centreFormationDAO.save(centre);
		
	}

	@Override
	public List<CentreFormation> getAllCentreFormation() {
		
		return (List<CentreFormation>) centreFormationDAO.findAll();
	}

	@Override
	public CentreFormation getCentreFormationById(Integer id) {
		
		return centreFormationDAO.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteCentreFormationById(Integer id1) {
		centreFormationDAO.deleteById(id1);
		
	}
//========================= Entreprise Client ==================
	@Override
	@Transactional
	public void addEntreprise(EntrepriseClient entreprise) {
		entrepriseDAO.save(entreprise);
		
	}

	@Override
	@Transactional
	public void updateEntreprise(EntrepriseClient entreprise) {
		entrepriseDAO.save(entreprise);
		
	}

	@Override
	public List<EntrepriseClient> getAllEntreprise() {
		
		return (List<EntrepriseClient>) entrepriseDAO.findAll();
	}

	@Override
	public EntrepriseClient getEntrepriseById(Integer id) {
		
		return entrepriseDAO.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteEntrepriseById(Integer id) {
		entrepriseDAO.deleteById(id);
		
	}

}
