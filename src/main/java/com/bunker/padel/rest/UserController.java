package com.bunker.padel.rest;

import com.bunker.padel.model.UserDTO;
import com.bunker.padel.params.UserParams;
import com.bunker.padel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController  {
    protected final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findBySearch(@ModelAttribute UserParams params)
    {
        return ResponseEntity.ok(userService.findBySearch(params));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
        return ResponseEntity.ok(userService.save(dto));
    }
}
