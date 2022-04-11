# Evaluación 2 - Iplacex - Integración de Sistemas

_Se realiza 2 proyectos en Springboot Java que interactuan con cola ActiveMQ(Consumer/Producer), mediante Apache Camel._

_Adicionalmente desde el Producer se consume end-point Rest donde se rescatan los datos a enviar a MQ, también se consume una BD en Mongo desde donde se rescatan el resto de parametros._

_El ActiveMQ esta configurado en modo de persistencia conectado a una BD Postgres._

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

### Pre-requisitos 📋

```
- npm/Node para levantar json-server
- JDK 1.8 para levantar el proyecto principal en Java
- docker/docker-compose para levantar las BDs Mongo, Postgres, el ActiveMQ
```

### Instalación 🔧

_A continuación instalación de Json-Server_

_Paso 1: Luego de instalado Node ejecutar comando:_

```
npm install -g json-server
```

_Paso 2: Navegar hasta donde se encuentra db.json:_

```
cd Data
```

_Paso 3: Levantar servicios, verificar que se encuentra libre el puerto 3000-3001-3002-3003_

```
json-server --watch db-rest-pedidos.json --port 3000
json-server --watch db-rest-empresaA.json --port 3001
json-server --watch db-rest-empresaB.json --port 3002
json-server --watch db-rest-empresaC.json --port 3003
```

_Paso 4: Navegar hasta donde se encuentra db.json:_

```
cd docker-activemq-mongodb
```

_Paso 5: Configurar según IP_LOCAL, persistencia MQ:_

```
cd Data/conf
nano db.properties
```

```
amq.db.host=IP_LOCAL
```

_Paso 6: Configurar según IP_LOCAL, proyecto java Consumer:_

```
cd camel-consumer-a/src/main/resources
nano application.properties
```

```
spring.activemq.broker-url=tcp://IP_LOCAL:61616
```

_Paso 7: Configurar según IP_LOCAL, proyecto java Producer:_

```
cd camel-producer-a/src/main/resources
nano application.properties
```

```
spring.activemq.broker-url=tcp://IP_LOCAL:61616
spring.data.mongodb.host=IP_LOCAL
```

_Paso 8: Levantar base datos mongo/postgres, activeMQ. Verificar que se encuentra libre los puertos 27017-61616-8161-5432-5050_

```
docker-compose up -d
```

_Una vez realizado lo anterior se puede ejecutar el proyecto desde Eclipse(preferentemente)_

## Ejecutando las pruebas ⚙️

### Login 🔩

```
Ingreso usuario / password
```

![Alt text](./images/login.png "login")

```
Login correcto
```

![Alt text](./images/login-ok.png "login-ok")

### Navegar menú ⌨️

```
Menú inicial
```

![Alt text](./images/menu.png "menu")

### Elección opción ⌨️

```
Menú opción 1
```

![Alt text](./images/menu-opc1.png "menu1")

```
Menú opción 2
```

![Alt text](./images/menu-opc2.png "menu2")

```
Menú opción 3
```

![Alt text](./images/menu-opc3.png "menu3")

```
Menú opción 4
```

![Alt text](./images/menu-opc4.png "menu4")

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

- [JAX-RS 2.1](https://repo1.maven.org/maven2/org/glassfish/jersey/bundles/jaxrs-ri/2.35/jaxrs-ri-2.35.zip) - Eclipse Jersey is a REST framework
- [json-server](https://github.com/typicode/json-server) - Get a full fake REST API with zero coding in less than 30 seconds (seriously)

## Autor ✒️

- **Gustavo Chavez** - _Todas las tareas_ - [ggchavez-hotmail](https://github.com/ggchavez-hotmail/iplacex_ingenieria_informatica/tree/main/2_patrones_de_dise%C3%B1o/examen_final)
