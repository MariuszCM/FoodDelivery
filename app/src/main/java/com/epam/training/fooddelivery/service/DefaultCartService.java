package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Cart;
import com.epam.training.fooddelivery.domain.Customer;
import com.epam.training.fooddelivery.domain.Food;
import com.epam.training.fooddelivery.domain.OrderItem;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Service
public class DefaultCartService implements CartService {
    @Transactional
    @Override
    public void updateCart(Customer customer, Food food, int pieces) {
        Cart cart = customer.getCart();
        List<OrderItem> cartOrderItems = cart.getOrderItems();
        for (int i = 0; i < cartOrderItems.size(); i++) {
            if (food.getName().equals(cartOrderItems.get(i).getFood().getName())) {
                setNewPriceOfCart(food, pieces, cart, i);
                if (pieces == 0) {
                    cartOrderItems.remove(i);
                    return;
                }
                setNewPriceOrderItem(food, pieces, cart, cartOrderItems, i);
                return;
            }
        }
        addNewItemToCart(customer, cart, food, cartOrderItems, pieces);
    }

    private void setNewPriceOrderItem(Food food, int pieces, Cart cart, List<OrderItem> cartOrderItems, int i) {
        cartOrderItems.get(i).setPieces(pieces);
        cartOrderItems.get(i).setPrice(food.getPrice().multiply(BigDecimal.valueOf(pieces)));
        cart.setOrderItems(cartOrderItems);
    }

    private void setNewPriceOfCart(Food food, int pieces, Cart cart, int i) {
        int subtractionAmount = pieces - cart.getOrderItems().get(i).getPieces();
        BigDecimal priceCart = cart.getPrice().add(food.getPrice().multiply(BigDecimal.valueOf(subtractionAmount)));
        cart.setPrice(priceCart);
    }

    private void addNewItemToCart(Customer customer, Cart cart, Food food, List<OrderItem> cartOrderItems, int pieces) {
        BigDecimal priceCart = cart.getPrice().add(food.getPrice().multiply(BigDecimal.valueOf(pieces)));
        BigDecimal itemPrice = food.getPrice().multiply(BigDecimal.valueOf(pieces));
        OrderItem orderItem = new OrderItem(pieces, itemPrice, food);
        cartOrderItems.add(orderItem);
        cart.setOrderItems(cartOrderItems);
        cart.setPrice(priceCart);
        customer.setCart(cart);
    }
}
