# Sistema de Gestión de Entregas por Consola en Java

Este ejercicio muestra una aplicación de **consola** en Java organizada en capas, que gestiona pedidos, repartidores y
entregas mediante menús numerados. Cubre herencia, polimorfismo, interfaces, hilos y validación de datos ingresados por teclado.

## 📋 Descripción

- Uso de una clase abstracta `Pedido` con tres subclases: `PedidoComida`, `PedidoEncomienda` y `PedidoExpress`.
- Implementación de interfaces (`Cancelable`, `Despachable`, `Rastreable`) según las capacidades de cada tipo de pedido.
- Sobreescritura de métodos (`mostrarResumen()`, `calcularTiempoEntrega()`) y sobrecarga de `asignarRepartidor()`.
- Uso de enumeraciones (`enum`) para el tipo y el estado del pedido.
- Almacenamiento de datos en memoria mediante `ArrayList` y consulta segura con `Collections.unmodifiableList()`.
- Simulación de repartos en segundo plano con hilos, implementando `Runnable` en la clase `Repartidor`.
- Menús numerados con `Scanner`, con formularios que se rellenan campo por campo.
- Validación de cada dato al momento de ingresarlo, repitiendo la pregunta hasta que sea válido.
- Operaciones CRUD (crear, listar, editar y eliminar) para pedidos, repartidores y entregas.
- Separación en capas: `model`, `services`, `view` y `util`.

## 🧩 Estructuras utilizadas

| Tipo | Sintaxis | Descripción |
|------|----------|-------------|
| Clase abstracta | `abstract class Pedido` | Define los datos y métodos comunes a todos los pedidos. |
| Herencia | `class PedidoComida extends Pedido` | Cada tipo de pedido especializa a la clase base. |
| Interfaces | `implements Cancelable, Rastreable` | Definen contratos que cumplen solo algunos tipos de pedido. |
| Enumeraciones | `enum EstadoPedido` / `enum TipoPedido` | Definen los valores fijos de estado y tipo de un pedido. |
| Sobreescritura | `@Override calcularTiempoEntrega()` | Cada pedido calcula su tiempo de entrega de forma distinta. |
| Sobrecarga | `asignarRepartidor()` / `asignarRepartidor(String)` | Mismo método con distintos parámetros. |
| Colección dinámica | `List<Pedido>` con `ArrayList` | Guarda los pedidos de todos los tipos en una sola lista. |
| Lista de solo lectura | `Collections.unmodifiableList(lista)` | Entrega la lista para consulta sin permitir modificarla desde fuera. |
| Hilos | `class Repartidor implements Runnable` | Cada reparto corre en segundo plano mientras el menú sigue disponible. |
| Atributo compartido entre hilos | `private volatile EstadoPedido estado` | Garantiza que el cambio de estado hecho por el hilo sea visible al menú. |
| Interfaz funcional | `Consumer<String> salida` | Permite decidir por dónde salen los mensajes del repartidor. |
| Lectura de datos | `Scanner` | Lee las opciones y los datos ingresados por teclado. |
| Validación | `String validarXxx(...)` | Devuelve el mensaje de error, o `null` si el dato es válido. |
| Expresiones regulares | `valor.matches("^\\d+([.,]\\d+)?$")` | Validan nombres y números. |
| Fecha y hora | `LocalDate` / `LocalTime` | Registran y validan la fecha y hora de cada entrega. |
| Menú con opciones | `do { ... } while (opcion != 0)` con `switch` | Repite el menú hasta que el usuario elige volver o salir. |

## 📂 Estructura del proyecto

```
proyecto/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── main/
│   │       │   └── Main.java                    # Punto de entrada: inicia el menú principal
│   │       ├── model/
│   │       │   ├── Pedido.java                  # Clase abstracta base
│   │       │   ├── PedidoComida.java            # Pedido de comida
│   │       │   ├── PedidoEncomienda.java        # Pedido de encomienda
│   │       │   ├── PedidoExpress.java           # Pedido express
│   │       │   ├── Repartidor.java              # Repartidor (Runnable)
│   │       │   ├── Entrega.java                 # Relación pedido - repartidor
│   │       │   ├── EstadoPedido.java            # Enum de estados
│   │       │   └── TipoPedido.java              # Enum de tipos
│   │       ├── interfaces/
│   │       │   ├── Cancelable.java              # Contrato para cancelar
│   │       │   ├── Despachable.java             # Contrato para despachar
│   │       │   └── Rastreable.java              # Contrato para ver historial
│   │       ├── services/
│   │       │   ├── ControladorPedidos.java      # Lógica de pedidos
│   │       │   ├── ControladorRepartidores.java # Lógica de repartidores
│   │       │   └── ControladorEntregas.java     # Lógica de entregas y envío
│   │       ├── util/
│   │       │   ├── Consola.java                 # Lectura por teclado e impresión de tablas
│   │       │   └── ValidadorDatos.java          # Validaciones de campos
│   │       └── view/
│   │           ├── MenuPrincipal.java           # Menú principal
│   │           ├── MenuPedidos.java             # Menú de pedidos
│   │           ├── MenuRepartidores.java        # Menú de repartidores
│   │           └── MenuEntregas.java            # Menú de entregas
│   └── test/
├── .gitignore
└── pom.xml
```

## 🏗️ Capas

| Capa | Responsabilidad |
|------|-----------------|
| `model` | Entidades del sistema y sus reglas propias (tiempos de entrega, mensajes, estados). |
| `interfaces` | Contratos que cumplen algunos tipos de pedido. |
| `services` | Lógica de negocio: crear, editar, eliminar y consultar. No imprime ni lee datos. |
| `util` | Herramientas de apoyo: lectura por consola y validaciones. |
| `view` | Menús de consola: muestran opciones, piden datos y llaman a los servicios. |

## ▶️ Funcionamiento

Al ejecutar el programa se muestra el menú principal y se trabaja con números:

1. **Menú principal:** permite entrar a Repartidores (1), Pedidos (2) o Entregas (3), o salir con 0.
2. **Repartidores:** se pueden listar, crear, editar y eliminar. No se elimina un repartidor con entregas en proceso.
3. **Pedidos:** se elige el tipo (Comida, Encomienda o Express) y se rellenan sus datos campo por campo. También se pueden listar, editar, eliminar y ver el detalle con el tiempo estimado de entrega.
4. **Entregas:** se asigna un pedido pendiente a un repartidor, y se puede listar, editar o eliminar mientras el pedido siga pendiente.
5. **Enviar pedidos:** el repartidor sale a ruta con todos sus pedidos pendientes, que pasan a `EN_REPARTO`.
6. Cada entrega se simula en segundo plano (entre 1 y 3 segundos) y los mensajes van apareciendo en consola.
7. Al terminar la ruta, los pedidos pasan a `ENTREGADO` y quedan congelados: ya no se pueden modificar.
8. Al editar, presionar **Enter** mantiene el valor actual del campo.
9. Si un dato es inválido, se muestra el error y se vuelve a pedir el mismo campo.

Este ejemplo permite visualizar de forma práctica una aplicación de consola por capas: la separación entre interfaz, lógica y modelo, el uso de herencia e interfaces para modelar distintos tipos de pedido, y la ejecución de tareas en segundo plano con hilos.
