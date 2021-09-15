CREATE TABLE `attendance` (
  `attendance_id` int(5) NOT NULL AUTO_INCREMENT,
  `employee_id` int(5) NOT NULL,
  `attendance_join` datetime NOT NULL,
  `attendance_leaving` datetime,
  PRIMARY KEY(`attendance_id`),
  FOREIGN KEY(`employee_id`)
    REFERENCES employee (`employee_id`)
) DEFAULT CHARSET=utf8;
