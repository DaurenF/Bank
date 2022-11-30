# Bank
<h1>Before running program we should get last currency of USD</h>
<h3>localhost:8080/getCurrency</h3>

<h2>Post request to save a new transaction</h2>
<h3>localhost:8080/transaction/new?sum=150000.00&account_from=0&account_to=1&expense_category=product</h3>
<h2>Post request to save a new limit</h2>
<h3>localhost:8080/limit/new?value=2000&expense_category=product</h3>

<h2>Get request about limit by id</h2>
<h3>localhost:8080/limit/1</h3>
----------------------------------------------------
<h2>Post request to save a new transaction with category service</h2>
<h3>localhost:8080/transaction/new?sum=150000.00&account_from=0&account_to=1&expense_category=service</h3>
<h2>Post request to save a new limit with category service</h2>
<h3>localhost:8080/limit/new?value=2000&expense_category=service</h3>
<h2>Get all limits</h2>
<h3>localhost:8080/limit/getAll</h3>

<h2>Get all transactions that are off limit</h2>
<h3>localhost:8080/transaction/getOffLimit</h3>
