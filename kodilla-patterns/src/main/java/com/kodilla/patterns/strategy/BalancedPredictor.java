package com.kodilla.patterns.strategy;

public class BalancedPredictor implements BuyPredictor {
    public String predictWhatToBuy(){
        return "[Balanced predictor] Buy shared units of Fund XYZ";
    }
}
