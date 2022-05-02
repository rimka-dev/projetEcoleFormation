package fr.ibformation.projetEcoleFormation.bll;


import java.util.List;

import fr.ibformation.projetEcoleFormation.bo.CentreFormation;
import fr.ibformation.projetEcoleFormation.bo.EntrepriseClient;
import fr.ibformation.projetEcoleFormation.bo.SalleFormation;


public interface LieuFormationManger {

	public void addSalleFormation(SalleFormation salle);

	public void updateSalleFormation(SalleFormation salle);

	public List<SalleFormation> getAllSalle();

	public SalleFormation getSallaById(Integer id);

	public void deleteSalle(SalleFormation salle) throws LieuException;

	public void addCentreFormation(CentreFormation centre);

	public void updateCentreFormation(CentreFormation centre);

	public List<CentreFormation> getAllCentreFormation();

	public CentreFormation getCentreFormationById(Integer id);

	public void deleteCentreFormationById(Integer id1);

	public void addEntreprise(EntrepriseClient entreprise);

	public void updateEntreprise(EntrepriseClient entreprise);

	public List<EntrepriseClient> getAllEntreprise();

	public EntrepriseClient getEntrepriseById(Integer id);

	public void deleteEntrepriseById(Integer id);

}
