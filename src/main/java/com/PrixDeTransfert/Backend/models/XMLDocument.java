package com.PrixDeTransfert.Backend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table
public class XMLDocument {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	private String XMLContent ;
	 @OneToOne(cascade = CascadeType.ALL)
	    @JsonIgnore 
	    @JoinColumn(name = "declaration_id"  )
	    private DéclarationPrixDeTransfert DéclarationPrixDeTransfert;
	public String getXMLContent() {
		return XMLContent;
	}
	public void setXMLContent(String xMLContent) {
		XMLContent = xMLContent;
	}

}
