package com.springdemo.n01firstproject;

import com.springdemo.n01firstproject.game.GameRunner;
import com.springdemo.n01firstproject.game.MarioGame;

public class AppGamingBasicJava {
  public static void main(String[] args) {

    var marioGame = new MarioGame();
    var gameRunner = new GameRunner(marioGame);
    gameRunner.run();

  }
}
