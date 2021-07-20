package akConnects.accountsPlus;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//used for communication and connection to db
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.*;



/**
 *
 * @author Akell
 */




public class SQLiteDbConnect {
    
    final public static String DBURL = "C:\\Users\\Akell\\Desktop\\repo\\AccountsPlus\\akConnects\\AccountsPlus.db";
    Connection conn = null;
    
    
    
    public SQLiteDbConnect(){
        
    	
    	
    	
    	// register driver with driver manager
        try{
            Class.forName("org.sqlite.JDBC");
        }catch (Exception error){
            System.out.println("Exception Db1: " + error);
        }
    	
        
        //checkFileExists()
        
        // get connection to db driver
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:" + DBURL);
        }catch( SQLException error){
            System.out.println("Exception Db2:" + error);
        }
        
        

    }
    
    
    
//    public void checkFileExists() {
//    	// https://www.tutorialspoint.com/java/java_files_io.htm
//	  	//using java.io
//    	File file = new File(DBURL);
//		if(file.exists()) //here's how to check
//	     {
//	         System.out.print("This database name already exists");
//	     }
//	     else{
//	    	 try {	
//	    	   Class.forName("org.sqlite.JDBC");            
//	           conn = DriverManager.getConnection("jdbc:sqlite:"+ DBURL);
//	           conn.createStatement(); 
//	           
//	    	 }catch(SQLException error) {
//	    		 System.out.println("Exception Db1.5:" + error);
//	    	 }
//
//	     }
//
//  	//using SQLite
//      //https://www.sqlitetutorial.net/sqlite-java/create-database/
//		// ensure we have a db file to work with
//		// try a connection and if it fails create db file
//		try(Connection c = DriverManager.getConnection("jdbc:sqlite:" + DBURL)){
//			if(c != null) {
//				DatabaseMetaData meta = c.getMetaData();
//				System.out.println("The driver name is: " + meta.getDriverName());
//			}
//		}catch (SQLException error){
//			System.out.println("Exception db1:" + error);
//		}
//    }
    
    
    
    
    
    public void dbDisconnectConn(){
        try{
            conn.close();
        }catch( SQLException error ){
            System.out.println("Exception Db3: " + error);
        }
        
    }
    
    
    
//    //create
//    public boolean addUser(int id, String email, String password){
//        String sql = "INSERT INTO Users VALUES(?,?,?)";
//        
//        PreparedStatement prepStmt = null;
//        Boolean result = false;
//
//        
//        try{
//            //setup pepare stmt 
//            prepStmt = conn.prepareStatement(sql);
//            
//            //fill prepare stmt
//            prepStmt.setInt(1,id);
//            prepStmt.setString(2,email);
//            prepStmt.setString(3,password);
//            
//            //execute
//            int rInt = prepStmt.executeUpdate(); 
//                        // Returns: either 
//                                   //(1) the row count for SQL Data Manipulation Language (DML) statements or 
//                                   //(2) 0 for SQL statements that return nothing
//            
//            if(rInt != 0){
//                result = true;
//            }
//            
//            //close in scope vars
//            prepStmt.close();
//            
//            
//        }catch( SQLException error){
//            System.out.println("Exception Db4 addUser:" + error);
//        } 
//        
//        return result;
//    }
//    
//    
//    
//    
//    // read
//    public void selectAllUsers(){
//        String sql = "SELECT * FROM Users;";
//        
//        PreparedStatement prepStmt = null;
//        ResultSet resultSet = null;
//        
//        try{
//            prepStmt = conn.prepareStatement(sql);
//            prepStmt.clearParameters();
//            
//            int id;
//            String email;
//            String password;
//            
//            resultSet = prepStmt.executeQuery();
//            while( resultSet.next() ){ //loop through rows
//                id = resultSet.getInt(1);
//                email = resultSet.getString("email");
//                password = resultSet.getString(3);
//                System.out.println("id=" + id +"/ email=" + email +"/ password= " + password + "/");
//            }
//            
//            resultSet.close();
//            prepStmt.close();
//        }catch( SQLException error){
//            System.out.println("Exception Db5 SelectAllUsers:" + error);
//        } 
//    }
//    
//    
//    //update
//    public boolean updateUserEmailById(String email,int id){
//        String sql = "UPDATE Users SET email = ? WHERE id = ?";
//        
//        PreparedStatement prepStmt = null;
//        Boolean result = false;
//
//        
//        try{
//            //setup pepare stmt 
//            prepStmt = conn.prepareStatement(sql);
//            
//            //fill prepare stmt
//            prepStmt.setString(1,email);
//            prepStmt.setInt(2,id);
//            
//            //execute
//            int rInt = prepStmt.executeUpdate(); 
//                        // Returns: either 
//                                   //(1) the row count for SQL Data Manipulation Language (DML) statements or 
//                                   //(2) 0 for SQL statements that return nothing
//            
//            if(rInt != 0){
//                result = true;
//            }
//            
//            //close in scope vars
//            prepStmt.close();
//            
//            
//        }catch( SQLException error){
//            System.out.println("Exception Db6 updateUserEmailById:" + error);
//        } 
//        
//        return result;
//    }
//    
//    
//    
//    //DELETE
//    public boolean deleteUserById(int id){
//        String sql = "DELETE FROM Users WHERE id = ?";
//        
//        PreparedStatement prepStmt = null;
//        Boolean result = false;
//
//        
//        try{
//            //setup pepare stmt 
//            prepStmt = conn.prepareStatement(sql);
//            
//            //fill prepare stmt
//            prepStmt.setInt(1,id);
//            
//            //execute
//            int rInt = prepStmt.executeUpdate(); 
//                        // Returns: either 
//                                   //(1) the row count for SQL Data Manipulation Language (DML) statements or 
//                                   //(2) 0 for SQL statements that return nothing
//            
//            if(rInt != 0){
//                result = true;
//            }
//            
//            //close in scope vars
//            prepStmt.close();
//            
//            
//        }catch( SQLException error){
//            System.out.println("Exception Db7 deleteUserById:" + error);
//        } 
//        
//        return result;
//    }
//    
//    
//}
    

