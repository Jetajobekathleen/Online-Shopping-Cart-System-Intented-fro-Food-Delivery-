//import required classes and packages  
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

  

class CreateLoginForm extends JFrame implements ActionListener  
{  
    //initialize button, panel, label, and text field  
    JButton b1,clearButton;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;
    Font  f3;
    int totalAttempts = 0;

        //calling constructor  
    CreateLoginForm()  
    {     
          
        //create label for username  

        f3 = new Font(Font.DIALOG,  Font.BOLD, 15);   
        userLabel = new JLabel();  
        userLabel.setText("Username");     
        userLabel.setBounds(10, 70, 80, 25); 
         
        textField1 = new JTextField(15);  
        textField1.setBounds(100, 70, 185, 25);
        textField1.setHorizontalAlignment(JTextField.CENTER);
        textField1.setFont(f3);
        //create label for password  
        passLabel = new JLabel();  
        passLabel.setText("Password");      //set label value for textField2  
        passLabel.setBounds(10, 100, 80, 25);

        //create text field to get password from the user  
        textField2 = new JPasswordField(15);    //set length for the password  
        textField2.setBounds(100, 100, 185, 25);
        textField2.setHorizontalAlignment(JTextField.CENTER);
        textField2.setFont(f3);  
        //create submit button  
        b1 = new JButton("SUBMIT"); //set label to button  
        b1.setBounds(100, 150, 180, 25); 
        b1.setFont(f3);
        b1.setBackground(Color.GREEN);

        
        //create panel to put form elements  
        newPanel = new JPanel(); 
        newPanel.setLayout(null); 
        newPanel.add(userLabel);     
        newPanel.add(textField1);   
        newPanel.add(passLabel);     
        newPanel.add(textField2);     
        newPanel.add(b1);           
         
        //set border to panel   
        add(newPanel, BorderLayout.CENTER);  
          
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button  
        setTitle("My Store");         //set title to the login form  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }  
      
    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  


        String userValue = textField1.getText();    
        String passValue = textField2.getText(); 
                
        


        //check whether the credentials are authentic or not  
            if (userValue.contains("admin") && passValue.contains("admin")) 
            {   
              
            textField2.setText("");

            textField1.setText("");

            JOptionPane.showMessageDialog(null,"Welcome " + userValue + " Enjoy your Day."," Succesfully Login ",JOptionPane.PLAIN_MESSAGE);
            

            NewPage page = new NewPage();  
            page.setVisible(true);

              
            }  
            else  if (!(userValue.contains("admin") && passValue.contains("admin"))) 
            {  

                
                    
                    JOptionPane.showMessageDialog(null,"Try again"," Invalid Login ",JOptionPane.ERROR_MESSAGE);

                    textField2.setText(null);
                    textField1.setText(null);
                    textField1.grabFocus();
                    totalAttempts += 1;
                
                if (totalAttempts == 3)
                {

                    JOptionPane.showMessageDialog(null,"3 Times attempt only"," Invalid Login ",JOptionPane.ERROR_MESSAGE);
                    System.exit(0);


                }
                

                    
                   
        
        

    } 


}
}
//create the main class  
class LoginFormDemo  
{  
    //main() method start  
    public static void main(String arg[])  
    {  
        try  
        {  
            //create instance of the CreateLoginForm  
            CreateLoginForm form = new CreateLoginForm();  
            form.setSize(350,300);   
            form.setVisible(true);  
            form.setLocationRelativeTo(null);
            
        }  
        catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
}
class NewPage extends JFrame implements ActionListener  
{  
    //constructor

    JFrame f;
    JLabel c1,c2,c3,d1,d2,d3,d4;
    JLabel l1,l2,lbl,labelPic,qlbl,dtitle,x1,x2,x3,x4,x5;
    JButton b1,button1,order;
    JTextField product,quantity;
    Font  f3,f1;
    int n1;
    int amount1 = 0, amount2 = 0, amount3 = 0, delivery1 = 0, delivery2 = 0, delivery3 = 0;
    String selectedValue;
    String DeliveryOpt;
    
    String[] choices = { "Burger", "Spaghetti", "Ice Cream" };

