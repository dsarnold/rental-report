package main.optionsPanes;

import java.awt.BorderLayout;
import java.awt.Component;
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

import main.pojos.House;
import main.pojos.RentalManagementCompany;
import main.Utils.CalculationUtils;

public class RentalReport extends JFrame {
    private JButton houseInfoPane, clcRmc, paradiceRmc, vacationCentralFloridaRmc, calculateNumbers;
    private JLabel purchasePriceLabel, updatesPriceLabel, address1Label, address2Label, zipLabel, hoaFeeLabel,
            taxesLabel, insuranceLabel, rentalIncomeLabel, paradiseRentalIncomeLabel, clcRentalIncomeLabel, vipIncomeLabel, pitiLabel;
    private JTextField purchasePriceTextbox, updatesPriceTextbox, pitiTextbox, address1Textbox, address2Textbox, zipTextbox,
            hoaFeeTextbox, taxesTextbox, insuranceTextbox, rentalIncomeTextbox;
    private House _house;
    JPanel _panel, _southPanel, _westPanel, _centerPanel;
    private RentalManagementCompany _paradiseRmc, _clcRmc, _vipRmc;
    private CalculationUtils utils = new CalculationUtils();

    public static void main(String[] args) {
        House house = new House(new BigDecimal(200000), new BigDecimal(2000), new BigDecimal(1500), "123 Brandon Way", "Apt. 3", "12345", new BigDecimal(300), new BigDecimal(150), new BigDecimal(150), new BigDecimal(4000));
        SwingUtilities.invokeLater(() -> new RentalReport(house));
    }


    public RentalReport(House house) {
        _house = new House(house.getPurchasePrice(), house.getUpdatesPrice(), house.getPiti(), house.getAddress1(), house.getAddress2(), house.getZip(), house.getHoaFee(), house.getTaxes(), house.getInsurance(), house.getRentalIncome());
        _paradiseRmc = new RentalManagementCompany("Paradise", 0.2D, 0.0D, 0.0D, BigDecimal.valueOf(125L), BigDecimal.valueOf(0L), BigDecimal.valueOf(0L), BigDecimal.valueOf(0L), BigDecimal.valueOf(90L), BigDecimal.valueOf(25L));
        _vipRmc = new RentalManagementCompany("VIP", 0.2D, 0.12D, 0.06D, BigDecimal.valueOf(205L), BigDecimal.valueOf(0L), BigDecimal.valueOf(150L), BigDecimal.valueOf(125L), BigDecimal.valueOf(0L), BigDecimal.valueOf(0L));
        _clcRmc = new RentalManagementCompany("CLC", 0.2D, 0.12D, 0.06D, BigDecimal.valueOf(205L), BigDecimal.valueOf(0L), BigDecimal.valueOf(35L), BigDecimal.valueOf(125L), BigDecimal.valueOf(0L), BigDecimal.valueOf(0L));
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
        _panel.add(_southPanel, "South");
        _panel.add(_westPanel, "West");
    }

    private void createCenterPanel() {
        JLabel blank = gridLabel("");
        JLabel paradiseNameLabel = gridLabel("Paradise");
        JLabel clcNameLabel = gridLabel("CLC World Resorts");
        JLabel virOrlandoNameLabel = gridLabel("VIP");
        JLabel rentalIncomeLabel = gridLabel("Rental Income");
        if (_house.getRentalIncome() != null) {
            paradiseRentalIncomeLabel = gridLabel(_house.getRentalIncome().toString());
            clcRentalIncomeLabel = gridLabel(_house.getRentalIncome().toString());
            vipIncomeLabel = gridLabel(_house.getRentalIncome().toString());
        } else {
            paradiseRentalIncomeLabel = gridLabel("");
            clcRentalIncomeLabel = gridLabel("");
            vipIncomeLabel = gridLabel("");
        }

        JLabel commissionLabel = gridLabel("Commission");
        JLabel parCommissionLabel = gridLabel(utils.getCommission(_house, _paradiseRmc));
        JLabel clcCommissionLabel = gridLabel(utils.getCommission(_house, _clcRmc));
        JLabel vipCommissionLabel = gridLabel(utils.getCommission(_house, _vipRmc));
        JLabel bookingChargesLabel = gridLabel("Max Booking Charges");
        JLabel parBookingChargeLabel = gridLabel(utils.getMaxBookingCharge(_house, _paradiseRmc));
        JLabel clcBookingChargeLabel = gridLabel(utils.getMaxBookingCharge(_house, _clcRmc));
        JLabel vipBookingChargeLabel = gridLabel(utils.getMaxBookingCharge(_house, _vipRmc));
        JLabel managementFeeLabel = gridLabel("Management Fee");
        JLabel parManagementFeeLabel = gridLabel(_paradiseRmc.getManagementFee().toString());
        JLabel clcManagementFeeLabel = gridLabel(_clcRmc.getManagementFee().toString());
        JLabel vipManagementFeeLabel = gridLabel(_vipRmc.getManagementFee().toString());
        JLabel cleaningLabel = gridLabel("Cleaning Fee");
        JLabel parCleaningLabel = gridLabel(_paradiseRmc.getCleaningFee().toString());
        JLabel clcCleaningLabel = gridLabel(_clcRmc.getCleaningFee().toString());
        JLabel vipCleaningLabel = gridLabel(_vipRmc.getCleaningFee().toString());
        JLabel resortManagementServicesLabel = gridLabel("Resort Management Services");
        JLabel parRMSLabel = gridLabel(_paradiseRmc.getResortManagementFee().toString());
        JLabel clcRMSLabel = gridLabel(_clcRmc.getResortManagementFee().toString());
        JLabel vipRMSLabel = gridLabel(_vipRmc.getResortManagementFee().toString());
        JLabel totalMaxIncome = gridLabel("Max Income");
        JLabel parMaxLabel = gridLabel(utils.getMaxIncome(_house, _paradiseRmc));
        JLabel clcMaxLabel = gridLabel(utils.getMaxIncome(_house, _clcRmc));
        JLabel vipMaxLabel = gridLabel(utils.getMaxIncome(_house, _vipRmc));
        JLabel totalMinIncome = gridLabel("Min Income");
        JLabel parMinLabel = gridLabel("0");
        JLabel clcMinLabel = gridLabel("0");
        JLabel vipMinLabel = gridLabel("0");
        _centerPanel = new JPanel(new GridLayout(9, 4));
        pack();
        _centerPanel.setPreferredSize(new Dimension(400, 400));
        _centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        _centerPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        _centerPanel.add(blank);
        _centerPanel.add(paradiseNameLabel);
        _centerPanel.add(clcNameLabel);
        _centerPanel.add(virOrlandoNameLabel);
        _centerPanel.add(rentalIncomeLabel);
        _centerPanel.add(paradiseRentalIncomeLabel);
        _centerPanel.add(clcRentalIncomeLabel);
        _centerPanel.add(vipIncomeLabel);
        _centerPanel.add(commissionLabel);
        _centerPanel.add(parCommissionLabel);
        _centerPanel.add(clcCommissionLabel);
        _centerPanel.add(vipCommissionLabel);
        _centerPanel.add(bookingChargesLabel);
        _centerPanel.add(parBookingChargeLabel);
        _centerPanel.add(clcBookingChargeLabel);
        _centerPanel.add(vipBookingChargeLabel);
        _centerPanel.add(managementFeeLabel);
        _centerPanel.add(parManagementFeeLabel);
        _centerPanel.add(clcManagementFeeLabel);
        _centerPanel.add(vipManagementFeeLabel);
        _centerPanel.add(cleaningLabel);
        _centerPanel.add(parCleaningLabel);
        _centerPanel.add(clcCleaningLabel);
        _centerPanel.add(vipCleaningLabel);
        _centerPanel.add(resortManagementServicesLabel);
        _centerPanel.add(parRMSLabel);
        _centerPanel.add(clcRMSLabel);
        _centerPanel.add(vipRMSLabel);
        _centerPanel.add(totalMaxIncome);
        _centerPanel.add(parMaxLabel);
        _centerPanel.add(clcMaxLabel);
        _centerPanel.add(vipMaxLabel);
        _centerPanel.add(totalMinIncome);
        _centerPanel.add(parMinLabel);
        _centerPanel.add(clcMinLabel);
        _centerPanel.add(vipMinLabel);
    }

