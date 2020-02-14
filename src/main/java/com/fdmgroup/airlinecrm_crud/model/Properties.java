package com.fdmgroup.airlinecrm_crud.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.catalina.Host;

@Entity
@Table(name="properties")
public class Properties {

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "host_id")
	private Host hostPropertie;
}