    final JComboBox<String> cb; 
    JRadioButton rb1,rb2,rb3,rb4,rb5;   
    NewPage()  
    {  
       
       
        f = new JFrame();
        f3 = new Font(Font.DIALOG,  Font.BOLD, 20); 
        f1 = new Font(Font.DIALOG,  Font.BOLD, 15); 
        l1 = new JLabel("MENU");
        c1 = new JLabel("1 - Burger - PHP 25.00");
        c2 = new JLabel("2 - Spaghetti - PHP 20.00");
        c3 = new JLabel("3 - Ice Cream - PHP 10.00");
        l2 = new JLabel("Delivery Charge");
        d1 = new JLabel("1-2km Range - 20.00 PHP");
        d2 = new JLabel("3-4km Range - 30.00 PHP");
        d3 = new JLabel("5-6km Range - 50.00 PHP");
        d4 = new JLabel("7km Range - Not Applicable");
        dtitle = new JLabel("Discount Information");
        x1 = new JLabel("1-100 items: No Discount");
        x2 = new JLabel("101-299 items: 5% Discount");
        x3 = new JLabel("300-599 items: 15% Discount");
        x4 = new JLabel("600-999 items: 30% Discount");
        x5 = new JLabel("1000 and above items: 50% Discount");

        rb1=new JRadioButton("Pick Up");    
        rb2=new JRadioButton("1-2km");
        rb3=new JRadioButton("3-4km");    
        rb4=new JRadioButton("5-6km");
        rb5=new JRadioButton("7km - up");    
        order = new JButton("ORDER");
        b1 = new JButton("SELECT");

        lbl = new JLabel("Select your order:");
        qlbl = new JLabel("Quantity:");
        quantity = new JTextField("");
        product = new JTextField(15);
        
        labelPic = new JLabel("");
        product.setText("Burger");
       
         order.setBackground(Color.GREEN);
        l1.setFont(f3);
        l2.setFont(f3);
        dtitle.setFont(f3);
        product.setFont(f1);
        quantity.setFont(f1);

        dtitle.setBounds(300,60, 200,30);
        x1.setBounds(300,90, 250,30);   
        x2.setBounds(300,120, 250,30); 
        x3.setBounds(300,150, 250,30);
        x4.setBounds(300,180, 250,30); 
        x5.setBounds(300,210, 250,30);


        l1.setBounds(50,20, 70,30); 
        c1.setBounds(50,50, 250,30);   
        c2.setBounds(50,70, 250,30); 
        c3.setBounds(50,90, 150,30);
        l2.setBounds(50,120, 150,30);
        d1.setBounds(50,150, 250,30);   
        d2.setBounds(50,170, 250,30); 
        d3.setBounds(50,190, 250,30);
         d4.setBounds(50,210, 250,30);
        lbl.setBounds(50,230, 250,30);
        cb = new JComboBox<String>(choices);
        cb.setMaximumSize(cb.getPreferredSize());
        cb.setBounds(150,260, 250,30);
        b1.setBounds(150,290, 250,30);
        product.setBounds(150,350, 150,30);
        product.setHorizontalAlignment(JTextField.CENTER);
        qlbl.setBounds(150,380, 100,30);
        quantity.setBounds(150,410, 100,30);
        rb1.setBounds(150,440, 100,30);
        rb2.setBounds(150,465, 100,30);
        rb3.setBounds(250,440, 100,30);
        rb4.setBounds(250,465, 100,30);
        rb5.setBounds(250,495, 100,30);
        order.setBounds(150,525, 250,30);

        labelPic.setBounds(350,330, 100,100);
        
        
        labelPic.setIcon(new ImageIcon("burger.png"));

        f.add(l1);f.add(c1);f.add(c2);f.add(c3);f.add(d4);
        f.add(b1);f.add(l2);f.add(d1);f.add(d2);
        f.add(d3);f.add(lbl);f.add(cb);f.add(product);f.add(labelPic);
        f.add(qlbl);f.add(quantity);
        f.add(rb1);f.add(rb2);f.add(rb3);f.add(rb4);f.add(order);f.add(rb5);
        f.add(dtitle);f.add(x1);f.add(x2);f.add(x3);f.add(x4);f.add(x5);


        f.setSize(600,600);  
        f.setLayout(null); 
        f.setLocationRelativeTo(null); 
        f.setVisible(true);

        b1.addActionListener(this);
        rb1.addActionListener(this);
        rb2.addActionListener(this);
        rb3.addActionListener(this);
        rb4.addActionListener(this);
        rb5.addActionListener(this);
        order.addActionListener(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    quantity.addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
             char c = e.getKeyChar();
             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                  e.consume();  // if it's not a number, ignore the event
             }
         }
      });    

    } 

    public void actionPerformed(ActionEvent ae)
    {
    if(ae.getActionCommand().equals("SELECT"))
    {
        selectedValue = cb.getSelectedItem().toString();
        product.setText(selectedValue);

        if (selectedValue == "Spaghetti"){
            labelPic.setIcon(new ImageIcon("spaghetti.png"));
            amount2 = 20;
        }
        if (selectedValue == "Burger"){
            labelPic.setIcon(new ImageIcon("burger.png"));
            amount1 = 25;
        }
        if (selectedValue == "Ice Cream"){
            labelPic.setIcon(new ImageIcon("icecream.png"));
            amount3 = 10;
        }
    }
    if(ae.getActionCommand().equals("Pick Up"))
    {
        DeliveryOpt = "Pick Up No Charges.";
        delivery1 = 0;
    }
    if(ae.getActionCommand().equals("1-2km"))
    {
        DeliveryOpt = " 1-2km";
        delivery1 = 20;
    }
    if(ae.getActionCommand().equals("3-4km"))
    {
        DeliveryOpt = "3-4km";
        delivery1 = 30;
    }
    if(ae.getActionCommand().equals("5-6km"))
    {
        DeliveryOpt = "5-6km";
        delivery1 = 50;
    }
    if(ae.getActionCommand().equals("7km - up"))
    {
        DeliveryOpt = "Pick Up No Charges.";
        delivery1 = 0;
    }
    if(ae.getActionCommand().equals("ORDER"))
    {
        
        int quantityTF = Integer.parseInt(quantity.getText());
        int result = 0;
        int total = 0;
        int discount = 0;
        
        if (selectedValue == "Burger") {
           if(quantityTF > 100 && quantityTF < 300){
                amount1 = 25 * quantityTF;
                discount = (amount1 * 5)/100;
                result =  amount1 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF > 300 && quantityTF < 600 ){
                amount1 = 25 * quantityTF;
                discount = (amount1 * 15)/100;
                result =  amount1 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF > 600 && quantityTF < 1000 ){
                amount1 = 25 * quantityTF;
                discount = (amount1 * 30)/100;
                result =  amount1 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF >= 1000 ){
                amount1 = 25 * quantityTF;
                discount = (amount1 * 50)/100;
                result =  amount1 - discount ;
                total = result + delivery1;
           }  else{
                amount1 = 25;
                result = amount1 * quantityTF;
                total = result + delivery1;
           }      
            
             JOptionPane.showMessageDialog(null,"Product: Burger"+"\n"+"Price:"+amount1+"\n"+"Quantity: " +quantityTF+"\n"+"Delivery:"+ DeliveryOpt+"\n"+ "Delivery Fee: "+delivery1 +"\n"+"Total: "+total);
             product.setText("");
             quantity.setText("");
             rb1.setSelected(false);
              rb2.setSelected(false);
               rb3.setSelected(false);
                rb4.setSelected(false);
                 rb5.setSelected(false);
        }
        if (selectedValue == "Spaghetti") {
          
           if(quantityTF > 100 && quantityTF < 300){
                amount2 = 20 * quantityTF;
                discount = (amount2 * 5)/100;
                result =  amount2 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF > 300 && quantityTF < 600 ){
                amount2 = 20 * quantityTF;
                discount = (amount2 * 15)/100;
                result =  amount2 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF > 600 && quantityTF < 1000 ){
                amount2 = 20 * quantityTF;
                discount = (amount2 * 30)/100;
                result =  amount2 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF >= 1000 ){
                amount2 = 20 * quantityTF;
                discount = (amount2 * 50)/100;
                result =  amount2 - discount ;
                total = result + delivery1;
           }else{
                amount2 = 20;
                result = amount2 * quantityTF;
                total = result + delivery1;
           }          
            
             JOptionPane.showMessageDialog(null,"Product: Spaghetti"+"\n"+"Price:"+amount2+"\n"+"Quantity: " +quantityTF+"\n"+"Delivery:"+ DeliveryOpt+"\n" +"Delivery Fee: "+delivery1 +"\n"+"Total: "+total);
             product.setText("");
             quantity.setText("");
             rb1.setSelected(false);
              rb2.setSelected(false);
               rb3.setSelected(false);
                rb4.setSelected(false);
                 rb5.setSelected(false);
        }
        if (selectedValue == "Ice Cream") {

            if(quantityTF > 100 && quantityTF < 300){
                amount3 = 10 * quantityTF;
                discount = (amount3 * 5)/100;
                result =  amount3 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF > 300 && quantityTF < 600 ){
                amount3 = 10 * quantityTF;
                discount = (amount3 * 15)/100;
                result =  amount3 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF > 600 && quantityTF < 1000 ){
                amount3 = 10 * quantityTF;
                discount = (amount3 * 30)/100;
                result =  amount3 - discount ;
                total = result + delivery1;
           } 
           if(quantityTF >= 1000 ){
                amount3 = 10 * quantityTF;
                discount = (amount3 * 50)/100;
                result =  amount3 - discount ;
                total = result + delivery1;
           }else{
                amount3 = 10;
                result = amount3 * quantityTF;
                total = result + delivery1;
           }   
            
            JOptionPane.showMessageDialog(null,"Product: Ice Cream"+"\n"+"Price:"+amount3+"\n"+"Quantity: " +quantityTF+"\n"+"Delivery:"+ DeliveryOpt+"\n" +"Delivery Fee: "+delivery1 +"\n"+"Total: "+total);
            product.setText("");
            quantity.setText("");
            rb1.setSelected(false);
              rb2.setSelected(false);
               rb3.setSelected(false);
                rb4.setSelected(false);
                 rb5.setSelected(false);
        }
        
            
        
        
    }

}
    

    
}   