package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Calculator extends JFrame{
	
	GUI obj;
	public Calculator()
	{
		obj = new GUI();
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300,400));
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		add(obj,BorderLayout.CENTER);
		obj.createGUI();
		pack();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator obj = new Calculator();
	}

}
