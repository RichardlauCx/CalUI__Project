package com.study.Caculator;

/**
 *  -*- coding: UTF-8 -*-
 *  @ Date   : 2019/5/20 13:14
 *  @ Author : Richard_lau
 *  @ file   : Richard.java
 *  @ IDE    : Eclipse
 */

public class Readme 
{
	public Readme() 
	{
		// TODO Auto-generated constructor stub
	
	/**
	 * **计算器GUI实现** *
	 * 待完成（TODO）：
	 * 1. 实现数据回删按钮功能；accomplish
	 * 2. 实现小数输出数据；  accomplish
	 * 3. 实现小数输入（实现小数点功能）；
	 * 4. 实现除加减乘除之外科学计算器功能，慢慢的使用eval()函数来实现复杂算式；
	 * 5. 实现图形界面开启此计算器（通过目录索引）；
	 * 6. 实现加入括号之后，结合数据结构的优先级顺序运算;
	 * 7. 当各种数据异常或溢出时，可实现友好界面回馈；
	 * 8. 添加键盘监听事件，实现键盘输入
	 * 
	 *BUG:
	 * 1. 每次运算完还会显示原相加过程数据（s字符串拼接过程）；		解决---> s = String.valueOf(sum);	textResult.setText(s);
	 * 2. 清零后（C），存在下一个数据前多一个"0"的字符拼接；		解决---> s = "";		textResult.setText(s);
	 * 3. 符号每次多点击都会赘余到文本框后面；		解决--> 添加判断（标志）变量（operand)
	 * 4. 若前面有两个数有0（一个或两个）的话，数据会出错； 		解决---> if(num[i] == 0) 	textResult.setText("0");
	 * 5. 操作多了运算符会失效，找根源；		解决---> if (String.valueOf(oper[0]).equals("+")) 
	 * 6. 运算体验后 eg：(1/3)，得到0.0 再输入1数值，运算就变错
	 * 7. 删除操作中，如果输入数据不止一位数，删除时就会出错（目前只考虑到了上一次输入为一位数的删除）
	 * 8. 删除数据前一位也是数字的操作时，如果输入数据不止一位数，删除时就会出错
	 * 
	 * 过程记录：
	 * 1. num[i] = num[i] * 10 + 5;  适用于大多数，
	 * 	  num[i] *= 10 + 5;  // 实践证明可以这样操作，但是当被赋值数为0时则不成立；
	 * 
	 * Version：
	 * V1.0：实现基本的加减乘除（四则）运算功能，以及全部数据清除；
	 * V2.0：实现回删以及当次视图数据清除，正负号功能；
	 * 
	 * Extend：
	 * 	Romance：
	 * 		1. 250 * 2 + 38 - 17.8686（17）
	 */
		
	}
}
