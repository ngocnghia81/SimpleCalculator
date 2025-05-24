#!/bin/bash
echo "Downloading files from ngocnghia81/Fitnesse repository..."

# Tạo thư mục tạm
mkdir -p temp-download
cd temp-download

# Tải xuống repository
echo "Cloning repository..."
git clone https://github.com/ngocnghia81/Fitnesse.git
cd Fitnesse

# Tạo thư mục fitnesse
echo "Creating fitnesse directory..."
mkdir -p ../../fitnesse

# Copy file jar và users.db
echo "Copying files..."
cp fitnesse-standalone.jar ../../fitnesse/
cp users.db ../../

# Copy thư mục FitNesseRoot nếu cần
echo "Do you want to copy FitNesseRoot folder? (Y/N)"
read input
if [[ $input == "Y" || $input == "y" ]]; then
    echo "Copying FitNesseRoot folder..."
    mkdir -p ../../src/test/fitnesse
    cp -r FitNesseRoot ../../src/test/fitnesse/
fi

# Quay lại thư mục gốc và dọn dẹp
cd ../..
rm -rf temp-download

echo "Done! Files have been downloaded from https://github.com/ngocnghia81/Fitnesse" 