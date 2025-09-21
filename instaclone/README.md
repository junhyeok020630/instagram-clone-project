# Instagram Clone Project

### 프로젝트 소개
이 프로젝트는 Spring Boot를 사용하여 구현한 Instagram 클론 웹 애플리케이션입니다. 사용자 인증, 게시물 관리, 팔로우, 좋아요, 댓글, 검색 등 Instagram의 핵심 기능을 제공합니다.

### 주요 기능
* **사용자 인증**: 회원가입 및 Spring Security를 활용한 로그인, 로그아웃 기능.
* **프로필 관리**: 사용자 프로필 페이지에서 게시물 수, 팔로워/팔로잉 수 확인이 가능하며, 프로필 정보 및 사진을 수정할 수 있습니다.
* **게시물 관리**: 게시물 업로드, 수정, 삭제 기능.
* **소셜 기능**:
    * 다른 사용자를 팔로우하거나 언팔로우할 수 있습니다.
    * 피드와 인기 페이지에서 게시물에 '좋아요'를 누르거나 취소할 수 있습니다.
    * 게시물에 댓글을 추가하고 삭제할 수 있습니다.
* **콘텐츠 탐색**:
    * 사용자의 팔로잉 목록에 있는 사용자의 게시물을 보여주는 메인 피드.
    * 해시태그를 통해 게시물을 검색하는 기능.
    * 가장 많은 '좋아요'를 받은 인기 게시물을 보여주는 페이지.
    * 좋아요를 누른 게시물 목록을 볼 수 있는 페이지.

### 기술 스택
* **백엔드**: Java 17, Spring Boot, Spring Security, Spring Data JPA
* **데이터베이스**: MySQL
* **템플릿 엔진**: Thymeleaf
* **프론트엔드**: HTML, CSS, JavaScript (jQuery)
* **빌드 도구**: Gradle

### 실행 방법
1.  **프로젝트 클론**:
    ```bash
    git clone junhyeok020630/instagram-clone-project.git
    cd instagram-clone-project/instaclone
    ```

2.  **의존성 설치**:
    * 프로젝트는 Gradle을 사용합니다. `build.gradle` 파일에 명시된 의존성을 자동으로 다운로드합니다.

3.  **데이터베이스 설정**:
    * MySQL 서버를 실행하고 `instagram`이라는 이름의 데이터베이스를 생성합니다.
    * `src/main/resources/application.properties` 파일을 열어 MySQL 사용자 이름과 비밀번호를 환경에 맞게 수정합니다.
        ```properties
        spring.datasource.username=root
        spring.datasource.password=root
        spring.datasource.url=jdbc:mysql://localhost:3306/instagram
        ```
    * JPA 설정에 따라 애플리케이션 실행 시 테이블이 자동 생성되도록 설정되어 있습니다 (`spring.jpa.hibernate.ddl-auto=none`).

4.  **애플리케이션 실행**:
    * `InstacloneApplication.java` 파일을 실행합니다.
    * 터미널에서 다음 명령어를 사용해 애플리케이션을 실행할 수도 있습니다.
        ```bash
        ./gradlew bootRun
        ```

5.  **접속**:
    * 웹 브라우저에서 `http://localhost:8080`으로 접속하여 애플리케이션을 사용할 수 있습니다.

### 제작자
* kksc