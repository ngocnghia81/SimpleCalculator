@echo off
echo Compiling Java fixtures...

rem Tạo thư mục cho classes biên dịch
mkdir target\classes

rem Biên dịch tất cả file Java trong src/main/java
javac -d target\classes src\main\java\com\example\*.java src\main\java\com\example\fixtures\*.java

echo Compilation complete. Class files saved to target\classes 