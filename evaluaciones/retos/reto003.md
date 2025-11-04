# Reto 003

- Como siempre, desarrollar los retos únicamente con los conceptos de programación vistos en clase. Esto es, lo que ***[a día de hoy deberíamos saber](/temario/aDiaDeHoy.md)***.
- Los programas deben funcionar de modo **elegante**.
- Se evaluará **código limpio** y **entrega adecuada**.
- Reglas de entrega: las habituales de clase.

<img src="/images/edificio.png" align=right width=40% border=1>

## Un edificio

En la esquina de las calles *Agonía* con *Mortificación* hay un hotel con 8 plantas. En cada planta (a partir de la primera y hasta la séptima), hay 6 habitaciones. La planta baja tiene las áreas comunes, por lo que carece de ventanas: está la recepción al centro, al lado izquierdo se encuentra el comedor y al lado derecho se encuentra un salón de actos.

Cada habitación tiene persianas que cierran por completo la visibilidad de la habitación hacia el exterior. La probabilidad de encontrar la persiana abierta se ha estimado en 70% para cada hora.

Asimismo, cada habitación puede tener la luz encendida o apagada. Lo mismo, por cada hora la probabilidad de una luz encendida es del 60%. Esta es independiente de la persiana.

Desde el frontis del edificio se ven únicamente las ventanas. Y si la ventana está cerrada, se puede ver el estado del foco interior (encendido o no).

### Reto base

Simule una semana en la vida de este edificio. Muestre el mismo mediante texto [ASCII](https://es.wikipedia.org/wiki/ASCII)


#### Sugerencia de presentación

```
               __/\__
  |    |    |  |####|  |    |    |  
====================================
:[*]::[*]::[º]:[    ]:[ ]::[ ]::[º]: - P7
:[*]::[ ]::[ ]:[    ]:[º]::[*]::[*]: - P6
:[*]::[º]::[ ]:[    ]:[º]::[ ]::[ ]: - P5
:[*]::[*]::[ ]:[    ]:[*]::[º]::[º]: - P4
:[ ]::[º]::[*]:[    ]:[ ]::[*]::[*]: - P3
:[º]::[º]::[º]:[    ]:[º]::[ ]::[*]: - P2
:[º]::[*]::[º]:[    ]:[ ]::[*]::[º]: - P1
------------------------------------
     ==========================
   ==============================
 ==================================

Dia 1 - 1:00h 
```
<div align=center>

|Ventana cerrada|Luz apagada|Luz encendida|
|:-:|:-:|:-:|
`[ ]`|`[º]`|`[*]`

</div>

### Retos extendidos

#### Estadísticas

A la gerencia del edificio le interesa hacer un seguimiento del gasto de electricidad de sus clientes. Para esto, un indicador interesante puede ser el número de horas que las habitaciones tienen la luz encendida: brinde el dato a la gerencia, indicando por cada hora cuántas ventanas han tenido encendida la luz las habitaciones.

Asimismo, al final del día, indique el dato total consumido del día.

```
               __/\__
  |    |    |  |####|  |    |    |  
====================================
:[*]::[*]::[º]:[    ]:[ ]::[ ]::[º]: - P7
:[*]::[ ]::[ ]:[    ]:[º]::[*]::[*]: - P6
:[*]::[º]::[ ]:[    ]:[º]::[ ]::[ ]: - P5
:[*]::[*]::[ ]:[    ]:[*]::[º]::[º]: - P4
:[ ]::[º]::[*]:[    ]:[ ]::[*]::[*]: - P3
:[º]::[º]::[º]:[    ]:[º]::[ ]::[*]: - P2
:[º]::[*]::[º]:[    ]:[ ]::[*]::[º]: - P1
------------------------------------
     ==========================
   ==============================
 ==================================

Dia 4 - 1:00h Consumo hora: 22
CONSUMOS: D1: 612 | D2: 652 | D3: 604 
```

Al final de la simulación, presente un esquema general similar al siguiente:

```

CONSUMOS: D1: 612 | D2: 652 | D3: 604 | D4: 664 | D5: 626 | D6: 631 | D7: 613 | 

Media de consumo semanal: 628

```

#### Otras ocurrencias

|Lluvia|Mantenimiento|
|-|-|
Algunos días llueve. Y cuando llueve, puede caer un rayo en alguno de los seis pararayos que tiene el edificio sobre su azotea. Al caer el rayo, inutiliza la electricidad de toda la columna sobre la que cae, la cual permanece averiada lo que resta de ese día.|Algunos días, hay plantas que entran en mantenimiento.
La probabilidad (por hora) de caida de un rayo sobre una columna es del 20%. En un día, solo puede caer un rayo|Aunque todas las plantas requieren mantenimiento, la probabilidad diaria que llegue el departamento de mantenimiento es del 5%. Y, al igual que con los rayos, solo una planta entra en mantenimiento por día.

```
               __/\__
  |    |    |  |####|  |    |    |  
====================================
:[º]::[*]::[X]:[    ]:[º]::[*]::[º]: - P7
:[º]::[º]::[X]:[    ]:[ ]::[ ]::[º]: - P6
:[#]::[#]::[X]:[    ]:[#]::[#]::[#]: - P5
:[*]::[*]::[X]:[    ]:[*]::[*]::[ ]: - P4
:[º]::[ ]::[X]:[    ]:[ ]::[*]::[*]: - P3
:[º]::[ ]::[X]:[    ]:[ ]::[*]::[*]: - P2
:[*]::[ ]::[X]:[    ]:[*]::[º]::[*]: - P1
------------------------------------
     ==========================
   ==============================
 ==================================

Dia 2 - 8:00h Consumo hora: 28
Un rayo ha inutilizado la columna 3
5º planta en mantenimiento
CONSUMOS: D1: 611 | 

```

<div align=center>

|Ventana cerrada|Luz apagada|Luz encendida|Avería|Mantenimiento
|:-:|:-:|:-:|:-:|:-:|
`[ ]`|`[º]`|`[*]`|`[X]`|`[#]`

</div>
