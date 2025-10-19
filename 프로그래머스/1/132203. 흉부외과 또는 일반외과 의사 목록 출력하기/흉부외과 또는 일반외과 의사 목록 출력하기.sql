-- 코드를 입력하세요
SELECT 
    d.DR_NAME AS dn,
    d.DR_ID AS di,
    d.MCDP_CD AS mc,
    DATE_FORMAT(d.HIRE_YMD, "%Y-%m-%d") AS hy
FROM DOCTOR AS d
WHERE MCDP_CD ='CS' OR MCDP_CD='GS'
ORDER BY d.HIRE_YMD DESC, d.DR_NAME ASC;