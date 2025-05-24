#!/bin/bash
echo "Fixing FitNesse directory structure..."

# Create link in FitNesseRoot for all files in the root CalculatorTests directory
if [ -d "src/test/fitnesse/CalculatorTests" ]; then
    echo "Found CalculatorTests in root directory, ensuring all tests are in FitNesseRoot"
    
    # Ensure FitNesseRoot/CalculatorTests exists
    mkdir -p "src/test/fitnesse/FitNesseRoot/CalculatorTests"
    
    # Copy content.txt if needed
    if [ -f "src/test/fitnesse/CalculatorTests/content.txt" ]; then
        cp "src/test/fitnesse/CalculatorTests/content.txt" "src/test/fitnesse/FitNesseRoot/CalculatorTests/content.txt"
        echo "Copied content.txt"
    fi
    
    # Copy all test directories
    for dir in src/test/fitnesse/CalculatorTests/*/; do
        if [ -d "$dir" ]; then
            dir_name=$(basename "$dir")
            if [ ! -d "src/test/fitnesse/FitNesseRoot/CalculatorTests/$dir_name" ]; then
                echo "Copying $dir_name directory"
                cp -r "$dir" "src/test/fitnesse/FitNesseRoot/CalculatorTests/$dir_name"
            fi
        fi
    done
fi

echo "Directory structure fix completed"
echo "You should now be able to run FitNesse with either path format" 