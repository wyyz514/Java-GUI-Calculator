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
}
