-- V3:Migrations para adicionar a coluna de IMGURL na tabela de TB_LIVROS, restart de ID, para mantermos a sequência

ALTER TABLE tb_livros
ADD COLUMN  imgUrl VARCHAR(255);

ALTER TABLE tb_livros
ALTER COLUMN id RESTART WITH 140;