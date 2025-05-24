@echo off
echo Starting FitNesse server...
echo Visit http://localhost:9125/CalculatorTests to view and run tests

rem Biên dịch project
call mvn clean compile

rem Tạo thư mục fitnesse nếu chưa tồn tại
if not exist fitnesse mkdir fitnesse

rem Kiểm tra xem file jar đã tồn tại chưa
if not exist fitnesse\fitnesse-standalone.jar (
    echo FitNesse JAR not found. Downloading...
    call download-fitnesse.bat
)

rem Chạy FitNesse với classpath
java -Xdebug -Dfitnesse.development.set.classpath=true -Dfitnesse.debug.classpath=true -jar fitnesse\fitnesse-standalone.jar -p 9125 -d src/test/fitnesse 