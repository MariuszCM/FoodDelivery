package com.epam.training.fooddelivery.view;

import com.epam.training.fooddelivery.aspect.EnableArgumentLogging;
import com.epam.training.fooddelivery.aspect.EnableExecutionTimeLogging;
import com.epam.training.fooddelivery.aspect.EnableReturnValueLogging;
import com.epam.training.fooddelivery.domain.*;
import com.epam.training.fooddelivery.repository.FoodRepository;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CLIView implements View {

    private static final Scanner scanner = new Scanner(System.in);
    private FoodRepository foodRepository;

    @EnableExecutionTimeLogging
    @EnableReturnValueLogging
    public User readCredentials() {
        User user = new User();
        System.out.print("Enter customer email adress: ");
        user.setEmail(scanner.nextLine());
        System.out.print("Enter customer password: ");
        user.setPassword(scanner.nextLine());
        return user;
    }

    @EnableExecutionTimeLogging
    @EnableArgumentLogging
    public void printWelcomeMessage(Customer customer) {
        System.out.printf("Welcome, %s. ", customer.getName());
        System.out.printf("Your balance is: %.2f.%n", customer.getBalance());
    }

    @EnableExecutionTimeLogging
    @EnableArgumentLogging
    public void printAllFoods(List<Food> foods) {
        System.out.printf("%nThese are our goods today:%n");
        for (Food food : foods) {
            System.out.printf("- %s %.2f EUR each%n", food.getName(), food.getPrice());
        }
    }

    @EnableExecutionTimeLogging
    @EnableArgumentLogging
    @EnableReturnValueLogging
    public Food selectFood(List<Food> foods) {
        String foodName;
        Optional<Food> food= Optional.empty();

        while (food.isEmpty()) {
            System.out.printf(
                    "%nPlease enter the name of the food you would like to buy or delete from the cart:");
            foodName = scanner.nextLine();
            food = foodRepository.findByName(foodName);

            if (food.isEmpty()) {
                printErrorMessage("Invalid input");
            }
        }
        return food.get();
    }

    @EnableExecutionTimeLogging
    @EnableReturnValueLogging
    public int readPieces() {
        System.out.printf(
                "%nHow many pieces do you want to buy? This input overwrites the old value in the cart, "
                        + "entering zero removes the%n"
                        + "item completely:");
        return scanner.nextInt();
    }

    @EnableExecutionTimeLogging
    @EnableArgumentLogging
    public void printAddedToCart(Food food, int pieces) {
        System.out.printf("%nAdded %d piece(s) of %s to the cart.", pieces, food.getName());
    }

    @EnableExecutionTimeLogging
    @EnableArgumentLogging
    public void printCart(Cart cart) {
        System.out.printf("%nThe cart has %.2f EUR of foods:", cart.getPrice());
        cart.getOrderItems().forEach(orderItem -> System.out.printf(
                "%n%s %d piece (s), %.2f EUR total",
                orderItem.getFood().getName(),
                orderItem.getPieces(),
                orderItem.getPrice()));
    }

    @EnableExecutionTimeLogging
    @EnableArgumentLogging
    public void printConfirmOrder(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.printf(
                "Order (items: %s, price: %s EUR, timestamp: %s) has been confirmed. Thank you "
                        + "for your purchase.",
                Arrays.toString(order.getOrderItems()
                        .stream()
                        .map(orderItem -> orderItem.getFood().getName())
                        .toArray()),
                order.getPrice().toString(),
                order.getTimestampCreated().format(formatter));
    }

    @EnableExecutionTimeLogging
    @EnableReturnValueLogging
    public boolean promptOrder() {
        System.out.printf("%nAre you finished with your order? (y/n):");
        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equals("y")) {
                return true;
            }
            if (input.equals("n")) {
                return false;
            }
            printErrorMessage("Invalid input.");
            System.out.printf("%nAre you finished with your order? (y/n):");
        }
    }

    @EnableExecutionTimeLogging
    @EnableArgumentLogging
    public void printErrorMessage(String message) {
        System.out.printf("%n%s", message);
    }
}
