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
    String [] tickerWithConditions;
    String currentTicker;
    TextInterface textInterface;
    Path path1 = Paths.get("C:","Temp","Nasdaq100Tickers.txt");
    Path path2 = Paths.get("/Users/bartlomiejlewandowski/Desktop/Nasdaq100Tickers.txt");
    File file = path2.toFile();
    

    public DataAnalysis (TextInterface _textInterface){
        tickerArray = new String [100];
        tickerWithConditions = new  String [100];
        textInterface = _textInterface;
    }

    public String [] giveTickerPrice () throws IOException{
        String tickersWithLucke[] = new String [100];
        int tickernumber = 0;
        if (file.exists() == true){
            String strArray [];
            System.out.println("start");
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                String tickerZeile = br.readLine();
                tickerZeile = br.readLine().trim();   //// "List:"" as first thing in the file because when first line is taken then u get =<(Ticker) so it gives out an exeption on the first line
                for (int i = 0; i < 80; i++){
                    try {
                        strArray = getPriceData(tickerZeile);
                        textInterface.setTextArea1(tickerZeile + "  " + strArray [1] + "  " + strArray [2]);
                        if (checkIfLucke(strArray) == true){

                        textInterface.setTextArea1(tickerZeile);
                        tickersWithLucke[tickernumber] = tickerZeile;
                        tickernumber++;
                        }
                        
                    }
                    catch (Exception ex){
                        textInterface.setTextArea1(tickerZeile + "is not a valid ticker");
                    }
                    finally{
                        tickerZeile = br.readLine().trim();
                    }
                    
                }
            }
            catch (Exception ex){
                System.out.println("Error with reading file");
            }
            
        }
        else if (file.exists() == false){
            System.out.println("Cannot find file!!!");
        }
        return tickersWithLucke;
    }

    public boolean checkIfLucke (String arrayTicker[]){
        double low = Double.parseDouble(arrayTicker[1]);
        double high = Double.parseDouble(arrayTicker[2]);
        double average = (Double.parseDouble(arrayTicker[1]) + Double.parseDouble(arrayTicker[2])) / 2;
        if (low > high){

            return true;
        }
        return false;
    }


    public String getTicker (){
        return currentTicker;
    }

    public void test (){
        Stock stock1;
        Stock stock2;

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        Calendar from1 = Calendar.getInstance();
        Calendar to1 = Calendar.getInstance();
        System.out.println(from.get(Calendar.DAY_OF_WEEK));
        from1.add(Calendar.DAY_OF_MONTH, -3); // from 5 years ago\
        try {
            stock1 = YahooFinance.get("AAPL", from, to, Interval.DAILY);
            stock2 = YahooFinance.get("AAPL", from1, to1, Interval.DAILY);
            
            textInterface.setTextArea1(stock2.getHistory().toString());
            textInterface.setTextArea1(stock1.getHistory().toString());
        }
        catch (IOException o){
            System.out.println("IOException: Problem with getting PriceData!");
        }
        

    }
    


    public String[] getPriceData (String ticker){
        String priceData [] = new String [3];
        
        
        Stock stock1;
        Stock stock2;

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        Calendar from1 = Calendar.getInstance();
        if (from.get(Calendar.DAY_OF_WEEK)==7){
            System.out.println("Saturday");
            from1.add(Calendar.DAY_OF_MONTH, -2);
            from.add(Calendar.DAY_OF_MONTH, -1);
        }
        else if (from.get(Calendar.DAY_OF_WEEK)==1){
            System.out.println("Sunday");
            from1.add(Calendar.DAY_OF_MONTH, -3);
            from.add(Calendar.DAY_OF_MONTH, -2);
        }
        else if (from.get(Calendar.DAY_OF_WEEK)== 2){
            System.out.println("Monday");
            from1.add(Calendar.DAY_OF_MONTH,-4);
            from.add(Calendar.DAY_OF_MONTH,-3);
        }
        else {
            System.out.println("Normalday");
            from1.add(Calendar.DAY_OF_MONTH, -1);
            //from.add(Calendar.DAY_OF_MONTH,-1); //Experimental
        }
        
        try {
            stock1 = YahooFinance.get(ticker, from, to, Interval.DAILY);
            stock2 = YahooFinance.get(ticker, from1, to, Interval.DAILY);
            tickerArray = stock1.getHistory().toString().split(" ");
            priceData [0] = tickerArray [0];
            tickerArray = tickerArray[1].split("-");
            priceData [2] = tickerArray [1].substring(0, tickerArray[1].length()-1);

            tickerArray = stock2.getHistory().toString().split(" ");
            tickerArray = tickerArray[1].split("-");
            priceData [1] =  tickerArray [0];
            
        }
        catch (IOException o){
            System.out.println("IOException: Problem with getting PriceData!");
            priceData [0] = ticker;
            priceData [1] = "0.000"; 
            priceData [2] = "0.000"; 
            return priceData;
        }
        return priceData;
    }

  

}