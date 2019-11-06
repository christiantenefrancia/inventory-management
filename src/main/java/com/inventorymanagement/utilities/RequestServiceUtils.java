package com.inventorymanagement.utilities;

import com.inventorymanagement.entities.Product;
import com.inventorymanagement.entities.Request;
import com.inventorymanagement.entities.User;
import com.inventorymanagement.model.IncomingUpdateRequest;
import com.inventorymanagement.model.RequestModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RequestServiceUtils {

  public List<RequestModel> mapRequestsToModel(List<Request> requests) {
    List<RequestModel> requestModels = new ArrayList<>();

    for (Request request : requests) {
      requestModels.add(mapRequest(request));
    }
    return requestModels;
  }

  public RequestModel mapRequest(Request request) {
    RequestModel requestModel = new RequestModel();
    requestModel.setReply(request.getReply());
    requestModel.setId(request.getId());
    User user = request.getUser();
    Product product = request.getProduct();
    requestModel.setUserName(user.getName());
    requestModel.setProductCompany(product.getCompany());
    requestModel.setVersion(product.getVersion());
    requestModel.setProductName(product.getName());
    return requestModel;
  }

  public void mapFromUpdateRequest(IncomingUpdateRequest requestModel, Request request) {
    String reply = requestModel.getReply();
    request.setReply(reply);
  }
}
