package main.java.rentalManagementCompanies;

import java.math.BigDecimal;

public class ClcManagement extends AbstractRentalManagementCompany {
    private static String website = "http://www.clcworldflorida.com/";
    private static String phoneNumber = "407-997-1000";
    private static Double avgMonthlyOccupancy = .79;
    private static Boolean canOwnersFindBooking = false;
    private static Boolean enterExitFees = false;
    private static Boolean discountForMultipleHomes = false;
    private static String companyName = "CLC Management";
    private static Double commission = .2;
    private static Double maxBookingCharge = .12;
    private static Double minBookingCharge = .06;
    private static BigDecimal managementFee = BigDecimal.valueOf(205);
    private static BigDecimal resortManagementFee = BigDecimal.valueOf(0);
    private static BigDecimal rentalInsurance = BigDecimal.valueOf(35);
    private static BigDecimal cleaningFee = BigDecimal.valueOf(100);
    private static BigDecimal poolService = BigDecimal.valueOf(0);
    private static BigDecimal pestMaintenance = BigDecimal.valueOf(0);
    private static BigDecimal linenReplacement = BigDecimal.valueOf(30);

    public ClcManagement() {
        super(website, phoneNumber, avgMonthlyOccupancy, canOwnersFindBooking, enterExitFees, discountForMultipleHomes, companyName, commission, maxBookingCharge, minBookingCharge, managementFee, resortManagementFee, rentalInsurance, cleaningFee, poolService, pestMaintenance, linenReplacement);
    }


}
