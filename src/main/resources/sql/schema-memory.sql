CREATE TABLE `RECORDS` (
                           `record_id`      long	        primary key AUTO_INCREMENT COMMENT 'auto increment',
                           `record_title`	varchar(255)	NOT NULL,
                           `location`	    varchar(255)	NOT NULL,
                           `start_date`	    date	        NOT NULL,
                           `end_date`	    date	        NOT NULL
);

CREATE TABLE `Record_COST` (
                               `cost_id`	    Long	        primary key AUTO_INCREMENT,
                               `record_id`	    Long	        NOT NULL,
                               `cost_category`	varchar(255)	NOT NULL	COMMENT '식비, 숙소, 교통, 기타',
                               `cost_details`	VARCHAR(255)	NULL,
                               `cost_amount`	decimal(8,2)	NULL,
                               FOREIGN KEY (record_id) references RECORDS(record_id)
);