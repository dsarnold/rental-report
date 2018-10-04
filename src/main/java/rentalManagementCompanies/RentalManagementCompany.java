package main.java.rentalManagementCompanies;

import java.math.BigDecimal;

public interface RentalManagementCompany {



    String getWebsite();

    void setWebsite(String website);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    Double getAvgMonthlyOccupancy();

    void setAvgMonthlyOccupancy(Double avgMonthlyOccupancy);

    Boolean getCanOwnersFindBooking();

    void setCanOwnersFindBooking(Boolean canOwnersFindBooking);

    Boolean getEnterExitFees();

    void setEnterExitFees(Boolean enterExitFees);

    String getExitTimeNotification();

    void setExitTimeNotification(String exitTimeNotification);

    Boolean getDiscountForMultipleHomes();

    void setDiscountForMultipleHomes(Boolean discountForMultipleHomes);

    BigDecimal getLinenReplacement();

    void setLinenReplacement(BigDecimal linenReplacement);

    String getCompanyName();

    void setCompanyName(String companyName);

    Double getCommission();

    void setCommission(Double commission);

    Double getMaxBookingCharge();

    void setMaxBookingCharge(Double maxBookingCharge);

    Double getMinBookingCharge();

    void setMinBookingCharge(Double minBookingCharge);

    BigDecimal getManagementFee();

    void setManagementFee(BigDecimal managementFee);

    BigDecimal getResortManagementFee();

    void setResortManagementFee(BigDecimal resortManagementFee);

    BigDecimal getRentalInsurance();

    void setRentalInsurance(BigDecimal rentalInsurance);

    BigDecimal getCleaningFee();

    void setCleaningFee(BigDecimal cleaningFee);

    BigDecimal getPoolService();

    void setPoolService(BigDecimal poolService);

    BigDecimal getPestMaintenance();

    void setPestMaintenance(BigDecimal pestMaintenance);


}
