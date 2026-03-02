SELECT * FROM EMP WHERE CAST(sal AS VARCHAR(20)) LIKE '______' AND CAST(hiredate AS VARCHAR(20)) LIKE '1981%';

SELECT ename, hiredate FROM emp WHERE job IN ('MANAGER', 'SALESMAN') AND ename LIKE '%LL%' AND sal>2000 AND hiredate BETWEEN '1981-01-01' AND '1981-12-31';

SELECT 'Mr. ' || ename AS Formal_Name FROM emp;

SELECT 'Mr. ' || ename || ' is a ' || job || ', earning ' || sal AS Expense_Sheet FROM emp;

SELECT ename, LENGTH(ename) from emp;

SELECT * FROM emp where sal = (SELECT MAX(sal) FROM emp);
SELECT * FROM emp ORDER BY sal DESC LIMIT 1;

SELECT COUNT(*) FROM emp WHERE deptno = 20;

SELECT MAX(sal) AS Max_Salary, SUM(sal) AS Total_Salary FROM emp where hiredate > '1980-12-31';

SELECT COUNT(DISTINCT sal) FROM emp;

SELECT AVG(sal) FROM emp WHERE sal BETWEEN 1000 AND 3000 AND hiredate BETWEEN '1981-01-01' AND '1981-12-31';

SELECT deptno, COUNT(*) AS No_of_employees FROM emp GROUP BY deptno ORDER BY No_of_employees;

SELECT deptno, COUNT(*) FROM emp where job = 'SALESMAN' GROUP BY deptno;

SELECT job, MAX(sal) as Maximum_salary FROM emp WHERE sal>2000 AND job LIKE '%A%' GROUP BY job;

SELECT sal FROM emp GROUP BY SAL;

SELECT deptno, COUNT(*), SUM(sal) AS Total_salary FROM emp WHERE mgr IS NOT NULL AND (comm IS NULL or comm=0) AND hiredate BETWEEN '1982-01-01' AND '1982-12-31' GROUP BY deptno

SELECT deptno, COUNT(*) AS Count_of_employees FROM emp GROUP BY deptno HAVING COUNT(*)>=2 ORDER BY Count_of_employees DESC;

SELECT deptno, COUNT(*) FROM emp WHERE job='SALESMAN' AND sal>110 GROUP BY deptno HAVING MAX(sal)>200;

SELECT deptno, MAX(sal) AS Max_salary FROM emp WHERE sal BETWEEN 2001 AND 5000 AND job in ('CLERK', 'MANAGER') GROUP BY deptno;

SELECT sal, COUNT(sal) FROM emp GROUP BY sal HAVING COUNT(sal)>1;

SELECT deptno, AVG(sal) FROM emp WHERE job='MANAGER' AND sal>2000 GROUP BY deptno HAVING SUM(sal)>2500;

SELECT * FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='SMITH');

SELECT * FROM emp WHERE hiredate>'1980-12-31' AND sal<(SELECT sal FROM emp WHERE ename='JONES');

SELECT * FROM emp WHERE hiredate>(SELECT hiredate FROM emp WHERE ename='ALLEN') AND sal>(SELECT sal FROM emp WHERE ename='JONES') ORDER BY deptno DESC, empno ASC;

SELECT * FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='JAMES') AND job=(SELECT job FROM emp WHERE ename='MILLER') AND sal>(SELECT sal FROM emp WHERE ename='ADAMS') AND hiredate>(SELECT hiredate FROM emp WHERE ename='MARTIN');

SELECT ename, sal FROM emp WHERE sal>(SELECT sal FROM emp WHERE ename='SMITH') AND sal<(SELECT sal FROM emp WHERE ename='MARTIN') ;

SELECT * FROM dept;

SELECT * FROM emp WHERE deptno=(SELECT deptno FROM dept WHERE loc='NEW YORK') ORDER BY ename DESC;

SELECT loc FROM dept WHERE deptno=(SELECT deptno FROM emp WHERE ename='ALLEN');

SELECT * FROM emp WHERE hiredate>(SELECT hiredate FROM emp WHERE sal>3000) AND deptno=(SELECT deptno FROM dept where loc='BOSTON');

