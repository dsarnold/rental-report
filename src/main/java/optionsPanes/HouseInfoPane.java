package main.java.optionsPanes;

import main.java.House;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class HouseInfoPane extends JFrame {
    protected String purchasePrice, updatesPrice, piti, address1, address2, zip, hoaFee, taxes, insurance, rentalIncome;
    private JTextField purchasePriceTextbox, updatesPriceTextbox, pitiTextbox, address1Textbox, address2Textbox, zipTextbox, hoaFeeTextbox,
            taxesTextbox, insuranceTextbox, rentalIncomeTextbox, waterCostTextbox, mortgageTextbox;
    private House _house;

    public HouseInfoPane(House house) {
        _house = house;
        createView();
        setTitle("House Information");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    private void createView() {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(panel);

        JButton submitButton = new JButton();
        submitButton.setText("Update House Info");
        submitButton.addActionListener(new submitListener());
        getContentPane().add("South", submitButton);

        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        getContentPane().add(panel);
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = 13;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0D;
        right.fill = 2;
        right.gridwidth = 0;

        panel.add(new JLabel("Purchase Price: "), left);
        purchasePriceTextbox = new JTextField(50);
        if (_house.getPurchasePrice() != null) {
            purchasePriceTextbox.setText(_house.getPurchasePrice().toString());
        }
        panel.add(purchasePriceTextbox, right);

        panel.add(new JLabel("Update Price: "), left);
        updatesPriceTextbox = new JTextField(50);
        if (_house.getUpdatesPrice() != null) {
            updatesPriceTextbox.setText(_house.getUpdatesPrice().toString());
        }
        panel.add(updatesPriceTextbox, right);

        panel.add(new JLabel("Address 1: "), left);
        address1Textbox = new JTextField(5);
        if (_house.getAddress1() != null) {
            address1Textbox.setText(_house.getAddress1());
        }
        panel.add(address1Textbox, right);

        panel.add(new JLabel("Address 2: "), left);
        address2Textbox = new JTextField(5);
        if (_house.getAddress2() != null) {
            address2Textbox.setText(_house.getAddress2());
        }
        panel.add(address2Textbox, right);

        panel.add(new JLabel("Zip: "), left);
        zipTextbox = new JTextField(5);
        if (_house.getZip() != null) {
            zipTextbox.setText(_house.getZip());
        }
        panel.add(zipTextbox, right);

        panel.add(new JLabel("HOA Fees"), left);
        hoaFeeTextbox = new JTextField(5);
        if (_house.getHoaFee() != null) {
            hoaFeeTextbox.setText(_house.getHoaFee().toString());
        }
        panel.add(hoaFeeTextbox, right);

        panel.add(new JLabel("Taxes"), left);
        taxesTextbox = new JTextField(5);
        if (_house.getTaxes() != null) {
            taxesTextbox.setText(_house.getTaxes().toString());
        }
        panel.add(taxesTextbox, right);

        panel.add(new JLabel("Insurance: "), left);
        insuranceTextbox = new JTextField(5);
        if (_house.getInsurance() != null) {
            insuranceTextbox.setText(_house.getInsurance().toString());
        }
        panel.add(insuranceTextbox, right);

        panel.add(new JLabel("Rental Income: "), left);
        rentalIncomeTextbox = new JTextField(5);
        if (_house.getRentalIncome() != null) {
            rentalIncomeTextbox.setText(_house.getRentalIncome().toString());
        }
        panel.add(rentalIncomeTextbox, right);

        panel.add(new JLabel("Water Cost: "), left);
        waterCostTextbox = new JTextField(5);
        if (_house.getWaterCost() != null) {
            waterCostTextbox.setText(_house.getWaterCost().toString());
        }
        panel.add(waterCostTextbox, right);

        panel.add(new JLabel("Mortgage: "), left);
        mortgageTextbox = new JTextField(5);
        if (_house.getMortgage() != null) {
            mortgageTextbox.setText(_house.getMortgage().toString());
        }
        panel.add(mortgageTextbox, right);
    }

    private void createBottomPanel(){

    }

    private void createCenterPanel(){

    }

    private class submitListener implements ActionListener {
        private submitListener() {
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

            setVisible(false);
            (new RentalReport(_house)).setVisible(true);
        }
    }
}
