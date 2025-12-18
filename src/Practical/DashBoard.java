package Practical;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class DashBoard extends JFrame {

    private static final long serialVersionUID = 1L;
    
    // --- Variables ---
    // Item counters and individual item total prices
    int flaflNum, folNum, waterNum, juiceNum;
    double flaflPrice, folPrice, waterPrice, juicePrice;
    
    // --- Base Costs ---
    final double FLAFL_COST = 5.0;
    final double FOL_COST = 4.0;
    final double WATER_COST = 5.0;
    final double JUICE_COST = 10.0;
    
    // --- Add-ons Costs ---
    final double EXTRA_EGGPLANT = 2.0;
    final double EXTRA_ICE = 2.0;

    // Totals and Invoice Management
    double subtotal, tax, total;
    int numberOfInvoice = 1;
    PrintWriter output;

    private JPanel contentPane;

    // --- Dark Theme Colors ---
    Color darkBackground = new Color(43, 43, 43);
    Color panelBackground = new Color(60, 63, 65);
    Color textColor = new Color(230, 230, 230);
    Color accentColor = new Color(75, 110, 175);
    Color successColor = new Color(46, 204, 113);
    Color dangerColor = new Color(231, 76, 60);

    public static void main(String[] args) {
        try {
            // Set System Look and Feel and customize specific components
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.put("Spinner.background", new Color(60, 63, 65));
            UIManager.put("CheckBox.background", new Color(60, 63, 65));
            UIManager.put("CheckBox.foreground", new Color(230, 230, 230));
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            try {
                DashBoard frame = new DashBoard();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public DashBoard() {
        // --- Main Frame Setup ---
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ahmed\\Downloads\\Resturant_Manegement\\Resturant_Manegement\\Black and White Simple Street Food Circle Logo.jpg"));
        setTitle("Restaurant-Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 997, 880);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        contentPane = new JPanel();
        contentPane.setBackground(darkBackground);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

        // --- Header Panel (Top) ---
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(darkBackground);
        
        JLabel lblTitle = new JLabel("مطعم فلافل");
        lblTitle.setForeground(textColor);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(lblTitle, BorderLayout.CENTER);

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon("C:\\Users\\ahmed\\Downloads\\Resturant_Manegement\\Resturant_Manegement\\ana.png"));
        headerPanel.add(lblLogo, BorderLayout.EAST);

        JButton btnExit = new JButton("خروج");
        styleButton(btnExit, dangerColor);
        btnExit.addActionListener(e -> System.exit(0));
        headerPanel.add(btnExit, BorderLayout.WEST);

        contentPane.add(headerPanel, BorderLayout.NORTH);

        // --- Center Grid Layout ---
        // Split into Left Column (Controls) and Right Column (Menu)
        JPanel centerGrid = new JPanel(new GridLayout(1, 2, 20, 20));
        centerGrid.setBackground(darkBackground);

        JPanel leftColumn = new JPanel(new GridLayout(2, 1, 20, 20));
        leftColumn.setOpaque(false);
        JPanel rightColumn = new JPanel(new GridLayout(2, 1, 20, 20));
        rightColumn.setOpaque(false);

        // 1. Food Panel (Right Top)
        JPanel panelEat = new JPanel(null);
        stylePanel(panelEat, "المأكولات");

        // === Falafel Item ===
        JLabel lblFlafl = new JLabel("سندوتش فلافل");
        styleLabel(lblFlafl);
        lblFlafl.setBounds(300, 40, 150, 30);
        panelEat.add(lblFlafl);

        JLabel lblcostFlafl = new JLabel("0.0 جنية");
        styleLabel(lblcostFlafl);
        lblcostFlafl.setForeground(successColor);
        lblcostFlafl.setBounds(20, 40, 100, 30);
        panelEat.add(lblcostFlafl);

        JSpinner spFlafl = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
        spFlafl.setBounds(230, 40, 60, 30);
        spFlafl.setFont(new Font("Tahoma", Font.BOLD, 14));
        panelEat.add(spFlafl);

        JCheckBox cbBantgan1 = new JCheckBox("باذنجان");
        styleCheckBox(cbBantgan1);
        cbBantgan1.setBounds(120, 40, 100, 30);
        panelEat.add(cbBantgan1);

        // Falafel Calculation Logic
        java.awt.event.ActionListener flaflAction = e -> {
            flaflNum = (Integer) spFlafl.getValue();
            // Price = Base + Addon
            double unitPrice = FLAFL_COST + (cbBantgan1.isSelected() ? EXTRA_EGGPLANT : 0.0);
            flaflPrice = flaflNum * unitPrice;
            lblcostFlafl.setText(flaflPrice + " جنية");
        };
        spFlafl.addChangeListener(e -> flaflAction.actionPerformed(null));
        cbBantgan1.addActionListener(flaflAction);

        // === Foul Item ===
        JLabel lblFol = new JLabel("سندوتش فول");
        styleLabel(lblFol);
        lblFol.setBounds(300, 100, 150, 30);
        panelEat.add(lblFol);

        JLabel lblcostFol = new JLabel("0.0 جنية");
        styleLabel(lblcostFol);
        lblcostFol.setForeground(successColor);
        lblcostFol.setBounds(20, 100, 100, 30);
        panelEat.add(lblcostFol);

        JSpinner spFol = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
        spFol.setBounds(230, 100, 60, 30);
        spFol.setFont(new Font("Tahoma", Font.BOLD, 14));
        panelEat.add(spFol);

        JCheckBox cbBantgan2 = new JCheckBox("باذنجان");
        styleCheckBox(cbBantgan2);
        cbBantgan2.setBounds(120, 100, 100, 30);
        panelEat.add(cbBantgan2);

        // Foul Calculation Logic
        java.awt.event.ActionListener folAction = e -> {
            folNum = (Integer) spFol.getValue();
            double unitPrice = FOL_COST + (cbBantgan2.isSelected() ? EXTRA_EGGPLANT : 0.0);
            folPrice = folNum * unitPrice;
            lblcostFol.setText(folPrice + " جنية");
        };
        spFol.addChangeListener(e -> folAction.actionPerformed(null));
        cbBantgan2.addActionListener(folAction);


        // 2. Drinks Panel (Right Bottom)
        JPanel panelDrinks = new JPanel(null);
        stylePanel(panelDrinks, "المشروبات");

        // === Water Item ===
        JLabel lblWater = new JLabel("ماء");
        styleLabel(lblWater);
        lblWater.setBounds(300, 40, 150, 30);
        panelDrinks.add(lblWater);

        JLabel costWater = new JLabel("0.0 جنية");
        styleLabel(costWater);
        costWater.setForeground(successColor);
        costWater.setBounds(20, 40, 100, 30);
        panelDrinks.add(costWater);

        JSpinner spWater = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
        spWater.setBounds(230, 40, 60, 30);
        spWater.setFont(new Font("Tahoma", Font.BOLD, 14));
        panelDrinks.add(spWater);

        JCheckBox cbIce1 = new JCheckBox("ثلج");
        styleCheckBox(cbIce1);
        cbIce1.setBounds(150, 40, 70, 30);
        panelDrinks.add(cbIce1);

        // Water Calculation Logic
        java.awt.event.ActionListener waterAction = e -> {
            waterNum = (Integer) spWater.getValue();
            double unitPrice = WATER_COST + (cbIce1.isSelected() ? EXTRA_ICE : 0.0);
            waterPrice = waterNum * unitPrice;
            costWater.setText(waterPrice + " جنية");
        };
        spWater.addChangeListener(e -> waterAction.actionPerformed(null));
        cbIce1.addActionListener(waterAction);

        // === Juice Item ===
        JLabel lblJuice = new JLabel("عصير");
        styleLabel(lblJuice);
        lblJuice.setBounds(300, 100, 150, 30);
        panelDrinks.add(lblJuice);

        JLabel costJuice = new JLabel("0.0 جنية");
        styleLabel(costJuice);
        costJuice.setForeground(successColor);
        costJuice.setBounds(20, 100, 100, 30);
        panelDrinks.add(costJuice);

        JSpinner spJuice = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
        spJuice.setBounds(230, 100, 60, 30);
        spJuice.setFont(new Font("Tahoma", Font.BOLD, 14));
        panelDrinks.add(spJuice);

        JCheckBox cbIce2 = new JCheckBox("ثلج");
        styleCheckBox(cbIce2);
        cbIce2.setBounds(150, 100, 70, 30);
        panelDrinks.add(cbIce2);

        // Juice Calculation Logic
        java.awt.event.ActionListener juiceAction = e -> {
            juiceNum = (Integer) spJuice.getValue();
            double unitPrice = JUICE_COST + (cbIce2.isSelected() ? EXTRA_ICE : 0.0);
            juicePrice = juiceNum * unitPrice;
            costJuice.setText(juicePrice + " جنية");
        };
        spJuice.addChangeListener(e -> juiceAction.actionPerformed(null));
        cbIce2.addActionListener(juiceAction);


        // 3. Accounts Panel (Left Top)
        JPanel panelAccount = new JPanel(null);
        stylePanel(panelAccount, "الحساب");

        JLabel lblSubTotal = new JLabel("المجموع: 0.0 جنية");
        styleLabel(lblSubTotal);
        lblSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubTotal.setBounds(50, 40, 350, 30);
        panelAccount.add(lblSubTotal);

        JLabel lblTax = new JLabel("الضريبة: 0.0 جنية");
        styleLabel(lblTax);
        lblTax.setHorizontalAlignment(SwingConstants.CENTER);
        lblTax.setBounds(50, 80, 350, 30);
        panelAccount.add(lblTax);

        JSeparator sep = new JSeparator();
        sep.setBackground(accentColor);
        sep.setBounds(50, 120, 350, 10);
        panelAccount.add(sep);

        JLabel lblTotal = new JLabel("الإجمالي: 0.0 جنية");
        lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
        lblTotal.setForeground(successColor);
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblTotal.setBounds(50, 140, 350, 40);
        panelAccount.add(lblTotal);

        // 4. Choices/Buttons Panel (Left Bottom)
        JPanel panelChoice = new JPanel(null);
        stylePanel(panelChoice, "الخيارات");

        // --- Calculate Button ---
        JButton btnCalc = new JButton("حساب");
        styleButton(btnCalc, accentColor);
        btnCalc.setBounds(50, 30, 350, 50);
        panelChoice.add(btnCalc);
        btnCalc.addActionListener(e -> {
            subtotal = flaflPrice + folPrice + waterPrice + juicePrice;
            lblSubTotal.setText("المجموع: " + subtotal + " جنية");
            
            tax = subtotal * 0.05; // 5% Tax
            tax = Math.round(tax * 100.0) / 100.0;
            lblTax.setText("الضريبة: " + tax + " جنية");
            
            total = subtotal + tax;
            lblTotal.setText("الإجمالي: " + total + " جنية");
        });

        JLabel lblInvNum = new JLabel("رقم الفاتورة: " + numberOfInvoice);
        styleLabel(lblInvNum);
        lblInvNum.setHorizontalAlignment(SwingConstants.CENTER);
        lblInvNum.setBounds(50, 90, 350, 30);
        panelChoice.add(lblInvNum);

        // --- New/Reset Button ---
        JButton btnNew = new JButton("جديد");
        styleButton(btnNew, new Color(230, 126, 34)); // Orange
        btnNew.setBounds(50, 130, 160, 45);
        panelChoice.add(btnNew);
        btnNew.addActionListener(e -> {
            if(total != 0) {
                // Reset all controls
                spFlafl.setValue(0); spFol.setValue(0);
                spWater.setValue(0); spJuice.setValue(0);
                cbBantgan1.setSelected(false); cbBantgan2.setSelected(false);
                cbIce1.setSelected(false); cbIce2.setSelected(false);
                
                // Reset totals
                subtotal = 0; tax = 0; total = 0;
                lblSubTotal.setText("المجموع: 0.0 جنية");
                lblTax.setText("الضريبة: 0.0 جنية");
                lblTotal.setText("الإجمالي: 0.0 جنية");
                
                numberOfInvoice++;
                lblInvNum.setText("رقم الفاتورة: " + numberOfInvoice);
            }
        });

        // --- Save Invoice Button ---
        JButton btnSave = new JButton("حفظ");
        styleButton(btnSave, successColor); // Green
        btnSave.setBounds(240, 130, 160, 45);
        panelChoice.add(btnSave);
        btnSave.addActionListener(e -> {
            try {
                if(total != 0) {
                    // 1. Define Path and Directory
                    String folderPath = "C:\\Users\\ahmed\\Downloads\\Resturant_Manegement\\Resturant_Manegement\\الفاتوره\\";
                    File directory = new File(folderPath);
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }

                    // 2. Setup File Writing
                    String fullPath = folderPath + "فاتورة_رقم_" + numberOfInvoice + ".txt";
                    File file = new File(fullPath);
                    output = new PrintWriter(file);
                    
                    // 3. Write Invoice Content
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
                    LocalDateTime now = LocalDateTime.now(); 
                    
                    output.println("******** مطعم فلافل ********");
                    output.println("رقم الفاتورة: " + numberOfInvoice);
                    output.println("التاريخ: " + dtf.format(now));
                    output.println("============================");
                    
                    if(flaflNum > 0) {
                        String extra = cbBantgan1.isSelected() ? " (بالباذنجان)" : "";
                        output.println(flaflNum + "x فلافل" + extra + " ... " + flaflPrice);
                    }
                    if(folNum > 0) {
                        String extra = cbBantgan2.isSelected() ? " (بالباذنجان)" : "";
                        output.println(folNum + "x فول" + extra + " ....... " + folPrice);
                    }
                    if(waterNum > 0) {
                        String extra = cbIce1.isSelected() ? " (مثلج)" : "";
                        output.println(waterNum + "x ماء" + extra + " ....... " + waterPrice);
                    }
                    if(juiceNum > 0) {
                        String extra = cbIce2.isSelected() ? " (مثلج)" : "";
                        output.println(juiceNum + "x عصير" + extra + " ...... " + juicePrice);
                    }
                    
                    output.println("----------------------------");
                    output.println("المجموع:  " + subtotal);
                    output.println("الضريبة:  " + tax);
                    output.println("الإجمالي: " + total + " جنية");
                    output.println("============================");
                    output.println("     شكراً لزيارتكم");
                    output.close();
                    
                    JOptionPane.showMessageDialog(null, "تم حفظ الفاتورة بنجاح في المسار:\n" + file.getAbsolutePath());
                } else {
                    JOptionPane.showMessageDialog(null, "لا يوجد طلبات لحفظها!", "تنبيه", JOptionPane.WARNING_MESSAGE);
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        rightColumn.add(panelEat);
        rightColumn.add(panelDrinks);
        leftColumn.add(panelAccount);
        leftColumn.add(panelChoice);
        
        centerGrid.add(leftColumn);
        centerGrid.add(rightColumn);
        
        contentPane.add(centerGrid, BorderLayout.CENTER);
    }

    // --- UI Styling Helper Methods ---
    private void stylePanel(JPanel p, String t) {
        p.setBackground(panelBackground);
        p.setBorder(new TitledBorder(new LineBorder(accentColor, 2, true), t,
                TitledBorder.RIGHT, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 18), accentColor));
    }
    private void styleLabel(JLabel l) {
        l.setForeground(textColor);
        l.setFont(new Font("Tahoma", Font.BOLD, 16));
        l.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    private void styleCheckBox(JCheckBox c) {
        c.setBackground(panelBackground);
        c.setForeground(textColor);
        c.setFont(new Font("Tahoma", Font.PLAIN, 14));
        c.setHorizontalAlignment(SwingConstants.RIGHT);
        c.setHorizontalTextPosition(SwingConstants.LEFT);
    }
    private void styleButton(JButton b, Color c) {
        b.setBackground(c);
        b.setForeground(Color.WHITE);
        b.setFont(new Font("Tahoma", Font.BOLD, 18));
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
