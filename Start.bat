@ECHO OFF
RMDIR /S/Q TARGET
MD target
CLS
ECHO Minimalism Java Tools.
javac -d target src/java/*.java
CD target
java start
PAUSE
EXIT