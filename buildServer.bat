@echo off
REM Kompiliere Java-Dateien
echo Kompiliere Java-Dateien...
REM mkdir classes
javac -d classes src/*.java

cd classes/
REM Erstelle die Manifestdatei
REM echo Main-Class: Server > ServerManifest.txt

REM Erstelle die JAR-Datei im Verzeichnis der .class-Dateien und füge die Manifestdatei hinzu

jar cfm Server.jar ServerManifest.txt *.class

REM Überprüfe, ob die JAR-Datei erfolgreich erstellt wurde
if exist Server.jar (
    echo JAR-Datei Server.jar wurde erfolgreich erstellt.
) else (
    echo Fehler beim Erstellen der JAR-Datei!
)

REM Starte den Server
echo Starte Server...
java -jar Server.jar

cd ../
pause
