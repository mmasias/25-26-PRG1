# Reto 001

- Este primer reto desarrollarlo únicamente con los conceptos de programación imperativa vistos en clase. Esto es, lo que ***[a día de hoy deberíamos saber](/temario/aDiaDeHoy.md)***.
- Los programas deben funcionar de modo **elegante**.
- Se valorará ampliamente **código limpio**.
- Reglas de entrega: como se explicó en clase.

## Problema 1 - Devolver cambio

El reto consiste en desarrollar en java un algoritmo que calcule el cambio a devolver

### Requisitos

- Los billetes/monedas que consideramos son de 100, 50, 20, 10, 5, 2 y 1
- El monto a pagar y lo que se entrega como pago son cantidades enteras.
- El monto entregado siempre es mayor que el monto a pagar.

### Presentación / Propuesta de interfaz

```terminal

java DevolverCambio

¿Cuántos euros debe pagar?
232

¿Con cuántos euros paga?
400

1 billete(s) de 100 €
1 billete(s) de 50 €
0 billete(s) de 20 €
1 billete(s) de 10 €
1 billete(s) de 5 €
1 moneda(s) de 2 €
1 moneda(s) de 1 €

```

## Problema 2 - Conversor de duración

### Requisitos

Desarrollar un algoritmo que convierta una duración expresada en segundos totales a formato días, horas, minutos y segundos.

**Consideraciones:**

- 1 día = 86400 segundos
- 1 hora = 3600 segundos  
- 1 minuto = 60 segundos
- Mostrar formato elegante usando singular/plural según corresponda

### Propuesta de interfaz

```terminal
java ConvertirDuracion
¿Cuántos segundos desea convertir?
123456

1 día(s)
10 hora(s)
17 minuto(s)
36 segundo(s)
```

**Mejora:** Mostrar "día" vs "días", "hora" vs "horas", etc.

```terminal
1 día
10 horas
17 minutos
36 segundos
```

## Problema 3 - Calculadora de precio final

### Requisitos

Desarrollar un algoritmo que calcule el precio final de un producto aplicando:

- IVA según categoría (general 21%, reducido 10%, superreducido 4%)
- Descuento si la cantidad supera cierto umbral

**Consideraciones:**

- Precio base e IVA se ingresan como enteros (representando céntimos)
- Si cantidad ≥ 10 unidades: 5% descuento
- Si cantidad ≥ 50 unidades: 10% descuento
- Si cantidad ≥ 100 unidades: 15% descuento
- Mostrar precio unitario final y total

### Propuesta de interfaz

```terminal
java CalcularPrecioFinal
Precio unitario base (céntimos):
1500
Cantidad de unidades:
75
Tipo de IVA (21, 10 o 4):
21

Precio base: 15.00 €
IVA aplicado: 21%
Descuento aplicado: 10%
Precio unitario final: 16.34 €
Precio total: 1225.50 €
```
