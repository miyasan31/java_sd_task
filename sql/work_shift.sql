CREATE TABLE `work_shift` (
  `shift_id` int(5) NOT NULL AUTO_INCREMENT,
  `employee_id` int(5) NOT NULL,
  `shift_join_schedule` datetime NOT NULL,
  `shift_leaving_schedule` datetime,
  PRIMARY KEY(`shift_id`),
  FOREIGN KEY(`employee_id`)
    REFERENCES employee (`employee_id`)
) DEFAULT CHARSET=utf8;
