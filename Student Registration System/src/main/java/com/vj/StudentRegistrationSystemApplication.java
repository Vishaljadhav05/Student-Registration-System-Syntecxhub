package com.vj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentRegistrationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRegistrationSystemApplication.class, args);
	}

}


// Database 

/*

mysql> select * from students;
+----+------------------+----------------------------+---------------+------------------+------------+-----------+------------+----------------------------+
| id | course           | created_at                 | date_of_birth | email            | first_name | last_name | phone      | updated_at                 |
+----+------------------+----------------------------+---------------+------------------+------------+-----------+------------+----------------------------+
|  1 | Computer Science | 2026-10-21 22:54:39.400410 | 2003-05-14    | asha@example.com | Asha       | Verma     | 9876543210 | 2026-10-21 22:54:39.400410 |
|  2 | Computer Science | 2026-10-21 22:56:04.236770 | 2003-10-25    | ramesh@gmail.com | Ramesh     | Mishra    | 9874561230 | 2026-10-21 22:56:04.236770 |
+----+------------------+----------------------------+---------------+------------------+------------+-----------+------------+----------------------------+
2 rows in set (0.00 sec)



mysql> select * from students;
+----+------------------+----------------------------+---------------+------------------+------------+-----------+------------+----------------------------+
| id | course           | created_at                 | date_of_birth | email            | first_name | last_name | phone      | updated_at                 |
+----+------------------+----------------------------+---------------+------------------+------------+-----------+------------+----------------------------+
|  2 | Computer Science | 2026-10-21 22:56:04.236770 | 2003-10-25    | ramesh@gmail.com | Ramesh     | Mishra    | 9874561230 | 2026-10-21 22:56:04.236770 |
+----+------------------+----------------------------+---------------+------------------+------------+-----------+------------+----------------------------+
1 row in set (0.00 sec)



*/