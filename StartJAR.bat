REM @ECHO OFF
MD Target
CLS
ECHO Minimalism Java Tools.
javac -d target src/java/*.java
CD Target
jar cfm start.jar ../manifest.mf *.class
java -jar start.jar
PAUSE
EXIT