package com.hostel.admin.controller;

import com.hostel.admin.dto.room.RoomDto;
import com.hostel.admin.response.ResponseHandler;
import com.hostel.admin.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/room")
    public ResponseEntity<Object> addRoom(@RequestBody RoomDto roomDto) {
        try {
            RoomDto room = roomService.saveUpdateRoom(roomDto);
            return ResponseHandler.generateResponse("Room added", HttpStatus.CREATED, room);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("can't add Room", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @GetMapping("/room")
    public ResponseEntity<Object> getRooms() {
        try {
            List<RoomDto> rooms = roomService.getRooms();
            return ResponseHandler.generateResponse("List of rooms is generated", HttpStatus.OK, rooms);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Can't able to generate list", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Object> getRoomByID(@PathVariable Long id) {
        try {
            RoomDto rooms = roomService.getRoomByID(id);
            return ResponseHandler.generateResponse("Room detail is generated", HttpStatus.OK, rooms);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Can't able to generate Detail", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Object> deleteRooms(@PathVariable Long id) {
        try {
            roomService.removeRoom(id);
            return ResponseHandler.generateResponse("Room deleted", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Can't able to delete room", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @PatchMapping("/room")
    public ResponseEntity<Object> udpateRoom(@RequestBody RoomDto roomDto) {
        try {
            RoomDto room = roomService.saveUpdateRoom(roomDto);
            return ResponseHandler.generateResponse("Room Updated", HttpStatus.CREATED, room);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("can't update Room", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }
}
