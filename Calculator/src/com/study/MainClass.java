package com.study.Caculator;

/**
 *  -*- coding: UTF-8 -*-
 *  @ Date   : 2019/5/20 13:14
 *  @ Author : Richard_lau
 *  @ file   : Richard.java
 *  @ IDE    : Eclipse
 */

public class MainClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		CalUI obj = new CalUI();
//		CalUI_two obj = new CalUI_two();
//		obj.setBounds(700, 290, 190, 250);  // 设置窗口界限
//		obj.setVisible(true);  // 设置窗口是否可见（可视化）
		
		CalUI__V1_0 cal_1 = new CalUI__V1_0();  // V1.0：实现基本的加减乘除（四则）运算功能
		cal_1.setBounds(700, 290, 190, 250);
		cal_1.setVisible(true);  // 设置窗口是否可见（可视化）
	}

}
