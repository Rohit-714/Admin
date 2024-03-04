package com.hostel.admin.service;

import com.hostel.admin.dto.UserDto;
import java.util.List;

public interface UserService {
   UserDto saveUpdateUser(UserDto userDto);
   List<UserDto> getUser();
   UserDto getUserByID(Long id);
   void removeUser(Long id);
}
