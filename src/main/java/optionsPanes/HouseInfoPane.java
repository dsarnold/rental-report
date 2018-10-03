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
    taxesTextbox, insuranceTextbox, rentalIncomeTextbox;
       private JLabel purchasePriceLabel;
    private JLabel updatesPriceLabel, pitiLabel, address1Label, address2Label, zipLabel, hoaFeeLabel, taxesLabel, insuranceLabel, rentalIncomeLabel;
    private JButton submitButton;
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
        purchasePriceLabel = new JLabel("Purchase Price: ");
        updatesPriceLabel = new JLabel("Update Price: ");
        pitiLabel = new JLabel("PITI: ");
        address1Label = new JLabel("Address 1: ");
        address2Label = new JLabel("Address 2: ");
        zipLabel = new JLabel("Zip: ");
        hoaFeeLabel = new JLabel("HOA Fees");
        taxesLabel = new JLabel("Taxes");
        insuranceLabel = new JLabel("Insurance: ");
        rentalIncomeLabel = new JLabel("Rental Income: ");
        purchasePriceTextbox = new JTextField(50);
        if (_house.getPurchasePrice() != null) {
            purchasePriceTextbox.setText(_house.getPurchasePrice().toString());
        }

        updatesPriceTextbox = new JTextField(50);
        if (_house.getUpdatesPrice() != null) {
            updatesPriceTextbox.setText(_house.getUpdatesPrice().toString());
        }

        pitiTextbox = new JTextField(5);
        if (_house.getPiti() != null) {
            pitiTextbox.setText(_house.getPiti().toString());
        }

        address1Textbox = new JTextField(5);
        if (_house.getAddress1() != null) {
            address1Textbox.setText(_house.getAddress1());
        }

        address2Textbox = new JTextField(5);
        if (_house.getAddress2() != null) {
            address2Textbox.setText(_house.getAddress2());
        }

        zipTextbox = new JTextField(5);
        if (_house.getZip() != null) {
            zipTextbox.setText(_house.getZip());
        }

        taxesTextbox = new JTextField(5);
        if (_house.getTaxes() != null) {
            taxesTextbox.setText(_house.getTaxes().toString());
        }

        hoaFeeTextbox = new JTextField(5);
        if (_house.getHoaFee() != null) {
            hoaFeeTextbox.setText(_house.getHoaFee().toString());
        }

        insuranceTextbox = new JTextField(5);
        if (_house.getInsurance() != null) {
            insuranceTextbox.setText(_house.getInsurance().toString());
        }

        rentalIncomeTextbox = new JTextField(5);
        if (_house.getRentalIncome() != null) {
            rentalIncomeTextbox.setText(_house.getRentalIncome().toString());
        }

        submitButton = new JButton();
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
        panel.add(purchasePriceLabel, left);
        panel.add(purchasePriceTextbox, right);
        panel.add(updatesPriceLabel, left);
        panel.add(updatesPriceTextbox, right);
        panel.add(pitiLabel, left);
        panel.add(pitiTextbox, right);
        panel.add(address1Label, left);
        panel.add(address1Textbox, right);
        panel.add(address2Label, left);
        panel.add(address2Textbox, right);
        panel.add(zipLabel, left);
        panel.add(zipTextbox, right);
        panel.add(hoaFeeLabel, left);
        panel.add(hoaFeeTextbox, right);
        panel.add(taxesLabel, left);
        panel.add(taxesTextbox, right);
        panel.add(insuranceLabel, left);
        panel.add(insuranceTextbox, right);
        panel.add(rentalIncomeLabel, left);
        panel.add(rentalIncomeTextbox, right);
    }

    private class submitListener implements ActionListener {
        private submitListener() {
        }

        public void actionPerformed(ActionEvent e) {
            if (purchasePriceTextbox.getText().length() != 0) {
                _house.withPurchasePrice(new BigDecimal(purchasePriceTextbox.getText()));
            }

            if (updatesPriceTextbox.getText().length() != 0) {
                _house.withUpdatesPrice(new BigDecimal(updatesPriceTextbox.getText()));
            }

            if (pitiTextbox.getText().length() != 0) {
                _house.withPiti(new BigDecimal(pitiTextbox.getText()));
            }

            if (address1Textbox.getText().length() != 0) {
                _house.withAddress1(address1Textbox.getText());
            }

            if (address2Textbox.getText().length() != 0) {
                _house.withAddress2(address2Textbox.getText());
            }

            if (zipTextbox.getText().length() != 0) {
                _house.withZip(zipTextbox.getText());
            }

            if (hoaFeeTextbox.getText().length() != 0) {
                _house.withHoaFee(new BigDecimal(hoaFeeTextbox.getText()));
            }

            if (taxesTextbox.getText().length() != 0) {
                _house.withTaxes(new BigDecimal(taxesTextbox.getText()));
            }

            if (insuranceTextbox.getText().length() != 0) {
                _house.withInsurance(new BigDecimal(insuranceTextbox.getText()));
            }

            if (rentalIncomeTextbox.getText().length() != 0) {
                _house.withRentalIncome(new BigDecimal(rentalIncomeTextbox.getText()));
            }

            setVisible(false);
            (new RentalReport(_house)).setVisible(true);
        }
    }
}
