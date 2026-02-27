# CodeWars Katas (Java)

## About
Java solutions for CodeWars challenges.

## Tech Stack
- Java 17
- JUnit 5 (parameterized tests)
- Gradle
- Allure Reports
- GitHub Actions

## Structure
src/
├── main/java/com/github/anastasiia/smotritskaya/katas/ # solutions
└── test/java/com/github/anastasiia/smotritskaya/katas/ # tests

## Testing
```bash
./gradlew test
./gradlew allureServe