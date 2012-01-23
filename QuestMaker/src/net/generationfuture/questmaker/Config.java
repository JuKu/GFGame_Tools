package net.generationfuture.questmaker;

public class Config {
    
    private String config_file = "";
    
    public double version = 1.0;
    public String version_ = "1.0";
    
    public String app_name = "QuestMaker 1.0";
    public String webseite = "http://generation-future.net/phpBB3";
    
    private String cache_path = "Cache/";
    private int debug_modus = 0;
    private int auto_update = 1;
    private String server_typ = "php";
    
    private String firstRunFile = "Data/Config/FirstRun.ini";
    private String configFolder = "Data/Config";
    
    private int firstRun = 1;
    
    public String build_cmd = "javac ";
    public String build_path = "Cache/src";
    public String src_path = "Cache/src";
    public String run_command = "java ";
    public int createDataFile = 1;
    public String outputFolder = "Data/Saves";
    public int compile_bat = 1;
    public String compile_bat_file = "Cache/compile.bat";
    
    public Config (String config_file) {
        this.config_file = config_file;
        loadConfig();
        
        checkFileSystem();
    }
    
    public final void loadConfig () {
        
        INIDatei config_datei = new INIDatei(this.config_file);
        
        this.cache_path = config_datei.leseString("Config", "cache");
        this.debug_modus = config_datei.leseInteger("Config", "debug", 0);
        this.auto_update = config_datei.leseInteger("Config", "auto_update", 1);
        this.server_typ = config_datei.leseString("Config", "server_typ");
        this.firstRunFile = config_datei.leseString("Config", "FirstRunFile");
        this.configFolder = config_datei.leseString("Config", "configFolder");
        
        INIDatei inidatei = new INIDatei(configFolder + "/Version.ini");
        
        this.version = inidatei.leseDouble("Version", "version", 1.0);
        this.version_ = inidatei.leseString("Version", "version_");
        this.app_name = inidatei.leseString("Version", "app_name");
        this.webseite = inidatei.leseString("Version", "webseite");
        
        inidatei = new INIDatei(configFolder + "/FirstRun.ini");
        this.firstRun = inidatei.leseInteger("FirstRun", "FirstRun", 1);
        
        INIDatei build_datei = new INIDatei(configFolder + "/build.ini");
        
        this.build_cmd = build_datei.leseString("build", "build");
        this.build_path = build_datei.leseString("build", "build_path");
        this.src_path = build_datei.leseString("build", "src_path");
        this.run_command = build_datei.leseString("build", "run_command");
        this.createDataFile = build_datei.leseInteger("build", "createDataFile", 1);
        this.outputFolder = build_datei.leseString("build", "outputFolder");
        this.compile_bat = build_datei.leseInteger("build", "compile_bat", 1);
        this.compile_bat_file = build_datei.leseString("build", "compile_bat_file");
        
    }
    
    public final void checkFileSystem () {
        //
    }
    
    public String getAppName () {
        return this.app_name;
    }
    
    public Boolean getFirstRun () {
        
        if (this.firstRun == 1) {//Anwendung wurde noch nicht ausgeführt.
            return true;
        } else {//Anwendung wurde schon ausgeführt.
            return false;
        }
        
    }
    
    public void setFirstRun (Boolean firstRun) {
        
        if (firstRun) {//Anwendung wurde noch nicht ausgeführt.
            this.firstRun = 1;
        } else {//Anwendung wurde schon ausgeführt.
            this.firstRun = 0;
        }
        
        INIDatei inidatei = new INIDatei(configFolder + "/FirstRun.ini");
        inidatei.setzeInteger("FirstRun", "FirstRun", this.firstRun);
        
        inidatei.schreibeINIDatei(configFolder + "/FirstRun.ini", true);
        
    }
    
    public String getCachePath () {
        return this.cache_path;
    }
    
    public int isDebugModus () {
        return this.debug_modus;
    }
    
}
