package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GUI extends JPanel implements ActionListener{

	private JTextField field;
	private ArrayList<JButton>buttonList;
	private JButton zero;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton addition;
	private JButton subtraction;
	private JButton multiplication;
	private JButton division;
	private JButton equalSign;
	private JButton backspace;
	private JPanel buttonPanel;
	private JPanel calcBody;
	private Border blackLine;
	private Logic logic;
	private int firstNumber;
	private int secondNumber;
	private String operation;
	
	public GUI()
	{
		logic = new Logic();
	}
	public void createGUI()
	{
		//housekeeping
		buttonList = new ArrayList<JButton>();
		setLayout(new BorderLayout());
		blackLine = BorderFactory.createLineBorder(Color.BLACK);
		calcBody = new JPanel();
		setBorder(blackLine);
		field = new JTextField("0",10);
		field.setEditable(false); //prevent users from typing directly into the field
		field.setFont(new Font("sans-serif",Font.BOLD,25));
		field.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		//add text field to calcBody panel and place at topmost spot
		calcBody.add(field);
		add(calcBody,BorderLayout.NORTH);
		
		/*
		 Add a button:
		 instantiate it
		 add to button panel
		 add to buttonlist
		 */
		
		//grid layout makes sense for the buttons
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4,4));
		
		//first row
		seven = new JButton("7");
		buttonPanel.add(seven);
		buttonList.add(seven);
		
		eight = new JButton("8");
		buttonPanel.add(eight);
		buttonList.add(eight);
		
		nine = new JButton("9");
		buttonPanel.add(nine);
		buttonList.add(nine);
		
		backspace = new JButton("Bsp.");
		buttonPanel.add(backspace);
		buttonList.add(backspace);
		
		//second row
		four = new JButton("4");
		buttonPanel.add(four);
		buttonList.add(four);
		
		five = new JButton("5");
		buttonPanel.add(five);
		buttonList.add(five);
		
		six = new JButton("6");
		buttonPanel.add(six);
		buttonList.add(six);
		
		addition = new JButton("+");
		buttonPanel.add(addition);
		buttonList.add(addition);
		
		//third row
		one = new JButton("1");
		buttonPanel.add(one);
		buttonList.add(one);
		
		two = new JButton("2");
		buttonPanel.add(two);
		buttonList.add(two);
		
		three = new JButton("3");
		buttonPanel.add(three);
		buttonList.add(three);
		
		subtraction = new JButton("-");
		buttonPanel.add(subtraction);
		buttonList.add(subtraction);
		
		//fourth row
		zero = new JButton("0");
		buttonPanel.add(zero);
		buttonList.add(zero);
		
		division = new JButton("/");
		buttonPanel.add(division);
		buttonList.add(division);
	
		equalSign = new JButton("=");
		buttonPanel.add(equalSign);
		buttonList.add(equalSign);
		
		multiplication = new JButton("*");
		buttonPanel.add(multiplication);
		buttonList.add(multiplication);
		
		add(buttonPanel,BorderLayout.CENTER);
		addClickListeners(buttonList);
	}
	
	public void addClickListeners(ArrayList<JButton>blist)
	{
		for(JButton button : blist)
		{
			button.addActionListener(this);
		}
	}
	
	//interim event handler. Must automate. DRY
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String actionCommand = arg0.getActionCommand();
		if(actionCommand.equals("Bsp."))
		{
			logic.backSpace(field);
		}
		else
		{
			try
			{
				
				int dummyVar = Integer.parseInt(actionCommand);
				//remove zero when user starts inputing numbers
				if(field.getText().equals("0"))
				{
					field.setText("");
				}
				field.setText(field.getText().concat(actionCommand));
			}
			catch(NumberFormatException e)
			{
				if(!arg0.getActionCommand().toString().equals("="))
				{
					firstNumber = Integer.parseInt(field.getText());
					operation = arg0.getActionCommand();
					field.setText("");
					System.out.println(arg0.getActionCommand());
				}
				else
				{
					secondNumber = Integer.parseInt(field.getText());
					logic.solve(firstNumber,secondNumber,operation,field);
				}
			}
		}
	}
	
	
}

/*
must show only numbers
should not remove numbers previously there until sign is clicked.
implement backspace button
*/