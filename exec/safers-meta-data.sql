-- common code
INSERT INTO `common_code` (`common_code`, `name`) VALUES ("A", "회원상태"), ("B", "보상조건"), ("C", "미션진행"), ("D", "게시글유형");

-- code
INSERT INTO `code` (`common_code`, `code`, `name`, `use_yn`) VALUES ("A", "A01", "일반회원", 1), ("A", "A02", "탈퇴회원", 1);
INSERT INTO `code` (`common_code`, `code`, `name`, `use_yn`) VALUES ("B", "B01", "맵 확장", 1), ("B", "B02", "동물획득", 1);
INSERT INTO `code` (`common_code`, `code`, `name`, `use_yn`) VALUES ("C", "C01", "비활성화", 1),("C", "C02", "미션 직전", 1), ("C", "C03", "미션 진행", 1), ("C", "C04", "미션 완료", 1);
INSERT INTO `code` (`common_code`, `code`, `name`, `use_yn`) VALUES ("D", "D01", "자유게시판", 1),("D", "D02", "얼룩말과 함께", 1), ("D", "D03", "텀블러101", 1), ("D", "D04", "동물도감 자랑", 1), ("D", "D05", "환경일기", 1), ("D", "D06", "환경관심도 측정", 1);

-- map
INSERT INTO `map` (`id`, `name`) VALUES ("M001", "숲/초원"), ("M002", "북극/남극"), ("M003", "해안");

-- animals
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001001","굴토끼","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001002","얼룩말","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001003","기린","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001004","고릴라","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001005","자이언트 판다","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001006","엘드사슴","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001007","난쟁이가지뿔영양","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001008","라쿤","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001009","퓨마","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001010","코끼리","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001011","회색늑대","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001012","나무늘보","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001013","야생물소","M001");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A001014","사자","M001");

INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002001","북극곰","M002");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002002","바다코끼리","M002");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002003","황제펭귄","M002");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002004","북극토끼","M002");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002005","볏왕관펭귄","M002");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002006","순록","M002");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002007","북극여우","M002");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002008","남극물개","M002");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A002009","극제비갈매기","M002");

INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003001","켐프각시바다거북","M003");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003002","듀공","M003");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003003","흑범고래","M003");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003004","백상아리","M003");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003005","큰귀상어","M003");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003006","개복치","M003");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003007","황소상어","M003");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003008","대왕쥐가오리","M003");
INSERT INTO `animals` (`id`, `name`, `map_id`) VALUES ("A003009","헥토르돌고래","M003");

-- mission
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1000","safers의 시작","S1010/S2010","A001002/A001009", "굴토끼");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1010","얼룩말과 인생한컷","S1020","A001003", "얼룩말");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1020","부끄럼쟁이 기린","S1030","A001004", "기린");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1030","텀블러 101","S1040","A001005", "고릴라");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1040","집을 잃은 북극곰","S1050","M002/A002001", "자이언트 판다");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1050","에어컨을 부탁해","S1060","A002002", "북극곰");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1060","띠띠띠- 영상을 잘 봐","S1070","A002003", "바다코끼리");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1070","저탄소 친환경 생활로 지구를 구해줘","S1080","A002004", "황제펭귄");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1080","명예볏왕관 만들기 ","S1090","A002005", "코뿔바다오리");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1090","새친구 퀴즈\n 볏왕관 펭귄을 맞혀봐","S1100","A002006", "볏왕관 펭귄");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1100","#근황체크#인싸의_길은_멀고도_험난하다","S1110","A001006", "순록");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1110","파티 참가 조건","S1120","A001007", "엘드사슴");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1120","로켓배송","S1130","A001008", "난쟁이가지뿔영양");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1130","너에 대한 모든게 궁금해","S1140","A002007", "라쿤");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1140","나의 환경 관심도는 몇 점","S1150","A002008", "북극여우");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S1150","감사의 인사","","A002009", "남극물개");

INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2010","초원의 스핑크스","S2020","A001010", "퓨마");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2020","환경일기 시작하기","S2030","A001011", "코끼리");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2030","에너지 절약의 첫걸음","S2040","A001012", "회색늑대");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2040","배고픈 나무늘보의 부탁","S2050","M003/A003001", "나무늘보");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2050","답답한 마스크","S2060","A003002", "켐프각시바다거북");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2060","울고 있는 듀공","S2070","A003003", "듀공");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2070","에너지 절약의 첫걸음2","S2080","A003004", "흑범고래");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2080","잃어버린 진주를 찾아서","S2090","A003005", "백상아리");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2090","고마움의 표시","S2100","A003006", "큰귀상어");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2100","돌연사를 막아라","S2110","A001013", "개복치");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2110","새로운 친구 사귀기","S2120","A001014", "켐프각시바다거북");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2120","심심한 사자의 부탁","S2130","A003007", "사자");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2130","너의 도감을 자랑해봐!","S2140","A003008", "황소상어");
INSERT INTO `mission` (`id`, `title`, `next_mission`, `result_id`) VALUES ("S2140","감사의 인사2","","A003009", "대왕쥐가오리");

-- survey data
INSERT INTO `survey` (`mbti`, `area`, `name`, `image_url`, `introduce`, `explanation`, `extinction`, `personality`, `buddy`, `enemy`)
VALUES
("ESTP", "초원", "얼룩말", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ESTP.PNG", "인생은 과감한 모험! 그게 아니면 아무것도 아니지!", "엄청나게 많은 수의 무리로 단체 생활을 해~/사람들이 사육하려고 도전했는데 어림도 없지! 난 절때 사람들에게 길들여지지 않는다고!/웬만한 맹수들도 힘들어할만큼 어마무시한 힘을 갖고 있어!", "NT(Near Threatened)로 가까운 시일 내에 사라질 위기에 처했어/내가 아무리 힘이 쎄도 인간들의 총과 덫을 피할 수는 없었어... 많은 밀렵으로 내 친구들은 사라졌지", "난 나름 느긋하게 움직여~ 급하기 전까진 최대한 느긋하다고!/다른 사람들의 변화를 곧잘 찾아낼 수 있어. 이게 주변 친구들이 싫어할 수도 있어서 발견해도 조용히 해야할지 한번씩 참아야 해/방해요소가 생기면 바로 중무장하게 돼! 최대한 이성적으로 처리해버리지!", "INTJ/INFJ/ENTJ/ENFJ", "ENTP/INTP/ENFP/INFP"),
("ISTP", "초원", "야생물소", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ISTP.PNG", "매일 같은 곳을 가고, 같은 사람을 만나면서 같은 일을 하며 살고싶지 않아! 난 항상 흥미로운 도전을 원해!", "내 멋진 뿔은 어필할 수 있는 매력 포인트이자 유일한 무기야/제일 좋아하는 건 진흙 목욕인데, 이건 기생충을 방지하는 똑똑한 방법이기도 해/우리 아이들은 대부분 외동이야 엄청나게 귀하지", "EN(Endangered) 등급으로 계속 우릴 이렇게 대하면 우린 지구에서 사라질꺼야/사람들이 우리의 건강하고 단단한 피부를 탐내서 무작위하게 잡아갔어/게임이라도 죽이고 고기를 먹으려고 죽이는 인간들이 너무 무서워", "냉철한 이성주의적인 성향과 왕성한 호기심을 가진 만능 재주꾼이야!/느긋하고 내성적이지만 한번 호기심이 생기면 완전 초집중해!/내 나름대로의 선이 명확해. 이걸 지키지 않으면 뒷감당할 수 없을꺼야.", "ESFJ/ENFJ/INFJ", "ENFP/INFP/ENTP/INTP/ISTJ/ISTP/ISFP"),
("ENTJ", "초원", "사자", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ENTJ.PNG", "삶은 한번이야. 다른 사람의 삶을 사느라 낭비하지마. 내가 원하는 것이 아니면 다 후순위야.", "무리를 지어서 지내고 있어. 우리의 공간인 프라이드에 침투하면 경고하거나 잡아먹어/필요할 때가 아니면 굳이 사냥을 하지 않아서 아주 굶주린 배와 아주 배부른 상태 2가지 밖에 없어/생각하는 것이랑 다르게 내가 달릴 수 있는 최고 속도는 80km/h정도 밖에 안돼", "VU(Vulnerable)로 관리하지 않으면 사라질 위험에 처한 단계야/우리가 먹는 동물들을 인간도 사냥하고 먹기 시작하면서 먹을 것이 줄어들었어. 밥그릇 싸움이 시작한거지/밥을 뺏은 것도 모자라서 우릴 죽인다니 대체 왜 그러는 거야", "난 천성적으로 타고난 리더야. 카리스마와 자신감으로 진두지휘할 수 있어/다툼이 생기면 뒤로 물러서는 법이 없어. 승리로 이끄는 그 자체를 즐기는 걸/내 본모습보다 날 더 과대 포장하긴 해... 하지만 내가 앞서는 만큼 다들 좋은 결과로 가려고 하는거니까 너무 뭐라하지마...", "INFP/ISFP/ESTP/ESFP", "ENTJ/ESFJ/ISFJ"),
("INFP", "숲", "나무늘보", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/INFP.PNG", "금이라고 다 반짝이는건 아니야. 오래되어도 더 강하고 시들지 않는 것들이 있어.", "우리는 매달려서 살고 있기 때문에 털이 머리에서 다리쪽으로 나지 않고 반대로 나와/털에는 다양한 박테리아가 있는데 이 자체가 좋은 영양분으로 먹기도 해/행동이 느리다고 알려져있는데 소화는 한 달 이상 더 걸려. 엄청나지?", "VU(Vulnerable) 등급으로 우릴 배려하지 않으면 천천히, 하지만 깔끔하게 지구에서 사라질꺼야/내가 살고 있는 열대 우림을 인간들이 파괴하면서 우리 직접 죽이거나 간접적으로 죽고 있어/지방이 적은 내 몸의 특성 상 우릴 잡아먹거나 털을 안장으로도 쓰는 사람들이 있어", "최대한 좋은 것만 보려고해. 이상적이지는 몰라도 즐거움과 열정이 가득해!/나름대로 원리원칙을 생각해 행동하지만 너무 추상적으로 설명하나봐... 간혹 사람들이 너무 추상적이라 이해하지 못해/다수도 좋지만 소수한테 관심이 더 많아. 이상적이자 이타적인게 내 특징이지.", "ENTJ/ESTJ/INTJ/ISTJ", "INFJ/ESTP/INTP/ENFP/ESFP/ISTP/ISFP"),
("ENFJ", "숲", "굴토끼", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ENFJ.PNG", "내가 하는 모든  잔잔히 처져나가 모든 이에게 영향을 주고 있어.", "이상한 나라의 앨리스를 이끌어갔던 토끼가 바로 나야!/겉모습이 귀여워서 온순할 거같지만, 난 약하기 때문에 경계심이 엄청 많아/귀가 정말 예민하기 때문에 이걸 만지면 공격할 수도 있어! 조심해~", "EN(Endangered) 등급으로 우릴 찾기 점점 힘들꺼야/지구가 따뜻해지면서 점점 이동하고 있는데 이젠 더이상 어디로 가야할까?/우리가 사라질 수록 생태계가 불균형해지면서 더 큰 파장이 오고 있어", "나는 선한 일을 통해서 세상에 빛과 소금이 되도록 카리스마와 열정으로 똘똘뭉친 리더야./직접 대면하고 이야기하는 것을 좋아해서 마법처럼 나에게 끌리는 사람들이 많아/내가 옳다고 생각하는 믿음을 위해서라면 총대 메는 것은 두렵지 않아!", "INTP/ISTP/ENFJ/ESTP/ESFP", "ESTJ/ISTJ/ENTJ/ISFJ/ENFP"),
("ISTJ", "숲", "회색늑대", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ISTJ.PNG", "한 명이면 충분한 일을, 두 명이 하면 될 일도 안되고, 세 명이 하면 시작도 못하더라", "기본적으로 우리 가족끼리 생활하는 것을 원칙으로 해/한 번 짝을 짓게 되면 끝까지 계속 살아가는 사랑꾼의 면모도 있어/높은 지능을 갖고 있어서 서로 계획을 잘 세워서 위협이 되는 상황이 올때 확실하게 처리할 수 있어", "LC(Least Concern) 등급으로 계속 확인해야하는 상태야/날카롭고 정확한 공격때문에 인간들에게 위협적으로 여겨졌는지 우릴 공격하기 시작했어/우리가 사는 곳이 뿔뿔히 끊겨서 조각처럼 나뉘어졌어 어디서 살라는거야", "내가 뱉은 말은 무슨 희생이 따르던지 책임을 지고 기어이 해내!/백해무익한 무리에 있으니 혼자 하는게 낫다고 생각해/최대한 분석하고 현실적으로 실행 가능한 계획을 세우는 것이 좋아", "ENTP/ENFP/INFP/ISFP", "ENFJ/INFJ/ENTJ/ISFJ/ISTP"),
("ESTJ", "숲", "자이언트 판다", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ESTJ.PNG", "휼륭한 질서는 모든 것의 기초야", "예전에는 아시아 곳곳의 넓은 지역에서 살았는데, 이제는 중국 남중부에 고립된 곳에서 살고있어/알고 있듯이 대나무 숲을 좋아하지만 오래 머무르지는 않아. 그래서 겨울 잠도 자지 않지/혼자 있기 좋아해서 같은 공간에 있어서 암묵적인 자신만의 영역이 있어!", "VU(Vulnerable)로 최근에 위기에서 취약등급으로 멸종 위기가 한 단계 내려왔어!/우리 자체도 한번에 많은 자손을 낳지 못하는데 인간들이 우리의 가죽을 위해 잡아버렸어/대나무 숲을 농사나 약초로 바꿔 버리면서 내 밥이 줄어들어 버렸어", "사회나 가족을 하나로 모으기 위해 질서를 세우는 대표적인 유형이야~/내 부족함을 알고 그걸 인정하면서 노력을 열심히 하기도 해/하지만 기준에서 벗어나는 무능력, 태만, 부정직을 보면 불같이 화내버려", "INFP/ISFP/ENTP/INTP", "ENFJ/INFJ/ESTP/ESFJ/INTJ/ENTJ"),
("ISFJ", "북극", "순록", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ISFJ.PNG", "다른 이가 필요한 것들을 나누어 주면 줄수록 돌아오는 것이 더 클 거예요.", "'루돌프 사슴코는~♪' 틀렸어! 루돌프는 순록이야! 그러니까 '루돌프 순록코는~♪' 이지!/날이 따뜻할 땐 수컷과 암컷이 따로 살아, 아기가 나올 때 쯤 소수의 수컷이 다수의 암컷을 거느리게 돼/코끝까지 털로 덮여서 따뜻하고, 발굽이 특이해서 눈속으로 빠지지 않게 해줘!", "VU(Vulenrable) 등급으로 개체가 점점 줄어들고 있어/지구가 따듯해져서 눈이 안오고 비가 오더라고... 얼음이 더 두꺼워지면서 식물을 먹기 힘들어졌어/인간은 우리를 식량, 가죽 등 과하게 많은 자원으로 사용했어. 우리를 지켜줘...", "내가 마음에 드는 사람들을 대상으로는 수호자처럼 보호해줄 수 있어/스스로 달성한 업적이나 실적을 굳이 밝히진 않아서 다른 사람들이 신기하게 봐/스포트라이트를 받는 건 너무 불편하고, 칭찬이 조금 어색해", "ENTP/INTP/ENFP/ISTP", "ENTJ/INTJ/ISFP/ISTJ/ISFJ/ENFJ"),
("ENTP", "북극", "북극토끼", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ENTP.PNG", "'별난 사람'이라는 낙인보다 내 생각을 버리고 순종하는게 더 치욕스러워", "내가 이 지구별 중에 가장 큰 토끼야! 큰 친구의 키는 70cm나 되는걸?/추운 곳에 사는 만큼 엄청나게 두꺼운 털을 갖고 있어! 부드러운 내 털 부럽지?/덩치가 크지만 그만큼 길어서 시속 60km로 달릴 수 있어!", "LC(Least Concern) 계급으로 멸종 위기의 위험에서 관심을 줘야 해/난 원래 버드나무나 맛있는 열매를 먹고 사는데, 달라진 환경 때문에 구할 수가 없어./북극에도 비가 오면서 땅의 얼음이 더 두꺼워졌어. 내가 몸을 숨길 곳들의 입구가 다 막혀가...", "맞는건 맞고 아닌건 아닌거야! 논쟁의 중심에서 내 이야기를 나누는 것이 제일 재밌어/논쟁이 재미있는거지 헐뜯진않아. 배려있게 타협이 되면 그게 가장 보람있어/빙빙 돌려 말하지 않았으면 좋겠어! 그래서 핵심이 뭔데?!", "ISTJ/ISFJ/ENTP/ESTJ/ESFJ", "ESFP/ISFP/ENTJ/ENFP/ESTP/ISTP"),
("INTP", "북극", "북극여우", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/INTP.PNG", "인생에서 가장 중요한 건 질문하는 일을 멈추지 않는 것이야.", "굉장히 빠르게 움직일 수 있어서 땅이랑 눈을 순식간에 파해칠 수 있어/음식은 이것저것 가리지 않고 고기부터 풀까지 다 먹을 수 있어!/처음엔 아빠한테 인정받아 졸업하고, 엄마한테 인정받아 독립하면 드디어 혼자 살 수 있어", "LC(Least Concern) 등급으로 꼭 관심을 갖고 있어줘야해. 언제 위기에 처할 지 몰라/사람들과 마주하게 되면서 광견병, 뇌염 등에 걸리면서 치명적으로 작용하기 시작했어/우리의 아름다운 털을 욕심내서 잡는 사람들도 꾸준히 늘어났었어", "평범함을 거부하는 자들이야! 우린 독창성과 창의력이 제일 강점이자 자부심이야/나의 유일한 장애물은 실패에 대한 두려움이라 계속해서 의구심을 극복하려고 노력하고 있어/몽상이 가득하지만 최대한 현실적으로 결론지으려고 해서 발명을 정말 많이 하기도 해", "ESFJ/ISFJ/ENFJ/ESTJ/INFJ", "ESFP/ISFP/INTJ/INFP/ESTP/ISTP"),
("ENFP", "남극", "남극물개", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ENFP.PNG", "여러분의 직업이 뭔지는 관심이 없어요. 하지만 꿈이 뭔지, 어떤 삶을 살고 싶은 지는 궁금해요.", "수컷은 평생을 영토를 놓고 도전하고 목소리를 높히는 성격을 갖고 있어/덩치가 큰 만큼 펭귄을 잡아먹지만 일부 지역에서는 어류나 크릴새우 만을 먹기도 해/피부가 매끄러워 보이지만, 짧은 털이 있어! 물에 젖어서 그렇게 보일 뿐이야", "LC(Least Concern) 등급으로 멸종 위기에 가능성이 있어 관심을 가져야 해/인간들은 내 가죽이 탐났나봐. 다음 세대가 태어나기도 전에 너무 많이 죽였어/바다가 따뜻해지면서 내가 먹던 물고기가 더 이상 여기에는 안 살더라...", "분위기 메이커 역할을 즐기면서 즐거움과 좋은 관계에 행복을 느껴/반복되거나 단순한 업무를 하라고 하면 인생이 너무 심심할 꺼야/살짝 미치면 인생은 즐거운거 같아! 한 번 사는 인생 즐겨야지!", "ISTJ/ISFJ/ESTJ/ESFJ", "ESTP/ESFP/ISTP/ENTP/ENFJ/INFP"),
("ISFP", "남극", "극제비 갈매기", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ISFP.PNG", "짧은 하루 동안에도 무수히 많이 변화합니다. 잠을 자고 눈을 뜨면 아예 새로운 제 자신이죠.", "밝은 깃털에 붉은 부리와 발에 검은색 포인트를 줘서 이쁘게 꾸며봤어. 어때?/나는 부지런히 움직이면서 북쪽 지역에서 남극까지 이주하기도 해. 지구별 중에 가장 긴 이동거리를 갖고있지./갓 태어났을 때는 솜뭉치같은데 똑똑해서 사냥방법과 다이빙 방법을 혼자서 배울 수 있어", "LC(Least Concern) 등급으로 멸종위기에 앞서 최소한의 관심을 가져야 해/남쪽 지역의 개척 때문에 남쪽으로 이동하면 머물 장소가 없어 허무하게 죽고 있어/작아진 삶의 공간에서 점점 더 격해지는 영역 다툼이 일어나서 알이나 새끼들이 죽기도 해", "전통적인 아름다움이 아닌 실험적인 아름다움이나 행위를 즐겨!/작은 하나하나가 큰 의미로 다가오는 성격 때문에 많은 일에 관심을 갖고 있어/다른 사람들의 칭찬에 쉽게 자극받아 무모한 일을 할 수도 있다는 걸 잘 알고있지", "ENTJ/ESTJ/INTJ/ISTJ", "ENTP/INTP/ISFJ/INFP/ISTP"),
("ESFJ", "남극", "볏왕관 펭귄", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ESFJ.PNG", "서로 용기를 북돋아 주고 힘이 돼주세요. 한 사람의 긍정 에너지가 곧 모든 사람에게 전달될 꺼에요!", "흔히 생각하는 펭귄이랑 다르게 눈 위에 노란색 볏이 있어! 멋지고 강렬하지/주로 크릴새우, 오징어, 작은 새우들을 맛있게 먹으면서 지내고 있어/최대한 단체로 지내려고 하고 서로 교대로 담당하면서 가정을 유지하고 있어", "EN(Endangered)의 등급으로 종을 파악하기도 전에 개체 수가 부족해서 위험해/내가 먹어야 하는 물고기를 인간들이 잡아가 버렸어! 사냥을 하는데도 성공률이 좋지않아.../매일이 다르게 급격하게 바뀌는 이상한 날씨 때문에 사는 곳을 계속 옮겨야 해", "최대한 간단히 표현하자면 다른 사람들의 행복이 즐거움을 만드는 게 곧 내 행복이야!/가정에 매우 집중하고 헌신적으로 도움이 되고자 해./많은 이들과 관계를 맺은 만큼 좋은 영향력에 대해서 많이 고민하는 편이야", "INTP/ISTP/ENTP/ENFP", "ENTJ/INTJ/ESTJ/INFJ/ESFP"),
("ESFP", "해안", "켐프각시바다거북", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/ESFP.PNG", "난 실수투성이에 천방지축이기도 하지만 난 이런 내가 좋아!", "바다 거북이들 중에는 가장 작은 편이야./뾰족한 부리 모양에 입이 매력포인트야! 신기하지?!/딱딱한 게도 먹을 수 있을 정도로 강한 턱을 갖고 있어", "CR(Critically Endangered)로 이제 곧 사라질 위기에 처해있어/예전에는 사람들이 우릴 잡아가면서 줄었는데 요즘엔 바다가 너무 더러워져서 숨을 쉬지 못하고 있어/무분별하게 던져둔 어망같은 것 때문에 더 힘들어", "스포트라이트를 즐기면서 쇼맵쉽이 내 몸을 감싸고 있어/계획을 세우는 건 엉망이라 돈이 자꾸 새어나가더라고... 너무 먼 계획보단 가까운 계획이 나아!/한 구석에서 어울리지 못하는 내 모습이 세상에서 제일 속상해", "INTJ/INFJ/ENTJ/ENFJ", "ENTP/INTP/ENFP/ESFJ/INFP/ESTP/ESFP"),
("INTJ", "해안", "듀공", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/INTJ.PNG", "주변이 뭐라고 하든 내가 가는 길이 나의 자부심이다.", "아름답고 신비로운 인어는 나를 보고 지어냈어. 그만큼 내가 좀 멋지지/많지는 않지만 10마리 미만의 작은 무리에서 살아가고 있어/해초가 드문드문 나는 곳에서 더 맛있는 해초를 골라먹는 미식가야", "VU(Vulnerable) 등급으로 멸종 위기에 취약한 상태야/나랑 친적이였던 마테나는 이미 18세기에 자취를 감췄어. 나도 그렇게 되는 걸까?/우리는 외동으로 태어나는 경우가 대부분일 정도인데, 우리의 살, 가죽, 기름, 뼈를 얻으려고 무분별하게 우릴 잡아왔어", "체스를 두는 듯이 정확하고 계산된 움직임으로 결단력 있게 행동하는 편이야/외로운 고심을 해도 내가 원하는 진리나 깊이의 지식을 얻을 수 있다면 그 과정도 너무 행복해/대책을 세워가면서 허를 찌르는 기술로 상황을 유리하게 갈 수 있는 능력도 갖고 있어", "ESTP/ESFP/INFP/ISFP", "ESFJ/ISFJ/INTP/ESTJ"),
("INFJ", "해안", "흑범고래", "https://safers.s3.ap-northeast-2.amazonaws.com/survey/INFJ.PNG", "내가 도움을 공유하는 건 결국 이 도움이 필요없도록 하기 위한 내 열망이야.", "나는 따뜻한 바다에서 유유히 헤엄치고 있어/괴롭히거나 위협을 가하는 것들로 부터 날 지킬수 있는 힘도 갖고 있어/온몸 구석구석이 검은색으로 뒤덮여있어 간혹 날 바위로 오해하기도 해", "DD(Data Deficient)로 오랜 시간이 지났지만 날 아직 알지 못할꺼야. 그만큼 잘 보이지 않거든/우리가 잘 보이지 않을 정도로 신비로운 존재라 지구에 몇 마리가 있는지도 파악이 안 될꺼야/조금이라도 소리가 들이면 사라지는 특성이 있어서 더 그럴 수도 있어.", "나긋나긋하게 말하지만 옳다고 생각하는 것에는 지칠 줄 모르고 투쟁할 줄 알아/내가 느끼는 세상은 너무 불평등하고 불공정해. 바로 잡는 것도 중요하지만 나도 잘 챙겨야할 것같아/다른 사람들과 논리나 사실을 이야기하는 딱딱한 대화가 아닌 따뜻하고 섬세한 이야기를 좋아해", "ESTP/ESFP/ISTP/INTP", "ESTJ/ISTJ/INFP/ESFJ/ISFJ");