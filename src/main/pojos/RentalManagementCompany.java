package main.pojos;

import java.math.BigDecimal;

public class RentalManagementCompany {
    String companyName;
    Double commission;
    Double maxBookingCharge;
    Double minBookingCharge;
    BigDecimal managementFee;
    BigDecimal resortManagementFee;
    BigDecimal rentalInsurance;
    BigDecimal cleaningFee;
    BigDecimal poolService;
    BigDecimal pestMaintenance;

    public RentalManagementCompany(String companyName, Double commission, Double maxBookingCharge, Double minBookingCharge, BigDecimal managementFee, BigDecimal resortManagementFee, BigDecimal rentalInsurance, BigDecimal cleaningFee, BigDecimal poolService, BigDecimal pestMaintenance) {
        this.companyName = companyName;
        this.commission = commission;
        this.maxBookingCharge = maxBookingCharge;
        this.minBookingCharge = minBookingCharge;
        this.managementFee = managementFee;
        this.resortManagementFee = resortManagementFee;
        this.rentalInsurance = rentalInsurance;
        this.cleaningFee = cleaningFee;
        this.poolService = poolService;
        this.pestMaintenance = pestMaintenance;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getCommission() {
        return this.commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public Double getMaxBookingCharge() {
        return this.maxBookingCharge;
    }

    public void setMaxBookingCharges(Double maxBookingCharge) {
        this.maxBookingCharge = maxBookingCharge;
    }

    public Double getMinBookingCharge() {
        return this.minBookingCharge;
    }

    public void setMinBookingCharges(Double minBookingCharge) {
        this.minBookingCharge = minBookingCharge;
    }

    public BigDecimal getManagementFee() {
        return this.managementFee;
    }

    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    public BigDecimal getResortManagementFee() {
        return this.resortManagementFee;
    }

    public void setResortManagementFee(BigDecimal resortManagementFee) {
        this.resortManagementFee = resortManagementFee;
    }

    public BigDecimal getRentalInsurance() {
        return this.rentalInsurance;
    }

    public void setRentalInsurance(BigDecimal rentalInsurance) {
        this.rentalInsurance = rentalInsurance;
    }

    public BigDecimal getCleaningFee() {
        return this.cleaningFee;
    }

    public void setCleaningFee(BigDecimal cleaningFee) {
        this.cleaningFee = cleaningFee;
    }

    public BigDecimal getPoolService() {
        return this.poolService;
    }

    public void setPoolService(BigDecimal poolService) {
        this.poolService = poolService;
    }

    public BigDecimal getPestMaintenance() {
        return this.pestMaintenance;
    }

    public void setPestMaintenance(BigDecimal pestMaintenance) {
        this.pestMaintenance = pestMaintenance;
    }
}
