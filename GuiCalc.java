/**
 * Calculator Program using Gui
 * @author(Sneha Mandala)
 * @version(31/08/2021
 */
import java.util.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; //Packages for Gui 
// Name of the class
public class GuiCalc extends JFrame implements ActionListener {
    JTextField Display; // Global variables for GuiCalc
    JButton[] Buttons;
    JButton BackSpace;
    JButton Clear;
    JButton OpenBrack;
    JButton CloseBrack;
    JButton Factu;
    JButton Off;
    JButton Calcu;
    double Result;
    String PostFix="";
    String[] ButtonNames = {"1","2","3","+","4","5","6","-","7","8","9","*","+/-","0",".","/"};
    String[] ButtonCommands = {"CMD_1","CMD_2","CMD_3","CMD_ADD","CMD_4","CMD_5",
        "CMD_6","CMD_SUB","CMD_7","CMD_8","CMD_9","CMD_MULTI","CMD_POSNEG","CMD_0","CMD_DOT","CMD_DIV","CMD_FAC"};
        // Array of string which has button names / commands
    /**
    /**
     * Constructor for objects of class GuiCalc 
     */
    public GuiCalc(){
        // initialises when the constructor is called
        super("Calculator in GUI ");//Container/ Window display msg
        setSize(450,350);
        CreateCalcGUI(); // Method  to set up Gui
    }

    /**
     * Method to set up GuiCalc
    */
    private void CreateCalcGUI() {
        //Creating Panel for the gui ,adding colors,components and creating object  
        JPanel panelTop = new JPanel();//local variable and creating an object fot it
        panelTop.setBackground(Color.gray);
        GridLayout panelTopLayout = new GridLayout(0,1);
        panelTop.setLayout(panelTopLayout);
    
        JPanel panelCenter = new JPanel();
        //Creating Gridlayout and object
        GridLayout panelCenterLayout = new GridLayout(4,4);
        panelCenterLayout.setHgap(10);
        panelCenterLayout.setVgap(10);
        panelCenter.setLayout(panelCenterLayout);   
        
        JPanel panelRight = new JPanel();
        
        GridLayout panelRightLayout = new GridLayout(4,1);
        panelRightLayout.setHgap(10);
        panelRightLayout.setVgap(10);
        panelRight.setLayout(panelRightLayout);   
        
        JPanel panelBottom = new JPanel();
        FlowLayout bottomLayout = new FlowLayout();
        bottomLayout.setHgap(3);
        bottomLayout.setVgap(3);
        bottomLayout.setAlignment(FlowLayout.LEADING);
        panelBottom.setLayout(bottomLayout);
        
        
        // Creating Borderlayout and object 
        BorderLayout mainLayout = new BorderLayout();
        setLayout(mainLayout);
        add(panelTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelRight, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);
        //creating Displayayout , object of type jtext field 
        Display = new JTextField("0");        
        Font displayFont = new Font("SansSerif", Font.BOLD, 24);
        Display.setFont(displayFont);
        Display.setHorizontalAlignment(JTextField.RIGHT);        
        Display.setPreferredSize(new Dimension(100,35));
        panelTop.add(Display);//method to add display attributes to panelTop
        //creating buttons for container
        Buttons = new JButton[16];
        for (int i = 0; i < Buttons.length; i++) { //to check number of buttons
            Buttons[i] = new JButton();
            Buttons[i].setPreferredSize(new Dimension(50, 50));
            Buttons[i].setText(ButtonNames[i]);
            Buttons[i].setActionCommand(ButtonCommands[i]);
            Buttons[i].addActionListener(this);
            panelCenter.add(Buttons[i]);
        }
        //creating buttons for container
        BackSpace = new JButton("<<");
        BackSpace.setPreferredSize(new Dimension(150, 100));
        BackSpace.addActionListener(this);
        BackSpace.setActionCommand("CMD_BSP");
        panelRight.add(BackSpace);//method to add << button attributes to panelRight
        
        //creating buttons for container
        Clear = new JButton("C");
        Clear.addActionListener(this);
        Clear.setActionCommand("CMD_C");
        panelRight.add(Clear);//method to add attributes for clear button to panelRight
        
        //creating buttons for container
        OpenBrack = new JButton("(");
        OpenBrack.addActionListener(this);
        OpenBrack.setActionCommand("CMD_OP");
        panelRight.add(OpenBrack);//method to add openBrack attributes to panelRight
        
        //creating buttons for container
        CloseBrack = new JButton(")");
        CloseBrack.addActionListener(this);
        CloseBrack.setActionCommand("CMD_CL");
        panelRight.add(CloseBrack);//method to add closeBrack attributes to panelRight
        
        Calcu = new JButton("=");//Creating button in bottom panel
        Calcu.setPreferredSize(new Dimension(220,50));
        Calcu.addActionListener(this);
        Calcu.setActionCommand("CMD_CAL");
        panelBottom.add(Calcu);//method to add = button  attributes to panelRight
        
        Factu = new JButton("!");//Creating factorial button in bottom panel of GuiCalc
        Factu.setPreferredSize(new Dimension(70,50));
        Factu.addActionListener(this);
        Factu.setActionCommand("CMD_FAC");
        panelBottom.add(Factu);//method to add +/- button attributes to panelBottom
        
        Off = new JButton("OFF");//creating off button to the bottom panel of GuiCalc
        Off.setPreferredSize(new Dimension(135,50));
        Off.addActionListener(this);
        Off.setActionCommand("CMD_OFF");
        Off.setForeground (Color. RED);//(new Color(255,143,143));
        Off.setOpaque(true);      
        panelBottom.add(Off);//method to add off button attributes to panelBottom
    }
    /**
    * method for taking user input ,appends it to display text, then calculates the given text based on the user given operation ,then displays the result as text.
    * */
    public void actionPerformed(ActionEvent e) {
        String displayText;//local variable gor taking user input
        displayText = Display.getText(); //calling the get text method from display class
        String command = e.getActionCommand();//
        if (command.equals("CMD_1")) {
            displayText = displayText + "1"; // string concatination for display text
        } else
        if (command.equals("CMD_2")) {
            displayText = displayText + "2";
        } else
        if (command.equals("CMD_3")) {
            displayText = displayText + "3";
        } else
        if (command.equals("CMD_4")) {
            displayText = displayText + "4";
        } else
        if (command.equals("CMD_5")) {
            displayText = displayText + "5";
        } else
        if (command.equals("CMD_6")) {
            displayText = displayText + "6";
        } else
        if (command.equals("CMD_7")) {
            displayText = displayText + "7";
        } else
        if (command.equals("CMD_8")) {
            displayText = displayText + "8";
        } else
        if (command.equals("CMD_9")) {
            displayText = displayText + "9";
        } else
        if (command.equals("CMD_0")) {
            displayText = displayText + "0";
        } else
        if (command.equals("CMD_DOT")) {
            displayText = displayText + ".";
        } else
        if (command.equals("CMD_C")) {
            displayText = "";//clears the display text box
            PostFix="";// Global variable of type string
            
        } else
        if (command.equals("CMD_BSP")) {
            int len = displayText.length(); //
            if(len!=0){// checks for the length nd substring method is used on the value
            displayText = displayText.substring(0, len-1);
        } 
        } else
        if (command.equals("CMD_ADD")) {
             displayText = displayText + "+"; //adds the symbnol to display text
        } else 
        if (command.equals("CMD_SUB")) {
             displayText = displayText + "-"; 
    
        } else
        if (command.equals("CMD_MULTI")) {
             displayText = displayText + "*"; 
         } else
            if (command.equals("CMD_DIV")) {
             displayText = displayText + "/"; 
        } else
            if (command.equals("CMD_POSNEG")) {
             displayText = displayText + "+/-"; 
       } else
       if (command.equals("CMD_OP")) {
             displayText = displayText + "("; 
       } else   
       if (command.equals("CMD_CL")) {
             displayText = displayText + ")"; 
       } else
       if (command.equals("CMD_CAL")) {
            calculate();//if = symbol is pressed then control goes to calculate method
       } else
              if (command.equals("CMD_FAC")) {
              factorial();//
       } else
       if (command.equals("CMD_OFF")) {
           
           System.exit(0);//exit method of system class to close GuiCalc
            
       }
        Display.setText(displayText);
        if (command.equals("CMD_CAL")) {
            calculate();
        
        }
        
    }
    /** 
     *Method to calculate the result based on input values by user, stacking
     */
    public void calculate(){
     String userInput = Display.getText();
     PostFix=convert(userInput);
     Result=evaluate(PostFix);
     String resultToShow=Double.toString(Result);
     Display.setText(resultToShow);
        
    }
     public void factorial(){
     String userInput = Display.getText();
     int fact=Integer.parseInt(userInput);
     int result=fact;
      for (int initial = fact-1; initial <= 1; initial--) {
                result = result * initial;
            }
    
     Display.setText(Integer.toString(result));
    }
    
