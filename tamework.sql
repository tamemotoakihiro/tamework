USE tamework;

SET PERSIST local_infile= 1;

LOAD DATA LOCAL INFILE "/Users/akihirotamemoto/tamework/tame_test.csv "
INTO TABLE work_list
FIELDS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
LINES TERMINATED BY '\r\n';
