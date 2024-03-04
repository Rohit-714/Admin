package com.hostel.admin.repository;

import com.hostel.admin.entity.Room;
import com.hostel.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo  extends JpaRepository<Room,Long> {
    @Query("SELECT DISTINCT r FROM Room r LEFT JOIN FETCH r.occupants")
    List<Room> findAllRooms();
    Room findByRoomNo(Long roomNo);
}
