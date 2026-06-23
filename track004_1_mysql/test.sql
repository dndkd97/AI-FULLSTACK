show tables;

-- 1. 회사
CREATE TABLE company (
  com_id INT AUTO_INCREMENT PRIMARY KEY,
  indust_code VARCHAR(20),
  indust_name VARCHAR(50),
  com_name VARCHAR(100) NOT NULL,
  com_ceo VARCHAR(50),
  biz_no VARCHAR(20),
  com_tel VARCHAR(20),
  com_logo VARCHAR(255),
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL
);
-- 3. 직급
CREATE TABLE emp_position (
  pos_id INT AUTO_INCREMENT PRIMARY KEY,
  com_id INT NOT NULL,
  pos_code VARCHAR(20),
  pos_name VARCHAR(50),
  pos_order INT,
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);
-- 4. 직원
CREATE TABLE employee (
  emp_id INT AUTO_INCREMENT PRIMARY KEY,
  com_id INT NOT NULL,
  pos_id INT NOT NULL,
  dept_id INT NOT NULL,
  emp_no VARCHAR(20),
  emp_name VARCHAR(50),
  emp_pass VARCHAR(255),
  emp_email VARCHAR(100),
  emp_mobile VARCHAR(20),
  emp_status VARCHAR(20),
  hire_date DATE,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  FOREIGN KEY (com_id) REFERENCES company(com_id),
  FOREIGN KEY (pos_id) REFERENCES emp_position(pos_id),
  FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);
-- 2. 부서
CREATE TABLE department (
  dept_id INT AUTO_INCREMENT PRIMARY KEY,
  com_id INT NOT NULL,
  parent_id INT,
  dept_name VARCHAR(100) NOT NULL,
  dept_code VARCHAR(20),
  depth INT,
  sort_order INT,
  emp_id INT,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);

-- 5. 권한
CREATE TABLE authority (
  aut_id INT AUTO_INCREMENT PRIMARY KEY,
  com_id INT NOT NULL,
  aut_name VARCHAR(50),
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);

-- 6. 직원-권한 매핑
CREATE TABLE emp_auth (
  emp_aut_id INT AUTO_INCREMENT PRIMARY KEY,
  emp_id INT NOT NULL,
  aut_id INT NOT NULL,
  FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
  FOREIGN KEY (aut_id) REFERENCES authority(aut_id)
);

-- 7. 프로젝트
CREATE TABLE project (
  pro_id INT AUTO_INCREMENT PRIMARY KEY,
  emp_id INT NOT NULL,
  com_id INT NOT NULL,
  pro_name VARCHAR(100) NOT NULL,
  pro_desc TEXT,
  pro_status VARCHAR(20) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE,
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);

-- 8. 프로젝트 멤버
CREATE TABLE project_member (
  pm_id INT AUTO_INCREMENT PRIMARY KEY,
  project_pro_id INT NOT NULL,
  emp_id INT NOT NULL,
  role VARCHAR(50),
  joined_at DATETIME,
  FOREIGN KEY (project_pro_id) REFERENCES project(pro_id),
  FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);

-- 9. 태스크
CREATE TABLE task (
  task_id INT AUTO_INCREMENT PRIMARY KEY,
  pro_id INT NOT NULL,
  pm_id INT NOT NULL,
  com_id INT NOT NULL,
  task_name VARCHAR(100),
  task_desc TEXT,
  task_status VARCHAR(20),
  pm_id_name VARCHAR(50),
  task_start_date DATE,
  task_end_date DATE,
  task_created_at DATETIME,
  task_updated_at DATETIME,
  FOREIGN KEY (pro_id) REFERENCES project(pro_id),
  FOREIGN KEY (pm_id) REFERENCES project_member(pm_id),
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);

-- 10. 결재 양식
CREATE TABLE appr_form (
  for_id INT AUTO_INCREMENT PRIMARY KEY,
  com_id INT NOT NULL,
  for_code VARCHAR(20),
  for_title VARCHAR(100),
  for_content TEXT,
  for_status BOOLEAN,
  for_created DATETIME,
  for_updated DATETIME,
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);

-- 11. 결재 문서
CREATE TABLE appr_doc (
  doc_id INT AUTO_INCREMENT PRIMARY KEY,
  emp_id INT NOT NULL,
  for_id INT NOT NULL,
  com_id INT NOT NULL,
  doc_title VARCHAR(200),
  doc_content TEXT,
  doc_status VARCHAR(20),
  doc_created DATETIME,
  doc_updated DATETIME,
  FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
  FOREIGN KEY (for_id) REFERENCES appr_form(for_id),
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);

-- 12. 결재선
CREATE TABLE appr_line (
  lin_id INT AUTO_INCREMENT PRIMARY KEY,
  doc_id INT NOT NULL,
  emp_id INT NOT NULL,
  lin_order INT,
  lin_status VARCHAR(20),
  lin_approved DATETIME,
  FOREIGN KEY (doc_id) REFERENCES appr_doc(doc_id),
  FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);

-- 13. 공지사항
CREATE TABLE notice (
  bno INT AUTO_INCREMENT PRIMARY KEY,
  emp_id INT NOT NULL,
  com_id INT NOT NULL,
  btitle VARCHAR(200),
  bcontent TEXT,
  bhit INT,
  bfile VARCHAR(255),
  created_at DATETIME,
  updated_at DATETIME,
  FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);

-- 14. 자원
CREATE TABLE resource (
  res_id INT AUTO_INCREMENT PRIMARY KEY,
  com_id INT NOT NULL,
  res_code VARCHAR(20),
  res_name VARCHAR(100),
  res_type VARCHAR(50),
  quantity INT,
  remark TEXT,
  created_at DATETIME,
  updated_at DATETIME,
  FOREIGN KEY (com_id) REFERENCES company(com_id)
);

-- 15. 예약
CREATE TABLE reservation (
  rev_id INT AUTO_INCREMENT PRIMARY KEY,
  res_id INT NOT NULL,
  com_id INT NOT NULL,
  emp_id INT NOT NULL,
  quantity INT,
  status VARCHAR(20),
  req_date DATETIME,
  remark TEXT,
  updated_at DATETIME,
  FOREIGN KEY (res_id) REFERENCES resource(res_id),
  FOREIGN KEY (com_id) REFERENCES company(com_id),
  FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);
