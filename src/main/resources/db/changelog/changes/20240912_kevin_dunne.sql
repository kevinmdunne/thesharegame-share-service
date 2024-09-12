ALTER TABLE shares
ADD create_date timestamp;

ALTER TABLE shares
ADD modify_date timestamp;

ALTER TABLE stockexchanges
ADD create_date timestamp;

ALTER TABLE stockexchanges
ADD modify_date timestamp;