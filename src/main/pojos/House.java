package main.pojos;

import java.math.BigDecimal;

public class House {
    BigDecimal purchasePrice;
    BigDecimal updatesPrice;
    BigDecimal piti;
    String address1;
    String address2;
    String zip;
    BigDecimal hoaFee;
    BigDecimal taxes;
    BigDecimal insurance;
    BigDecimal rentalIncome;

    public House(BigDecimal purchasePrice, BigDecimal updatesPrice, BigDecimal piti, String address1, String address2, String zip, BigDecimal hoaFee, BigDecimal taxes, BigDecimal insurance, BigDecimal rentalIncome) {
        this.purchasePrice = purchasePrice;
        this.updatesPrice = updatesPrice;
        this.piti = piti;
        this.address1 = address1;
        this.address2 = address2;
        this.zip = zip;
        this.hoaFee = hoaFee;
        this.taxes = taxes;
        this.insurance = insurance;
        this.rentalIncome = rentalIncome;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void withAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void withAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZip() {
        return this.zip;
    }

    public void withZip(String zip) {
        this.zip = zip;
    }

    public BigDecimal getHoaFee() {
        return this.hoaFee;
    }

    public void withHoaFee(BigDecimal hoaFee) {
        this.hoaFee = hoaFee;
    }

    public BigDecimal getTaxes() {
        return this.taxes;
    }

    public void withTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }

    public BigDecimal getInsurance() {
        return this.insurance;
    }

    public void withInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public BigDecimal getRentalIncome() {
        return this.rentalIncome;
    }

    public void withRentalIncome(BigDecimal rentalIncome) {
        this.rentalIncome = rentalIncome;
    }

    public BigDecimal getPurchasePrice() {
        return this.purchasePrice;
    }

    public void withPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getUpdatesPrice() {
        return this.updatesPrice;
    }

    public void withUpdatesPrice(BigDecimal updatesPrice) {
        this.updatesPrice = updatesPrice;
    }

    public BigDecimal getPiti() {
        return this.piti;
    }

    public void withPiti(BigDecimal piti) {
        this.piti = piti;
    }
}
