# Run
to execute the application locally

## Start the databsse

run the database docker container configuration
```bash
docker-compose --project-directory postgres up -d
```

## Execute

execute the project
```bash
./gradlew bootRun 
```

# Stopping

After using the application you can
 - stop the project
 - remove the test database

to remove the test database:
```bash
docker-compose --project-directory postgres down --volumes
```
