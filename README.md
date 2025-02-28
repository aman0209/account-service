**Account Service Application**

**Overview**
This application is a backend service for handling account and transaction data for users. It provides two key functionalities:

1. View all accounts of a user: Retrieves a list of accounts associated with a specific user.
2. View all transactions of a particular account: Retrieves all transactions associated with a specific account.

The schema.sql file is responsible for creating the necessary tables and populating them with dummy data for testing purposes.

**API Endpoints**

1. Get All Accounts of a User
URL: HTTP:localhost:8080/accounts/user/{userId}
Method: GET

2. Get All Transactions for an Account
URL: HTTP:localhost:8080/transactions/account/{accountId}
Method: GET

