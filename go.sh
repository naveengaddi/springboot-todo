#!/usr/bin/env bash

#create todo
curl -v --location --request POST 'http://localhost:8080/v1/todos' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"Read Head First Java",
"dueDate":"2022-01-23'T'12:00:00.002Z"
}'

#get todos
curl --location --request GET 'http://localhost:8080/v1/todos'

#get todo by id
curl --location --request GET 'http://localhost:8080/v1/todos/1'

#delete todo by id
curl --location --request DELETE 'http://localhost:8080/v1/todos/1'