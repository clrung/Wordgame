#Wordgame
I wrote this word game for an Algorithms class at Bucknell.  The program uses [Dijkstra’s algorithm](http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm) to find the shortest “distance” between two five-letter words.  If the words have two different characters in the same position, they are assigned a distance of 5.  If they have only one different character, they are assigned a distance of 1.  For example, the distance between “wor**d**s” and “wor**m**s” is 1, and the distance between “**w**o**r**ds” and “**r**o**a**ds” is 5 (emphasis added to unlike characters).

There are two games to play.  The first game lists all of the neighbors of a given word (words that have a distance of 1 or 5), and the second game will find the shortest path from one word to another.  For example, the shortest path from "grape" to "grads" is 2 points; grape > grade > grads. 

##Usage
First, compile the java source files and send the compiled class files to the bin directory.

```
javac ./src/* -d bin/
```

Next, cd into the bin directory, and run the WordGame driver, supplying it with a dictionary file as an argument.  A dictionary file simply contains a list of I have included a dictionary file, dictionary.dat, in the root of this project.

```
cd bin
java WordgameDriver ../dictionary.dat
```

You may also use the included setup script to compile and run the game.

```
cd Wordgame
./setup.sh
```