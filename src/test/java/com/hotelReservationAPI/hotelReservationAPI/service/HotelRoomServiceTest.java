package com.hotelReservationAPI.hotelReservationAPI.service;

import com.hotelReservationAPI.hotelReservationAPI.repository.HotelRoomRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class HotelRoomServiceTest {

    // TODO

    @InjectMocks
    private HotelRoomService hotelRoomService;

    @Mock
    private HotelRoomRepository hotelRoomRepository;

    @BeforeAll
    public static void setUp(){

    }

    @Test
    void testGetAvailableRooms() {
        hotelRoomService.getAvailableRooms().getBody().size();


    }

    @Test
    void testGetRoomDetails() {
    }

    @Test
    void testCreateRoom() {
    }

    @Test
    void testUpdateRoom() {
    }

    @Test
    void testDeleteRoom() {
    }
}
