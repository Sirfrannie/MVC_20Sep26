#!/bin/bash

# Compile the Java file
javac -cp ".:lib/sqlite-jdbc-3.50.3.0.jar" *.java mypack/*.java

# Check if the compilation was successful
if [ $? -eq 0 ]; then
    # run 
    echo "Running Main..."
    java -cp ".:lib/sqlite-jdbc-3.50.3.0.jar" Main
else
    echo "Compilation failed"
fi
