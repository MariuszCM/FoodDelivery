package com.training.fooddelivery.converter;

import com.training.fooddelivery.domain.Cart;
import com.training.fooddelivery.model.CartModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartModelConverter implements Converter<CartModel, Cart> {

    private OrderItemModelListConverter orderItemModelListConverter;

    public CartModelConverter(OrderItemModelListConverter orderItemModelListConverter) {
        this.orderItemModelListConverter = orderItemModelListConverter;
    }

    @Override
    public Cart convert(CartModel cartModel) {
        Cart cart = new Cart();
        cart.setOrderItems(orderItemModelListConverter.convert(cartModel.getOrderItemModels()));
        cart.setPrice(new BigDecimal(cartModel.getPrice()));
        return cart;
    }
}
