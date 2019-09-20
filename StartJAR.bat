@ECHO OFF
RMDIR /S/Q TARGET
MD target
CLS
ECHO Minimalism Java Tools.
javac -d target src/java/*.java
CD Target
jar cfm start.jar ../manifest.mf *.class
del *.class
java -jar start.jar
PAUSE
EXIT