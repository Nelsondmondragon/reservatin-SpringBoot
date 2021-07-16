package com.platzi.ereservation.bussines.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.platzi.ereservation.model.Reservation;

public interface reservationRepository extends JpaRepository<Reservation, String> {

	@Query("SELECT r FROM Reservation r WHERE r.dateEntry =:dateEntry and r.dateExit =:dateExit")
	public List<Reservation> fin(@Param("dateEntry") Date dateEntry, @Param("dateExit") Date dateExit);
}
