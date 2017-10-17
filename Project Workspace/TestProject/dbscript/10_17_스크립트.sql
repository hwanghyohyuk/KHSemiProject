PROMPT StudyHub 자료입력시작

set feedback ON;
set define ON;

DROP TABLE TB_USER CASCADE CONSTRAINTS;
PROMPT DROPPING TB_USER TABLE...
DROP TABLE TB_GROUP CASCADE CONSTRAINTS;
PROMPT DROPPING TB_GROUP TABLE...
DROP TABLE TB_AUTHORITY CASCADE CONSTRAINTS;
PROMPT DROPPING TB_AUTHORITY TABLE...
DROP TABLE TB_UNG CASCADE CONSTRAINTS;
PROMPT DROPPING TB_UNG TABLE...
DROP TABLE TB_CATEGORY CASCADE CONSTRAINTS;
PROMPT DROPPING TB_CATEGORY TABLE...
DROP TABLE TB_ACCESS CASCADE CONSTRAINTS;
PROMPT DROPPING TB_ACCESS TABLE...
DROP TABLE TB_NOTICE CASCADE CONSTRAINTS;
PROMPT DROPPING TB_NOTICE TABLE...
--DROP TABLE TB_NOTICE_COMMENT CASCADE CONSTRAINTS;
--PROMPT DROPPING TB_NOTICE_COMMENT TABLE...
DROP TABLE TB_BOARD CASCADE CONSTRAINTS;
PROMPT DROPPING TB_BOARD TABLE...
DROP TABLE TB_BOARD_COMMENT CASCADE CONSTRAINTS;
PROMPT DROPPING TB_BOARD_COMMENT TABLE...
DROP TABLE TB_FAQ_CATEGORY CASCADE CONSTRAINTS;
PROMPT DROPPING TB_FAQ_CATEGORY TABLE...
DROP TABLE TB_FAQ CASCADE CONSTRAINTS;
PROMPT DROPPING TB_FAQ TABLE...
DROP TABLE TB_QNA CASCADE CONSTRAINTS;
PROMPT DROPPING TB_QNA TABLE...
DROP TABLE TB_QNA_COMMENT CASCADE CONSTRAINTS;
PROMPT DROPPING TB_QNA_COMMENT TABLE..
DROP TABLE TB_G_NOTICE CASCADE CONSTRAINTS;
PROMPT DROPPING TB_G_NOTICE TABLE...
DROP TABLE TB_GN_COMMENT CASCADE CONSTRAINTS;
PROMPT DROPPING TB_GN_COMMENT TABLE...
DROP TABLE TB_G_BOARD CASCADE CONSTRAINTS;
PROMPT DROPPING TB_G_BOARD TABLE...
DROP TABLE TB_GB_COMMENT CASCADE CONSTRAINTS;
PROMPT DROPPING TB_GB_COMMENT TABLE...
DROP TABLE TB_G_QNA CASCADE CONSTRAINTS;
PROMPT DROPPING TB_G_QNA TABLE...
DROP TABLE TB_GQ_COMMENT CASCADE CONSTRAINTS;
PROMPT DROPPING TB_GQ_COMMENT TABLE...
DROP TABLE TB_SCHEDULE CASCADE CONSTRAINTS;
PROMPT DROPPING TB_SCHEDULE TABLE...
DROP TABLE TB_SHARE_FILE CASCADE CONSTRAINTS;
PROMPT DROPPING TB_SHARE_FILE TABLE...
DROP TABLE TB_ON_OFF CASCADE CONSTRAINTS;
PROMPT DROPPING TB_ON_OFF TABLE...
DROP TABLE TB_MESSAGE CASCADE CONSTRAINTS;
PROMPT DROPPING TB_MESSAGE TABLE...
--DROP TRIGGER MESSAGE_DELETE CASCADE;
--PROMPT DROPPING MESSAGE_DELETE TRIGGER...

-- 1.유저테이블 생성,,
PROMPT CREATING User TABLE ...
CREATE TABLE TB_USER (
  User_No INTEGER CONSTRAINT PK_USER PRIMARY KEY,
  Email VARCHAR2(30) NOT NULL,
  USer_Name VARCHAR2(10) NOT NULL,
  User_Pwd VARCHAR2(20) NOT NULL,
  Phone VARCHAR2(13)
);
COMMENT ON COLUMN TB_USER.User_No IS '유저번호';
COMMENT ON COLUMN TB_USER.Email IS '이메일';
COMMENT ON COLUMN TB_USER.User_Name IS '이름';
COMMENT ON COLUMN TB_USER.User_Pwd IS '비밀번호';
COMMENT ON COLUMN TB_USER.Phone IS '전화번호';

