/* 创建表 */
CREATE TABLE custom();

/* 添加注释 */
COMMENT ON TABLE custom IS '客户表';
COMMENT ON COLUMN custom.oid IS '主键-唯一标识符';
COMMENT ON COLUMN custom.name IS '客户姓名';
COMMENT ON COLUMN custom.balance IS '帐户余额';
COMMENT ON COLUMN custom.status IS '客户状态 (0-无效, 1-未激活, 2-正常)';
COMMENT ON COLUMN custom.address IS '地址';

/* 创建序列 */
CREATE SEQUENCE seq_custom_oid
START WITH 0
INCREMENT BY 1
MAXVALUE 999999999999999999999999
CACHE 10
ORDER
CYCLE;

/* 创建表 */
CREATE TABLE item();

COMMENT ON TABLE item IS '订单表';
COMMENT ON COLUMN item.oid IS '主键-唯一标识符';
COMMENT ON COLUMN item.name IS '定单名称';
COMMENT ON COLUMN item.orderDate IS '下单时间戳 yyyy-MM-dd HH:mm:ss';
COMMENT ON COLUMN item.monetary IS '消费金额';
COMMENT ON COLUMN item.remark IS '备注';

/* 创建序列 */
CREATE SEQUENCE seq_item_oid
START WITH 0
INCREMENT BY 1
MAXVALUE 999999999999999999999999
CACHE 10
ORDER
CYCLE;