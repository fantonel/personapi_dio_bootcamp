CREATE DATABASE ead WITH OWNER = postgres
    ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA dio;

CREATE SEQUENCE dio.person_seq;
CREATE SEQUENCE dio.phone_seq;

ALTER DATABASE ead SET search_path TO dio;