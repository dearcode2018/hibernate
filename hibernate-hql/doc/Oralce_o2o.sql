/* 创建表 */
CREATE TABLE person();

COMMENT ON TABLE person IS '人信息表';
COMMENT ON COLUMN person.oid IS '主键-唯一标识符';
COMMENT ON COLUMN person.name IS '姓名';
COMMENT ON COLUMN person.photoUrl IS '证件照片url';
COMMENT ON COLUMN person.gender IS '性别 : 0-未知, 1-男(male), 2-女(female)';
COMMENT ON COLUMN person.nation IS '民族';
COMMENT ON COLUMN person.birthday IS '出生日期 yyyy-MM-dd';
COMMENT ON COLUMN person.address IS '住址';

/* 创建序列 */
CREATE SEQUENCE seq_person_oid
START WITH 0
INCREMENT BY 1
MAXVALUE 999999999999999999999999
CACHE 10
ORDER
CYCLE;

/* 创建表 */
CREATE TABLE idCard();

/* 创建序列 */
CREATE SEQUENCE seq_idCard_oid
START WITH 0
INCREMENT BY 1
MAXVALUE 999999999999999999999999
CACHE 10
ORDER
CYCLE;

/* 添加注释 */
COMMENT ON TABLE idCard IS '身份证表';
COMMENT ON COLUMN idCard.oid IS '主键-唯一标识符';
COMMENT ON COLUMN idCard.title IS '身份证标题, 例如 : 中华人民共和国 - 居民身份证';
COMMENT ON COLUMN idCard.issuingAuthority IS '签发机关 (Xx市公安局)';
COMMENT ON COLUMN idCard.effectiveDate IS '生效日期 yyyy-MM-dd';
COMMENT ON COLUMN idCard.expiryDate IS '失效日期 yyyy-MM-dd';

