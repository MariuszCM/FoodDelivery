package com.epam.training.fooddelivery.model;

import java.util.Objects;
import com.epam.training.fooddelivery.model.FoodModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderItemModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-25T23:23:26.741787800+02:00[Europe/Warsaw]")
public class OrderItemModel   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("pieces")
  private Integer pieces;

  @JsonProperty("price")
  private Double price;

  @JsonProperty("foodModel")
  private FoodModel foodModel;

  public OrderItemModel id(Long id) {
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

  public OrderItemModel pieces(Integer pieces) {
    this.pieces = pieces;
    return this;
  }

  /**
   * Get pieces
   * @return pieces
  */
  @ApiModelProperty(example = "198772", value = "")


  public Integer getPieces() {
    return pieces;
  }

  public void setPieces(Integer pieces) {
    this.pieces = pieces;
  }

  public OrderItemModel price(Double price) {
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

  public OrderItemModel foodModel(FoodModel foodModel) {
    this.foodModel = foodModel;
    return this;
  }

  /**
   * Get foodModel
   * @return foodModel
  */
  @ApiModelProperty(value = "")

  @Valid

  public FoodModel getFoodModel() {
    return foodModel;
  }

  public void setFoodModel(FoodModel foodModel) {
    this.foodModel = foodModel;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemModel orderItemModel = (OrderItemModel) o;
    return Objects.equals(this.id, orderItemModel.id) &&
        Objects.equals(this.pieces, orderItemModel.pieces) &&
        Objects.equals(this.price, orderItemModel.price) &&
        Objects.equals(this.foodModel, orderItemModel.foodModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, pieces, price, foodModel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItemModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    pieces: ").append(toIndentedString(pieces)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    foodModel: ").append(toIndentedString(foodModel)).append("\n");
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

