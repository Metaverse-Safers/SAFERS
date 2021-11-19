[↩ Main로 돌아가기](https://lab.ssafy.com/s05-final/S05P31A403)

<br><br>

- [팀 컨벤션](#팀-컨벤션)
  - [커밋(Commit)](#커밋commit)
  - [지라(Jira)](#지라jira)
  - [브랜치(Branch)](#브랜치branch)

<br><br>

# 팀 컨벤션

## 커밋(Commit)

[참고 컨벤션 : Udacity Nanodegree Style Guide](https://udacity.github.io/git-styleguide/)

```code
  type: commit log
```

- Type
  - **feat:** A new feature
  - **fix:** A bug fix
  - **docs:** Changes to documentation
  - **style:** Formatting, missing semi colons, etc; no code change
  - **refactor:** Refactoring production code
  - **test:** Adding tests, refactoring test; no production code change
  - **chore:** Updating build tasks, package manager configs, etc; no production code change
- 규칙
  - 제목의 길이는 50글자를 넘기지 않는다
  - 제목의 마지막에 마침표를 사용하지 않는다
  - 본문을 작성할 때 한 줄에 72글자 넘기지 않는다
  - 마침표를 사용하지 않는다
  - 과거형을 사용하지 않는다
  - 커밋 메시지는 **영어**로 작성한다

<br><br>

## 지라(Jira)

- 순위 : Epic > Story > Task > Sub-Task <br>

- 이슈관리
  - To Do/In Progress/Done 잘 찍기
  - Story Point : 담당자가 작성하되 여유롭게 시간을 작성해서 진행하기 <br>

- Epic
  - 기획/설계
  - 개발기초 - 자동화 준비, FE/BE 구조, Web에 Unity 올리기
  - 회원관리 - CRUD, 사진 업데이트, 닉네임 중복
  - 게시판기능 - CRUD, 좋아요, 개인 화면
  - 개인캐릭터설정 - 에셋 조사, 적용, DB 확인
  - 캐릭터&맵 - 에셋(동물), 인칭, 무빙, 이동가능 범주, 채팅 ....
  - 미션 - Sort, Filter, Tab
  - 도감 - 정보 양식, 뱃지, **한국**, ....
  - 비회원서비스 - 설문조사 및 결과 공유
  - 산출물
    - 1주차 : 기획, 컨셉
    - 2주차 : 계획서, 컨벤션, 아키텍쳐, 요구사항 명세서, 디자인, ERD, 와이어프레임
    - 3주차 : rest api, meta-data
    - 4주차 :
    - 5주차 : UCC, 테스팅, 포팅 메뉴얼, 시나리오
    - 6주차 : 최종 발표 자료

<br><br>

## 브랜치(Branch)

- 개발기간 중에는 dev 브랜치를 default 브랜치로 사용한다.
- feat는 각 기능을 개발하는 담당자들이 진행한다.
  - `feat/<type>-<function>`에 네이밍 규칙을 따른다.
    - type : BE, FE, Unity 등 각 영역을 기재한다.
    - function : 어떤 기능인지 기재한다.
- 배포는 dev 기준으로 진행한다.
- 각 feat를 만들면 Gitlab의 Issuce 역시 만든다. (아래 예시)

![image](https://user-images.githubusercontent.com/45550607/142356026-7039adf0-8269-427d-99ff-2abcaee298a5.png)
