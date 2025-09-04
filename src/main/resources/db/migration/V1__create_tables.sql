CREATE TABLE usuario (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL UNIQUE,
                         senha VARCHAR(255) NOT NULL,
                         role ENUM('USER', 'ADMIN') NOT NULL
);

CREATE TABLE espaco (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        descricao TEXT
);

CREATE TABLE atividade (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           nome VARCHAR(100) NOT NULL,
                           horario DATETIME NOT NULL,
                           capacidade INT NOT NULL,
                           espaco_id BIGINT,
                           FOREIGN KEY (espaco_id) REFERENCES espaco(id)
);

CREATE TABLE reserva (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         usuario_id BIGINT NOT NULL,
                         atividade_id BIGINT NOT NULL,
                         status ENUM('CONFIRMADA', 'CANCELADA') NOT NULL DEFAULT 'CONFIRMADA',
                         data_reserva DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (usuario_id) REFERENCES usuario(id),
                         FOREIGN KEY (atividade_id) REFERENCES atividade(id)
);
