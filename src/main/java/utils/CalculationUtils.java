package main.java.utils;

import main.java.House;
import main.java.rentalManagementCompanies.RentalManagementCompany;

import java.math.BigDecimal;

public class CalculationUtils {
    public CalculationUtils() {
    }

    public String getMaxIncome(House house, RentalManagementCompany rms) {
        if (house.getRentalIncome() != null && rms.getManagementFee() != null) {
            BigDecimal maxIncome = this.getCommissionBd(house, rms).subtract(rms.getManagementFee());
            return maxIncome.toString();
        } else {
            return "n/a";
        }
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
}
