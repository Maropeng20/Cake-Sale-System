/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malemela.mv;

import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author MAROPENG VANESSA MALEMELA
 */
public class MalemelaMV {
    
    private String flavour;
    private String shape;
    private char lateOrder;
    private String orderNumber;

    public MalemelaMV() {
        
        flavour="FRUIT";
        shape="SQUARE";
        lateOrder='Y';
        orderNumber="RD2347#89";
        
                
    }

    public MalemelaMV(String flavour, String shape, char lateOrder, String orderNumber) {
        this.flavour = flavour;
        this.shape = shape;
        this.lateOrder = lateOrder;
        this.orderNumber = orderNumber;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public char getLateOrder() {
        return lateOrder;
    }

    public void setLateOrder(char lateOrder) {
        this.lateOrder = lateOrder;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public double calculateTotal()
    {
        double totPrice=0;
        
        switch(lateOrder)
        {
            case 'Y':totPrice=totPrice+52.54;
                     break;
            case 'N':totPrice=totPrice+28.67;
                    break;
        }
        
        if(flavour.equals("CHOCOLATE"))
        {
          totPrice=totPrice+85.50;
          
          if(shape.equals("ROUND"))
          {
            totPrice=totPrice+35.75;  
          }else if(shape.equals("SQUARE"))
          {
             totPrice=totPrice+25.75;  
          }
              
        }else if(flavour.equals("VANILLA"))
         {
             totPrice=totPrice+65.50;
          
            if(shape.equals("ROUND"))
            {
              totPrice=totPrice+35.75;  
            }else if(shape.equals("SQUARE"))
              {
                totPrice=totPrice+25.75;  
              }
             
         }else if(flavour.equals("RED VELVET"))
           {
                totPrice=totPrice+120.79;
          
                if(shape.equals("ROUND"))
                {
                  totPrice=totPrice+35.75;  
                }else if(shape.equals("SQUARE"))
                  {
                    totPrice=totPrice+25.75;  
                  }
            
           }else if(flavour.equals("FRUIT"))
             {
                totPrice=totPrice+105.55;
          
                if(shape.equals("ROUND"))
                {
                  totPrice=totPrice+35.75;  
                }else if(shape.equals("SQUARE"))
                  {
                    totPrice=totPrice+25.75;  
                  }
             }
        
        return totPrice;
    }
    
    public double determineChange(double amount)
    {
        double change=0.0;
        double amountDue=calculateTotal();
       
        change=amount-amountDue;
        
        return change;
        
    }
    
     public String displayOrder(double paid)
    {
        DecimalFormat fm=new DecimalFormat("R#####.00");
        
        Date dt=new Date();
        String display="                            Ruby's Delights"+"\n"+dt+"\n================================================"+"\n"
        +"                            CAKE ORDER:"+orderNumber+"\n"+" \n"+"Cake Flavour:"+getFlavour()+"\nShape:"+getShape();
        
        switch(lateOrder)
        {
            case 'Y':display=display+"\nLate Order:Yes                "+ "Cake order fee:R52.54";
                     break;
            case 'N':display=display+"\nLate Order:No                 "+ "Cake order fee:R28.67";
        }
        
        display=display+"\nTotal Due:"+fm.format(calculateTotal()) +"           Amount Rendered:"+fm.format(paid)+"\nChange Due:"+fm.format(determineChange(paid))
                +"\n                     --------------------------------\n                             "+ "Thank You";
        
        return display;
    }
    
    public boolean checkOrderNo(String input)
    {
         boolean status=false;
         String numBase="RD2347#";
            String test=input.substring(0,7);
            if(test.equals(numBase))
            {
              status=true;
            }
          return status;  
        
    }

    
}
