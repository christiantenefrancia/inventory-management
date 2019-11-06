package com.inventorymanagement.service;

import com.inventorymanagement.constants.Constants;
import com.inventorymanagement.dao.RequestDaoInterface;
import com.inventorymanagement.entities.Product;
import com.inventorymanagement.entities.Request;
import com.inventorymanagement.entities.User;
import com.inventorymanagement.model.IncomingRequestModel;
import com.inventorymanagement.model.IncomingUpdateRequest;
import com.inventorymanagement.model.RequestModel;
import com.inventorymanagement.utilities.RequestServiceUtils;
import inti.ws.spring.exception.client.BadRequestException;
import inti.ws.spring.exception.client.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RequestServiceImpl implements RequestServiceInterface {

  @Autowired
  RequestDaoInterface requestDaoImpl;

  @Autowired
  RequestServiceUtils requestUtils;

  @Override
  @Transactional
  public RequestModel addRequest(IncomingRequestModel requestModel) throws BadRequestException {

    if (requestModel.getUserId() <= 0 || requestModel.getProductId() <= 0) {
      throw new BadRequestException("Required parameters are either missing or invalid");
    }

    User user = new User(requestModel.getUserId());
    Product product = new Product(requestModel.getProductId());
    String reply = "";

    Request request = new Request(user, product, reply);

    requestDaoImpl.save(request);
    requestDaoImpl.refresh(request);

    RequestModel rm = new RequestModel(request, Constants.REQUEST_CREATED_MESSAGE);

    return rm;
  }

  @Override
  @Transactional
  public List<RequestModel> getAllRequests() {
    List<Request> requests = requestDaoImpl.getAll();
    List<RequestModel> requestModel = requestUtils.mapRequestsToModel(requests);
    return requestModel;
  }

  @Override
  @Transactional
  public RequestModel getRequestById(int id) throws BadRequestException, NotFoundException {
    if (id <= 0) {
      throw new BadRequestException("Required parameters are either missing or invalid");
    }
    try {
      Request request = requestDaoImpl.getById(id);
      RequestModel requestModel = requestUtils.mapRequest(request);
      return requestModel;
    } catch (Exception e) {
      throw new NotFoundException("Request with given ID does not exist");
    }
  }

  @Override
  @Transactional
  public RequestModel updateRequest(int id, IncomingUpdateRequest requestModel)
      throws BadRequestException, NotFoundException {

    if (requestModel.getReply() == null || requestModel.getReply().equals("")) {
      throw new BadRequestException("Required parameters are either missing or invalid");
    }
    try {
      Request request = requestDaoImpl.getById(id);

      requestUtils.mapFromUpdateRequest(requestModel, request);
      requestDaoImpl.update(request);
      RequestModel rm = new RequestModel(request, Constants.REQUEST_UPDATED_MESSAGE);
      return rm;
    } catch (Exception e) {
      throw new NotFoundException("Request with given ID does not exist");
    }
  }

  @Override
  @Transactional
  public List<RequestModel> getRequestByUserId(int id) throws BadRequestException {
    if (id <= 0) {
      throw new BadRequestException("Required parameters are either missing or invalid");
    }

    List<Request> request = requestDaoImpl.getByUserId(id);
    List<RequestModel> requestModel = requestUtils.mapRequestsToModel(request);
    return requestModel;
  }

}
