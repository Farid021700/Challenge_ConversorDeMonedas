# 💱 Conversor de Monedas en Java

Proyecto desarrollado como desafío final de la formación **Java Backend – Alura**.
El objetivo es consolidar los conocimientos adquiridos en Java básico, Programación Orientada a Objetos, consumo de APIs, manejo de errores y uso de colecciones.

---

## 🚀 Funcionalidades

* Conversión de monedas en tiempo real usando una **API de tasas de cambio**
* Menú interactivo en consola
* Soporte para las siguientes conversiones:

  * Dólar ⇄ Peso Argentino
  * Dólar ⇄ Real Brasileño
  * Dólar ⇄ Peso Colombiano
* Obtención dinámica de tasas de cambio
* Arquitectura clara y modular
* Manejo básico de errores

---

## 🛠️ Tecnologías utilizadas

* **Java 17+**
* **API ExchangeRate** ([https://www.exchangerate-api.com](https://www.exchangerate-api.com))
* **Gson** para el manejo de JSON
* **HTTP Client (java.net.http)**
* **Git & GitHub**

---

## 📂 Estructura del proyecto

```
conversor-moneda
│
├── src
│   └── lad.com.alura.conversormoneda
│       ├── ConversorApp.java
│       ├── Conversor.java
│       ├── CalculadoraConversion.java
│       └── Moneda.java
│
└── README.md
```

---

## ▶️ Cómo ejecutar el proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/conversor-moneda-java.git
```

2. Abre el proyecto en tu IDE (IntelliJ IDEA recomendado).

3. Regístrate en **ExchangeRate API** y obtén tu **API Key** gratuita.

4. En la clase `Conversor`, reemplaza:

```java
String apiKey = "TU_API_KEY";
```

por tu clave real.

5. Ejecuta la clase:

```java
ConversorApp.java
```

---

## 🖥️ Ejemplo de uso

```
Sea bienvenido/a al Conversor de Moneda =]

1) Dólar =>> Peso argentino
2) Peso argentino =>> Dólar
3) Dólar =>> Real brasileño
4) Real brasileño =>> Dólar
5) Dólar =>> Peso colombiano
6) Peso colombiano =>> Dólar
7) Salir

Elija una opción válida:
```

El usuario ingresa la opción, luego el valor a convertir y el programa muestra el resultado automáticamente.

---

## 📚 Aprendizajes reforzados

* Programación Orientada a Objetos (POO)
* Uso de `enum` para representar monedas
* Consumo de APIs REST en Java
* Manejo de JSON con Gson
* Separación de responsabilidades
* Flujo de control con `while` y `switch`

---

## 👤 Autor

**Farid España**
Proyecto desarrollado con fines educativos como parte del desafío de Alura.

---

¡Gracias por revisar este proyecto! 
