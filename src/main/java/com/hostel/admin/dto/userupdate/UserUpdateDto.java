package com.hostel.admin.dto.userupdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
    private Long uid;
    private String email;
    private String name;
    private String address;
    private Long cNo;
    private String password;

}
