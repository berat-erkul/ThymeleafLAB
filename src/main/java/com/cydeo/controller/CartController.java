package com.cydeo.controller;

import com.cydeo.service.CartService;
import com.cydeo.service.impl.CartServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/cart")
    public String getCart(Model model){

        model.addAttribute("cart", CartServiceImpl.CART);

        return "cart/show-cart";
    }

    @GetMapping("addToCart/{productId}/{quantity}")
    public String addToCart(@PathVariable UUID productId, @PathVariable Integer quantity){

        cartService.addToCart(productId, quantity);

        return "redirect:/cart";
    }

    @GetMapping("/delete/{productId}")
    public String deleteCartItem(@PathVariable UUID productId){

        cartService.deleteFromCart(productId);

        return "redirect:/cart";
    }
}
