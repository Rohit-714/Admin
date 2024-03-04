package com.hostel.admin.service.serviceImpl;

import com.hostel.admin.entity.Room;
import com.hostel.admin.entity.User;
import com.hostel.admin.repository.RoomRepo;
import com.hostel.admin.repository.UserRepo;
import com.hostel.admin.service.AllotmentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class AllotmentServiceImpl implements AllotmentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoomRepo roomRepo;
    @Autowired
    private UserRepo userRepo;

    public Room allotRoom(Long roomId, Long uid) {
        Room room = roomRepo.findByRoomNo(roomId);
        User user = userRepo.findById(uid).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + uid));

        // Remove user from existing room
        if (user.getRoom() != null) {
            user.getRoom().getOccupants().remove(user);
        }

        user.setRoom(room);
        room.getOccupants().add(user);

        Room savedRoom = roomRepo.saveAndFlush(room);
        return savedRoom;
    }
    }
