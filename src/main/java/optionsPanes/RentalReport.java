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
import main.java.utils.PaneUtils;

public class RentalReport extends JFrame {
    private House _house;
    private JPanel _panel, _bottomPanel, _leftPanel, _centerPanel;
    private RentalManagementCompany _paradiseRmc, _clcRmc, _beInFloridaRmc;
    private CalculationUtils utils = new CalculationUtils();
    private PaneUtils paneUtils = new PaneUtils();

    public static void main(String[] args) {
        House house = new House(new BigDecimal(200000), new BigDecimal(2000), "123 Brandon Way", "Apt. 3", "12345", new BigDecimal(300), new BigDecimal(150), new BigDecimal(150), new BigDecimal(4000), new BigDecimal(100), new BigDecimal(1200));
        SwingUtilities.invokeLater(() -> new RentalReport(house));
    }


    public RentalReport(House house) {
        _house = new House(house.getPurchasePrice(), house.getUpdatesPrice(), house.getAddress1(), house.getAddress2(),
                house.getZip(), house.getHoaFee(), house.getTaxes(), house.getInsurance(), house.getRentalIncome(), house.getWaterCost(),
                house.getMortgage());
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
        _centerPanel = new JPanel(new GridLayout(12, 4));
        pack();
        _centerPanel.setPreferredSize(new Dimension(400, 400));
        _centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        _centerPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        _centerPanel.add(paneUtils.gridLabel(""));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getCompanyName()), true);
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getCompanyName()), true);
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getCompanyName()), true);

        _centerPanel.add(paneUtils.gridLabel("Rental Income"));
        JLabel paradiseRentalIncomeLabel;
        JLabel clcRentalIncomeLabel;
        JLabel beInFloridaIncomeLabel;
        if (_house.getRentalIncome() != null) {
            paradiseRentalIncomeLabel = paneUtils.gridLabel(_house.getRentalIncome().toString());
            clcRentalIncomeLabel = paneUtils.gridLabel(_house.getRentalIncome().toString());
            beInFloridaIncomeLabel = paneUtils.gridLabel(_house.getRentalIncome().toString());
        } else {
            paradiseRentalIncomeLabel = paneUtils.gridLabel("");
            clcRentalIncomeLabel = paneUtils.gridLabel("");
            beInFloridaIncomeLabel = paneUtils.gridLabel("");
        }
        _centerPanel.add(paradiseRentalIncomeLabel);
        _centerPanel.add(clcRentalIncomeLabel);
        _centerPanel.add(beInFloridaIncomeLabel);

        _centerPanel.add(paneUtils.gridLabel("TOTAL INCOME", true));
        _centerPanel.add(paneUtils.gridLabel(utils.getTotalIncome(_house), true));
        _centerPanel.add(paneUtils.gridLabel(utils.getTotalIncome(_house), true));
        _centerPanel.add(paneUtils.gridLabel(utils.getTotalIncome(_house), true));

        _centerPanel.add(paneUtils.gridLabel("Commission"));
        _centerPanel.add(paneUtils.gridLabel(utils.getCommission(_house, _paradiseRmc)));
        _centerPanel.add(paneUtils.gridLabel(utils.getCommission(_house, _clcRmc)));
        _centerPanel.add(paneUtils.gridLabel(utils.getCommission(_house, _beInFloridaRmc)));

        _centerPanel.add(paneUtils.gridLabel("Max Booking Charges"));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaxBookingCharge(_house, _paradiseRmc)));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaxBookingCharge(_house, _clcRmc)));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaxBookingCharge(_house, _beInFloridaRmc)));

        _centerPanel.add(paneUtils.gridLabel("Management Fee"));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getManagementFee().toString()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getManagementFee().toString()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getManagementFee().toString()));

        _centerPanel.add(paneUtils.gridLabel("Cleaning Fee"));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getCleaningFee().toString()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getCleaningFee().toString()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getCleaningFee().toString()));

        _centerPanel.add(paneUtils.gridLabel("Resort Management Services"));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getResortManagementFee().toString()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getResortManagementFee().toString()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getResortManagementFee().toString()));

        _centerPanel.add(paneUtils.gridLabel("TOTAL RMC COST", true));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaximumRmcCost(_house, _paradiseRmc).toString(), true));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaximumRmcCost(_house, _clcRmc).toString(), true));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaximumRmcCost(_house, _beInFloridaRmc).toString(), true));

        _centerPanel.add(paneUtils.gridLabel("Max Income"));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaxIncome(_house, _paradiseRmc)));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaxIncome(_house, _clcRmc)));
        _centerPanel.add(paneUtils.gridLabel(utils.getMaxIncome(_house, _beInFloridaRmc)));

        _centerPanel.add(paneUtils.gridLabel("Min Income"));
        _centerPanel.add(paneUtils.gridLabel(utils.getMinIncome(_house, _paradiseRmc)));
        _centerPanel.add(paneUtils.gridLabel(utils.getMinIncome(_house, _clcRmc)));
        _centerPanel.add(paneUtils.gridLabel(utils.getMinIncome(_house, _beInFloridaRmc)));
    }

    private void createLeftPanel() {
        _leftPanel = new JPanel();
        pack();
        _leftPanel.setPreferredSize(new Dimension(200, 400));
        _leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        _leftPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        JLabel purchasePriceLabel;
        if (_house.getPurchasePrice() != null) {
            purchasePriceLabel = new JLabel("Purchase Price: " + _house.getPurchasePrice().toString());
        } else {
            purchasePriceLabel = new JLabel("Purchase Price: ");
        }

        JLabel updatesPriceLabel;
        if (_house.getUpdatesPrice() != null) {
            updatesPriceLabel = new JLabel("Update Price:  " + _house.getUpdatesPrice().toString());
        } else {
            updatesPriceLabel = new JLabel("Update Price:  ");
        }

        JLabel address1Label;
        if (_house.getAddress1() != null) {
            address1Label = new JLabel("Address 1: " + _house.getAddress1());
        } else {
            address1Label = new JLabel("Address 1: ");
        }

        JLabel address2Label;
        if (_house.getAddress2() != null) {
            address2Label = new JLabel("Address 2: " + _house.getAddress2());
        } else {
            address2Label = new JLabel("Address 2: ");
        }

        JLabel zipLabel;
        if (_house.getZip() != null) {
            zipLabel = new JLabel("Zip: " + _house.getZip());
        } else {
            zipLabel = new JLabel("Zip: ");
        }

        JLabel hoaFeeLabel;
        if (_house.getHoaFee() != null) {
            hoaFeeLabel = new JLabel("HOA Fee: " + _house.getHoaFee().toString());
        } else {
            hoaFeeLabel = new JLabel("HOA Fee: ");
        }

        JLabel taxesLabel;
        if (_house.getTaxes() != null) {
            taxesLabel = new JLabel("Taxes: " + _house.getTaxes().toString());
        } else {
            taxesLabel = new JLabel("Taxes: ");
        }

        JLabel insuranceLabel;
        if (_house.getInsurance() != null) {
            insuranceLabel = new JLabel("Insurance: " + _house.getInsurance().toString());
        } else {
            insuranceLabel = new JLabel("Insurance: ");
        }

        JLabel rentalIncomeLabel;
        if (_house.getRentalIncome() != null) {
            rentalIncomeLabel = new JLabel("Rental Income: " + _house.getRentalIncome().toString());
        } else {
            rentalIncomeLabel = new JLabel("Rental Income: ");
        }

        purchasePriceLabel.setPreferredSize(new Dimension(200, 15));
        updatesPriceLabel.setPreferredSize(new Dimension(200, 15));
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
        _leftPanel.add(hoaFeeLabel);
        _leftPanel.add(taxesLabel);
        _leftPanel.add(insuranceLabel);
        _leftPanel.add(rentalIncomeLabel);
    }

    private void createBottomPanel() {
        _bottomPanel = new JPanel();
        JButton houseButton = new JButton();
        houseButton.setPreferredSize(new Dimension(100, 20));
        houseButton.setText("House Info");
        houseButton.addActionListener(new houseListenter());

        JButton rmcInfoPane = new JButton();
        rmcInfoPane.setPreferredSize(new Dimension(100, 20));
        rmcInfoPane.setText("Rental Management Info");
        rmcInfoPane.addActionListener(new rmcListenter());

        _bottomPanel.add(houseButton);
        _bottomPanel.add(rmcInfoPane);
    }

    private class houseListenter implements ActionListener {
        private houseListenter() {
        }

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            (new HouseInfoPane(_house)).setVisible(true);
        }
    }

    private class rmcListenter implements ActionListener {
        private rmcListenter() {
        }

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            (new RmcInfoPane(_paradiseRmc, _clcRmc, _beInFloridaRmc, _house)).setVisible(true);
        }
    }

}
