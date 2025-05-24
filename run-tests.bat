@echo off
echo Running FitNesse test suite...

rem Create directories if they don't exist
if not exist "target\classes" mkdir target\classes
if not exist "fitnesse" mkdir fitnesse
if not exist "target\fitnesse-results" mkdir target\fitnesse-results

rem Compile fixtures if needed
call compile-fixtures.bat

rem Check if FitNesse jar exists, download if not
if not exist "fitnesse\fitnesse-standalone.jar" (
    echo Downloading FitNesse...
    call get-fitnesse-from-nghia.bat
)

rem Set up classpath properties
echo CLASSPATH=fitnesse/fitnesse-standalone.jar:target/classes:target/dependencies/* > plugins.properties
echo Test.CLASSPATH=fitnesse/fitnesse-standalone.jar:target/classes:target/dependencies/* >> plugins.properties

rem Try first path format
echo Running tests with direct path...
java -jar fitnesse\fitnesse-standalone.jar -c "CalculatorTests?suite&format=junit" -d . -r src/test/fitnesse -p 9125 -o -f plugins.properties -b target\fitnesse-results\result.xml

if exist "target\fitnesse-results\result.xml" (
    echo Test results file was created successfully
) else (
    echo Test results file was not created, trying alternate path
    java -jar fitnesse\fitnesse-standalone.jar -c "FitNesseRoot.CalculatorTests?suite&format=junit" -d . -r src/test/fitnesse -p 9125 -o -f plugins.properties -b target\fitnesse-results\result2.xml
    
    if exist "target\fitnesse-results\result2.xml" (
        copy target\fitnesse-results\result2.xml target\fitnesse-results\result.xml
        echo Test results generated using alternate path
    ) else (
        echo Both test paths failed
    )
)

echo Test execution completed
if exist "target\fitnesse-results\result.xml" (
    echo Results saved to target\fitnesse-results\result.xml
) 