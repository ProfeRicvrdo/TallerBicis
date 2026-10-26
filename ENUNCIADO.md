# Taller de Bicicletas – JavaFX + MVC

Reciben el **modelo ya terminado** y la clase `App`/`Main`. Su trabajo es crear el **controlador** y la **vista (FXML)**.

## El modelo (ya hecho, no lo modifiquen)

```
            Bicicleta  (abstracta)
   codigo, marca, modelo, aro, color
   getTipo()  calcularCostoMantencion()
        /                         \
BicicletaTradicional        BicicletaElectrica
 cantidadCambios             potenciaMotorW
 tipoFreno                   capacidadBateriaWh
 tieneCanasto                calcularAutonomiaKm()
 revisarCambios()            diagnosticarBateria()
```

`Taller` es la clase gestora (como `Escuela`): agregar, eliminar, actualizar y obtener la lista.

## Lo que deben construir

### 1. Vista: `src/main/resources/GestionBicicletas.fxml` (con Scene Builder)
El nombre debe coincidir con `utils/Path.java`. Debe tener:
- Un `ComboBox` para elegir el **tipo** (Tradicional / Eléctrica).
- Campos comunes: código, marca, modelo, aro, color.
- Un **panel solo para tradicional**: cantidad de cambios (`TextField`), tipo de freno (`ComboBox`: Zapata, V-Brake, Disco), lleva canasto (`CheckBox`).
- Un **panel solo para eléctrica**: potencia del motor y batería (`TextField`).
- Botones: Guardar, Actualizar, Eliminar, Limpiar, **Revisar cambios**, **Diagnosticar batería**.
- Un `TableView` con columnas: código, tipo, marca, modelo, aro, costo de mantención.
- Un `Label` para mostrar mensajes de error.

> Pista: pongan cada grupo de campos específicos dentro de un `VBox` con `fx:id`. Así deshabilitan todo el grupo con una sola línea.

### 2. Controlador: `controller/GestionBicicletasController.java`

**Reglas de la interfaz (lo más importante):**

| Situación | Qué debe pasar |
|---|---|
| No hay tipo elegido | Ambos paneles desactivados y Guardar desactivado |
| Tipo = Tradicional | Solo se activa el panel tradicional |
| Tipo = Eléctrica | Solo se activa el panel eléctrico |
| Cambia el tipo | Se borran los campos del panel que se desactivó |
| Se selecciona una fila | El formulario se llena; el código y el tipo **no** se pueden editar; Guardar se desactiva; Actualizar y Eliminar se activan |
| Fila tradicional seleccionada | Solo "Revisar cambios" activo |
| Fila eléctrica seleccionada | Solo "Diagnosticar batería" activo |
| Datos inválidos | Mensaje en el `Label`, **sin** romper el programa |

**Pistas de JavaFX:**
- `nodo.setDisable(true/false)` desactiva un nodo y todos sus hijos.
- Para crear el objeto correcto: `if (tipo.equals("Tradicional")) new BicicletaTradicional(...) else new BicicletaElectrica(...)`.
- Para saber de qué clase es una fila: `if (b instanceof BicicletaTradicional t) { t.getCantidadCambios() ... }`.
- La columna de costo no es un atributo, es un método: no sirve `PropertyValueFactory`. Usen una lambda con `ReadOnlyStringWrapper`.
- `Integer.parseInt` lanza `NumberFormatException` si el texto no es un número: usen `try/catch`.
- ⚠️ `comboBox.setValue(...)` hecho **por código** NO dispara el `onAction` del combo; solo lo dispara el usuario. Si necesitan que se actualice el formulario, llamen ustedes al método.

## Pauta de evaluación sugerida

| Criterio | Puntos |
|---|---|
| FXML carga y se ve ordenado | 10 |
| Activa/desactiva paneles según tipo | 25 |
| Guardar crea el objeto del tipo correcto | 15 |
| Actualizar y Eliminar funcionan | 15 |
| Botones específicos según el tipo seleccionado | 15 |
| Validaciones (vacíos, números, código repetido) | 10 |
| Orden y comentarios del código | 10 |

## Desafíos extra
1. Agregar el tipo **"Cargo"** (nueva clase hija) y adaptar la interfaz.
2. Filtro en la tabla por tipo (todas / tradicionales / eléctricas).
3. Mostrar el total de costo de mantención de todo el taller.
