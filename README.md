# Simple Calculator Project

Đây là một dự án đơn giản để demo CI/CD với GitHub Actions.

## Cấu trúc dự án

- `src/main/java/com/example/Calculator.java`: Class Calculator với các chức năng cơ bản
- `src/test/java/com/example/CalculatorTest.java`: Test cho Calculator

## CI/CD

Dự án này sử dụng GitHub Actions để tự động hóa quy trình CI/CD. Mỗi khi có commit hoặc pull request vào nhánh `main` hoặc `master`, workflow sau sẽ được kích hoạt:

1. Checkout code
2. Cài đặt JDK 11
3. Build dự án với Maven
4. Chạy các test
5. Lưu trữ kết quả test

## Cách chạy dự án cục bộ

```bash
# Clone repository
git clone https://github.com/your-username/simple-calculator.git
cd simple-calculator

# Build với Maven
mvn clean install

# Chạy test
mvn test
```

## Cách đóng góp

1. Fork repository
2. Tạo nhánh mới: `git checkout -b feature/your-feature-name`
3. Commit các thay đổi: `git commit -m 'Add some feature'`
4. Push lên nhánh của bạn: `git push origin feature/your-feature-name`
5. Tạo Pull Request 