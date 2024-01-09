package com.phoenix.Phoenixprojectwork.serviceImpl;

import com.phoenix.Phoenixprojectwork.dto.AuthenticationRequest;
import com.phoenix.Phoenixprojectwork.dto.AuthenticationResponse;
import com.phoenix.Phoenixprojectwork.repository.UserRepository;
import com.phoenix.Phoenixprojectwork.security.JwtService;
import com.phoenix.Phoenixprojectwork.services.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUserName(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByUserName(authenticationRequest.getUserName())
                .orElseThrow(() -> new UsernameNotFoundException("user doesnot exists"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
