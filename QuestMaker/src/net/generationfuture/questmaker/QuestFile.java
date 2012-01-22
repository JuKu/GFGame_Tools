package net.generationfuture.questmaker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class QuestFile {
    
    private String name = "";
    private QuestMaker questmaker;
    
    public QuestFile (QuestMaker questmaker) {
        this.questmaker = questmaker;
    }
    
    public void newQuest () {
        //
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public void loadQuest (String name) {
        //
    }
    
    public void compile () {
        
        if (name != null && !"".equals(name)) {
        
        INIDatei inidatei = new INIDatei("Data/Saves/" + name + ".ini");
        inidatei.setzeString("QuestMaker", "app_name", questmaker.app_name);
        inidatei.setzeString("QuestMaker", "webseite", questmaker.webseite);
        inidatei.setzeDouble("QuestMaker", "version", questmaker.version);
        inidatei.setzeString("QuestMaker", "version_", questmaker.version_);
        
        inidatei.schreibeINIDatei("Data/Saves/" + name + ".ini", true);
        
        } else {
            JOptionPane.showConfirmDialog(null, new JLabel("Der Quest konnte nicht kompiliert werden, da kein Quest geöffet ist."), "GFGame-QuestMaker", 2);//JOptionPane.showConfirmDialog(new JLabel("Der Quest konnte nicht kompiliert werden, da kein Quest geöffet ist."), this);
        }
        
    }
    
    public void run () {
        //
    }
    
}
