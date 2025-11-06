# Advertisement Notification System - Application Context

# Project Overview

This project is the **Advertisement Notification System**, responsible for delivering advertisement notifications asynchronously to customers. It leverages **websocket communication** so that users subscribed to a destination can receive notifications in near real time.

The solution consists of two coordinated modules:

1. **advertisement-notification-producer** → receives ads from the marketing department, persists them, and publishes them to a message broker.
2. **notification-system** → listens to broker messages and decides the appropriate channel (websocket, email, mobile, etc.) to notify each user.

Primary goals:

* Deliver fast advertisement notifications without degrading the user experience.
* Ensure high availability by decoupling notification production from notification delivery.

---

# Tech Stack Constraints

## Backend

* **Java 17**
* **Gradle 7.6.1**
* **Spring Boot 2.x/3.x**
* **Spring WebSocket** for async notification delivery
* **Spring Scheduling** for periodic processing (10s interval)
* **MongoDB** or **custom in-memory repository** (configurable via `application.yml`)
* **Redis** (for caching, optional)
* **Kafka + Zookeeper** as message broker
* **Docker** and **Docker Compose**
* **Unit Testing**: JUnit 5 + Mockito

---

# Architectural Rules

## Launch Guidelines

* Use `docker-compose` to bootstrap infrastructure:

    * Zookeeper
    * Kafka
    * MongoDB / custom in-memory DB
    * Redis
* Then start Spring Boot apps:

```bash
./gradlew bootRun
```

## Backend Guidelines

* Follow **SOLID principles**.
* Apply **Clean Architecture**:

    * Domain models and repositories under `/domain`
    * Service interfaces (prefix with `I`) and implementations separated
* Communication rules:

    * **Producer module** only publishes messages
    * **Notification system** consumes messages and dispatches to channels
* Repository conventions:

    * `saveAdvertisement(...)`
    * `findAdvertisementByUserId(...)`
    * `deleteAdvertisementByUserId(...)`
* Scheduled tasks deliver messages every 10s
* Notification channels: `WEB`, `EMAIL`, `MOBILE`

## Endpoint Rules

* **POST /advertisement-notifications** → send notifications
* **POST /advertisement-exclusions/customers/{userId}** → opt-out user
* **DELETE /advertisement-exclusions/customers/{userId}** → re-enable notifications
* Responses in consistent JSON format:

```json
{ "data": <payload> }
```

## Testing Guidelines

* **Unit tests** must validate:

    * WebSocket delivery to subscribed users
    * Exclusion logic prevents opted-out users from receiving notifications
    * Re-enabling works correctly
    * Scheduled tasks publish and process messages correctly
* Use **Mockito** to simulate dependencies (Mongo, Kafka, Redis)
* Tests must not depend on Dockerized infrastructure

---

# Folder / Package Conventions

* Base package: `br.com.notification`
* Suggested module layout:

```text
br/com/notification
  /domain
  /usecase
      /notification
          /send
          /cancel
          /enable
  /adapter
      /repository
      /websocket
      /kafka
  /service
```

* Endpoint classes under `usecase/<feature>/endpoint`
* Mapping utilities under `usecase/<feature>/mapping`
* DTOs under `usecase/<feature>/contract`

---

# Summary

This system ensures **asynchronous, resilient, and scalable** delivery of advertisement notifications.
It decouples producers and consumers, supports multiple notification channels, and is container-ready with Kafka, MongoDB, and Redis.
Following strict architectural, testing, and folder conventions ensures maintainability, testability, and clarity for future development.
