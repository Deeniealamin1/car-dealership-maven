package com.skills4it.dealership.data;

import com.skills4it.dealership.models.Vehicle;

public abstract class Contract {
    private String contractDate;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private double totalPrice;
    private boolean financeOption;

    public Contract(String contractDate, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeOption) {
        this.contractDate = contractDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }

    public double getSalesTaxAmount() {
        return vehicleSold.getPrice() * 0.05;
    }

    public double getRecordingFee() {
        return 100.00;
    }

    public double getProcessingFee() {
        return (vehicleSold.getPrice() < 10000) ? 295.00 : 495.00;
    }

    public abstract double getTotalPrice() {
        return vehicleSold.getPrice() + getSalesTaxAmount() + getRecordingFee() + getProcessingFee();
    }

    public double getMonthlyPayment() {
        if (!financeOption) {
            return 0.0;
        }

        double interestRate;
        int months;

        if (vehicleSold.getPrice() >= 10000) {
            interestRate = 0.0425;
            months = 48;
        } else {
            interestRate = 0.0525;
            months = 24;
        }

        double monthlyRate = interestRate / 12;
        return (getTotalPrice() * monthlyRate * Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);
    }
}