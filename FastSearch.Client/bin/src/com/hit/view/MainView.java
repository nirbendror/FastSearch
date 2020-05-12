package com.hit.view;

import com.hit.Client.Messages.Response;
import com.hit.dm.searchItem;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class MainView extends JFrame{

	private HistoryTree b;
	private JLabel backGround;
	private JTextField SearchField;
	private JButton search;
	private JList<searchItem> searchList;
	private JLabel txtpnSearchLable;
	private JLabel txtpnFastsearch;
	private JButton clear;
	private JTextPane txtpnEnterText;
	private JButton delete;
	private JButton DeleteAll;
	private ButtonGroup G1;
	private JLabel operatioTime;
	private JRadioButton Naive;
	private JRadioButton Kmp;
	private JRadioButton RabinKarp;
	private JTextPane txtpnChoseaAlgo;
	private HistoryTree tree;
	private ImageIcon backGroundImg ;
	private JScrollPane scrollBar;
	private MainViewActionListener listener = new MainViewActionListener(this);

	public MainView() {
		super();
		initialization();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialization() {
		//frame = new JFrame();
		this.setBounds(100, 100, 816, 523);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setTitle("FastSearch App");





		SearchField = new JTextField();
		SearchField.setForeground(Color.BLACK);
		SearchField.setBackground(new Color(255, 255, 255));
		SearchField.setBounds(51, 143, 300, 31);
		this.getContentPane().add(SearchField);

		search = new JButton("search");
		search.setBackground(UIManager.getColor("CheckBox.foreground"));
		search.setBounds(364, 143, 92, 31);
		this.getContentPane().add(search);



		searchList = new JList<searchItem>();
		searchList.setCellRenderer(new SearchItemCellRenderer());
		searchList.setBounds(51, 209, 503, 264);
	    this.getContentPane().add(searchList);



		txtpnSearchLable = new JLabel();
		txtpnSearchLable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnSearchLable.setBackground(SystemColor.menu);
		txtpnSearchLable.setForeground(Color.white);
		txtpnSearchLable.setText("History:");
		txtpnSearchLable.setBounds(633, 101, 116, 31);
		this.getContentPane().add(txtpnSearchLable);

		txtpnFastsearch = new JLabel();
		txtpnFastsearch.setForeground(Color.WHITE);
		txtpnFastsearch.setFont(new Font("Tahoma", Font.ROMAN_BASELINE, 60));
		txtpnFastsearch.setText("FastSearch");
		txtpnFastsearch.setBackground(SystemColor.menu);
		txtpnFastsearch.setBounds(70, 40, 300, 73);
		this.getContentPane().add(txtpnFastsearch);


		clear = new JButton("clear");
		clear.setBounds(466, 143, 89, 31);
		this.getContentPane().add(clear);


		delete = new JButton("Delete");
		delete.setBounds(608, 450, 89, 23);
		this.getContentPane().add(delete);


		DeleteAll = new JButton("DeleteAll");
		DeleteAll.setBounds(707, 450, 89, 23);
		this.getContentPane().add(DeleteAll);

		Naive = new JRadioButton("Naive");
		Naive.setForeground(Color.white);
		Naive.setToolTipText("");
		Naive.setBounds(51, 179, 65, 23);
		Naive.setContentAreaFilled(false);
		this.getContentPane().add(Naive);

		Kmp = new JRadioButton("KMP");
		Kmp.setForeground(Color.white);
		Kmp.setBounds(118, 179, 65, 23);
		Kmp.setContentAreaFilled(false);
		this.getContentPane().add(Kmp);

		RabinKarp = new JRadioButton("Rabin Karp");
		RabinKarp.setForeground(Color.white);
		RabinKarp.setBounds(185, 179, 90, 23);
		RabinKarp.setContentAreaFilled(false);
		this.getContentPane().add(RabinKarp);


		G1 = new ButtonGroup();
		G1.add(getNaive());
		G1.add(getKmp());
		G1.add(getRabinKarp());

		operatioTime = new JLabel("");
		operatioTime.setBounds(350, 174, 300, 31);
		operatioTime.setForeground(Color.white);
		this.getContentPane().add(operatioTime);


		DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("History");
		tree = new HistoryTree(root1);
		tree.setBounds(619, 138, 162, 297);
		this.getContentPane().add(tree);



		clear.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		search.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		SearchField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		clear.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		delete.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		DeleteAll.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
		searchList.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
		tree.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));

		backGroundImg = new ImageIcon("src/com/hit/view/resources/bg.jpeg");
		backGround = new JLabel(backGroundImg);
		backGround.setBounds(0, 0, 816, 523);
		backGround.setVisible(true);
		add(backGround);

		clear.addActionListener(listener);
		search.addActionListener(listener);
		SearchField.addActionListener(listener);
		clear.addActionListener(listener);
		delete.addActionListener(listener);
		DeleteAll.addActionListener(listener);
		searchList.addListSelectionListener(listener);



		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		this.setVisible(true);


	}

	public JFrame getFrame() {
		return this;
	}

	public void clear() {
		SearchField.setText("");
	}

	public Observable getListener() {
		return this.listener;
	}
	public JTextField getSearchField() {
		return SearchField;
	}

	public JButton getSearch() {
		return search;
	}
	public void SetOperationTime(long time)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Operation completed within - ");
		stringBuilder.append(time);
		stringBuilder.append("ms");
		operatioTime.setText(stringBuilder.toString());
	}
	public JList getSearchList() {
		return searchList;
	}

	public JLabel getTxtpnSearchLable() {
		return txtpnSearchLable;
	}

	public JLabel getJlabelTitle() {
		return txtpnFastsearch;
	}

	public JButton getClear() {
		return clear;
	}

	public JTextPane getTxtpnEnterText() {
		return txtpnEnterText;
	}

	public JButton getDelete() {
		return delete;
	}

	public HistoryTree GetHistoryTree() {
		return b;
	}

	public JButton getDeleteAll() {
		return DeleteAll;
	}

	public JRadioButton getNaive() {
		return Naive;
	}

	public JRadioButton getKmp() {
		return Kmp;
	}

	public JRadioButton getRabinKarp() {
		return RabinKarp;
	}

	public JTextPane getTxtpnChoseaAlgo() {
		return txtpnChoseaAlgo;
	}

	public ButtonGroup getG1() { return G1; }

	public HistoryTree getTree() {
		return tree;
	}
	public void UpdateUIData(Response response,long TimeToComplete) {
		if(!response.success)
		{
			JOptionPane.showMessageDialog(this,"Failed to preform search operation", "Failed", 0);
			return;

		}
		if(!(response.arr==null)&&!response.arr.isEmpty())
		{
			addToJList(searchList, response.arr);
			SetOperationTime(TimeToComplete);
		}
		else{
			JOptionPane.showMessageDialog(this,"There is no items with this keyword", "Pay attention", 2);

		}
	}

	public void addToJList(JList<searchItem> l1, ArrayList<searchItem> arr) {
		DefaultListModel<searchItem> ListModel = new DefaultListModel<searchItem>();
		for (var item : arr) {
			System.out.println(item.getTag());
			ListModel.addElement(item);
		}
		l1.setModel(ListModel);
	}


}
