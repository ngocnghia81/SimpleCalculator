#!/bin/bash
echo "Downloading FitNesse standalone JAR..."

mkdir -p fitnesse
curl -L -o fitnesse/fitnesse-standalone.jar https://github.com/fitnesse/fitnesse/releases/download/v20221219/fitnesse-standalone.jar

echo "Download complete. FitNesse JAR saved to fitnesse/fitnesse-standalone.jar" 