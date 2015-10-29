
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
        
public class deletequery {
    
    private Connection conn;
    
    public deletequery(){
        
        Properties props=new Properties();
        InputStream instr=getClass().getResourceAsStream("dbcon.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(deletequery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(deletequery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("Server.name");
        String username=props.getProperty("user.name");
        String passwd=props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(deletequery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(deletequery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void dodelete(int MonsterID){
        
        try {
            String query="DELETE From SUMMONMONSTER WHERE MonsterID= ?";
            
            PreparedStatement ps= conn.prepareStatement(query);
            
            ps.setInt(1, MonsterID);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(deletequery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
