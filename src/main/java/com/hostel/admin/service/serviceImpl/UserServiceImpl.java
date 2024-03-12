package com.hostel.admin.service.serviceImpl;

import com.hostel.admin.dto.UserDto;
import com.hostel.admin.dto.userupdate.UserUpdateDto;
import com.hostel.admin.entity.User;
import com.hostel.admin.exception.UserAlreadyExistException;
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
    public UserDto saveUser(User user) {
   if(userRepo.getByEmail(user.getEmail())!=null)
     {  throw new UserAlreadyExistException("User already exist.");}
        User usersaved = userRepo.saveAndFlush(user);
        UserDto usercreated = modelMapper.map(usersaved, UserDto.class);
        return usercreated;
    }

    @Override
    public UserUpdateDto updateUser(String email, UserUpdateDto userDto) {
        User user = userRepo.getByEmail(email);
        if (user == null) {
            throw new UserAlreadyExistException("User does'nt exist.");
        }
        if(userDto.getEmail()!=null)user.setEmail(userDto.getEmail());
        if(userDto.getPassword()!=null)user.setPassword(userDto.getPassword());
        if (userDto.getName() != null) user.setName(userDto.getName());
        if (userDto.getAddress() != null) user.setAddress(user.getAddress());
        if (userDto.getCNo() != null) user.setCNo(userDto.getCNo());
        User usersaved = userRepo.save(user);
        UserUpdateDto usercreated = modelMapper.map(usersaved, UserUpdateDto.class);
        return usercreated;
    }
    @Override
    public List<UserDto> getUser() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }
    @Override
    public UserDto getByEmail(String email) {
        User user = userRepo.getByEmail(email);
        UserDto userDto = modelMapper.map(user,UserDto.class);
        return userDto;
    }

    @Override
    public void removeUser(String email) {
        userRepo.deleteByEmail(email);
    }

    @Override
    public UserDto isUserExist(com.hostel.admin.dto.login.UserDto user) {
        String email = user.getEmail();
        String password = user.getPassword();
        User usergetted = userRepo.findByEmailAndPassword(email, password);
        UserDto userDto = modelMapper.map(usergetted, UserDto.class);
        return userDto;
    }

}
