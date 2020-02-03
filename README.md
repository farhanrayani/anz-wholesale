
## Development server

To run project, navigate to AnzWholesaleApplication.java and run as SpringBoot Applciation. Upon server start  up, new Accounts and Transactions are inserted using db_sql.sql (H2 in memory database) located in src/main/resources.

APIs can be accessed via http://localhost:8081
Example:
1) <b>GET</b>
`localhost:8081/anz/accounts/`
2) <b>POST</b>
`localhost:8081/anz/accounts/`

`BODY:
{
    "name": "test account",
    "transactionDate": "2020-01-19T18:43:21.567",
    "transactions": [] ...
}`

3) <b>GET</b>
`localhost:8081/anz/accounts/9001/transactions`

4) <b>POST</b> 
`localhost:8081/anz/accounts/9001/transactions`

`BODY:
{
    "description": "test transaction",
    "postDate": "2020-01-11T19:45:21.000" ...
}`


## Unit Test

To run Unit Test, go to AccountRepositoryTest.java and run as JUnit Test.

