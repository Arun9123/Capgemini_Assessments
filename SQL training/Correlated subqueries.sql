-------Query to display 10th min salary----------
SELECT * FROM emp E1 WHERE 10-1 IN (SELECT COUNT(DISTINCT E2.sal) FROM emp E2 WHERE E1.sal>E2.sal)

---Query to display loc of employees earning 8th max salary----------
SELECT loc FROM dept
WHERE deptno=(SELECT deptno from emp E1
WHERE 8-1 IN (SELECT COUNT(DISTINCT E2.sal) FROM emp E2
WHERE E1.sal<E2.sal));

-----WAQTD 3rd and 4th max salary---------
SELECT * FROM emp E1 WHERE (SELECT COUNT(DISTINCT E2.sal) FROM emp E2 WHERE E1.sal<E2.sal) IN (2,3);

------WAQTD first 5 max salaries---------- (USING DISTINCT as only the salaries are required, but if the details of those employees are also asked, it is better NOT to use DISTINCT in the outer query in that case)
SELECT DISTINCT E1.sal FROM emp E1 WHERE (SELECT COUNT(DISTINCT E2.sal) FROM emp E2 WHERE E1.sal<E2.sal) BETWEEN 0 AND 4 ORDER BY E1.sal DESC;

------WAQTD the 2nd max salary in each dept in descending order------
SELECT deptno, MAX(E1.sal)
FROM emp E1
WHERE sal<(SELECT MAX(E2.sal)
FROM emp E2 WHERE E1.deptno=E2.deptno)
GROUP BY E1.deptno ORDER BY MAX DESC;

---------WAQTD the details of employees earning more than the average income of their own dept---------
SELECT *
FROM emp E1
WHERE sal>(SELECT AVG(E2.sal)
FROM emp E2 WHERE E1.deptno=E2.deptno);
