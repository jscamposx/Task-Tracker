# 📌 Task Tracker

Task Tracker es una aplicación CLI diseñada para **rastrear y gestionar tareas** directamente desde la línea de comandos. 🚀 Con esta herramienta, puedes organizar eficientemente tus pendientes, lo que estás haciendo y tus logros.

Este proyecto es una excelente oportunidad para fortalecer tus habilidades de programación en **Java**, abarcando manipulación de archivos, procesamiento de entradas de usuario y desarrollo de aplicaciones CLI con **Spring Boot y Spring Shell**.
https://roadmap.sh/projects/task-tracker
---

## ✨ Funcionalidades Principales

✅ **Gestión de Tareas:**
- **➕ Agregar**, **✏️ actualizar** y **🗑️ eliminar** tareas.
- **🚦 Marcar estado:** Cambia entre **Pendiente (`TODO`)** y **Completada (`DONE`)**.
- **📄 Listar todas las tareas:** Vista general de tus pendientes y logros.
- **✅ Filtrar tareas completadas:** Muestra solo las que ya finalizaste.
- **⏳ Filtrar tareas pendientes:** Muestra solo las que aún están por hacer.

💾 **Persistencia de Datos:**
- Las tareas se almacenan en un **archivo JSON**, permitiendo que los datos se mantengan entre sesiones.

---

## 🛠 Tecnologías Utilizadas

| Tecnología | Descripción |
|------------|------------|
| **Java** ☕ (versión 21) | Lenguaje de programación principal |
| **Spring Boot** 🚀 | Framework para construir la aplicación |
| **Maven** 📦 | Gestor de dependencias |

### 📌 Dependencias Clave

1. **Spring Shell Starter (`spring-shell-starter`)** ⌨️
   - Permite crear una **interfaz CLI interactiva**.
   
2. **Lombok** 🧱
   - Reduce el código repetitivo al generar automáticamente **getters, setters, constructores y métodos comunes**.
   
3. **Jackson (`com.fasterxml.jackson.core`)** ⚙️
   - Facilita la **serialización y deserialización de JSON**.
   
4. **Spring Boot DevTools (`spring-boot-devtools`)** 🛠️
   - Proporciona **reinicio automático** en desarrollo para mejorar la productividad.

---

## 📂 Estructura del Proyecto

```
📦 task-tracker
├── 📂 cli          # Lógica de la interfaz de línea de comandos
├── 📂 exceptions   # Excepciones personalizadas de la aplicación
├── 📂 model        # Clases que representan los datos de la aplicación
├── 📂 repository   # Interfaces e implementaciones de persistencia
└── 📂 service      # Lógica de negocio de la aplicación
```

---

## 🚀 Cómo Ejecutar el Proyecto

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/jscamposz/Task-Tracker.git
   cd Task-Tracker
   ```
2. **Compilar y ejecutar con Maven:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
3. **Interacción con la CLI:**
   - Para agregar una tarea: `add "Nombre de la tarea"`
   - Para listar tareas: `list`
   - Para marcar una tarea como completada: `done ID`
   - Para eliminar una tarea: `delete ID`

---

## 📌 Contribuir

¡Cualquier contribución es bienvenida! Si deseas mejorar este proyecto, sigue estos pasos:

1. **Fork el repositorio**
2. **Crea una rama nueva (`git checkout -b feature-nueva`)**
3. **Realiza cambios y haz un commit (`git commit -m "Descripción del cambio"`)**
4. **Sube los cambios (`git push origin feature-nueva`)**
5. **Crea un Pull Request**

---

## 📜 Licencia

Este proyecto está bajo la licencia **MIT**. Puedes usarlo, modificarlo y distribuirlo libremente. 🎉

