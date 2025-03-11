package com.hotelReservationAPI.hotelReservationAPI.controller;

import com.hotelReservationAPI.hotelReservationAPI.dto.HotelRoomTO;
import com.hotelReservationAPI.hotelReservationAPI.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class HotelRoomController {

    @Autowired
    private HotelRoomService hotelRoomService;

    @GetMapping
    private ResponseEntity<List<HotelRoomTO>> getAvailableRooms(){
        return ResponseEntity.ok(hotelRoomService.getAvailableRooms());
    }

    @GetMapping("/{id}")
    private ResponseEntity<HotelRoomTO> getRoomDetails(@PathVariable Long id){
        return ResponseEntity.ok(hotelRoomService.getRoomDetails(id));
    }

    @PostMapping
    private ResponseEntity<HotelRoomTO> createRoom(@RequestBody HotelRoomTO hotelRoomTO){
        return new ResponseEntity<>(hotelRoomService.createRoom(hotelRoomTO), HttpStatus.CREATED);
    }

    // FIXME Este endpoint en lugar de actualizar, crea un nuevo registro
    @PutMapping("/{id}")
    private ResponseEntity<HotelRoomTO> updateRoom(@PathVariable Long id, @RequestBody HotelRoomTO hotelRoomTO){
        return ResponseEntity.ok(hotelRoomService.updateRoom(id, hotelRoomTO));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Boolean> deleteRoom(@PathVariable Long id){
        return new ResponseEntity<>(hotelRoomService.deleteRoom(id),HttpStatus.NO_CONTENT);
    }


}
