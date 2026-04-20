import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GadgetShop extends JFrame {

    private ArrayList<Gadget> gadgets = new ArrayList<>();

    private JTextField modelField, priceField, weightField, sizeField;
    private JTextField creditField, memoryField, displayNumberField, phoneField, durationField, downloadField;

    private JTextArea displayArea;

    public GadgetShop() {
        setTitle("Gadget Shop");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Fields
        modelField = new JTextField(10);
        priceField = new JTextField(10);
        weightField = new JTextField(10);
        sizeField = new JTextField(10);
        creditField = new JTextField(10);
        memoryField = new JTextField(10);
        displayNumberField = new JTextField(5);
        phoneField = new JTextField(10);
        durationField = new JTextField(5);
        downloadField = new JTextField(5);

        // Labels + fields
        add(new JLabel("Model")); add(modelField);
        add(new JLabel("Price")); add(priceField);
        add(new JLabel("Weight")); add(weightField);
        add(new JLabel("Size")); add(sizeField);
        add(new JLabel("Credit")); add(creditField);
        add(new JLabel("Memory")); add(memoryField);

        add(new JLabel("Display Number")); add(displayNumberField);
        add(new JLabel("Phone")); add(phoneField);
        add(new JLabel("Duration")); add(durationField);
        add(new JLabel("Download Size")); add(downloadField);

        // Buttons
        JButton addMobileBtn = new JButton("Add Mobile");
        JButton addMP3Btn = new JButton("Add MP3");
        JButton displayBtn = new JButton("Display All");
        JButton callBtn = new JButton("Make Call");
        JButton downloadBtn = new JButton("Download Music");
        JButton clearBtn = new JButton("Clear");

        add(addMobileBtn);
        add(addMP3Btn);
        add(displayBtn);
        add(callBtn);
        add(downloadBtn);
        add(clearBtn);

        // Display area
        displayArea = new JTextArea(15, 40);
        add(displayArea);

        // BUTTON ACTIONS

        // Add Mobile
        addMobileBtn.addActionListener(e -> {
            try {
                String model = modelField.getText();
                double price = Double.parseDouble(priceField.getText());
                int weight = Integer.parseInt(weightField.getText());
                String size = sizeField.getText();
                int credit = Integer.parseInt(creditField.getText());

                Mobile m = new Mobile(model, price, weight, size, credit);
                gadgets.add(m);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input");
            }
        });

        // Add MP3
        addMP3Btn.addActionListener(e -> {
            try {
                String model = modelField.getText();
                double price = Double.parseDouble(priceField.getText());
                int weight = Integer.parseInt(weightField.getText());
                String size = sizeField.getText();
                int memory = Integer.parseInt(memoryField.getText());

                MP3 mp = new MP3(model, price, weight, size, memory);
                gadgets.add(mp);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input");
            }
        });

        // Display All
        displayBtn.addActionListener(e -> {
            displayArea.setText("");
            for (int i = 0; i < gadgets.size(); i++) {
                displayArea.append("Index: " + i + "\n");
                Gadget g = gadgets.get(i);

                if (g instanceof Mobile) {
                    Mobile m = (Mobile) g;
                    displayArea.append("Model: " + m.getModel() + "\n");
                    displayArea.append("Price: £" + m.getPrice() + "\n");
                    displayArea.append("Weight: " + m.getWeight() + "g\n");
                    displayArea.append("Size: " + m.getSize() + "\n");
                    displayArea.append("Credit: " + m.getCredit() + "\n\n");
                }

                if (g instanceof MP3) {
                    MP3 mp = (MP3) g;
                    displayArea.append("Model: " + mp.getModel() + "\n");
                    displayArea.append("Price: £" + mp.getPrice() + "\n");
                    displayArea.append("Weight: " + mp.getWeight() + "g\n");
                    displayArea.append("Size: " + mp.getSize() + "\n");
                    displayArea.append("Memory: " + mp.getMemory() + "\n\n");
                }
            }
        });

        // Make Call
        callBtn.addActionListener(e -> {
            try {
                int index = Integer.parseInt(displayNumberField.getText());
                String number = phoneField.getText();
                int duration = Integer.parseInt(durationField.getText());

                Gadget g = gadgets.get(index);
                Mobile m = (Mobile) g;
                m.makeCall(number, duration);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input or wrong index");
            }
        });

        // Download Music
        downloadBtn.addActionListener(e -> {
            try {
                int index = Integer.parseInt(displayNumberField.getText());
                int size = Integer.parseInt(downloadField.getText());

                Gadget g = gadgets.get(index);
                MP3 mp = (MP3) g;
                mp.downloadMusic(size);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input or wrong index");
            }
        });

        // Clear
        clearBtn.addActionListener(e -> {
            modelField.setText("");
            priceField.setText("");
            weightField.setText("");
            sizeField.setText("");
            creditField.setText("");
            memoryField.setText("");
            displayNumberField.setText("");
            phoneField.setText("");
            durationField.setText("");
            downloadField.setText("");
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new GadgetShop();
    }
}