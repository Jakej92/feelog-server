# Feelog

<h1>함께쓰는 마음일기 - 'Feelog'</h1>

<h2>1. 기획 의도</h2>

<img src="https://github.com/user-attachments/assets/0560e041-2cc7-44d7-ba6d-848b4ea0b412"/>

전 세계적으로 우울증과 자살률은 점차 감소하고 있지만, 우리나라는 여전히 <strong>높은 자살률과 우울증 유병률</strong>을 보이고 있습니다.</br>
기존 일기의 단순 기록 방식에서 벗어나, <strong>감정을 나누고 소통할 수 있는 플랫폼</strong>을 통해 감정의 무게를 덜고자 본 프로젝트를 기획하게 되었습니다.

<h2>2. 기대 효과</h2>

<img src="https://github.com/user-attachments/assets/7216d8d2-99a1-4cbd-a2e8-6c8cbd878cab"/>

<strong>감정 관리 습관을 형성하고 정서적 회복</strong>을 유도합니다.</br>
또한, 커뮤니티 기반의 공감과 응원을 통해 <strong>정서적 안정감</strong>을 제공할 수 있습니다.</br>
일상 속 힐링을 위한 챌린지 참여를 유도하고, 응원 메시지와 이모티콘을 통해 <strong>감정 환기와 긍정적인 경험</strong>을 제공합니다.

<h2>3. 프로젝트 사용 툴</h2>

💻 언어 & 프레임워크
  - Java
  - Javascript
  - Spring Boot
  - Fast API
  - MyBatis
  - JSON
  - Thymeleaf
  - Python

🛠️ 개발 환경 & IDE
  - IntelliJ IDEA
  - Pycharm
  - Visual Studio Code
  - Sourcetree
  - Git, Github
  - Apache Tomcat
  - JDK 11.0.15

🗄️ 데이터베이스 & DB 툴
  - Oracle Database
  - MySql

🌐 API & 외부 서비스
  - Kakao Deverlopers (로그인 API)
  - CoolSMS API
  - OpenAI Platform

📦 빌드 & 의존성 관리
  - Gradle

🔔 협업 & 커뮤니케이션
  - Slack

🎨 디자인 & 퍼블리싱
  - HTML / CSS

📷 기타 도구
  - Thumbnailator
  - Lombok

🧪 테스트 & 디버깅
  - Postman

<h2>4. ERD</h2>

<img src="https://github.com/user-attachments/assets/2357e86f-5406-49a5-ac8e-4dea61ea3208"/>

<h2>5. 담당 업무</h2>
5-1 퍼블리싱

<img src="https://github.com/user-attachments/assets/1ea2bc15-84cf-4cde-8a3b-94e133b4da30"/>

▶ 관리자 페이지
- 관리자 홈, 회원/관리자 목록
- 포스트/감정일기/댓글 신고 목록 및 상세
- 공지사항 목록/등록/수정/상세
- 챌린지 목록/등록/수정/상세
- 자주 묻는 질문 목록/등록/수정

▶ 공지사항
- 공지사항 목록, 상세

▶ 메시지
- 메시지 대화창 UI

▶포스트 게시판/마음기록
- 게시글 및 감정일기 목록, 상세 페이지
- 익명 감정 게시판 및 응원 게시글 구현

5-2 서버

<img src="https://github.com/user-attachments/assets/3382db61-4243-4f11-8122-645515cd6963"/>
<img src="https://github.com/user-attachments/assets/033ce043-2eca-4777-b1be-83d9d61484dd"/>

▶ 관리자 페이지(REST)
- 관리자, 회원 정보 DB 저장 및 소프트 딜리트
- 각종 목록 페이징 (4개씩 표시)
- 공지/챌린지/FAQ 등록 시 이미지 첨부 가능

▶ 공지사항
- 목록 및 상세 조회
- 좋아요 수, 이전/다음 글 출력

