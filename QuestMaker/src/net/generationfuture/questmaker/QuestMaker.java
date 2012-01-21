package net.generationfuture.questmaker;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class QuestMaker extends BasicGame {
    
    private Image start_image = null;
    
    public QuestMaker () throws SlickException {
        super("GFGame-QuestMaker");
    }

    public static void main(String[] args) throws SlickException {
         AppGameContainer app = new AppGameContainer(new QuestMaker());
         //Dies ist JuKus erster Kommentar in dieser Datei. ;-)
         app.setDisplayMode(800, 600, false);
         app.start();
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        //
    }

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        //
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        //
    }
    
}
