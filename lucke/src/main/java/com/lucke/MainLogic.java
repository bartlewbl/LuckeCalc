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
import java.nio.channels.FileLock;
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
    GivePrice givePrice;

    String tickerToShort[];
    public MainLogic (TextInterface _textInterface){
        eWrapperImpl = new EWrapperImpl(_textInterface);
        readerSignal = new EJavaSignal();
        client = new EClientSocket(eWrapperImpl, readerSignal);
        ordersAndContracts = new OrdersContracts();
        
        final EReader reader = new EReader(client, readerSignal);
        reader.start();
        textInterface = _textInterface;
        dataAnalysis = new DataAnalysis(_textInterface);
        givePrice = new GivePrice();
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

    public void checkForCommand () {
        String currentTextInTextArea2 = textInterface.getTextArea2();
        String[] currentTextArray = new String [10];


        currentTextArray = currentTextInTextArea2.split(" ");
        textInterface.setTextArea2("");
        if (currentTextArray[0].trim().compareTo("price") == 0){
            getTickerPriceAndShow(currentTextArray[1]);
        }
        else if (currentTextArray[0].trim().compareTo("start")== 0){
            if (currentTextArray[1].trim().compareTo("gap") == 0 || currentTextArray[1].trim().compareTo("lucke") == 0 ){

                if(currentTextArray[2].trim().compareTo("1") == 0){
                    getData(true,false);
                }
                else {
                    getData(false,false);
                }
                
            }
            
            
        }
        else {
            textInterface.setTextArea1("No such command!");
        }




        
    }

    public void placeOrderFct(String ticker){
        client.placeOrder(giveNextOrderId(), ordersAndContracts.giveContract(ticker), ordersAndContracts.giveOrder());
    }
    public void getData (boolean showPrices, boolean shouldShort){
        
        try {
            tickerToShort = dataAnalysis.giveTickerPrice(showPrices);
        }
        catch (IOException o){
            textInterface.setTextArea1("Couldnt transfer Stringarray with tickers to short!");
        }
        if (shouldShort == true){
            for (int i = 0; i < 10;i++){
                if (tickerToShort[i] != null){
                    try {
                        Stock stock = YahooFinance.get(tickerToShort[i]);
                        
                        textInterface.setTextArea1("Shorting " + tickerToShort[i] + " " + stock.getQuote().getPrice());
                        
                        
                    }
                    catch(IOException o){
    
                    }
                    
                    
                    placeOrderFct(tickerToShort[i]);
                }
            }
        }
        
    }
    public void getTickerPriceAndShow (String s){
        
       
        textInterface.setTextArea1(givePrice.givecurrentPriceAndTicker(s).toString());
    }
}

