@echo off
echo Downloading files from ngocnghia81/Fitnesse repository...

rem Tạo thư mục tạm
mkdir temp-download
cd temp-download

rem Tải xuống repository
echo Cloning repository...
git clone https://github.com/ngocnghia81/Fitnesse.git
cd Fitnesse

rem Tạo thư mục fitnesse nếu chưa tồn tại
echo Creating fitnesse directory...
if not exist ..\..\fitnesse mkdir ..\..\fitnesse

rem Copy file jar và users.db
echo Copying files...
copy fitnesse-standalone.jar ..\..\fitnesse\
copy users.db ..\..\

rem Copy thư mục FitNesseRoot nếu cần
echo Do you want to copy FitNesseRoot folder? (Y/N)
set /p input=
if /i "%input%"=="Y" (
    echo Copying FitNesseRoot folder...
    xcopy /E /I /Y FitNesseRoot ..\..\src\test\fitnesse\FitNesseRoot
)

rem Quay lại thư mục gốc và dọn dẹp
cd ..\..
rmdir /S /Q temp-download

echo Done! Files have been downloaded from https://github.com/ngocnghia81/Fitnesse 