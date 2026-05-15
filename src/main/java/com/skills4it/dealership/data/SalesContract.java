package com.skills4it.dealership.data;

import com.skills4it.dealership.models.Vehicle;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;

    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption) {
        super(contractDate, customerName, customerEmail, vehicleSold, financeOption);
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05;
        this.recordingFee = 100.00;
        this.processingFee = (vehicleSold.getPrice() < 10000) ? 295.00 : 495.00;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }
    @Override
    public double getTotalPrice(){
        return (getVehicleSold().getPrice() + salesTaxAmount + processingFee + recordingFee);
    }

    @Override
    public double getMonthlyPayment(){
        if (!isFinanceOption()){
            return 0.0;
        }
        double rate;
        int months;

        if (getVehicleSold().getPrice() >= 10000){
            rate = 0.0425;
            months = 48;
        }
        else{
            rate = 0.0525;
            months = 24;
        }
        double monthlyRate = rate / 12;
        return (getTotalPrice() * monthlyRate * Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);
    }

}