# Evaluaci贸n 2 - Iplacex - Integraci贸n de Sistemas

_Se realiza 2 proyectos en Springboot Java que interactuan con cola ActiveMQ(Consumer/Producer), mediante Apache Camel._

_Adicionalmente desde el Producer se consume end-point Rest donde se rescatan los pedidos a enviar a MQ, tambi茅n se consume una BD en Mongo desde donde se rescatan el resto de parametros._

_El ActiveMQ esta configurado en modo de persistencia conectado a una BD Postgres._

## Comenzando 馃殌

_Estas instrucciones te permitir谩n obtener una copia del proyecto en funcionamiento en tu m谩quina local para prop贸sitos de desarrollo y pruebas._

### Pre-requisitos 馃搵

```
- npm/Node para levantar json-server
- JDK 1.8 para levantar el proyecto principal en Java
- docker/docker-compose para levantar las BDs Mongo, Postgres, el ActiveMQ
```

### Instalaci贸n 馃敡

_A continuaci贸n instalaci贸n de Json-Server_

_Paso 1: Luego de instalado Node ejecutar comando:_

```
npm install -g json-server
```

_Paso 2: Navegar hasta donde se encuentra \*.json, que se convertiran en Api Rest:_

```
cd Data
```

_Paso 3: Levantar servicios, verificar que se encuentra libre el puerto 3000-3001-3002-3003 (ejecutar un comando por terminal, ya que la soluci贸n debe quedar corriendo)_

```
json-server --watch db-rest-pedidos.json --port 3000 -d 100
json-server --watch db-rest-empresaA.json --port 3001 -d 100
json-server --watch db-rest-empresaB.json --port 3002 -d 100
json-server --watch db-rest-empresaC.json --port 3003 -d 100
```

_Paso 4: Configurar persistencia MQ, seg煤n IP_LOCAL (usar la ip de su maquina):_

```
cd docker-activemq-mongodb/activemq-volume/conf
nano db.properties
```

```
amq.db.host=IP_LOCAL
```

_Paso 5: Configurar proyecto java Consumer, seg煤n IP_LOCAL (usar la ip de su maquina):_

```
cd camel-consumer-a/src/main/resources
nano application.properties
```

```
spring.activemq.broker-url=tcp://IP_LOCAL:61616
```

_Paso 6: Configurar proyecto java Producer, seg煤n IP_LOCAL (usar la ip de su maquina):_

```
cd camel-producer-a/src/main/resources
nano application.properties
```

```
spring.activemq.broker-url=tcp://IP_LOCAL:61616
spring.data.mongodb.host=IP_LOCAL
```

_Paso 7: Levantar base datos mongo/postgres, activeMQ. Verificar que se encuentra libre los puertos 27017-61616-8161-5432-5050_

```
cd docker-activemq-mongodb/
docker-compose up -d
```

_Una vez realizado lo anterior se puede ejecutar los proyectos java desde Eclipse(preferentemente)_

## Ejecutando las pruebas 鈿欙笍

### Ejecuci贸n de proyecto Java - Producer 馃敥

![Alt text](./images/Imagen1.png "1")

### Api Rest donde se encuentran los pedidos de la aplicacion 鈱笍

![Alt text](./images/Imagen2.png "2")

### Revisi贸n de ActiMQ con los colas generadas 鈱笍

![Alt text](./images/Imagen3.png "3")

### Revisi贸n de ActiMQ detalle de mensaje 鈱笍

![Alt text](./images/Imagen4.png "4")

### Revisi贸n de Postgres los mensajes de ActiveMQ 鈱笍

![Alt text](./images/Imagen5.png "5")

### Revisi贸n de Mongo los parametros adicionales para completar mensajes 鈱笍

![Alt text](./images/Imagen6.png "6")

### Ejecuci贸n de proyecto Java - Consumer 馃敥

![Alt text](./images/Imagen7.png "7")

### Revisi贸n de ActiMQ los mensaje fueron consumidos 鈱笍

![Alt text](./images/Imagen7.1.png "7.1")

### Revisi贸n de Postgres los mensaje de ActiveMQ fueron actualizados 鈱笍

![Alt text](./images/Imagen8.png "8")

### Api Rest de Empresa A, donde se visualiza los mensaje ingresados 鈱笍

![Alt text](./images/Imagen9.png "9")

### Api Rest de Empresa B, donde se visualiza los mensaje ingresados 鈱笍

![Alt text](./images/Imagen10.png "10")

### Api Rest de Empresa C, donde se visualiza los mensaje ingresados 鈱笍

![Alt text](./images/Imagen11.png "11")

## Construido con 馃洜锔?

_las siguientes herramientas_

- JDK 8
- Springboot 2.6.6
- Apache Camel 3.14.2
- ActiveMQ 5.15.9
- MongoDB (Docker lastest)
- PostgreSQL (Docker lastest)
- Docker/Docker-compose
- [json-server](https://github.com/typicode/json-server) - Get a full fake REST API with zero coding in less than 30 seconds (seriously)

## Autor 鉁掞笍

- **Gustavo Chavez** - _Todas las tareas_ - [ggchavez-hotmail](https://github.com/ggchavez-hotmail/iplacex_ingenieria_informatica/tree/main/2_patrones_de_dise%C3%B1o/examen_final)
