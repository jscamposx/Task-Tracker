# 📌 Task Tracker CLI

Task Tracker es una aplicación CLI diseñada para **rastrear y gestionar tareas** directamente desde la línea de comandos. 🚀 Con esta herramienta, puedes organizar eficientemente tus pendientes, lo que estás haciendo y tus logros.

Este proyecto es una excelente oportunidad para fortalecer tus habilidades de programación en **Java**, abarcando manipulación de archivos, procesamiento de entradas de usuario y desarrollo de aplicaciones CLI con **Spring Boot y Spring Shell**.

Inspirado y basado en el proyecto sugerido en: [roadmap.sh/projects/task-tracker](https://roadmap.sh/projects/task-tracker)

---

## ✨ Funcionalidades Principales

✅ **Gestión de Tareas:**

-   **➕ Agregar:** Añade nuevas tareas a tu lista.
-   **✏️ Actualizar:** Modifica la descripción y/o el estado de una tarea existente.
-   **🗑️ Eliminar:** Borra tareas que ya no necesites.
-   **🚦 Marcar estado:** Cambia fácilmente el estado de una tarea entre **Pendiente (`TODO`)** y **Completada (`DONE`)**.
-   **📄 Listar:** Muestra todas las tareas registradas.
-   **✅ Filtrar completadas:** Visualiza únicamente las tareas finalizadas.
-   **⏳ Filtrar pendientes:** Visualiza únicamente las tareas por hacer.

💾 **Persistencia de Datos:**

-   Las tareas se almacenan en un **archivo JSON** (`tasks.json` por defecto, configurable), permitiendo que los datos se mantengan entre sesiones de la aplicación.

---

## 🛠️ Tecnologías Utilizadas

| Tecnología                | Descripción                                      |
| :------------------------ | :----------------------------------------------- |
| **Java ☕ (versión 21+)** | Lenguaje de programación principal               |
| **Spring Boot 🚀** | Framework para construir la aplicación           |
| **Spring Shell ⌨️** | Para crear la interfaz de línea de comandos (CLI) |
| **Maven 📦** | Gestor de dependencias y construcción del proyecto |
| **Jackson ⚙️** | Para serialización/deserialización JSON          |
| **Lombok 🧱** | Para reducir código boilerplate (getters, etc.)  |

### 📌 Dependencias Clave (Maven)

1.  **`spring-boot-starter-shell`**: Core de Spring Shell para la funcionalidad CLI.
2.  **`lombok`**: Reduce código repetitivo (requiere configuración en el IDE).
3.  **`jackson-databind`**: Para manejar la lectura/escritura del archivo JSON.
4.  **`spring-boot-devtools`** (Opcional): Para reinicio automático durante el desarrollo.

---

## 📂 Estructura del Proyecto (Simplificada)

```
📦 task-tracker
├── 📁 .mvn/
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java/com/example/task
│   │   │   ├── 📁 cli        # Clases de comandos de Spring Shell (TaskCommands)
│   │   │   ├── 📁 config     # Configuración (ej. ubicación del archivo JSON)
│   │   │   ├── 📁 exception  # Excepciones personalizadas
│   │   │   ├── 📁 model      # Clases del dominio (Task, Status)
│   │   │   ├── 📁 repository # Lógica de acceso a datos (lectura/escritura JSON)
│   │   │   └── 📁 service    # Lógica de negocio (TaskService)
│   │   └── 📁 resources
│   │       └── application.properties
│   └── 📁 test
├── 📄 .gitignore
├── 📄 mvnw
├── 📄 mvnw.cmd
└── 📄 pom.xml      # Archivo de configuración de Maven
```

---

## 🚀 Cómo Ejecutar el Proyecto

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/jscamposz/Task-Tracker.git](https://github.com/jscamposz/Task-Tracker.git)
    cd Task-Tracker
    ```
2.  **Compilar el proyecto:**
    ```bash
    mvn clean install
    ```
3.  **Ejecutar la aplicación:**
    ```bash
    mvn spring-boot:run
    # O también puedes ejecutar el JAR generado:
    # java -jar target/task-tracker-0.0.1-SNAPSHOT.jar
    ```
4.  Una vez ejecutado, verás el prompt de Spring Shell (`shell:>`) listo para recibir comandos.

---

## ⌨️ Comandos CLI Disponibles

Aquí tienes una lista de los comandos disponibles y ejemplos de su uso y salida:

**1. `add "<descripción>"`**
   - Añade una nueva tarea con el estado `TODO` por defecto.
   - **Uso:** `shell:> add "Comprar pan integral"`
   - **Salida:** `✅ Tarea añadida correctamente: Comprar pan integral`

**2. `list`**
   - Muestra todas las tareas con su ID, estado y descripción.
   - **Uso:** `shell:> list`
   - **Salida (Ejemplo):**
     ```text
     --- Lista de Tareas ---
     [1] [TODO] Comprar pan integral
     [2] [DONE] Subir código a GitHub
     [3] [TODO] Preparar presentación
     -----------------------
     ```
   - **Salida (Si no hay tareas):** `ℹ️ No hay tareas registradas.`

**3. `list-todo`**
   - Muestra solo las tareas pendientes (estado `TODO`).
   - **Uso:** `shell:> list-todo`
   - **Salida (Ejemplo):**
     ```text
     --- Tareas Pendientes (TODO) ---
     [1] [TODO] Comprar pan integral
     [3] [TODO] Preparar presentación
     --------------------------------
     ```
   - **Salida (Si no hay tareas TODO):** `ℹ️ No hay tareas pendientes.`

**4. `list-done`**
   - Muestra solo las tareas completadas (estado `DONE`).
   - **Uso:** `shell:> list-done`
   - **Salida (Ejemplo):**
     ```text
     --- Tareas Completadas (DONE) ---
     [2] [DONE] Subir código a GitHub
     ---------------------------------
     ```
   - **Salida (Si no hay tareas DONE):** `ℹ️ No hay tareas completadas.`



---

## 📌 Contribuir

¡Cualquier contribución es bienvenida! Si deseas mejorar este proyecto, sigue estos pasos:

1.  **Fork** el repositorio (`https://github.com/jscamposz/Task-Tracker.git`).
2.  Crea una **rama nueva** para tu funcionalidad (`git checkout -b feature/nueva-funcionalidad`).
3.  Realiza tus cambios y haz **commit** (`git commit -am "Añade nueva funcionalidad X"`).
4.  **Sube** tus cambios a tu fork (`git push origin feature/nueva-funcionalidad`).
5.  Abre un **Pull Request** en el repositorio original.

---

## 📜 Licencia

Este proyecto está bajo la licencia **MIT**. Puedes usarlo, modificarlo y distribuirlo libremente. 🎉
