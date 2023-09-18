CREATE TABLE brands
(
    id   bigint      NOT NULL AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE prices
(
    id         bigint      NOT NULL AUTO_INCREMENT,
    brand_id   bigint      NOT NULL,
    start_date datetime    NOT NULL,
    end_date   datetime    NOT NULL,
    price_list bigint,
    product_id varchar(16) NOT NULL,
    priority   int         NOT NULL,
    price      double      NOT NULL,
    curr       varchar(8)  NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO brands (id, name)
VALUES (1, 'xyz');

INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, '35455', 0, 35.50, 'EUR');
INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, '35455', 1, 25.45, 'EUR');
INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, '35455', 1, 30.50, 'EUR');
INSERT INTO prices (id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, '35455', 1, 38.95, 'EUR');