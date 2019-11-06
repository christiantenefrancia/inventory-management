package com.inventorymanagement.utilities;

import com.inventorymanagement.entities.User;
import com.inventorymanagement.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceUtils {

  public List<UserModel> mapUsersToModels(List<User> users) {
    List<UserModel> userModels = new ArrayList<>();

    for (User user : users) {
      userModels.add(mapUser(user));
    }
    return userModels;
  }

  public UserModel mapUser(User user) {
    UserModel userModel = new UserModel();
    userModel.setId(user.getId());
    userModel.setName(user.getName());
    userModel.setEmail(user.getEmail());
    return userModel;
  }

}
