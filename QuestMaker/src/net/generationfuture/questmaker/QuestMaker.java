package net.generationfuture.questmaker;

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
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        //
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        
        if (!start) {
            app.setDisplayMode(600, 400, false);
            this.start_image.draw(1, 1);
        }
        
    }
    
    public class MouseListener {
        //
    }
    
}
