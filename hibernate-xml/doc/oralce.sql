
SELECT t.* FROM 
(SELECT a.*, rownum AS rNum FROM person a WHERE  rownum <= 5) t
WHERE t.rNum >= 2;