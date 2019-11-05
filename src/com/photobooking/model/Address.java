package com.photobooking.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Address {

    @NotEmpty
    private long id;

    @NotEmpty
    private String street;

    @NotEmpty
    private String zipCode;

    @NotEmpty
    private String city;

    @NotEmpty
    @Pattern(regexp = "[A-Z]{2}") //expects 2 uppercase alphabet characters
    private String state;


}
