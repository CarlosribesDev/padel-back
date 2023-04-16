package com.bunker.padel.service;

import com.bunker.padel.mapper.UserMapper;
import com.bunker.padel.model.UserDTO;
import com.bunker.padel.persistence.entity.User;
import com.bunker.padel.persistence.repository.UserRepository;
import com.bunker.padel.persistence.specifications.UserSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseServiceImpl<User, Long, UserDTO> {

    protected UserService(final UserRepository userRepository, final UserMapper userMapper) {
        super(userRepository, userMapper);
    }

    @Override
    public List<UserDTO> findAll(final Map<String, String> filters) {
        Specification<User> specification = Specification.where(null);

        if(filters.containsKey("usernames") && filters.get("usernames").length() > 0) {
            final List<String> usernames = List.of(filters.get("usernames").split(","));
            specification = specification.and(UserSpecifications.byUsername(usernames));
        }

        final List<User> entities = this.repository.findAll(specification);
        return this.entityMapper.entitiesToDTOs(entities);
    }
}
