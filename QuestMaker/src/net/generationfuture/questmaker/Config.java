package net.generationfuture.questmaker;

public class Config {
    
    private String config_file = "";
    
    private double version = 1.0;
    private String version_ = "1.0";
    
    public Config (String config_file) {
        this.config_file = config_file;
        loadConfig();
    }
    
    public final void loadConfig () {
        
        INIDatei config_datei = new INIDatei(this.config_file);
        
    }
    
}
