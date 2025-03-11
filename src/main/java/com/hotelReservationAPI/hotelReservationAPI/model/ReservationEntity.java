package com.hotelReservationAPI.hotelReservationAPI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customerName", nullable = false)
    private String customerName;

    @Column(name = "checkInDate", nullable = false, insertable = false)
    private LocalDateTime checkInDate;

    @Column(name = "checkOutDate", nullable = false)
    private LocalDateTime checkOutDate;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false, insertable = false)
    private HotelRoomEntity hotelRoom;
}
