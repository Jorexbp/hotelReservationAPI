package com.hotelReservationAPI.hotelReservationAPI.repository;

import com.hotelReservationAPI.hotelReservationAPI.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