-- 2.그룹테이블 생성
PROMPT CREATING Group TABLE..
CREATE TABLE TB_GROUP (
  Group_No INTEGER CONSTRAINT PK_GROUP PRIMARY KEY,
  Group_Name VARCHAR2(50) NOT NULL,
  ATTRIBUTE_NO INTEGER,
  Location VARCHAR2(20),
  Category_No INTEGER,
  DESCRIPTION VARCHAR2(100),
  G_IMG_ORIGINAL VARCHAR2(100),
  G_IMG_RENAME VARCHAR2(100)
);
COMMENT ON COLUMN TB_GROUP.Group_No IS '그룹번호';
COMMENT ON COLUMN TB_GROUP.Group_Name IS '그룹이름';
COMMENT ON COLUMN TB_GROUP.Attribute_NO IS '온/오프';
COMMENT ON COLUMN TB_GROUP.Location IS '지역';
COMMENT ON COLUMN TB_GROUP.Category_No IS '분류번호';
COMMENT ON COLUMN TB_GROUP.DESCRIPTION IS '그룹설명';
COMMENT ON COLUMN TB_GROUP.G_IMG_ORIGINAL IS '그룹이미지원래이름';
COMMENT ON COLUMN TB_GROUP.G_IMG_RENAME IS '그룹이미지변경이름';

-- 3.권한테이블 생성
PROMPT CREATING Authority TABLE...
CREATE TABLE TB_AUTHORITY (
  AUTHORITY_No INTEGER CONSTRAINT PK_AUTH PRIMARY KEY,
  AUTHORITY_Name VARCHAR2(10) NOT NULL
);
COMMENT ON COLUMN TB_AUTHORITY.AUTHORITY_No IS '권한번호';
COMMENT ON COLUMN TB_AUTHORITY.AUTHORITY_Name IS '권한이름';

-- 4.UnG테이블 생성
PROMPT CREATING UNG TABLE...
CREATE TABLE TB_UNG (
  UNG_NO INTEGER CONSTRAINT PK_UNG PRIMARY KEY,
  USER_No INTEGER,
  GROUP_No INTEGER,
  AUTHORITY_No INTEGER
);
COMMENT ON COLUMN TB_UNG.UNG_NO IS 'ung번호';
COMMENT ON COLUMN TB_UNG.USER_No IS '유저번호';
COMMENT ON COLUMN TB_UNG.GROUP_No IS '그룹번호';
COMMENT ON COLUMN TB_UNG.AUTHORITY_No IS '권한번호';

ALTER TABLE TB_UNG
 ADD CONSTRAINT FK1_UNG FOREIGN KEY(USER_No) REFERENCES TB_USER;
ALTER TABLE TB_UNG
 ADD CONSTRAINT FK2_UNG FOREIGN KEY(GROUP_No) REFERENCES TB_GROUP;
ALTER TABLE TB_UNG
 ADD CONSTRAINT FK3_UNG FOREIGN KEY(AUTHORITY_No) REFERENCES TB_AUTHORITY;
  
-- 5.Category 테이블 생성
PROMPT CREATING CATEGORY TABLE....
CREATE TABLE TB_CATEGORY (
  CATEGORY_NO INTEGER CONSTRAINT PK_CATEGORY PRIMARY KEY,
  CATEGORY_NAME VARCHAR2(20)
);
COMMENT ON COLUMN TB_CATEGORY.CATEGORY_NO IS '분류번호';
COMMENT ON COLUMN TB_CATEGORY.CATEGORY_NAME IS '분류이름';

ALTER TABLE TB_GROUP
  ADD CONSTRAINT FK_GROUP FOREIGN KEY(CATEGORY_NO) REFERENCES TB_CATEGORY;
  
-- 6.Access 테이블 생성
PROMPT CREATING ACCESS TABLE...
CREATE TABLE TB_ACCESS (
  ACCESS_NO  INTEGER CONSTRAINT PK_ACCESS PRIMARY KEY,
  ACCESS_RIGHT  VARCHAR2(100) CHECK(ACCESS_RIGHT IN('전체공개', '회원만', '그룹원만'))
);
COMMENT ON COLUMN TB_ACCESS.ACCESS_NO IS '권한번호';
COMMENT ON COLUMN TB_ACCESS.ACCESS_RIGHT IS '권한이름';

-- 7.전체 공지 테이블 생성
PROMPT CREATING NOTICE TABLE...
CREATE TABLE TB_NOTICE (
  CONTENT VARCHAR2(1000),
);
COMMENT ON COLUMN TB_NOTICE.CONTENT IS '공지내용';
  
-- 9.모집게시판 테이블 생성
PROMPT CREATING BOARD TABLE...
CREATE TABLE TB_BOARD (
  BOARD_NO INTEGER CONSTRAINT PK_BOARD PRIMARY KEY,
  TITLE VARCHAR2(20),
  CONTENT VARCHAR2(500),
  UPLOAD_DATE DATE,
  UPLOADER INTEGER
);
COMMENT ON COLUMN TB_BOARD.BOARD_NO IS '모집글번호';
COMMENT ON COLUMN TB_BOARD.TITLE IS '모집글제목';
COMMENT ON COLUMN TB_BOARD.CONTENT IS '모집글내용';
COMMENT ON COLUMN TB_BOARD.UPLOAD_DATE IS '작성일';
COMMENT ON COLUMN TB_BOARD.UPLOADER IS '작성자';

ALTER TABLE TB_BOARD
  ADD CONSTRAINT FK_B_UPLOADER FOREIGN KEY(UPLOADER) REFERENCES TB_UNG;
  
