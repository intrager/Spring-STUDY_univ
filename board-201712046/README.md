## 학기말 프로젝트

### 개요
> 회원제 게시판을 통해서 클라이언트와 서버의 요청 흐름을 Service/Repository 계층을 이해하고,
 JPA를 이용하여 DTO/Entity로 분리해 영속 객체의 생명주기를 효율적으로 관리하는 법을 배운 프로젝트입니다.
> 
> Querydsl을 이용하여 JPA에서의 한정적인 쿼리 작업에서 벗어나, 동적인 쿼리 작성의 이점을 실감할 수 있었습니다.
> 
> 또한, MyBatis와 다르게, SQL 쿼리를 코드로 작성함으로써, 컴파일 시점에 문법 오류를 쉽게 잡을 수 있다는 것을 배웠습니다.

### 기능
#### 세션을 통한 회원제 게시판
- 기본적인 회원 가입/로그인, 이를 이용한 게시글 CRUD 기능
- 관리자와 일반 사용자 분리
  - 회원 목록
    - 회원 단계 혹은 주소, 전화번호, 이름을 통한 검색
  - 회원 차단 및 그에 따른 게시글 차단
- 게시글 
  - 게시글 조회수 처리
  - 목록(페이지네이션)처리
  - 카테고리별 분류 기능
  
### 기술 스택
- IntelliJ IDEA
- JDK 11
- Gradle 7.4.1
- Spring Boot 2.6.8
  - Boot Starter
    - Data JPA
      - Querydsl 5.0.0
- Thymeleaf 3.0.15

### 로그인 전 메뉴창
![image](https://user-images.githubusercontent.com/77195486/197456972-d398b29a-0013-4b5e-927a-38587aa9baa8.png)

### 회원 로그인 시 메뉴창
![image](https://user-images.githubusercontent.com/77195486/197457003-4cd4ecee-3ee8-4e15-8806-370fc9da63b5.png)

### 회원 로그인 시 (관리자)
#### 일반 회원과는 다르게 회원 목록을 볼 수 있습니다.
![image](https://user-images.githubusercontent.com/77195486/197457040-7c7e3c11-4fcf-4c02-ad27-7fd4b1e351cb.png)

### 회원 상세 정보
![image](https://user-images.githubusercontent.com/77195486/197457095-bb5013ff-e4cc-47a2-b3a2-f308df8b8954.png)

### 회원 목록(관리자 상태)
![image](https://user-images.githubusercontent.com/77195486/197457122-01af1010-9e28-47d2-9d9e-a38247277745.png)

### 회원 검색
![image](https://user-images.githubusercontent.com/77195486/197457143-eaee9dac-1430-4f02-8e7c-be14d22baebe.png)

### 게시글 목록 (카테고리 검색 시)
![image](https://user-images.githubusercontent.com/77195486/197457156-4418e7dd-3c01-4d67-9ea5-8986cc38f508.png)

### 게시글 상세보기
![image](https://user-images.githubusercontent.com/77195486/197457167-f549fea4-e1c1-443e-b79f-a23364ada091.png)

### 회원 차단

#### 차단 설정
![image](https://user-images.githubusercontent.com/77195486/197457183-6804be1c-8576-4c7d-b901-5d3957840012.png)
#### 차단된 사용자 (페이지 넘어갈 때마다 경고 발생)
![image](https://user-images.githubusercontent.com/77195486/197457196-6ac874b6-dd6d-4609-9863-4e7d40ad0821.png)
#### 차단된 사용자의 게시물
![image](https://user-images.githubusercontent.com/77195486/197457207-575cd62f-b34b-491e-a039-c3b6ecd2288f.png)
