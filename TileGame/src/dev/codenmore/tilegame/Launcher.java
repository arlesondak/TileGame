package dev.codenmore.tilegame;

import dev.codenmore.tilegame.Game;


public class Launcher {

	public static void main(String[] args){
		Game game = new Game("Tile Game!", 500, 650);
		game.start();
	}
	
}