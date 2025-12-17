package Practical;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;

public class DashBoard extends JFrame {

	int flaflNum, folNum, waterNum, juiceNum;
    double flaflPrice, folPrice, waterPrice, juicePrice;
    final double FLAFL_COST = 5.0, FOL_COST = 4.0, WATER_COST = 5.0, JUICE_COST = 10.0;
    double subtotal, tax, total;
    int numberOfInvoice;
    PrintWriter output;

    private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashBoard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\gamal\\Downloads\\Resturant_Manegement\\Black and White Simple Street Food Circle Logo.jpg"));
		setTitle("Resturant Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 416);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("مطعم فلافل");
		lblNewLabel.setBounds(376, 32, 132, 29);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_1 = new JLabel("Logo");
		lblNewLabel_1.setBounds(536, 15, 68, 69);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\gamal\\Downloads\\Resturant_Manegement\\output-onlinepngtools (1).png"));
		
		JPanel panelEat = new JPanel();
		panelEat.setBounds(258, 94, 353, 139);
		panelEat.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0627\u0644\u0645\u0623\u0643\u0648\u0644\u0627\u062A", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblcostFlafl = new JLabel("0.0 جنية");
		lblcostFlafl.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblcostFlafl.setHorizontalAlignment(SwingConstants.CENTER);
		lblcostFlafl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcostFlafl.setBounds(35, 24, 87, 24);
		panelEat.add(lblcostFlafl);
		
		JLabel lblFlafl = new JLabel("سندوتش فلافل");
		lblFlafl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFlafl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFlafl.setBounds(256, 24, 87, 24);
		panelEat.add(lblFlafl);
		
		
		
		JSpinner spinnerNumberFlafl = new JSpinner();
		spinnerNumberFlafl.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				 
				        flaflNum = (Integer) spinnerNumberFlafl.getValue();
				        flaflPrice = flaflNum * FLAFL_COST;
				        lblcostFlafl.setText(flaflPrice + " جنية");

			}
		});
		spinnerNumberFlafl.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerNumberFlafl.setBounds(206, 26, 40, 24);
		panelEat.add(spinnerNumberFlafl);
		
		JCheckBox spinnerbantgan1 = new JCheckBox("الباذنجان");
		spinnerbantgan1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (spinnerbantgan1.isEnabled()) {
		            flaflPrice += 2;
		        }
				else {
					 flaflPrice -= 2;
				            
				}
				   lblcostFlafl.setText(flaflPrice + " جنية");
			}
		});
		spinnerbantgan1.setHorizontalAlignment(SwingConstants.RIGHT);
		spinnerbantgan1.setHorizontalTextPosition(SwingConstants.LEFT);
		spinnerbantgan1.setBounds(108, 27, 92, 20);
		panelEat.add(spinnerbantgan1);
		
		JLabel lblcostFol = new JLabel("0.0 جنية");
		lblcostFol.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblcostFol.setHorizontalAlignment(SwingConstants.CENTER);
		lblcostFol.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblcostFol.setBounds(35, 78, 87, 24);
		panelEat.add(lblcostFol);
		
		JLabel lblFol = new JLabel("سندوتش فول");
		lblFol.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFol.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFol.setBounds(256, 78, 87, 24);
		panelEat.add(lblFol);
		
		JSpinner spinnerNumberFol = new JSpinner();
		spinnerNumberFol.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
		        folNum = (Integer) spinnerNumberFol.getValue();
		        folPrice = folNum * FOL_COST;
		        lblcostFol.setText(folPrice + " جنية");

			}
		});
		spinnerNumberFol.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerNumberFol.setBounds(206, 80, 40, 24);
		panelEat.add(spinnerNumberFol);
		
		JCheckBox spinnerbantgan2 = new JCheckBox("الباذنجان");
		spinnerbantgan2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (spinnerbantgan2.isEnabled()) {
		            folPrice += 2;
		        }
				else {
					 folPrice -= 2;
				       
				}
				     lblcostFol.setText(folPrice + " جنية");  
			}
			
		});
		spinnerbantgan2.setHorizontalTextPosition(SwingConstants.LEFT);
		spinnerbantgan2.setHorizontalAlignment(SwingConstants.RIGHT);
		spinnerbantgan2.setBounds(108, 79, 92, 20);
		panelEat.add(spinnerbantgan2);
		
		
		
		JPanel panelDrinks = new JPanel();
		panelDrinks.setBounds(316, 243, 295, 139);
		panelDrinks.setLayout(null);
		panelDrinks.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0627\u0644\u0645\u0634\u0631\u0648\u0628\u0627\u062A", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblWater = new JLabel("ماء");
		lblWater.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWater.setHorizontalAlignment(SwingConstants.CENTER);
		lblWater.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWater.setBounds(222, 24, 56, 24);
		panelDrinks.add(lblWater);
		
		JLabel costWater = new JLabel("0.0 جنية");
		costWater.setHorizontalTextPosition(SwingConstants.RIGHT);
		costWater.setHorizontalAlignment(SwingConstants.CENTER);
		costWater.setFont(new Font("Tahoma", Font.BOLD, 12));
		costWater.setBounds(54, 24, 71, 24);
		panelDrinks.add(costWater);
		
		JSpinner spinnerBottleWater = new JSpinner();
		spinnerBottleWater.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
		        waterNum = (Integer) spinnerBottleWater.getValue();
		        waterPrice = waterNum * WATER_COST;
		        costWater.setText(waterPrice + " جنية");

			}
		});
		spinnerBottleWater.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerBottleWater.setBounds(177, 26, 40, 24);
		panelDrinks.add(spinnerBottleWater);
		
		JCheckBox spinnerIce1 = new JCheckBox("ثلج");
		spinnerIce1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (spinnerIce1.isEnabled()) {
		            waterPrice += 1;
		        }
				else {
					 waterPrice -= 1;
				       
				}
				     costWater.setText(waterPrice + " جنية");  
			}
			
		});
		spinnerIce1.setHorizontalTextPosition(SwingConstants.LEFT);
		spinnerIce1.setHorizontalAlignment(SwingConstants.RIGHT);
		spinnerIce1.setBounds(131, 27, 40, 20);
		panelDrinks.add(spinnerIce1);
		
		JLabel lblJuice = new JLabel("عصير");
		lblJuice.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJuice.setBounds(223, 78, 62, 24);
		panelDrinks.add(lblJuice);
		
		JLabel costJuice = new JLabel("0.0 جنية");
		costJuice.setHorizontalTextPosition(SwingConstants.RIGHT);
		costJuice.setHorizontalAlignment(SwingConstants.CENTER);
		costJuice.setFont(new Font("Tahoma", Font.BOLD, 12));
		costJuice.setBounds(54, 78, 71, 24);
		panelDrinks.add(costJuice);
		
		JSpinner spinnerBottleJuice = new JSpinner();
		spinnerBottleJuice.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
		        juiceNum = (Integer) spinnerBottleJuice.getValue();
		        juicePrice = juiceNum * JUICE_COST;
		        costJuice.setText(juicePrice + " جنية");

			}
		});
		spinnerBottleJuice.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerBottleJuice.setBounds(177, 80, 40, 24);
		panelDrinks.add(spinnerBottleJuice);
		
		JCheckBox spinnerIce2 = new JCheckBox("ثلج");
		spinnerIce2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (spinnerIce2.isEnabled()) {
		            juicePrice += 1;
		            
		        }
				else {
					 juicePrice -= 1;
				       
				}
				     costJuice.setText(juicePrice + " جنية");  
			}
		});
		spinnerIce2.setHorizontalTextPosition(SwingConstants.LEFT);
		spinnerIce2.setHorizontalAlignment(SwingConstants.RIGHT);
		spinnerIce2.setBounds(131, 81, 40, 20);
		panelDrinks.add(spinnerIce2);
		
		JPanel panelAccount = new JPanel();
		panelAccount.setBounds(29, 94, 215, 139);
		panelAccount.setLayout(null);
		panelAccount.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0627\u0644\u062D\u0633\u0627\u0628", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblSubTotal = new JLabel("المجموع: 0.0 جنية");
		lblSubTotal.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSubTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubTotal.setBounds(42, 22, 112, 24);
		panelAccount.add(lblSubTotal);
		
		JLabel lblTax = new JLabel("الضريبة:  0.0 جنية");
		lblTax.setHorizontalAlignment(SwingConstants.CENTER);
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTax.setBounds(42, 46, 112, 24);
		panelAccount.add(lblTax);
		
		JLabel lblTotal = new JLabel("الإجمالي: 0.0 جنية");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(42, 80, 119, 24);
		panelAccount.add(lblTotal);
		
		JPanel panelChoice = new JPanel();
		panelChoice.setBounds(29, 243, 225, 139);
		panelChoice.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u0627\u0644\u062E\u064A\u0627\u0631\u0627\u062A", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChoice.setLayout(null);
		
		JSeparator jSeparator1_1 = new JSeparator();
		jSeparator1_1.setBounds(23, 71, 192, 20);
		jSeparator1_1.setBackground(Color.LIGHT_GRAY);
		panelChoice.add(jSeparator1_1);
		
		JButton btnPrice = new JButton("حساب ");
		btnPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnPrice.setBounds(38, 28, 154, 33);
		btnPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				subtotal = flaflPrice+ folPrice+ waterPrice+ juicePrice;
				lblSubTotal.setText("المجموع: " + subtotal + " جنية");
				
				tax = subtotal * 0.05;
				tax = tax * 100;
		        tax = (double) ((int) tax);
		        tax = tax / 100;
				lblTax.setText("الضريبة: " + tax + " جنية");
				
				total = subtotal + tax;
				lblTotal.setText("الإجمالي: " + total + " جنية");
				
				
			}
		});
		panelChoice.add(btnPrice);
		
		JButton btnSaveInvoice = new JButton("حقظ الفاتورة ");
		btnSaveInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(total != 0) {
					output = new PrintWriter("billNumber" +numberOfInvoice+".txt");
					
					output.println(numberOfInvoice + " فاتورة رقم");
	                output.println("==============");

	                if (flaflNum != 0) {
	                    output.print(flaflNum + " سدوتش فلافل");

	                    if (spinnerbantgan1.isEnabled()) {
	                        output.println(" مع الباذنجان");
	                    }
	                    output.println(flaflPrice + " جنية");
	                }

	                if (folNum != 0) {
	                    output.print(folNum + " سندوتش فول");

	                    if (spinnerbantgan2.isEnabled()) {
	                        output.println(" مع الباذنجان");
	                    }
	                    output.println(folPrice + " جنية");
	                }

	                if (waterNum != 0) {
	                    output.println(waterNum + " ماء");
	                    output.println(waterPrice + " جنية");
	                    
	                }

	                if (juiceNum != 0) {
	                    output.println(juiceNum + " عصير");
	                    output.println(juicePrice + " جنية");
	                }

	                output.println("----");
	                output.println("المجموع: " + subtotal + " جنية");
	                output.println("الضريبة: " + tax + " جنية");
	                output.println("الإجمالي: " + total + " جنية");
	                output.println();
	                output.println("*** شكرا لطلبك ***");

	                output.close();

	            }
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSaveInvoice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSaveInvoice.setBounds(115, 81, 100, 33);
		panelChoice.add(btnSaveInvoice);
		
		JLabel lblnumberOfInvoice = new JLabel("رقم الفاتورة: 0");
		lblnumberOfInvoice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblnumberOfInvoice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblnumberOfInvoice.setBounds(85, 55, 139, 29);
		contentPane.add(lblnumberOfInvoice);
		
		
		JButton btnNewInvoice = new JButton("فاتورة جديدة");
		btnNewInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(total != 0)
				{
					
					spinnerNumberFlafl.setValue(0);
					spinnerNumberFol.setValue(0);
					spinnerBottleWater.setValue(0);
					spinnerBottleJuice.setValue(0);
					
					spinnerbantgan1.setSelected(false);
					spinnerbantgan2.setSelected(false);
            		spinnerIce1.setSelected(false);
        		    spinnerIce2.setSelected(false);
        		    
        		    lblSubTotal.setText("المجموع: 0.0 جنية");
            		lblTax.setText("الضريبة: 0.0 جنية");
            		lblTotal.setText("الإجمالي: 0.0 جنية");

            		subtotal = 0;
            		tax = 0;
            		total = 0;
            		
					numberOfInvoice++;
					lblnumberOfInvoice.setText("رقم الفاتورة: " + numberOfInvoice);
					
				}
			}
		});
		btnNewInvoice.setBounds(10, 81, 95, 33);
		panelChoice.add(btnNewInvoice);
		
		
		
		JSeparator jSeparator1 = new JSeparator();
		jSeparator1.setBackground(new Color(192, 192, 192));
		jSeparator1.setBounds(23, 71, 154, 33);
		panelAccount.add(jSeparator1);
		panelEat.setLayout(null);

		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		contentPane.add(panelChoice);
		contentPane.add(panelDrinks);
		contentPane.add(panelAccount);
		contentPane.add(panelEat);
		
		
		JButton btnExit = new JButton("خروج");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBounds(10, 25, 84, 36);
		contentPane.add(btnExit);

	}
}
