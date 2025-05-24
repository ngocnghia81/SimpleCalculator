#!/bin/bash
echo "Running FitNesse test suite..."

# Create directories if they don't exist
mkdir -p target/classes
mkdir -p fitnesse
mkdir -p target/fitnesse-results

# Compile fixtures
echo "Compiling fixtures..."
if [ -f "compile-fixtures.sh" ]; then
    bash compile-fixtures.sh
else
    javac -cp "fitnesse/fitnesse-standalone.jar:target/classes" -d target/classes $(find src/main/java -name "*.java")
fi

# Check if FitNesse jar exists, download if not
if [ ! -f "fitnesse/fitnesse-standalone.jar" ]; then
    echo "Downloading FitNesse..."
    if [ -f "get-fitnesse-from-nghia.sh" ]; then
        bash get-fitnesse-from-nghia.sh
    else
        wget -O fitnesse/fitnesse-standalone.jar https://github.com/ngocnghia81/Fitnesse/raw/main/fitnesse-standalone.jar
    fi
fi

# Set up classpath properties
echo "CLASSPATH=fitnesse/fitnesse-standalone.jar:target/classes:target/dependencies/*" > plugins.properties
echo "Test.CLASSPATH=fitnesse/fitnesse-standalone.jar:target/classes:target/dependencies/*" >> plugins.properties

# Try both path formats
echo "Running tests with direct path..."
java -jar fitnesse/fitnesse-standalone.jar -c "CalculatorTests?suite&format=junit" -d . -r src/test/fitnesse -p 9125 -o -f plugins.properties -b target/fitnesse-results/result.xml || true

if [ -f "target/fitnesse-results/result.xml" ]; then
    echo "Test results file was created successfully"
else
    echo "Test results file was not created, trying alternate path"
    java -jar fitnesse/fitnesse-standalone.jar -c "FitNesseRoot.CalculatorTests?suite&format=junit" -d . -r src/test/fitnesse -p 9125 -o -f plugins.properties -b target/fitnesse-results/result2.xml || true
    if [ -f "target/fitnesse-results/result2.xml" ]; then
        cp target/fitnesse-results/result2.xml target/fitnesse-results/result.xml
        echo "Test results generated using alternate path"
    else
        echo "Both test paths failed"
    fi
fi

echo "Test execution completed"
if [ -f "target/fitnesse-results/result.xml" ]; then
    echo "Results saved to target/fitnesse-results/result.xml"
fi 