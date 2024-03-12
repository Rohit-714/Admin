package com.hostel.admin.controller;

import com.hostel.admin.dto.UserDto;
import com.hostel.admin.dto.userupdate.UserUpdateDto;
import com.hostel.admin.entity.User;
import com.hostel.admin.response.ResponseHandler;
import com.hostel.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        try {
            UserDto savedUser = userService.saveUser(user);
            return ResponseHandler.generateResponse("User Created", HttpStatus.OK, savedUser);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY, user);
        }
    }

    @PostMapping("/user/login")
    public ResponseEntity<Object> checkUser(@RequestBody com.hostel.admin.dto.login.UserDto userDto) {
        try {
            UserDto user = userService.isUserExist(userDto);
            return ResponseHandler.generateResponse("login successfull", HttpStatus.OK, user);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Invalid credentials", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }
    @GetMapping("/user")
    public ResponseEntity<Object> getUser() {
        try {
            List<UserDto> users = userService.getUser();
            return ResponseHandler.generateResponse("Users are listed", HttpStatus.OK, users);
        } catch (Exception e) {

            return ResponseHandler.generateResponse("unable to find users", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<Object> getUser(@PathVariable Long uid) {
        try {
            UserDto users = userService.getByUid(uid);
            return ResponseHandler.generateResponse("User are listed", HttpStatus.OK, users);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("unable to find user", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @DeleteMapping("/user/{uid}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long uid) {
        try {
        Integer b =    userService.removeUser(uid);
            return ResponseHandler.generateResponse("User deleted by id", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("User can't delete", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

    @PutMapping("/user/{uid}")
    public ResponseEntity<Object> updateUser(@PathVariable Long uid,@RequestBody UserUpdateDto userDto) {
        try {
            UserUpdateDto savedUser = userService.updateUser(uid,userDto);
            return ResponseHandler.generateResponse("User Created", HttpStatus.OK, savedUser);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("User unable to create", HttpStatus.UNPROCESSABLE_ENTITY, null);
        }
    }

}