-- 10. 모집게시판 댓글 테이블 생성
PROMPT CREATING BOARD_COMMENT TABLE...
CREATE TABLE TB_BOARD_COMMENT (
  COMMENT_NO INTEGER CONSTRAINTS PK_B_COMMENT PRIMARY KEY,
  BOARD_NO INTEGER,
  CONTENT VARCHAR2(100),
  UPLOAD_DATE DATE,
  USER_NO INTEGER,
  ACCESS_NO INTEGER
);
COMMENT ON COLUMN TB_BOARD_COMMENT.COMMENT_NO IS '모집댓글번호';
COMMENT ON COLUMN TB_BOARD_COMMENT.BOARD_NO IS '모집글번호';
COMMENT ON COLUMN TB_BOARD_COMMENT.CONTENT IS '모집글댓글내용';
COMMENT ON COLUMN TB_BOARD_COMMENT.UPLOAD_DATE IS '작성일';
COMMENT ON COLUMN TB_BOARD_COMMENT.USER_NO IS '작성자';
COMMENT ON COLUMN TB_BOARD_COMMENT.ACCESS_NO IS '접근번호';

ALTER TABLE TB_BOARD_COMMENT
  ADD CONSTRAINT FK_BC_NO FOREIGN KEY(BOARD_NO) REFERENCES TB_BOARD;
ALTER TABLE TB_BOARD_COMMENT
  ADD CONSTRAINT FK_BC_USER FOREIGN KEY(USER_NO) REFERENCES TB_USER;
ALTER TABLE TB_BOARD_COMMENT
  ADD CONSTRAINT FK_BC_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;

-- 11. FAQ 카테고리 테이블 생성
PROMPT CREATING FAQ_CATEGORY TABLE...
CREATE TABLE TB_FAQ_CATEGORY (
  FAQ_CATEGORY_NO INTEGER CONSTRAINTS PK_FAQ_C PRIMARY KEY,
  FAQ_CATEGORY_NAME VARCHAR2(100)
);
COMMENT ON COLUMN TB_FAQ_CATEGORY.FAQ_CATEGORY_NO IS 'FAQ분류번호';
COMMENT ON COLUMN TB_FAQ_CATEGORY.FAQ_CATEGORY_NAME IS 'FAQ분류이름';

-- 12. FAQ 게시판 테이블 생성
PROMPT CREATING FAQ TABLE...
CREATE TABLE TB_FAQ (
  FAQ_NO INTEGER CONSTRAINTS PK_FAQ PRIMARY KEY,
  TITLE VARCHAR2(60),
  CONTENT VARCHAR2(500),
  FAQ_CATEGORY_NO INTEGER
);
COMMENT ON COLUMN TB_FAQ.FAQ_NO IS 'FAQ글번호';
COMMENT ON COLUMN TB_FAQ.TITLE IS 'FAQ제목';
COMMENT ON COLUMN TB_FAQ.CONTENT IS 'FAQ내용';
COMMENT ON COLUMN TB_FAQ.FAQ_CATEGORY_NO IS 'FAQ분류번호';

ALTER TABLE TB_FAQ
  ADD CONSTRAINT FK_FAQ_CATEGORY FOREIGN KEY(FAQ_CATEGORY_NO) REFERENCES TB_FAQ_CATEGORY;
  
-- 13. QNA 테이블 생성
PROMPT CREATING QNA TABLE...
CREATE TABLE TB_QNA (
  QNA_NO INTEGER CONSTRAINT PK_QNA PRIMARY KEY,
  TITLE VARCHAR2(20),
  CONTENT VARCHAR2(100),
  UPLOAD_DATE DATE,
  USER_NO INTEGER,
  ACCESS_NO INTEGER
);
COMMENT ON COLUMN TB_QNA.QNA_NO IS 'QNA번호';
COMMENT ON COLUMN TB_QNA.TITLE IS 'QNA제목';
COMMENT ON COLUMN TB_QNA.CONTENT IS 'QNA내용';
COMMENT ON COLUMN TB_QNA.UPLOAD_DATE IS '작성일';
COMMENT ON COLUMN TB_QNA.USER_NO IS '작성자';
COMMENT ON COLUMN TB_QNA.ACCESS_NO IS '접근번호';

ALTER TABLE TB_QNA
  ADD CONSTRAINT FK_QNA_USER FOREIGN KEY(USER_NO) REFERENCES TB_USER;
ALTER TABLE TB_QNA
  ADD CONSTRAINT FK_QNA_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;

-- 14. QNA댓글 테이블 생성
PROMPT CREATING QNA_COMMENT TABLE...
CREATE TABLE TB_QNA_COMMENT (
  COMMENT_NO INTEGER CONSTRAINTS PK_Q_COMMENT PRIMARY KEY,
  QNA_NO INTEGER,
  CONTENT VARCHAR2(100),
  UPLOAD_DATE DATE,
  USER_NO INTEGER,
  ACCESS_NO INTEGER
);
COMMENT ON COLUMN TB_QNA_COMMENT.COMMENT_NO IS 'QNA댓글번호';
COMMENT ON COLUMN TB_QNA_COMMENT.QNA_NO IS 'QNA번호';
COMMENT ON COLUMN TB_QNA_COMMENT.CONTENT IS 'QNA댓글내용';
COMMENT ON COLUMN TB_QNA_COMMENT.UPLOAD_DATE IS 'Q작성일';
COMMENT ON COLUMN TB_QNA_COMMENT.USER_NO IS '작성자';
COMMENT ON COLUMN TB_QNA_COMMENT.ACCESS_NO IS '접근번호';

