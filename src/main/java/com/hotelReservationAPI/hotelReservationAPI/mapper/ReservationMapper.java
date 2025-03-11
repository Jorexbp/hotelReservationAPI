package com.hotelReservationAPI.hotelReservationAPI.mapper;

import com.hotelReservationAPI.hotelReservationAPI.dto.ReservationTO;
import com.hotelReservationAPI.hotelReservationAPI.model.ReservationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationTO toDto(ReservationEntity entity);

    ReservationEntity toEntity(ReservationTO reservationTO);
}