-- V2:Migrations para adicionar a coluna de EDITORA na tabala de TB_LIVROS, restart de ID, para mantermos a sequência

ALTER TABLE tb_livros
ADD COLUMN  editora VARCHAR(255);

ALTER TABLE tb_livros
ALTER COLUMN id RESTART WITH 2;