package com.techelevator.controller;

import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isAuthenticated()")
public class AmenitiesController {
}
