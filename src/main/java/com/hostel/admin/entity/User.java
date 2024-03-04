package com.hostel.admin.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String email;
    private String name;
    private String address;
    private Long cNo;
    private Date dateOfJoin;
    @ManyToOne
    @JoinColumn(name = "roomNo")
    private Room room;

    private String password;

}
