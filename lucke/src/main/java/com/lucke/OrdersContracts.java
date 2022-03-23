package com.lucke;


import com.ib.client.Order;
import com.ib.client.EWrapper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.io.*;
import com.ib.client.*;
public class OrdersContracts {
    public OrdersContracts (){
        
    }




    public Order giveOrder (){
        Order order1 = new Order();
        order1.action("BUY");
        order1.orderType("MKT");
        order1.totalQuantity(-1);
        return order1;
    }
    public Contract giveContract (String ticker){
        Contract contract1 = new Contract ();
        contract1.symbol (ticker);  
        contract1.secType ("STK");
        contract1.exchange("NASDAQ");
        contract1.currency ("USD");  
        
        return contract1;
    }
}
