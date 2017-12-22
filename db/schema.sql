-- schema del database NegozioCD

DROP DATABASE NegozioCD;

CREATE DATABASE NegozioCD;

USE NegozioCD;

CREATE TABLE utenti (
    id int NOT NULL AUTO_INCREMENT,
    codice_fiscale VARCHAR(20) NOT NULL, 
    username VARCHAR(20) NOT NULL, 
    password VARCHAR(20) NOT NULL,
    nome VARCHAR(20) NOT NULL, 
    cognome VARCHAR(20) NOT NULL, 
    residenza VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    cellulare VARCHAR(20),
    PRIMARY KEY (id)
);

INSERT INTO utenti (codice_fiscale, username, password, nome, cognome, residenza, telefono, cellulare) VALUES
    ('XXXXXXXXXXXXXXX', 'alerighi', 'alerighi', 'Alessandro', 'Righi', 'San Pietro in Cariano (VR)', '0456801847', '2498437935');

CREATE TABLE vendite (
    id int NOT NULL AUTO_INCREMENT,
    cliente int NOT NULL, 
    prezzo int NOT NULL, 
    data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ip VARCHAR(16) NOT NULL, 
    pagamento VARCHAR(20) NOT NULL, 
    consegna VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE acquisti (
    cliente int NOT NULL, 
    prodotto int NOT NULL
);

CREATE TABLE cd (
    id int NOT NULL AUTO_INCREMENT,
    titolo VARCHAR(50) NOT NULL,
    copertina VARCHAR(50) NOT NULL, 
    prezzo int NOT NULL, 
    data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, 
    titolare VARCHAR(50) NOT NULL,
    genere VARCHAR(20),
    quantita int,
    PRIMARY KEY (id)
);

INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('The Wall', 'wall.jpg', 20, 'Pink Floyd', 'progressive rock');
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('Wish you were here', 'wish.jpg', 14, 'Pink Floyd', 'progressive rock');
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('The Dark Side Of The Moon', 'dark.jpg', 16, 'Pink Floyd', 'progressive rock');
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('Appetite for Destruction', 'a.jpg', 14, 'Guns N\' Roses', 'rock');
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('Led Zeppelin', '_.jpg', 13, 'Led Zeppelin', 'rock'); 
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('Led Zeppelin II', '_.jpg', 13, 'Led Zeppelin', 'rock'); 
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('Led Zeppelin III', '_.jpg', 13, 'Led Zeppelin', 'rock'); 
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('Led Zeppelin IV', '_.jpg', 13, 'Led Zeppelin', 'rock'); 
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('Back In Black', '_.jpg', 15, 'AC/DC', 'rock'); 
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('Fear Of The Dark', '_.jpg', 17, 'Iron Maiden', 'metal');
INSERT INTO cd (titolo, copertina, prezzo, titolare, genere) VALUES 
    ('The Number of the Beast', '_.jpg', 17, 'Iron Maiden', 'metal');

CREATE TABLE brani (
    cd int NOT NULL, 
    titolo VARCHAR(50) NOT NULL
);

INSERT INTO brani (cd, titolo) SELECT id, 'Speak To Me' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'Breathe' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'On The Run' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'Time' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'The Great Gig In The Sky' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'Money' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'Us And Them' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'Any Colour You Like' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'Brain Damage' FROM cd WHERE titolo LIKE 'The dark%';
INSERT INTO brani (cd, titolo) SELECT id, 'Eclipse' FROM cd WHERE titolo LIKE 'The dark%';

CREATE TABLE musicisti (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(20) NOT NULL, 
    genere VARCHAR(20) NOT NULL,
    anno int NOT NULL,
    strumenti VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO musicisti (nome, genere, anno, strumenti) VALUES ('David Gilmour', 'progressive rock', 1946, 'chitarra');
INSERT INTO musicisti (nome, genere, anno, strumenti) VALUES ('Roger Walters', 'progressive rock', 1943, 'basso');
INSERT INTO musicisti (nome, genere, anno, strumenti) VALUES ('Richard Wright', 'progressive rock', 1943, 'tastiera');
INSERT INTO musicisti (nome, genere, anno, strumenti) VALUES ('Nick Manson', 'progressive rock', 1944, 'batteria');

CREATE TABLE musicisti_cd (
    cd int NOT NULL,
    musicista int NOT NULL, 
    strumento VARCHAR(20) NOT NULL
);

INSERT INTO musicisti_cd (cd, musicista, strumento) SELECT cd.id, musicisti.id, 'chitarra' FROM musicisti, cd WHERE cd.titolo LIKE 'The Dark%' AND musicisti.nome like 'David%';
INSERT INTO musicisti_cd (cd, musicista, strumento) SELECT cd.id, musicisti.id, 'basso' FROM musicisti, cd WHERE cd.titolo LIKE 'The Dark%' AND musicisti.nome like 'Roger%';
INSERT INTO musicisti_cd (cd, musicista, strumento) SELECT cd.id, musicisti.id, 'tastiera' FROM musicisti, cd WHERE cd.titolo LIKE 'The Dark%' AND musicisti.nome like 'Richard%';
INSERT INTO musicisti_cd (cd, musicista, strumento) SELECT cd.id, musicisti.id, 'batteria' FROM musicisti, cd WHERE cd.titolo LIKE 'The Dark%' AND musicisti.nome like 'Nick%';

CREATE TABLE carrello (
    cliente int NOT NULL, 
    cd int NOT NULL
);
