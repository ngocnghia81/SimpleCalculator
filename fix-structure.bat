@echo off
echo Fixing FitNesse directory structure...

rem Create link in FitNesseRoot for all files in the root CalculatorTests directory
if exist "src\test\fitnesse\CalculatorTests" (
    echo Found CalculatorTests in root directory, ensuring all tests are in FitNesseRoot
    
    rem Ensure FitNesseRoot/CalculatorTests exists
    if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests" (
        mkdir "src\test\fitnesse\FitNesseRoot\CalculatorTests"
    )
    
    rem Copy content.txt if needed
    if exist "src\test\fitnesse\CalculatorTests\content.txt" (
        copy "src\test\fitnesse\CalculatorTests\content.txt" "src\test\fitnesse\FitNesseRoot\CalculatorTests\content.txt" /Y
        echo Copied content.txt
    )
    
    rem Copy all test directories - list them specifically to avoid issues with variable expansion
    if exist "src\test\fitnesse\CalculatorTests\AdditionTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\AdditionTest" (
            echo Copying AdditionTest directory
            xcopy "src\test\fitnesse\CalculatorTests\AdditionTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\AdditionTest" /E /I /Y
        )
    )
    
    if exist "src\test\fitnesse\CalculatorTests\SubtractionTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\SubtractionTest" (
            echo Copying SubtractionTest directory
            xcopy "src\test\fitnesse\CalculatorTests\SubtractionTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\SubtractionTest" /E /I /Y
        )
    )
    
    if exist "src\test\fitnesse\CalculatorTests\MultiplicationTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\MultiplicationTest" (
            echo Copying MultiplicationTest directory
            xcopy "src\test\fitnesse\CalculatorTests\MultiplicationTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\MultiplicationTest" /E /I /Y
        )
    )
    
    if exist "src\test\fitnesse\CalculatorTests\DivisionTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\DivisionTest" (
            echo Copying DivisionTest directory
            xcopy "src\test\fitnesse\CalculatorTests\DivisionTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\DivisionTest" /E /I /Y
        )
    )
    
    if exist "src\test\fitnesse\CalculatorTests\AllOperationsTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\AllOperationsTest" (
            echo Copying AllOperationsTest directory
            xcopy "src\test\fitnesse\CalculatorTests\AllOperationsTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\AllOperationsTest" /E /I /Y
        )
    )
    
    if exist "src\test\fitnesse\CalculatorTests\DecisionTableTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\DecisionTableTest" (
            echo Copying DecisionTableTest directory
            xcopy "src\test\fitnesse\CalculatorTests\DecisionTableTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\DecisionTableTest" /E /I /Y
        )
    )
    
    if exist "src\test\fitnesse\CalculatorTests\ErrorHandlingTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\ErrorHandlingTest" (
            echo Copying ErrorHandlingTest directory
            xcopy "src\test\fitnesse\CalculatorTests\ErrorHandlingTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\ErrorHandlingTest" /E /I /Y
        )
    )
    
    if exist "src\test\fitnesse\CalculatorTests\SimpleTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\SimpleTest" (
            echo Copying SimpleTest directory
            xcopy "src\test\fitnesse\CalculatorTests\SimpleTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\SimpleTest" /E /I /Y
        )
    )
    
    if exist "src\test\fitnesse\CalculatorTests\ScenarioTest" (
        if not exist "src\test\fitnesse\FitNesseRoot\CalculatorTests\ScenarioTest" (
            echo Copying ScenarioTest directory
            xcopy "src\test\fitnesse\CalculatorTests\ScenarioTest" "src\test\fitnesse\FitNesseRoot\CalculatorTests\ScenarioTest" /E /I /Y
        )
    )
)

echo Directory structure fix completed
echo You should now be able to run FitNesse with either path format 