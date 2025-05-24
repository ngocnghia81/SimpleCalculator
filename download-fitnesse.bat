@echo off
echo Downloading FitNesse standalone JAR...

mkdir fitnesse
powershell -Command "Invoke-WebRequest -Uri 'https://github.com/fitnesse/fitnesse/releases/download/v20221219/fitnesse-standalone.jar' -OutFile 'fitnesse/fitnesse-standalone.jar'"

echo Download complete. FitNesse JAR saved to fitnesse/fitnesse-standalone.jar 