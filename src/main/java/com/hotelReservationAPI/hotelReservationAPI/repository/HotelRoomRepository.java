package com.hotelReservationAPI.hotelReservationAPI.repository;

import com.hotelReservationAPI.hotelReservationAPI.model.HotelRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HotelRoomRepository extends JpaRepository<HotelRoomEntity, Long> {

    @Query("SELECT r FROM HotelRoomEntity r WHERE r.available = true")
    List<HotelRoomEntity> findAvailable();

}
