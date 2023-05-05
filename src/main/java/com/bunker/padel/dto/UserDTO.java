package com.bunker.padel.dto;

import lombok.Data;

import java.util.List;


@Data
public class UserDTO implements JsonDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private List<BookingDTO> bookings;
}


