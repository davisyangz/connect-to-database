/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Summoners;

/**
 *
 * @author Zheng
 */
public class addquery {
    
    private Connection conn;
    
    public addquery(){
        Properties props=new Properties();
        InputStream instr=getClass().getResourceAsStream("dbcon.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(addquery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(addquery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("Server.name");
        String username=props.getProperty("user.name");
        String passwd=props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addquery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(addquery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void doAdd(Summoners monster){
     
        try {
            String query="INSERT INTO SUMMONMONSTER(MonsterName, Property, Mlevel) VALUES(?,?,?)";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1, monster.getMonsterName());
            ps.setString(2, monster.getProperty());
            ps.setInt(3, monster.getMLevel());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(addquery.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
                  

     
 }
     
}
