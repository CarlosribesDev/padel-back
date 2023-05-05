package com.bunker.padel.persistence.specifications;

import com.bunker.padel.persistence.entity.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class UserSpecifications {

    public static Specification<User> byUsername(List<String> usernames) {
        return (root, criteriaQuery, criteriaBuilder) -> {
                if(usernames == null) {
                    return null;
                }
             return criteriaBuilder.in(root.get("username")).value(usernames);
        };
    }
}
