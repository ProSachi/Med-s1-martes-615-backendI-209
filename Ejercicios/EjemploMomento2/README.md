# Refactorizacion Java - Herencia, Interfaces y Polimorfismo

Este proyecto implementa los entregables solicitados:

1. Clase abstracta `Usuario` con herencia en `Administrador` y `Cliente`.
2. Interfaz `IOperaciones<T>` con metodos `guardar`, `buscar` y `eliminar`.
3. Polimorfismo al tratar objetos derivados como `Usuario`.
4. Simulador de Frontend mediante menu de consola con `Scanner` para crear, listar, actualizar, buscar y eliminar.

## Estructura

- `src/model`: clases del dominio.
- `src/repository`: interfaces base.
- `src/service`: logica de gestion.
- `src/app`: punto de entrada con menu.

## Compilar y ejecutar (Windows / PowerShell)

```powershell
javac -d out src\model\*.java src\repository\*.java src\service\*.java src\app\App.java
java -cp out app.App
```
