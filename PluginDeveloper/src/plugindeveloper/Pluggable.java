package plugindeveloper;

public interface Pluggable {
    
    boolean start();
    boolean stop();
  
    void setPluginManager(PluginManager manager);
  
}
