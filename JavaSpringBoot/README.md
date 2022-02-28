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
\c student
\d // Show Relations
```
