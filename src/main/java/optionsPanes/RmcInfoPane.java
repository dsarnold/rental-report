package main.java.optionsPanes;

import main.java.House;
import main.java.rentalManagementCompanies.RentalManagementCompany;
import main.java.utils.PaneUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RmcInfoPane extends JFrame {

    private JPanel _panel,_centerPanel, _bottomPanel;
    private PaneUtils paneUtils = new PaneUtils();
    private RentalManagementCompany _paradiseRmc, _clcRmc, _beInFloridaRmc;
    private House _house;

    public RmcInfoPane(RentalManagementCompany paradiseRmc, RentalManagementCompany clcRmc, RentalManagementCompany beInFloridaRmc, House house) {
        _paradiseRmc = paradiseRmc;
        _clcRmc = clcRmc;
        _beInFloridaRmc = beInFloridaRmc;
        _house = house;

        createView();
        setTitle("Rental Management Information");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);
    }

    private void createView() {
        _panel = new JPanel(new BorderLayout());
        _panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(_panel);
        setExtendedState(6);
        createCenterPanel();
        createBottomPanel();
        _panel.add(_centerPanel, "Center");
        _panel.add(_bottomPanel, "South");
    }
    
    private void createCenterPanel(){
        _centerPanel = new JPanel(new GridLayout(9, 4));
        pack();
        _centerPanel.setPreferredSize(new Dimension(400, 400));
        _centerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        _centerPanel.setBorder(BorderFactory.createRaisedBevelBorder());

        _centerPanel.add(paneUtils.gridLabel(""));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getCompanyName()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getCompanyName()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getCompanyName()));

        _centerPanel.add(paneUtils.gridLabel("Website"));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getWebsite()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getWebsite()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getWebsite()));

        _centerPanel.add(paneUtils.gridLabel("Phone Number"));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getPhoneNumber()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getPhoneNumber()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getPhoneNumber()));

        _centerPanel.add(paneUtils.gridLabel("Commission"));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getCommission().toString()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getCommission().toString()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getCommission().toString()));

        _centerPanel.add(paneUtils.gridLabel("Max Booking Charges"));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getMaxBookingCharge().toString()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getMaxBookingCharge().toString()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getMaxBookingCharge().toString()));

        _centerPanel.add(paneUtils.gridLabel("Average Monthly Occupancy"));
        _centerPanel.add(paneUtils.gridLabel(_paradiseRmc.getAvgMonthlyOccupancy().toString()));
        _centerPanel.add(paneUtils.gridLabel(_clcRmc.getAvgMonthlyOccupancy().toString()));
        _centerPanel.add(paneUtils.gridLabel(_beInFloridaRmc.getAvgMonthlyOccupancy().toString()));

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

    }

    private void createBottomPanel() {
        _bottomPanel = new JPanel();
        JButton houseInfoPane = new JButton();
        houseInfoPane.setPreferredSize(new Dimension(100, 20));
        houseInfoPane.setText("Rental Info");
        houseInfoPane.addActionListener(new rmsListener());
        _bottomPanel.add(houseInfoPane);
    }

    private class rmsListener implements ActionListener {
        private rmsListener() {
        }

        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            (new RentalReport(_house)).setVisible(true);
        }
    }

}
