/*
package com.inventorymanagement.service;

import com.inventorymanagement.constants.Constants;
import com.inventorymanagement.model.IncomingUserModel;
import com.inventorymanagement.model.LoginResponseModel;
import com.inventorymanagement.model.UserModel;
import com.inventorymanagement.utilities.OAuthServiceUtils;
import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.ForbiddenException;
import inti.ws.spring.exception.client.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.security.Principal;
import java.util.HashMap;

*/
/**
 * @see OAuthServiceInterface
 * @author manrajsingh
 *
 *//*

@Service
public class OAuthServiceImpl implements OAuthServiceInterface {

  */
/**
   * {@link OAuthServiceUtils}
   *//*

  @Autowired
  private OAuthServiceUtils oauthServiceUtils;

  */
/*
   * (non-Javadoc)
   * 
   * @see inventorymanagement.service.OAuthServiceInterface#authenticate(java.security.Principal,
   * javax.servlet.http.HttpSession)
   *//*

  @Override
  @Transactional
  public LoginResponseModel authenticate(Principal principal, HttpSession session)
      throws UnauthorizedException, ForbiddenException, BadRequestException {

    if (principal == null) {
      throw new ForbiddenException("Access denied");
    }

    OAuth2Authentication oauth = (OAuth2Authentication) principal;

    if (oauth.isAuthenticated()) {
      @SuppressWarnings("unchecked")
      HashMap<String, String> details =
          (HashMap<String, String>) oauth.getUserAuthentication().getDetails();

      String domain = details.get(Constants.DOMAIN_KEY);

      if (!(Constants.ALLOW_DOMAIN).equalsIgnoreCase(domain)) {
        throw new UnauthorizedException("Unauthorized access");
      }

      String email = details.get(Constants.EMAIL_KEY);
      String name = details.get(Constants.NAME_KEY);
      String picture = details.get(Constants.PICTURE_KEY);

      IncomingUserModel user = new IncomingUserModel(name, email);

      UserModel userModel = oauthServiceUtils.addUserIfNotExist(user);

      String id = Integer.toString(userModel.getId());

      session.setAttribute(Constants.SESSION_EMAIL, email);
      session.setAttribute(Constants.SESSION_NAME, name);
      session.setAttribute(Constants.SESSION_ID, id);
      session.setAttribute(Constants.SESSION_PICTURE, picture);

      Boolean admin = oauthServiceUtils.checkIfAdmin(userModel);

      session.setAttribute(Constants.SESSION_ADMIN, admin);
      LoginResponseModel loginResponse = new LoginResponseModel();
      loginResponse.setEmail(email);
      loginResponse.setId(id);
      loginResponse.setName(name);
      loginResponse.setPicture(picture);
      loginResponse.setAdmin(admin);

      return loginResponse;
    } else {
      throw new UnauthorizedException("Login failed");
    }
  }
}
*/
