package com.epam.training.fooddelivery.model;

import java.util.Objects;
import com.epam.training.fooddelivery.model.OrderItemModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CartModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-25T20:35:02.660236600+02:00[Europe/Warsaw]")
public class CartModel   {
  @JsonProperty("price")
  private Double price;

  @JsonProperty("orderItems")
  @Valid
  private List<OrderItemModel> orderItems = null;

  public CartModel price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(example = "10.21", value = "")


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public CartModel orderItems(List<OrderItemModel> orderItems) {
    this.orderItems = orderItems;
    return this;
  }

  public CartModel addOrderItemsItem(OrderItemModel orderItemsItem) {
    if (this.orderItems == null) {
      this.orderItems = new ArrayList<>();
    }
    this.orderItems.add(orderItemsItem);
    return this;
  }

  /**
   * Get orderItems
   * @return orderItems
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<OrderItemModel> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<OrderItemModel> orderItems) {
    this.orderItems = orderItems;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CartModel cartModel = (CartModel) o;
    return Objects.equals(this.price, cartModel.price) &&
        Objects.equals(this.orderItems, cartModel.orderItems);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, orderItems);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartModel {\n");
    
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    orderItems: ").append(toIndentedString(orderItems)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

