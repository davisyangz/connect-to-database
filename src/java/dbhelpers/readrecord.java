
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Summoners;


public class readrecord {
     private Connection conn;
    private ResultSet results;
    
   private Summoners monster=new Summoners();
   private int MonsterID;
    
    public readrecord(int MonsterID){
    
      
    Properties props=new Properties();
        InputStream instr=getClass().getResourceAsStream("dbcon.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(readrecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(readrecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("Server.name");
        String username=props.getProperty("user.name");
        String passwd=props.getProperty("user.password");
        
        this.MonsterID=MonsterID;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(readrecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(readrecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void doRead(){
         
         try {
             String query="SELECT * FROM SUMMONMONSTER WHERE MonsterID= ?";
             PreparedStatement ps=conn.prepareStatement(query);
             ps.setInt(1, MonsterID);
             this.results=ps.executeQuery();
             this.results.next();
             
             monster.setMonsterID(this.results.getInt("MonsterID"));
             monster.setMonsterName(this.results.getString("MonsterName"));
             monster.setProperty(this.results.getString("property"));
             monster.setMLevel(this.results.getInt("MLevel"));
         } catch (SQLException ex) {
             Logger.getLogger(readrecord.class.getName()).log(Level.SEVERE, null, ex);
         }
}
        
        public Summoners getMonster(){
            return this.monster;
        }
        
}
