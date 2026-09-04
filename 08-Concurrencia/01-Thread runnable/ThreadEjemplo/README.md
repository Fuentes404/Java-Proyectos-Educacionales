
# Concurrencia en Java: Hilos (Threads) con `extends Thread`

Este ejercicio muestra el uso de la clase **`Thread`** de Java para ejecutar dos tareas **al mismo tiempo**
(no una después de otra), cubriendo el ciclo de vida de un hilo, la diferencia entre concurrencia y
ejecución secuencial, el uso de `start()` vs `run()`, pausas independientes con `sleep()`, manejo de
`InterruptedException`, y sincronización del hilo principal con `join()`.

## 📋 Descripción

- **Creación de hilos por herencia**: cada clase que extiende `Thread` *es* un hilo en sí misma (no *usa* un hilo, *es* uno). Java no permite herencia múltiple, así que si una clase ya extiende otra, se usaría `implements Runnable` en su lugar — pero ese es otro enfoque.
- **`run()` vs `start()`**, la distinción más importante de todo el ejercicio:
  - `run()` es solo un método normal. Si lo llamas directamente (`hilo.run()`), se ejecuta en el hilo actual, de forma **secuencial**, como cualquier otra llamada de método. No hay concurrencia.
  - `start()` le pide al sistema operativo que **cree un hilo nuevo real**, y ese hilo nuevo es quien ejecuta `run()`. Solo aquí aparece la concurrencia.
- **Ciclo de vida del hilo** (simplificado): `NEW` (objeto creado, sin `start()`) → `RUNNABLE` (corriendo o listo para correr) → `TIMED_WAITING` (mientras está en `sleep()`) → `TERMINATED` (cuando `run()` termina).
- **Independencia entre hilos**: `Thread.sleep(ms)` pausa **únicamente** el hilo que lo invoca. Los demás hilos del programa (incluido `main`) siguen corriendo sin verse afectados.
- **`InterruptedException`** es una excepción *checked* obligatoria al usar `sleep()`, porque otro hilo podría interrumpir la espera de este hilo en cualquier momento (por ejemplo, con `hilo.interrupt()`).
- **No determinismo**: el orden real de ejecución entre hilos lo decide el *scheduler* del sistema operativo, no el orden en que escribiste el código. Por eso la salida por consola puede variar entre una ejecución y otra — esto **no es un bug**, es la naturaleza de la concurrencia.
- **`join()`** es el mecanismo para que un hilo (por ejemplo `main`) espere a que otro hilo termine antes de continuar, sincronizando así el final de la ejecución concurrente.

## 🧩 Estructuras y conceptos utilizados

| Tipo | Sintaxis | Descripción |
|------|----------|-------------|
| Clase hilo por herencia | `class HiloX extends Thread` | Convierte la clase en un hilo ejecutable; sobreescribe `run()`. |
| Constructor con nombre | `super(nombre)` | Asigna un identificador al hilo, heredado de `Thread`, útil para depurar salidas concurrentes. |
| Método de ejecución | `run()` | Contiene la lógica que debe correr en paralelo. Por sí solo **no crea concurrencia**. |
| Lanzar el hilo | `hilo.start()` | Crea el hilo real del SO y dispara `run()` en paralelo. Solo puede llamarse **una vez** por hilo. |
| Identificar el hilo | `getName()` | Devuelve el nombre asignado, heredado de `Thread`. |
| Pausa aislada | `Thread.sleep(ms)` | Pausa solo el hilo que la invoca; simula trabajo o evita saturar la CPU. |
| Excepción de interrupción | `try/catch (InterruptedException e)` | Obligatoria: captura una posible interrupción externa durante `sleep()` o `join()`. |
| Esperar finalización | `hilo.join()` | Bloquea el hilo que lo llama hasta que el hilo indicado termine (pasa a `TERMINATED`). |
| Concurrencia vs paralelismo | — | Concurrencia: varias tareas *progresando* en el mismo intervalo de tiempo (intercaladas). Paralelismo: ejecutándose *literalmente* al mismo tiempo en núcleos distintos. Este ejemplo es concurrente y, si la máquina tiene múltiples núcleos, también paralelo. |
| Condición de carrera (mención) | — | No ocurre en este ejemplo porque los hilos no comparten datos mutables; si compartieran una variable sin sincronización, ahí sí aparecería una *race condition*. |

## 📂 Estructura del proyecto

```
proyecto/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── ui/
│   │       │   └── Main.java         # Clase principal: crea y lanza los hilos, espera su finalización
│   │       └── model/
│   │           ├── HiloPar.java      # Hilo que imprime los números pares (2 a 10)
│   │           └── HiloImpar.java    # Hilo que imprime los números impares (1 a 9)
│   └── test/
├── .gitignore
└── pom.xml
```

## ▶️ Funcionamiento

Al ejecutar el programa se realizan las siguientes acciones en orden:

1. Se crean los objetos `HiloPar` (`"Hilo-Pares"`) e `HiloImpar` (`"Hilo-Impares"`). En este punto **aún no existe concurrencia**, solo se instancian los objetos.
2. Se llama a `start()` sobre ambos hilos. A partir de aquí nacen los hilos reales del sistema operativo y cada uno ejecuta su `run()` en paralelo.
3. El hilo `HiloPar` recorre un bucle imprimiendo `2, 4, 6, 8, 10`, con una pausa de 400ms entre cada impresión mediante `Thread.sleep(400)`.
4. El hilo `HiloImpar` recorre en paralelo un bucle imprimiendo `1, 3, 5, 7, 9`, también con pausas de 400ms.
5. Como `start()` no bloquea, el hilo principal (`main`) continúa inmediatamente e imprime su propio mensaje, sin esperar a los hilos hijos.
6. `main` llama a `hiloPares.join()` y luego a `hiloImpares.join()`, quedando bloqueado hasta que **ambos** hilos hayan terminado su ejecución.
7. Cada hilo hijo, al completar su bucle, imprime un mensaje de finalización (`"... ha finalizado."`).
8. Finalmente, `main` imprime un mensaje de cierre, garantizando que se muestra **después** de que ambos hilos hayan terminado.

Este ejemplo permite visualizar de forma práctica el comportamiento de los hilos en Java: cómo `start()` habilita la concurrencia real, cómo cada hilo mantiene su propio ciclo de vida independiente (incluyendo sus pausas), y cómo `join()` permite sincronizar al hilo principal con la finalización de los hilos hijos, evitando que el programa continúe antes de tiempo.

> ⚠️ **Nota sobre el orden de salida:** debido a que los hilos corren de forma concurrente, el orden exacto en que se intercalan las impresiones de `Hilo-Pares` e `Hilo-Impares` **no está garantizado** y puede variar entre ejecuciones, dependiendo de cómo el *scheduler* del sistema operativo reparta el tiempo de CPU.
