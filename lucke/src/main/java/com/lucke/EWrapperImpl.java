package com.lucke;

import com.ib.client.EWrapper;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.io.*;
import com.ib.client.*;
public class EWrapperImpl implements EWrapper {
    
    TextInterface textInterface;
    
        
    
    public EWrapperImpl (TextInterface _textInterface){
        textInterface = _textInterface;

        
    }









    public void tickPrice(int i, int i1, double v, int i2) {
        textInterface.setTextArea1("" + i + i1  + i2);
    }



    public void softDollarTiers(int arg0, SoftDollarTier[] arg1) {}





    @Override
    public void accountDownloadEnd(String arg0) {
       
    }

    @Override
    public void accountSummary(int arg0, String arg1, String arg2, String arg3, String arg4) {
       
        
    }

    @Override
    public void accountSummaryEnd(int arg0) {
       
        
    }

    @Override
    public void accountUpdateMulti(int arg0, String arg1, String arg2, String arg3, String arg4, String arg5) {
        
        
    }

    @Override
    public void accountUpdateMultiEnd(int arg0) {
       
        
    }

    @Override
    public void bondContractDetails(int arg0, ContractDetails arg1) {
       
        
    }

    @Override
    public void commissionReport(CommissionReport arg0) {
        
        
    }

    @Override
    public void completedOrder(Contract arg0, Order arg1, OrderState arg2) {
        
        
    }

    @Override
    public void completedOrdersEnd() {
        
        
    }

    @Override
    public void connectAck() {
       
        
    }

    @Override
    public void connectionClosed() {
        
        
    }

    @Override
    public void contractDetails(int arg0, ContractDetails arg1) {
        
        
    }

    @Override
    public void contractDetailsEnd(int arg0) {
        
        
    }

    @Override
    public void currentTime(long arg0) {
        
        
    }

    @Override
    public void deltaNeutralValidation(int arg0, DeltaNeutralContract arg1) {
        
        
    }

    @Override
    public void displayGroupList(int arg0, String arg1) {
        
        
    }

    @Override
    public void displayGroupUpdated(int arg0, String arg1) {
        
        
    }

    @Override
    public void error(Exception arg0) {
        textInterface.setTextArea1(""+arg0);
    }

    @Override
    public void error(String arg0) {
        
        textInterface.setTextArea1(arg0);
    }

    @Override
    public void error(int arg0, int arg1, String arg2) {
        
        textInterface.setTextArea1(arg0 + arg1 + arg2);
    }

    @Override
    public void execDetails(int arg0, Contract arg1, Execution arg2) {
        
        
    }

    @Override
    public void execDetailsEnd(int arg0) {
       
        
    }

    @Override
    public void familyCodes(FamilyCode[] arg0) {
        
        
    }

    @Override
    public void fundamentalData(int arg0, String arg1) {
        
        
    }

    @Override
    public void headTimestamp(int arg0, String arg1) {
        
        
    }

    @Override
    public void histogramData(int arg0, List<HistogramEntry> arg1) {
        
        
    }

    @Override
    public void historicalData(int arg0, Bar arg1) {
        textInterface.setTextArea1("HistoricalData:  " + EWrapperMsgGenerator.historicalData(arg0, arg1.time(), arg1.open(), arg1.high(), arg1.low(), arg1.close(), arg1.volume(), arg1.count(), arg1.wap()));
        
    }

    @Override
    public void historicalDataEnd(int arg0, String arg1, String arg2) {
        textInterface.setTextArea1("HistoricalDataEnd. " + EWrapperMsgGenerator.historicalDataEnd(arg0, arg1, arg2));
        
    }

    @Override
    public void historicalDataUpdate(int arg0, Bar arg1) {
        textInterface.setTextArea1("HistoricalDataUpdate. " + EWrapperMsgGenerator.historicalData(arg0, arg1.time(), arg1.open(), arg1.high(), arg1.low(), arg1.close(), arg1.volume(), arg1.count(), arg1.wap()));
        
    }

    @Override
    public void historicalNews(int arg0, String arg1, String arg2, String arg3, String arg4) {
        
        
    }

    @Override
    public void historicalNewsEnd(int arg0, boolean arg1) {
        
        
    }

    @Override
    public void historicalTicks(int arg0, List<HistoricalTick> arg1, boolean arg2) {
        
        
    }

    @Override
    public void historicalTicksBidAsk(int arg0, List<HistoricalTickBidAsk> arg1, boolean arg2) {
       
        
    }

    @Override
    public void historicalTicksLast(int arg0, List<HistoricalTickLast> arg1, boolean arg2) {
       
        
    }

    @Override
    public void managedAccounts(String arg0) {
        
        
    }

    @Override
    public void marketDataType(int arg0, int arg1) {
        
        
    }

    @Override
    public void marketRule(int arg0, PriceIncrement[] arg1) {
       
        
    }

    @Override
    public void mktDepthExchanges(DepthMktDataDescription[] arg0) {
        
        
    }

    @Override
    public void newsArticle(int arg0, int arg1, String arg2) {
        
        
    }

    @Override
    public void newsProviders(NewsProvider[] arg0) {
        
        
    }

    @Override
    public void nextValidId(int arg0) {
        
        
    }

