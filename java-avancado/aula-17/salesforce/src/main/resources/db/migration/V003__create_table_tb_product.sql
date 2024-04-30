create table if not exists tb_product (
  price float(53),
  id bigserial not null,
  description varchar(255),
  img_url varchar(255),
  name varchar(255) unique,
  primary key (id)
);

INSERT INTO tb_product (price, description, img_url, name) 
VALUES 
    (1000.0, 'Smartphone top de linha', 'https://www.google.com', 'Smartphone'),
    (500.0, 'Notebook com configuração avançada', 'https://www.example.com', 'Notebook'),
    (50.0, 'Camiseta casual', 'https://www.example.com', 'Camiseta'),
    (20.0, 'Calça jeans', 'https://www.example.com', 'Calça Jeans'),
    (30.0, 'Mesa de madeira', 'https://www.example.com', 'Mesa'),
    (800.0, 'Sofá confortável', 'https://www.example.com', 'Sofá'),
    (10.0, 'Feijão mulatinho', 'https://www.example.com', 'Feijão'),
    (15.0, 'Arroz branco', 'https://www.example.com', 'Arroz'),
    (200.0, 'Fogão a gás', 'https://www.example.com', 'Fogão'),
    (300.0, 'Geladeira frost-free', 'https://www.example.com', 'Geladeira'),
    (25.0, 'Boné estiloso', 'https://www.example.com', 'Boné'),
    (40.0, 'Shorts de praia', 'https://www.example.com', 'Shorts'),
    (150.0, 'Tênis esportivo', 'https://www.example.com', 'Tênis'),
    (70.0, 'Mochila para viagem', 'https://www.example.com', 'Mochila'),
    (120.0, 'Chapéu de sol', 'https://www.example.com', 'Chapéu'),
    (90.0, 'Óculos de sol', 'https://www.example.com', 'Óculos'),
    (35.0, 'Cinto de couro', 'https://www.example.com', 'Cinto'),
    (60.0, 'Relógio de pulso', 'https://www.example.com', 'Relógio'),
    (45.0, 'Bolsa feminina', 'https://www.example.com', 'Bolsa'),
    (80.0, 'Jaqueta de couro', 'https://www.example.com', 'Jaqueta');