# Examen Parcial - lDraco15

**Usuario GitHub:** lDraco15
**Fecha:** 4 de noviembre de 2025
**Retos tenidos en cuenta:** Reto 003

---

## Instrucciones

A continuación encontrarás fragmentos de código extraídos de tus entregas. Cada fragmento contiene una o más situaciones relacionadas con los conceptos vistos en clase.

Para cada pregunta debes:
1) Identificar a qué se refiere la observación
2) Explicar si es o no un error y por qué
3) Proponer la corrección

Nota: Responde 5 de las 10 preguntas (en función a lo indicado en el examen).


---

## Pregunta 1---

Archivo: `RetoEdificio.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/b0a9f229997b9d22b212e4f4df9767f93d4d9a0f/entregas/villedaAbner/src/RetoEdificio.java) (Reto 003)

```java
for (int hora = 0; hora <= 24; hora++) {
    System.out.println("dia: " + dia + " hora: " + hora);
}
```

¿Qué observas en este código?
En principio este bloque de codigo como esta planteado esta mal, si bien tenemos la variable hora, la variable dia no se encuentra por ningun lado, lo cual haria que el codigo direcatamente no funcione, ahora bien si establecemos la variable dia antes del for por ejemplo int dia=1, entonces ahora el ciclo for ahora si imprime el dia que sera siempre 1, y la hora que sera el momento en el que ciclo for vaya pasando el numero hasta llegar a 24, ahora bien como en el codigo original este ciclo for esta dentro de otro ciclo for que ahi si se toma en cuenta la variable dia, el codigo estaria trabajando primero en el dia 1 imprimiendo sus 24 horas, luego el dia 2 con sus 24 horas, y asi suseccivamente hasta que el ciclo for se detenga
---

## Pregunta 2---

Archivo: `RetoEdificio.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/b0a9f229997b9d22b212e4f4df9767f93d4d9a0f/entregas/villedaAbner/src/RetoEdificio.java) (Reto 003)

```java
final int PLANTAS = 8;
for (int columna = 1; columna <= 8; columna++) {
    for (int habitacion = 1; habitacion <= 6; habitacion++) {
        // ...
    }
}
```

¿Qué observas en este código?
Hay un error en el codigo original, La linea de codigo "final int PLANTAS = 8" es un grave error ya que la variable no se utiliza en cualquier momento, arruina la vision del codigo, por lo tanto hay que quitarla

---

## Pregunta 3---

Archivo: `RetoEdificio.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/b0a9f229997b9d22b212e4f4df9767f93d4d9a0f/entregas/villedaAbner/src/RetoEdificio.java) (Reto 003)

```java
if (!abierta) {
    System.out.print(VENTANA_CERRADA);
} else if (encendida) {
    System.out.print(LUZ_ENCENDIDA);
} else {
    System.out.print(LUZ_APAGADA);
}
```


¿Qué observas en este código?
En el siguiente codigo se puede observar una serie de if y elses, sobre una variable de tipo boolean llamada abierta, eso hara que cuando se ejecute el codigo, si la variable de tipo boolean es falsa entonces esta imprime la variable "VENTANA_CERRADA", si no entonces tendria que cumplir otra condicion que es si el boolean encendida es verdadera entonces imprimira entonces la variable "LUZ_ECENDIDA", entonces si encendida es falsa entonces imprimira la variable "LUZ_APAGADA", ahora bien, si bien esto es posible hacerlo el codigo se puede simplificar para ocupar menos lineas de codigo con un ternario, cambiaria algo como un if comprobando si el boolean de abierta entonces imprima la ventana abierta, luego para ahorrarse el else if entonces solo pondremos el y tirarmos la linea "System.out.print(encendida ? LUZ_ENCENDIDA : LUZ_APAGADA);" asi nos ahorramos el poner el else if, y el cosigo se ve mas limpio

---

## Pregunta 4--

Archivo: `RetoEdificio.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/b0a9f229997b9d22b212e4f4df9767f93d4d9a0f/entregas/villedaAbner/src/RetoEdificio.java) (Reto 003)

