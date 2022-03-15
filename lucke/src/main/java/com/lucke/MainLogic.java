package com.lucke;


import com.ib.client.EWrapper;

import org.w3c.dom.Text;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.*;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.crypto.Data;

import java.util.Set;
import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import com.ib.client.*;


public class MainLogic {

    EWrapperImpl eWrapperImpl;  
    private EReaderSignal readerSignal;
    EClientSocket client;
    OrdersContracts ordersAndContracts;
    int i = 1;
    TextInterface textInterface;
    DataAnalysis dataAnalysis;

    public MainLogic (TextInterface _textInterface){
        eWrapperImpl = new EWrapperImpl(_textInterface);
        readerSignal = new EJavaSignal();
        client = new EClientSocket(eWrapperImpl, readerSignal);
        ordersAndContracts = new OrdersContracts();
        
        final EReader reader = new EReader(client, readerSignal);
        reader.start();
        textInterface = _textInterface;
        dataAnalysis = new DataAnalysis();
    }


    public void connect(String s, int p1, int p2){
        client.eConnect(s, p1, p2);
        
        
    }

    public void disconnect() {
        client.eDisconnect();
    }

    public int giveNextOrderId(){
        i++;
        client.reqIds(i);
        return i; 
    }

    public void placeOrderFct(){
        client.placeOrder(giveNextOrderId(), ordersAndContracts.giveContract(), ordersAndContracts.giveOrder());
    }
    public void getData (){
        textInterface.setTextArea1(dataAnalysis.getHistoricalData());
    }
}

