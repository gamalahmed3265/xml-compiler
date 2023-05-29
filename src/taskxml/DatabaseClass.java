package taskxml;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.PreparedStatement;
/**
 *
 * @author gamal
 */
public class DatabaseClass {
    private Student student;
    DatabaseClass(Student student){
        this.student=student;
    }
    public static void CreateTable(){
        String quaryCreateTable="CREATE TABLE IF NOT EXISTS Students (id integer primary key autoincrement,name varchar(255),phone INTEGER,age INTEGER)";
             try(
            Connection con=DriverManager.getConnection("jdbc:sqlite:database2.db");
            Statement ss=con.createStatement();
                ){
            System.out.println("Connection succccccfly");
                       
            ss.execute(quaryCreateTable);
            System.out.println("create succccccfly");

            ss.close();
        }
                
        catch(SQLException eeor){
            System.out.println(eeor.getMessage());
        }        
    }
    
public  void insertData(){
          //IF NOT EXISTS
          String quaryInsert="INSERT INTO Students (name, phone, age)VALUES ('"+
                  student.getName()+
                  "', '"+
                  student.getPhone()+
                  "', '"+
                  student.getAge()+
                  "');"
                  ;
        
        try(
            Connection con=DriverManager.getConnection("jdbc:sqlite:database2.db");
            Statement ss=con.createStatement();
                ){
            CreateTable();
            System.out.println("Connection succccccfly");
            System.out.println(quaryInsert);
            ss.execute(quaryInsert);
            System.out.println("INSERT succccccfly");
            ss.close();
        }
                
        catch(SQLException eeor){
            System.out.println(eeor.getMessage());
        }        
     }
   
public  void DeleteDataBase(int id){
          
          String quaryDelete="DELETE FROM Takes WHERE id='"+id+"';";
//          String drop="ALTER TABLE Takes DROP id;";
//          String  AUTOINCREM="ALTER TABLE Takes AUTO_INCREMENT=1";         
//          String ALTERdropAUTO_INCREMENT="ALTER TABLE Takes ADD id int UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY FIRST;";
        try(
            Connection con=DriverManager.getConnection("jdbc:sqlite:database2.db");
            Statement ss=con.createStatement();
                ){
            System.out.println("Connection succccccfly");
            System.out.println("create succccccfly");

            ss.execute(quaryDelete);
//            ss.execute(drop);
//            ss.execute(AUTOINCREM);
//            ss.execute(ALTERdropAUTO_INCREMENT);
            System.out.println("Delete succccccfly");
            ss.close();
        }
                
        catch(SQLException eeor){
            System.out.println(eeor.getMessage());
        }        
     }
    
public static void UpdateDataBase(int id,String name,String contant,String dayvalue,int FromHour,int FromMin,int ToHour,int ToMin){
          
          String quaryUpdate="UPDATE Takes SET name='"+name+"', contant='"+contant+"', day='"+dayvalue+"', fromHour='"+FromHour+"', fromMin='"+FromMin+"', toHour='"+ToHour+"', toMin='"+ToMin+"' WHERE id='"+id+"';";
        
        try(
            Connection con=DriverManager.getConnection("jdbc:sqlite:database2.db");
            Statement ss=con.createStatement();
                ){
            System.out.println("Connection succccccfly");

            
            ss.execute(quaryUpdate);
            System.out.println("Update succccccfly");
            ss.close();
        }
                
        catch(SQLException eeor){
            System.out.println(eeor.getMessage());
        }        
     }
       
public static void DropTable(){
          
          String quaryDrope="DROP TABLE Takes;";
        try(
            Connection con=DriverManager.getConnection("jdbc:sqlite:database2.db");
            Statement ss=con.createStatement();
                ){
            System.out.println("Connection succccccfly");

            ss.execute(quaryDrope);
            System.out.println("quaryDrope succccccfly");
            ss.close();
        }
                
        catch(SQLException eeor){
            System.out.println(eeor.getMessage());
        }        
     }
public static void DeleteDataBaseByDay(String day){
          
          String quaryDelete="DELETE FROM Takes WHERE day='"+day+"';";
        try(
            Connection con=DriverManager.getConnection("jdbc:sqlite:database2.db");
            Statement ss=con.createStatement();
                ){
            System.out.println("Connection succccccfly");
            System.out.println("create succccccfly");

            ss.execute(quaryDelete);            System.out.println("Delete succccccfly");
            ss.close();
        }
                
        catch(SQLException eeor){
            System.out.println(eeor.getMessage());
        }        
     }
}
    
