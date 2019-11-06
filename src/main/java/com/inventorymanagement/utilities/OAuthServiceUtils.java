package com.inventorymanagement.utilities;

import com.inventorymanagement.constants.Constants;
import com.inventorymanagement.dao.UserDaoInterface;
import com.inventorymanagement.dao.UserRoleDaoInterface;
import com.inventorymanagement.entities.Role;
import com.inventorymanagement.entities.User;
import com.inventorymanagement.entities.UserRole;
import com.inventorymanagement.model.IncomingUserModel;
import com.inventorymanagement.model.UserModel;
import com.inventorymanagement.service.UserServiceImpl;
import inti.ws.spring.exception.client.BadRequestException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OAuthServiceUtils {

  private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

  @Autowired
  UserDaoInterface userDaoImpl;

  @Autowired
  UserRoleDaoInterface userRoleDaoImpl;

  public UserModel addUser(IncomingUserModel userModel) throws BadRequestException {
    if (userModel.getName() == null || userModel.getEmail() == null
        || userModel.getName().equals("") || userModel.getEmail().equals("")) {
      throw new BadRequestException("Required parameters are invalid");
    }
    LOG.debug("Parameters are valid");
    String name = userModel.getName();
    String email = userModel.getEmail();
    Role role = new Role(2, "user");
    User user = new User(name, email);
    UserRole userRole = new UserRole(role, user);
    LOG.debug("Saving user");
    userDaoImpl.save(user);
    userRoleDaoImpl.save(userRole);
    userRoleDaoImpl.refresh(userRole);
    userDaoImpl.refresh(user);
    LOG.debug("Saved user and its role");
    UserModel addUser = new UserModel(user, Constants.USER_CREATED_MESSAGE);
    return addUser;
  }

  public UserModel addUserIfNotExist(IncomingUserModel userModel) throws BadRequestException {
    if (userModel.getEmail() == null || userModel.getEmail().equals("")) {
      throw new BadRequestException("Email provided is invalid");
    }

    User user = userDaoImpl.getUserByEmail(userModel.getEmail());
    if (user == null) {
      return addUser(userModel);
    } else {
      UserModel um = new UserModel(user);
      return um;
    }
  }

  public Boolean checkIfAdmin(UserModel userModel) {

    Set<UserRole> roles = userModel.getRole();
    Boolean admin = false;

    for (UserRole userRole : roles) {
      Role role = userRole.getRole();
      if (role.getId() == 1) {
        admin = true;
      }
    }

    return admin;
  }
}
