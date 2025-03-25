package com.hotelReservationAPI.hotelReservationAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hi")
public class HiController {

    @GetMapping()
    public String sayHi() {
        return "API is running! Un saludo a Jorge y a Chanti (y a todos los demás también menos a los que adoran PHP, a esos no)";
    }
}