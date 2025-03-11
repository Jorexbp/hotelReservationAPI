package com.hotelReservationAPI.hotelReservationAPI.mapper;

import com.hotelReservationAPI.hotelReservationAPI.dto.HotelRoomTO;
import com.hotelReservationAPI.hotelReservationAPI.model.HotelRoomEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelRoomMapper {
    HotelRoomTO toDto(HotelRoomEntity hotelRoom);

    HotelRoomEntity toEntity(HotelRoomTO hotelRoomTO);
}
