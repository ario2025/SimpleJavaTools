rmdir -rf target
mkdir target
clear
echo Minimalist Java Tools.
javac -d target src/java/*.java
cd target
jar cfm start.jar ../manifest.mf *.class
rm *.class
java -jar start.jar

