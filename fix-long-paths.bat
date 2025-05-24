@echo off
echo Fixing long path issues for Git...

rem Bật hỗ trợ đường dẫn dài trong Git
git config --system core.longpaths true

rem Loại bỏ các file có đường dẫn quá dài khỏi Git staging
git rm --cached -r src/test/fitnesse/FitNesseRoot/FitNesse

rem Chỉ thêm các file quan trọng
git add src/test/fitnesse/FitNesseRoot/CalculatorTests
git add .github
git add pom.xml
git add README.md
git add *.bat
git add *.sh
git add .gitignore

echo Done! Now you can commit with: git commit -m "Your message" 