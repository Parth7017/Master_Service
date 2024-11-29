package org.nexgen.master.service;

import org.nexgen.master.module.UserResponse;

import java.util.List;

public interface UserService {
   public List<UserResponse> getAllActiveUsers();
}