    /**
     * method to check operator and return Integer value 
     */
    private int isOperator(char c) {
        switch (c) {
            case '+':                
            case '-':
                return 1;
            case '*':
            case '/':
            
                return 2;
        }
        return -1;
    }
    /**
     * method to take user input , stack by prioritising and return string value
     */
    public String convert(String infix) {
        Stack<Character> stack = new Stack();//data structure for the priority
        String postfix = "";
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (isOperator(c) > 0) {
               //operator
                while (!stack.isEmpty() && (isOperator(c) <= isOperator(stack.peek()))) {
                    postfix = postfix + stack.pop();
                }
                stack.push(c);
            } else 
            if (c == '(') {
                //left parenthesis
                stack.push(c);
            } else
            if (c == ')') {
                //right parenthesis
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix = postfix + stack.pop();
                }
                stack.pop(); //take out the left parenthesis from the stack
            } else {
                //operand
                postfix = postfix + c;
            }            
        }
        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop();
        }
        
        return postfix;
    }
    /**
     * Method to perform calculation based on operator ,return result in Double value
     */
    public double evaluate(String postfix) {//called from calculate method and is defined here
        Stack<Double> stack = new Stack();
        double result = 0;
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (isOperator(c) > 0) {
                double operand2 = Double.parseDouble("" + stack.pop());
                double operand1 = Double.parseDouble("" + stack.pop());
                if (c == '+') {
                    result = operand1 + operand2;
                } else
                if (c == '-') {
                    result = operand1 - operand2;
                } else
                if (c == '*') {
                    result = operand1 * operand2;
                } else
                if (c == '/') {
                    result = operand1 / operand2;
                }                
                stack.push(result);
            } else {
                //c is an operand
                stack.push(Double.parseDouble("" + c));                
            }            
        }
        
        result = stack.pop();//delete
        
        return result;// returns double value
    }
   /**
    * Main method for GuiCalc for starting the execution
    */ 
   public static void main (String[] args) {
        GuiCalc calc = new GuiCalc();// creating an object for GuiCalc
        calc.setVisible(true);//calling the method usibg GuiCalc reference by passing value as true
}
}




