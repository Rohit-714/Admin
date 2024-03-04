package com.hostel.admin.service.serviceImpl;

import com.hostel.admin.dto.room.RoomDto;
import com.hostel.admin.dto.room.UserDto;
import com.hostel.admin.entity.Room;
import com.hostel.admin.entity.User;
import com.hostel.admin.repository.RoomRepo;
import com.hostel.admin.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RoomRepo roomRepo;

    @Override
    public RoomDto saveUpdateRoom(RoomDto roomDto) {
        // Map RoomDto to Room
        Room room = modelMapper.map(roomDto, Room.class);

        // Clear existing occupants to avoid duplicates
        if (room.getOccupants() != null) {
            room.getOccupants().clear();
        }

        // Set bidirectional relationship
        if (roomDto.getOccupants() != null && !roomDto.getOccupants().isEmpty()) {
            for (UserDto occupantDto : roomDto.getOccupants()) {
                User occupant = modelMapper.map(occupantDto, User.class);
                occupant.setRoom(room);
                room.getOccupants().add(occupant);
            }
        }

        // Save the room and occupants
        Room savedRoom = roomRepo.saveAndFlush(room);

        // Map the saved Room back to RoomDto
        RoomDto savedRoomDto = modelMapper.map(savedRoom, RoomDto.class);

        return savedRoomDto;
    }
    @Override
    public List<RoomDto> getRooms() {
        List<Room> rooms = roomRepo.findAllRooms();
        List<RoomDto> roomDtos = rooms.stream()
                .map(room -> modelMapper.map(room, RoomDto.class))
                .collect(Collectors.toList());
        return roomDtos;
    }

    @Override
    public void removeRoom(Long id) {
        roomRepo.deleteById(id);
    }
    @Override
    public RoomDto getRoomByID(Long id)
    {
        Room room=roomRepo.getById(id);
        RoomDto roomDto=modelMapper.map(room,RoomDto.class);
        return  roomDto;
    }

}
