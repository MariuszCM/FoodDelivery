package com.training.fooddelivery.converter;

import com.training.fooddelivery.domain.Order;
import com.training.fooddelivery.model.OrderModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SingleOrderModelConverter implements Converter<Order, OrderModel> {

    private OrderItemListConverter orderItemListConverter;

    public SingleOrderModelConverter(OrderItemListConverter orderItemListConverter) {
        this.orderItemListConverter = orderItemListConverter;
    }

    @Override
    public OrderModel convert(Order order) {
        System.out.println(order.toString());
        OrderModel orderModel = new OrderModel();
        orderModel.setId(order.getId());
        orderModel.setPrice(order.getPrice().doubleValue());
        orderModel.setTimestampCreated(order.getTimestampCreated().toLocalDate());
        orderModel.setOrderItemModels(orderItemListConverter.convert(order.getOrderItems()));
        return orderModel;
    }
}
