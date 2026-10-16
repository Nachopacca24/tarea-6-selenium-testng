<div align="center">

<h1>Tarea 6: Selenium y TestNG, de Maven a Gradle</h1>

Pruebas de navegador contra <a href="https://www.saucedemo.com">saucedemo.com</a> con Selenium WebDriver, TestNG y Page Objects.<br>
El proyecto se construye con Maven, y la tarea es pasarlo a Gradle.

[![Java 21](https://img.shields.io/badge/Java-21-555555?style=flat-square&logo=openjdk)](#requisitos)
[![Selenium WebDriver](https://img.shields.io/badge/Selenium-WebDriver-43B02A?style=flat-square&logo=selenium&logoColor=white)](#qué-trae)
[![TestNG](https://img.shields.io/badge/TestNG-suite-555555?style=flat-square)](#qué-trae)
[![De Maven a Gradle](https://img.shields.io/badge/Maven%20a%20Gradle-02303A?style=flat-square&logo=gradle)](#ejercicio)
[![Entrega 15 oct 23:59](https://img.shields.io/badge/entrega-15%20oct%2023%3A59-2E5D4B?style=flat-square)](#entrega)

[Requisitos](#requisitos) | [Qué trae](#qué-trae) | [Ejercicio](#ejercicio) | [Entrega](#entrega)

</div>

---

## Requisitos

Se necesita Java 21 y Google Chrome. El proyecto ya está en Gradle y trae el wrapper, así que no hace falta instalar Gradle:

```bash
./gradlew test                       # suite de testng.xml (headless)
./gradlew test -Pheadless=false      # misma suite con el navegador visible
./gradlew dynamicSuite               # suite armada en código, solo smoke
./gradlew dynamicSuite -Pgroups=regression -Pheadless=false
```

En Windows (PowerShell/cmd) se usa `.\gradlew.bat` en lugar de `./gradlew`.

`testng.xml` quedó editado para correr dos bloques: `smoke` (login y carrito) y `login-regression` (regresión de login sin el caso de contraseña incorrecta).

## Qué trae

| Archivo | Contenido |
|---|---|
| `src/test/java/edu/ufm/qa/pages/` | Los Page Objects de login, inventario, carrito y checkout. |
| `src/test/java/edu/ufm/qa/tests/` | `LoginTest` y `CartTest`, con sus grupos `smoke` y `regression`. |
| `testng.xml` | La suite que corre `./gradlew test`. |
| `src/test/java/edu/ufm/qa/DynamicSuiteRunner.java` | La misma idea de suite, armada en código. |
| `build.gradle`, `settings.gradle`, `gradlew` | El build de Gradle (reemplaza al `pom.xml` de Maven). |

## Ejercicio

Se permite usar LLMs en todos los pasos.

1. Hacer fork de este repo y correr las pruebas.
2. Correrlas con el navegador visible.
3. Editar `testng.xml` para cambiar qué pruebas corren.
4. Convertir el proyecto de Maven a Gradle y correr las pruebas con Gradle.

## Entrega

La fecha límite es el jueves 15 de octubre de 2026 a las 23:59. Se entregan dos cosas:

- El link al fork, con el proyecto ya en Gradle.
- Un video del flujo corriendo con Gradle y el navegador visible.
