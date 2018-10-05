package main.java.optionsPanes;

import java.awt.*;
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
    private JTextField purchasePriceTextbox, updatesPriceTextbox, address1Textbox, address2Textbox, zipTextbox, hoaFeeTextbox,
            taxesTextbox, insuranceTextbox, rentalIncomeTextbox, waterCostTextbox, mortgageTextbox;
    JLabel _paradiseRentalIncomeLabel, _clcRentalIncomeLabel, _beInFloridaRentalIncomeLabel, _paradiseTotalIncomeLabel, _clcTotalIncomeLabel, _beInFloridaTotalIncomeLabel,
            _paradiseCommissionLabel, _clcCommissionLabel, _beInFloridaCommissionLabel, _paradiseMaxBookingChargeLabel, _clcMaxBookingChargeLabel, _beInFloridaMaxBookingChargeLabel,
            _paradiseManagementFeeLabel, _clcManagementFeeLabel, _beInFloridaManagementFeeLabel, _paradiseCleaningFeeLabel, _clcCleaningFeeLabel, _beInFloridaCleaningFeeLabel,
            _paradiseTotalRmcCostLabel, _clcTotalRmcCostLabel, _beInFloridaTotalRmcCostLabel, _paradiseMaxIncomeLabel, _clcMaxIncomeLabel, _beInFloridaMaxIncomeLabel,
            _paradiseMinIncomeLabel, _clcMinIncomeLabel, _beInFloridaMinIncomeLabel, _paradiseResortManagementFeeLabel, _clcResortManagementFeeLabel, _beInFloridaResortManagementFeeLabel;


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
        if (_house.getRentalIncome() != null) {
            _paradiseRentalIncomeLabel = paneUtils.gridLabel(_house.getRentalIncome().toString());
            _clcRentalIncomeLabel = paneUtils.gridLabel(_house.getRentalIncome().toString());
            _beInFloridaRentalIncomeLabel = paneUtils.gridLabel(_house.getRentalIncome().toString());
        } else {
            _paradiseRentalIncomeLabel = paneUtils.gridLabel("");
            _clcRentalIncomeLabel = paneUtils.gridLabel("");
            _beInFloridaRentalIncomeLabel = paneUtils.gridLabel("");
        }
        _centerPanel.add(_paradiseRentalIncomeLabel);
        _centerPanel.add(_clcRentalIncomeLabel);
        _centerPanel.add(_beInFloridaRentalIncomeLabel);

        _centerPanel.add(paneUtils.gridLabel("TOTAL INCOME", true));
        _paradiseTotalIncomeLabel = paneUtils.gridLabel(utils.getTotalIncome(_house), true);
        _clcTotalIncomeLabel = paneUtils.gridLabel(utils.getTotalIncome(_house), true);
        _beInFloridaTotalIncomeLabel = paneUtils.gridLabel(utils.getTotalIncome(_house), true);
        _centerPanel.add(_paradiseTotalIncomeLabel);
        _centerPanel.add(_clcTotalIncomeLabel);
        _centerPanel.add(_beInFloridaTotalIncomeLabel);

        _centerPanel.add(paneUtils.gridLabel("Commission"));
        _paradiseCommissionLabel = paneUtils.gridLabel(utils.getCommission(_house, _paradiseRmc));
        _clcCommissionLabel = paneUtils.gridLabel(utils.getCommission(_house, _clcRmc));
        _beInFloridaCommissionLabel = paneUtils.gridLabel(utils.getCommission(_house, _beInFloridaRmc));
        _centerPanel.add(_paradiseCommissionLabel);
        _centerPanel.add(_clcCommissionLabel);
        _centerPanel.add(_beInFloridaCommissionLabel);

        _centerPanel.add(paneUtils.gridLabel("Max Booking Charges"));
        _paradiseMaxBookingChargeLabel = paneUtils.gridLabel(utils.getMaxBookingCharge(_house, _paradiseRmc));
        _clcMaxBookingChargeLabel = paneUtils.gridLabel(utils.getMaxBookingCharge(_house, _clcRmc));
        _beInFloridaMaxBookingChargeLabel = paneUtils.gridLabel(utils.getMaxBookingCharge(_house, _beInFloridaRmc));
        _centerPanel.add(_paradiseMaxBookingChargeLabel);
        _centerPanel.add(_clcMaxBookingChargeLabel);
        _centerPanel.add(_beInFloridaMaxBookingChargeLabel);

        _centerPanel.add(paneUtils.gridLabel("Management Fee"));
        _paradiseManagementFeeLabel = paneUtils.gridLabel(_paradiseRmc.getManagementFee().toString());
        _clcManagementFeeLabel = paneUtils.gridLabel(_clcRmc.getManagementFee().toString());
        _beInFloridaManagementFeeLabel = paneUtils.gridLabel(_beInFloridaRmc.getManagementFee().toString());
        _centerPanel.add(_paradiseManagementFeeLabel);
        _centerPanel.add(_clcManagementFeeLabel);
        _centerPanel.add(_beInFloridaManagementFeeLabel);

        _centerPanel.add(paneUtils.gridLabel("Cleaning Fee"));
        _paradiseCleaningFeeLabel = paneUtils.gridLabel(_paradiseRmc.getCleaningFee().toString());
        _clcCleaningFeeLabel = paneUtils.gridLabel(_clcRmc.getCleaningFee().toString());
        _beInFloridaCleaningFeeLabel = paneUtils.gridLabel(_beInFloridaRmc.getCleaningFee().toString());
        _centerPanel.add(_paradiseCleaningFeeLabel);
        _centerPanel.add(_clcCleaningFeeLabel);
        _centerPanel.add(_beInFloridaCleaningFeeLabel);

        _centerPanel.add(paneUtils.gridLabel("Resort Management Services"));
        _paradiseResortManagementFeeLabel = paneUtils.gridLabel(_paradiseRmc.getResortManagementFee().toString());
        _clcResortManagementFeeLabel = paneUtils.gridLabel(_clcRmc.getResortManagementFee().toString());
        _beInFloridaResortManagementFeeLabel = paneUtils.gridLabel(_beInFloridaRmc.getResortManagementFee().toString());
        _centerPanel.add(_paradiseResortManagementFeeLabel);
        _centerPanel.add(_clcResortManagementFeeLabel);
        _centerPanel.add(_beInFloridaResortManagementFeeLabel);

        _centerPanel.add(paneUtils.gridLabel("TOTAL RMC COST", true));
        _paradiseTotalRmcCostLabel = paneUtils.gridLabel(utils.getMaximumRmcCost(_house, _paradiseRmc).toString(), true);
        _clcTotalRmcCostLabel = paneUtils.gridLabel(utils.getMaximumRmcCost(_house, _clcRmc).toString(), true);
        _beInFloridaTotalRmcCostLabel = paneUtils.gridLabel(utils.getMaximumRmcCost(_house, _beInFloridaRmc).toString(), true);
        _centerPanel.add(_paradiseTotalRmcCostLabel);
        _centerPanel.add(_clcTotalRmcCostLabel);
        _centerPanel.add(_beInFloridaTotalRmcCostLabel);

        _centerPanel.add(paneUtils.gridLabel("Max Income"));
        _paradiseMaxIncomeLabel = paneUtils.gridLabel(utils.getMaxIncome(_house, _paradiseRmc));
        _clcMaxIncomeLabel = paneUtils.gridLabel(utils.getMaxIncome(_house, _clcRmc));
        _beInFloridaMaxIncomeLabel = paneUtils.gridLabel(utils.getMaxIncome(_house, _beInFloridaRmc));
        _centerPanel.add(_paradiseMaxIncomeLabel);
        _centerPanel.add(_clcMaxIncomeLabel);
        _centerPanel.add(_beInFloridaMaxIncomeLabel);

        _centerPanel.add(paneUtils.gridLabel("Min Income"));
        _paradiseMinIncomeLabel = paneUtils.gridLabel(utils.getMinIncome(_house, _paradiseRmc));
        _clcMinIncomeLabel = paneUtils.gridLabel(utils.getMinIncome(_house, _clcRmc));
        _beInFloridaMinIncomeLabel = paneUtils.gridLabel(utils.getMinIncome(_house, _beInFloridaRmc));
        _centerPanel.add(_paradiseMinIncomeLabel);
        _centerPanel.add(_clcMinIncomeLabel);
        _centerPanel.add(_beInFloridaMinIncomeLabel);
    }

    private void repaintCenterText() {

        _paradiseRentalIncomeLabel.setText(_house.getRentalIncome().toString());
        _clcRentalIncomeLabel.setText(_house.getRentalIncome().toString());
        _beInFloridaRentalIncomeLabel.setText(_house.getRentalIncome().toString());

        _paradiseTotalIncomeLabel.setText(utils.getTotalIncome(_house));
        _clcTotalIncomeLabel.setText(utils.getTotalIncome(_house));
        _beInFloridaTotalIncomeLabel.setText(utils.getTotalIncome(_house));

        _paradiseCommissionLabel.setText(utils.getCommission(_house, _paradiseRmc));
        _clcCommissionLabel.setText(utils.getCommission(_house, _clcRmc));
        _beInFloridaCommissionLabel.setText(utils.getCommission(_house, _beInFloridaRmc));

        _paradiseMaxBookingChargeLabel.setText(utils.getMaxBookingCharge(_house, _paradiseRmc));
        _clcMaxBookingChargeLabel.setText(utils.getMaxBookingCharge(_house, _clcRmc));
        _beInFloridaMaxBookingChargeLabel.setText(utils.getMaxBookingCharge(_house, _beInFloridaRmc));

        _paradiseManagementFeeLabel.setText(_paradiseRmc.getManagementFee().toString());
        _clcManagementFeeLabel.setText(_clcRmc.getManagementFee().toString());
        _beInFloridaManagementFeeLabel.setText(_beInFloridaRmc.getManagementFee().toString());

        _paradiseCleaningFeeLabel.setText(_paradiseRmc.getCleaningFee().toString());
        _clcCleaningFeeLabel.setText(_clcRmc.getCleaningFee().toString());
        _beInFloridaCleaningFeeLabel.setText(_beInFloridaRmc.getCleaningFee().toString());

        _paradiseResortManagementFeeLabel.setText(_paradiseRmc.getResortManagementFee().toString());
        _clcResortManagementFeeLabel.setText(_clcRmc.getResortManagementFee().toString());
        _beInFloridaResortManagementFeeLabel.setText(_beInFloridaRmc.getResortManagementFee().toString());

        _paradiseTotalRmcCostLabel.setText(utils.getMaximumRmcCost(_house, _paradiseRmc).toString());
        _clcTotalRmcCostLabel.setText(utils.getMaximumRmcCost(_house, _clcRmc).toString());
        _beInFloridaTotalRmcCostLabel.setText(utils.getMaximumRmcCost(_house, _beInFloridaRmc).toString());

        _paradiseMaxIncomeLabel.setText(utils.getMaxIncome(_house, _paradiseRmc));
        _clcMaxIncomeLabel.setText(utils.getMaxIncome(_house, _clcRmc));
        _beInFloridaMaxIncomeLabel.setText(utils.getMaxIncome(_house, _beInFloridaRmc));

        _paradiseMinIncomeLabel.setText(utils.getMinIncome(_house, _paradiseRmc));
        _clcMinIncomeLabel.setText(utils.getMinIncome(_house, _clcRmc));
        _beInFloridaMinIncomeLabel.setText(utils.getMinIncome(_house, _beInFloridaRmc));
    }

    private void createLeftPanel() {
        _leftPanel = new JPanel();
        _leftPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        _leftPanel.setPreferredSize(new Dimension(300, 400));

        _leftPanel.setLayout(new GridBagLayout());

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = 13;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0D;
        right.fill = 2;
        right.gridwidth = 0;

        _leftPanel.add(new JLabel("Purchase Price: "), left);
        purchasePriceTextbox = new JTextField(50);
        purchasePriceTextbox.addActionListener(new textboxListener());
        if (_house.getPurchasePrice() != null) {
            purchasePriceTextbox.setText(_house.getPurchasePrice().toString());
        }
        _leftPanel.add(purchasePriceTextbox, right);

        _leftPanel.add(new JLabel("Update Price: "), left);
        updatesPriceTextbox = new JTextField(50);
        updatesPriceTextbox.addActionListener(new textboxListener());
        if (_house.getUpdatesPrice() != null) {
            updatesPriceTextbox.setText(_house.getUpdatesPrice().toString());
        }
        _leftPanel.add(updatesPriceTextbox, right);

        _leftPanel.add(new JLabel("Address 1: "), left);
        address1Textbox = new JTextField(5);
        address1Textbox.addActionListener(new textboxListener());
        if (_house.getAddress1() != null) {
            address1Textbox.setText(_house.getAddress1());
        }
        _leftPanel.add(address1Textbox, right);

        _leftPanel.add(new JLabel("Address 2: "), left);
        address2Textbox = new JTextField(5);
        address2Textbox.addActionListener(new textboxListener());
        if (_house.getAddress2() != null) {
            address2Textbox.setText(_house.getAddress2());
        }
        _leftPanel.add(address2Textbox, right);

        _leftPanel.add(new JLabel("Zip: "), left);
        zipTextbox = new JTextField(5);
        zipTextbox.addActionListener(new textboxListener());
        if (_house.getZip() != null) {
            zipTextbox.setText(_house.getZip());
        }
        _leftPanel.add(zipTextbox, right);

        _leftPanel.add(new JLabel("HOA Fees"), left);
        hoaFeeTextbox = new JTextField(5);
        hoaFeeTextbox.addActionListener(new textboxListener());
        if (_house.getHoaFee() != null) {
            hoaFeeTextbox.setText(_house.getHoaFee().toString());
        }
        _leftPanel.add(hoaFeeTextbox, right);

        _leftPanel.add(new JLabel("Taxes"), left);
        taxesTextbox = new JTextField(5);
        taxesTextbox.addActionListener(new textboxListener());
        if (_house.getTaxes() != null) {
            taxesTextbox.setText(_house.getTaxes().toString());
        }
        _leftPanel.add(taxesTextbox, right);

        _leftPanel.add(new JLabel("Insurance: "), left);
        insuranceTextbox = new JTextField(5);
        insuranceTextbox.addActionListener(new textboxListener());
        if (_house.getInsurance() != null) {
            insuranceTextbox.setText(_house.getInsurance().toString());
        }
        _leftPanel.add(insuranceTextbox, right);

        _leftPanel.add(new JLabel("Rental Income: "), left);
        rentalIncomeTextbox = new JTextField(5);
        rentalIncomeTextbox.addActionListener(new textboxListener());
        if (_house.getRentalIncome() != null) {
            rentalIncomeTextbox.setText(_house.getRentalIncome().toString());
        }
        _leftPanel.add(rentalIncomeTextbox, right);

        _leftPanel.add(new JLabel("Water Cost: "), left);
        waterCostTextbox = new JTextField(5);
        waterCostTextbox.addActionListener(new textboxListener());
        if (_house.getWaterCost() != null) {
            waterCostTextbox.setText(_house.getWaterCost().toString());
        }
        _leftPanel.add(waterCostTextbox, right);

        _leftPanel.add(new JLabel("Mortgage: "), left);
        mortgageTextbox = new JTextField(5);
        mortgageTextbox.addActionListener(new textboxListener());
        if (_house.getMortgage() != null) {
            mortgageTextbox.setText(_house.getMortgage().toString());
        }
        _leftPanel.add(mortgageTextbox, right);

        JButton submitButton = new JButton();
        submitButton.setText("Update House Info");
        submitButton.addActionListener(new textboxListener());
        _leftPanel.add(submitButton);
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

    public class textboxListener implements ActionListener {
        private textboxListener() {
        }

        public void actionPerformed(ActionEvent e) {
            if (purchasePriceTextbox.getText().length() != 0) {
                _house.setPurchasePrice(new BigDecimal(purchasePriceTextbox.getText()));
            }

            if (updatesPriceTextbox.getText().length() != 0) {
                _house.setUpdatesPrice(new BigDecimal(updatesPriceTextbox.getText()));
            }

            if (address1Textbox.getText().length() != 0) {
                _house.setAddress1(address1Textbox.getText());
            }

            if (address2Textbox.getText().length() != 0) {
                _house.setAddress2(address2Textbox.getText());
            }

            if (zipTextbox.getText().length() != 0) {
                _house.setZip(zipTextbox.getText());
            }

            if (hoaFeeTextbox.getText().length() != 0) {
                _house.setHoaFee(new BigDecimal(hoaFeeTextbox.getText()));
            }

            if (taxesTextbox.getText().length() != 0) {
                _house.setTaxes(new BigDecimal(taxesTextbox.getText()));
            }

            if (insuranceTextbox.getText().length() != 0) {
                _house.setInsurance(new BigDecimal(insuranceTextbox.getText()));
            }

            if (waterCostTextbox.getText().length() != 0) {
                _house.setWaterCost(new BigDecimal(waterCostTextbox.getText()));
            }

            if (mortgageTextbox.getText().length() != 0) {
                _house.setMortgage(new BigDecimal(mortgageTextbox.getText()));
            }

            if (rentalIncomeTextbox.getText().length() != 0) {
                _house.setRentalIncome(new BigDecimal(rentalIncomeTextbox.getText()));
            }

            repaintCenterText();
        }
    }
}
