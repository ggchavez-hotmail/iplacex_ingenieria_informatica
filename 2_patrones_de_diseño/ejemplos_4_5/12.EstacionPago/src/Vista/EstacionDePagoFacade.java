package Vista;

import Implementacion.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import softcollection.lcd.*;

public class EstacionDePagoFacade extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {

        }
        new EstacionDePagoFacade();
    }

    LCDDigitDisplay display;
    EstacionDePago estacionDePago;

    public EstacionDePagoFacade() {
        super("EstacionDePago Facade");
        estacionDePago = new EstacionDePagoImpl(new EstacionamientoBFactory());
        JFrame.setDefaultLookAndFeelDecorated(true);
        setLocation(100, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cpane = getContentPane();
        cpane.setLayout(new BorderLayout());
        cpane.add(createCoinInputPanel(), BorderLayout.EAST);
        cpane.add(createButtonPanel(), BorderLayout.SOUTH);
        cpane.add(createDisplayPanel(), BorderLayout.CENTER);
        display.set("    0");
        setJMenuBar(createAllMenus());
        pack();
        setVisible(true);
    }

    private void updateDisplay() {
        String prefixedZeros = String.format("%4d", estacionDePago.leeDisplay());
        display.set(prefixedZeros);
    }

    private JComponent createCoinInputPanel() {
        Box p = new Box(BoxLayout.Y_AXIS);
        p.add(define(" 5 c", "5"));
        p.add(define("10 c", "10"));
        p.add(define("25 c", "25"));
        return p;
    }

    private ActionListener buttonActionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            int moneda = Integer.parseInt(s);
            try {
                estacionDePago.agregaMoneda(moneda);
            } catch (MonedaNoPermitidaException exc) {

            }
            updateDisplay();
        }
    };

    private JComponent createButtonPanel() {
        Box p = new Box(BoxLayout.X_AXIS);
        JButton b;
        b = new JButton("Cancel");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createHorizontalGlue());
        p.add(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                estacionDePago.cancela();
                updateDisplay();
            }
        });
        b = new JButton("Buy");
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        p.add(Box.createHorizontalGlue());
        p.add(b);
        p.add(Box.createHorizontalGlue());
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Recibo r = estacionDePago.compra();
                updateDisplay();
                showReceiptInWindows(r);
            }
        });
        return p;
    }

    private JButton defineButton(String text, String actionCommand) {
        JButton b;
        b = new JButton(text);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setActionCommand(actionCommand);
        b.addActionListener(buttonActionListener);
        return b;
    }

    private JComponent createDisplayPanel() {
        display = new LDCDigitDisplay();
        return display;
    }

    private void showReceiptInWindow(Recibo recibo) {
        JFrame frame = new JFrame("Recibo");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        recibo.imprime(ps);
        String[] lines = baos.toString().split("\n");
        JTextArea text = new JTextArea(lines.length, 20);
        text.setEditable(false);
        text.setFont(new Font("DialogInput", Font.PLAIN, 14));
        for (int i = 0; i < lines.length; i++) {
            text.append(lines[i] + "\n");
        }
        frame.getContentPane().add(text);
        frame.pack();
        frame.setVisible(true);
    }

    private JMenuBar createAllMenus() {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        menuBar = new JMenuBar();
        menu = new JMenu("Variant Selection");
        menu.getAccessibleContext().setAccessibleDescription("Select pay station variants here.");
        menuBar.add(menu);
        menuItem = makeTownMenuItem("EstacionamientoA", new EstacionamientoAFactory());
        menu.add(menuItem);
        menuItem = makeTownMenuItem("EstacionamientoB", new EstacionamientoAFactory());
        menu.add(menuItem);
        menuItem = makeTownMenuItem("EstacionamientoC", new EstacionamientoAFactory());
        menu.add(menuItem);
        addMoreProductVariants(menu);
        return menuBar;
    }

    protected void addMoreProductVariants(JMenu menu) {
    }

    protected JMenuItem makeTownMenuItem(final String name, final EstacionamientoFactory factory) {
        JMenuItem menuItem;
        menuItem = new JMenuItem(name);
        menuItem.getAccessibleContext().setAccessibleDescription("Reconfig to basic " + name + " behaviour.");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                estacionDePago = new EstacionamientoImpl(factory);
                updateDisplay();
            }
        });
        return menuItem;
    }
}
