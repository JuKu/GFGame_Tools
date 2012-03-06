package plugindeveloper;

import java.awt.event.KeyEvent;

public interface Pluggable {
    
    boolean start();
    boolean stop();
    void setPluginManager(PluginManager manager);
    String getName();
    double getVersion();
    boolean isCompatible(double version);
    boolean exec();
    int mouseListener(int x, int y);
    int KeyListener(KeyEvent e);
  
}
