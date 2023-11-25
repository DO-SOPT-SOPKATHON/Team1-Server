# Team1-Server

   <br />

## 🏳 서비스 소개



### 💡 과거의 걱정을 오늘의 나에게, 오늘의 걱정을 미래의 나에게. 걱정 기록 서비스

우리는 왜 지금 걱정을 크게 해서 본인을 마비시키는 걸까요?
지금 당장 걱정에만 집중해서 그런 거 아닐까요?

각자의 마음속에는 수없이 많은 걱정들이 자리 잡고 있습니다. 
하지만 시간이 지나고 돌이켜보면, 그 걱정들이 우리를 더 성숙하고 강인하게 만들었음을 깨닫게 됩니다. 

이제, 당신의 걱정들을 아카이빙하여 미래의 어느 날, 
얼마나 멀리 왔는지 돌아보는 시간을 가져보세요. 
어제의 당신은 이미 오늘의 당신을 도와줄거에요

 <i>지금의 고민과 걱정이 언젠가는 좋은 방향이 될 수 있도록, 당신의 모든 순간을 함께 아카이브 해 드립니다. </i>


**"현재의 내 걱정을 덜어주는 건 과거의 내 걱정들이었다."**

<i> 현재의 내가 본 과거의 내 걱정, 다 잘 됐어요  </i>
<br/>
<i> 미래의 내가 볼 현재의 내 걱정, 다 괜찮을 거에요  </i>
 
#### 과거의 걱정을 오늘의 나에게, 오늘의 걱정을 미래의 나에게. 걱정 기록 서비스

  <br />

## 팀원 소개

<img src="https://github.com/DO-SOPT-SOPKATHON/Team1-Server/assets/115079024/321b6ea7-d6be-4a3b-a005-e18bb3cea032" width = 300 height = 300 />

#### 박희정
- GET 일기 단건 조회
- GET 일기 랜덤 단건 조회
- POST 리뷰 추가
#### 이혜연
- POST 일기 추가
- GET 카테고리 일기 리스트 조회

  
    <br />
    
## 🌳 Branch

`main branch` : 배포 단위 브랜치

`dev branch` : main merge 전 거치는 branch

`feat branch`: 기능별 branch

- 할 일 Issue 등록 후, Issue 번호와 기능 내용으로 브랜치 생성
- 해당 브랜치 작업 후 완료 후 PR 보내기
- 로컬에서 먼저 충돌 해결한 후 올리기
- 서로 Approve & 리뷰 반영한 이후 merge
 
  <br />
## 🧵 Commit Convention

<div>
  
- init: 개발 환경 초기 세팅
- feat: 새로운 기능 구현
- fix: 버그 수정
- docs: 문서 추가, 수정, 삭제
- build: 빌드 시스템 및 외부에 영향을 미치는 사항 (라이브러리 추가 등)
- test: 테스트 추가 및 테스트 수정
- refactor: 코드 리팩토링
- chore: 그 외 자잘한 수정

</div>
<br />

## 🧶 Convention

<div>

1. 직관적이고 이해하기 쉬운 네이밍  <br>
2. 패키지 이름은 소문자로 구성한다. ex) `domain`, `controller`  <br>
3. 클래스, 인터페이스 이름은 명사로 작성하고 대문자 카멜표기법 적용한다. ex) `UserSeriveTest`  <br>
4. 테스트 클래스 이름은 항상 'Test'로 끝낸다.  <br>
5. 메서드 이름은 동사로 작성하고 소문자 카멜표기법을 적용한다. ex) `readBook`  <br>
6. EUNUM 이나 상수는 대문자 및 언더스코어로 작성한다. ex ) `DEFAULT_SCORE`  <br>
7. 변수는 소문자 카멜표기법 적용한다.   <br>
8. URL, 파일명 등은 kebab-case 를 사용한다 (원문 : USER LOGIN LOG, 케밥식: `user-login-log`)  <br>
9. 예외 케이스가 발생할 확률이 있는 경우, 가능한 빨리 리턴 또는 예외를 던질 수 있게 한다  <br>
- 예외는 반드시 처리하고 처리하지 않을 경우 주석으로 이유를 설명한다  <br>
10. 하나의 메소드와 클래스는 하나의 목적만 수행하게 만든다.  <br>
- 메소드는 최소한의 역할만 수행한다  <br>
- 클래스는 필요한 책임만 할당한다  <br>

</div>


## 🛠️ Tech
- Spring	3.1.6
- AWS RDS(MySQL)
- AWS EC2(Ubuntu)
- Gradle
- MySQL Workbench
- Java version	Java 17
