package com.hostel.admin.controller;

import com.hostel.admin.dto.RequestDto;
import com.hostel.admin.entity.Request;
import com.hostel.admin.response.ResponseHandler;
import com.hostel.admin.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RequestController {
    @Autowired
    RequestService requestService;

    @PostMapping("/request/{uid}")
    public ResponseEntity<Object> addRequest(@PathVariable Long uid,@RequestBody Request requestDto) {
        try {

            RequestDto request = requestService.createRequest(requestDto,uid);
            return ResponseHandler.generateResponse("request added", HttpStatus.CREATED, request);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("can't add request", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @GetMapping("/request")
    public ResponseEntity<Object> getRequest() {
        try {
            List<RequestDto> requestDto = requestService.getRequest();
            return ResponseHandler.generateResponse("List of rooms is generated", HttpStatus.OK, requestDto);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Can't able to generate list", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @GetMapping("/request/{id}")
    public ResponseEntity<Object> getRequestByID(@PathVariable Long id) {
        try {
            RequestDto request = requestService.getRequestById(id);
            return ResponseHandler.generateResponse("Room detail is generated", HttpStatus.OK, request);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Can't able to generate Detail", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @PutMapping("/request/feedback/{id}")
    public ResponseEntity<Object> addFeedback(@PathVariable Long id, @RequestBody String feedback) {
        try {
            RequestDto request = requestService.addFeedback(id, feedback);
            return ResponseHandler.generateResponse("Room detail is generated", HttpStatus.OK, request);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Can't able to generate Detail", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @DeleteMapping("/request/{id}")
    public ResponseEntity<Object> deleteRequest(@PathVariable Long id) {
        try {
            requestService.removeRequest(id);
            return ResponseHandler.generateResponse("Room deleted", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Can't able to delete room", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }
}