▶ 메시지(REST)
- 로그인 검사 후 메시지 목록 출력
- 최근 메시지 내용, 상대 회원 프로필 출력
- 메시지 클릭 시 전체 대화 이력 출력

▶ 포스트 게시판/마음기록
- 일기 작성 시 OpenAI 플랫폼을 통해 긍정적인 오늘의 한마디 제공
- 좋아요/스크랩 기능 REST 방식 구현
- 댓글 입력/조회, 추천 게시글 출력 등 기능 포함
- 비공개/전체공개/구독자 전용 일기 분기 처리
- AI 기반 감정 점수 및 응원 코멘트 출력

<h2>6. 트러블슈팅</h2>

<h3>1. 문제</h3> 
💡 service.js에 너무 많은 fetch 요청이 몰려있어 가독성과 유지보수가 어려웠다.

<img src="https://github.com/user-attachments/assets/955aad5d-289a-4a4b-bc78-0b05e7910f7f"/>

<h3>2. 해결</h3>
✏️ HTML 기준이 아닌 기능 기준으로 모듈화를 진행했다. 각 기능별로 JS 파일을 나누어 중복 방지 및 유지보수 용이성을 확보했다.


<h3>1. 문제</h3>
💡 비공개, 전체공개, 구독자 전용 글을 구분해 보여줘야 했다. 로그인 여부에 따라 보여줘야 할 데이터가 달라 복잡한 로직이 필요해 보였다.

<h3>2. 해결</h3> 
✏️ 아래 쿼리문을 사용하여 로그인한 회원은 전체공개 + 구독자 전용 글을, 비로그인 상태에서는 전체공개 글만 조회하도록 구현하였다

```
 SELECT *
        FROM (SELECT d.id           AS id,
                     m.id           AS member_id,
                     m.member_nickname,
                     m.member_file_path,
                     m.member_file_name,
                     m.member_status,
                     d.diary_title,
                     d.diary_content,
                     d.diary_open,
                     d.diary_name_open,
                     d.diary_file_path,
                     d.diary_file_name,
                     d.diary_status,
                     d.updated_date AS updated_date,
                     d.diary_read_count,
                     c.id           AS channel_id,
                     c.channel_title,
                     c.channel_url,
                     c.channel_file_path,
                     c.channel_file_name,
                     c.channel_status,
                     dm.score_message,
                     d.diary_score
              FROM tbl_member m
                       JOIN tbl_diary d ON m.id = d.member_id
                       JOIN tbl_channel c ON m.id = c.member_id
                       join tbl_diary_score dm on d.diary_score = dm.id
              WHERE d.diary_open IN ('전체 공개', '구독자에게만 공개')) d
        WHERE EXISTS (SELECT 1
                      FROM tbl_subscribe s
                      WHERE s.member_id = #{memberId}
                        AND s.channel_id = d.channel_id)
           OR d.diary_open = '전체 공개'

        UNION

        SELECT *
        FROM (SELECT d.id           AS id,
                     m.id           AS member_id,
                     m.member_nickname,
                     m.member_file_path,
                     m.member_file_name,
                     m.member_status,
                     d.diary_title,
                     d.diary_content,
                     d.diary_open,
                     d.diary_name_open,
                     d.diary_file_path,
                     d.diary_file_name,
                     d.diary_status,
                     d.updated_date AS updated_date,
                     d.diary_read_count,
                     c.id           AS channel_id,
                     c.channel_title,
                     c.channel_url,
                     c.channel_file_path,
                     c.channel_file_name,
                     c.channel_status,
                     dm.score_message,
                     d.diary_score
              FROM tbl_member m
                       JOIN tbl_diary d ON m.id = d.member_id
                       JOIN tbl_channel c ON m.id = c.member_id
                       join tbl_diary_score dm on d.diary_score = dm.id

              WHERE d.diary_open = '전체 공개') d
        WHERE NOT EXISTS (SELECT 1
                          FROM tbl_subscribe
                          WHERE member_id = #{memberId})
        order by id desc
        limit #{postPagination.offset}, #{postPagination.rowCount}
  ```

