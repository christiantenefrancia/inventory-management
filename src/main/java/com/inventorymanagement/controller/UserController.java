package com.inventorymanagement.controller;

import com.inventorymanagement.model.UserModel;
import com.inventorymanagement.service.UserServiceInterface;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

  private static final Logger LOG = Logger.getLogger(UserController.class);

  @Autowired
  UserServiceInterface userService;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<UserModel> getAll() {
    LOG.info("Request received to get all user");
    List<UserModel> users = userService.getAllUsers();
    LOG.info("Request to get all successful");
    return users;
  }

}
