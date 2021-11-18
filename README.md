# 세이퍼스(Safers)
![image](https://user-images.githubusercontent.com/45550607/142267043-3f369a95-bee7-4aa2-b533-e017bf03c6ff.png)

**함께 지구별에서 같이 살아간느 침구들의 지킴이가 되어주세요.**
> 여러분은 환경과 동물에 대해 얼마나 알고 계신가요?<br><br>
> 반 세기(50년) 간 지구의 70%의 동물들이 이미 사라졌거나, 곧 사라질 위기에 처해있습니다.<br>
> 인간만이 살아갈 수 없는 이 지구를 지키고, 한 번 더 생각할 수 있는 세이퍼스의 가상세계에 초대합니다.<br><br>
> 이제는 더 이상 보기 힘든 동물 친구들과 반갑게 인사도 하고, 답답한 일상에서 벗어나보세요.

<br><br>

## 프로젝트 목차
- [세이퍼스(Safers)](#세이퍼스safers)
  - [프로젝트 목차](#프로젝트-목차)
  - [1️⃣ 프로젝트 소개](#1️⃣-프로젝트-소개)
    - [📋 기술 스택](#-기술-스택)
    - [🧱 애플리케이션 아키텍처](#-애플리케이션-아키텍처)
    - [🎨 디자인](#-디자인)
  - [2️⃣ 프로젝트 파일 구조](#2️⃣-프로젝트-파일-구조)
    - [Backend](#backend)
    - [Frontend](#frontend)
    - [Unity](#unity)
  - [4️⃣ 프로젝트 산출물](#4️⃣-프로젝트-산출물)

<br><br>

## 1️⃣ 프로젝트 소개
1. 일정 : 2021-10-12 ~ 2021-11-19 (총 6주)
2. 인원 (총 5인)
    - [당현아](https://github.com/eona1301) : 팀장, Backend, Frontend, AWS EC2, Machine Learning
    - [안상훈](https://github.com/ahnsang9) : Frontend
    - [이상현](https://github.com/kimkuan) : Backend, Frontend, AWS EC2, Unity
    - [이영주](https://github.com/0JUUU) : Backend, AWS EC2, Unity
    - [정원석](https://github.com/JWeonseok) : Backend, Unity

<br><br>

### 📋 기술 스택

1. 이슈관리 : Jira
2. 형상관리 : Gitlab
3. 커뮤니케이션 : Mattermost, Notion
4. 디자인 : Adobe Photoshop, Figma
5. 개발 환경
   - OS : Windwos 10
   - DB : MySQL 8.0.22
   - Server : AWS EC2, AWS S3, Ubuntu 20.04, Jenkins 2.303.2, nginx 1.18.0
6. Frontend
   - HTML5, CSS3, JavaScript(ES6)
   - Vue 2.6.11, Vuex 3.4.0, Node.js 10.19.0
   - Lib : Bootstrap 5.1.3, vue modal 2.0.1, simple alert 1.1.1
7. Backend
   - Java open JDK zulu 8.33.0.1
   - SpringBoot Gradle 6.7
   - Lombok 1.18.20, JPA, Swagger, https, Security
8. Unity
   - Unity Community 2019.4.32f1
   - WebGL 2.0, Photon 2.38
9. Machine Learning
   - Tensorflow 3.11.0
   - Tensorflow Mofilenet models 2.1.0
   - Tensorflow Teachable Machine Image 0.8.5
   - Tensorflow core 3.11.0, Tensorflow backend wasm 3.11.0
10. IDE&Tool
    - intelliJ 21.1.2
    - MySQL Workbench
    - Visual Studio Code 1.58
    - MobaXterm

<br><br>

### 🧱 애플리케이션 아키텍처

![image](https://user-images.githubusercontent.com/45550607/142270609-8fa74b4f-1300-45e0-803b-9973d0823169.png)

<br><br>

### 🎨 디자인

![image](https://user-images.githubusercontent.com/45550607/142340088-c79f4b48-7556-4608-a382-a93f1bb799f8.png)

<br><br>

## 2️⃣ 프로젝트 파일 구조

### Backend

```
com
└── safers
  ├─ api
  │ ├─ controller
  │ ├─ service
  │ ├─ request
  │ └─ response
  │
  ├─ common
  │ ├─ util
  │ ├─ exception
  │ ├─ model
  │ ├─ handler
  │ └─ auth
  │
  ├─ config
  │
  └── db
   ├── entity
   └── repository
```

### Frontend

```
frontend
└── src
 ├─ assets
 ├─ router
 ├─ views
 ├─ store
 │ ├── index.js
 │ └── modules 
 ├─ common
 │ ├── axios.js
 │ └── store.js
 ├─ components
 │ ├── Common
 │ ├── Board
 │ ├── Info
 ├─ App.vue
 └─ main.js
```

### Unity

```
SafersSafers
└── Packages
└── Assets
  └─ Animator
  └─ Fonts
  └─ ImportAssets
  └─ Materials
  └─ Photon
  └─ Plugins
  └─ Perfabs
  └─ Resources
  └─ Scenes
  └─ SceneenShot
  └─ Scripts
  └─ Sounds
  └─ ScenesSprites
  └─ TextMesh Pro
```

<br><br>

## 4️⃣ 프로젝트 산출물

- MD와 Notion은 동일하게 정리되었습니다. 열람하시는 분이 더욱 편한 내용으로 확인해주세요.
- 일부 자료는 md로 옮기기 너무 방대해 Notion 링크만 있습니다. 링크는 public하니 자유롭게 확인해주세요.

<table>
  <tr>
    <th colspan="2">Notion</th>
    <td align="center"><a href="https://danghyeona.notion.site/Safers-e8bf96475c65464cba714bd12ecdc9ee" target="_blank">Safers Notion 바로가기</a></td>
  </tr>
  <tr>
    <th colspan="2">6주간 진행한 개별 업무 수행</th>
    <td align="center"><a href="docs/individual-work.md">확인하기</a></td>
  </tr>
  <tr>
    <th rowspan="3">기획</th>
    <td>브레인스토밍</td>
    <td align="center"><a href="docs/brainstorming.md">MD </a> | <a href="https://danghyeona.notion.site/ad1b90b96341408da52c5e8ea1fa9728" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>서비스 확정 및 요구조건</td>
    <td align="center"><a href="docs/requirements.md">MD </a> | <a href="https://danghyeona.notion.site/83498016717e478689f120624ffcedfe" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>프로젝트 계획서</td>
    <td align="center"><a href="docs/project-plan.md">MD </a> | <a href="https://danghyeona.notion.site/871834c10898463d86a2fdb81150e499" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <th rowspan="4">개발 설계</th>
    <td>팀 컨벤션</td>
    <td align="center"><a href="docs/team-convention.md">MD </a> | <a href="https://danghyeona.notion.site/ae3f42fafb58490cb7588f1e1ebe044b" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>서비스 디자인</td>
    <td align="center"><a href="docs/service-design.md">MD </a> | <a href="https://danghyeona.notion.site/d4fac1440f17411fbaa5e48c24f5173a" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>와이어프레임</td>
    <td align="center"><a href="docs/wire-frame.md">MD </a> | <a href="https://danghyeona.notion.site/1a666ee3a6064e669f5d3bd7dd91d42b" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>ERD 구성 및 Meta Data 구성</td>
    <td align="center"><a href="docs/database-erd-meta.md">MD </a> | <a href="https://danghyeona.notion.site/ERD-31f980214f9947bc9e0f9241c893a68a" target="_blank"> ERD Notion</a> | <a href="https://danghyeona.notion.site/Meta-Data-5d85f634be7540a3a8289bbbb56b3d81" target="_blank">Meta-Data Notion</a></td>
  </tr>
  <tr>
    <th rowspan="3">사전 학습 공유</th>
    <td>Unity 학습</td>
    <td align="center"><a href="https://danghyeona.notion.site/Unity-2a7bb2b1f5604334a9b53822501619b5" target="_blank">Notion 확인하기</a></td>
  </tr>
  <tr>
    <td>AWS EC2 학습</td>
    <td align="center"><a href="https://danghyeona.notion.site/AWS-EC2-ecac85932996415390c9b6ce189b5efb" target="_blank">Notion 확인하기</a></td>
  </tr>
  <tr>
    <td>Jenkins CI/CD 학습</td>
    <td align="center"><a href="https://danghyeona.notion.site/Jenkins-CI-CD-5c1a1367004747778659c26ed9fe9bd0" target="_blank">Notion 확인하기</a></td>
  </tr>
  <tr>
    <th rowspan="6">콘텐츠 설계</th>
    <td>멸종동물 사전 조사</td>
    <td align="center"><a href="docs/preliminary-animal-research.md">MD </a> | <a href="https://danghyeona.notion.site/9bc92406487942a5bf23a1f03bd9b2e3?v=51171e7026ab4ab9b602e8fa6a8e53d2" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>미션 콘텐츠 사전 조사</td>
    <td align="center"><a href="docs/preliminary-mission-contents.md">MD </a> | <a href="https://danghyeona.notion.site/fcc97056c8f94defb16b8b1c6771ee02?v=6e334a7e64ce44548fbf0f54c9539cb1" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>비회원 서비스 - 성격유형검사 설계</td>
    <td align="center"><a href="docs/personality-test.md">MD </a> | <a href="https://danghyeona.notion.site/eae9f76854a24efa83806e02cabe33a2" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>미션 스토리 라인 및 퀘스트 대사 설계</td>
    <td align="center"><a href="docs/final-mission-contents.md">MD </a> | <a href="https://danghyeona.notion.site/049ecf50eda44f2facd32067971eed63" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>동물 최종 확정 및 에셋 조사</td>
    <td align="center"><a href="docs/final-animal-survey.md">MD </a> | <a href="https://danghyeona.notion.site/FIX-4bc7822f5cb94038a7b3040c9ca95ae6" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>서비스 BGM 선정</td>
    <td align="center"><a href="docs/service-bgm.md">MD </a> | <a href="https://danghyeona.notion.site/BGM-a39f3676822246869d6cd85bae0b974c" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <th rowspan="2">개발 착수</th>
    <td>BackEnd - API Docs</td>
    <td align="center"><a href="docs/api-docs.md">MD </a> | <a href="https://danghyeona.notion.site/3bc7d766250b409cb4be32d251d05c11?v=27c018c45cdb4602a8e038e4c7567e1c" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>Unity 미션 정보</td>
    <td align="center"><a href="docs/uinity-mission-data.md">MD </a> | <a href="https://danghyeona.notion.site/d804440fbd2c42f0b59655996d93808e" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <th rowspan="1">테스트</th>
    <td>버그 리포트</td>
    <td align="center"><a href="docs/bug-report.md">MD </a> | <a href="https://danghyeona.notion.site/Bug-Report-bcce8f310e6f44a69d6625b84c0b4b79" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <th rowspan="3">발표</th>
    <td>기획 발표 자료</td>
    <td align="center"><a href="docs/planning-presentation.md">MD </a> | <a href="https://danghyeona.notion.site/e50cc04f801e4401aa94878ba15a8300" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>최종 발표 자료</td>
    <td align="center"><a href="">MD </a> | <a href="" target="_blank">Notion</a></td>
  </tr>
  <tr>
    <td>프로젝트 서비스 UCC</td>
    <td align="center"><a href=""> 보러가기 </a></td>
  </tr>
</table>