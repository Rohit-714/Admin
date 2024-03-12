package com.hostel.admin.service;

import com.hostel.admin.dto.UserDto;
import com.hostel.admin.dto.userupdate.UserUpdateDto;
import com.hostel.admin.entity.User;

import java.util.List;

public interface UserService {
   UserDto saveUser(User user);
   UserUpdateDto updateUser(Long uid, UserUpdateDto userDto);
   List<UserDto> getUser();
   UserDto getByEmail(String email);
   UserDto getByUid(Long uid);
   Integer removeUser(Long uid);
   UserDto isUserExist(com.hostel.admin.dto.login.UserDto user);
}
