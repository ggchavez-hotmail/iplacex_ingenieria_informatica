# Instalar y Configurar MQ

## Instalar JDK Oracle

### Oracle JDK 8

```
LOGIN REQUIRED. USE WEB BROWSER TO DOWNLOAD.
```

### Oracle JDK 8

```
sudo mkdir -p /usr/lib/jvm
sudo tar -zxvf jdk-8u221-linux-x64.tar.gz -C /usr/lib/jvm/
```

### Oracle JDK 8

```
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.8.0_221/bin/java 1
```

### Set default Java version

```
sudo update-alternatives --config java
sudo update-alternatives --set java /usr/lib/jvm/jdk1.8.X_version/bin/java
```

### Verify Java version

```
java -version
```

### Setup Environmental Variable

```
sudo nano /etc/profile

export PATH=$PATH:/usr/lib/jvm/jdk1.8.0_221/bin
export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_221/
export JRE_HOME=/usr/lib/jvm/jdk1.8.0_221/jre/
export J2SDKDIR=/usr/lib/jvm/jdk1.8.0_221/
export J2REDIR=/usr/lib/jvm/jdk1.8.0_221/jre/
```

## Incluir Puerto para salida maquina virtual

### Instalar UFW

```
sudo apt install ufw
```

### Habilitar puerto de MQ

```
sudo ufw allow 8161/tcp
```

### Habilitar UFW

```
sudo ufw enable
```

### Comprobar el estado y las reglas de UFW

```
sudo ufw status verbose
```

## Instalar Apache Active MQ

### Descargar versión 5.16.4, compatible con JDK Oracle 8, la version 5.17.0 da error.

```
cd /opt
sudo wget http://activemq.apache.org/path/tofile/apache-activemq-5.16.4-bin.tar.gz
tar zxvf apache-activemq-5.16.4-bin.tar.gz
cd apache-activemq-5.16.4
```

### Ejecutar MQ - desantendido

```
sudo ./bin/activemq start
```

### Detener MQ

```
sudo ./bin/activemq stop
```

### Observar proceso que ejecuta MQ, ver puerto 61616

ss -ltpn

### Ejecutar MQ - modo consola

```
sudo ./bin/activemq console
```

### Monitor web MQ (admin/admin)

```
http://localhost:8161
```

### Ver log de la consola MQ, desde Web ver en Feed RSS, desde consola ejecutar:

```
cat /opt/apache-activemq-5.16.4/data/activemq.log
```

## Instalar Configurar Apache Maven

### Bajar version e instalar

```
wget https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.tar.gz -P /tmp
sudo tar xf /tmp/apache-maven-\*.tar.gz -C /opt
sudo ln -s /opt/apache-maven-3.8.5 /opt/maven
```

### Crear archivo configuracion

```
sudo nano /etc/profile.d/maven.sh
```

```
#export JAVA_HOME=/usr/lib/jvm/jdk1.8.0_221 # ya creamos esta variable de entorno
export M2_HOME=/opt/maven
export MAVEN_HOME=/opt/maven
export PATH=${M2_HOME}/bin:${PATH}
```

### Hacer ejecutable archivo configuracion

```
sudo chmod +x /etc/profile.d/maven.sh

source /etc/profile.d/maven.sh
```

### Comprobar versión Maven

```
mvn -version
```
