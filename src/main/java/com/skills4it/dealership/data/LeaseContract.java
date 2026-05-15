package com.skills4it.dealership.data;

import com.skills4it.dealership.models.Vehicle;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leasingFee;
    private double monthlyPayment;

    public LeaseContract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption, double expectedEndingValue, double leasingFee, double monthlyPayment) {
        super(contractDate, customerName, customerEmail, vehicleSold, financeOption);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.50;
        this.leasingFee = vehicleSold.getPrice() * 0.07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeasingFee() {
        return leasingFee;
    }

    public void setLeasingFee(double leasingFee) {
        this.leasingFee = leasingFee;
    }
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    @Override
    public double getMonthlyPayment() {
        double rate = 0.040;
        int months = 36;

        double monthlyRate = rate / months;
        return (getTotalPrice() * monthlyRate * Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);
    }

    @Override
    public double getTotalPrice(){
        return (getVehicleSold().getPrice() - expectedEndingValue) * leasingFee;
    }
}