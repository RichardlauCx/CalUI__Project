package com.study.Caculator;

/**
 *  -*- coding: UTF-8 -*-
 *  @ Date   : 2019/5/20 13:14
 *  @ Author : Richard_lau
 *  @ file   : Richard.java
 *  @ IDE    : Eclipse
 */

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalUI__V2_0 extends JDialog {
	/**
	 *	������ʹ��eval()������ʵ�ָ�����ʽ
	 * 
	 */
	private boolean operand = true;  //  operand �����������== falseΪ֮ǰ�޲�������== trueΪ֮ǰ�в�������Ĭ�Ͻ�ֹ�������������
	private boolean point = false;  // point �����Ƿ���С���㣬trueΪ�ǣ�falseΪ��
//	double
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textResult;
	private int number1 = 1;
	private int number2 = 2;
	private String lastOp = "";  
	
	private String s = "";  // ��ʾ��ʽ 
	private double[] num = new double[100]; // �洢��������
	private char[] oper = new char[100];  // ���������
	private int i = 0;  // �����������ݺ�������Ǹ��������
	private int calc = 0; // ������ʱ����ռ�������ݿռ�
	private double sum = 0; // ������
	
	public CalUI__V2_0() {
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnOption.add(mntmExit);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		textResult = new JTextField();
		textResult.setFont(new Font("Arial", Font.PLAIN, 14));
		textResult.setEditable(false);
		textResult.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textResult);
		textResult.setColumns(10);
		
//		textField = new JTextField();
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		JButton btnOpPlus = new JButton("+");
		btnOpPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (operand == false)
				{
					s = s + "+";
					textResult.setText(s);  // ���ı�������ʾ��Ӧ����������
					oper[i] = '+';
					operand = true;
					i++;
				}
			}
		});		
		
		
		JButton btnDelete = new JButton("Del");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String substitute = s;
				try 
				{
					s = s.substring(0, s.length()-1);
					textResult.setText(s);
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2 + "\nAll data has been deleted, please re-enter");
				}
				
				if (substitute.substring(substitute.length()-1) == String.valueOf(oper[i-1]))
				{  // �ж�ɾ���Ƿ�Ϊ������
					i--;
					operand = false;
				}
				
				else 
				{  // �����ж�ɾ��Ϊ����
					num[i] = 0;  // ��ս�����������
					operand = true;
					// TODO ������������ݲ�ֹһλ����ɾ��ʱ�ͻ����
				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 0;
		panel_1.add(btnDelete, gbc_btnDelete);
		
		
		JButton btnClearE = new JButton("CE");
		btnClearE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnClearE = new GridBagConstraints();
		gbc_btnClearE.insets = new Insets(0, 0, 5, 5);
		gbc_btnClearE.gridx = 0;
		gbc_btnClearE.gridy = 0;
		panel_1.add(btnClearE, gbc_btnClearE);
		
		
		JButton btnSymbol = new JButton("+/-");
		btnSymbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnSymbol = new GridBagConstraints();
		gbc_btnSymbol.insets = new Insets(0, 0, 5, 5);
		gbc_btnSymbol.gridx = 1;
		gbc_btnSymbol.gridy = 0;
		panel_1.add(btnSymbol, gbc_btnSymbol);
		
		GridBagConstraints gbc_btnOpPlus = new GridBagConstraints();  // ����������Լ��
		gbc_btnOpPlus.insets = new Insets(0, 0, 5, 0);
		
//		btnOpPlus.setBounds(236, 200, 60, 95);  // ���ð�ť�߽緶Χ
//		frame.getContentPane().add(btnOpPlus);  // �����ݴ�������Ӱ�ť
		
		gbc_btnOpPlus.gridx = 3;
		gbc_btnOpPlus.gridy = 0;
		panel_1.add(btnOpPlus, gbc_btnOpPlus);
		
		
		JButton btnOpMinus = new JButton("-");
		btnOpMinus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (operand == false)
				{
					s += "-";
					textResult.setText(s);
					oper[i] = '-';
					operand = true;
					i++;
				}
			}
		});
		
		
		JButton btnNum3 = new JButton("3");
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = s + "3";
				textResult.setText(s);
				num[i] = num[i] * 10 + 3;
				operand = false;
			}
		});
		
		
		JButton btnNum2 = new JButton("2");
		btnNum2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				s = s + "2";
				textResult.setText(s);
				num[i] = num[i] * 10 + 2;
				operand = false;
			}
		});
		
		JButton btnNum1 = new JButton("1");
		btnNum1.addActionListener(new ActionListener() { 
			/**
			 * ��Ӵ˰�ť��ص���Ӧ����Ϊ������
			 */
			public void actionPerformed(ActionEvent e) 
			/**
			 * �������ִ�е���Ϊ
			 */
			{
				s = s + "1";
				textResult.setText(s);
				num[i] = num[i] * 10 + 1;
				operand = false;
				
			}
		});
		GridBagConstraints gbc_btnNum1 = new GridBagConstraints();  // �����װ��Լ����ʽ
		gbc_btnNum1.insets = new Insets(0, 0, 5, 5);  // ����ߴ��С
		//		btnNum1.setBounds(14, 308, 60, 41);  // ���ý��޷�Χ
		//		frame.getContentPane().add(btnNum1);  // ������ݴ�����ӵ���������
				gbc_btnNum1.gridx = 0;
				gbc_btnNum1.gridy = 1;
				panel_1.add(btnNum1, gbc_btnNum1);
		GridBagConstraints gbc_btnNum2 = new GridBagConstraints();
		gbc_btnNum2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum2.gridx = 1;
		gbc_btnNum2.gridy = 1;
		panel_1.add(btnNum2, gbc_btnNum2);
		GridBagConstraints gbc_btnNum3 = new GridBagConstraints();
		gbc_btnNum3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum3.gridx = 2;
		gbc_btnNum3.gridy = 1;
		panel_1.add(btnNum3, gbc_btnNum3);
		GridBagConstraints gbc_btnOpMinus = new GridBagConstraints();
		gbc_btnOpMinus.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpMinus.gridx = 3;
		gbc_btnOpMinus.gridy = 1;
		panel_1.add(btnOpMinus, gbc_btnOpMinus);
		
		
		JButton btnOpDivide = new JButton("/");
		btnOpDivide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (operand == false)
				{
					s += "/";
					textResult.setText(s);
					oper[i] = '/';
					operand = true;
					i++;
				}
			}
		});
		
		
		JButton btnNum9 = new JButton("9");
		btnNum9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s += "9";
				textResult.setText(s);
				num[i] = num[i] * 10 + 9;
				operand = false;
			}
		});
		
		
		JButton btnNum8 = new JButton("8");
		btnNum8.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s += "8";
				textResult.setText(s);
				num[i] = num[i] * 10 + 8;
				operand = false;
			}
		});
		
		
		JButton btnNum7 = new JButton("7");
		btnNum7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s += "7";
				textResult.setText(s);
				num[i] = num[i] *  10 + 7;
				operand = false;
			}
		});
		
		
		JButton btnNum6 = new JButton("6");
		btnNum6.addActionListener(new ActionListener() {
			
			@Override  // ���������¸���
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s += "6";
				textResult.setText(s);
				num[i] = num[i] * 10 + 6;
				operand = false;
			}
		});
		
		
		JButton btnNum5 = new JButton("5");
		btnNum5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s += "5";
				textResult.setText(s);  // textResult ��ʵ���ı���TextField����ʵ��������
				num[i] = num[i] * 10 + 5;  
				operand = false;
