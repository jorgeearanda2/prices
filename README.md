# Prices service

Service which expose features in order to manage information regarding products prices

### Configuration
Be aware of application.yaml as it has db configuration in case access is needed

### Build and Package
```
mvn clean install
```

## Local Development

### Deployment
```
mvn spring-boot:run
```

### Testing
```
mvn test
```

Integration test are at PricesControllerIT.java including given examples.

### Spec

Spec can be accessed via http://localhost:8080/swagger-ui/index.htm and swagger ui will be rendered.

### Additional info

A Postman Collection has been attached in postman_collection. It includes given examples requests.
