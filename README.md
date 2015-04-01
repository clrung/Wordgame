# Wordgame
I wrote this two-part word game for an Algorithms class at Bucknell.  The first game lists all of the neighbors(words that have a distance of 1 or 5) of a given five letter word.  The second game uses [Dijkstra’s algorithm](http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm) to find the shortest path between two five letter words.  For example, the shortest path from "grape" to "grads" is 2 points; Dijkstra's algorithm would traverse through gra**p**e > gra**d**e > grad**s** on the graph. 

A provided dictionary file (a text file containing a list of words) is used to create the graph data structure.  The graph's edges' distances are computed as follows:

* If the words have two different characters in the same position, the edge connecting them is assigned a distance of 5.
* If the words have only one different character in the same position, the edge connecting them is assigned a distance of 1.

For example, the distance between “wor**d**s” and “wor**m**s” is 1, and the distance between “**w**o**r**ds” and “**r**o**a**ds” is 5 (emphasis added to unlike characters).

## Usage
First, compile the java source files and send the compiled class files to a bin directory.

```
$ mkdir bin
$ javac ./src/* -d bin/
```

Next, cd into the bin directory, and run the WordGame driver, supplying it with a dictionary file as an argument.  A dictionary file simply contains the list of possible words.  I have included a sample 8938-word dictionary file, dictionary.dat, in the root of this project.

```
$ cd bin
$ java WordgameDriver ../dictionary.dat
```

You may also use the included setup script to compile and run the game.

```
$ cd Wordgame
$ ./setup.sh
```