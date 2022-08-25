package com.epam.training.fooddelivery.converter;

import com.epam.training.fooddelivery.domain.Order;
import com.epam.training.fooddelivery.model.OrderModel;
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
        orderModel.setOrderItemsModel(orderItemListConverter.convert(order.getOrderItems()));
        return orderModel;
    }
}
