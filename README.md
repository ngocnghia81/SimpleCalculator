# Simple Calculator Project với FitNesse và GitHub Actions CI/CD

Đây là một dự án mẫu sử dụng FitNesse để kiểm thử và GitHub Actions để tích hợp CI/CD.

## Cấu trúc dự án

- `src/main/java/com/example/Calculator.java`: Class Calculator với các chức năng cơ bản
- `src/main/java/com/example/fixtures/`: FitNesse fixtures cho testing
- `src/test/java/com/example/CalculatorTest.java`: JUnit tests cho Calculator
- `src/test/fitnesse/`: Wiki pages của FitNesse và test specifications
- `src/test/java/com/example/FitNesseRunner.java`: Runner để chạy FitNesse tests từ JUnit
- `.github/workflows/fitnesse-ci.yml`: Cấu hình GitHub Actions CI/CD

## FitNesse Tests

Dự án này sử dụng FitNesse để kiểm thử chức năng thông qua các bảng dữ liệu (tables) dễ đọc, dễ viết. Các tests được tổ chức trong thư mục `src/test/fitnesse/` và bao gồm:

- `CalculatorTests/SimpleTest`: Test đơn giản nhất cho Calculator
- `CalculatorTests/AdditionTest`: Kiểm tra chức năng cộng
- `CalculatorTests/SubtractionTest`: Kiểm tra chức năng trừ
- `CalculatorTests/MultiplicationTest`: Kiểm tra chức năng nhân
- `CalculatorTests/DivisionTest`: Kiểm tra chức năng chia
- `CalculatorTests/AllOperationsTest`: Kiểm tra tất cả các phép tính
- `CalculatorTests/DecisionTableTest`: Sử dụng bảng quyết định
- `CalculatorTests/ScenarioTest`: Sử dụng kịch bản BDD
- `CalculatorTests/ErrorHandlingTest`: Kiểm tra xử lý lỗi

## CI/CD với GitHub Actions

Dự án này sử dụng GitHub Actions để tự động hóa quy trình CI/CD. Mỗi khi có commit hoặc pull request vào nhánh `main` hoặc `master`, workflow sau sẽ được kích hoạt:

1. **Checkout code**: Lấy mã nguồn từ repository
2. **Set up JDK 11**: Cài đặt môi trường Java
3. **Build với Maven**: Biên dịch mã nguồn
4. **Download FitNesse**: Tải FitNesse standalone jar
5. **Run FitNesse Tests**: Chạy bộ test FitNesse và xuất kết quả sang định dạng JUnit XML
6. **Upload Test Results**: Lưu trữ kết quả test dưới dạng artifact
7. **Publish Test Report**: Xuất bản báo cáo test trong GitHub

### Lợi ích của CI/CD với FitNesse

- **Phát hiện lỗi sớm**: Tự động kiểm tra mỗi khi có thay đổi
- **Đảm bảo chất lượng**: Yêu cầu tất cả test phải pass
- **Tài liệu sống**: FitNesse tests đóng vai trò như tài liệu chức năng
- **Báo cáo trực quan**: Kết quả test được hiển thị trực quan trong GitHub

## Cách chạy dự án cục bộ

```bash
# Clone repository
git clone https://github.com/ngocnghia81/SimpleCalculator
cd simple-calculator

# Build với Maven
mvn clean compile

# Chạy FitNesse server
# Windows:
.\run-fitnesse2.bat

# Linux/macOS:
./run-fitnesse.sh
```

Sau khi chạy FitNesse server, bạn có thể truy cập FitNesse qua trình duyệt tại địa chỉ:
http://localhost:9125/CalculatorTests

## Thêm test mới

1. Tạo file content.txt trong thư mục `src/test/fitnesse/FitNesseRoot/CalculatorTests/YourNewTest`
2. Thêm nội dung theo mẫu:
```
!define TEST_SYSTEM {slim}
!path D:/your-project-path/target/classes

|script|com.example.fixtures.CalculatorFixture|
|set first number|10|
|set second number|5|
|add|
|check|result|17|
```
3. Tạo file properties.xml với thuộc tính Test=true

## Cách đóng góp

1. Fork repository
2. Tạo nhánh mới: `git checkout -b feature/your-feature-name`
3. Commit các thay đổi: `git commit -m 'Add some feature'`
4. Push lên nhánh của bạn: `git push origin feature/your-feature-name`
5. Tạo Pull Request 