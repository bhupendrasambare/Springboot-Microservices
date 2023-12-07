# Docker Commands

### Run registry

```bash
for dir in registry; do (cd "$dir" && mvn clean install); done

cd registry
docker build -t microservice:registry .
```
 
- Copy the IP address from registry and add to api-gateway and services

```bash
for dir in api-gateway department-service user-service; do (cd "$dir" && mvn clean install); done
cd api-gateway 
docker build -t microservice:api-gateway .
cd department-service 
docker build -t microservice:department-service  .
cd user-service 
docker build -t microservice:user-service  .
```
- Run docker images over containers

```bash
docker run --network=microservice -d -p 8761:8761 microservice:registry . 
docker run --network=microservice -d -p 9191:9191 microservice:api-gateway . 
docker run --network=microservice -d -p 9001:9001 microservice:department-service .
docker run --network=microservice -d -p 9002:9002 microservice:user-service .

```

```

