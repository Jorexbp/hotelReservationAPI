package com.hotelReservationAPI.hotelReservationAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReservationTO {

    @JsonProperty(value = "customerName", required = true)
    private String customerName;

    @JsonProperty(value = "roomId",required = true)
    private Long roomId;

    @JsonProperty(value = "checkInDate", required = true)
    private LocalDateTime checkInDate;

    @JsonProperty(value = "checkOutDate", required = true)
    private LocalDateTime checkOutDate;
}
