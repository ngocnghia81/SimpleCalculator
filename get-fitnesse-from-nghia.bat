@echo off
echo Downloading FitNesse standalone JAR from ngocnghia81 repository...

mkdir fitnesse
powershell -Command "Invoke-WebRequest -Uri 'https://github.com/ngocnghia81/Fitnesse/raw/main/fitnesse-standalone.jar' -OutFile 'fitnesse/fitnesse-standalone.jar'"

echo Download complete. FitNesse JAR saved to fitnesse/fitnesse-standalone.jar 