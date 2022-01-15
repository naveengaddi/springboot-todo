# Spring Boot : Todo App (Backend Rest Api) + TDD 

This simple todo rest api app uses Spring boot framework\
Spring web (for rest api)\
Spring jpa (for querying db)\
Lombok(for logging)\
and H2 (for in memory database)

### Start server
```shell
./gradlew clean build
./gradlew bootRun
```


###Usage of apis
1. Create TODO api
```shell
curl -v --location --request POST 'http://localhost:8080/v1/todos' \
--header 'Content-Type: application/json' \
--data-raw '{
"name":"Read Head First Java",
"dueDate":"2022-01-23'T'12:00:00.002Z"
}'
```

2. Get all TODOs api
```shell
curl --location --request GET 'http://localhost:8080/v1/todos'
```

3. Get TODO by Id api
```shell
curl --location --request GET 'http://localhost:8080/v1/todos/{id}'
```

4. Delete TODO by Id api
```shell
curl --location --request DELETE 'http://localhost:8080/v1/todos/{id}'
```

