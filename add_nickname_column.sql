-- ========================================
-- 회원가입 시스템 업데이트를 위한 SQL 스크립트
-- ========================================

-- 1. members 테이블에 nickname 컬럼 추가
-- 이미 nickname 컬럼이 있다면 이 명령은 에러가 발생합니다.
-- 그럴 경우 이 명령을 건너뛰고 다음으로 진행하세요.

ALTER TABLE members ADD COLUMN nickname VARCHAR(50) NULL;

-- 2. 기존 데이터에 대한 기본값 설정 (선택사항)
-- 이미 등록된 회원들에게 임시 닉네임을 부여하려면 아래 명령을 실행하세요.

UPDATE members SET nickname = CONCAT('user_', id) WHERE nickname IS NULL;

-- 3. 테이블 구조 확인
-- 아래 명령으로 테이블 구조를 확인할 수 있습니다.

DESC members;

-- ========================================
-- 예상되는 테이블 구조:
-- ========================================
-- id           INT          PRIMARY KEY AUTO_INCREMENT
-- name         VARCHAR(50)  NOT NULL
-- user_id      VARCHAR(50)  NOT NULL UNIQUE
-- user_pw      VARCHAR(50)  NOT NULL
-- phone        VARCHAR(20)  NOT NULL
-- email        VARCHAR(100) NOT NULL
-- reg_date     DATETIME     NOT NULL
-- address      VARCHAR(200) NOT NULL
-- nickname     VARCHAR(50)  NULL (새로 추가된 컬럼)
-- ========================================
