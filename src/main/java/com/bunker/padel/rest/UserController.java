package com.bunker.padel.rest;

import com.bunker.padel.model.UserDTO;
import com.bunker.padel.persistence.entity.UserEntity;
import com.bunker.padel.service.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserEntity, Long, UserDTO> {
    protected UserController(UserService service) {
        super(service);
    }
}
