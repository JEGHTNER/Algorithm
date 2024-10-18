-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS ai
WHERE ai.NAME in ("Lucy", "Ella", "Pickle", "Rogan", "Sabrina", "Mitty")
ORDER BY ai.ANIMAL_ID