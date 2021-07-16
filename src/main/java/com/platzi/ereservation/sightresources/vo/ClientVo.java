package com.platzi.ereservation.sightresources.vo;

import java.util.Set;

import lombok.Data;

/**
 * Class representing the client table.
 * 
 * @author Nelson
 *
 */
@Data
public class ClientVo {

	private String name;
	private String surName;
	private String identification;
	private String direction;
	private String numberPhone;
	private String email;

}
