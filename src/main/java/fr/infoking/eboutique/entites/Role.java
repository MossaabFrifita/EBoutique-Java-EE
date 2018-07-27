package fr.infoking.eboutique.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Role {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idRole;
	private String nomRole;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String nomRole) {
		super();
		this.nomRole = nomRole;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getNomRole() {
		return nomRole;
	}
	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}
	
	
	

}
