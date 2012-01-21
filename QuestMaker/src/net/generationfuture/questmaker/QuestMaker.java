package net.generationfuture.questmaker;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class QuestMaker extends BasicGame {
    
    private Image start_image = null;
    private Boolean start = false;
    
    public static AppGameContainer app;
    
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
            
            g.fillRect(1, 1, 800, 600);
            g.setColor(Color.blue);
            g.drawString("GFGame-QuestMaker", 20, 20);
            g.setColor(Color.white);
            
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
                    
                } catch (SlickException ex) {
                    Logger.getLogger(QuestMaker.class.getName()).log(Level.SEVERE, null, ex);
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
