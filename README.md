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

## ✨세부 계획

![Untitled](SMILEGATE%20%E1%84%80%E1%85%B5%E1%86%B7%E1%84%89%E1%85%A5%E1%86%BC%E1%84%8B%E1%85%B2%E1%86%AB%E2%80%99S%20DEV%20CAMP%20428ffffff89846cbb5317cb1c17e830d/Untitled.png)

## ✨기술 아키텍처

![https://user-images.githubusercontent.com/90383376/205441835-33c45923-602a-41aa-a295-9cf4a7e07833.png](https://user-images.githubusercontent.com/90383376/205441835-33c45923-602a-41aa-a295-9cf4a7e07833.png)

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
> 

(to be continue)

## ✨구현 리스트

* User Server
- [ ] 회원가입 기능
- [ ] 비밀번호 암호화
- [ ] 회원가입 예외처리
