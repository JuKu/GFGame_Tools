//QuestMaker 1.0 Version: 1.0

//import net.generationfuture.game.Items;
//import net.generationfuture.game.Player;
//import net.generationfuture.game.Quest;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class test2 extends Quest {

//test
public test2 (Player player, Items items) throws SlickException {

super(player, items);
Questimage[0] = new Image("GameData/Cache/Quests/image.png");

Questhinweis = "mouseOver-Text";

}

@Override
public void update () {

System.out.println("test");

}

@Override
public void reward () {

System.out.println("reward.");

}

}