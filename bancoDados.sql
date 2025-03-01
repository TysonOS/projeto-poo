drop database if exists study_tracker;
create database study_tracker;
use study_tracker;
-- Um assunto funciona como uma lista que contém as tarefas/tópicos de estudo
create table assunto(
    id INT auto_increment PRIMARY KEY,
    titulo VARCHAR(60),
    descricao VARCHAR(255),
    dataCriacao DATE
);

create table tarefas(
    id INT auto_increment PRIMARY KEY,
    assuntoId INT,    
    foreign key (assuntoId) references assunto(id) ON DELETE CASCADE,
    titulo VARCHAR(60),
    descricao VARCHAR(255),
    concluida BOOLEAN default false,
    dataCriacao TIMESTAMP default current_timestamp,
    prazoConclusao DATE default null
);
