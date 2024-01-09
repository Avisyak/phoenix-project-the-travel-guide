package com.phoenix.Phoenixprojectwork.serviceImpl;

import com.phoenix.Phoenixprojectwork.config.CustomMessageSource;
import com.phoenix.Phoenixprojectwork.dto.UserDto;
import com.phoenix.Phoenixprojectwork.model.User;
import com.phoenix.Phoenixprojectwork.repository.UserRepository;
import com.phoenix.Phoenixprojectwork.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CustomMessageSource customMessageSource;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }


}