ALTER TABLE TB_QNA_COMMENT
  ADD CONSTRAINT FK_QC_NO FOREIGN KEY(QNA_NO) REFERENCES TB_QNA;
 ALTER TABLE TB_QNA_COMMENT
  ADD CONSTRAINT FK_QC_USER FOREIGN KEY(USER_NO) REFERENCES TB_USER;
ALTER TABLE TB_QNA_COMMENT
  ADD CONSTRAINT FK_QC_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;

-- 15. 그룹공지게시판 테이블 생성
PROMPT CREATING G_NOTICE TABLE...
CREATE TABLE TB_G_NOTICE (
  NOTICE_NO INTEGER CONSTRAINTS PK_G_NOTICE PRIMARY KEY,
  TITLE VARCHAR2(20),
  CONTENT VARCHAR2(500),
  UPLOAD_DATE DATE,
  UPLOADER INTEGER,
  ACCESS_NO INTEGER,
  GROUP_NO INTEGER
);
COMMENT ON COLUMN TB_G_NOTICE.NOTICE_NO IS '그룹공지번호';
COMMENT ON COLUMN TB_G_NOTICE.TITLE IS '그룹공지제목';
COMMENT ON COLUMN TB_G_NOTICE.CONTENT IS '그룹공지내용';
COMMENT ON COLUMN TB_G_NOTICE.UPLOAD_DATE IS '작성일';
COMMENT ON COLUMN TB_G_NOTICE.UPLOADER IS '작성자';
COMMENT ON COLUMN TB_G_NOTICE.ACCESS_NO IS '접근번호';
COMMENT ON COLUMN TB_G_NOTICE.GROUP_NO IS '그룹번호';

ALTER TABLE TB_G_NOTICE 
  ADD CONSTRAINT FK_GN_UPLOADER FOREIGN KEY(UPLOADER) REFERENCES TB_UNG;
ALTER TABLE TB_G_NOTICE
  ADD CONSTRAINT FK_GN_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;
ALTER TABLE TB_G_NOTICE
  ADD CONSTRAINT FK_GN_GROUP FOREIGN KEY(GROUP_NO) REFERENCES TB_GROUP;
  
-- 16.그룹공지 댓글 테이블 생성
PROMPT CREATING GN_COMMENT TABLE...
CREATE TABLE TB_GN_COMMENT (
  COMMENT_NO INTEGER CONSTRAINTS PK_GN_COMMENT PRIMARY KEY,
  NOTICE_NO INTEGER,
  CONTENT VARCHAR2(100),
  UPLOAD_DATE DATE,
  UPLOADER INTEGER,
  ACCESS_NO INTEGER
);
COMMENT ON COLUMN TB_GN_COMMENT.COMMENT_NO IS '그룹공지댓글번호';
COMMENT ON COLUMN TB_GN_COMMENT.NOTICE_NO IS '그룹공지번호';
COMMENT ON COLUMN TB_GN_COMMENT.CONTENT IS '그룹공지댓글내용';
COMMENT ON COLUMN TB_GN_COMMENT.UPLOAD_DATE IS '작성일';
COMMENT ON COLUMN TB_GN_COMMENT.UPLOADER IS '작성자';
COMMENT ON COLUMN TB_GN_COMMENT.ACCESS_NO IS '접근번호';

ALTER TABLE TB_GN_COMMENT
  ADD CONSTRAINT FK_GNC_NOTICE FOREIGN KEY(NOTICE_NO) REFERENCES TB_G_NOTICE;
ALTER TABLE TB_GN_COMMENT
  ADD CONSTRAINT FK_GNC_UPLOADER FOREIGN KEY(UPLOADER) REFERENCES TB_UNG;
ALTER TABLE TB_GN_COMMENT
  ADD CONSTRAINT FK_GNC_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;
  
-- 17. 그룹자유게시판 테이블 생성
PROMPT CREATING G_BOARD TABLE...
CREATE TABLE TB_G_BOARD (
  G_BOARD_NO INTEGER CONSTRAINTS PK_G_BOARD PRIMARY KEY,
  TITLE VARCHAR2(20),
  CONTENT VARCHAR2(500),
  UPLOAD_DATE DATE,
  UPLOADER INTEGER,
  ACCESS_NO INTEGER,
  GROUP_NO INTEGER
);
COMMENT ON COLUMN TB_G_BOARD.G_BOARD_NO IS '그룹게시판번호';
COMMENT ON COLUMN TB_G_BOARD.TITLE IS '그룹게시판제목';
COMMENT ON COLUMN TB_G_BOARD.CONTENT IS '그룹게시판내용';
COMMENT ON COLUMN TB_G_BOARD.UPLOAD_DATE IS '작성일';
COMMENT ON COLUMN TB_G_BOARD.UPLOADER IS '작성자';
COMMENT ON COLUMN TB_G_BOARD.ACCESS_NO IS '접근번호';
COMMENT ON COLUMN TB_G_BOARD.GROUP_NO IS '그룹번호';

ALTER TABLE TB_G_BOARD
  ADD CONSTRAINT FK_GB_UPLOADER FOREIGN KEY(UPLOADER) REFERENCES TB_UNG;
