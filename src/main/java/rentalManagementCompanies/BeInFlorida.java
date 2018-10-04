package main.java.rentalManagementCompanies;

import java.math.BigDecimal;

public class BeInFlorida extends AbstractRentalManagementCompany {
    private static String website = "https://beinflorida.com/";
    private static String phoneNumber = "407-574-2091";
    private static Double avgMonthlyOccupancy = .10; //TODO: need to update
    private static Boolean canOwnersFindBooking = true;
    private static Boolean enterExitFees = true;
    private static String exitTimeNotification = "60";
    private static Boolean discountForMultipleHomes = true;
    private static String companyName = "Be In Florida";
    private static Double commission = .2;
    private static Double maxBookingCharge = .0;
    private static Double minBookingCharge = .0;
    private static BigDecimal managementFee = BigDecimal.valueOf(200);
    private static BigDecimal resortManagementFee = BigDecimal.valueOf(0);
    private static BigDecimal rentalInsurance = BigDecimal.valueOf(0);
    private static BigDecimal cleaningFee = BigDecimal.valueOf(0);
    private static BigDecimal poolService = BigDecimal.valueOf(95);
    private static BigDecimal pestMaintenance = BigDecimal.valueOf(50);
    private static BigDecimal linenReplacement = BigDecimal.valueOf(0);

    public BeInFlorida() {
        super(website, phoneNumber, avgMonthlyOccupancy, canOwnersFindBooking, enterExitFees, exitTimeNotification, discountForMultipleHomes, companyName, commission, maxBookingCharge, minBookingCharge, managementFee, resortManagementFee, rentalInsurance, cleaningFee, poolService, pestMaintenance, linenReplacement);
    }


}
