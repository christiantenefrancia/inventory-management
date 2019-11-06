package com.inventorymanagement.utilities;

import com.inventorymanagement.entities.Item;
import com.inventorymanagement.entities.Product;
import com.inventorymanagement.model.IncomingItemModel;
import com.inventorymanagement.model.ItemModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceUtils {

  public Item mapFromUpdateItem(IncomingItemModel itemModel, Item item) {
    String tag = itemModel.getProductTag();
    Product product = new Product(itemModel.getProductId());

    item.setProduct(product);
    item.setTag(tag);

    return item;
  }

  public List<ItemModel> mapItemsToModel(List<Item> items) {
    List<ItemModel> itemsModel = new ArrayList<>();

    for (Item item : items) {
      itemsModel.add(mapItemToModel(item));
    }

    return itemsModel;
  }

  public ItemModel mapItemToModel(Item item) {
    ItemModel itemModel = new ItemModel();
    Product product = item.getProduct();
    itemModel.setItemId(item.getId());
    itemModel.setProductId(product.getId());
    itemModel.setCompany(product.getCompany());
    itemModel.setName(product.getName());
    itemModel.setTag(item.getTag());
    itemModel.setAvailable(item.getAvailable());
    itemModel.setVersion(product.getVersion());
    return itemModel;
  }
}
