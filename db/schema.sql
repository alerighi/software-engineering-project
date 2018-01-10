-- schema del database NegozioCD

-- pulisco il database per ricrearlo da capo
DROP SCHEMA public CASCADE;
CREATE SCHEMA public;

-- creazione database 
CREATE TABLE clients (
    tax_code      VARCHAR(50)   NOT NULL PRIMARY KEY,
    username      VARCHAR(50)   NOT NULL,
    password      VARCHAR(50)   NOT NULL,
    first_name    VARCHAR(50)   NOT NULL,
    last_name     VARCHAR(50)   NOT NULL,
    city          VARCHAR(50)   NOT NULL,
    phone         VARCHAR(50)   NOT NULL,
    mobile_phone  VARCHAR(50),
    is_admin      BOOLEAN       NOT NULL DEFAULT FALSE
);

CREATE TABLE CDs (
    code                  INTEGER       NOT NULL PRIMARY KEY,
    title                 VARCHAR(50)   NOT NULL,
    cover_image           VARCHAR(50)   NOT NULL,
    price                 DECIMAL(5,2)  NOT NULL,
    date_since_on_sale    DATE          NOT NULL DEFAULT CURRENT_DATE,
    author                VARCHAR(50)   NOT NULL,
    genre                 VARCHAR(50)   NOT NULL,
    number_of_pieces      INTEGER       NOT NULL
);

CREATE TABLE songs (
    cd    INTEGER     NOT NULL REFERENCES CDs,
    title VARCHAR(50) NOT NULL,
    PRIMARY KEY (cd, title)
);

CREATE TABLE sales (
    id              SERIAL        PRIMARY KEY, 
    client          VARCHAR(50)   NOT NULL REFERENCES clients,
    total_amount    INTEGER       NOT NULL,
    date            DATE          NOT NULL DEFAULT CURRENT_DATE,
    ip              VARCHAR(16)   NOT NULL,
    payment_method  VARCHAR(50)   NOT NULL,
    delivery_method VARCHAR(50)   NOT NULL
);

CREATE TABLE sales_product (
    sale          INTEGER     REFERENCES sales,
    product       INTEGER     NOT NULL REFERENCES CDs,
    amount        INTEGER     NOT NULL,
    PRIMARY KEY (sale, product)
);

CREATE TABLE musicians (
    name          VARCHAR(50) NOT NULL PRIMARY KEY,
    main_genre    VARCHAR(50) NOT NULL,
    year_of_birth INTEGER     NOT NULL
);

CREATE TABLE instruments (
    musician    VARCHAR(50) NOT NULL REFERENCES musicians,
    instrument  VARCHAR(50) NOT NULL,
    PRIMARY KEY (musician, instrument)
);

CREATE TABLE musician_cd (
    cd          INTEGER     NOT NULL REFERENCES CDs,
    musician    VARCHAR(50) NOT NULL REFERENCES musicians,
    instrument  VARCHAR(50) NOT NULL,
    PRIMARY KEY (cd, musician, instrument)
);

CREATE TABLE cart (
    client  VARCHAR(50) NOT NULL REFERENCES clients,
    product INTEGER     NOT NULL REFERENCES CDs,
    amount  INTEGER     NOT NULL,
    PRIMARY KEY (client, product)
);

-- popolazione della base di dati con valori predefiniti
INSERT INTO CDs
    (code, title,                       cover_image,  price,  author,           genre,              number_of_pieces) VALUES
    (1,    'The Wall',                  'wall.jpg',   20,     'Pink Floyd',     'progressive rock', 100             ),
    (2,    'Wish you were here',        'wish.jpg',   14,     'Pink Floyd',     'progressive rock', 40              ),
    (3,    'The Dark Side Of The Moon', 'dark.jpg',   16.99,  'Pink Floyd',     'progressive rock', 10              ),
    (4,    'Appetite for Destruction',  'a.jpg',      14.50,  'Guns N'' Roses', 'rock',             1               ),
    (5,    'Led Zeppelin',              '_.jpg',      13,     'Led Zeppelin',   'rock',             50              ),
    (6,    'Led Zeppelin II',           '_.jpg',      13,     'Led Zeppelin',   'rock',             4               ),
    (7,    'Led Zeppelin III',          '_.jpg',      13.30,  'Led Zeppelin',   'rock',             3               ),
    (8,    'Led Zeppelin IV',           '_.jpg',      13,     'Led Zeppelin',   'rock',             2               ),
    (9,    'Back In Black',             '_.jpg',      15,     'AC/DC',          'rock',             11              ),
    (10,   'Fear Of The Dark',          '_.jpg',      17,     'Iron Maiden',    'metal',            4               ),
    (11,   'The Number of the Beast',   '_.jpg',      17,     'Iron Maiden',    'metal',            0               );

INSERT INTO songs
    (cd, title                       ) VALUES
    (3,  'Speak To Me'               ),
    (3,  'Breathe'                   ),
    (3,  'On The Run'                ),
    (3,  'Time'                      ),
    (3,  'The Great Gig In The Sky'  ),
    (3, 'Money'                      ),
    (3, 'Us And Them'                ),
    (3, 'Any Colour You Like'        ),
    (3, 'Brain Damage'               ),
    (3, 'Eclipse'                    );

INSERT INTO musicians
    (name,              main_genre,         year_of_birth) VALUES
    ('David Gilmour',   'progressive rock', 1946         ),
    ('Roger Walters',   'progressive rock', 1943         ),
    ('Richard Wright',  'progressive rock', 1943         ),
    ('Nick Manson',     'progressive rock', 1944         );

INSERT INTO instruments
    (musician,        instrument) VALUES
    ('David Gilmour', 'chitarra'),
    ('Roger Walters', 'basso'   );

INSERT INTO musician_cd
    (cd, musician,          instrument  ) VALUES
    (3,  'David Gilmour',   'chitarra'  ),
    (3,  'Roger Walters',   'basso'     ),
    (3,  'Richard Wright',  'tastiera'  ),
    (3,  'Nick Manson',     'batteria'  );

INSERT INTO clients
    (tax_code,          username,   password,   first_name,   last_name, city,                          phone,       mobile_phone, is_admin) VALUES
    ('XXXXXXXXXXXXXXX', 'admin',    'admin',    'Admin',      'Admin',   '-',                           '-',         '-',          TRUE    ),
    ('XXXXXXXXXXXXXXA', 'alerighi', 'alerighi', 'Alessandro', 'Righi',   'San Pietro in Cariano (VR)', '0456801847', '2498437935', FALSE   );
