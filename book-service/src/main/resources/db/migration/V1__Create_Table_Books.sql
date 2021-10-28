CREATE SEQUENCE book_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE book (
	id bigint NOT NULL DEFAULT nextval('book_id_seq'::regclass),
	author character varying(255) NOT NULL COLLATE pg_catalog."default",
	launch_date date NOT NULL,
	price decimal(65,2) NOT NULL,
	title character varying(255) NOT NULL COLLATE pg_catalog."default"
);