ALTER TABLE TB_G_BOARD
  ADD CONSTRAINT FK_GB_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;
ALTER TABLE TB_G_BOARD
  ADD CONSTRAINT FK_GB_GROUP FOREIGN KEY(GROUP_NO) REFERENCES TB_GROUP;
  
-- 18. 그룹게시판 댓글 테이블 생성
PROMPT CREATING GB_COMMENT TABLE...
CREATE TABLE TB_GB_COMMENT (
  COMMENT_NO INTEGER CONSTRAINTS PK_GB_COMMENT PRIMARY KEY,
  G_BOARD_NO INTEGER,
  CONTENT VARCHAR2(100),
  UPLOAD_DATE DATE,
  UPLOADER INTEGER,
  ACCESS_NO INTEGER
);
COMMENT ON COLUMN TB_GB_COMMENT.COMMENT_NO IS '그룹게시판댓글번호';
COMMENT ON COLUMN TB_GB_COMMENT.G_BOARD_NO IS '그룹게시판번호';
COMMENT ON COLUMN TB_GB_COMMENT.CONTENT IS '그룹게시판댓글내용';
COMMENT ON COLUMN TB_GB_COMMENT.UPLOAD_DATE IS '그룹게시판댓글작성일';
COMMENT ON COLUMN TB_GB_COMMENT.UPLOADER IS '작성자';
COMMENT ON COLUMN TB_GB_COMMENT.ACCESS_NO IS '접근번호';

ALTER TABLE TB_GB_COMMENT
  ADD CONSTRAINT FK_GBC_NOTICE FOREIGN KEY(G_BOARD_NO) REFERENCES TB_G_BOARD;
ALTER TABLE TB_GB_COMMENT
  ADD CONSTRAINT FK_GBC_UPLOADER FOREIGN KEY(UPLOADER) REFERENCES TB_UNG;
ALTER TABLE TB_GB_COMMENT
  ADD CONSTRAINT FK_GBC_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;
  
-- 19. 그룹 QNA 게시판 테이블 생성
PROMPT CREATING G_QNA TABLE...
CREATE TABLE TB_G_QNA (
  G_QNA_NO INTEGER CONSTRAINTS PK_G_QNA PRIMARY KEY,
  TITLE VARCHAR2(20),
  CONTENT VARCHAR2(500),
  UPLOAD_DATE DATE,
  UPLOADER INTEGER,
  ACCESS_NO INTEGER,
  GROUP_NO INTEGER
);
COMMENT ON COLUMN TB_G_QNA.G_QNA_NO IS 'QNA글번호';
COMMENT ON COLUMN TB_G_QNA.TITLE IS 'QNA글제목';
COMMENT ON COLUMN TB_G_QNA.CONTENT IS 'QNA글내용';
COMMENT ON COLUMN TB_G_QNA.UPLOAD_DATE IS '작성일';
COMMENT ON COLUMN TB_G_QNA.UPLOADER IS '작성자';
COMMENT ON COLUMN TB_G_QNA.ACCESS_NO IS '접근번호';
COMMENT ON COLUMN TB_G_QNA.GROUP_NO IS '그룹번호';

ALTER TABLE TB_G_QNA
  ADD CONSTRAINT FK_GQ_UPLOADER FOREIGN KEY(UPLOADER) REFERENCES TB_UNG;
ALTER TABLE TB_G_QNA
  ADD CONSTRAINT FK_GQ_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;
ALTER TABLE TB_G_QNA
  ADD CONSTRAINT FK_GQ_GROUP FOREIGN KEY(GROUP_NO) REFERENCES TB_GROUP;  
-- 20. 그룹QNA 댓글 테이블 생성
PROMPT CREATING GQ_COMMENT TABLE...
CREATE TABLE TB_GQ_COMMENT (
  COMMENT_NO INTEGER CONSTRAINTS PK_GQ_COMMENT PRIMARY KEY,
  G_QNA_NO INTEGER,
  CONTENT VARCHAR2(100),
  UPLOAD_DATE DATE,
  UPLOADER INTEGER,
  ACCESS_NO INTEGER
);
COMMENT ON COLUMN TB_GQ_COMMENT.COMMENT_NO IS '그룹QNA댓글번호';
COMMENT ON COLUMN TB_GQ_COMMENT.G_QNA_NO IS 'QNA글번호';
COMMENT ON COLUMN TB_GQ_COMMENT.CONTENT IS '그룹QNA댓글내용';
COMMENT ON COLUMN TB_GQ_COMMENT.UPLOAD_DATE IS '작성일';
COMMENT ON COLUMN TB_GQ_COMMENT.UPLOADER IS '작성자';
COMMENT ON COLUMN TB_GQ_COMMENT.ACCESS_NO IS '접근번호';

ALTER TABLE TB_GQ_COMMENT
  ADD CONSTRAINT FK_GQC_NOTICE FOREIGN KEY(G_QNA_NO) REFERENCES TB_G_QNA;
ALTER TABLE TB_GQ_COMMENT
  ADD CONSTRAINT FK_GQC_UPLOADER FOREIGN KEY(UPLOADER) REFERENCES TB_UNG;
