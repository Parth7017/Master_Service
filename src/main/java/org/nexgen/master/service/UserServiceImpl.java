package org.nexgen.master.service;

import org.nexgen.master.repository.UserRepository;
import org.nexgen.master.module.UserResponse;
import org.nexgen.schema.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public List<UserResponse> getAllActiveUsers() {

        List<User> activeUsers = userRepository.findAllByIsEnabledTrue();

        return activeUsers.stream()
                .map(user -> new UserResponse(user.getId(), user.getUserName()))
                .collect(Collectors.toList());
    }
}
