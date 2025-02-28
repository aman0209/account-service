DROP TABLE IF EXISTS users CASCADE;

DROP TABLE IF EXISTS accounts CASCADE;

DROP TABLE IF EXISTS transactions CASCADE;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    account_number VARCHAR(50) NOT NULL UNIQUE,
    account_name VARCHAR(255) NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    balance_date DATE NOT NULL,
    currency VARCHAR(10) NOT NULL,
    opening_available_balance DECIMAL(15, 2),
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    account_number VARCHAR(50) NOT NULL,
    account_name VARCHAR(255) NOT NULL,
    value_date DATE NOT NULL,
    debit_amount DECIMAL(15, 2),
    credit_amount DECIMAL(15, 2),
    transaction_type VARCHAR(10) NOT NULL,
    transaction_narrative TEXT,
    account_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);


INSERT INTO users (username, email, password) VALUES
('user1', 'user1@example.com', 'password123'),
('user2', 'user2@example.com', 'password123'),
('user3', 'user3@example.com', 'password123'),
('user4', 'user4@example.com', 'password123'),
('user5', 'user5@example.com', 'password123');

INSERT INTO accounts (account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) VALUES
('1000000001', 'SGSavings001', 'Saving', '2025-02-26', 'SGD', 500.00, 1),
('1000000002', 'AUCurrent001', 'Current', '2025-02-26', 'AUD', 6000.00, 1),
('1000000003', 'AUCurrent002', 'Current', '2025-02-26', 'AUD', 570.00, 1);

INSERT INTO accounts (account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) VALUES
('2000000001', 'SGSavings001', 'Saving', '2025-02-26', 'SGD', 200.00, 2),
('2000000002', 'AUCurrent001', 'Current', '2025-02-26', 'AUD', 5000.00, 2),
('2000000003', 'AUCurrent002', 'Current', '2025-02-26', 'AUD', 700.00, 2),
('2000000004', 'AUCurrent003', 'Current', '2025-02-26', 'AUD', 700.00, 2);

INSERT INTO accounts (account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) VALUES
('3000000001', 'SGSavings001', 'Saving', '2025-02-26', 'SGD', 500.00, 3),
('3000000002', 'AUCurrent001', 'Current', '2025-02-26', 'AUD', 500.00, 3);

INSERT INTO accounts (account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) VALUES
('4000000001', 'SGSavings001', 'Saving', '2025-02-26', 'SGD', 500.00, 4),
('4000000002', 'SGSavings002', 'Saving', '2025-02-26', 'SGD', 900.00, 4),
('4000000003', 'AUCurrent001', 'Current', '2025-02-26', 'AUD', 1100.00, 4),
('4000000004', 'AUCurrent002', 'Current', '2025-02-26', 'AUD', 1500.00, 4),
('4000000005', 'AUCurrent003', 'Current', '2025-02-26', 'AUD', 5800.00, 4);

INSERT INTO accounts (account_number, account_name, account_type, balance_date, currency, opening_available_balance, user_id) VALUES
('5000000001', 'SGSavings001', 'Saving', '2025-02-26', 'SGD', 6500.00, 5),
('5000000002', 'AUCurrent001', 'Current', '2025-02-26', 'AUD', 600.00, 5);

INSERT INTO transactions (account_number, account_name, value_date, debit_amount, credit_amount, transaction_type, transaction_narrative, account_id) VALUES
('1000000001', 'SGSavings001', '2025-02-26', NULL, 500.00, 'Credit', null, 1),
('1000000002', 'AUCurrent001', '2025-02-26', 200.00, NULL, 'Debit', null, 1),
('1000000003', 'AUCurrent002', '2025-02-25', 150.00, NULL, 'Debit', null, 1);

INSERT INTO transactions (account_number, account_name, value_date, debit_amount, credit_amount, transaction_type, transaction_narrative, account_id) VALUES
('2000000001', 'SGSavings001', '2025-02-26', NULL, 1000.00, 'Credit', null, 2),
('2000000003', 'AUCurrent002', '2025-02-26', 500.00, NULL, 'Debit', null, 2),
('2000000004', 'AUCurrent003', '2025-02-26', 100.00, NULL, 'Debit', null, 2);

INSERT INTO transactions (account_number, account_name, value_date, debit_amount, credit_amount, transaction_type, transaction_narrative, account_id) VALUES
('3000000001', 'SGSavings001', '2025-02-26', NULL, 1500.00, 'Credit', null, 3),
('3000000002', 'AUCurrent001', '2025-02-25', 250.00, NULL, 'Debit', null, 3);

INSERT INTO transactions (account_number, account_name, value_date, debit_amount, credit_amount, transaction_type, transaction_narrative, account_id) VALUES
('4000000001', 'SGSavings001', '2025-02-26', NULL, 1200.00, 'Credit', null, 4),
('4000000002', 'SGSavings002', '2025-02-26', NULL, 800.00, 'Credit', null, 4),
('4000000003', 'AUCurrent001', '2025-02-26', 300.00, NULL, 'Debit', null, 4),
('4000000004', 'AUCurrent002', '2025-02-26', NULL, 1000.00, 'Credit', null, 4);

INSERT INTO transactions (account_number, account_name, value_date, debit_amount, credit_amount, transaction_type, transaction_narrative, account_id) VALUES
('5000000001', 'SGSavings001', '2025-02-26', NULL, 5000.00, 'Credit', null, 5),
('5000000002', 'AUCurrent001', '2025-02-25', 600.00, NULL, 'Debit', null, 5);


