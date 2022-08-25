/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.epam.training.fooddelivery.api;

import com.epam.training.fooddelivery.model.CartModel;
import com.epam.training.fooddelivery.model.OrderModel;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-08-25T23:23:26.741787800+02:00[Europe/Warsaw]")
@Validated
@Api(value = "orderservice", description = "the orderservice API")
public interface OrderserviceApi {

    /**
     * POST /orderservice/orders : The created order from the cart
     * Place a new order in the store
     *
     * @param cartModel Cart to place an order (required)
     * @return Created order (status code 201)
     *         or The Cart is empty (status code 400)
     */
    @ApiOperation(value = "The created order from the cart", nickname = "createOrder", notes = "Place a new order in the store", response = OrderModel.class, tags={ "order-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created order", response = OrderModel.class),
        @ApiResponse(code = 400, message = "The Cart is empty") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/orderservice/orders",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<OrderModel> createOrder(@ApiParam(value = "Cart to place an order", required = true) @Valid @RequestBody CartModel cartModel);


    /**
     * GET /orderservice/orders/{orderId} : Find purchase order by ID
     *
     * @param orderId ID of order that needs to be fetched (required)
     * @return successful operation (status code 200)
     *         or The order exists but does not belong to the authenticated customer (status code 403)
     *         or The order does not exist (status code 404)
     */
    @ApiOperation(value = "Find purchase order by ID", nickname = "getOrderById", notes = "", response = OrderModel.class, tags={ "order-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = OrderModel.class),
        @ApiResponse(code = 403, message = "The order exists but does not belong to the authenticated customer"),
        @ApiResponse(code = 404, message = "The order does not exist") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/orderservice/orders/{orderId}",
        produces = { "application/json" }
    )
    ResponseEntity<OrderModel> getOrderById(@ApiParam(value = "ID of order that needs to be fetched", required = true) @PathVariable("orderId") Long orderId);


    /**
     * GET /orderservice/orders : List of authenticated customer&#39;s orders
     * List of authenticated customer&#39;s orders
     *
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "List of authenticated customer's orders", nickname = "listAllOrders", notes = "List of authenticated customer's orders", response = OrderModel.class, responseContainer = "List", tags={ "order-controller", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = OrderModel.class, responseContainer = "List") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/orderservice/orders",
        produces = { "application/json" }
    )
    ResponseEntity<List<OrderModel>> listAllOrders();

}
