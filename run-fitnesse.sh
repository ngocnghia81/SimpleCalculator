#!/bin/bash
echo "Starting FitNesse server..."
echo "Visit http://localhost:9125/CalculatorTests to view and run tests"

# Biên dịch project
mvn clean compile

# Chạy FitNesse với classpath
java -jar ./fitnesse/fitnesse-standalone.jar -p 9125 -d src/test/fitnesse 