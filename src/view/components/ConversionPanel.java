package view.components;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.ConversionAlgorithms;
/**
 * MISSING JAVADOC.
 *
 */
public class ConversionPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = -9080067811293897721L;

    private final Map<String, CCDisplay> map = new HashMap<>();

    private final CCDisplay decDisplay;
    //TODO add javadoc.
    /**
     * MISSING JAVADOC.
     * @param conv
     */
    public ConversionPanel(final ActionListener conv) {
        this.setLayout(new GridLayout(4, 2));

        final JButton hex = new JButton("HEX");
        hex.addActionListener(conv);
        this.add(hex);
        final CCDisplay hexDisplay = new CCDisplay();
        this.add(hexDisplay);
        this.map.put(hex.getText(), hexDisplay);

        final JButton dec = new JButton("DEC");
        dec.addActionListener(conv);
        this.add(dec);
        this.decDisplay = new CCDisplay();
        this.add(decDisplay);
        this.map.put(dec.getText(), decDisplay);
        // not needed since it's linked to the main display

        final JButton oct = new JButton("OCT");
        oct.addActionListener(conv);
        this.add(oct);
        final CCDisplay octDisplay = new CCDisplay();
        this.add(octDisplay);
        this.map.put(oct.getText(), octDisplay);

        final JButton bin = new JButton("BIN");
        bin.addActionListener(conv);
        this.add(bin);
        final CCDisplay binDisplay = new CCDisplay();
        this.add(binDisplay);
        this.map.put(bin.getText(), binDisplay);
    }

    /**
     * @param input
     *            for base2 base8 and base16.
     */
    public void updateConvDisplays(final int input) {
            this.map.entrySet().stream().forEach((entry) -> entry.getValue().updateText(textToBase(entry.getKey(), input)));
    }

    private String textToBase(final String text, final int toConvert) {
        switch (text) {
        case "HEX":
            return ConversionAlgorithms.conversionToStringBase(16, toConvert);
        case "DEC":
            return String.valueOf(toConvert);
        case "OCT":
            return ConversionAlgorithms.conversionToStringBase(8, toConvert);
        case "BIN":
            return ConversionAlgorithms.conversionToStringBase(2, toConvert);
        default:
            return null;
        }
    }

}