INSERT INTO employee(id,first_name, last_name, email) VALUES (1, 'santhosh', 'raj', 'san@gct.in');
INSERT INTO employee(id,first_name, last_name, email) VALUES (2, 'naveen', 'kumar', 'naveen@psg.in');
INSERT INTO employee(id,first_name, last_name, email) VALUES (3, 'karthi', 's', 'karthi@psg.in');
INSERT INTO employee(id,first_name, last_name, email) VALUES (4, 'faruk', 'abdula', 'abdula@gmail.com');
INSERT INTO employee(id,first_name, last_name, email) VALUES (5, 'john', 'anderson', 'john@gmail.com');
INSERT INTO employee(id,first_name, last_name, email) VALUES (6, 'cris', 'stark', 'stark@avng.in');

INSERT INTO project(id, name, description, status) VALUES (101, 'spring boot small', 'small spring boot app', 'INPROGRESS'); 
INSERT INTO project(id, name, description, status) VALUES (102, 'project one app', 'project management spring boot app', 'NOTSTARTED'); 
INSERT INTO project(id, name, description, status) VALUES (103, 'student forum', 'spring app for student registration forum', 'NOTSTARTED'); 
INSERT INTO project(id, name, description, status) VALUES (104, 'school management', 'node js app for school management', 'COMPLETED'); 

INSERT INTO project_employee(project_id, employee_id) VALUES (101,2);
INSERT INTO project_employee(project_id, employee_id) VALUES (101,3);
INSERT INTO project_employee(project_id, employee_id) VALUES (101,4);
INSERT INTO project_employee(project_id, employee_id) VALUES (102,1);
INSERT INTO project_employee(project_id, employee_id) VALUES (102,6);
INSERT INTO project_employee(project_id, employee_id) VALUES (102,4);
INSERT INTO project_employee(project_id, employee_id) VALUES (103,1);
INSERT INTO project_employee(project_id, employee_id) VALUES (103,3);
INSERT INTO project_employee(project_id, employee_id) VALUES (103,5);
INSERT INTO project_employee(project_id, employee_id) VALUES (104,4);
INSERT INTO project_employee(project_id, employee_id) VALUES (104,6);