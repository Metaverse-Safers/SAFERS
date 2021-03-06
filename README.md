# 세이퍼스(Safers)
![image](https://user-images.githubusercontent.com/45550607/142267043-3f369a95-bee7-4aa2-b533-e017bf03c6ff.png)

**함께 지구별에서 같이 살아가는 친구들의 지킴이가 되어주세요.**
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
  - [4️⃣ 프로젝트 결과](#4️⃣-프로젝트-결과)
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

## 4️⃣ 프로젝트 결과
- SSAFY 자율프로젝트 최우수상🥇 
- SSAFY 결선발표회(전국발표) 입선🏅 
