package net.generationfuture.questmaker;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class QuestMaker extends BasicGame {
    
    private Image start_image = null;
    private Boolean start = false;
    
    public QuestFile questfile;
    public static AppGameContainer app;
    
    Boolean menu_isShown = false;
    String menu_names[][];
    
    int menu_x = 200;
    int menu_y = 100;
    int menu_width = 200;
    int menu_height = 40;
    
    public double version = 1.0;
    public String version_ = "1.0";
    
    public String app_name = "QuestMaker 1.0";
    public String webseite = "http://generation-future.net/phpBB3";
    
    public QuestMaker () throws SlickException {
        super("GFGame-QuestMaker");
    }

    public static void main(String[] args) throws SlickException {
         app = new AppGameContainer(new QuestMaker());
         //Dies ist JuKus erster Kommentar in dieser Datei. ;-)
         app.setDisplayMode(800, 600, false);
         app.start();
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        start_image = new Image("Data/images/start_image.png");
        gc.getInput().addMouseListener(new AppMouseListener(this));
        
        menu_names = new String[10][4];
        questfile = new QuestFile(this);
        
        menu_names[0][0] = "Neuen Quest";
        menu_names[1][0] = "Quest laden";
        menu_names[0][2] = "newQuest";//MouseCommand
        menu_names[1][2] = "loadQuest";
        
        menu_names[2][0] = "Quest speichern";
        menu_names[2][2] = "saveQuest";
        menu_names[3][0] = "Quest complieren";//MouseCommand
        menu_names[3][2] = "compileQuest";
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        //
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        
        if (!start) {
            app.setDisplayMode(600, 400, false);
            this.start_image.draw(1, 1);
        } else {
            
            if (menu_isShown) {
                
                int x = menu_x;
                int y = menu_y;
                
                for (int i = 0; i < menu_names.length; i++) {
                    
                    Color schrift_color = Color.blue;
                    Color bg_color = Color.white;
                    
                    if (menu_names[i][0] != null) {
                        
                        if ("true".equals(menu_names[i][1])) {
                            schrift_color = Color.white;
                            bg_color = Color.blue;
                        }
                    
                    g.setColor(Color.blue);
                    g.drawRect(x, y, 200, 40);
                    g.setColor(schrift_color);
                    g.fillRect(x + 1, y + 1, 200 - 1, 40 - 1);
                    g.setColor(bg_color);
                    g.drawString(menu_names[i][0] + "", x + 20, y + 10);
                    
                    y = y + 50;
                    
                    }
                    
                }
                
                g.setColor(Color.blue);
                
            } else {
                
            g.fillRect(1, 1, 800, 600);
            g.setColor(Color.blue);
            g.drawString("GFGame-QuestMaker", 20, 20);
            g.setColor(Color.white);
                
            }
            
        }
        
    }
    
    public void Menu_isMouseOver (int mouse_x, int mouse_y) {
        
        for (int i = 0; i < menu_names.length; i++) {
            
        if (mouse_x > menu_x && mouse_x < menu_x + menu_width) {
            
            if (mouse_y > menu_y + (i * 50) && mouse_y < menu_y + (i * 50) + menu_height) {
                menu_names[i][1] = "true";
            } else {
                menu_names[i][1] = "false";
            }
            
        } else {
            menu_names[i][1] = "false";
        }
        
        }
        
    }
    
    public void Menu_isMouseClicked (int mouse_x, int mouse_y) {
        
        for (int i = 0; i < menu_names.length; i++) {
            
        if (mouse_x > menu_x && mouse_x < menu_x + menu_width) {
            
            if (mouse_y > menu_y + (i * 50) && mouse_y < menu_y + (i * 50) + menu_height) {
                actionPerformed(menu_names[i][2]);
            } else {
                //
            }
            
        } else {
            //
        }
        
        }
        
    }
    
    public void actionPerformed (String command) {
        
        System.out.println("actionPerformed: " + command);
        
        if ("compileQuest".equals(command)) {
            questfile.compile();
        } else if ("newQuest".equals(command)) {
            questfile.newQuest();
        }
        
    }
    
    class AppMouseListener implements MouseListener {
        
        QuestMaker questmaker;
        
        public AppMouseListener (QuestMaker questmaker) {
            this.questmaker = questmaker;
        }

        @Override
        public void mouseWheelMoved(int i) {
            //
        }

        @Override
        public void mouseClicked(int i, int i1, int i2, int i3) {
            
            if (!questmaker.start) {
                
                try {
                    
                    questmaker.start = true;
                    QuestMaker.app.setDisplayMode(800, 600, false);
                    
                    questmaker.menu_isShown = true;
                    
                } catch (SlickException ex) {
                    Logger.getLogger(QuestMaker.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                
                if (questmaker.menu_isShown) {
                    questmaker.Menu_isMouseClicked(i1, i2);
                }
                
            }
            
        }

        @Override
        public void mousePressed(int i, int i1, int i2) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(int i, int i1, int i2) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseMoved(int i, int i1, int i2, int i3) {
            //throw new UnsupportedOperationException("Not supported yet.");
            
            if (questmaker.menu_isShown) {
                questmaker.Menu_isMouseOver(i, i1);
            }
            
            //
        }

        @Override
        public void mouseDragged(int i, int i1, int i2, int i3) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void setInput(Input input) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean isAcceptingInput() {
            //throw new UnsupportedOperationException("Not supported yet.");
            return true;
        }

        @Override
        public void inputEnded() {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void inputStarted() {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
}
