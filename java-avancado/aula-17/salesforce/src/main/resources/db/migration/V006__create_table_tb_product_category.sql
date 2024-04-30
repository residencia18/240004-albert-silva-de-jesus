create table if not exists tb_product_category (
  category_id bigint not null,
  product_id bigint not null,
  primary key (category_id, product_id)
);

INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);  -- Smartphone -> Eletrônicos
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);  -- Notebook -> Eletrônicos
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);  -- Camiseta -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (4, 3);  -- Calça Jeans -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 2);  -- Mesa -> Móveis
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 2);  -- Sofá -> Móveis
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 4);  -- Feijão -> Alimentos
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 4);  -- Arroz -> Alimentos
INSERT INTO tb_product_category (product_id, category_id) VALUES (9, 2);  -- Fogão -> Móveis
INSERT INTO tb_product_category (product_id, category_id) VALUES (10, 2); -- Geladeira -> Móveis
INSERT INTO tb_product_category (product_id, category_id) VALUES (11, 3); -- Boné -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (12, 3); -- Shorts -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (13, 3); -- Tênis -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (14, 3); -- Mochila -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (15, 3); -- Chapéu -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (16, 3); -- Óculos -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (17, 3); -- Cinto -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (18, 3); -- Relógio -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (19, 3); -- Bolsa -> Roupas
INSERT INTO tb_product_category (product_id, category_id) VALUES (20, 3); -- Jaqueta -> Roupas