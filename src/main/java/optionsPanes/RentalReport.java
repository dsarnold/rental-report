package main.java.optionsPanes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import main.java.House;
import main.java.utils.CalculationUtils;
import main.java.rentalManagementCompanies.BeInFlorida;
import main.java.rentalManagementCompanies.ParadiseProperties;
import main.java.rentalManagementCompanies.RentalManagementCompany;
import main.java.rentalManagementCompanies.ClcManagement;

public class RentalReport extends JFrame {
    private JButton houseInfoPane;
    private JLabel purchasePriceLabel, updatesPriceLabel, address1Label, address2Label, zipLabel, hoaFeeLabel,
            taxesLabel, insuranceLabel, rentalIncomeLabel, paradiseRentalIncomeLabel, clcRentalIncomeLabel, beInFloridaIncomeLabel, pitiLabel;
    private JTextField purchasePriceTextbox, updatesPriceTextbox, pitiTextbox, address1Textbox, address2Textbox, zipTextbox,
            hoaFeeTextbox, taxesTextbox, insuranceTextbox, rentalIncomeTextbox;
    private House _house;
    JPanel _panel, _bottomPanel, _leftPanel, _centerPanel;
    private RentalManagementCompany _paradiseRmc, _clcRmc, _beInFloridaRmc;
    private CalculationUtils utils = new CalculationUtils();

    public static void main(String[] args) {
        House house = new House(new BigDecimal(200000), new BigDecimal(2000), new BigDecimal(1500), "123 Brandon Way", "Apt. 3", "12345", new BigDecimal(300), new BigDecimal(150), new BigDecimal(150), new BigDecimal(4000));
        SwingUtilities.invokeLater(() -> new RentalReport(house));
    }


