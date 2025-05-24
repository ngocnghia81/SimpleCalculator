#!/bin/bash
echo "Compiling Java fixtures..."

# Tạo thư mục cho classes biên dịch
mkdir -p target/classes

# Biên dịch tất cả file Java trong src/main/java
find src/main/java -name "*.java" | xargs javac -d target/classes

echo "Compilation complete. Class files saved to target/classes" 