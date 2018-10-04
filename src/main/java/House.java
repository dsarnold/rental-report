package main.java;

import java.math.BigDecimal;

public class House {
    BigDecimal purchasePrice;
    BigDecimal updatesPrice;
    String address1;
    String address2;
    String zip;
    BigDecimal hoaFee;
    BigDecimal taxes;
    BigDecimal insurance;
    BigDecimal rentalIncome;
    BigDecimal waterCost;
    BigDecimal mortgage;

    public House(BigDecimal purchasePrice, BigDecimal updatesPrice, String address1, String address2, String zip, BigDecimal hoaFee,
                 BigDecimal taxes, BigDecimal insurance, BigDecimal rentalIncome, BigDecimal waterCost, BigDecimal mortgage) {
        this.purchasePrice = purchasePrice;
        this.updatesPrice = updatesPrice;
        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
        this.hoaFee = hoaFee;
        this.taxes = taxes;
        this.insurance = insurance;
        this.rentalIncome = rentalIncome;
        this.waterCost = waterCost;
        this.mortgage = mortgage;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public BigDecimal getHoaFee() {
        return this.hoaFee;
    }

    public void setHoaFee(BigDecimal hoaFee) {
        this.hoaFee = hoaFee;
    }

    public BigDecimal getTaxes() {
        return this.taxes;
    }

    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }

    public BigDecimal getInsurance() {
        return this.insurance;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public BigDecimal getRentalIncome() {
        return this.rentalIncome;
    }

    public void setRentalIncome(BigDecimal rentalIncome) {
        this.rentalIncome = rentalIncome;
    }

    public BigDecimal getPurchasePrice() {
        return this.purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getUpdatesPrice() {
        return this.updatesPrice;
    }

    public void setUpdatesPrice(BigDecimal updatesPrice) {
        this.updatesPrice = updatesPrice;
    }

    public BigDecimal getWaterCost() {
        return waterCost;
    }

    public void setWaterCost(BigDecimal waterCost) {
        this.waterCost = waterCost;
    }

    public BigDecimal getMortgage() {
        return mortgage;
    }

    public void setMortgage(BigDecimal mortgage) {
        this.mortgage = mortgage;
    }
}
