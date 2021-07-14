/**
 * 
 */
package com.platzi.ereservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class representing the client table.
 * 
 * @author Nelson
 *
 */
@Data
@Entity
@Table(name = "client")
@NamedQuery(name = "Client.finByIdentification", query = "SELECT c FROM Client c WHERE c.identification=?1")
public class Client {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idC;

	private String name;
	private String surName;
	private String identification;
	private String direction;
	private String numberPhone;
	private String email;

	@OneToMany(mappedBy = "client")
	private Set<Reservation> reservation;

	public Client() {

	}

}
