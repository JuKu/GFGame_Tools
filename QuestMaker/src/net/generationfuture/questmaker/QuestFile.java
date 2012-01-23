package net.generationfuture.questmaker;

import java.io.File;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.newdawn.slick.Image;

public class QuestFile {
    
    private Config config;
    
    private String name = "";
    private QuestMaker questmaker;
    private String quest_image_path = "";
    private Image quest_image = null;
    
    private String quest_name = "";
    private String mouseOver_text = "";
    private int isUserQuest = 1;
    private int isFreakQuest = 1;
    
    private String build_path = "build/";
    
    public QuestFile (QuestMaker questmaker, Config config) {
        this.questmaker = questmaker;
        this.config = config;
    }
    
    public void newQuest () {
        this.name = JOptionPane.showInputDialog(new JLabel("Bitte Quest-Name (zum speichern) eingeben:"));
        this.quest_name = JOptionPane.showInputDialog(new JLabel("Bitte den Quest-Namen eingeben, der im Game angezeigt wird:"));
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public void checkFileSystem () {
        
        File ordner = new File(config.outputFolder + "/");
        
        if (!ordner.exists()) {
            ordner.mkdirs();
        }
        
        ordner = new File(config.getCachePath());
        
        if (!ordner.exists()) {
            ordner.mkdirs();
        }
        
        ordner = new File(config.getCachePath() + "/src");
        
        if (!ordner.exists()) {
            ordner.mkdirs();
        }
        
        ordner = new File(config.getCachePath() + "/build");
        
        if (!ordner.exists()) {
            ordner.mkdirs();
        }
        
    }
    
    public void loadQuest (String name) {
        //
    }
    
    public void saveQuest () {
        //
    }
    
    public void compile () {
        
        checkFileSystem();
        
        if (name != null && !"".equals(name)) {
            
        File file = new File("Data/Saves/" + name + "/");
        
        if (!file.exists()) {
            file.mkdir();
        }
        
        INIDatei inidatei = new INIDatei("Data/Saves/" + name + ".ini");//System.out.println("app_name: " + this.config.getAppName());
        //
        inidatei.setzeString("QuestMaker", "app_name", config.app_name);
        inidatei.setzeString("QuestMaker", "webseite", config.webseite);
        inidatei.setzeDouble("QuestMaker", "version", config.version);
        inidatei.setzeString("QuestMaker", "version_", config.version_);
        
        inidatei.setzeString("Quest", "name", this.quest_name);
        inidatei.setzeString("Quest", "mouseOver_text", this.mouseOver_text);
        inidatei.setzeInteger("Quest", "isUserQuest", this.isUserQuest);
        inidatei.setzeInteger("Quest", "isFreakQuest", this.isFreakQuest);
        
        inidatei.setzeString("Images", "quest_image", this.quest_image_path);
        
        inidatei.setzeString("build", "path", this.build_path);
        
        inidatei.schreibeINIDatei("Data/Saves/" + name + ".ini", true);
        
        } else {
            JOptionPane.showConfirmDialog(null, new JLabel("Der Quest konnte nicht kompiliert werden, da kein Quest geöffet ist."), "GFGame-QuestMaker", 2);//JOptionPane.showConfirmDialog(new JLabel("Der Quest konnte nicht kompiliert werden, da kein Quest geöffet ist."), this);
        }
        
    }
    
    public void run () {
        //
    }
    
}