```java
final String VENTANA = ":[]:";
final String VENTANA_CERRADA = ":[-]:";
final String LUZ_APAGADA = ":[x]:";
final String LUZ_ENCENDIDA = ":[*]:";
```

¿Qué observas en este código?
Un grave error el cual es crear una variable final y no usarla en todo el codigo, en este caso final String VENTANA, la solucion es borrar la variable para que el codigo sea mas limpio

---

## Pregunta 5

Archivo: `RetoEdificio.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/b0a9f229997b9d22b212e4f4df9767f93d4d9a0f/entregas/villedaAbner/src/RetoEdificio.java) (Reto 003)

```java
System.out.println(BASE);
System.out.println(CALLE);
```

¿Qué observas en este código?

---

## Pregunta 6

Archivo: `Conversor.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/c4c754632c7dc5420e7bb9f2e363d57ad3a780a5/entregas/villedaAbner/src/Conversor.java) (Reto 001)

```java
int horas = (Tsegundos/3600) % 60;
int dias = (Tsegundos / 86400 ) % 24;
```

¿Qué observas en este código?

---

## Pregunta 7

Archivo: `Devolucion.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/c4c754632c7dc5420e7bb9f2e363d57ad3a780a5/entregas/villedaAbner/src/Devolucion.java) (Reto 001)

```java
int cambio = pago - deposito;
cambio *= (cambio < 0) ? -1 : 1;
```

¿Qué observas en este código?

---

## Pregunta 8

Archivo: `CalculadoraPrecio.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/c4c754632c7dc5420e7bb9f2e363d57ad3a780a5/entregas/villedaAbner/src/CalculadoraPrecio.java) (Reto 001)

```java
System.out.println("IVA : " + 100*(1-tipoIVA) + "%");
System.out.println("Descuento : " + 100*(1 - descuento) + "%");
```

¿Qué observas en este código?

---

## Pregunta 9

Archivo: `RetoEdificio.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/b0a9f229997b9d22b212e4f4df9767f93d4d9a0f/entregas/villedaAbner/src/RetoEdificio.java) (Reto 003)

```java
for (int columna = 1; columna <= 8; columna++) {
    for (int habitacion = 1; habitacion <= 6; habitacion++) {
        abierta = Math.random() < PROB_VENTANA_ABIERTA;
        encendida = Math.random() < PROB_LUZ_ENCENDIDA;
        if (!abierta) {
            System.out.print(VENTANA_CERRADA);
        } else if (encendida) {
            System.out.print(LUZ_ENCENDIDA);
        } else {
            System.out.print(LUZ_APAGADA);
        }
```

¿Qué observas en este código?

---

## Pregunta 10--

Archivo: `PeleaHeroe.java` — [Ver archivo](https://github.com/mmasias/25-26-PRG1/blob/095eeb1c6244261603f2a723b156679436a4a41b/entregas/villedaAbner/src/PeleaHeroe.java) (Reto 002)

```java
do {
    // ... código del combate ...
} while (!algunMuerto);
{
    String elGanador = vidaGuerrero <= 0 ? "El vampiro te ha vencido" : "Has Ganado!!!";

    System.out.println("\n--- BATALLA TERMINADA ---");
    System.out.println(elGanador);
    System.out.println("Vida de guerrero: [" + vidaGuerrero + "]");
    System.out.println("Vida de vampiro: [" + vidaVampiro + "]");
}
```

¿Qué observas en este código?
El codigo estaria bien escrito, solo hay un pequeño error donde dice batalla terminada, seria anular ese comando de "\n" ya que no aporta nada este o no este el codigo seguira igual, ademas de ponerle parentesis a la parte de vidaGuerrero para ser un poco mas ordenado