SELECT * FROM emp WHERE job=(SELECT job FROM emp WHERE ename='MILLER') AND deptno=(SELECT deptno FROM dept where loc='NEW YORK');

SELECT * FROM emp WHERE job='CLERK' AND deptno=(SELECT deptno FROM emp WHERE ename='SMITH') AND sal>=(SELECT sal FROM emp WHERE ename='KING') AND hiredate>(SELECT hiredate FROM emp WHERE ename='MARTIN') AND deptno=(SELECT deptno FROM dept where loc='BOSTON');

--------------------The multi-row subquery can return multiple rows, so we use IN------------------------
SELECT dname FROM dept WHERE deptno in (SELECT deptno FROM emp WHERE job='CLERK');


SELECT * FROM emp WHERE sal=(SELECT MAX(sal) FROM emp);

--------------2ND MAX SALARY------------------
SELECT * FROM emp ORDER BY sal DESC LIMIT 1 OFFSET 1

SELECT * FROM emp WHERE sal=(SELECT MAX(sal) FROM emp WHERE sal<(SELECT MAX(sal) FROM emp));

--------------3rd min salary-------------------
SELECT * FROM emp WHERE sal IN (SELECT MIN(sal) FROM emp WHERE sal>(SELECT MIN(sal) FROM emp WHERE sal>(SELECT MIN(sal) FROM emp)));

SELECT loc FROM DEPT WHERE deptno IN (SELECT deptno FROM emp WHERE sal=(SELECT MAX(sal) FROM emp WHERE sal<(SELECT MAX(sal) FROM emp)));

---Display details of employees who earn more than the employee having consecutive 2 L's in their names and are working in New York
SELECT * FROM emp WHERE sal>(SELECT MAX(sal) FROM emp WHERE ename LIKE '%LL%') AND deptno IN (SELECT deptno FROM dept WHERE loc='NEW YORK');


----------Details of employees earning more than clerks-----------------

SELECT *
FROM emp
WHERE sal> ALL(SELECT sal FROM emp WHERE job='CLERK');

SELECT *
FROM emp
WHERE sal>(SELECT MAX(sal) FROM emp WHERE job='CLERK');

SELECT *
FROM emp
WHERE sal> ALL(SELECT sal FROM emp WHERE job='SALESMAN')
AND
saL< ANY(SELECT sal FROM emp WHERE job='PRESIDENT');


SELECT * FROM emp
WHERE hiredate> ALL(SELECT hiredate FROM emp WHERE deptno IN (SELECT deptno FROM dept WHERE loc='NEW YORK'))
AND
sal>ALL(SELECT sal FROM emp WHERE ename LIKE '%A%' OR ename LIKE '%S%');

----------Display details of manager----------

SELECT mgr FROM emp WHERE ename='SMITH';

SELECT * FROM emp WHERE empno=(SELECT mgr FROM emp WHERE ename='SMITH');

---Dname of Allen's manager---------
SELECT dname
FROM dept
WHERE deptno=(SELECT deptno
FROM emp
WHERE empno=(SELECT mgr
FROM emp
WHERE ename='ALLEN'));

--------MANAGER'S MANAGER'S DETAILS-----------------



--------Details of employees who are reporting to KING----------
SELECT * FROM emp WHERE mgr=(SELECT empno FROM emp WHERE ename='KING');

--------Details of employees who are reporting to JONES' manager----------
SELECT * FROM emp WHERE mgr IN (SELECT empno FROM emp WHERE empno IN (SELECT mgr FROM emp WHERE ename='JONES'));

--can do this thing by the below query as well

SELECT *
FROM emp
WHERE mgr IN (SELECT mgr
FROM emp
WHERE ename='JONES');

----Query to display details of employees reporting to Ward's manager's manager-----------

SELECT *
FROM emp
WHERE mgr IN (SELECT empno
FROM emp
WHERE empno IN (SELECT mgr
FROM emp
WHERE empno IN (SELECT mgr
FROM emp
WHERE ename='WARD')));

---or----

SELECT *
FROM emp
WHERE mgr IN (SELECT mgr
FROM emp
WHERE empno IN (SELECT mgr
FROM emp
WHERE ename='WARD'));

-----Display 10th highest salary-----(Using LIMIT/OFFSET)





