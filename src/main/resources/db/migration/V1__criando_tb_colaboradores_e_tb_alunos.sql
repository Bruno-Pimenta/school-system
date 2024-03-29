
CREATE TABLE tb_colaboradores(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(100) UNIQUE NOT NULL,
    cpf VARCHAR(15) UNIQUE NOT NULL,
    cargo VARCHAR(50),
    cep VARCHAR(9),
    logradouro VARCHAR(255),
    numero Int,
    bairro VARCHAR(255),
    complemento VARCHAR(255),
    cidade VARCHAR(255),
    uf VARCHAR(2)
 );
 
 CREATE TABLE tb_alunos(

    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(100) UNIQUE NOT NULL,
    cpf VARCHAR(15) UNIQUE NOT NULL,
    curso VARCHAR(50),
    telefone VARCHAR(20),
    cep VARCHAR(9),
    numero Int,
    logradouro VARCHAR(255),
    bairro VARCHAR(255),
    complemento VARCHAR(255),
    cidade VARCHAR(255),
    uf VARCHAR(2)
);