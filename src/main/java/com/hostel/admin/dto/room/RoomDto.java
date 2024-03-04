package com.hostel.admin.dto.room;

import com.hostel.admin.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long roomNo;
    private String type;
    private Boolean occupied;
    private List<UserDto> occupants;
}
