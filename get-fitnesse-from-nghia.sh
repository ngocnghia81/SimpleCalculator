#!/bin/bash
echo "Downloading FitNesse standalone JAR from ngocnghia81 repository..."

mkdir -p fitnesse
curl -L -o fitnesse/fitnesse-standalone.jar https://github.com/ngocnghia81/Fitnesse/raw/main/fitnesse-standalone.jar

echo "Download complete. FitNesse JAR saved to fitnesse/fitnesse-standalone.jar" 