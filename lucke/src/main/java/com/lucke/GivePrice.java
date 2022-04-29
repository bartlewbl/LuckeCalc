package com.lucke;

import yahoofinance.*;

public class GivePrice {
    //private String ticker;


    public GivePrice(){
        
    }

    public String givecurrentPriceAndTicker(String requestedTicker){
        String ticker = requestedTicker;
        String price;
        try{
            Stock givenTicker = YahooFinance.get(ticker);
            price = givenTicker.toString();
            return price;
        }
        catch (Exception ex){
            System.out.print("Given ticker doesnt exist or there is a problem with getting data!");
        }
        

        return "0";
    }

}
