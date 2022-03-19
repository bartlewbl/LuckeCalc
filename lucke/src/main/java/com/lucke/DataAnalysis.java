package com.lucke;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import yahoofinance.*;

public class DataAnalysis {
    String [] tickerArray;
    TextInterface textInterface;
    Path path1 = Paths.get("C:","Temp","Nasdaq100Tickers.txt");
    Path path2 = Paths.get("/Users/bartlomiejlewandowski/Desktop/Nasdaq100Tickers.txt");
    File file = path2.toFile();
    

    public DataAnalysis (TextInterface _textInterface){
        tickerArray = new String [100];
        textInterface = _textInterface;
    }

    public void giveTickerPrice () throws IOException{
        
        if (file.exists() == true){
            Stock stock1;
            Stock stock2;

            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            Calendar from1 = Calendar.getInstance();
            Calendar to1 = Calendar.getInstance();
            from1.add(Calendar.DAY_OF_MONTH, -1);
            System.out.println("start");
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                String tickerZeile = br.readLine();
                tickerZeile = br.readLine().trim();   //// "List:"" as first thing in the file because when first line is taken then u get =<(Ticker) so it gives out an exeption on the first line
                for (int i = 0; i < 5; i++){
                    try {
                        stock1 = YahooFinance.get(tickerZeile, from, to, Interval.DAILY);
                        //System.out.println(stock1.getHistory()); 
                        textInterface.setTextArea1(stock1.getHistory().toString());
                        tickerArray = stock1.getHistory().toString().split(" ");
                        textInterface.setTextArea1(tickerArray[0]);
                        textInterface.setTextArea1(tickerArray[1]);
                        //stock2 = YahooFinance.get(tickerZeile, from1, to1, Interval.DAILY);
                        //textInterface.setTextArea1(stock2.getHistory().toString()); 
                    }
                    catch (IOException o){}
                    tickerZeile = br.readLine().trim();
                }
            }
            catch (Exception ex){
                System.out.println("Error with reading file");
            }
            
        }
        else if (file.exists() == false){
            System.out.println("Cannot find file!!!");
        }
        
    }



    public void getPriceData (String ticker){

        
        
        Stock stock1;
        Stock stock2;

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        Calendar from1 = Calendar.getInstance();
        Calendar to1 = Calendar.getInstance();
        from1.add(Calendar.DAY_OF_MONTH, -1); // from 5 years ago
        try {
            stock1 = YahooFinance.get(ticker, from, to, Interval.DAILY);
            //System.out.println(stock1.getHistory()); 
            textInterface.setTextArea1(stock1.getHistory().toString()); 
            stock2 = YahooFinance.get(ticker, from1, to1, Interval.DAILY);
            textInterface.setTextArea1(stock2.getHistory().toString()); 
        }
        catch (IOException o){}
        
    }

  

}