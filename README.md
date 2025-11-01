# Proyecto Backend en Spring Boot

Este proyecto es una API desarrollada con **Spring Boot**, diseñada para manejar las operaciones del backend de la aplicación.  
Incluye controladores, servicios y modelos que gestionan la lógica de negocio y la comunicación con el frontend.

## Requisitos previos

Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas:

## Herramienta | Versión recomendada | Verificación |

**Java (JDK)** | 17.0.17 | `java -version` |
**Maven** | 3.9.11 | `mvn -version` |
**IDE recomendado** | IntelliJ IDEA / Eclipse / VS Code | — |
**Git** | Última versión estable | `git --version` |

Se recomienda tener configurada la variable de entorno **JAVA_HOME** apuntando al directorio del JDK.


Clonar el repositorio

## Ejecuta los siguientes comandos en tu terminal:
git clone
https://github.com/caarenasm/proyecto-angular-spring-boot-backend.git

----------------------------------------------------//---------------------------------------------//-----------------------------------------------------------

## voy agregar esturctura de la DB que la exporte en SQL para que la puedan replicar allí están los datos como los llama el back

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `db_backend_users` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_backend_users`;

CREATE TABLE IF NOT EXISTS `tareas` (
  `client_id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `completed` tinyint DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `tareas` (`client_id`, `title`, `description`, `completed`) VALUES
	('851c78b5-66d6-41e4-a86e-d0f2129d7c35', 'Desarrollo', 'Software', 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;