<h3>1. 문제</h3> 
💡 header.html에서 modal.js의 함수가 정의되지 않았다는 오류 발생했다.

<h3>2. 해결</h3> 
<img src="https://github.com/user-attachments/assets/579eac49-cb76-4b24-84e2-3fd47039c4b7"/>

✏️ modal.js가 먼저 로드되며 의존 모듈보다 먼저 실행되는 문제였다.</br>
스크립트를 하단으로 내려도 해결되지 않아, 모듈화 대신 해당 함수들을 modal.js 내부에 직접 작성하여 처리하였다.


<h2>7. 느낀점</h2>

<h3>🎈성장과 익숙함에서 오는 자신감</h3>
내 자신이 이전 프로젝트보다 발전 했다는 생각이 들었다. 이전 프로젝트와 비교해서 비교적 속도도 붙고, 코드들도 이전 프로젝트에서도 그렇고 현 프로젝트를 진행하면서도 많이 봐왔던 것들이라 막힘없이 할 수 있었다.
또 새로운게 나오더라도 어떻게 작동하는지 전 프로젝트보다는 빠르게 이해 할 수 있어서 새로운 코드도 사용하는데 있어서 어렵지 않았다. 새로운 것을 배울때는 어렵지만 막상 사용 해보고 나니 더 재밋어졌다.

<h3>🎈기획의 중요성과 그에 따른 교훈</h3>
기획의 중요성을 다시 한번 깨달았다. 현 프로젝트를 기획할때 이전의 경험에 빗대어 더욱 꼼꼼하게 기획했다고 자신했지만, 프로그래밍을 하면서 아직 많이 미숙하다는 것을 깨달았다. 빠진 부분들이 하나 둘 보이면서 기획 할 때 비어있던 부분들을 다시 채울 때 힘들었던 경험들은 잊지 못할 것 같다.

<h3>🎈배포 과정에서의 시행착오와 책임감</h3>
프로젝트를 배포하기 전에 더 꼼꼼하게 봐야된다고 생각했다. 배포하기 전에는 잘 되던 서비스들이 배포 이후에는 안되는 부분들이 보이고, 지속적으로 오류가 나면서 코드를 잘못 작성 한것들이 나왔다. 아직 실력은 미숙하지만 그래도 배포 하는 것을 염두해두고 코드를 짜야 한다는 것을 깨달았다.

<h3>🎈첫 단추를 잘 꿰자</h3>
코드를 짤 때보다 디버깅하는 시간이 더 오래 걸리는 경우가 많았다. 꼼꼼하게 보지 않아서 보내지 못한 데이터들이나, 쿼리문의 사소한 것 하나하나가 빠져서 그것들을 찾아내고 다시 수정하는 작업이 처음부터 코드를 짜는 것과 크게 다를 것 없다고 느꼇다. 이렇게 디버깅을 하면서 더 확실하고 꼼꼼하게 코드를 짜야 하겠다고 생각했다.

<h3>🎈문서화의 필요성</h3>
작업한 내용을 기록하지 않으면 나중에 자신이 짠 코드조차 이해하기 힘들었다. 아직까지는 내가 작성한 코드들이어도 한눈에 알아보기 힘들었다. 코드를 좀 훑어보고 나서야 어떻게 작동한는 코드인지 이해가 갔다. 이뿐만 아니라 다른 사람의 코드를 볼때는 내가 짯던 코드들을 볼떄보다 더 이해하기 힘들었다.
이런 경험들로 인해 내가 짠 코드들에 주석을 달고 추후에 프로젝트를 맡게되어 프로젝트 규모가 커진다면 문서화 시키는 것이 반드시 필요하다고 느꼇다.