    @Override
    public void openOrder(int arg0, Contract arg1, Order arg2, OrderState arg3) {
        
        
    }

    @Override
    public void openOrderEnd() {
       
        
    }

    @Override
    public void orderBound(long arg0, int arg1, int arg2) {
        
        
    }

    @Override
    public void orderStatus(int arg0, String arg1, double arg2, double arg3, double arg4, int arg5, int arg6,
            double arg7, int arg8, String arg9, double arg10) {
        
        
    }

    @Override
    public void pnl(int arg0, double arg1, double arg2, double arg3) {
        
        
    }

    @Override
    public void pnlSingle(int arg0, int arg1, double arg2, double arg3, double arg4, double arg5) {
        
        
    }

    @Override
    public void position(String arg0, Contract arg1, double arg2, double arg3) {
        
        
    }

    @Override
    public void positionEnd() {
        
        
    }

    @Override
    public void positionMulti(int arg0, String arg1, String arg2, Contract arg3, double arg4, double arg5) {
        
        
    }

    @Override
    public void positionMultiEnd(int arg0) {
        
        
    }

    @Override
    public void realtimeBar(int arg0, long arg1, double arg2, double arg3, double arg4, double arg5, long arg6,
            double arg7, int arg8) {
        
        
    }

    @Override
    public void receiveFA(int arg0, String arg1) {
        
        
    }

    @Override
    public void rerouteMktDataReq(int arg0, int arg1, String arg2) {
        
        
    }

    @Override
    public void rerouteMktDepthReq(int arg0, int arg1, String arg2) {
        
        
    }

    @Override
    public void scannerData(int arg0, int arg1, ContractDetails arg2, String arg3, String arg4, String arg5,
            String arg6) {
        
        
    }

    @Override
    public void scannerDataEnd(int arg0) {
       
        
    }

    @Override
    public void scannerParameters(String arg0) {
        
        
    }

    @Override
    public void securityDefinitionOptionalParameter(int arg0, String arg1, int arg2, String arg3, String arg4,
            Set<String> arg5, Set<Double> arg6) {
        
        
    }

    @Override
    public void securityDefinitionOptionalParameterEnd(int arg0) {
        
        
    }

    @Override
    public void smartComponents(int arg0, Map<Integer, Entry<String, Character>> arg1) {
        
        
    }

    @Override
    public void symbolSamples(int arg0, ContractDescription[] arg1) {
        
        
    }

    @Override
    public void tickByTickAllLast(int arg0, int arg1, long arg2, double arg3, int arg4, TickAttribLast arg5,
            String arg6, String arg7) {
        
        
    }

    @Override
    public void tickByTickBidAsk(int arg0, long arg1, double arg2, double arg3, int arg4, int arg5,
            TickAttribBidAsk arg6) {
      
        
    }

    @Override
    public void tickByTickMidPoint(int arg0, long arg1, double arg2) {
       
        
    }

    @Override
    public void tickEFP(int arg0, int arg1, double arg2, String arg3, double arg4, int arg5, String arg6, double arg7,
            double arg8) {
       
        
    }

    @Override
    public void tickGeneric(int arg0, int arg1, double arg2) {
       
        
    }

    @Override
    public void tickNews(int arg0, long arg1, String arg2, String arg3, String arg4, String arg5) {
     
        
    }

    @Override
    public void tickOptionComputation(int arg0, int arg1, double arg2, double arg3, double arg4, double arg5,
            double arg6, double arg7, double arg8, double arg9) {
      
        
    }

    @Override
    public void tickPrice(int arg0, int arg1, double arg2, TickAttrib arg3) {
      
        
    }

    @Override
    public void tickReqParams(int arg0, double arg1, String arg2, int arg3) {
       
        
    }

    @Override
    public void tickSize(int arg0, int arg1, int arg2) {
        textInterface.setTextArea1("" + arg0 + arg1 + arg2);
        
    }

    @Override
    public void tickSnapshotEnd(int arg0) {
     
        
    }

    @Override
    public void tickString(int arg0, int arg1, String arg2) {
       
        
    }

    @Override
    public void updateAccountTime(String arg0) {
       
        
    }

    @Override
    public void updateAccountValue(String arg0, String arg1, String arg2, String arg3) {
     
        
    }

    @Override
    public void updateMktDepth(int arg0, int arg1, int arg2, int arg3, double arg4, int arg5) {
      
        
    }

    @Override
    public void updateMktDepthL2(int arg0, int arg1, String arg2, int arg3, int arg4, double arg5, int arg6,
            boolean arg7) {
     
        
    }

    @Override
    public void updateNewsBulletin(int arg0, int arg1, String arg2, String arg3) {
     
        
    }

    @Override
    public void updatePortfolio(Contract arg0, double arg1, double arg2, double arg3, double arg4, double arg5,
            double arg6, String arg7) {
      
        
    }

    @Override
    public void verifyAndAuthCompleted(boolean arg0, String arg1) {
       
        
    }

    @Override
    public void verifyAndAuthMessageAPI(String arg0, String arg1) {
      
        
    }

    @Override
    public void verifyCompleted(boolean arg0, String arg1) {
      
        
    }

    @Override
    public void verifyMessageAPI(String arg0) {
      
        
    }
}
