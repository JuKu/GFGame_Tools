package net.generationfuture.questmaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.newdawn.slick.Image;

public class QuestFile {
    
    private Config config;
    
    private String name = "";
    private QuestMaker questmaker;
    private String quest_image_path = "image.png";
    private Image quest_image = null;
    
    private String quest_name = "";
    private String mouseOver_text = "mouseOver-Text";
    private int isUserQuest = 1;
    private int isFreakQuest = 1;
    
    public String update_text = "System.out.println(\"test\");";
    public String reward_text = "System.out.println(\"reward.\");";
    
    private String build_path = "build/";
    public String java_file = "public class Quest1 {\npublic static void main(String args[]) {\n\tSystem.out.println(\"test\");\n}\n  }";
    
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
    
    public void compile () throws IOException {
        
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
        
        File java_datei = new File(config.outputFolder + "/" + name + "/" + name + ".java");
        
        if (java_datei.exists()) {
            java_datei.delete();
        }
        
        java_datei.createNewFile();
        
        FileWriter writer;
        writer = new FileWriter(java_datei, false);
        
        /*writer.write(this.java_file);
        
        //Platformunabhängiger Zeilenumbruch
        writer.write(System.getProperty("line.separator"));
        
        writer.write("test");*/
        
        writer = this.writeFile(writer);
        
        writer.flush();
        writer.close();
        
        File inF = new File(config.outputFolder + "/" + name + "/" + name + ".java");
        File outF = new File(config.getCachePath() + "/src/" + name + ".java");
        copyFile(inF, outF);
        
        inF = new File("Data/Items.class");
        outF = new File(config.getCachePath() + "/src/Items.class");
        copyFile(inF, outF);
        
        inF = new File("Data/Player.class");
        outF = new File(config.getCachePath() + "/src/Player.class");
        copyFile(inF, outF);
        
        inF = new File("Data/Quest.class");
        outF = new File(config.getCachePath() + "/src/Quest.class");
        copyFile(inF, outF);
        
        inF = new File("Data/lib/lwjgl.jar");
        outF = new File(config.getCachePath() + "/src/lwjgl.jar");
        copyFile(inF, outF);
        
        inF = new File("Data/lib/natives-linux.jar");
        outF = new File(config.getCachePath() + "/src/natives-linux.jar");
        copyFile(inF, outF);
        
        inF = new File("Data/lib/natives-mac.jar");
        outF = new File(config.getCachePath() + "/src/natives-mac.jar");
        copyFile(inF, outF);
        
        inF = new File("Data/lib/natives-win32.jar");
        outF = new File(config.getCachePath() + "/src/natives-win32.jar");
        copyFile(inF, outF);
        
        inF = new File("Data/lib/slick.jar");
        outF = new File(config.getCachePath() + "/src/slick.jar");
        copyFile(inF, outF);
        
        Runtime.getRuntime().exec("cmd /c pause");//System.out.println("user.dir: " + System.getProperty("user.dir"));
        //String string[] = new String[2];string[0] = "cd Cache/src";string[1] = "javac " + name + ".java";
        Runtime.getRuntime().exec("compile.bat"/*"Cache/compile.bat"*//*"javac Cache/src/" + name + "/" + name + ".java"*//* + System.getProperty("user.dir") + "\\Cache\\src\\" + name + ".java"*/);
        
        } else {
            JOptionPane.showConfirmDialog(null, new JLabel("Der Quest konnte nicht kompiliert werden, da kein Quest geöffet ist."), "GFGame-QuestMaker", 2);//JOptionPane.showConfirmDialog(new JLabel("Der Quest konnte nicht kompiliert werden, da kein Quest geöffet ist."), this);
        }
        
    }
    
    public void run () {
        //
    }
    
    public FileWriter writeFile (FileWriter writer) throws IOException {
        
        String br = System.getProperty("line.separator");
        
        writer.write("//" + config.app_name + " Version: " + config.version_ + this.getZeilenumbruch() + this.getZeilenumbruch() + "");
        writer.write("import org.newdawn.slick.Image;" + this.getZeilenumbruch() + "import org.newdawn.slick.SlickException;" + this.getZeilenumbruch() + this.getZeilenumbruch() + "");
        
        writer.write("public class " + name + " extends Quest {" + this.getZeilenumbruch() + this.getZeilenumbruch() + "");
        
        writer.write("//test" + br + "");
        writer.write("public " + name + " (Player player, Items items) throws SlickException {" + br + br + "");
        
        writer.write("super(player, items);" + br + "Questimage[0] = new Image(\"" + config.quest_image_folder + "/" + this.quest_image_path + "\");" + br + br + "Questhinweis = \"" + this.mouseOver_text + "\";" + "");
        
        writer.write("" + br + br + "}" + br + br + "");
        writer.write("@Override" + br + "public void update () {" + br + br + "" + this.update_text + br + br + "}");
        
        writer.write("" + br + br + "@Override" + br + "public void reward () {" + br + br + this.reward_text + br + br + "}");
        
        writer.write("" + this.getZeilenumbruch() + this.getZeilenumbruch() +  "}");
        
        return writer;
        
    }
    
    public String getZeilenumbruch () {
        return System.getProperty("line.separator") + "";
    }
    
     public static void copyFile(File in, File out) throws IOException {
        FileChannel inChannel = new FileInputStream(in).getChannel();
        FileChannel outChannel = new FileOutputStream(out).getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (IOException e) {
            throw e;
        } finally {
            if (inChannel != null)
                inChannel.close();
            if (outChannel != null)
                outChannel.close();
        }
    } 
    
}
