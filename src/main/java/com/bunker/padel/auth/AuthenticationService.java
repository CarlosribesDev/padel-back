package com.bunker.padel.auth;

import com.bunker.padel.config.JwtService;
import com.bunker.padel.model.constants.Role;
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
    private final UserAuthRepository userAuthRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegistrationRequest request) {
        final User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setSurname(request.getSurname());
        user.setUsername(request.getUsername());

        final UserAuth userAuth = new UserAuth();
        userAuth.setUsername(request.getUsername());
        userAuth.setPassword(this.passwordEncoder.encode(request.getPassword()));
        userAuth.setRole(Role.USER);

        this.userRepository.save(user);
        this.userAuthRepository.save(userAuth);
        String jwtToken = this.jwtService.generateToken(userAuth);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
        );

        final UserAuth user = this.userAuthRepository.findByUsername(request.getUsername()).orElseThrow();
        final String jwtToken = this.jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
