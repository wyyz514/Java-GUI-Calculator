package calculator;

import javax.swing.JTextField;

public class Logic {
	
	public void backSpace(JTextField field)
	{	
		//backspace is basically dividing by ten and ignoring the remainder
		int currentNumber;
		if(field.getText().equals(""))
		{
			field.setText("0");
		}
		//appends new number to field
		currentNumber = Integer.parseInt(field.getText());
		int newNumber = currentNumber / 10;
		String newText = Integer.toString(newNumber);
		field.setText(newText);
	}
	
	//selects operation and calls relevant method
	public void solve(int firstNumber,int secondNumber,String operation,JTextField field)
	{
		switch(operation)
		{
		case "+":
			addition(firstNumber,secondNumber,field);
			break;
		case "-":
			subtraction(firstNumber,secondNumber,field);
			break;
		}
	}
	private void addition(int firstNumber, int secondNumber,JTextField field)
	{
		int sum = firstNumber + secondNumber;
		String result = new Integer(sum).toString();
		field.setText(result);
	}
	private void subtraction(int firstNumber, int secondNumber, JTextField field)
	{
		int difference = firstNumber - secondNumber;
		String result = new Integer(difference).toString();
		field.setText(result);
	}
}
