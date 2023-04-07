package com.bunker.padel.rest;

import com.bunker.padel.model.UserDTO;
import com.bunker.padel.persistence.entity.User;
import com.bunker.padel.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<User, Long, UserDTO> {
    protected UserController(final UserService userService) {
        super(userService);
    }
}
