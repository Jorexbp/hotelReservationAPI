package com.hotelReservationAPI.hotelReservationAPI.service.use_cases;

import com.hotelReservationAPI.hotelReservationAPI.dto.HotelRoomTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelRoomUseCase {
    List<HotelRoomTO> getAvailableRooms();

    HotelRoomTO getRoomDetails(Long id);

    HotelRoomTO createRoom(HotelRoomTO hotelRoomTO);

    HotelRoomTO updateRoom(Long id, HotelRoomTO hotelRoomTO);

    Boolean deleteRoom(Long id);
}
