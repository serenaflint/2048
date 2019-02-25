Serena Flint
Partner: Jayda Medina

sflint3@u.rochester.edu
=======================================
Project 1: 2048

Run.java: Used to run the game!

Colors.java: Contains all (most) of the colors used in the game, and themes
Display.java: Contains the paintComponent, draws different aspects of the game
Engine.java: Contains all of the game controls, states, formatting, and specific graphics components
HighScores.java: Contains methods for saving and pulling high scores
Sound.java: Contains methods for playing and stopping music/sounds
TextGame.java: Contains the methods for the fundamental game mechanics (moving in a direction, etc.)
Write.java: Contains the methods for writing to and reading files

background.wav: background music!
click.wav: sound file
highscores.txt: contains all of the high scores written from trials across saves


Paths: ...\serenaflint_jaydamedina_2048\src\Run.java
      ...\serenaflint_jaydamedina_2048\src\Colors.java
      ...
      (all .java files follow this format)
      ...
      ...\serenaflint_jaydamedina_2048\background.wav
      ...\serenaflint_jaydamedina_2048\click.wav
      ...\serenaflint_jaydamedina_2048\highscores.txt



=======================================

How to Compile and Run:

Import the serenaflint_jaydamedina_2048 folder into Eclipse as a project and run Run.java!

NOTE: The graphical game will likely be a little larger, but completely playable on 1920x1080 displays.
      (Testing was done using both 3840x2160 and 1920x1080 displays, and both worked fine)

NOTE: If the sound doesn't work, it's almost definitely a path issue, but it worked when I tested it in Eclipse.
=======================================

Controls: 

-Use the arrow keys or W, A, S, D keys to move the tiles in their respective directions
-Press Q to quit, R to restart, and Y or N to confirm or deny

General Features (Text Game):

-Displays the updated board each turn
-Displays the total number of valid moves made, key pressed, maximum tile, and score after each turn
-Displays the GAME OVER when the game has ended

General Features (Graphical Game):

-A clean graphical implementation of the textgame, heavily influenced on the style of the original game
-A main menu with Play Game, High Score, and Options choices
-Ambeint music and sounds when clicking buttons
-Returning to the main menu during a game will NOT reset the board
	-Resetting the board like this would be too close to restarting
-After you win, you can continue playing until you no longer have valid moves available
-You can quit at any time using Q or by exitting the window
	-NOTE: The score will not be saved if you quit before the game is over!
-Displays and actively updates the current score
	-The score is based off of what I observed the orginal to use, adding the total of all merged 
	 tiles to the score
-Can restart using the button next to the score
-High Scores are saved across terminations of the game, and are automatically saved upon a game over or restart
	-Displaying scores REQUIRES 10 scores to be in the text file, but will generate additional scores of 
	 "00000" to meet this quota if necessary

Options Menu:
-Can change color themes!
-Can turn on or off music
-Can turn on or off sound effects