    private JLabel gridLabel(String text) {
        JLabel label = new JLabel(text, 0);
        label.setBorder(BorderFactory.createRaisedBevelBorder());
        return label;
    }

    private void createLeftPanel() {
        _westPanel = new JPanel();
        pack();
        _westPanel.setPreferredSize(new Dimension(200, 400));
        _westPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        _westPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        if (_house.getPurchasePrice() != null) {
            purchasePriceLabel = new JLabel(_house.getPurchasePrice().toString());
        } else {
            purchasePriceLabel = new JLabel("Purchase Price: ");
        }

        if (_house.getUpdatesPrice() != null) {
            updatesPriceLabel = new JLabel(_house.getUpdatesPrice().toString());
        } else {
            updatesPriceLabel = new JLabel("Update Price:  ");
        }

        if (_house.getPiti() != null) {
            pitiLabel = new JLabel(_house.getPiti().toString());
        } else {
            pitiLabel = new JLabel("PITI: ");
        }

        if (_house.getAddress1() != null) {
            address1Label = new JLabel(_house.getAddress1());
        } else {
            address1Label = new JLabel("Address 1: ");
        }

        if (_house.getAddress2() != null) {
            address2Label = new JLabel(_house.getAddress2());
        } else {
            address2Label = new JLabel("Address 2: ");
        }

        if (_house.getZip() != null) {
            zipLabel = new JLabel(_house.getZip());
        } else {
            zipLabel = new JLabel("Zip: ");
        }

        if (_house.getHoaFee() != null) {
            hoaFeeLabel = new JLabel(_house.getHoaFee().toString());
        } else {
            hoaFeeLabel = new JLabel("HOA Fee: ");
        }

        if (_house.getTaxes() != null) {
            taxesLabel = new JLabel(_house.getTaxes().toString());
        } else {
            taxesLabel = new JLabel("Taxes: ");
        }

        if (_house.getInsurance() != null) {
            insuranceLabel = new JLabel(_house.getInsurance().toString());
        } else {
            insuranceLabel = new JLabel("Insurance: ");
        }

        if (_house.getRentalIncome() != null) {
            rentalIncomeLabel = new JLabel(_house.getRentalIncome().toString());
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
        _westPanel.add(address1Label);
        _westPanel.add(address2Label);
        _westPanel.add(zipLabel);
        _westPanel.add(purchasePriceLabel);
        _westPanel.add(updatesPriceLabel);
        _westPanel.add(pitiLabel);
        _westPanel.add(hoaFeeLabel);
        _westPanel.add(taxesLabel);
        _westPanel.add(insuranceLabel);
        _westPanel.add(rentalIncomeLabel);
    }

    private void createBottomPanel() {
        _southPanel = new JPanel();
        houseInfoPane = new JButton();
        houseInfoPane.setPreferredSize(new Dimension(100, 20));
        houseInfoPane.setText("House Info");
        houseInfoPane.addActionListener(new houseListenter());
        _southPanel.add(houseInfoPane);
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