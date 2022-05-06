create table accounts (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    name VARCHAR(255) NOT NULL UNIQUE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

create table transactions (
    id UUID PRIMARY KEY,
    description VARCHAR(255),
    transaction_value NUMERIC(19, 2),
    origin BIGINT REFERENCES accounts(id),
    destination BIGINT REFERENCES accounts(id),
    created_at TIMESTAMP
);

