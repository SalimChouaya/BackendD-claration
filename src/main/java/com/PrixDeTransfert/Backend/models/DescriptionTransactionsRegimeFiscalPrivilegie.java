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
public class DescriptionTransactionsRegimeFiscalPrivilegie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	String DescriptionTransactionsRegimeFiscalPrivilegie;
	@OneToOne
    @JoinColumn(name = "MontantTransactionsMethodeDeterminationPrixTransfertid", referencedColumnName = "id")
    private MontantTransactionsMethodeDeterminationPrixTransfertBD MontantTransactionsMethodeDeterminationPrixTransfert;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescriptionTransactionsRegimeFiscalPrivilegie() {
		return DescriptionTransactionsRegimeFiscalPrivilegie;
	}
	public void setDescriptionTransactionsRegimeFiscalPrivilegie(String descriptionTransactionsRegimeFiscalPrivilegie) {
		DescriptionTransactionsRegimeFiscalPrivilegie = descriptionTransactionsRegimeFiscalPrivilegie;
	}
	public MontantTransactionsMethodeDeterminationPrixTransfertBD getMontantTransactionsMethodeDeterminationPrixTransfert() {
		return MontantTransactionsMethodeDeterminationPrixTransfert;
	}
	public void setMontantTransactionsMethodeDeterminationPrixTransfert(
			MontantTransactionsMethodeDeterminationPrixTransfertBD montantTransactionsMethodeDeterminationPrixTransfert) {
		MontantTransactionsMethodeDeterminationPrixTransfert = montantTransactionsMethodeDeterminationPrixTransfert;
	}
}

