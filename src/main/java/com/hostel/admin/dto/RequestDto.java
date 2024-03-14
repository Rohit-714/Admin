package com.hostel.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    private Integer id;
    private String requestedBy;
    private String reason;
    private String discription;
    private String feedback;
}
