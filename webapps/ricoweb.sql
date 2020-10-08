LOAD DATA LOCAL INFILE "/Users/akihirotamemoto/ricoweb/webapps/rico_test.csv"
INTO TABLE company_list
FIELDS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"';
