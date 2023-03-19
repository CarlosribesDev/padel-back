package com.bunker.padel.rest;

import com.bunker.padel.model.User;
import com.bunker.padel.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    private ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    };

    @GetMapping(path = "/{id}")
    private ResponseEntity<User> getUserById(final @PathVariable Long id) {
        return ResponseEntity.ok(this.userService.getUserById(id));
    };

    @PutMapping(path = "/{id}")
    private ResponseEntity<User> updateUser(final @RequestBody User user, final @PathVariable Long id) {
        return ResponseEntity.ok(this.userService.updateUser(id, user));
    };

    @PostMapping
    private ResponseEntity<User> addUser(final @RequestBody User user) {
        return ResponseEntity.ok(this.userService.createUser(user));
    };

}
