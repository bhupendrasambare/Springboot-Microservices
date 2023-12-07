# Docker Commands

### Run registry

```bash
for dir in registry; do (cd "$dir" && mvn clean install); done

cd registry
docker build -t bhupendra1404/microservice:registry .
docker run  -d -p 8761:8761 bhupendra1404/microservice:registry . 
cd ..
```
 
- Copy the IP address from registry and add to api-gateway and services

```bash
for dir in api-gateway department-service user-service; do (cd "$dir" && mvn clean install); done
cd api-gateway 
docker build -t bhupendra1404/microservice:api-gateway .
cd ..
cd department-service 
docker build -t bhupendra1404/microservice:department-service  .
cd ..
cd user-service 
docker build -t bhupendra1404/microservice:user-service  .
```
- Run docker images over containers

```bash
docker run --network=microservice -d -p 8761:8761 bhupendra1404/microservice:registry . 
docker run --network=microservice -d -p 9191:9191 bhupendra1404/microservice:api-gateway .
docker run --network=microservice -d -p 9001:9001 bhupendra1404/microservice:department-service .
docker run --network=microservice -d -p 9002:9002 bhupendra1404/microservice:user-service .

```

```

