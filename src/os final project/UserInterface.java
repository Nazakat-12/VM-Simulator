package our_os_project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;

public class UserInterface {
	private ArrayList<Process> P;
	private int algorithmFlag=1;
	private int user_ram = 0;
	private int total_CPU_time=0;
	private int total_CS=0;
	private int total_faults=0;
	private int total_cycles=0;
	private float avg_WT=0;
	private float avg_TAT=0;
	private JFrame frmVirtualMemorySimulator;
	private JTextField textField1;
	private JTextField textField2;
	private JTable table;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JButton btn1;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox4;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTextField textField3;
	private JTextField textField6;
	private JTextField textField5;
	private JTextField textField4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		System.out.println("This code is outside of the thread");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frmVirtualMemorySimulator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVirtualMemorySimulator = new JFrame();
		frmVirtualMemorySimulator.setForeground(new Color(0, 0, 0));
		frmVirtualMemorySimulator.setTitle("Virtual Memory Simulator");
		frmVirtualMemorySimulator.setBounds(100, 100, 867, 523);
		frmVirtualMemorySimulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVirtualMemorySimulator.getContentPane().setLayout(null);

		lbl1 = new JLabel("Select File : ");
		lbl1.setBackground(new Color(255, 204, 204));
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl1.setBounds(33, 22, 84, 26);
		frmVirtualMemorySimulator.getContentPane().add(lbl1);

		lbl2 = new JLabel("Select memory size : ");
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl2.setBackground(new Color(255, 204, 204));
		lbl2.setBounds(33, 62, 144, 26);
		frmVirtualMemorySimulator.getContentPane().add(lbl2);

		lbl4 = new JLabel("Select page replacement algorithm : ");
		lbl4.setForeground(Color.BLACK);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl4.setBackground(new Color(255, 204, 204));
		lbl4.setBounds(33, 108, 227, 26);
		frmVirtualMemorySimulator.getContentPane().add(lbl4);

