package com.epam.training.fooddelivery.converter;

import com.epam.training.fooddelivery.domain.Cart;
import com.epam.training.fooddelivery.model.CartModel;
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
        cart.setOrderItems(orderItemModelListConverter.convert(cartModel.getOrderItemModel()));
        cart.setPrice(new BigDecimal(cartModel.getPrice()));
        return cart;
    }
}
