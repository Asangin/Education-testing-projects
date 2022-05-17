# A number of projects created to study different approaches and tools in testing

## Application under test (AUT)

### AUT description
All projects will be using [Golang Web Application](https://github.com/Asangin/go-webapp-sample) as a application under
test.
It's a [fork](https://github.com/ybkuroki/go-webapp-sample) of application that was made
by [Yuta Kuroki](https://github.com/ybkuroki)

### Run AUT from source

So before running some test projects, we need to deploy the application locally, deployment described
in [README](https://github.com/Asangin/go-webapp-sample/blob/master/README.md#starting-server). However, in some
project, AUT can be running as a precondition.
1. Precondition is download and install [Golang](https://golang.org/)
2. Close AUT repository 
```bash 
git clone https://github.com/Asangin/go-webapp-sample.git
``` 
2. cd into project and run server
```bash 
cd go-webapp-sample
go run main.go 
``` 

### Run AUT in docker

```bash
docker-compose up
```



## Maven

### Run test in particular module

```bash
mvn clean test -pl playwright-tests
```

```bash
mvn clean test -Dtest=MainTest -pl wiremock-tests
```