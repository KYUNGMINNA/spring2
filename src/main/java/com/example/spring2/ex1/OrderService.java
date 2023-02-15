package com.example.spring2.ex1;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
