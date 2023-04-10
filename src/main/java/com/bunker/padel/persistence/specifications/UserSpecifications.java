package com.bunker.padel.persistence.specifications;

import com.bunker.padel.persistence.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public static Specification<User> byUsername(String username) {
        return (root, query, cb) -> cb.like(root.get("username"), "%" + username + "%");
    }
}
