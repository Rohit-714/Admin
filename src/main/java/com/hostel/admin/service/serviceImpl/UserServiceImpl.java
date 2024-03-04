package com.hostel.admin.service.serviceImpl;

import com.hostel.admin.dto.UserDto;
import com.hostel.admin.entity.User;
import com.hostel.admin.repository.UserRepo;
import com.hostel.admin.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto saveUpdateUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User usersaved = userRepo.saveAndFlush(user);
        UserDto usercreated = modelMapper.map(usersaved, UserDto.class);
        return usercreated;
    }

    @Override
    public List<UserDto> getUser() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }
    @Override
    public UserDto getUserByID(Long id) {
        User user = userRepo.getById(id);
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public void removeUser(Long id) {
        userRepo.deleteById(id);
    }

}
