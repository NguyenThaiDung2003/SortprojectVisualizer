package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSpinner;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private final ButtonGroup grInitMethod = new ButtonGroup();
	private final ButtonGroup grAlgorithms = new ButtonGroup();
	private final ButtonGroup grControl = new ButtonGroup();
	private JButton btnBack;
	private int amount;
	private JLabel[] lblArray;
	private int[] array;
	private Thread[] threads = new Thread[1000000];
	private int curT = -1;
	private JLabel[] lblBucket = new JLabel[5];

	private JLabel lblAppName;

	private JPanel pnSortArea;

	private JPanel pnInitArea;
	private JSpinner spAmt;
	private JRadioButton rdRandom;
	private JRadioButton rdByHand;
	private JButton btnCreate, btnEdit, btnDelete;

	private JPanel pnDescribeArea;
	private JTextPane txtAgrthmDescribe;

	private JPanel pnSelectAgrthmArea;
	private JRadioButton rdBubbleSort;
	private JRadioButton rdMergeSort;
	private ArrayList<JLabel> list;
	private JRadioButton rdSelectionSort;
	private JRadioButton rdBucketSort;

	private JPanel pnControlArea;
	private JRadioButton rdIncrease;
	private JRadioButton rdDecrease;
	private JButton btnSort, btnClear;
	//private boolean checkPause;
	//private Object lock = new Object();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setLookandFeel();
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(1, 1, (int) dim.getWidth()-100, (int) dim.getHeight()-100);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAppName = new JLabel("SORTING APPLICATION");
		lblAppName.setBackground(new Color(238, 130, 238));
		lblAppName.setHorizontalAlignment(SwingConstants.CENTER);
		lblAppName.setForeground(new Color(255, 0, 0));
		lblAppName.setFont(new Font("Snap ITC", Font.BOLD, 28));
		lblAppName.setBounds(165, -11, 1351, 74);
		contentPane.add(lblAppName);

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backAction();
			}
		});
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(41, 10, 104, 34);
		contentPane.add(btnBack);

		/*
		 * Init Area
		*/
		pnInitArea = new JPanel();
		pnInitArea.setBackground(new Color(238, 130, 238));
		pnInitArea.setBounds(10, 64, 285, 437);
		contentPane.add(pnInitArea);
		pnInitArea.setLayout(null);

		JLabel lblInitArea = new JLabel("INITIALIZE");
		lblInitArea.setBackground(new Color(240, 248, 255));
		lblInitArea.setBounds(6, 5, 252, 60);
		lblInitArea.setForeground(new Color(255, 0, 0));
		lblInitArea.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lblInitArea.setHorizontalAlignment(SwingConstants.CENTER);
		pnInitArea.add(lblInitArea);

		JLabel lblAmt = new JLabel("Amount");
		lblAmt.setForeground(new Color(0, 0, 0));
		lblAmt.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblAmt.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmt.setBounds(6, 75, 129, 29);
		pnInitArea.add(lblAmt);

		spAmt = new JSpinner();
		spAmt.setModel(new SpinnerNumberModel(2, 2, 10, 1));
		spAmt.setFont(new Font("Arial", Font.PLAIN, 18));
		spAmt.setBounds(145, 75, 109, 27);
		pnInitArea.add(spAmt);

		JLabel lblLimit = new JLabel("(from 2 to 10)");
		lblLimit.setForeground(new Color(245, 255, 250));
		lblLimit.setFont(new Font("Rockwell", Font.PLAIN, 18));
		lblLimit.setHorizontalAlignment(SwingConstants.CENTER);
		lblLimit.setBounds(6, 102, 129, 29);
		pnInitArea.add(lblLimit);

		btnCreate = new JButton("CREATE");
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setBackground(new Color(255, 255, 255));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createArray();
			}
		});
		btnCreate.setForeground(new Color(255, 0, 0));
		btnCreate.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnCreate.setBounds(81, 153, 117, 54);
		pnInitArea.add(btnCreate);


		btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Initialize newInit = new Initialize(array);
				newInit.setVisible(true);
			}
		});
		btnEdit.setForeground(Color.RED);
		btnEdit.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBounds(81, 217, 117, 54);
		pnInitArea.add(btnEdit);

		btnDelete = new JButton("DELETE");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteArray();
				setState(0);
			}
		});
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnDelete.setBounds(81, 279, 117, 54);
		pnInitArea.add(btnDelete);

		rdRandom = new JRadioButton("Random");
		rdRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createRandom();
			}
		});
		rdRandom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdRandom.setBackground(new Color(238, 130, 238));
		grInitMethod.add(rdRandom);
		rdRandom.setForeground(new Color(255, 255, 255));
		rdRandom.setFont(new Font("Rockwell", Font.BOLD, 18));
		rdRandom.setBounds(32, 378, 103, 27);
		pnInitArea.add(rdRandom);

		rdByHand = new JRadioButton("By hand");
		rdByHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Initialize newInit = new Initialize();
				newInit.setVisible(true);
			}
		});
		rdByHand.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdByHand.setBackground(new Color(238, 130, 238));
		grInitMethod.add(rdByHand);
		rdByHand.setForeground(Color.WHITE);
		rdByHand.setFont(new Font("Rockwell", Font.BOLD, 18));
		rdByHand.setBounds(155, 378, 103, 27);
		pnInitArea.add(rdByHand);

		JLabel lblSlctInitMethod = new JLabel("Initialization Method");
		lblSlctInitMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblSlctInitMethod.setForeground(new Color(0, 0, 0));
		lblSlctInitMethod.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblSlctInitMethod.setBounds(6, 343, 248, 29);
		pnInitArea.add(lblSlctInitMethod);


		/*
		 * Describe Area
		 */
		pnDescribeArea = new JPanel();
		pnDescribeArea.setBackground(new Color(238, 130, 238));
		pnDescribeArea.setBounds(305, 511, 800, 289);
		contentPane.add(pnDescribeArea);
		pnDescribeArea.setLayout(null);

		JLabel lblDescribe = new JLabel("DESCRIBE");
		lblDescribe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescribe.setForeground(new Color(255, 0, 0));
		lblDescribe.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lblDescribe.setBounds(6, 5, 780, 60);//848
		pnDescribeArea.add(lblDescribe);

		txtAgrthmDescribe = new JTextPane();
		txtAgrthmDescribe.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtAgrthmDescribe.setEditable(false);
		txtAgrthmDescribe.setFont(new Font("Rockwell", Font.PLAIN, 24));
		txtAgrthmDescribe.setBounds(16, 50, 750, 202);//77
		pnDescribeArea.add(txtAgrthmDescribe);

		pnSortArea = new JPanel();
		pnSortArea.setBorder(new LineBorder(new Color(238, 130, 238), 4));
		pnSortArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pnSortArea.setBackground(new Color(255, 255, 255));
		pnSortArea.setBounds(305, 64, 1211, 437);////
		contentPane.add(pnSortArea);
		pnSortArea.setLayout(null);

		/*
		 * Select Algorithm Area
		 */
		pnSelectAgrthmArea = new JPanel();
		pnSelectAgrthmArea.setBounds(10, 511, 285, 289);
		contentPane.add(pnSelectAgrthmArea);
		pnSelectAgrthmArea.setBackground(new Color(238, 130, 238));
		pnSelectAgrthmArea.setLayout(null);

		JLabel lbAgrthms = new JLabel("ALGORITHMS");
		lbAgrthms.setForeground(new Color(255, 0, 0));
		lbAgrthms.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lbAgrthms.setHorizontalAlignment(SwingConstants.CENTER);
		lbAgrthms.setBounds(6, 6, 252, 60);////////////
		pnSelectAgrthmArea.add(lbAgrthms);

		rdBubbleSort = new JRadioButton("Bubble Sort");
		rdBubbleSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBubbleSort();
			}
		});
		rdBubbleSort.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdBubbleSort.setBackground(new Color(238, 130, 238));
		grAlgorithms.add(rdBubbleSort);
		rdBubbleSort.setFont(new Font("Rockwell", Font.BOLD, 22));
		rdBubbleSort.setBounds(32, 50, 204, 35);
		pnSelectAgrthmArea.add(rdBubbleSort);

		rdMergeSort = new JRadioButton("Merge Sort");
		rdMergeSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMergeSort();
			}
		});
		rdMergeSort.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdMergeSort.setBackground(new Color(238, 130, 238));
		grAlgorithms.add(rdMergeSort);
		rdMergeSort.setFont(new Font("Rockwell", Font.BOLD, 22));
		rdMergeSort.setBounds(32, 85, 204, 35);
		pnSelectAgrthmArea.add(rdMergeSort);

		rdSelectionSort = new JRadioButton("Selection Sort");
		rdSelectionSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSelectionSort();
			}
		});
		rdSelectionSort.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdSelectionSort.setBackground(new Color(238, 130, 238));
		grAlgorithms.add(rdSelectionSort);
		rdSelectionSort.setFont(new Font("Rockwell", Font.BOLD, 22));
		rdSelectionSort.setBounds(32, 120, 204, 35);
		pnSelectAgrthmArea.add(rdSelectionSort);

		rdBucketSort = new JRadioButton("Bucket Sort");
		rdBucketSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBucketSort();
			}
		});
		rdBucketSort.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdBucketSort.setBackground(new Color(238, 130, 238));
		grAlgorithms.add(rdBucketSort);
		rdBucketSort.setFont(new Font("Rockwell", Font.BOLD, 22));
		rdBucketSort.setBounds(32, 155, 204, 35);
		pnSelectAgrthmArea.add(rdBucketSort);

		/*
		 * Control Area
		 */
		pnControlArea = new JPanel();
		pnControlArea.setBounds(1050, 511, 325, 289);/////////////////////////////
		contentPane.add(pnControlArea);
		pnControlArea.setBackground(new Color(238, 130, 238));
		pnControlArea.setLayout(null);

		JLabel lblControl = new JLabel("CONTROL");
		lblControl.setForeground(new Color(255, 0, 0));
		lblControl.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lblControl.setHorizontalAlignment(SwingConstants.CENTER);
		lblControl.setBounds(10, 10, 309, 60);
		pnControlArea.add(lblControl);

		btnSort = new JButton("SORT");
		btnSort.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSort.setBackground(new Color(255, 255, 255));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(3);
				for(int i = 0; i < amount; i++) {
					lblArray[i].setForeground(Color.BLACK);
					lblArray[i].setBackground(Color.ORANGE);
				}

				if(rdBubbleSort.isSelected()) {
					BubbleSort();
					waitEnd();
				}

				if(rdMergeSort.isSelected()) {
					list = new ArrayList<JLabel> (amount);
					MergeSort(array, 0, amount - 1);
				}

				if(rdSelectionSort.isSelected()) {
					SelectionSort();
					waitEnd();
				}

				if(rdBucketSort.isSelected()) {
					BucketSort();
					waitEnd();
				}
			}
		});
		btnSort.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnSort.setBounds(38, 70, 126, 49);
		pnControlArea.add(btnSort);

		btnClear = new JButton("CLEAR");
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteArray();
				setState(0);
			}
		});
		btnClear.setFont(new Font("Rockwell", Font.BOLD, 20));
		btnClear.setBounds(38, 150, 126, 49);
		pnControlArea.add(btnClear);

		rdIncrease = new JRadioButton("Increase");
		rdIncrease.setSelected(true);
		rdIncrease.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdIncrease.setForeground(new Color(255, 255, 255));
		rdIncrease.setBackground(new Color(238, 130, 238));
		grControl.add(rdIncrease);
		rdIncrease.setHorizontalAlignment(SwingConstants.LEFT);
		rdIncrease.setFont(new Font("Rockwell", Font.BOLD, 16));
		rdIncrease.setBounds(192, 100, 109, 35);
		pnControlArea.add(rdIncrease);

		rdDecrease = new JRadioButton("Decrease");
		rdDecrease.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rdDecrease.setForeground(new Color(255, 255, 255));
		rdDecrease.setBackground(new Color(238, 130, 238));
		grControl.add(rdDecrease);
		rdDecrease.setHorizontalAlignment(SwingConstants.LEFT);
		rdDecrease.setFont(new Font("Rockwell", Font.BOLD, 16));
		rdDecrease.setBounds(192, 125, 109, 35);
		pnControlArea.add(rdDecrease);

		setState(0);
		rdBubbleSort.setSelected(true);
		addBubbleSort();
	}


	/*
	 * Set look and feel
	 */
	public static void setLookandFeel() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {

		}
	}

	public void backAction() {
		this.dispose();
		(new Welcome()).setVisible(true);
	}


	/*
	 * Set State
	 */
	public void setState(int state) {
		switch(state) {
		case 0: //haven't created array
			btnCreate.setEnabled(true);
			btnEdit.setEnabled(false);
			btnDelete.setEnabled(false);

			rdRandom.setEnabled(false);
			rdRandom.setSelected(false);
			rdByHand.setEnabled(true);
			rdByHand.setSelected(false);

			rdBubbleSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			rdSelectionSort.setEnabled(true);
			rdBucketSort.setEnabled(true);

			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);

			btnSort.setEnabled(false);
			btnClear.setEnabled(false);
			//checkPause = false;
			break;

		case 1: //be waiting to set array values
			btnEdit.setEnabled(true);
			btnDelete.setEnabled(true);

			rdRandom.setEnabled(true);
			rdByHand.setEnabled(true);


			rdBubbleSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			rdSelectionSort.setEnabled(true);
			rdBucketSort.setEnabled(true);

			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);
			//checkPause = false;
			break;

		case 2: //ready to sort
			btnEdit.setEnabled(true);
			btnDelete.setEnabled(true);

			rdRandom.setEnabled(true);
			rdByHand.setEnabled(true);


			rdBubbleSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			rdSelectionSort.setEnabled(true);
			rdBucketSort.setEnabled(true);

			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);

			btnSort.setEnabled(true);
			btnClear.setEnabled(false);
			//checkPause = false;
			break;

		case 3: //sorting
			btnCreate.setEnabled(false);
			btnEdit.setEnabled(false);
			btnDelete.setEnabled(false);

			rdRandom.setEnabled(false);
			rdByHand.setEnabled(false);


			rdBubbleSort.setEnabled(false);
			rdMergeSort.setEnabled(false);
			rdSelectionSort.setEnabled(false);
			rdBucketSort.setEnabled(false);

			rdIncrease.setEnabled(false);
			rdDecrease.setEnabled(false);

			btnSort.setEnabled(false);
			btnClear.setEnabled(true);
			//checkPause = false;
			break;

		case 4: //sort done
			btnCreate.setEnabled(true);
			btnEdit.setEnabled(true);
			btnDelete.setEnabled(true);

			rdRandom.setEnabled(true);
			rdByHand.setEnabled(true);


			rdBubbleSort.setEnabled(true);
			rdMergeSort.setEnabled(true);
			rdSelectionSort.setEnabled(true);
			rdBucketSort.setEnabled(true);

			rdIncrease.setEnabled(true);
			rdDecrease.setEnabled(true);

			btnSort.setEnabled(true);
			btnClear.setEnabled(true);
			//checkPause = false;
			break;
		}
	}


	/*
	 * Init Methods
	 */
	public void createArray() {
		deleteArray(); //delete previous data and set amount of array
		amount = (Integer) spAmt.getValue();

		lblArray = new JLabel[amount];
		array = new int[amount];

		for(int i = 0; i < amount; i++) {
			//create label
			lblArray[i] = new JLabel("0");
			array[i] = 0;
			pnSortArea.add(lblArray[i]);
			lblArray[i].setText(String.valueOf(array[i]));

			//set Size
			lblArray[i].setOpaque(true);
			lblArray[i].setSize(50, 50);

			//set location label
			if (i == 0)
				lblArray[i].setLocation(((int) ((15 - amount) * 0.5) * 70) + 100, 150);
			else
				lblArray[i].setLocation(lblArray[i-1].getX() + 70, 150);

			//set font
			lblArray[i].setFont(new Font("Arial", Font.PLAIN, 30));

			//set color
			lblArray[i].setForeground(Color.BLACK);
			lblArray[i].setBackground(Color.lightGray);

			//set text alighment center
			lblArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblArray[i].setVerticalAlignment(SwingConstants.CENTER);

		}

		pnSortArea.setVisible(true);
		pnSortArea.validate();
		pnSortArea.repaint();
		setState(1);
	}

	public void deleteArray() {
		for (int i = 0; i < curT; i++) {
			try {
					threads[i].interrupt();
			}
			catch (Exception e) {

			}
		}
		curT = -1;

		for (int i = 0; i < amount; i++) {
			lblArray[i].setText("0");
			array[i] = 0;
			lblArray[i].setVisible(false);
		}
		pnSortArea.removeAll();

		pnSortArea.revalidate();
		pnSortArea.repaint();
		if(rdBubbleSort.isSelected()) addBubbleSort();
		if(rdMergeSort.isSelected()) addMergeSort();
		if(rdSelectionSort.isSelected()) addSelectionSort();
		if(rdBucketSort.isSelected()) addBucketSort();
		
		
		setState(0);
		if(mergesort == true)
		{
			if(timer1.isRunning()) timer1.stop();
			if(timer2.isRunning()) timer2.stop();
			mergesort = false;
		}
		
	}

	public void createRandom() {
		createArray();
		Random rand = new Random();
		for(int i = 0; i < amount; i++) {
			array[i] = rand.nextInt(101) + 0;
			lblArray[i].setText(String.valueOf(array[i]));
			lblArray[i].setForeground(Color.BLACK);
			lblArray[i].setBackground(Color.lightGray);
		}

		pnSortArea.setVisible(true);
		pnSortArea.validate();
		pnSortArea.repaint();
		setState(2);
	}

	public void setArray(int[] initArray) {
		deleteArray(); //delete previous data and set amount of array
		amount = initArray.length;
		spAmt.setValue(amount);

		lblArray = new JLabel[amount];
		array = initArray;

		for(int i = 0; i < amount; i++) {
			//create label
			lblArray[i] = new JLabel("");
			pnSortArea.add(lblArray[i]);
			lblArray[i].setText(String.valueOf(array[i]));

			//set Size
			lblArray[i].setOpaque(true);
			lblArray[i].setSize(50, 50);

			//set location label
			if (i == 0)
				lblArray[i].setLocation(((int) ((15 - amount) * 0.5) * 70) + 100, 150);
			else
				lblArray[i].setLocation(lblArray[i-1].getX() + 70, 150);

			//set font
			lblArray[i].setFont(new Font("Arial", Font.PLAIN, 30));

			//set color
			lblArray[i].setForeground(Color.BLACK);
			lblArray[i].setBackground(Color.lightGray);

			//set text alighment center
			lblArray[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblArray[i].setVerticalAlignment(SwingConstants.CENTER);

		}

		pnSortArea.setVisible(true);
		pnSortArea.validate();
		pnSortArea.repaint();
		setState(2);
	}


	/*
	 * Algorithms
	 */
	//BubbleSort
	public void addBubbleSort() {
		txtAgrthmDescribe.removeAll();
		txtAgrthmDescribe.setText("Bubble Sort is the simplest sorting algorithm that works by repeatedly \n\n"
				+ "swapping the adjacent elements if they are in the wrong order.\n\n"
				+ "BPP: O(n^2)");
	}
	public void BubbleSort() {
		int times = 0;
		if(rdIncrease.isSelected()) {
			boolean check = true;
			do {
				check = true;
				if(times == 0) {
					++curT;
					int cur = curT;

					threads[cur] = new Thread (new Runnable() {
						public void run() {
							try {
								//while(checkPause);
								txtAgrthmDescribe.setText("Bubble sort starts with very first two elements, comparing them to check which one is greater.");
								Thread.sleep(3000);
								txtAgrthmDescribe.setText("Algorithm compares two adjacent elements.");
							} catch(Exception e) {

							}
						}
					});
					threads[cur].start();
					++times;
				}
				for(int i = 0; i < amount - 1; i++) {
					highLightlbl(lblArray[i], lblArray[i + 1]);
					if(array[i] > array[i + 1]) {
						++curT;
						int cur = curT;
						int a = array[i], b = array[i + 1], id = i;

						threads[cur] = new Thread (new Runnable() {
							public void run() {
								try {
									//while(checkPause);
									threads[cur - 1].join();
									lblArray[id].setBackground(Color.GREEN);
									lblArray[id + 1].setBackground(Color.GREEN);
									txtAgrthmDescribe.setText("Swap since " + a + " > " + b);
									Thread.sleep(500);
									txtAgrthmDescribe.setText("Algorithm compares two adjacent elements.");
									lblArray[id].setBackground(Color.ORANGE);
									lblArray[id + 1].setBackground(Color.ORANGE);
								} catch(Exception e) {

								}
							}
						});
						threads[cur].start();
						check = false;
						int tmp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = tmp;
						swap(lblArray[i], lblArray[i + 1]);
					}
				}
			} while(!check);
		}
		else {
			boolean check = true;
			do {
				check = true;
				if(times == 0) {
					++curT;
					int cur = curT;

					threads[cur] = new Thread (new Runnable() {
						public void run() {
							try {
								//while(checkPause);
								txtAgrthmDescribe.setText("Bubble sort starts with very last two elements, comparing them to check which one is greater.");
								Thread.sleep(3000);
								txtAgrthmDescribe.setText("Algorithm compares two adjacent elements.");
							} catch(Exception e) {

							}
						}
					});
					threads[cur].start();
					++times;
				}
				for(int i = amount - 1; i > 0; i--) {
					highLightlbl(lblArray[i], lblArray[i - 1]);
					if(array[i] > array[i - 1]) {
						++curT;
						int cur = curT;
						int a = array[i], b = array[i - 1], id = i;

						threads[cur] = new Thread (new Runnable() {
							public void run() {
								try {
									//while(checkPause);
									threads[cur - 1].join();
									lblArray[id].setBackground(Color.GREEN);
									lblArray[id - 1].setBackground(Color.GREEN);
									txtAgrthmDescribe.setText("Swap since " + a + " > " + b);
									Thread.sleep(500);
									txtAgrthmDescribe.setText("Algorithm compares two adjacent elements.");
									lblArray[id].setBackground(Color.ORANGE);
									lblArray[id - 1].setBackground(Color.ORANGE);
								} catch(Exception e) {

								}
							}
						});
						threads[cur].start();
						check = false;
						int tmp = array[i];
						array[i] = array[i - 1];
						array[i - 1] = tmp;
						swap(lblArray[i - 1], lblArray[i]);
					}
				}
			} while(!check);
		}
	}


	//MergeSort
	public void addMergeSort() {
		txtAgrthmDescribe.removeAll();
		txtAgrthmDescribe.setText("The Merge Sort algorithm is a sorting algorithm that is "
				+ " as an example of the divide and conquer strategy. So, in this algorithm, "
				+ "the array is initially divided into two equal halves and then they are combined in a sorted manner.\n\n"
				+ "BPP: O(nlogn)");
	}

	public void MergeSort(int arr[],int l,int r) {
		if(l<r) {
			 for(int i=l;i<=r;i++) {
          	   lblArray[i].setLocation(lblArray[i].getX(),lblArray[i].getY()-30);
             }
			 start();
		}
	}

	public void divide(int l, int r,int gap)
    {
        if(l<r) {
            curT++;
	        int cur = curT;
	        threads[cur] = new Thread(new Runnable() {
		        public void run() {
			    	try {
			    		if (cur != 0) {
			    			threads[cur - 1].join();
			    	    }

			    	    int tmp1 = 0;

		               	int mid = (l + r) / 2;

		            	while(tmp1 < gap) {
		            		for(int i = l; i <= mid; i++){
		            			lblArray[i].setLocation(lblArray[i].getX() - 2, lblArray[i].getY());
		            		}
		            		for(int i = mid + 1; i <= r; i++) {
		            			lblArray[i].setLocation(lblArray[i].getX() + 2, lblArray[i].getY());
		            		}
		        			txtAgrthmDescribe.setText("Divive array into two subarrays.");
		            		Thread.sleep(20);
		            		tmp1++;
		            	}

		            	divide(l, mid, gap/2);
			            divide(mid+1, r, gap/2);
			        }catch (Exception e) {}
				}
	        });
	        threads[cur].start();
        }
    }

    public void merge(int l, int r, int hgap, int vgap)
    {
    	if(l >= r) return;

    	int mid = (l + r) / 2;
    	merge(l, mid, hgap / 2, vgap - 60);
        merge(mid + 1, r, hgap / 2, vgap - 60);

        curT++;
        int cur=curT;
        threads[cur] = new Thread(new Runnable() {
	        public void run() {
	    	try {
			    if (cur != 0) {
			    	threads[cur - 1].join();
			    }

			    int y;
			    JLabel[] tmplabel = new JLabel[11];
			    y = (lblArray[l].getY() > lblArray[r].getY()) ? lblArray[l].getY() : lblArray[r].getY();
			    y += vgap;
			    for(int i = l; i <= r; i++) {
			    	tmplabel[i] = new JLabel("  ");
			    	tmplabel[i].setHorizontalAlignment(JLabel.CENTER);
			    	tmplabel[i].setVerticalAlignment(JLabel.CENTER);
			    	tmplabel[i].setFont(new Font("Arial", Font.PLAIN, 30));
				    tmplabel[i].setBackground(Color.ORANGE);
				    tmplabel[i].setOpaque(true);
				    pnSortArea.add(tmplabel[i]);
				    list.add(tmplabel[i]);
				    tmplabel[i].setBounds(lblArray[i].getX(), y, 50, 50);
				    tmplabel[i].setVisible(false);
				}

			    tmplabel[mid].setLocation(tmplabel[mid].getX()+hgap,tmplabel[mid].getY());

			    for(int i=mid-1;i>=l;i--)
			    {
			    	tmplabel[i].setLocation(tmplabel[i+1].getX()-80,tmplabel[i].getY());
			    }
			    for(int i=mid+1;i<=r;i++)
			    {
			    	tmplabel[i].setLocation(tmplabel[i-1].getX()+80,tmplabel[i].getY());
			    }
			    for(int i=l;i<=r;i++)
			    {
			    	tmplabel[i].setVisible(true);
			    }
			    Thread.sleep(800);

			    int i, j, k;
			    int n1 = mid - l + 1;
			    int n2 = r - mid;


			    // mang tam thoi
			    int L[] = new int[n1];
			    int R[] = new int[n2];

			    /* Copy data to temp arrays L[] and R[] */
			    for (i = 0; i < n1; i++)
			    	L[i] = array[l + i];
			    for (j = 0; j < n2; j++)
			    	R[j] = array[mid + 1 + j];

			    /* Merge the temp arrays back into arr[l..r]*/
			    i = 0; // Initial index of first subarray
			    j = 0; // Initial index of second subarray
			    k = l; // Initial index of merged subarray

			    while (i < n1 && j < n2) {
			    	lblArray[l + i].setBackground(Color.RED);
			    	lblArray[mid + 1 + j].setBackground(Color.RED);
	        	   	Thread.sleep(800);
	        	   	lblArray[l + i].setBackground(Color.ORANGE);
	        	   	lblArray[mid + 1 + j].setBackground(Color.ORANGE);
	        	   	if(rdIncrease.isSelected())// tang dan
	        	   	{
	        	   		if (L[i] <= R[j]) {
	        	   			array[k] = L[i];
	        	   			tmplabel[k].setText(String.valueOf(L[i]));
	        	   			txtAgrthmDescribe.setText("Merge two subarrays.\nChoose " + L[i]);
	        	   			i++;
	        	   		}
	        	   		else {
	        	   			array[k] = R[j];
	        	   			tmplabel[k].setText(String.valueOf(R[j]));
	        	   			txtAgrthmDescribe.setText("Merge two subarrays.\nChoose " + R[j]);
	        	   			j++;
	        	   		}
	        	   		k++;
	        	   	}

	        	   	if(rdDecrease.isSelected())// giam gan
	        	   	{
	        	   		if (L[i] >= R[j]) {
	        	   			array[k] = L[i];
	        	   			tmplabel[k].setText(String.valueOf(L[i]));
	        	   			txtAgrthmDescribe.setText("Merge two subarrays.\nChoose " + L[i]);
	        	   			i++;
	        	   		}
	        	   		else {
	        	   			array[k]=R[j];
	        	   			tmplabel[k].setText(String.valueOf(R[j]));
	        	   			txtAgrthmDescribe.setText("Merge two subarrays.\nChoose " + R[j]);
	        	   			j++;
	        	   		}
	        	   		k++;
	        	   	}

	        	   	Thread.sleep(800);
			    }

			    /* Copy the remaining elements of L[], if there
	          	are any */
			    while (i < n1) {
			    	lblArray[l + i].setBackground(Color.RED);
			    	Thread.sleep(800);
			    	lblArray[l + i].setBackground(Color.ORANGE);
			    	array[k] = L[i];
			    	tmplabel[k].setText(String.valueOf(L[i]));
			    	txtAgrthmDescribe.setText("Merge two subarrays.\nChoose " + L[i]);
			    	i++;
			    	k++;
			    	Thread.sleep(800);
			    }

			    /* Copy the remaining elements of R[], if there
	         	are any */
			    while (j < n2) {
			    	lblArray[mid + 1 + j].setBackground(Color.RED);
		            Thread.sleep(800);
		            lblArray[mid + 1 + j].setBackground(Color.ORANGE);
		            array[k] = R[j];
		            tmplabel[k].setText(String.valueOf(R[j]));
		            txtAgrthmDescribe.setText("Merge two subarrays.\nChoose " + R[j]);
		            j++;
		            k++;
		            Thread.sleep(800);
		        }
	            for( i=l;i<=r;i++)
	            {
	            	lblArray[i].setText(tmplabel[i].getText());
	            }

	            Thread.sleep(3000*(l-r+1));

	    	} catch (Exception e) {}
			}
        });
        threads[cur].start();
    }
    public void repaint()
    {
       curT++;
       int cur = curT;
       threads[cur] = new Thread(new Runnable() {
    	   public void run() {
    		   try {
    			   if (cur != 0) {
    				   threads[cur - 1].join();
    			   }

	               for(int i = 0; i < amount; i++)
	               {
	            	   lblArray[i].setVisible(false);
	               }
	               int numbergap = 0;
	               int tmp = 1;
	               while(tmp < amount)
	               {
	                  numbergap++;
	                  tmp = tmp * 2;
	                }
	               for(JLabel x:list)
	               {
	            	   if(x.getY()==lblArray[0].getY() + 60 * numbergap) {
	            		   x.setBackground(Color.BLUE);
	            		   x.setForeground(Color.WHITE);
	            		   x.setLocation(x.getX(),x.getY() - 50 * numbergap);
	            	   }
	            	   else x.setVisible(false);
	            	   txtAgrthmDescribe.setText("Successful arrangement!");
	               }

    		   }catch (Exception e) {}
    	   }
       });
       threads[cur].start();
    }

    private Timer timer1;
    private Timer timer2 ;
    private boolean mergesort = false;
    public void start()
    {
    	mergesort = true;
        divide(0, amount - 1, 30);
        int numbergaptmp = 0;
        int tmp = 1;
        while(tmp < amount)
        {
            numbergaptmp++;
            tmp = tmp * 2;
        }
        final int  numbergap = numbergaptmp;
        timer1 = new Timer (500 * amount, new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		merge(0,amount-1,30,60*numbergap);
        	}
        });
        timer1.setRepeats(false);
        timer1.start();
        timer2 = new Timer(1500*amount, new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent evt) {
        		repaint();
        	}
        });
        timer2.setRepeats(false);
        timer2.start();
        setState(4);
    }

	//SelectionSort
    public void addSelectionSort() {
		txtAgrthmDescribe.removeAll();
		txtAgrthmDescribe.setText("Selection sort is an in-place comparison sorting algorithm\n\n" + "BPP: O(n^2)");
	}
	public void SelectionSort() {
		int times = 0;
		if(rdIncrease.isSelected()) {
			if(times == 0) {
				++curT;
				int cur = curT;

				threads[cur] = new Thread (new Runnable() {
					public void run() {
						try {
							if(cur != 0) {
								threads[cur - 1].join();
							}
							txtAgrthmDescribe.setText("Selection sort begins by selecting the smallest "
									+ "of the initial n elements, returning this element to the correct "
									+ "position as the first in the current sequence..");
							Thread.sleep(2000);
							txtAgrthmDescribe.setText("Then ignore it, see the current sequence has only n-1 "
									+ "elements of the original sequence, starting from position 2.");
						} catch(Exception e) {

						}
					}
				});
				threads[cur].start();
				++times;
			}

			for(int i = 0; i < amount - 1; i++) {
				int minId = i;
				for(int j = i + 1; j < amount; j++) {
					highLightlbl(lblArray[i], lblArray[j]);
					if(array[j] < array[minId]) {
						minId = j;
						++curT;
						int cur = curT;
						int id = i, jd=j;

						threads[cur] = new Thread (new Runnable() {
							public void run() {
								try {
									if(cur != 0) {
										threads[cur - 1].join();
									}
									lblArray[id].setBackground(Color.GREEN);
									lblArray[jd].setBackground(Color.GREEN);
									txtAgrthmDescribe.setText("Found the smaller value!");
									Thread.sleep(500);
									lblArray[id].setBackground(Color.ORANGE);
									lblArray[jd].setBackground(Color.ORANGE);
								} catch(Exception e) {

								}
							}
						});
						threads[cur].start();
					}
				}
				if(i != minId) {
					int tmp = array[i];
					array[i] = array[minId];
					array[minId] = tmp;
					++curT;
					int cur = curT;
					int id = i + 1, min = minId;

					threads[cur] = new Thread (new Runnable() {
						public void run() {
							try {
								if(cur != 0) {
									threads[cur - 1].join();
								}
								lblArray[id - 1].setBackground(Color.GREEN);
								lblArray[min].setBackground(Color.GREEN);
								String text = "";
								switch(id) {
								case 1:
									text = "first";
									break;
								case 2:
									text = "second";
									break;
								case 3:
									text = "third";
									break;
								case 4:
									text = "fourth";
									break;
								case 5:
									text = "fifth";
									break;
								case 6:
									text = "sixth";
									break;
								case 7:
									text = "seventh";
									break;
								case 8:
									text = "eighth";
									break;
								case 9:
									text = "nineth";
									break;
								case 10:
									text = "tenth";
									break;
								}
								txtAgrthmDescribe.setText("Arange the " + text + " lowest value to the " + text + " place.");
								Thread.sleep(1000);
							} catch(Exception e) {

							}
						}
					});
					threads[cur].start();
					swap(lblArray[i], lblArray[minId]);
				}
			}
		}
		else {
			if(times == 0) {
				++curT;
				int cur = curT;

				threads[cur] = new Thread (new Runnable() {
					public void run() {
						try {
							if(cur != 0) {
								threads[cur - 1].join();
							}
							txtAgrthmDescribe.setText("Selection sort begins by selecting the "
									+ "biggest of the initial n elements, returning this element "
									+ "to the correct position as the first in the current sequence..");
							Thread.sleep(2000);
							txtAgrthmDescribe.setText("Then ignore it, see the current sequence has only "
									+ "n-1 elements of the original sequence, starting from position 2.");
						} catch(Exception e) {

						}
					}
				});
				threads[cur].start();
				++times;
			}

			for(int i = 0; i < amount - 1; i++) {
				int maxId = i;
				for(int j = i + 1; j < amount; j++) {
					highLightlbl(lblArray[i], lblArray[j]);
					if(array[j] > array[maxId]) {
						maxId = j;
						++curT;
						int cur = curT;
						int id = i, jd=j;

						threads[cur] = new Thread (new Runnable() {
							public void run() {
								try {
									if(cur != 0) {
										threads[cur - 1].join();
									}
									lblArray[id].setBackground(Color.GREEN);
									lblArray[jd].setBackground(Color.GREEN);
									txtAgrthmDescribe.setText("Found the bigger value!");
									Thread.sleep(500);
									lblArray[id].setBackground(Color.ORANGE);
									lblArray[jd].setBackground(Color.ORANGE);
								} catch(Exception e) {

								}
							}
						});
						threads[cur].start();
					}
				}
				if(i != maxId) {
					int tmp = array[i];
					array[i] = array[maxId];
					array[maxId] = tmp;
					++curT;
					int cur = curT;
					int id = i + 1, max = maxId;

					threads[cur] = new Thread (new Runnable() {
						public void run() {
							try {
								if(cur != 0) {
									threads[cur - 1].join();
								}
								lblArray[id - 1].setBackground(Color.GREEN);
								lblArray[max].setBackground(Color.GREEN);
								String text = "";
								switch(id) {
								case 1:
									text = "first";
									break;
								case 2:
									text = "second";
									break;
								case 3:
									text = "third";
									break;
								case 4:
									text = "fourth";
									break;
								case 5:
									text = "fifth";
									break;
								case 6:
									text = "sixth";
									break;
								case 7:
									text = "seventh";
									break;
								case 8:
									text = "eighth";
									break;
								case 9:
									text = "nineth";
									break;
								case 10:
									text = "tenth";
									break;
								}
								txtAgrthmDescribe.setText("Arange the " + text + " highest value to the " + text + " place.");
								Thread.sleep(1000);
								lblArray[id - 1].setBackground(Color.ORANGE);
								lblArray[max].setBackground(Color.ORANGE);
							} catch(Exception e) {

							}
						}
					});
					threads[cur].start();
					swap(lblArray[i], lblArray[maxId]);
				}
			}
		}
	}

	//BucketSort
	public void addBucketSort() {
		txtAgrthmDescribe.removeAll();
		txtAgrthmDescribe.setText("Bucket Sort is a sorting algorithm that divides the unsorted array n elements "
				+ "into k groups called buckets. \nEach bucket is then sorted by using any of the suitable "
				+ "sorting algorithms or recursively applying the same bucket algorithm."
				+ "\nBPP: O(nlogn)");
	}
	public void BucketSort() {
		curT++;
		int cur = curT;
		int Y = lblArray[0].getY();

		threads[cur] = new Thread(new Runnable() {
			public void run() {
				try {
					if(cur != 0) {
						threads[cur - 1].join();
					}
					int y = Y;
					while(y > 10) {
						for(int i = 0; i < amount; i++) {
							lblArray[i].setLocation(lblArray[i].getX(), lblArray[i].getY() - 10);
						}
						y -= 10;
						Thread.sleep(50);
					}

					int max = array[0], min = array[0];
					for(int i = 0; i < amount; i++) {
						max = (max < array[i]) ? array[i] : max;
						min = (min > array[i]) ? array[i] : min;
					}
					int lim = (max - min) / 5;
					txtAgrthmDescribe.setText("Find out"+"\nmin = "+min+"\nmax = "+max+"\nrange of each bucket = "+lim);
					Thread.sleep(2000);
					int[] valBucketStart = new int[5];
					valBucketStart[0] = min;
					for(int i = 1; i < 5; i++) {
						valBucketStart[i] = valBucketStart[i - 1] + lim + 1;
					}
					JLabel[] lblBucketLim = new JLabel[5];
					for(int i = 0; i < 5; i++) {
						lblBucket[i] = new JLabel("Bucket" + i);
						lblBucket[i].setForeground(Color.BLACK);
						lblBucket[i].setFont(new Font("Rockwell", Font.PLAIN, 20));
						lblBucket[i].setHorizontalAlignment(SwingConstants.CENTER);
						pnSortArea.add(lblBucket[i]);
						lblBucket[i].setBounds(6, 140 + 50*i, 130, 40);
						lblBucket[i].setVisible(true);
						lblBucket[i].setOpaque(true);

						if(i < 4) lblBucketLim[i] = new JLabel("(from " + valBucketStart[i] + " to " + (valBucketStart[i] + lim) + ")");
						else lblBucketLim[i] = new JLabel("(from " + valBucketStart[i] + " to " + max + ")");

						lblBucketLim[i].setForeground(Color.BLACK);
						lblBucketLim[i].setBackground(Color.WHITE);
						lblBucketLim[i].setFont(new Font("Rockwell", Font.PLAIN, 16));
						lblBucketLim[i].setHorizontalAlignment(SwingConstants.LEADING);
						pnSortArea.add(lblBucketLim[i]);
						lblBucketLim[i].setBounds(140, 140 + 50*i, 120, 40);
						lblBucketLim[i].setVisible(true);
						lblBucketLim[i].setOpaque(true);
					}
					txtAgrthmDescribe.setText(" Divide the array elements into the suitable group ");
					Thread.sleep(2000);

					int[] Bucket0 = new int[10];
					int[] Bucket1 = new int[10];
					int[] Bucket2 = new int[10];
					int[] Bucket3 = new int[10];
					int[] Bucket4 = new int[10];
					int[] bucketLength = new int[5];
					for(int i = 0; i < 5; i++) bucketLength[i] = 0;
					JLabel[] lblBucket0 = new JLabel[10];
					JLabel[] lblBucket1 = new JLabel[10];
					JLabel[] lblBucket2 = new JLabel[10];
					JLabel[] lblBucket3 = new JLabel[10];
					JLabel[] lblBucket4 = new JLabel[10];

					for(int i = 0; i < amount; i++) {
						try {
						for(int j = 4; j >= 0; j--) if(array[i] >= valBucketStart[j]) {
								switch(j) {
								case 0:
									Bucket0[bucketLength[j]] = array[i];
									lblBucket0[bucketLength[j]] = new JLabel(Bucket0[bucketLength[j]] + "");
									lblBucket0[bucketLength[j]].setForeground(Color.BLACK);
									lblBucket0[bucketLength[j]].setBackground(Color.ORANGE);
									lblBucket0[bucketLength[j]].setFont(new Font("Arial", Font.PLAIN, 20));
									lblBucket0[bucketLength[j]].setHorizontalAlignment(SwingConstants.CENTER);
									pnSortArea.add(lblBucket0[bucketLength[j]]);
									lblBucket0[bucketLength[j]].setBounds(270 + 50 * bucketLength[j], 140 + 50 * j, 40, 40);
									lblBucket0[bucketLength[j]].setVisible(true);
									lblBucket0[bucketLength[j]].setOpaque(true);
									break;
								case 1:
									Bucket1[bucketLength[j]] = array[i];
									lblBucket1[bucketLength[j]] = new JLabel(Bucket1[bucketLength[j]] + "");
									lblBucket1[bucketLength[j]].setForeground(Color.BLACK);
									lblBucket1[bucketLength[j]].setBackground(Color.ORANGE);
									lblBucket1[bucketLength[j]].setFont(new Font("Arial", Font.PLAIN, 20));
									lblBucket1[bucketLength[j]].setHorizontalAlignment(SwingConstants.CENTER);
									pnSortArea.add(lblBucket1[bucketLength[j]]);
									lblBucket1[bucketLength[j]].setBounds(270 + 50 * bucketLength[j], 140 + 50 * j, 40, 40);
									lblBucket1[bucketLength[j]].setVisible(true);
									lblBucket1[bucketLength[j]].setOpaque(true);
									break;
								case 2:
									Bucket2[bucketLength[j]] = array[i];
									lblBucket2[bucketLength[j]] = new JLabel(Bucket2[bucketLength[j]] + "");
									lblBucket2[bucketLength[j]].setForeground(Color.BLACK);
									lblBucket2[bucketLength[j]].setBackground(Color.ORANGE);
									lblBucket2[bucketLength[j]].setFont(new Font("Arial", Font.PLAIN, 20));
									lblBucket2[bucketLength[j]].setHorizontalAlignment(SwingConstants.CENTER);
									pnSortArea.add(lblBucket2[bucketLength[j]]);
									lblBucket2[bucketLength[j]].setBounds(270 + 50 * bucketLength[j], 140 + 50 * j, 40, 40);
									lblBucket2[bucketLength[j]].setVisible(true);
									lblBucket2[bucketLength[j]].setOpaque(true);
									break;
								case 3:
									Bucket3[bucketLength[j]] = array[i];
									lblBucket3[bucketLength[j]] = new JLabel(Bucket3[bucketLength[j]] + "");
									lblBucket3[bucketLength[j]].setForeground(Color.BLACK);
									lblBucket3[bucketLength[j]].setBackground(Color.ORANGE);
									lblBucket3[bucketLength[j]].setFont(new Font("Arial", Font.PLAIN, 20));
									lblBucket3[bucketLength[j]].setHorizontalAlignment(SwingConstants.CENTER);
									pnSortArea.add(lblBucket3[bucketLength[j]]);
									lblBucket3[bucketLength[j]].setBounds(270 + 50 * bucketLength[j], 140 + 50 * j, 40, 40);
									lblBucket3[bucketLength[j]].setVisible(true);
									lblBucket3[bucketLength[j]].setOpaque(true);
									break;
								case 4:
									Bucket4[bucketLength[j]] = array[i];
									lblBucket4[bucketLength[j]] = new JLabel(Bucket4[bucketLength[j]] + "");
									lblBucket4[bucketLength[j]].setForeground(Color.BLACK);
									lblBucket4[bucketLength[j]].setBackground(Color.ORANGE);
									lblBucket4[bucketLength[j]].setFont(new Font("Arial", Font.PLAIN, 20));
									lblBucket4[bucketLength[j]].setHorizontalAlignment(SwingConstants.CENTER);
									pnSortArea.add(lblBucket4[bucketLength[j]]);
									lblBucket4[bucketLength[j]].setBounds(270 + 50 * bucketLength[j], 140 + 50 * j, 40, 40);
									lblBucket4[bucketLength[j]].setVisible(true);
									lblBucket4[bucketLength[j]].setOpaque(true);
									break;
								}
								++bucketLength[j];
								break;
							}
							lblArray[i].setVisible(false);
							Thread.sleep(500);
						} catch(Exception e) {

						}
					}

					txtAgrthmDescribe.setText("Each bucket is then sorted by using any of the suitable sorting algorithms");

					Thread.sleep(2000);

					if(rdIncrease.isSelected()) {

						for(int i = 0; i < 5; i++) if(bucketLength[i] != 0){
							for(int j = 0; j < bucketLength[i] - 1; j++) {
								for(int k = j + 1; k < bucketLength[i]; k++) {
									switch(i) {
									case 0:
										if(Bucket0[j] > Bucket0[k]) {
											int tmp = Bucket0[j];
											Bucket0[j] = Bucket0[k];
											Bucket0[k] = tmp;
										}
										break;
									case 1:
										if(Bucket1[j] > Bucket1[k]) {
											int tmp = Bucket1[j];
											Bucket1[j] = Bucket1[k];
											Bucket1[k] = tmp;
										}
										break;
									case 2:
										if(Bucket2[j] > Bucket2[k]) {
											int tmp = Bucket2[j];
											Bucket2[j] = Bucket2[k];
											Bucket2[k] = tmp;
										}
										break;
									case 3:
										if(Bucket3[j] > Bucket3[k]) {
											int tmp = Bucket3[j];
											Bucket3[j] = Bucket3[k];
											Bucket3[k] = tmp;
										}
										break;
									case 4:
										if(Bucket4[j] > Bucket4[k]) {
											int tmp = Bucket4[j];
											Bucket4[j] = Bucket4[k];
											Bucket4[k] = tmp;
										}
										break;
									}
								}
							}
							try {
								for(int j = 0; j < bucketLength[i]; j++) {
									switch(i) {
									case 0:
										lblBucket0[j].setText(Bucket0[j] + "");
										lblBucket0[j].setForeground(Color.WHITE);
										break;
									case 1:
										lblBucket1[j].setText(Bucket1[j] + "");
										lblBucket1[j].setForeground(Color.WHITE);
										break;
									case 2:
										lblBucket2[j].setText(Bucket2[j] + "");
										lblBucket2[j].setForeground(Color.WHITE);
										break;
									case 3:
										lblBucket3[j].setText(Bucket3[j] + "");
										lblBucket3[j].setForeground(Color.WHITE);
										break;
									case 4:
										lblBucket4[j].setText(Bucket4[j] + "");
										lblBucket4[j].setForeground(Color.WHITE);
										break;
									}
								}

								Thread.sleep(500);
							} catch(Exception e) {

							}
						}
					}

					else {
						for(int i = 0; i < 5; i++) if(bucketLength[i] != 0){
							for(int j = 0; j < bucketLength[i] - 1; j++) {
								for(int k = j + 1; k < bucketLength[i]; k++) {
									switch(i) {
									case 0:
										if(Bucket0[j] < Bucket0[k]) {
											int tmp = Bucket0[j];
											Bucket0[j] = Bucket0[k];
											Bucket0[k] = tmp;
										}
										break;
									case 1:
										if(Bucket1[j] < Bucket1[k]) {
											int tmp = Bucket1[j];
											Bucket1[j] = Bucket1[k];
											Bucket1[k] = tmp;
										}
										break;
									case 2:
										if(Bucket2[j] < Bucket2[k]) {
											int tmp = Bucket2[j];
											Bucket2[j] = Bucket2[k];
											Bucket2[k] = tmp;
										}
										break;
									case 3:
										if(Bucket3[j] < Bucket3[k]) {
											int tmp = Bucket3[j];
											Bucket3[j] = Bucket3[k];
											Bucket3[k] = tmp;
										}
										break;
									case 4:
										if(Bucket4[j] < Bucket4[k]) {
											int tmp = Bucket4[j];
											Bucket4[j] = Bucket4[k];
											Bucket4[k] = tmp;
										}
										break;
									}
								}
							}

							try {
								for(int j = 0; j < bucketLength[i]; j++) {
									switch(i) {
									case 0:
										lblBucket0[j].setText(Bucket0[j] + "");
										lblBucket0[j].setForeground(Color.WHITE);
										break;
									case 1:
										lblBucket1[j].setText(Bucket1[j] + "");
										lblBucket1[j].setForeground(Color.WHITE);
										break;
									case 2:
										lblBucket2[j].setText(Bucket2[j] + "");
										lblBucket2[j].setForeground(Color.WHITE);
										break;
									case 3:
										lblBucket3[j].setText(Bucket3[j] + "");
										lblBucket3[j].setForeground(Color.WHITE);
										break;
									case 4:
										lblBucket4[j].setText(Bucket4[j] + "");
										lblBucket4[j].setForeground(Color.WHITE);
										break;
									}
								}

								Thread.sleep(2000);

							} catch(Exception e) {

							}
						}
					}

					txtAgrthmDescribe.setText("Finally, the sorted buckets are combined to form a final sorted array");

					if(rdIncrease.isSelected()) {
						int pos = 0;
						for(int i = 0; i < 5; i++) if(bucketLength[i] != 0){
							try {
								for(int j = 0; j < bucketLength[i]; j++) {
									lblArray[pos].setVisible(true);
									switch(i) {
									case 0:
										lblArray[pos++].setText(Bucket0[j] + "");
										break;
									case 1:
										lblArray[pos++].setText(Bucket1[j] + "");
										break;
									case 2:
										lblArray[pos++].setText(Bucket2[j] + "");
										break;
									case 3:
										lblArray[pos++].setText(Bucket3[j] + "");
										break;
									case 4:
										lblArray[pos++].setText(Bucket4[j] + "");
										break;
									}
								}
								Thread.sleep(800);
							} catch(Exception e) {

							}
						}
					}

					else {
						int pos = 0;
						for(int i = 4; i >= 0; i--) if(bucketLength[i] != 0){
							try {
								for(int j = 0; j < bucketLength[i]; j++) {
									lblArray[pos].setVisible(true);
									switch(i) {
									case 0:
										lblArray[pos++].setText(Bucket0[j] + "");
										break;
									case 1:
										lblArray[pos++].setText(Bucket1[j] + "");
										break;
									case 2:
										lblArray[pos++].setText(Bucket2[j] + "");
										break;
									case 3:
										lblArray[pos++].setText(Bucket3[j] + "");
										break;
									case 4:
										lblArray[pos++].setText(Bucket4[j] + "");
										break;
									}
								}
								Thread.sleep(800);
							} catch(Exception e) {

							}
						}
					}
				} catch(Exception e) {

				}
			}
		});
		threads[cur].start();

	}


	/*
	 * Movement Effect
	 */
	public void swap(JLabel lbl1, JLabel lbl2) {
		int X1 = lbl1.getX();
		int X2 = lbl2.getX();
		curT++;

		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
			public void run() {
				try {
					if(cur != 0) {
						threads[cur - 1].join();
					}

					lbl1.setBackground(Color.GREEN);
					lbl2.setBackground(Color.GREEN);
					while(lbl1.getY() > 100) {
						//while(checkPause);
						lbl1.setLocation(lbl1.getX(), lbl1.getY() - 10);
						lbl2.setLocation(lbl2.getX(), lbl2.getY() + 10);
						Thread.sleep(50);
					}
					while(lbl1.getX() < X2) {
						//while(checkPause);
						lbl1.setLocation(lbl1.getX() + 10, lbl1.getY());
						lbl2.setLocation(lbl2.getX() - 10, lbl2.getY());
						Thread.sleep(50);
					}
					while(lbl1.getY() < 140) {
						//while(checkPause);
						lbl1.setLocation(lbl1.getX(), lbl1.getY() + 10);
						lbl2.setLocation(lbl2.getX(), lbl2.getY() - 10);
						Thread.sleep(50);
					}
					String txtLbl1 = lbl1.getText();
					lbl1.setText(lbl2.getText());
					lbl2.setText(txtLbl1);
					lbl1.setLocation(X1, 150);
					lbl2.setLocation(X2, 150);
					lbl1.setBackground(Color.ORANGE);
					lbl2.setBackground(Color.ORANGE);
				} catch(Exception e) {

				}
			}
		});
		threads[cur].start();
	}

	public void highLightlbl(JLabel lbl1, JLabel lbl2) {
		curT++;

		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
			public void run() {
				try {
					if(cur != 0) {
						threads[cur - 1].join();
					}
					//while(checkPause);
					lbl1.setBackground(Color.GREEN);
					lbl2.setBackground(Color.GREEN);
					Thread.sleep(200);
					lbl1.setBackground(Color.ORANGE);
					lbl2.setBackground(Color.ORANGE);
				}
				catch(Exception e) {

				}
			}
		});
		threads[cur].start();
	}


	/*
	 * Done
	 */
	public void waitEnd() {
		curT++;

		int cur = curT;
		threads[cur] = new Thread(new Runnable() {
			public void run() {
				try {
					if(cur != 0) {
						threads[cur - 1].join();
					}
					setState(4);
					for(int  i = 0; i < amount; i++) {
						lblArray[i].setForeground(Color.WHITE);
						lblArray[i].setBackground(Color.BLUE);
					}
					txtAgrthmDescribe.setText("Successful arrangement!");
				}
				catch(Exception e) {

				}
			}
		});
		threads[cur].start();
	}
}
