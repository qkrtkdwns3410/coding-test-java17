# Java 17 코딩테스트

IntelliJ에서 이 폴더를 열고 Gradle 프로젝트로 가져오세요.
Gradle JVM 및 Project SDK는 설치된 JDK 17을 사용하세요.

- `src/main/java/Solution.java`: 프로그래머스/Codility 제출용 풀이. 문제에 맞게 메서드 시그니처를 바꾸세요.
- `src/main/java/Main.java`: 예제 입력을 직접 넣어 실행하는 로컬 진입점.
- `gradlew.bat run --console=plain`: 실행
- `gradlew.bat clean build`: 빌드

외부 라이브러리 없이 Java 17 표준 라이브러리만 사용합니다.
PC별 JDK 경로를 담는 `gradle.properties`는 Git에서 제외됩니다. 다른 PC에서는 JDK 17 설치 후 IntelliJ의 Gradle JVM을 설정하세요.