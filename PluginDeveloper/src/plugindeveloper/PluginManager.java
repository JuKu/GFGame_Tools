package plugindeveloper;

import java.awt.Component;
import java.io.File;

public interface PluginManager {
    
    double version = 1.0;
    
    void showVisualMessage(String message);
    void showErrorMessage(String message);
    String getPluginDataPath(String pluginname);
    Boolean createPluginDataPath(String pluginname);
    void writeLog(String message);
    void showMessage(String message);
    void closeGame ();
    void createQuest(File file);
    double getVersion();
    void exec(String command);
    
}
