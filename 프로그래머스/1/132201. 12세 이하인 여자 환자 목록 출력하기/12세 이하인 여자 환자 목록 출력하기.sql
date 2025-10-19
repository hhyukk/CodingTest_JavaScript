-- 코드를 입력하세요
SELECT
    PT_NAME AS ptname,
    PT_NO AS ptno,
    GEND_CD AS gendcd,
    AGE AS age,
    IFNULL(TLNO, 'NONE') AS tlno
FROM PATIENT
WHERE AGE<=12 AND GEND_CD = 'W'
ORDER BY age DESC, ptname ASC