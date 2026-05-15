package com.skills4it.dealership.data;

import com.skills4it.dealership.models.Vehicle;
import com.skills4it.dealership.models.enums.VehicleType;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveToFile(Contract contract){
        Vehicle vehicle = contract.getVehicleSold();

        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(contract instanceof SalesContract ? "SALE" : "LEASE").append("|")
                .append(contract.getContractDate()).append("|")
                .append(contract.getCustomerName()).append("|")
                .append(contract.getCustomerEmail()).append("|");

        strBuilder.append(vehicle.getVin()).append("|")
                .append(vehicle.getYear()).append("|")
                .append(vehicle.getMake()).append("|")
                .append(vehicle.getModel()).append("|")
                .append(vehicle.getVehicleType()).append("|")
                .append(vehicle.getColor()).append("|")
                .append(vehicle.getOdometer()).append("|")
                .append(vehicle.getPrice()).append("|");

    }

}
