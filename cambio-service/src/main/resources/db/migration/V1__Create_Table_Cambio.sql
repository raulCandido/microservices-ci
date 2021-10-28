CREATE SEQUENCE cambio_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE TABLE cambio (
  id bigint NOT NULL DEFAULT nextval('cambio_id_seq'::regclass),
  from_currency character varying(3) NOT NULL COLLATE pg_catalog."default",
  to_currency character varying(3) NOT NULL COLLATE pg_catalog."default",
  conversion_factor decimal(65,2) NOT NULL,
  CONSTRAINT cambio_key PRIMARY KEY (id)
);

INSERT INTO cambio (from_currency, to_currency, conversion_factor) VALUES
                     ('USD', 'BRL', 5.73),
					 ('USD', 'EUR', 0.84),
					 ('USD', 'GBP', 0.73),
					 ('USD', 'ARS', 92.56),
					 ('USD', 'CLP', 713.30),
					 ('USD', 'COP', 3665.00),
					 ('USD', 'MXN', 20.15);