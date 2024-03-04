package com.hostel.admin.dto;

import com.hostel.admin.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long uid;
    private String email;
    private String name;
    private String address;
    private Long cNo;
    private Date dateOfJoin;
    private Room allotment;
    private String password;

}
