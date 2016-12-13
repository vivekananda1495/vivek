/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication33;
import java.util.*;
import java.io.*;
import java.sql.*;
/**
 *
 * @author Administrator
 */
public class JavaApplication33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            
    
        Class.forName("com.mysql.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "mysql");          
        Statement st= c.createStatement();
        String s= "select e.name from employee e, dept d where e.empid=d.empid and d.name in('hr','it')"; 
        String z= "select name from employee where age= (select min(e1.age) from employee e1, dept d1 where d1.name in('sales','hr','it') and e1.empid=d1.empid)";
        String a= "select avg(age) from employee e, dept d where e.empid=d.empid and d.did in(1,2,3) ";
       
       
       
        
        Scanner s1= new Scanner(System.in); 
        int ch= s1.nextInt();

            
        
        
        switch(ch)
        {
            case 1: ResultSet rs= st.executeQuery(s);    
                while(rs.next())
                         {
                         String q= rs.getString(1);
                         System.out.println(q);
                        }break;
            
            case 2:      ResultSet rs1= st.executeQuery(z); 
                while(rs1.next())
                         {
                     //       System.out.println("dss"); 
                         String w= rs1.getString(1);
                         System.out.println(w);
                        }break;
                    
            case 3:         ResultSet rs2= st.executeQuery(a);
                while(rs2.next())
                         {
                         String h= rs2.getString(1);
                         System.out.println(h);
                        
                        }break;
                        
            case 4:  String sql= "update table1 set name= ? where empid= ?";
                     
                     PreparedStatement st1 = c.prepareStatement(sql);
                   
                    
                    
                     String name= s1.next();
                     int empid = s1.nextInt();
                     st1.setString(1, name);
                     st1.setInt(2, empid);
                     System.out.println(name);
                      int r= st1.executeUpdate();
                     break;
                     
            case 5: String sql1 = "insert into employee2 values('vinay',23,6,'qertyp')";
                   
                    int n = st.executeUpdate(sql1);
                    break;
            case 6:  String l= "show tables";
                    String p = "describe employee2";
                     ResultSet rs3= st.executeQuery(l);  
                      List <String> w= new ArrayList<String>(); 
                     while(rs3.next())
                         {
                         String h= rs3.getString(1);
                         System.out.println(h);
                         
                       w.add(rs3.getString(1));
                      
                        
                        } //System.out.println(w);
    
                        if( w.contains("table2"))
                        {
                           System.out.println("hi");
                           String sql9 = "describe employee2";
                           ResultSet rs9= st.executeQuery(sql9); 
                            while(rs9.next())
                              {
                                  String t= rs9.getString(1);
                                  System.out.println(t);
                             }
                         
                          }
                          else
                              {
                                  String sql2 = "create table employee2(name varchar(10), age int(2), empid int(2) primary key, address varchar(50))";
                                  int m= st.executeUpdate(sql2);
                              }break;
                              
            case 7: String l1= "show tables";
                    String p1 = "describe employee2";
                     ResultSet rs4= st.executeQuery(l1);  
                      List <String> w1= new ArrayList<String>(); 
                     while(rs4.next())
                         {
                         String h= rs4.getString(1);
                         System.out.println(h);
                         
                            w1.add(rs4.getString(1));           
                        }
                    
                    
                                  String s10 = "create table tablename ?";
                                //  String s11 = "";
                                  
                                  int m= st.executeUpdate(s10);
                            
                    
                        
            default :  System.out.println("invalid input");
                        
                     
                      
        }
        c.close();
        
        
                
                
      
        
        
        }
        catch(Exception e)
        { System.out.println(e);}
        
    
    }
    
}
