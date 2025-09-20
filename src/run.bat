REM CHAT-GPT generated script
REM not sure will it work
REM if not, please complie Main.java manually


@echo off
REM Compile the Java files (including those in mypack)
javac -cp ".;lib/sqlite-jdbc-3.50.3.0.jar" *.java mypack\*.java

REM Check if the compilation was successful
if %errorlevel%==0 (
    echo Running Main...
    java -cp ".;lib/sqlite-jdbc-3.50.3.0.jar" Main
) else (
    echo Compilation failed
)

pause
