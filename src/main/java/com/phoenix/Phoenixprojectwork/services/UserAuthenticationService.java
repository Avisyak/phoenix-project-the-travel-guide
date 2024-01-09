package com.phoenix.Phoenixprojectwork.services;

import com.phoenix.Phoenixprojectwork.dto.AuthenticationRequest;
import com.phoenix.Phoenixprojectwork.dto.AuthenticationResponse;

public interface UserAuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
