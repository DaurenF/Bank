# Bank
<h1>Before running program we should get the lastest currency of USD to KZT</h>
<div>localhost:8080/getCurrency</div>

<h2>Post request to save a new transaction</h2>
<div>localhost:8080/transaction/new?sum=150000.00&account_from=0&account_to=1&expense_category=product</div>
<h2>Post request to save a new limit</h2>
<div>localhost:8080/limit/new?value=2000&expense_category=product</div>

<h2>Get request about limit by id</h2>
<div>localhost:8080/limit/1</div>
----------------------------------------------------
<h2>Post request to save a new transaction with category service</h2>
<div>localhost:8080/transaction/new?sum=150000.00&account_from=0&account_to=1&expense_category=service</div>
<h2>Post request to save a new limit with category service</h2>
<div>localhost:8080/limit/new?value=2000&expense_category=service</div>
<h2>Get all limits</h2>
<div>localhost:8080/limit/getAll</div>

<h2>Get all transactions that are off limit</h2>
<div>localhost:8080/transaction/getOffLimit</div>


------------------------------------------------
<div>If there is no working liquibase, I have uploaded bank.sql file to manually import database</div>
