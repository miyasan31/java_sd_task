CREATE TABLE `working_shift` (
  `working_shift_id` int(5) NOT NULL AUTO_INCREMENT,
  `employee_id` int(5) NOT NULL,
  `working_shift_join` datetime NOT NULL,
  `working_shift_leaving` datetime,
  PRIMARY KEY(`working_shift_id`),
  FOREIGN KEY(`employee_id`)
    REFERENCES employee (`employee_id`)
) DEFAULT CHARSET=utf8;
