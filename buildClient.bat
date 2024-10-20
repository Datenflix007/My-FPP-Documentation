@echo off
REM Kompiliere Java-Dateien
echo Kompiliere Java-Dateien...
REM mkdir classes
javac -d classes src/*.java

cd classes/
REM Erstelle die Manifestdatei
REM echo Main-Class: Client > ClientManifest.txt

REM Erstelle die JAR-Datei im Verzeichnis der .class-Dateien und füge die Manifestdatei hinzu

jar cfm Client.jar ClientManifest.txt *.class

REM Überprüfe, ob die JAR-Datei erfolgreich erstellt wurde
if exist Client.jar (
    echo JAR-Datei Server.jar wurde erfolgreich erstellt.
) else (
    echo Fehler beim Erstellen der JAR-Datei!
)

REM Starte den Client
echo Starte Client...
java -jar Client.jar

cd ../
pause
