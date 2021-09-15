CREATE TABLE `employee` (
  `employee_id` int(5) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(15) NOT NULL,
  `employee_name_sub` varchar(30) NOT NULL,
  `employee_birthday` date NOT NULL,
  `employee_gender` char(1) NOT NULL,
  `employee_email` varchar(50) NOT NULL,
  `employee_password` varchar (50) NOT NULL,
  `employee_phone` char(11) NOT NULL,
  `employee_address`  varchar(100) NOT NULL,
  `employee_zipcode` char(7) NOT NULL,
  `employee_type` char(1) NOT NULL,
  `company_join` date NOT NULL,
  `company_leaving` date DEFAULt NULL,
  PRIMARY KEY(`employee_id`)
) DEFAULT CHARSET=utf8;
