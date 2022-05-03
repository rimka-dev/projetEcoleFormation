package fr.ibformation.projetEcoleFormation.bo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SessionFormation {
	@Id
	@GeneratedValue
	private Integer idSession;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String typeFormation;
	private Boolean salleInstallee;
	private Boolean formateurConfirme;
	private Boolean supportImprime;
	private Boolean convocationEnvoyee;
	private Boolean planningMisAjour;
	private Boolean listePresenceImprimee;
	private Boolean ticketRepasImprime;
	private Boolean formulaireEvalGenere;
	
	@ManyToOne
	@JsonManagedReference(value="session-formation")
	private Formation formation;
	
	@ManyToOne
	@JsonBackReference
	private SalleFormation salleFormation;
	
	@ManyToOne
	@JsonBackReference
	private Formateur formateur;
	
	@ManyToOne
	@JsonBackReference
	private EntrepriseClient entreprise;
	
	@OneToMany(mappedBy = "sessionFormation")
	@JsonManagedReference
	private Set <Stagiaire> listeStagiaires = new HashSet<>();
	
	@OneToOne
	private EvaluationSession evalSession;
	
	@OneToOne
	private EvaluationFormateur evalFormateur;
	
	
	
	public SessionFormation(LocalDate dateDebut, LocalDate dateFin, String typeFormation, Boolean salleInstallee,
			Boolean formateurConfirme, Boolean supportImprime, Boolean convocationEnvoyee, Boolean planningMisAjour,
			Boolean listePresenceImprimee, Boolean ticketRepasImprime, Boolean formulaireEvalGenere) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.typeFormation = typeFormation;
		this.salleInstallee = salleInstallee;
		this.formateurConfirme = formateurConfirme;
		this.supportImprime = supportImprime;
		this.convocationEnvoyee = convocationEnvoyee;
		this.planningMisAjour = planningMisAjour;
		this.listePresenceImprimee = listePresenceImprimee;
		this.ticketRepasImprime = ticketRepasImprime;
		this.formulaireEvalGenere = formulaireEvalGenere;
	}
	
	
	public void addStagiaire(Stagiaire stagiaire) {
		this.listeStagiaires.add(stagiaire);
		stagiaire.setSessionFormation(this);
	}

	@Override
	public String toString() {
		return "SessionFormation [idSession=" + idSession + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", typeFormation=" + typeFormation + ", salleInstallee=" + salleInstallee + ", formateurConfirme="
				+ formateurConfirme + ", supportImprime=" + supportImprime + ", convocationEnvoyee="
				+ convocationEnvoyee + ", planningMisAjour=" + planningMisAjour + ", listePresenceImprimee="
				+ listePresenceImprimee + ", ticketRepasImprime=" + ticketRepasImprime + ", formulaireEvalGenere="
				+ formulaireEvalGenere + "]";
	}
	
	
	
	
	
	

}
