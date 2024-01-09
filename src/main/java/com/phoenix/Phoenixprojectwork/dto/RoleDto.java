package com.phoenix.Phoenixprojectwork.dto;

import com.phoenix.Phoenixprojectwork.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Integer id;
    private String name;
    private String description;
    private boolean isActive;
    private List<User> userList;
}
