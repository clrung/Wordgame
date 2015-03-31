#!/bin/bash

echo Removing java class files…
rm -rf ./bin/
echo Done

echo Compiling java src files…
mkdir bin
javac ./src/* -d bin/
echo Done

while true; do
    read -p "Would you like to play the Wordgame now with the default dictionary? (Y/n) " yn
    case $yn in
        [Yy]* ) cd ./bin; java WordgameDriver ../dictionary.dat; break;;
        [Nn]* ) exit;;
        * ) echo "Please answer yes or no.";;
    esac
done

exit 1