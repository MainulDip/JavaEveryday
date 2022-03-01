## Spring-boot Quick Walk through With Java/Maven:

```sh
docker exec -it <postgrescontainer> psql -U mainuldip
\l // show databases
CREATE DATABASE student;
\du // show database users
#CREATE USER springuser SUPERUSER WITH PASSWORD 'password'; // SuperUser
CREATE USER springuser WITH PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE "student" TO springuser;

# Inter into databasee
\c <database> // select database 
\d // describe relations
\d <table> // describe table or sequence
```


## Spring Boot Layers
1. Controller: Called By Application Context. Describes APIs, RestControllers and Get/Post Mapping. Naming Convention <Package>Controller like StudentController
2. Service: Called by Controller. Serve Data, Naming Convention <Package>Service like StudentService
3. Repository: Called by Service. Interface class that will access the database. Naming Convention <Package>Repository like StudentRepository
4. Configuration: Called By Repository to handle data, CommandLineRunner etc. Naming Convention <Package>Config like StudentConfig
5. Schema: Database Schema Definitions, Naming Convention <Package> like Student