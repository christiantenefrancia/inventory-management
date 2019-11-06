package com.inventorymanagement.service;

import com.inventorymanagement.dao.UserDaoInterface;
import com.inventorymanagement.entities.User;
import com.inventorymanagement.model.UserModel;
import com.inventorymanagement.utilities.UserServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @see UserServiceInterface
 * @author manrajsingh
 *
 */
@Service
public class UserServiceImpl implements UserServiceInterface {

  /**
   * {@link UserDaoInterface}
   */
  @Autowired
  UserDaoInterface userDaoImpl;

  /**
   * {@link UserServiceUtils}
   */
  @Autowired
  UserServiceUtils userUtils;

  /*
   * (non-Javadoc)
   * 
   * @see inventorymanagement.service.UserServiceInterface#getAllUsers()
   */
  @Override
  @Transactional
  public List<UserModel> getAllUsers() {
    List<User> users = userDaoImpl.getAll();
    List<UserModel> usersModel = userUtils.mapUsersToModels(users);
    return usersModel;
  }

}
