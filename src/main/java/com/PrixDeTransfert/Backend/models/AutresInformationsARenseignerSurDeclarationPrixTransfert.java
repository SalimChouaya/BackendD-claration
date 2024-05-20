package com.PrixDeTransfert.Backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table

public class AutresInformationsARenseignerSurDeclarationPrixTransfert {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	String AutresInformationsARenseignerSurDeclarationPrixTransfert ;
	
	@OneToOne
    @JoinColumn(name = "DéclarationsPrixDetransfertid", referencedColumnName = "id")
    private DéclarationPrixDeTransfert DéclarationPrixDeTransfert;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutresInformationsARenseignerSurDeclarationPrixTransfert() {
		return AutresInformationsARenseignerSurDeclarationPrixTransfert;
	}

	public void setAutresInformationsARenseignerSurDeclarationPrixTransfert(
			String autresInformationsARenseignerSurDeclarationPrixTransfert) {
		AutresInformationsARenseignerSurDeclarationPrixTransfert = autresInformationsARenseignerSurDeclarationPrixTransfert;
	}

	public DéclarationPrixDeTransfert getDéclarationPrixDeTransfert() {
		return DéclarationPrixDeTransfert;
	}

	public void setDéclarationPrixDeTransfert(DéclarationPrixDeTransfert déclarationPrixDeTransfert) {
		DéclarationPrixDeTransfert = déclarationPrixDeTransfert;
	}
}
