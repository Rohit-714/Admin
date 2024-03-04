package com.hostel.admin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/micro")
public class HomeController {
@GetMapping("/home")
    private HttpStatus homepage()
{
    return HttpStatus.OK;
}
}
