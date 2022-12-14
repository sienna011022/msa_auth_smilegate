# SMILEGATE 김성윤’S DEV CAMP

## ✨인증 시스템

> SmileGate Winter Dev Camp 개인 프로젝트 중 김성윤의 인증 시스템을 구현하고자 합니다.
> 

[https://github.com/sienna011022/msa_auth_smilegate.git](https://github.com/sienna011022/msa_auth_smilegate.git)

## ✨목표

- 공식 문서를 읽으며 , 정확한 이해와 구현을 목표로 합니다.
- 프레임워크에 의존하지 않고 일부는 나만의 코드로 구현하고자 합니다.
- 클린 코드를 지향하고자 합니다.
- FE까지 연동하며 완성된 프로젝트를 만들고자 합니다.
- 성능 테스트를 통해 대용량 트래픽에도 대비할 수 있는 코드를 만들고자 합니다.

| AS-IS | TO-BE                                                                    |
| --- |--------------------------------------------------------------------------|
| 공식 문서를 읽는 습관이 아닌 한국어로 번역된 블로그를 읽는 습관 | Spring Security Docs를 바탕으로 인터페이스를 타고 들어가며 코드흐름을 이해해보기.                   |
| 인증/인가에 대한 구현 경험 부족 | 인증/인가 시스템의 이해부터 구현까지 직접해보기.                                              |
| 에러의 원인을 뜯어보지 않고 즉흥적으로 구글링 한 뒤 솔루션 적용 | 에러 발생 시 ,What, Why, How를 남기며 정리 해놓기                                      |
| FE에는 뒷전이었던 개발 습관 | React를 사용하며 FE와의 연동까지 성공하기                                               |
| 다른 사람의 블로그 포스팅을 보고 , 이해한 뒤 본인 블로그에 Ctrl+c, Ctrl+v 하는 경향 | 다른 사람의 글은 참고용으로 , 하나하나 직접 내가 이해한 내용을 토대로 작성하기                            |
| 많이 사용되는 프레임 워크에 의존하는 습관 | 일부는 프레임 워크 의존이 아닌 custom하여 나만의 코드로 시스템을 구현하기 및 프레임 워크 사용 시 사용 이유를 명확히 하기 |
| 성능테스트 경험 부족 | [부하 테스트 목표] 로그인 동시접속자 수 = 600명 , 응답 시간  : 3s이내 ,목표 TPS: 200TPS           |
| 클린코드에 대한 경험 부족 | TDD 적용 및 OOP관점에서 의미 있는 코드 짜기                                             |


## ✨플로우 차트 & 시스템 아키텍처
* 시스템 아키텍처
![image](https://user-images.githubusercontent.com/90383376/207228855-190cd352-62d0-4847-8cdd-f71e6dcd059a.png)
* 로그인 플로우 차트
![image](https://user-images.githubusercontent.com/90383376/207228872-4cae3609-9381-4e72-9578-6d4b9286dd7c.png)


## ✨기술 스택

> 해당 프로젝트를 수행하며 사용할 기술 스택입니다.
> 

## FE

- React

## BE

- JAVA 11
- Spring Boot
- Spring Cloud Gateway
- Spring Security (Option)
- MySQL
- AOP (Option)

## ETC

- IntelliJ
- GitHub Action (Option)
- Ngrinder

## ✨모듈 별 기능

> 각 모듈 별 기능을 나열하였습니다.(+추가 예정)
> 

### Gateway

- 모듈 별 라우팅

### Auth

- JWT 기반  Access Token 발급
- JWT 기반 Refresh Token 발급

### User

- 회원가입
- 로그인
- 유저 관리 페이지
- Password Encryption
- E-Mail 인증 (option)
- 비밀번호 찾기 (option)

## ✨ 프로젝트 진행 포스팅

> 프로젝트 개발 과정에서 다양한 고민과 좌충우돌을 적은 포스팅이며 링크로 연결되어 있습니다.
- [어떤 비밀번호 알고리즘을 사용할까?](https://sienna1022.tistory.com/entry/%EC%96%B4%EB%96%A4-%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98%EC%9D%84-%EC%8D%A8%EC%95%BC-%ED%95%A0%EA%B9%8C)

## ✨구현 리스트

* User Server
- [X] 회원가입 기능
- [X] 비밀번호 암호화
- [X] 비밀번호 유효성 체크
- [X] 회원 정보를 찾을 수 없다면 예외 발생
- [X] 비밀번호가 일치하지 않으면 예외 발생
- [ ] 아이디가 이미 존재한다면 예외 발생
- [X] 로그인 기능
- [X] Auth Server에 토큰 발급 요청
- [ ] Refresh Token 저장

* Auth Server
- [X] JWT access token 발급
- [X] JWT refresh token 발급
- [X] 요청 온 access token 유효성 검사
- [ ] 요청 온 refresh token 유효성 검사
- [ ] 요청 온 refresh token 존재여부 user server에 검증 요청
- [ ] access token 재발급

* GateWay
- [X] 각 모듈 라우팅
- [ ] 요청 Header에서 JWT 존재 여부 검사

* Front Server
- [X] 회원가입 페이지
![image](https://user-images.githubusercontent.com/90383376/206737250-a655a078-fcad-4798-9198-d5941219e568.png)
- [ ] JWT 헤더에 포함 후 요청
- [ ] 로그인 페이지
