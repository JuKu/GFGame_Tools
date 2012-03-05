//QuestMaker 1.0 Version: 1.0

//import org.newdawn.slick.Image;
//import org.newdawn.slick.SlickException;

public class test extends Quest {

//test
public test (Player player, Items items)/* throws SlickException*/ {

super(player, items);
//Questimage[0] = new Image("GameData/Cache/Quests/image.png");

Questhinweis = "mouseOver-Text";

}

@Override
public void update () {

System.out.println("test");

}

public static void main (String args[]) {
	System.out.println("Methode main().");
}

@Override
public void reward () {

System.out.println("reward.");

}

}