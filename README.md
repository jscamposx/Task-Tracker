# 📌 Task Tracker CLI

Task Tracker es una aplicación CLI diseñada para **rastrear y gestionar tareas** directamente desde la línea de comandos. 🚀 Con esta herramienta, puedes organizar eficientemente tus pendientes, lo que estás haciendo y tus logros.
Inspirado y basado en el proyecto sugerido en: [roadmap.sh/projects/task-tracker](https://roadmap.sh/projects/task-tracker)

---

## ✨ Funcionalidades Principales

✅ **Gestión de Tareas:**

- **➕ Agregar:** Añade nuevas tareas a tu lista.
- **✏️ Actualizar:** Modifica la descripción y/o el estado de una tarea existente.
- **🗑️ Eliminar:** Borra tareas que ya no necesites.
- **🚦 Marcar estado:** Cambia fácilmente el estado de una tarea entre **Pendiente (TODO)** y **Completada (DONE)**.
- **📄 Listar:** Muestra todas las tareas registradas.
- **✅ Filtrar completadas:** Visualiza únicamente las tareas finalizadas.
- **⏳ Filtrar pendientes:** Visualiza únicamente las tareas por hacer.

💾 **Persistencia de Datos:**

- Las tareas se almacenan en un **archivo JSON** (tasks.json por defecto, configurable), permitiendo que los datos se mantengan entre sesiones de la aplicación.

---

## 🛠️ Tecnologías Utilizadas

| Tecnología               | Descripción                                        |
| ------------------------ | -------------------------------------------------- |
| **Java ☕ (versión 21+)** | Lenguaje de programación principal                 |
| **Spring Boot 🚀**       | Framework para construir la aplicación             |
| **Spring Shell ⌨️**      | Para crear la interfaz de línea de comandos (CLI)  |
| **Maven 📦**             | Gestor de dependencias y construcción del proyecto |
| **Jackson ⚙️**           | Para serialización/deserialización JSON            |
| **Lombok 🧱**            | Para reducir código boilerplate (getters, etc.)    |

### 📌 Dependencias Clave (Maven)

1. **spring-boot-starter-shell**: Core de Spring Shell para la funcionalidad CLI.
2. **lombok**: Reduce código repetitivo (requiere configuración en el IDE).
3. **jackson-databind**: Para manejar la lectura/escritura del archivo JSON.
4. **spring-boot-devtools** (Opcional): Para reinicio automático durante el desarrollo.

---

## 📂 Estructura del Proyecto 

```
📦 task-tracker
├── 📁 .mvn/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/com/example/task/
│   │   │   ├── 📁 cli/        # Clases de comandos de Spring Shell (TaskCommands)
│   │   │   ├── 📁 config/     # Configuración (ej. ubicación del archivo JSON)
│   │   │   ├── 📁 exception/  # Excepciones personalizadas
│   │   │   ├── 📁 model/      # Clases del dominio (Task, Status)
│   │   │   ├── 📁 repository/ # Lógica de acceso a datos (lectura/escritura JSON)
│   │   │   ├── 📁 service/    # Lógica de negocio (TaskService)
│   │   │   └── 📁 util/       # Clases utilitarias
│   │   ├── 📁 resources/
│   │   │   └── application.properties
│   ├── 📁 test/
├── 📄 .gitignore
├── 📄 mvnw
├── 📄 mvnw.cmd
├── 📄 pom.xml      # Archivo de configuración de Maven
└── 📄 README.md
```

---

## 🚀 Cómo Ejecutar el Proyecto

### 🔹 Desde el código fuente

1. **Clonar el repositorio:**

```bash
git clone https://github.com/jscamposz/Task-Tracker.git
cd Task-Tracker
```

2. **Compilar el proyecto:**

```bash
mvn clean install
```

3. **Ejecutar la aplicación:**

```bash
mvn spring-boot:run
```

4. Una vez ejecutado, verás el prompt de Spring Shell (shell:>) listo para recibir comandos.

### 🔹 Desde el archivo JAR

Si ya tienes el JAR generado (`task-0.0.1-SNAPSHOT.jar`), puedes ejecutarlo directamente sin necesidad de Maven:

```bash
java -jar target/task-0.0.1-SNAPSHOT.jar
```

Esto iniciará la aplicación CLI y mostrará el prompt de Spring Shell para ejecutar comandos (debes tener configurada tu terminal para tener la experiencia completa o ejecutar desde el codigo fuente).

---

## ⌨️ Comandos CLI Disponibles

### Agregar una tarea:
```bash
shell:> add "Comprar pan integral"
✅ Tarea añadida correctamente: Comprar pan integral
```

### Listar todas las tareas:
```bash
shell:> list
--- Lista de Tareas ---
[1] [TODO] Comprar pan integral
[2] [DONE] Subir código a GitHub
[3] [TODO] Preparar presentación
-----------------------
```

### Listar tareas completadas:
```bash
shell:> list-done
--- Tareas Completadas (DONE) ---
[2] [DONE] Subir código a GitHub
---------------------------------
```

### Listar tareas pendientes:
```bash
shell:> list-todo
--- Tareas Pendientes (TODO) ---
[1] [TODO] Comprar pan integral
[3] [TODO] Preparar presentación
--------------------------------
```

### Eliminar una tarea:
```bash
shell:> delete 1
✅ Tarea eliminada correctamente con ID: 1
```

### Actualizar una tarea:
```bash
shell:> update 3 "Preparar reunión" "DONE"
✅ Tarea actualizada correctamente con ID: 3
```



## 📜 Licencia

Este proyecto está bajo la licencia **MIT**. Puedes usarlo, modificarlo y distribuirlo libremente. 🎉

