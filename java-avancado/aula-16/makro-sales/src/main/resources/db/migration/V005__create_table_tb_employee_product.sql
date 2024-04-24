create table tb_employee_product (
  employee_id bigint not null,
  product_id bigint not null,
  primary key (employee_id, product_id)
);

INSERT INTO tb_employee_product (employee_id, product_id) VALUES (1, 1);  -- João da Silva -> Smartphone
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (2, 2);  -- Maria da Silva -> Notebook
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (3, 3);  -- José da Silva -> Camiseta
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (4, 4);  -- Ana da Silva -> Calça Jeans
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (5, 5);  -- Paulo da Silva -> Mesa
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (6, 6);  -- Pedro da Silva -> Sofá
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (7, 7);  -- Carlos da Silva -> Feijão
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (8, 8);  -- Antônio da Silva -> Arroz
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (9, 9);  -- Francisco da Silva -> Fogão
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (10, 10); -- Luiz da Silva -> Geladeira
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (11, 11); -- Miguel da Silva -> Boné
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (12, 12); -- Eduardo da Silva -> Shorts
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (13, 13); -- Gabriel da Silva -> Tênis
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (14, 14); -- Rafael da Silva -> Mochila
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (15, 15); -- Lucas da Silva -> Chapéu
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (16, 16); -- Mateus da Silva -> Óculos
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (17, 17); -- Rodrigo da Silva -> Cinto
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (18, 18); -- Gustavo da Silva -> Relógio
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (19, 19); -- Pedro da Silva 2 -> Bolsa
INSERT INTO tb_employee_product (employee_id, product_id) VALUES (20, 20); -- Paulo da Silva 2 -> Jaqueta