
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

public class readquery {
    private Connection conn;
    private ResultSet results;
     
    public readquery(){
        Properties props=new Properties();
        InputStream instr=getClass().getResourceAsStream("dbcon.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(readquery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(readquery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver=props.getProperty("driver.name");
        String url=props.getProperty("Server.name");
        String username=props.getProperty("user.name");
        String passwd=props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(readquery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn=DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(readquery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void doRead(){
        try {
            String query="select * from SUMMONMONSTER";
            
            PreparedStatement ps=conn.prepareStatement(query);
            this.results=ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(readquery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        public String getHTMLtable(){
            String table="";
            table+="<table>";
            
        try {
            while(this.results.next()){
                Summoners monster=new Summoners();
                monster.setMonsterID(this.results.getInt("MonsterID"));
                monster.setMonsterName(this.results.getString("MonsterName"));
                monster.setProperty(this.results.getString("Property"));
                monster.setMLevel(this.results.getInt("MLevel"));
                
                table+="<tr>";
                table+="<td>";
                table+=monster.getMonsterID();
                table+="</td>";
                
                table+="<td>";
                table+=monster.getMonsterName();
                table+="</td>";
                
                table+="<td>";
                table+=monster.getProperty();
                table+="</td>";
                
                table+="<td>";
                table+=monster.getMLevel();
                table+="</td>";
                
                table+="<td>";
                table+="<a href=delete?MonsterID=" + monster.getMonsterID() + "> Delete </a>";
                table+="</td>";
                
                table+="</tr>";
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(readquery.class.getName()).log(Level.SEVERE, null, ex);
        }
            table+="</table>";
            return table;
            
        }
}
