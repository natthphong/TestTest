DROP TABLE IF EXISTS customer_info;
CREATE TABLE customer_info (
  id bigserial PRIMARY KEY,
  age int,
  email varchar(255) NOT NULL UNIQUE,
  password varchar(255),
  username varchar(255),
  is_delete char(1) DEFAULT 'N'
);


DROP TABLE IF EXISTS tbl_transaction;
CREATE TABLE tbl_transaction (
                                        id serial4 NOT NULL,
                                        txn_type varchar(10) NOT NULL,
                                        current_price int4 NOT NULL,
                                        request_ref varchar(255) NOT NULL,
                                        status varchar(20) NOT NULL DEFAULT 'CF'::character varying,
                                        email varchar(100) NULL,
                                        confirm_date timestamp,
                                        sale_id varchar(255) ,
                                        create_date timestamp NOT NULL DEFAULT now(),
                                        create_by varchar(255) NOT NULL,
                                        CONSTRAINT tbl_transaction_pkey PRIMARY KEY (id)
);