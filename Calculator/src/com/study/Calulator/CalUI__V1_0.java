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

public class CalUI__V1_0 extends JDialog {
	/**
	 *	V1.0：实现基本的加减乘除（四则）运算功能
	 * 
	 */
	private boolean operand = true;  //  operand 代表操作数，== false为之前无操作数，== true为之前有操作数，默认禁止输入运算操作符
	private boolean point = false;  // point 代表是否有小数点，true为是，false为否
//	double
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textResult;
	private int number1 = 1;
	private int number2 = 2;
	private String lastOp = "";  
	
	private String s = "";  // 显示算式 
	private double[] num = new double[100]; // 存储运算数据
	private char[] oper = new char[100];  // 储存运算符
	private int i = 0;  // 输入运算数据和运算符是给数组计数
	private int calc = 0; // 计算结果时计数占多少数据空间
	private double sum = 0; // 计算结果
	
	public CalUI__V1_0() {
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
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNum1 = new JButton("1");
		btnNum1.addActionListener(new ActionListener() { 
			/**
			 * 添加此按钮相关的响应（行为监听）
			 */
			public void actionPerformed(ActionEvent e) 
			/**
			 * 添加所需执行的行为
			 */
			{
				s = s + "1";
				textResult.setText(s);
				num[i] = num[i] * 10 + 1;
				operand = false;
				
			}
		});
		GridBagConstraints gbc_btnNum1 = new GridBagConstraints();  // 网格包装的约束形式
		gbc_btnNum1.insets = new Insets(0, 0, 5, 5);  // 插入尺寸大小
		gbc_btnNum1.gridx = 0;
		gbc_btnNum1.gridy = 0;
		panel_1.add(btnNum1, gbc_btnNum1);
		
		
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
		GridBagConstraints gbc_btnNum2 = new GridBagConstraints();
		gbc_btnNum2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum2.gridx = 1;
		gbc_btnNum2.gridy = 0;
		panel_1.add(btnNum2, gbc_btnNum2);
		
		
		JButton btnNum3 = new JButton("3");
		btnNum3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = s + "3";
				textResult.setText(s);
				num[i] = num[i] * 10 + 3;
				operand = false;
			}
		});
		GridBagConstraints gbc_btnNum3 = new GridBagConstraints();
		gbc_btnNum3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum3.gridx = 2;
		gbc_btnNum3.gridy = 0;
		panel_1.add(btnNum3, gbc_btnNum3);
		
		
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
		GridBagConstraints gbc_btnNum4 = new GridBagConstraints();  // 实例化网格包裹约束对象
		gbc_btnNum4.insets = new Insets(0, 0, 5, 5);  // 插入位置及尺寸设置
		gbc_btnNum4.gridx = 0;  // 网格横向坐标为gridx
		gbc_btnNum4.gridy = 1;  // 网格纵向坐标为gridy
		panel_1.add(btnNum4, gbc_btnNum4);
		
		
		JButton btnNum5 = new JButton("5");
		btnNum5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s += "5";
				textResult.setText(s);  // textResult 其实是文本框（TextField）的实例化对象
				num[i] = num[i] * 10 + 5;  
				operand = false;
			}
		});
		GridBagConstraints gbc_btnNum5 = new GridBagConstraints();
		gbc_btnNum5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum5.gridx = 1;
		gbc_btnNum5.gridy = 1;
		panel_1.add(btnNum5, gbc_btnNum5);
		
		
		JButton btnNum6 = new JButton("6");
		btnNum6.addActionListener(new ActionListener() {
			
			@Override  // 方法的重新覆盖
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s += "6";
				textResult.setText(s);
				num[i] = num[i] * 10 + 6;
				operand = false;
			}
		});
		GridBagConstraints gbc_btnNum6 = new GridBagConstraints();
		gbc_btnNum6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum6.gridx = 2;
		gbc_btnNum6.gridy = 1;
		panel_1.add(btnNum6, gbc_btnNum6);
		
		
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
		GridBagConstraints gbc_btnNum7 = new GridBagConstraints();
		gbc_btnNum7.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum7.gridx = 0;
		gbc_btnNum7.gridy = 2;
		panel_1.add(btnNum7, gbc_btnNum7);
		
		
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
		GridBagConstraints gbc_btnNum8 = new GridBagConstraints();
		gbc_btnNum8.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum8.gridx = 1;
		gbc_btnNum8.gridy = 2;
		panel_1.add(btnNum8, gbc_btnNum8);
		
		
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
		GridBagConstraints gbc_btnNum9 = new GridBagConstraints();
		gbc_btnNum9.insets = new Insets(0, 0, 5, 5);
		gbc_btnNum9.gridx = 2;
		gbc_btnNum9.gridy = 2;
		panel_1.add(btnNum9, gbc_btnNum9);
		
		
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
		gbc_btnNum0.gridy = 3;
		panel_1.add(btnNum0, gbc_btnNum0);
		
		
		JButton btnOpEqual = new JButton("=");
		btnOpEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 先实现一次计算，为了方便后期的循环乘、除（与0相关问题）
				 */
				if (String.valueOf(oper[0]).equals("+"))
				{
					sum = num[0] + num[1];
				}
				
				else if (String.valueOf(oper[0]).equals("-"))
				{
					sum = num[0] - num[1];
				}
				
				else if (String.valueOf(oper[0]).equals("*"))
				{
					sum = num[0] * num[1];
				}
				
				else if (String.valueOf(oper[0]).equals("/"))
				{
					sum = num[0] / num[1];
				}
				
				calc++;  // 记录总计算数
				
				for (calc=1; calc < i; calc++)
				{
					if (String.valueOf(oper[calc]).equals("+"))
					{
						sum = sum + num[calc+1];
					}
					
					else if (String.valueOf(oper[calc]).equals("-"))
					{
						sum = sum - num[calc+1];
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
		GridBagConstraints gbc_btnOpEqual = new GridBagConstraints();
		gbc_btnOpEqual.insets = new Insets(0, 0, 0, 5);
		gbc_btnOpEqual.gridx = 2;
		gbc_btnOpEqual.gridy = 3;
		panel_1.add(btnOpEqual, gbc_btnOpEqual);
		
		
		JButton btnOpPlus = new JButton("+");
		btnOpPlus.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (operand == false)
				{
					s = s + "+";
					textResult.setText(s);  // 在文本框中显示相应的运算内容
					oper[i] = '+';
					operand = true;
					i++;
				}
			}
		});		
		GridBagConstraints gbc_btnOpPlus = new GridBagConstraints();  // 添加网格包裹约束
		gbc_btnOpPlus.insets = new Insets(0, 0, 5, 0);
		
		
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
		GridBagConstraints gbc_btnOpDivide = new GridBagConstraints();
		gbc_btnOpDivide.gridx = 3;
		gbc_btnOpDivide.gridy = 3;
		panel_1.add(btnOpDivide, gbc_btnOpDivide);
		
		
		JButton btnClear = new JButton("c");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s = "";
				textResult.setText(s);
				for (calc=0; calc < 100; calc++)
				{
					num[calc] = 0;  // 清空运算数据
					oper[calc] = 0;  // 清空运算符
				}
				
				i = 0;  // 重新初始化
				calc = 0;
				sum = 0;
			}
		});
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.insets = new Insets(0, 0, 0, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 3;
		panel_1.add(btnClear, gbc_btnClear);
		
		
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
	}

}
