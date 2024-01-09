package com.phoenix.Phoenixprojectwork.serviceImpl;

import com.phoenix.Phoenixprojectwork.dto.RoleDto;
import com.phoenix.Phoenixprojectwork.model.Role;
import com.phoenix.Phoenixprojectwork.repository.RoleRepository;
import com.phoenix.Phoenixprojectwork.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Boolean createRole(RoleDto roleDto) {
        Role role = Role.builder()
                .name(roleDto.getName())
                .build();
        roleRepository.save(role);
        return true;
    }
}
