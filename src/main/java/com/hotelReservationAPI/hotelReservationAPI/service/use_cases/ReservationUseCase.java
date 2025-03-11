package com.hotelReservationAPI.hotelReservationAPI.service.use_cases;

import com.hotelReservationAPI.hotelReservationAPI.dto.ReservationTO;

public interface ReservationUseCase {
    ReservationTO getReservationById(Long id);

    ReservationTO createReservation(ReservationTO reservationTO);

    Boolean deleteReservation(Long id);
}