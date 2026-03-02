----------CROSS JOIN-----------
SELECT * FROM emp CROSS JOIN dept;

----------INNER JOIN-----------
SELECT * FROM emp INNER JOIN dept on emp.deptno=dept.deptno;

----------WAQTD details of employees with their loc if they are earning more than 2000----------
SELECT * FROM emp INNER JOIN dept on emp.deptno=dept.deptno WHERE emp.sal>2000;

----------WAQTD dname, ename and salary of employees if they are working in New York and they are earning more than clerk----------
SELECT dname, ename, sal FROM emp INNER JOIN dept on emp.deptno=dept.deptno WHERE loc='NEW YORK' AND sal>ALL(SELECT sal FROM emp WHERE job='CLERK');

-----------WAQTD details of department along with the salary of the employees if they are working in deptno 20 and they are earning more than the employee who is hired after the employee who is working in the location of Chicago.
SELECT dept.*, sal FROM emp INNER JOIN dept ON emp.deptno=dept.deptno
WHERE emp.deptno=20 AND
sal>ALL(SELECT sal FROM emp
WHERE hiredate>ALL(SELECT hiredate FROM emp WHERE 
deptno=(SELECT deptno FROM dept WHERE loc='CHICAGO')));


------------------(Look into this the below question)---------------
-------WAQTD details of employees aong with dname if they are hired after atleast a clerk, and they are working in accounting dept and if they have reporting manager---
SELECT emp.*, dname FROM emp INNER JOIN dept on emp.deptno=dept.deptno WHERE hiredate>ANY(SELECT hiredate FROM emp WHERE job='CLERK') AND mgr IS NOT NULL;


-------Query to display details of employees with their managers----------------
SELECT e1.*, e2.ename AS Manager, e2.sal AS Manager_salary FROM emp e1 JOIN emp e2 ON e1.mgr=e2.empno WHERE e1.sal<e2.sal;

-------Query to display name and annual salary of employees & their managers if
-------employees and their managers are working in the same job and employees are
-------earning more than the employee who is having char 'A' in his name.---------

SELECT e1.ename, e1.sal*12 AS employee_sal, e2.ename AS Manager, e2.sal*12 AS Manager_sal FROM emp e1 JOIN emp e2 ON e1.mgr=e2.empno
WHERE e1.job=e2.job AND e1.sal>ALL(SELECT sal FROM emp WHERE ename like '%A%');




-----3 tables----------------
---Query to display name of employees and their managers and manager's manager---------
SELECT E1.ename,E2.ename,E3.ename FROM emp E1 JOIN emp E2 ON E1.mgr=E2.empno JOIN emp E3 ON E2.mgr=E3.empno;

-----Query to dislay name of employees and their managers if employees are earning more than Allen and
-----Managers are hired after their manager. Employees and managers are working in the same job
-----and managers are working in the location of New York.

SELECT e1.ename, e2.name FROM emp e1 JOIN emp e2 ON e1.mgr=e2.empno JOIN emp e3 ON e2.mgr=e3.empno


-----WAQTD name and department of employees, their managers and their manager's manager's name-----
SELECT E1.ename AS Employee_name,D1.dname AS Employee_dept, E2.ename AS Manager_name, D2.dname AS Manager_dept, E3.ename AS Managers_manager_name, D3.dname AS Managers_manager_dept FROM emp E1 JOIN emp E2 ON E1.mgr=E2.empno 
JOIN emp E3 ON E2.mgr=E3.empno JOIN dept D1 ON E1.deptno=D1.deptno JOIN dept D2 ON E2.deptno=D2.deptno 
JOIN dept D3 ON E3.deptno=D3.deptno;


----WAQTD location of Salesman's manager's manager.------------
SELECT D1.loc FROM emp E1 JOIN emp E2 ON E1.mgr=E2.empno 
JOIN emp E3 ON E2.mgr=E3.empno JOIN dept D1 ON E1.deptno=D1.deptno JOIN dept D2 ON E2.deptno=D2.deptno 
JOIN dept D3 ON E3.deptno=D3.deptno WHERE E1.job='SALESMAN';
