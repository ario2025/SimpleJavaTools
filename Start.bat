@ECHO OFF

MD Target

CLS

ECHO Minimalism Java Tools.

REM javac -d target -cp "./;" src/java/*.java

javac -d target src/java/*.java

CD Target

java start

REM jar cfm start.jar ../manifest.mf start start.class

REM java -jar start.jar

PAUSE

EXIT