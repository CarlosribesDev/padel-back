package com.bunker.padel.auth;

import com.bunker.padel.config.JwtService;
import com.bunker.padel.mapper.UserMapper;
import com.bunker.padel.model.Role;
import com.bunker.padel.model.UserDTO;
import com.bunker.padel.persistence.entity.User;
import com.bunker.padel.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(UserDTO userDTO) {
        User user = this.userMapper.modelToEntity(userDTO);
        user.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(Role.USER);

        this.userRepository.save(user);
        String jwtToken = this.jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
        );

        User user = this.userRepository.findByUsername(request.getUsername()).orElseThrow();

        String jwtToken = this.jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();

    }
}