ALTER TABLE TB_GQ_COMMENT
  ADD CONSTRAINT FK_GQC_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;
  
-- 21. 스케줄 테이블 생성
PROMPT CREATING SCHEDULE TABLE...
CREATE TABLE TB_SCHEDULE (
  SCHEDULE_NO INTEGER CONSTRAINTS PK_SCHEDULE PRIMARY KEY,
  MEETING_DATE DATE,
  GROUP_NO INTEGER,
  UNG_NO INTEGER,
  MEETING_NAME VARCHAR2(500)
);
COMMENT ON COLUMN TB_SCHEDULE.SCHEDULE_NO IS '일정번호';
COMMENT ON COLUMN TB_SCHEDULE.MEETING_DATE IS '모임날짜';
COMMENT ON COLUMN TB_SCHEDULE.GROUP_NO IS '그룹번호';
COMMENT ON COLUMN TB_SCHEDULE.UNG_NO IS 'UNG번호';
COMMENT ON COLUMN TB_SCHEDULE.MEETING_NAME IS '모임내용';

ALTER TABLE TB_SCHEDULE
  ADD CONSTRAINT FK_S_GROUP FOREIGN KEY(GROUP_NO) REFERENCES TB_GROUP;
ALTER TABLE TB_SCHEDULE
  ADD CONSTRAINT FK_S_UNG FOREIGN KEY(UNG_NO) REFERENCES TB_UNG;
  
-- 22.파일공유게시판 테이블 생성
PROMPT CREATING SHARE_FILE TABLE...
CREATE TABLE TB_SHARE_FILE (
  FILE_NO INTEGER CONSTRAINTS PK_SHARE PRIMARY KEY,
  TITLE VARCHAR2(20),
  CONTENT VARCHAR2(500),
  UPLOAD_DATE DATE,
  ORIGINALFILENAME VARCHAR2(100),
  RENAMEFILENAME VARCHAR2(100),
  UPLOADER INTEGER,
  ACCESS_NO INTEGER
);
COMMENT ON COLUMN TB_SHARE_FILE.FILE_NO IS '파일공유번호';
COMMENT ON COLUMN TB_SHARE_FILE.TITLE IS '파일공유제목';
COMMENT ON COLUMN TB_SHARE_FILE.CONTENT IS '파일공유내용';
COMMENT ON COLUMN TB_SHARE_FILE.UPLOAD_DATE IS '파일공유작성일';
COMMENT ON COLUMN TB_SHARE_FILE.ORIGINALFILENAME IS '원래파일이름';
COMMENT ON COLUMN TB_SHARE_FILE.RENAMEFILENAME IS '바뀐파일이름';
COMMENT ON COLUMN TB_SHARE_FILE.UPLOADER IS '작성자';
COMMENT ON COLUMN TB_SHARE_FILE.ACCESS_NO IS '접근번호';
  
ALTER TABLE TB_SHARE_FILE
  ADD CONSTRAINT FK_SF_UPLOADER FOREIGN KEY(UPLOADER) REFERENCES TB_UNG;
ALTER TABLE TB_SHARE_FILE
  ADD CONSTRAINT FK_SF_ACCESS FOREIGN KEY(ACCESS_NO) REFERENCES TB_ACCESS;
  
-- 23. ON/OFF 테이블 생성
PROMPT CREATING ON_OFF TABLE...
CREATE TABLE TB_ON_OFF (
  ATTRIBUTE_NO INTEGER CONSTRAINT PK_ON_OFF PRIMARY KEY,
  ATTRIBUTE_NAME VARCHAR2(10) default 2
);
COMMENT ON COLUMN TB_ON_OFF.ATTRIBUTE_NO IS '온오프번호';
COMMENT ON COLUMN TB_ON_OFF.ATTRIBUTE_NAME IS '온오프이름';

ALTER TABLE TB_GROUP
  ADD CONSTRAINT FK_ATTRIBUTE FOREIGN KEY(ATTRIBUTE_NO) REFERENCES TB_ON_OFF;
  
-- 24.  Message 테이블 생성
PROMPT CREATING MESSAGE TABLE...
CREATE TABLE TB_MESSAGE (
  MESSAGE_NO INTEGER CONSTRAINT PK_MESSAGE PRIMARY KEY,
  SENDER INTEGER,
  RECEIVER INTEGER,
  MESSAGE_STATE INTEGER,
  MESSAGE VARCHAR2(500),
  CONSTRAINT STATE_CHECK CHECK(MESSAGE_STATE IN (1,2,3,4,5,6))
);
COMMENT ON COLUMN TB_MESSAGE.MESSAGE_NO IS '메시지번호';
COMMENT ON COLUMN TB_MESSAGE.SENDER IS '보낸이';
COMMENT ON COLUMN TB_MESSAGE.RECEIVER IS '받는이';
COMMENT ON COLUMN TB_MESSAGE.MESSAGE IS '메시지';
COMMENT ON COLUMN TB_MESSAGE.MESSAGE_STATE IS '메시지상태확인';

ALTER TABLE TB_MESSAGE
  ADD CONSTRAINT FK_SENDER FOREIGN KEY(SENDER) REFERENCES TB_USER;
ALTER TABLE TB_MESSAGE
  ADD CONSTRAINT FK_RECEIVER FOREIGN KEY(RECEIVER) REFERENCES TB_USER;
  
