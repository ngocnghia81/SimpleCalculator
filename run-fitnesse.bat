@echo off
echo Starting FitNesse server...
echo Visit http://localhost:9124/CalculatorTests to view and run tests

rem Không cần biên dịch vì đã làm thủ công
rem call mvn clean compile -DskipTests

rem Chạy FitNesse với classpath trỏ đến các lớp đã biên dịch
java -jar D:\workspace\university\Nam3_HK2\KiemDinhPhanMem\Fitnesse\fitnesse-standalone.jar -p 9124 -d src/test/fitnesse 