package com.hostel.admin.controller;

import com.hostel.admin.entity.Room;
import com.hostel.admin.response.ResponseHandler;
import com.hostel.admin.service.AllotmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AllotmentController {
    @Autowired
    AllotmentService allotmentService;
    @GetMapping("/allotRoom/{roomId}/{uId}")
    public ResponseEntity<Object> alotRoom(@PathVariable Long roomId, @PathVariable Long uId) {
        try {
            Room room = allotmentService.allotRoom(roomId,uId);
            return ResponseHandler.generateResponse("person added", HttpStatus.CREATED, room);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("can't add person", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }
}