-- 메시지테이블 트리거 설정
/
CREATE TRIGGER MESSAGE_DELETE AFTER UPDATE ON TB_MESSAGE
  FOR EACH ROW
  BEGIN
    DELETE FROM TB_MESSAGE WHERE DELETE_SEND = 1 AND DELETE_RECEIVE = 1;
    COMMIT;
  END;
  /


-- 샘플 데이터 삽입
--- 샘플 데이터 고정값들 
PROMPT INSERT DATA 권한..
INSERT INTO TB_AUTHORITY VALUES(1, '회원');
INSERT INTO TB_AUTHORITY VALUES(2, '그룹장');

PROMPT INSERT DATA 그룹분류..
INSERT INTO TB_CATEGORY VALUES(1, '토익');
INSERT INTO TB_CATEGORY VALUES(2, '영어회화');
INSERT INTO TB_CATEGORY VALUES(3, '중국어');
INSERT INTO TB_CATEGORY VALUES(4, '제2외국어');
INSERT INTO TB_CATEGORY VALUES(5, 'IT/컴퓨터');
INSERT INTO TB_CATEGORY VALUES(6, '독서모임');
INSERT INTO TB_CATEGORY VALUES(7, '취업스터디');
INSERT INTO TB_CATEGORY VALUES(8, '기타');

PROMPT INSERT DATA 온오프...
INSERT INTO TB_ON_OFF VALUES(1, 'ONLINE');
INSERT INTO TB_ON_OFF VALUES(2, 'OFFLINE');

PROMPT INSERT DATA FAQ카테고리...
INSERT INTO TB_FAQ_CATEGORY VALUES(1, '회원가입');
INSERT INTO TB_FAQ_CATEGORY VALUES(2, '스터디찾기');
INSERT INTO TB_FAQ_CATEGORY VALUES(3, '그룹페이지');
INSERT INTO TB_FAQ_CATEGORY VALUES(4, '파일공유관련');

PROMPT INSERT DATA 접근권한...
INSERT INTO TB_ACCESS VALUES(1, '전체공개');
INSERT INTO TB_ACCESS VALUES(2, '회원만');
INSERT INTO TB_ACCESS VALUES(3, '그룹원만');

PROMPT INSERT DATA 유저테이블...
INSERT INTO TB_USER VALUES(1, 'admin@admin.com', '관리자', 'admin', '01012345678');
INSERT INTO TB_USER VALUES(2, 'user11@iei.or.kr', '홍길동', 'pass11', '01088887777');
INSERT INTO TB_USER VALUES(3, 'user22@naver.com', '임꺽정', 'pass22', '01033334455');
INSERT INTO TB_USER VALUES(4, 'user33@google.com', '김구글', 'pass33', '01099999999');
INSERT INTO TB_USER VALUES(5, 'user44@daum.net', '박다음', 'pass44', '01022223333');
INSERT INTO TB_USER VALUES(6, 'user55@yahoo.co.kr', '최야후', 'pass55', '01044442222');

PROMPT INSERT DATA 그룹생성..
INSERT INTO TB_GROUP VALUES(1, 'TOEIC', 1, '서울', 1, '토익온오프라인모임', null, null);
INSERT INTO TB_GROUP VALUES(2, '영어회화방',  2, '경기도', 2, '만나서회화까지', null, null);

PROMPT INSERT DATA UNG!...
INSERT INTO TB_UNG VALUES(1,2,1,2); -- 유저2번 그룹1번 그룹장
INSERT INTO TB_UNG VALUES(2,3,1,1); -- 유저3번 그룹1번 회원
INSERT INTO TB_UNG VALUES(3,5,1,1); -- 유저5번 그룹1번 회원
INSERT INTO TB_UNG VALUES(4,6,1,1); -- 유저6번 그룹1번 회원
INSERT INTO TB_UNG VALUES(5,4,2,2); -- 유저4번 그룹2번 그룹장
INSERT INTO TB_UNG VALUES(6,2,2,1); -- 유저2번 그룹2번 회원(유저2번은 그룹1번 그룹장)
INSERT INTO TB_UNG VALUES(7,3,2,1); -- 유저3번 그룹2번 회원
INSERT INTO TB_UNG VALUES(8,6,2,1); -- 유저6번 그룹2번 회원

---추가 
PROMPT INSERT DATA 그룹QNA...
INSERT INTO TB_G_QNA VALUES(1,'첫번째모임','언제에요?',SYSDATE,2,1,1);
INSERT INTO TB_G_QNA VALUES(2,'모임장소대여','어디가좋을까요',SYSDATE,3,2,2);
INSERT INTO TB_G_QNA VALUES(3,'두번째모임','언제에요?',SYSDATE,2,1,1);
INSERT INTO TB_G_QNA VALUES(4,'세번째모임','언제에요?',SYSDATE,2,1,1);

PROMPT INSERT DATA 그룹QNA_댓글...
INSERT INTO TB_GQ_COMMENT VALUES(1, 1,'9월27일수요일입니다!',SYSDATE,4,1);
INSERT INTO TB_GQ_COMMENT VALUES(2, 2,'사당역스벅좋아요',SYSDATE,2,2); 
INSERT INTO TB_GQ_COMMENT VALUES(3, 1,'test11',SYSDATE,4,1); 
INSERT INTO TB_GQ_COMMENT VALUES(4, 1,'사당역스벅좋아요',SYSDATE,2,2); 

