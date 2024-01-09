package com.phoenix.Phoenixprojectwork.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private List<Integer> rolesId;
}
