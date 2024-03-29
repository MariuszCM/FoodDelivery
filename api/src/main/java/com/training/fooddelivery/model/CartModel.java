package com.training.fooddelivery.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

/**
 * CartModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-26T23:41:58.811663200+02:00[Europe/Warsaw]")
public class CartModel   {
  @JsonProperty("price")
  private Double price;

  @JsonProperty("orderItemModels")
  @Valid
  private List<OrderItemModel> orderItemModels = null;

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

  public CartModel orderItemModels(List<OrderItemModel> orderItemModels) {
    this.orderItemModels = orderItemModels;
    return this;
  }

  public CartModel addOrderItemModelsItem(OrderItemModel orderItemModelsItem) {
    if (this.orderItemModels == null) {
      this.orderItemModels = new ArrayList<>();
    }
    this.orderItemModels.add(orderItemModelsItem);
    return this;
  }

  /**
   * Get orderItemModels
   * @return orderItemModels
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<OrderItemModel> getOrderItemModels() {
    return orderItemModels;
  }

  public void setOrderItemModels(List<OrderItemModel> orderItemModels) {
    this.orderItemModels = orderItemModels;
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
        Objects.equals(this.orderItemModels, cartModel.orderItemModels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, orderItemModels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartModel {\n");
    
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    orderItemModels: ").append(toIndentedString(orderItemModels)).append("\n");
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

