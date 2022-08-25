package com.epam.training.fooddelivery.model;

import java.util.Objects;
import com.epam.training.fooddelivery.model.OrderItemModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-25T23:23:26.741787800+02:00[Europe/Warsaw]")
public class OrderModel   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("timestampCreated")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate timestampCreated;

  @JsonProperty("orderItemModel")
  @Valid
  private List<OrderItemModel> orderItemModel = null;

  public OrderModel id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(example = "10", value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrderModel price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(example = "7.13", value = "")


  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public OrderModel timestampCreated(LocalDate timestampCreated) {
    this.timestampCreated = timestampCreated;
    return this;
  }

  /**
   * Get timestampCreated
   * @return timestampCreated
  */
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getTimestampCreated() {
    return timestampCreated;
  }

  public void setTimestampCreated(LocalDate timestampCreated) {
    this.timestampCreated = timestampCreated;
  }

  public OrderModel orderItemModel(List<OrderItemModel> orderItemModel) {
    this.orderItemModel = orderItemModel;
    return this;
  }

  public OrderModel addOrderItemModelItem(OrderItemModel orderItemModelItem) {
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
    OrderModel orderModel = (OrderModel) o;
    return Objects.equals(this.id, orderModel.id) &&
        Objects.equals(this.price, orderModel.price) &&
        Objects.equals(this.timestampCreated, orderModel.timestampCreated) &&
        Objects.equals(this.orderItemModel, orderModel.orderItemModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, price, timestampCreated, orderItemModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    timestampCreated: ").append(toIndentedString(timestampCreated)).append("\n");
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

