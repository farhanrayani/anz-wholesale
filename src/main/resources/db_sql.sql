insert into account values(9001, 'Account 1', 'SAVINGS', sysdate(), 'USD', '900.5');
insert into account values(9002, 'Account 2', 'CURRENT', sysdate(), 'AUD', '90.5');
insert into account values(9003, 'Account 3', 'SAVINGS', sysdate(), 'USD', '2000.5');


-- Transactions for 9001
insert into transaction values(1901, 9.5, 9, 'DEBIT', 'Transaction 1 for Account 1', sysdate(), 9001);
insert into transaction values(1902, 9.5, 9, 'CREDIT', 'Transaction 2 for Account 1', sysdate(), 9001);
insert into transaction values(1903, 4, 1, 'DEBIT', 'Transaction 3 for Account 1', sysdate(), 9001);

-- Transactions for 9002
insert into transaction values(1904, 11, 9, 'DEBIT', 'Transaction 1 for Account 2', sysdate(), 9002);
insert into transaction values(1905, 9.2, 9, 'CREDIT', 'Transaction 2 for Account 2', sysdate(), 9002);
insert into transaction values(1906, 4.5, 111, 'DEBIT', 'Transaction 3 for Account 2', sysdate(), 9002);