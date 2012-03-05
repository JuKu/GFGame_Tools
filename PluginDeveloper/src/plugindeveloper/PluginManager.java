package plugindeveloper;

public interface PluginManager {
    
    void showVisualMessage(String message);
    void showErrorMessage(String message);
    String getPluginDataPath(String pluginname);
    Boolean createPluginDataPath(String pluginname);
    void writeLog(String message);
    void showMessage(String message);
    
}
