/**
 * BM project SQL
 * 
 * @author LDH
 */
-- DB 계정 생성
CREATE USER bmin IDENTIFIED BY java;
GRANT CONNECT, DBA TO bmin;

-- DROP table
DROP TABLE bm_menu CASCADE CONSTRAINTS;
DROP SEQUENCE seq_menu;
DROP TABLE bm_shop CASCADE CONSTRAINTS;
DROP SEQUENCE seq_shop;
DROP TABLE bm_notice CASCADE CONSTRAINTS;

DROP TABLE bm_faq CASCADE CONSTRAINTS;
DROP SEQUENCE seq_faq;
DROP TABLE bm_category CASCADE CONSTRAINTS;
DROP SEQUENCE seq_category;
DROP TABLE bm_user CASCADE CONSTRAINTS;
DROP TABLE bm_owner CASCADE CONSTRAINTS;

-- User table 생성 
/*
 * user_id 			VARCHAR2(20)	- 아이디
 * user_pwd			VARCHAR2(25)	- 비밀번호
 * user_name		VARCHAR2(15)	- 이름
 * user_tel			VARCHAR2(11)	- 전화번호
 * user_addr1		VARCHAR2(80)	- 주소
 * user_addr2		VARCHAR2(120)	- 상세 주소
 * user_grade		VARCHAR2(15)	- 등급
 * user_point		NUMBER			- 포인트
 * pk_user : user_id
 * 
 */
CREATE TABLE bm_user
(user_id	VARCHAR2(20) NOT NULL
,user_pwd	VARCHAR2(25) NOT NULL
,user_name	VARCHAR2(15) NOT NULL
,user_tel	VARCHAR2(11) NOT NULL
,user_addr1	VARCHAR2(80) NOT NULL
,user_addr2	VARCHAR2(120) NOT NULL
,user_grade	VARCHAR2(15) NOT NULL
,user_point	NUMBER DEFAULT 0
,CONSTRAINT pk_user PRIMARY KEY (user_id)
);

-- Owner table 생성
/*
 * owner_id 		VARCHAR2(20)	- 아이디
 * owner_pwd		VARCHAR2(25)	- 비밀번호
 * owner_name		VARCHAR2(15)	- 이름
 * owner_tel		VARCHAR2(11)	- 전화번호
 * owner_grade		VARCHAR2(15)	- 등급
 * owner_corpnum	NUMBER			- 사업자번호
 * pk_owner : owner_id
 * 
 */
CREATE TABLE bm_owner
(owner_id 		VARCHAR2(20) NOT NULL
,owner_pwd		VARCHAR2(25) NOT NULL
,owner_name		VARCHAR2(15) NOT NULL
,owner_tel		VARCHAR2(11) NOT NULL
,owner_grade	VARCHAR2(15) NOT NULL
,owner_corpnum	NUMBER NOT NULL
,CONSTRAINT pk_owner PRIMARY KEY (owner_id)
);

-- Category table 생성
/*
 * ctgy_num		NUMBER				- 카테고리 번호
 * ctgy_name	VARCHAR2(30)		- 카테고리 명
 * pk_category : ctgy_num
 *
 */
CREATE TABLE bm_category
(ctgy_num	NUMBER NOT NULL
,ctgy_name	VARCHAR2(30) NOT NULL
,CONSTRAINT pk_category PRIMARY KEY (ctgy_num)
);

-- Category Sequence 생성
CREATE SEQUENCE seq_category
START WITH 1;

-- Notice table 생성
/*
 * ntc_num		NUMBER				- 공지사항 번호
 * ntc_title	VARCHAR2(100)		- 제목
 * ntc_author	VARCHAR2(20)		- 작성자
 * ntc_content	VARCHAR2(1000)		- 내용
 * ntc_type		VARCHAR2(15)		- 타입 ( 이벤트 / 공지사항 )
 * ntc_date		DATE				- 작성일
 * pk_notice : ntc_num
 * fk_notice_user_id : ntc_author
 * 
 */
CREATE TABLE bm_notice
(ntc_num		NUMBER NOT NULL
,ntc_title		VARCHAR2(100) NOT NULL
,ntc_author		VARCHAR2(20) NULL
,ntc_content 	VARCHAR2(1000) NOT NULL
,ntc_type		VARCHAR2(15) NOT NULL
,ntc_date		DATE DEFAULT sysdate
,CONSTRAINT	pk_notice PRIMARY KEY (ntc_num)
,CONSTRAINT fk_notice_user_id FOREIGN KEY (ntc_author)
                               REFERENCES bm_user(user_id)
);

