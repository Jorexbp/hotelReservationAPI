package com.hotelReservationAPI.hotelReservationAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelRoomTO {

    @JsonProperty(value = "number",required = true)
    private Integer number;

    @JsonProperty(value = "type", required = true)
    private String type;

    @JsonProperty(value = "price", required = true)
    private Double price;

    @JsonProperty(value = "available", required = true)
    private Boolean available;
}
