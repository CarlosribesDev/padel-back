package com.bunker.padel.auth;

import com.bunker.padel.model.constants.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody final RegistrationRequest request) {
        return ResponseEntity.ok(this.authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody final AuthenticationRequest request) {
        return ResponseEntity.ok(this.authenticationService.authenticate(request));

    }

    @GetMapping("/{username}")
    public ResponseEntity<Role> getRole(@PathVariable final String username) {
        return ResponseEntity.ok(this.authenticationService.getUserRole(username));

    }
}