//				num[i] *= 10 + 5;  // ʵ��֤�������������������ǵ�����ֵ��Ϊ0ʱ������
			}
		});
		
		
		JButton btnNum4 = new JButton("4");
		btnNum4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s = s + "4";
				textResult.setText(s);
				num[i] = num[i] * 10 + 4;
				operand = false;
			}
		});
		GridBagConstraints gbc_btnNum4 = new GridBagConstraints();  // ʵ�����������Լ������
		gbc_btnNum4.insets = new Insets(0, 0, 5, 5);  // ����λ�ü��ߴ�����
		gbc_btnNum4.gridx = 0;  // �����������Ϊgridx
		gbc_btnNum4.gridy = 2;  // ������������Ϊgridy
		panel_1.add(btnNum4, gbc_btnNum4);
		GridBagConstraints gbc_btnNum5 = new GridBagConstraints();
		gbc_btnNum5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum5.gridx = 1;
		gbc_btnNum5.gridy = 2;
		panel_1.add(btnNum5, gbc_btnNum5);
		GridBagConstraints gbc_btnNum6 = new GridBagConstraints();
		gbc_btnNum6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum6.gridx = 2;
		gbc_btnNum6.gridy = 2;
		panel_1.add(btnNum6, gbc_btnNum6);
		GridBagConstraints gbc_btnNum7 = new GridBagConstraints();
		gbc_btnNum7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum7.gridx = 0;
		gbc_btnNum7.gridy = 3;
		panel_1.add(btnNum7, gbc_btnNum7);
		GridBagConstraints gbc_btnNum8 = new GridBagConstraints();
		gbc_btnNum8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum8.gridx = 1;
		gbc_btnNum8.gridy = 3;
		panel_1.add(btnNum8, gbc_btnNum8);
		GridBagConstraints gbc_btnNum9 = new GridBagConstraints();
		gbc_btnNum9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum9.gridx = 2;
		gbc_btnNum9.gridy = 3;
		panel_1.add(btnNum9, gbc_btnNum9);
		GridBagConstraints gbc_btnOpDivide = new GridBagConstraints();
		gbc_btnOpDivide.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpDivide.gridx = 3;
		gbc_btnOpDivide.gridy = 3;
		panel_1.add(btnOpDivide, gbc_btnOpDivide);
		
		
		JButton btnOpMultiple = new JButton("*");
		btnOpMultiple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (operand == false)
				{
					s += "*";
					textResult.setText(s);
					oper[i] = '*';
					operand = true;
					i++;
				}
			}
		});
		GridBagConstraints gbc_btnOpMultiple = new GridBagConstraints();
		gbc_btnOpMultiple.insets = new Insets(0, 0, 5, 0);
		gbc_btnOpMultiple.gridx = 3;
		gbc_btnOpMultiple.gridy = 2;
		panel_1.add(btnOpMultiple, gbc_btnOpMultiple);
		
		
		JButton btnClear = new JButton("c");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "";
				textResult.setText(s);
				for (calc=0; calc < 100; calc++)
				{
					num[calc] = 0;  // �����������
					oper[calc] = 0;  // ��������
				}
				
				i = 0;  // ���³�ʼ��
				calc = 0;
				sum = 0;
			}
		});
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 0, 5);
		//		btnClear.setBounds(14, 146, 60, 40);
		//		frame.getContentPane().add(btnClear);  // ��Ӱ�ť��������
				gbc_btnClear.gridx = 0;
				gbc_btnClear.gridy = 4;
				panel_1.add(btnClear, gbc_btnClear);
				
				
		JButton btnNum0 = new JButton("0");
		btnNum0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num[i] == 0)
					{
						textResult.setText("0");
					}
				else
				{
					s += "0";
					textResult.setText(s);
					num[i] *= 10;
				}
				operand = false;
			}
		});
		GridBagConstraints gbc_btnNum0 = new GridBagConstraints();
		gbc_btnNum0.insets = new Insets(0, 0, 0, 5);
		gbc_btnNum0.gridx = 1;
		gbc_btnNum0.gridy = 4;
		panel_1.add(btnNum0, gbc_btnNum0);
				
				
		JButton btnOpEqual = new JButton("=");
		btnOpEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * ��ʵ��һ�μ��㣬Ϊ�˷�����ڵ�ѭ���ˡ�������0������⣩
				 */
				if (String.valueOf(oper[0]).equals("+"))
				{
					sum = num[0] + num[1];
//					System.out.print("\n+Test:" + sum);
					}
					
					else if (String.valueOf(oper[0]).equals("-"))
					{
						sum = num[0] - num[1];
//					System.out.print("\n-Test:" + sum);
					}
					
					else if (String.valueOf(oper[0]).equals("*"))
					{
						sum = num[0] * num[1];
					}
					
					else if (String.valueOf(oper[0]).equals("/"))
					{
						sum = num[0] / num[1];
					}
					
					calc++;  // ��¼�ܼ�����
					
					for (calc=1; calc < i; calc++)
					{
						if (String.valueOf(oper[calc]).equals("+"))
						{
							sum = sum + num[calc+1];
//							System.out.print("\n+Test:" + sum);
						}
						
						else if (String.valueOf(oper[calc]).equals("-"))
						{
							sum = sum - num[calc+1];
//							System.out.print("\n-Test:" + sum);
						}
						
						else if (String.valueOf(oper[calc]).equals("*"))
						{
							sum *= num[calc+1];
						}
						
						else if (String.valueOf(oper[calc]).equals("/"))
						{
							sum /= num[calc+1];
						}
					}
					
					s = String.valueOf(sum);
					textResult.setText(s);
				}
			});
			
			JButton btnPoint = new JButton(".");
			btnPoint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			GridBagConstraints gbc_btnPoint = new GridBagConstraints();
			gbc_btnPoint.insets = new Insets(0, 0, 0, 5);
			gbc_btnPoint.gridx = 2;
			gbc_btnPoint.gridy = 4;
			panel_1.add(btnPoint, gbc_btnPoint);
			GridBagConstraints gbc_btnOpEqual = new GridBagConstraints();
			//		btnOpEqual.setBounds(236, 308, 60, 95);
			//		frame.getContentPane().add(btnOpEqual);  // �����ڰ�ť��ӵ����ݴ�����  
					gbc_btnOpEqual.gridx = 3;
					gbc_btnOpEqual.gridy = 4;
					panel_1.add(btnOpEqual, gbc_btnOpEqual);
//		private void compute()
//		{
//			
//		}
	}

}
