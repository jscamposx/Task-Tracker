#📌Task Tracker
Task Tracker es un proyecto diseñado para ayudarte a **rastrear y gestionar tus tareas directamente desde la línea de comandos**. 🚀 Con esta sencilla interfaz CLI, podrás organizar eficientemente tus pendientes, lo que estás haciendo y tus logros. Este proyecto es una excelente oportunidad para fortalecer tus habilidades de programación en Java, incluyendo la manipulación de archivos, el procesamiento de entradas de usuario y la construcción de aplicaciones CLI robustas con Spring Boot y Spring Shell.

## ✨ Funcionalidades Principales

Esta aplicación te permitirá interactuar con tus tareas a través de comandos en la terminal. Los requerimientos clave son:

- **➕ Agregar, ✏️ actualizar y 🗑️ eliminar tareas:** Gestiona el ciclo de vida completo de tus tareas.
- **🚦 Marcar el estado de una tarea:** Podrás indicar si una tarea está **Pendiente (`TODO`)** o **Completada (`DONE`)**.
- **📄 Listar todas las tareas:** Obtén una visión general de todas tus tareas registradas.
- **✅ Listar las tareas completadas:** Filtra y visualiza solo las tareas que ya has finalizado.
- **⏳ Listar las tareas pendientes:** Enfócate en lo que aún necesitas hacer consultando la lista de tareas pendientes.

## 💾 Persistencia de Datos

Las tareas se almacenarán en un **archivo JSON** en tu sistema. Esto permitirá que tus tareas persistan entre sesiones de la aplicación.

#📋Desarrollo Task Tracker

## Tecnologías Utilizadas

- **Lenguaje:** Java ☕ (versión 21)
- **Framework:** Spring Boot 🚀
- **Gestor de Dependencias:** Maven

## Dependencias

1. **Spring Shell Starter (`spring-shell-starter`)**: ⌨️ Se utiliza para crear una interfaz de línea de comandos (CLI) interactiva para la aplicación. Permite a los usuarios interactuar con las tareas mediante comandos de texto.
2. **Lombok**: 🧱 Simplifica la escritura de código Java al eliminar la necesidad de escribir código boilerplate como getters, setters, constructores y los métodos `equals()`, `hashCode()` y `toString()` mediante el uso de anotaciones.
3. **Jackson (`com.fasterxml.jackson.core`)**: ⚙️ Se utiliza para la **serialización** (convertir objetos Java a formato JSON) y **deserialización** (convertir formato JSON a objetos Java) de las tareas, lo que podría ser útil para guardar o transferir datos.
4. **Spring Boot DevTools (`spring-boot-devtools`)**: 🛠️ Proporciona funcionalidades útiles durante el desarrollo, como el reinicio automático de la aplicación cuando se detectan cambios en el código, lo que acelera el ciclo de desarrollo.
## Estructura

task/
├── [[⌨️ Cli]]                 # Contiene la lógica de la interfaz de línea de comandos
├── [[❗ Exceptions]]    # Contiene las excepciones personalizadas de la aplicación
├── [[🧱 Model]]           # Contiene las clases que representan los datos de la aplicación
├── [[💾 Repository]]    # Contiene las interfaces e implementaciones
└── [[⚙️ Service]]          # Contiene la lógica de negocio de la aplicación





