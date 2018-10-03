package main.java.rentalManagementCompanies;

import java.math.BigDecimal;

public abstract class AbstractRentalManagementCompany implements RentalManagementCompany {
    String website;
    String phoneNumber;
    Double avgMonthlyOccupancy;
    Boolean canOwnersFindBooking;
    Boolean enterExitFees;
    Boolean discountForMultipleHomes;
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
    BigDecimal linenReplacement;

    public AbstractRentalManagementCompany(String website, String phoneNumber, Double avgMonthlyOccupancy, Boolean canOwnersFindBooking, Boolean enterExitFees, Boolean discountForMultipleHomes, String companyName, Double commission, Double maxBookingCharge, Double minBookingCharge, BigDecimal managementFee, BigDecimal resortManagementFee, BigDecimal rentalInsurance, BigDecimal cleaningFee, BigDecimal poolService, BigDecimal pestMaintenance, BigDecimal linenReplacement) {
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.avgMonthlyOccupancy = avgMonthlyOccupancy;
        this.canOwnersFindBooking = canOwnersFindBooking;
        this.enterExitFees = enterExitFees;
        this.discountForMultipleHomes = discountForMultipleHomes;
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
        this.linenReplacement = linenReplacement;
    }

    @Override
    public String getWebsite() {
        return website;
    }

    @Override
    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Double getAvgMonthlyOccupancy() {
        return avgMonthlyOccupancy;
    }

    @Override
    public void setAvgMonthlyOccupancy(Double avgMonthlyOccupancy) {
        this.avgMonthlyOccupancy = avgMonthlyOccupancy;
    }

    @Override
    public Boolean getCanOwnersFindBooking() {
        return canOwnersFindBooking;
    }

    @Override
    public void setCanOwnersFindBooking(Boolean canOwnersFindBooking) {
        this.canOwnersFindBooking = canOwnersFindBooking;
    }

    @Override
    public Boolean getEnterExitFees() {
        return enterExitFees;
    }

    @Override
    public void setEnterExitFees(Boolean enterExitFees) {
        this.enterExitFees = enterExitFees;
    }

    @Override
    public Boolean getDiscountForMultipleHomes() {
        return discountForMultipleHomes;
    }

    @Override
    public void setDiscountForMultipleHomes(Boolean discountForMultipleHomes) {
        this.discountForMultipleHomes = discountForMultipleHomes;
    }

    @Override
    public BigDecimal getLinenReplacement() {
        return linenReplacement;
    }

    @Override
    public void setLinenReplacement(BigDecimal linenReplacement) {
        this.linenReplacement = linenReplacement;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public Double getCommission() {
        return commission;
    }

    @Override
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    @Override
    public Double getMaxBookingCharge() {
        return maxBookingCharge;
    }

    @Override
    public void setMaxBookingCharge(Double maxBookingCharge) {
        this.maxBookingCharge = maxBookingCharge;
    }

    @Override
    public Double getMinBookingCharge() {
        return minBookingCharge;
    }

    @Override
    public void setMinBookingCharge(Double minBookingCharge) {
        this.minBookingCharge = minBookingCharge;
    }

    @Override
    public BigDecimal getManagementFee() {
        return managementFee;
    }

    @Override
    public void setManagementFee(BigDecimal managementFee) {
        this.managementFee = managementFee;
    }

    @Override
    public BigDecimal getResortManagementFee() {
        return resortManagementFee;
    }

    @Override
    public void setResortManagementFee(BigDecimal resortManagementFee) {
        this.resortManagementFee = resortManagementFee;
    }

    @Override
    public BigDecimal getRentalInsurance() {
        return rentalInsurance;
    }

    @Override
    public void setRentalInsurance(BigDecimal rentalInsurance) {
        this.rentalInsurance = rentalInsurance;
    }

    @Override
    public BigDecimal getCleaningFee() {
        return cleaningFee;
    }

    @Override
    public void setCleaningFee(BigDecimal cleaningFee) {
        this.cleaningFee = cleaningFee;
    }

    @Override
    public BigDecimal getPoolService() {
        return poolService;
    }

    @Override
    public void setPoolService(BigDecimal poolService) {
        this.poolService = poolService;
    }

    @Override
    public BigDecimal getPestMaintenance() {
        return pestMaintenance;
    }

    @Override
    public void setPestMaintenance(BigDecimal pestMaintenance) {
        this.pestMaintenance = pestMaintenance;
    }
}
