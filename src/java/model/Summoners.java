
package model;

public class Summoners {
    
    private int MonsterID;
    private String MonsterName;
    private String Property;
    private int MLevel;

    public Summoners() {
        this.MonsterID = 0;
        this.MonsterName = "";
        this.Property = "";
        this.MLevel = 0;
    }
    
    
    public Summoners(int MonsterID, String MonsterName, String property, int MLevel) {
        this.MonsterID = MonsterID;
        this.MonsterName = MonsterName;
        this.Property = property;
        this.MLevel = MLevel;
    }

    public int getMonsterID() {
        return MonsterID;
    }

    public void setMonsterID(int MonsterID) {
        this.MonsterID = MonsterID;
    }

    public String getMonsterName() {
        return MonsterName;
    }

    public void setMonsterName(String MonsterName) {
        this.MonsterName = MonsterName;
    }

    public String getProperty() {
        return Property;
    }

    public void setProperty(String property) {
        this.Property = property;
    }

    public int getMLevel() {
        return MLevel;
    }

    public void setMLevel(int MLevel) {
        this.MLevel = MLevel;
    }

    @Override
    public String toString() {
        return "Summoners{" + "MonsterID=" + MonsterID + ", MonsterName=" + MonsterName + ", property=" + Property + ", MLevel=" + MLevel + '}';
    }
    
    
    
    
}
