# house-of-microservices-quarkus-contract-testing-sample

## Scope

![the application in action](readme/house-gif.gif)


## Usage

You will need to run the front-end and bff separately.

### Frontend

```
cd frontend
npm start
```

Access the front end on `http:\\localhost:3000`.

### BFF ("best friend forever"):

```
cd bff
quarkus dev
```

Access the BFF on `http:\\localhost:8080`.

### Testing

#### Front end

For the contract tests, a pact proxy will need to be running. 

#### Back end 

For the contract tests, if you weren't using 
the `@QuarkusTest` annotation, the server will need to be running.
the `@QuarkusTest` annotation starts a server on port 8081, 
so it is sufficient to run the contract test. 

To run all the tests, do 

```
cd bff
mvn test
```

For a full set of steps for a live coding demo, see the [demo script](./demo-script.md).