    public RentalReport(House house) {
        _house = new House(house.getPurchasePrice(), house.getUpdatesPrice(), house.getPiti(), house.getAddress1(), house.getAddress2(), house.getZip(), house.getHoaFee(), house.getTaxes(), house.getInsurance(), house.getRentalIncome());
        _paradiseRmc = new ParadiseProperties();
        _clcRmc = new ClcManagement();
        _beInFloridaRmc = new BeInFlorida();

        setExtendedState(6);
        createView();
        setTitle("Property Report");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    private void createView() {
        _panel = new JPanel(new BorderLayout());
        _panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(_panel);
        setExtendedState(6);
        createBottomPanel();
        createLeftPanel();
        createCenterPanel();
        _panel.add(_centerPanel, "Center");
        _panel.add(_bottomPanel, "South");
        _panel.add(_leftPanel, "West");
    }

    private void createCenterPanel() {
        JLabel blank = gridLabel("");
        JLabel paradiseNameLabel = gridLabel(_paradiseRmc.getCompanyName());
        JLabel clcNameLabel = gridLabel(_clcRmc.getCompanyName());
        JLabel beInFloridaNameLabel = gridLabel(_beInFloridaRmc.getCompanyName());
        JLabel rentalIncomeLabel = gridLabel("Rental Income");
        if (_house.getRentalIncome() != null) {
            paradiseRentalIncomeLabel = gridLabel(_house.getRentalIncome().toString());
            clcRentalIncomeLabel = gridLabel(_house.getRentalIncome().toString());
            beInFloridaIncomeLabel = gridLabel(_house.getRentalIncome().toString());
        } else {
            paradiseRentalIncomeLabel = gridLabel("");
            clcRentalIncomeLabel = gridLabel("");
            beInFloridaIncomeLabel = gridLabel("");
        }

        JLabel commissionLabel = gridLabel("Commission");
        JLabel parCommissionLabel = gridLabel(utils.getCommission(_house, _paradiseRmc));
        JLabel clcCommissionLabel = gridLabel(utils.getCommission(_house, _clcRmc));
        JLabel beInFloridaCommissionLabel = gridLabel(utils.getCommission(_house, _beInFloridaRmc));
        JLabel bookingChargesLabel = gridLabel("Max Booking Charges");
        JLabel parBookingChargeLabel = gridLabel(utils.getMaxBookingCharge(_house, _paradiseRmc));
        JLabel clcBookingChargeLabel = gridLabel(utils.getMaxBookingCharge(_house, _clcRmc));
        JLabel beInFloridaBookingChargeLabel = gridLabel(utils.getMaxBookingCharge(_house, _beInFloridaRmc));
        JLabel managementFeeLabel = gridLabel("Management Fee");
        JLabel parManagementFeeLabel = gridLabel(_paradiseRmc.getManagementFee().toString());
        JLabel clcManagementFeeLabel = gridLabel(_clcRmc.getManagementFee().toString());
        JLabel beInFloridaManagementFeeLabel = gridLabel(_beInFloridaRmc.getManagementFee().toString());
        JLabel cleaningLabel = gridLabel("Cleaning Fee");
        JLabel parCleaningLabel = gridLabel(_paradiseRmc.getCleaningFee().toString());
        JLabel clcCleaningLabel = gridLabel(_clcRmc.getCleaningFee().toString());
        JLabel beInFloridaCleaningLabel = gridLabel(_beInFloridaRmc.getCleaningFee().toString());
        JLabel resortManagementServicesLabel = gridLabel("Resort Management Services");
        JLabel parRMSLabel = gridLabel(_paradiseRmc.getResortManagementFee().toString());
        JLabel clcRMSLabel = gridLabel(_clcRmc.getResortManagementFee().toString());
        JLabel beInFloridaRMSLabel = gridLabel(_beInFloridaRmc.getResortManagementFee().toString());
        JLabel totalMaxIncome = gridLabel("Max Income");
        JLabel parMaxLabel = gridLabel(utils.getMaxIncome(_house, _paradiseRmc));
        JLabel clcMaxLabel = gridLabel(utils.getMaxIncome(_house, _clcRmc));
        JLabel beInFloridaMaxLabel = gridLabel(utils.getMaxIncome(_house, _beInFloridaRmc));
        JLabel totalMinIncome = gridLabel("Min Income");
        JLabel parMinLabel = gridLabel("0");
        JLabel clcMinLabel = gridLabel("0");
        JLabel beInFloridaMinLabel = gridLabel("0");
        _centerPanel = new JPanel(new GridLayout(9, 4));
        pack();
        _centerPanel.setPreferredSize(new Dimension(400, 400));
        _centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        _centerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        _centerPanel.add(blank);
        _centerPanel.add(paradiseNameLabel);
        _centerPanel.add(clcNameLabel);
        _centerPanel.add(beInFloridaNameLabel);
        _centerPanel.add(rentalIncomeLabel);
        _centerPanel.add(paradiseRentalIncomeLabel);
        _centerPanel.add(clcRentalIncomeLabel);
        _centerPanel.add(beInFloridaIncomeLabel);
        _centerPanel.add(commissionLabel);
        _centerPanel.add(parCommissionLabel);
        _centerPanel.add(clcCommissionLabel);
        _centerPanel.add(beInFloridaCommissionLabel);
        _centerPanel.add(bookingChargesLabel);
        _centerPanel.add(parBookingChargeLabel);
        _centerPanel.add(clcBookingChargeLabel);
        _centerPanel.add(beInFloridaBookingChargeLabel);
        _centerPanel.add(managementFeeLabel);
        _centerPanel.add(parManagementFeeLabel);
        _centerPanel.add(clcManagementFeeLabel);
        _centerPanel.add(beInFloridaManagementFeeLabel);
        _centerPanel.add(cleaningLabel);
        _centerPanel.add(parCleaningLabel);
        _centerPanel.add(clcCleaningLabel);
        _centerPanel.add(beInFloridaCleaningLabel);
        _centerPanel.add(resortManagementServicesLabel);
        _centerPanel.add(parRMSLabel);
        _centerPanel.add(clcRMSLabel);
        _centerPanel.add(beInFloridaRMSLabel);
        _centerPanel.add(totalMaxIncome);
        _centerPanel.add(parMaxLabel);
        _centerPanel.add(clcMaxLabel);
        _centerPanel.add(beInFloridaMaxLabel);
        _centerPanel.add(totalMinIncome);
        _centerPanel.add(parMinLabel);
        _centerPanel.add(clcMinLabel);
        _centerPanel.add(beInFloridaMinLabel);
    }

    private JLabel gridLabel(String text) {
        JLabel label = new JLabel(text, 0);
        label.setBorder(BorderFactory.createRaisedBevelBorder());
        return label;
    }

    private void createLeftPanel() {
        _leftPanel = new JPanel();
        pack();
        _leftPanel.setPreferredSize(new Dimension(200, 400));
        _leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        _leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        if (_house.getPurchasePrice() != null) {
            purchasePriceLabel = new JLabel("Purchase Price: " + _house.getPurchasePrice().toString());
        } else {
            purchasePriceLabel = new JLabel("Purchase Price: ");
        }

        if (_house.getUpdatesPrice() != null) {
            updatesPriceLabel = new JLabel("Update Price:  " + _house.getUpdatesPrice().toString());
        } else {
            updatesPriceLabel = new JLabel("Update Price:  ");
        }

        if (_house.getPiti() != null) {
            pitiLabel = new JLabel("PITI: " + _house.getPiti().toString());
        } else {
            pitiLabel = new JLabel("PITI: ");
        }

        if (_house.getAddress1() != null) {
            address1Label = new JLabel("Address 1: " + _house.getAddress1());
        } else {
            address1Label = new JLabel("Address 1: ");
        }

        if (_house.getAddress2() != null) {
            address2Label = new JLabel("Address 2: " + _house.getAddress2());
        } else {
            address2Label = new JLabel("Address 2: ");
        }

        if (_house.getZip() != null) {
            zipLabel = new JLabel("Zip: " + _house.getZip());
        } else {
            zipLabel = new JLabel("Zip: ");
        }

        if (_house.getHoaFee() != null) {
            hoaFeeLabel = new JLabel("HOA Fee: " + _house.getHoaFee().toString());
        } else {
            hoaFeeLabel = new JLabel("HOA Fee: ");
        }

        if (_house.getTaxes() != null) {
            taxesLabel = new JLabel("Taxes: " + _house.getTaxes().toString());
        } else {
            taxesLabel = new JLabel("Taxes: ");
        }

        if (_house.getInsurance() != null) {
            insuranceLabel = new JLabel("Insurance: " + _house.getInsurance().toString());
        } else {
            insuranceLabel = new JLabel("Insurance: ");
        }

        if (_house.getRentalIncome() != null) {
            rentalIncomeLabel = new JLabel("Rental Income: " + _house.getRentalIncome().toString());
        } else {
            rentalIncomeLabel = new JLabel("Rental Income: ");
        }

        purchasePriceLabel.setPreferredSize(new Dimension(200, 15));
        updatesPriceLabel.setPreferredSize(new Dimension(200, 15));
        pitiLabel.setPreferredSize(new Dimension(200, 15));
        address1Label.setPreferredSize(new Dimension(200, 15));
        address2Label.setPreferredSize(new Dimension(200, 15));
        zipLabel.setPreferredSize(new Dimension(200, 15));
        hoaFeeLabel.setPreferredSize(new Dimension(200, 15));
        taxesLabel.setPreferredSize(new Dimension(200, 15));
        insuranceLabel.setPreferredSize(new Dimension(200, 15));
        rentalIncomeLabel.setPreferredSize(new Dimension(200, 15));
        _leftPanel.add(address1Label);
        _leftPanel.add(address2Label);
        _leftPanel.add(zipLabel);
        _leftPanel.add(purchasePriceLabel);
        _leftPanel.add(updatesPriceLabel);
        _leftPanel.add(pitiLabel);
        _leftPanel.add(hoaFeeLabel);
        _leftPanel.add(taxesLabel);
        _leftPanel.add(insuranceLabel);
        _leftPanel.add(rentalIncomeLabel);
    }

    private void createBottomPanel() {
        _bottomPanel = new JPanel();
        houseInfoPane = new JButton();
        houseInfoPane.setPreferredSize(new Dimension(100, 20));
        houseInfoPane.setText("House Info");
        houseInfoPane.addActionListener(new houseListenter());
        _bottomPanel.add(houseInfoPane);
    }

    private class houseListenter implements ActionListener {
        private houseListenter() {
        }

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            (new HouseInfoPane(_house)).setVisible(true);
        }
    }

    private class paradiceRmcListenter implements ActionListener {
        private paradiceRmcListenter() {
        }

        public void actionPerformed(ActionEvent e) {
        }
    }

    private class clcRmcListenter implements ActionListener {
        private clcRmcListenter() {
        }

        public void actionPerformed(ActionEvent e) {
        }
    }
}
