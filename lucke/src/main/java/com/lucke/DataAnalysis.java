package com.lucke;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.Calendar;

import yahoofinance.*;

public class DataAnalysis {

    public DataAnalysis (){

    }

    public String getHistoricalData (){
        String str = "new";
        Stock google;
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.DAY_OF_MONTH, -1); // from 5 years ago
        try {
            google = YahooFinance.get("GOOG", from, to, Interval.DAILY);
            System.out.println(google.getHistory()); 
            return google.getHistory().toString();

        }
        catch (IOException o){}
        return str;
    }


}