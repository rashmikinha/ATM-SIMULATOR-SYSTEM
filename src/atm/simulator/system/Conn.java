package atm.simulator.system;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            //create connection 
            c =DriverManager.getConnection("jdbc:mysql:///bms","root","7042270752");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  