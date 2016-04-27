drop table 'contents';

CREATE TABLE `contents` (
   `ID` varchar(255) NOT NULL,
   `VERSION` int(11),
   `contents` varchar(255) DEFAULT NULL,
   `USER_NAME` varchar(255) NOT NULL,
   `CONTENT` varchar(255) NOT NULL,
   `CONTENT_DATE` timestamp NOT NULL,
   `CREATED_BY` varchar(255) NOT NULL,
   `CREATED_DATE` timestamp NOT NULL,
   `UPDATED_BY` varchar(255) NOT NULL,
   `UPDATED_DATE` timestamp NOT NULL,
   PRIMARY KEY (`ID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;