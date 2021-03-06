import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.ArrayList;
//required for file IO
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class lab6exe3 extends JPanel implements ActionListener{
    private JLabel jcomp1;
    private JLabel jcomp2;
    private JButton btnAdd;
    private JTextArea jt1;
    private JComboBox jcb;
    private JButton btnOrder;
    private static Cake cake;
    private static ArrayList<String> order;
   
    String output = " ";
    String path = "CakeMenu.txt";
    private boolean append_to_file = false;

    public lab6exe3() {
        //construct preComponents
        String[] jcbItems = {"[Select]"};

        //construct components
        jcomp1 = new JLabel ("Cake Menu");
        jcomp2 = new JLabel ("Toppings Selection");
        btnAdd = new JButton ("Add Topping");
        jt1 = new JTextArea (5, 5);
        JScrollPane jt1_sp = new JScrollPane(jt1);
        jcb = new JComboBox (jcbItems);
        btnOrder = new JButton ("Order");
        
        btnAdd.addActionListener(this);
        btnOrder.addActionListener(this);

        //adjust size and set layout
        setPreferredSize (new Dimension (514, 325));
        setLayout (null);

        //add components
        add (jcomp1);
        add (jcomp2);
        add (btnAdd);
        add (jt1_sp);
        add (jcb);
        add (btnOrder);

        //set component bounds (only needed by Absolute Positioning)
        jcomp1.setBounds (195, 10, 115, 25);
        jcomp2.setBounds (25, 55, 125, 25);
        btnAdd.setBounds (365, 55, 125, 25);
        jt1_sp.setBounds (25, 120, 465, 180);
        jcb.setBounds (180, 55, 180, 25);
        btnOrder.setBounds (365, 90, 125, 25);
    }
    
   public void actionPerformed(ActionEvent ae){
      String command = ae.getActionCommand(); 
      
      if(command.equals("Add Topping")){
         order.add(jcb.getSelectedItem().toString());      
         jt1.append(jcb.getSelectedItem().toString() + "\n");   
      }
      else if(command.equals("Order")){
         //convert Arraylist to String array
         // declaration and initialise String Array 
         String str_order[] = new String[order.size()]; 
  
         // ArrayList to Array Conversion 
         for (int j = 0; j < order.size(); j++) { 
            // Assign each value to String array 
            str_order[j] = order.get(j); 
         }
         cake.cakeOrder(str_order, 1, 2);
         String txt = cake.printOrder_GUI();
         jt1.append(txt);
         output = cake.printOrder_GUI();
         
         //save to text file  
         try{           
            FileWriter write = new FileWriter("CakeMenu.txt", true);
            PrintWriter print_line = new PrintWriter(write);
            print_line.println(output);
            print_line.close();
            JOptionPane.showMessageDialog(null, "Your order is saved");
         }
         catch(IOException e){
            JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.");
         }
      }          
   }
       
   public void updateCB(String[] topping){
      for(int i=0; i<topping.length; i++){
         jcb.addItem(topping[i]);
      }      
   }  

   public static void main (String[] args) {
      cake = new Cake("Generic");
      order = new ArrayList<String>();
      
      JFrame frame = new JFrame ("CAKE ORDERING SYSTEM");
      String[] topping = {"LAVA CHOCOLATE", "CREAM CHEESE", "BUTTER CREAM", "FONDANT"};
      cake.setCake(topping, 45.00, 65.00, 80.00); 
      
      lab6exe3 capp = new lab6exe3(); 
      capp.updateCB(topping);
              
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add (capp);
      frame.pack();
      frame.setVisible (true);
   }
}