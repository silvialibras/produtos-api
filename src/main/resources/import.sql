-- Exemplo de dados iniciais para produtos
INSERT INTO product (nome, preco, categoria, personalizavel, descricao, imagem_url)
VALUES
    ('Camiseta Básica', 29.90, 'CAMISETA', true, 'Camiseta 100% algodão', 'https://exemplo.com/camiseta.jpg'),
    ('Caneca Premium', 39.90, 'CANECA', true, 'Caneca de cerâmica', 'https://exemplo.com/caneca.jpg');

-- Materiais e tamanhos (IDs 1 e 2 correspondem aos produtos acima)
INSERT INTO produto_materiais (produto_id, material)
VALUES
    (1, 'ALGODAO'),
    (2, 'CERAMICA');

INSERT INTO produto_tamanhos (produto_id, tamanho)
VALUES
    (1, 'P'), (1, 'M'), (1, 'G'),
    (2, 'UNICO');