# Cloud Telemetry API 

API REST diseñada en Java para el registro y monitoreo de métricas/eventos en tiempo real. Este proyecto esta siendo desarrollado con un enfoque **Cloud-Native**, utilizando **Docker** para la contenedorización y entornos de producción en **Amazon Web Services (AWS)**.

El objetivo principal es dominar el ciclo de despliegue moderno: desde el desarrollo local en contenedores hasta la persistencia en bases de datos administradas en la nube.

---

## Tecnologías Utilizadas

*   **Backend:** Java 17+ / Spring Boot (Spring Web, Spring Data JPA)
*   **Contenedores:** Docker & Docker Compose
*   **Base de Datos:** PostgreSQL
*   **Cloud (AWS):** Amazon RDS (Relational Database Service) & AWS App Runner / Beanstalk

---

## Arquitectura del Sistema

El flujo de la información está estructurado de la siguiente manera:
1. El cliente envía métricas de monitoreo mediante peticiones HTTP (JSON) a la API.
2. La API (corriendo dentro de un contenedor Docker) procesa la información.
3. Los datos se persisten en una base de datos PostgreSQL (local en desarrollo, AWS RDS en producción).

---

## Guía de Inicio Rápido (Desarrollo Local)

Sigue estos pasos para levantar el entorno de desarrollo en tu máquina local usando Docker.

### Prerrequisitos
*   Java 17 o superior instalado
*   Docker y Docker Compose instalados

### 1. Levantar la Base de Datos (Local)
Para no instalar PostgreSQL directamente en el sistema operativo, ejecuta el contenedor preconfigurado:
```bash
docker-compose up -d
