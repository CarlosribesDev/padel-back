package com.bunker.padel.params;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserParams implements Serializable {
    final List<String> usernames;
}
