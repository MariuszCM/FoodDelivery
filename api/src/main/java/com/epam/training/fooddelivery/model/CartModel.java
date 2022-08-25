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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-25T23:29:15.611086100+02:00[Europe/Warsaw]")
public class CartModel   {
  @JsonProperty("price")
  private Double price;

  @JsonProperty("orderItemModel")
  @Valid
  private List<OrderItemModel> orderItemModel = null;

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

  public CartModel orderItemModel(List<OrderItemModel> orderItemModel) {
    this.orderItemModel = orderItemModel;
    return this;
  }

  public CartModel addOrderItemModelItem(OrderItemModel orderItemModelItem) {
    if (this.orderItemModel == null) {
      this.orderItemModel = new ArrayList<>();
    }
    this.orderItemModel.add(orderItemModelItem);
    return this;
  }

  /**
   * Get orderItemModel
   * @return orderItemModel
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<OrderItemModel> getOrderItemModel() {
    return orderItemModel;
  }

  public void setOrderItemModel(List<OrderItemModel> orderItemModel) {
    this.orderItemModel = orderItemModel;
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
        Objects.equals(this.orderItemModel, cartModel.orderItemModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, orderItemModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CartModel {\n");
    
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    orderItemModel: ").append(toIndentedString(orderItemModel)).append("\n");
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

