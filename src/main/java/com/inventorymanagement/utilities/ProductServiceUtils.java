package com.inventorymanagement.utilities;

import com.inventorymanagement.entities.Product;
import com.inventorymanagement.model.IncomingProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceUtils {

  public Product mapFromUpdateProduct(IncomingProductModel productModel, Product product) {
    String name = productModel.getName();
    String company = productModel.getCompany();
    String version = productModel.getVersion();

    product.setCompany(company);
    product.setName(name);
    product.setVersion(version);

    return product;
  }

  public List<IncomingProductModel> mapProductsToModel(List<Product> products) {
    List<IncomingProductModel> productModels = new ArrayList<>();

    for (Product product : products) {
      productModels.add(mapProduct(product));
    }

    return productModels;
  }

  public IncomingProductModel mapProduct(Product product) {

    IncomingProductModel productModel = new IncomingProductModel();

    productModel.setId(product.getId());
    productModel.setCompany(product.getCompany());
    productModel.setName(product.getName());
    productModel.setVersion(product.getVersion());

    return productModel;
  }
}
