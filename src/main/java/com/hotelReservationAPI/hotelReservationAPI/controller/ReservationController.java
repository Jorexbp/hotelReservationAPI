package com.hotelReservationAPI.hotelReservationAPI.controller;

import com.hotelReservationAPI.hotelReservationAPI.dto.ReservationTO;
import com.hotelReservationAPI.hotelReservationAPI.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{id}")
    private ResponseEntity<ReservationTO> getReservation(@PathVariable Long id){
        ReservationTO reservation = reservationService.getReservationById(id);

        if(reservation == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ReservationTO> createReservation(@RequestBody ReservationTO reservationTO){
        ReservationTO reservation =  reservationService.createReservation(reservationTO);

        if(reservation == null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteReservation(@PathVariable Long id){
        if(reservationService.deleteReservation(id))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
