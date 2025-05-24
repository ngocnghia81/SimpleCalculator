@echo off
echo Starting FitNesse server...
echo Visit http://localhost:9124/FitNesseRoot/CalculatorTests to view and run tests

rem Create directories if they don't exist
if not exist "target\classes" mkdir target\classes
if not exist "fitnesse" mkdir fitnesse
if not exist "target\fitnesse-results" mkdir target\fitnesse-results

rem Compile fixtures if needed
call compile-fixtures.bat

rem Start FitNesse with classpath pointing to compiled classes
java -jar fitnesse\fitnesse-standalone.jar -p 9124 -d . -r src/test/fitnesse -f plugins.properties 