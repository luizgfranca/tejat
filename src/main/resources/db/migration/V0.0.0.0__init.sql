create table ACCOUNTS (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

create table TRANSACTIONS (
    id UUID PRIMARY KEY,
    description VARCHAR(255),
    transaction_value NUMERIC(19, 2),
    transaction_direction INTEGER,
    created_at TIMESTAMP
);