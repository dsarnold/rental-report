package main.java.utils;

import main.java.House;
import main.java.rentalManagementCompanies.RentalManagementCompany;

import java.math.BigDecimal;

public class CalculationUtils {
    public CalculationUtils() {
    }

    public String getMaxIncome(House house, RentalManagementCompany rms) {
        // total income - minimum rmc cost - minimum house costs
        BigDecimal totalIncome = house.getRentalIncome();
        BigDecimal totalRmcCost = getMinimumRmcCost(house, rms);
        BigDecimal minimumHouseCost = getHouseCost(house);

        return totalIncome.subtract(totalRmcCost).subtract(minimumHouseCost).toString();
    }

    public String getMinIncome(House house, RentalManagementCompany rms) {
        // total income - max rmc cost - max house costs
        BigDecimal totalIncome = house.getRentalIncome();
        BigDecimal totalRmcCost = getMaximumRmcCost(house, rms);
        BigDecimal minimumHouseCost = getHouseCost(house);

        return totalIncome.subtract(totalRmcCost).subtract(minimumHouseCost).toString();
    }

    public BigDecimal getMaximumRmcCost(House house, RentalManagementCompany rmc){
        BigDecimal maxCost = new BigDecimal(0);

        // max commission
        BigDecimal commission = house.getRentalIncome().multiply(BigDecimal.valueOf(rmc.getCommission()));
        maxCost = maxCost.add(commission);

        // max booking fee
        BigDecimal maxBookingFee = house.getRentalIncome().multiply(BigDecimal.valueOf(rmc.getMaxBookingCharge()));
        maxCost = maxCost.add(maxBookingFee);

        // max cleaning fee
        maxCost = maxCost.add(rmc.getCleaningFee());

        // max rental insurance
        maxCost = maxCost.add(rmc.getRentalInsurance());

        // max linen replacement
        maxCost = maxCost.add(rmc.getLinenReplacement());

        // max pool service fee
        maxCost = maxCost.add(rmc.getPoolService());

        // max pest control
        maxCost = maxCost.add(rmc.getPestMaintenance());

        return  maxCost;
    }

    public BigDecimal getMinimumRmcCost(House house, RentalManagementCompany rms){
        BigDecimal minimumCost = new BigDecimal(0);

        // minimum commission
        BigDecimal commission = house.getRentalIncome().multiply(BigDecimal.valueOf(rms.getCommission()));
        minimumCost = minimumCost.add(commission);

        // minimum booking fee
        BigDecimal minBookingFee = house.getRentalIncome().multiply(BigDecimal.valueOf(rms.getMinBookingCharge()));
        minimumCost = minimumCost.add(minBookingFee);

        // minimum cleaning fee
        minimumCost = minimumCost.add(rms.getCleaningFee());

        // minimum rental insurance
        minimumCost = minimumCost.add(rms.getRentalInsurance());

        // minimum linen replacement
        minimumCost = minimumCost.add(rms.getLinenReplacement());

        // minimum pool service fee
        minimumCost = minimumCost.add(rms.getPoolService());

        // minimum pest control
        minimumCost = minimumCost.add(rms.getPestMaintenance());

        return  minimumCost;
    }

    private BigDecimal getHouseCost(House house){
        BigDecimal cost = new BigDecimal(0);

        // Insurance
        cost = cost.add(house.getInsurance());

        // water
        cost = cost.add(house.getWaterCost());

        // mortgage
        cost = cost.add(house.getMortgage());

        // hoa
        cost = cost.add(house.getHoaFee());

        return cost;
    }

    private BigDecimal getCommissionBd(House house, RentalManagementCompany rms) {
        BigDecimal income = house.getRentalIncome();
        BigDecimal commission = BigDecimal.valueOf(rms.getCommission());
        BigDecimal payedCommission = income.multiply(commission);
        return payedCommission;
    }

    public String getCommission(House house, RentalManagementCompany rms) {
        return house.getRentalIncome() != null && rms.getCommission() != null ? this.getCommissionBd(house, rms).toString() : "n/a";
    }

    public String getMaxBookingCharge(House house, RentalManagementCompany rms) {
        if (house.getRentalIncome() != null && rms.getMaxBookingCharge() != null) {
            BigDecimal maxBookingCharge = house.getRentalIncome().multiply(BigDecimal.valueOf(rms.getMaxBookingCharge()));
            return maxBookingCharge.toString();
        } else {
            return "n/a";
        }
    }

    public String getTotalIncome(House house) {
        return house.getRentalIncome().toString(); // TODO: Add extra income... Look up what other income is
    }
}