		btn1 = new JButton("Simulate");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1ActionPerformed(e);
			}
		});
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setBackground(new Color(0, 0, 51));
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn1.setBounds(85, 171, 227, 35);
		frmVirtualMemorySimulator.getContentPane().add(btn1);

		comboBox1 = new JComboBox();
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jComboBox1ActionPerformed(e);
			}
		});
		comboBox1.setEditable(true);
		comboBox1.setModel(new DefaultComboBoxModel(new String[] { "use configuration file", "use generated file" }));
		comboBox1.setSelectedItem("select file");
		comboBox1.setBounds(248, 25, 175, 22);
		frmVirtualMemorySimulator.getContentPane().add(comboBox1);

		comboBox2 = new JComboBox();
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jComboBox2ActionPerformed(e);
			}
		});
		comboBox2.setModel(
				new DefaultComboBoxModel(new String[] { "10K ,40 frames", "50K  ,200 frames", "125K  , 500 frames" }));
		comboBox2.setEditable(true);
		comboBox2.setSelectedItem("select RAM size");
		comboBox2.setBounds(248, 65, 175, 22);
		frmVirtualMemorySimulator.getContentPane().add(comboBox2);

		comboBox4 = new JComboBox();
		comboBox4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jComboBox4ActionPerformed(e);
			}
		});
		comboBox4.setModel(new DefaultComboBoxModel(new String[] { "FIFO", "Second-chance FIFO", "LRU" }));
		comboBox4.setEditable(true);
		comboBox4.setSelectedItem("select algorithm");
		comboBox4.setBounds(248, 111, 175, 22);
		frmVirtualMemorySimulator.getContentPane().add(comboBox4);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(530, 22, 293, 238);
		frmVirtualMemorySimulator.getContentPane().add(panel);
		panel.setLayout(null);

		lbl5 = new JLabel("Simulation Results:");
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl5.setForeground(new Color(255, 255, 255));
		lbl5.setBounds(10, 11, 121, 14);
		panel.add(lbl5);

		lbl6 = new JLabel("total page faults :");
		lbl6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl6.setForeground(new Color(255, 255, 255));
		lbl6.setBounds(39, 36, 111, 20);
		panel.add(lbl6);

		lbl7 = new JLabel("total cyclesFC :");
		lbl7.setForeground(Color.WHITE);
		lbl7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl7.setBounds(39, 67, 111, 20);
		panel.add(lbl7);

		textField1 = new JTextField();
		textField1.setBounds(185, 36, 48, 20);
		panel.add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(185, 67, 48, 20);
		panel.add(textField2);

		JLabel lblTotalContextSwitches = new JLabel("total context switches :");
		lblTotalContextSwitches.setForeground(Color.WHITE);
		lblTotalContextSwitches.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalContextSwitches.setBounds(39, 95, 136, 20);
		panel.add(lblTotalContextSwitches);

		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(185, 98, 48, 20);
		panel.add(textField3);

		JLabel lblTotalCpuTime = new JLabel("total cpu time :");
		lblTotalCpuTime.setForeground(Color.WHITE);
		lblTotalCpuTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotalCpuTime.setBounds(39, 124, 111, 20);
		panel.add(lblTotalCpuTime);

		JLabel lblAvgWaitTime = new JLabel("avg wait time:");
		lblAvgWaitTime.setForeground(Color.WHITE);
		lblAvgWaitTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvgWaitTime.setBounds(39, 155, 111, 20);
		panel.add(lblAvgWaitTime);

		JLabel lblAvgTurnAround = new JLabel("avg turn around time:");
		lblAvgTurnAround.setForeground(Color.WHITE);
		lblAvgTurnAround.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvgTurnAround.setBounds(39, 180, 136, 20);
		panel.add(lblAvgTurnAround);

		textField6 = new JTextField();
		textField6.setColumns(10);
		textField6.setBounds(185, 180, 48, 20);
		panel.add(textField6);

		textField5 = new JTextField();
		textField5.setColumns(10);
		textField5.setBounds(185, 155, 48, 20);
		panel.add(textField5);

		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(185, 124, 48, 20);
		panel.add(textField4);

		panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 102));
		panel_1.setBounds(10, 271, 813, 221);
		frmVirtualMemorySimulator.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 793, 164);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "PID", "duration(burst time)",
				"start time", "finish time", "turn around time", "wait time", "# of faults", "# of pages" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(53);
		table.getColumnModel().getColumn(0).setMinWidth(14);
		table.getColumnModel().getColumn(1).setPreferredWidth(117);
		table.getColumnModel().getColumn(4).setPreferredWidth(97);
		table.getColumnModel().getColumn(7).setPreferredWidth(74);

		lbl8 = new JLabel("Processes info & status:");
		lbl8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl8.setBounds(10, 246, 190, 14);
		frmVirtualMemorySimulator.getContentPane().add(lbl8);
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent e) {
		FileInput fi = new FileInput();
		switch (comboBox1.getSelectedIndex()) {
		case (0): { // Configuration file
			P = fi.readConfigurationFile();
			break;
		}
		case (1): { // Generated file
			P = fi.readGeneratedFile();
			break;
		}
		default:
		}
	}

	private void jComboBox2ActionPerformed(java.awt.event.ActionEvent e) {
		switch (comboBox2.getSelectedIndex()) {
		case (0): {
			user_ram = 40;
			break;
		}
		case (1): {
			user_ram = 200;
			break;
		}
		case (2): {
			user_ram = 500;
			break;
		}
		default:
		}
	}

	private void jComboBox4ActionPerformed(java.awt.event.ActionEvent e) {
		switch (comboBox4.getSelectedIndex()) {
		case (0): {
			algorithmFlag = 1; // fifo
			break;
		}
		case (1): {
			algorithmFlag = 2; // econd chance
			break;
		}
		case (2): {
			algorithmFlag = 3;// lru
			break;
		}
		default:
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent e) {
		
		MyThread thread = new MyThread();
		// clear table
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				int rowCount = dm.getRowCount();
				// Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
					dm.removeRow(i);
				}
				
		// change array list to array
		Process[] ar_p = new Process[P.size()];
		ar_p = P.toArray(new Process[0]);
		thread.setFlag(algorithmFlag);
		thread.setRamsize(user_ram);
		thread.setArrp(ar_p);
		thread.run();

		total_cycles = thread.getF().getCycles();
		for (int i = 0; i < P.size(); i++) {
			total_CPU_time += P.get(i).getDuration();
			total_faults += ar_p[i].getFaultsNumber();
			total_cycles += thread.getPr().getCycles();
		}
		thread.getF().setContext_switch(ar_p.length);
		total_CS = thread.getF().getContext_switch();
		avg_WT = thread.getF().getAVG_WT();
		avg_TAT = thread.getF().getAVG_TAT();

		System.out.println("Total number of faults = " + total_faults);
		//System.out.println("number of faults for proccess  "+ i+ total_faults);
		
		
		// initialize table cells
		textField1.setText(String.valueOf(total_faults));
		textField2.setText(String.valueOf(total_cycles));
		textField3.setText(String.valueOf(total_CS));
		textField4.setText(String.valueOf(total_CPU_time));
		textField5.setText(String.valueOf(avg_WT));
		textField6.setText(String.valueOf(avg_TAT));

		// add to table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int k = 0; k < P.size(); k++) {
			int finish_time = P.get(k).getTAtime() + P.get(k).getArrivalTime();
			model.addRow(new Object[] { P.get(k).getProcessID(), P.get(k).getDuration(),
					String.valueOf(P.get(k).getArrivalTime()), String.valueOf(finish_time),
					String.valueOf(ar_p[k].getTAtime()), String.valueOf(ar_p[k].getWTime()),
					String.valueOf(ar_p[k].getFaultsNumber()), P.get(k).getSize() });
		}
		
	}
}