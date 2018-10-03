package main.java.rentalManagementCompanies;

import java.math.BigDecimal;

public class ParadiseProperties extends AbstractRentalManagementCompany {
    private static String website = "http://www.affordablevillasneardisney.com/";
    private static String phoneNumber = "888-922-6425";
    private static Double avgMonthlyOccupancy = .70;
    private static Boolean canOwnersFindBooking = true;
    private static Boolean enterExitFees = false;
    private static Boolean discountForMultipleHomes = true;
    private static String companyName = "Paradise Properties";
    private static Double commission = .2;
    private static Double maxBookingCharge = .0;
    private static Double minBookingCharge = .0;
    private static BigDecimal managementFee = BigDecimal.valueOf(125);
    private static BigDecimal resortManagementFee = BigDecimal.valueOf(0);
    private static BigDecimal rentalInsurance = BigDecimal.valueOf(0);
    private static BigDecimal cleaningFee = BigDecimal.valueOf(0);
    private static BigDecimal poolService = BigDecimal.valueOf(90);
    private static BigDecimal pestMaintenance = BigDecimal.valueOf(25);
    private static BigDecimal linenReplacement = BigDecimal.valueOf(0);

    public ParadiseProperties() {
        super(website, phoneNumber, avgMonthlyOccupancy, canOwnersFindBooking, enterExitFees, discountForMultipleHomes, companyName, commission, maxBookingCharge, minBookingCharge, managementFee, resortManagementFee, rentalInsurance, cleaningFee, poolService, pestMaintenance, linenReplacement);
    }
}
