LOAD DATA LOCAL INFILE "/Users/akihirotamemoto/tamework/temp/sql/rico_test.csv"
INTO TABLE work_list
FIELDS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"';
