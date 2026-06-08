# Pulse Project

This repository contains the Pulse microservices. Currently, it includes the `patient-service` and its associated PostgreSQL database.

## Prerequisites
- Docker and Docker Desktop
- Java 21 (for local development)
- Maven 3.9+ (for local development)

## Getting Started (Docker)

The easiest way to run the entire stack is using **Docker Compose**. Run these commands from the project root:

### Quick Start
```bash
# Start everything in the background
docker-compose up -d
```

### Essential CLI Commands

| Action | Command | Description |
| :--- | :--- | :--- |
| **Start / Update** | `docker-compose up -d --build` | Starts containers and rebuilds images if code changed. |
| **Stop** | `docker-compose down` | Stops and removes containers (data is preserved). |
| **Watch Logs** | `docker-compose logs -f` | Streams logs from all containers in real-time. |
| **Check Status** | `docker-compose ps` | Shows running containers and their health status. |
| **Restart** | `docker-compose restart` | Restarts containers without recreating them. |

### Troubleshooting: Wipe and Start Fresh
If the database becomes corrupted or you need to reset the schema/credentials:
1. `docker-compose down`
2. `rm -rf patient-service-db/*` (Deletes local database files)
3. `docker-compose up -d`

## Project Structure
- `/patient-service`: Spring Boot 4.0.6 Java application.
- `/patient-service-db`: Local bind-mount folder for PostgreSQL 18 data.
- `docker-compose.yml`: Orchestration file for the service and database.

## API Documentation
Once the service is started, you can access the Swagger UI at:
[http://localhost:4000/swagger-ui/index.html](http://localhost:4000/swagger-ui/index.html)
