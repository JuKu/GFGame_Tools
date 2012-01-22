package net.generationfuture.questmaker;

public class QuestFile {
    
    private String name = "";
    private QuestMaker questmaker;
    
    public QuestFile (QuestMaker questmaker) {
        this.questmaker = questmaker;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public void loadQuest (String name) {
        //
    }
    
    public void compile () {
        
        INIDatei inidatei = new INIDatei("Data/Saves/" + name + ".ini");
        
        inidatei.setzeString("Glo", name, name);
        
    }
    
    public void run () {
        //
    }
    
}
