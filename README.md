# Spring-Task

Development task
Create a java spring boot backend application that manages purchases and refunds
transactions for customers:
General Requirements
- The service receives HTTP requests for Registering Products, Customers, Purchases
and Refunds.
- The service reads and writes to a Postgres database.
- The service uses spring boot version 3.2.0 with Yaml Application configuration
- The service uses Hibernate JPA for the data access layer.
- Endpoints are RESTful and protected by BASIC AUTH (username: test, password: test)
- Endpoints returns HTTP 404 when a customer/product/purchase is not registered.
Data Requirements
1) Create the database with name: taskdb and access username (task) and password
(p@ssw0rd)
2) Create the required Entities/Tables/Relations for:
● Customer: id name, phone
● Purchase: id, customer, product, amount
● Refund: id, purchase, customer, product, amount
● Product: id, name, price
Endpoints Requirements
1) Create endpoints for POST/PUT/DELETE /customer for create/update/delete a
customer.
2) Create an endpoint POST/PUT/DELETE /product for create/update/delete a product.
3) Create an endpoint POST /purchase for registering a purchase transaction
4) Create an endpoint POST /refund for registering a refund transaction
Reporting Requirements
1) Create a scheduled job:
a) The job runs every day at 01:00 AM
b) The job generate a report containing yesterday’s purchases and refunds
c) The job sends the report as a html table to an email address defined in
application.yml