PROMPT INSERT DATA QNA(사이트)...
INSERT INTO TB_QNA VALUES(1,'STUDYHUB이용','혹시 수수료있나요?',SYSDATE,2,1);
INSERT INTO TB_QNA VALUES(2,'STUDYHUB','사진만한꺼번에저장하는기능은없나요?',SYSDATE,3,2);

PROMPT INSERT DATA QNA 댓글...
INSERT INTO TB_QNA_COMMENT VALUES(1,1,'수수료는 없습니다',SYSDATE,1,1);
INSERT INTO TB_QNA_COMMENT VALUES(2,2,'아직 없습니다',SYSDATE,1,1);

PROMPT INSERT DATA 일정...
INSERT INTO TB_SCHEDULE VALUES(1,TO_DATE('2017-11-01','RRRR-MM-DD'),1,2, '오프라인모임일정');
INSERT INTO TB_SCHEDULE VALUES(2,TO_DATE('2017-11-11','RRRR-MM-DD'),2,4, '1차 정기 모임');

PROMPT INSERT DATA 그룹 게시판...
INSERT INTO TB_G_BOARD VALUES(1,'첫글','안녕하세요',SYSDATE,2,2,1);
INSERT INTO TB_G_BOARD VALUES(2,'사진','업로드했습니다',SYSDATE,3,2,1);

PROMPT INSERT DATA 그룹 게시판 댓글...
INSERT INTO TB_GB_COMMENT VALUES(1,1,'반갑습니다',SYSDATE,3,2);
INSERT INTO TB_GB_COMMENT VALUES(2,2,'감사합니다',SYSDATE,4,2);

PROMPT INSERT DATA 메세지...
INSERT INTO TB_MESSAGE VALUES(1,1,2,1,'환영합니다! -STUDYHUB');
INSERT INTO TB_MESSAGE VALUES(2,2,3,1,'사진공유 부탁드려요');

PROMPT INSERT DATA FAQ...
INSERT INTO TB_FAQ VALUES(1,'아이디가 기억이 안나요','로그인화면 하단에 아이디찾기를 클릭하세요',1);
INSERT INTO TB_FAQ VALUES(2,'글 공개범위는 어떻게바꾸나요?','글쓰기나 수정화면에서 전체공개 또는 그룹공개 가능합니다',3);

--추가 II
PROMPT INSERT DATA 전체공지...
INSERT INTO TB_NOTICE VALUES('StudyHub는 누구나 이용할 수 있습니다.');

PROMPT INSERT DATA 파일공유 임시데이터...
INSERT INTO TB_SHARE_FILE VALUES(1,'토익800점 어휘','You can do it!',SYSDATE,'토익800어휘',NULL,2,3); --그룹 내 파일공유 게시판이므로 그룹정보를 알수있어야함
INSERT INTO TB_SHARE_FILE VALUES(2,'회화를 위한','You can do it!',SYSDATE,'회화팁',NULL,4,3);

--------------------------------------------------
PROMPT INSERT DATA 모집게시판...
INSERT INTO TB_BOARD VALUES(1, '토익스터디', '장소 : 신촌, 주1회 모여서 스터디',
            TO_DATE(SYSDATE),2);
INSERT INTO TB_BOARD VALUES(2, '취업스터디', '장소 : 강남, 주2회 스터디',
            TO_DATE(SYSDATE),3);
INSERT INTO TB_BOARD VALUES(3, '독서토론', '장소 : 혜화, 주1회 스터디, 온라인 첨삭',
            '17/09/24',4);
            
PROMPT INSERT DATA 모집게시판 댓글...
INSERT INTO TB_BOARD_COMMENT VALUES
(1, 1, '가입원합니다', TO_DATE(SYSDATE), 5, 2);
INSERT INTO TB_BOARD_COMMENT VALUES
(2, 1, '강남 어디인가요?', TO_DATE(SYSDATE), 6, 2);
INSERT INTO TB_BOARD_COMMENT VALUES
(3, 2, '취업스터디 더 알고싶어요', TO_DATE(SYSDATE), 4, 2);

PROMPT INSERT DATA 그룹 공지 게시판..
INSERT INTO TB_G_NOTICE VALUES
(1, '스터디공지', '1. 매주 토요일 스터디 참석 
2. 하루에 한번은 그룹게시판 방문하여 글 확인', TO_DATE(SYSDATE), 2,3,1);
INSERT INTO TB_G_NOTICE VALUES
(2, '스터디날짜','무슨요일에 모였으면 하시나요? 댓글로 원하는 요일 말해주세요.'
, TO_DATE(SYSDATE), 2, 3,2);

PROMPT INSERT DATA 그룹 공지 게시판 댓글..
INSERT INTO TB_GN_COMMENT VALUES
(1, 1, '확인하였습니다', TO_DATE(SYSDATE), 3, 3);
INSERT INTO TB_GN_COMMENT VALUES
(2, 2, '확인하였습니다', TO_DATE(SYSDATE), 4, 3);

COMMIT;

PROMPT StudyHub;