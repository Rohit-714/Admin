package com.hostel.admin.service;

import com.hostel.admin.dto.UserDto;
import java.util.List;

public interface UserService {
   UserDto saveUpdateUser(UserDto userDto);
   List<UserDto> getUser();
   UserDto getByEmail(String email);
   void removeUser(Long id);
   UserDto isUserExist(com.hostel.admin.dto.login.UserDto user);
}
