package com.hostel.admin.service;

import com.hostel.admin.dto.room.RoomDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface RoomService {
    @Transactional
    RoomDto saveUpdateRoom(RoomDto roomDto);
    List<RoomDto> getRooms();
    RoomDto getRoomByID(Long id);
    void removeRoom(Long id);
}
