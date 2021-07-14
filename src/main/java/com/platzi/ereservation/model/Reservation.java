package com.platzi.ereservation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class representing the reservation table.
 * 
 * @author Nelson
 *
 */
@Data
@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String idR;

	@Temporal(TemporalType.DATE)
	private Date dateEntry;

	@Temporal(TemporalType.DATE)
	private Date dateExit;

	private int amountPeople;
	private String description;

	@ManyToOne
	@JoinColumn(name = "idC")
	private Client client;

	public Reservation() {

	}
}