-- Notice Sequence 생성
CREATE SEQUENCE seq_notice
START WITH 1;

-- FAQ table 생성
/*
 * faq_num 		NUMBER				-FAQ 번호
 * faq_title	VARCHAR2(100)		- 제목
 * faq_content	VARCHAR2(1000)		- 내용
 * pk_faq : faq_num		
 * 
 */
CREATE TABLE bm_faq
(faq_num		NUMBER NOT NULL
,faq_title		VARCHAR2(100) NOT NULL
,faq_content	VARCHAR2(1000) NOT NULL
,CONSTRAINT pk_faq PRIMARY KEY (faq_num)
);

-- FAQ Sequence 생성
CREATE SEQUENCE seq_faq
START WITH 1;

-- Shop table 생성
/*
 * shop_num		NUMBER				- 가게 번호
 * shop_name	VARCHAR2(60)		- 가게 명
 * shop_tel		VARCHAR2(11)		- 전화번호
 * shop_addr1	VARCHAR2(80) 		- 주소
 * shop_addr2	VARCHAR2(120)		- 상세 주소
 * shop_ctgy	NUMBER				- 카테고리 번호
 * shop_owner	VARCHAR2(20)		- 사업자 아이디
 * pk_shop : shop_num
 * fk_shop_ctgy : shop_ctgy
 * fk_shop_owner_id : shop_owner
 * 
 */
CREATE TABLE bm_shop
(shop_num		NUMBER NOT NULL
,shop_name		VARCHAR2(60) NOT NULL
,shop_tel		VARCHAR2(11) NOT NULL
,shop_addr1		VARCHAR2(80) NOT NULL
,shop_addr2		VARCHAR2(120) NOT NULL
,shop_ctgy		NUMBER NOT NULL
,shop_owner		VARCHAR2(20) NOT NULL
,shop_actStatus	
,CONSTRAINT pk_shop PRIMARY KEY (shop_num)
,CONSTRAINT fk_shop_ctgy FOREIGN KEY (shop_ctgy)
						  REFERENCES bm_ctgy(ctgy_num)
,CONSTRAINT fk_shop_owner_id FOREIGN KEY (shop_owner)
							  REFERENCES bm_owner(owner_id)
);

-- Shop Sequence 생성
CREATE SEQUENCE seq_shop
START WITH 1;

-- Menu table 생성
/*
 * menu_num		NUMBER				- 메뉴 번호
 * menu_shop	NUMBER				- 가게 번호
 * menu_name	VARCHAR2(40)		- 메뉴 명
 * menu_price	NUMBER				- 가격
 * pk_menu : menu_num
 * fk_menu_shop_num : menu_shop
 * 
 */
CREATE TABLE menu
(menu_num	NUMBER NOT NULL
,menu_shop	NUMBER NOT NULL
,menu_name	VARCHAR2(40) NOT NULL
,menu_price	NUMBER NOT NULL
,CONSTRAINT pk_menu PRIMARY KEY (menu_num)
,CONSTRAINT fk_menu_shop_num FOREIGN KEY (menu_shop)
							  REFERENCES bm_shop(shop_num)
);

-- Menu Sequence 생성
CREATE SEQUENCE seq_menu
START WITH 1;





COMMIT;

-- 초기값

INSERT INTO bm_user
VALUES ('rtmase', '1234', 'LDH', '01080019477', '대전시 대덕구', '법동', '일반회원', 0);
INSERT INTO bm_user
VALUES ('root', 'root', '이동희', '01080019477', '관리자', '열받네', '관리자', 0);

INSERT INTO bm_owner
VALUES ('owner1', '1234', '별충', '01023467554', '사업자', 423050);

INSERT INTO bm_category
VALUES (seq_category.nextval,'한식');
INSERT INTO bm_category
VALUES (seq_category.nextval,'일식');
INSERT INTO bm_category
VALUES (seq_category.nextval,'중식');
INSERT INTO bm_category
VALUES (seq_category.nextval,'분식');
INSERT INTO bm_category
VALUES (seq_category.nextval,'치킨');
INSERT INTO bm_category
VALUES (seq_category.nextval,'피자');
INSERT INTO bm_category
VALUES (seq_category.nextval,'족발/보쌈');
INSERT INTO bm_category
VALUES (seq_category.nextval,'야식');





