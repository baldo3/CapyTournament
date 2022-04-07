# 🏆 CapyTournament
Herramienta para jugadores amateur de MOBA que quieren organizar y participar en sus propios torneos.
Completada con estadísticas sobre partidos, jugadores y campeones.

# 🟢 FASE 1

## 🌎 Parte pública ##
- Ver los torneos existentes, equipos, jugadores participantes y campeones (personajes).

## 🔒 Parte privada ##
JUGADOR:
- Crear un equipo.
- Unirse a un equipo ya existente.
- Inscribirse a un torneo.

ADMINISTRADOR:
- Crear un torneo.
- Gestionar los resultados de los encuentros (equipo ganador y campeones utilizados)
- Crear o eliminar campeones.
- Si fuese necesario, expulsar equipos o jugadores del sistema.


## 📦 Entidades ##
- Torneo: almacena los diferentes partidos y equipos, así como el formato del torneo.
- Partido: almacena el juego, los campeones jugados, las estadísticas y los resultados del encuentro.
- Equipo: almacena los jugadores y las estadísticas propias del equipo.
- Jugador: pertenece a un equipo y tiene sus propias estadísticas personales. Puede ser capitán (uno por equipo).
- Campeón (Personaje): puede ser jugado por varios jugadores (máximo una vez por partido) y también tiene sus propias estadísticas.

## 🔧 Funcionalidades del servicio interno ##
- Envío de correos electrónicos a los nuevos jugadores registrados.
- Envío de correos electrónicos a todos los jugadores cuando su equipo gana un partido.


# 🟢 FASE 2
La aplicación implementa la navegación principal y hace uso completo de la base de datos.

## 💻 Capturas de pantalla ##
INICIO:
Página inicial de la aplicación, muestra una breve descripción sobre el objetivo del sistema y una imagen.

<img src="https://user-images.githubusercontent.com/59179104/154987491-1493dea1-34e4-4b17-b35c-c7630cddd2bb.png" width="800" height="400">


LISTA DE TORNEOS:
Accesible a través de la barra de navegación, muestra todos los torneos así como la opción (para administradores) de crear un nuevo torneo y la opción (para capitanes) de inscribirse a un torneo)

<img src="https://user-images.githubusercontent.com/59179104/154988967-95462997-9067-40b8-9e32-2794e76fcc5f.png" width="800" height="400">

TORNEO:
Muestra el nombre del torneo, una lista con los equipos que participan en el torneo, así como la puntuación de cada uno de ellos. En siguientes versiones, mostratá los resultados de los partidos del torneo.

<img src="https://user-images.githubusercontent.com/59179104/154990687-121b76d9-300c-426c-90f7-85f4d5f78184.png" width="800" height="400">

LISTA DE EQUIPOS:
Accesible a través de la barra de navegación, muestra todos los equipos así como las acciones principales sobre los equipos (unirse, eliminar, crear equipo...)

<img src="https://user-images.githubusercontent.com/59179104/154990224-52a66e67-b00d-45dd-a45b-3ca86faa7d9e.png" width="800" height="400">

EQUIPO:
Muestra el nombre del equipo, una lista con los jugadores que lo forman y el torneo actual (si están en alguno). En siguientes versiones, mostrará las estadísticas del equipo. También ofrece algunos botones para las acciones específicas sobre ese equipo.

<img src="https://user-images.githubusercontent.com/59179104/154990276-2d6554c4-ed97-4462-b644-a33826c0566e.png" width="800" height="400">

LISTA DE JUGADORES:
Accesible a través de la barra de navegación, muestra todos los jugadores así como la opción (si eres administrador) de banear a un jugador.

<img src="https://user-images.githubusercontent.com/59179104/154990370-2d30e008-d5d0-453d-aa61-b279a9176490.png" width="800" height="400">

JUGADOR:
Muestra el nombre del jugador y el equipo en el que está (si está en alguno). En siguientes versiones, mostrará las estadísticas del jugador.

<img src="https://user-images.githubusercontent.com/59179104/154990449-16388530-2d40-4ed1-9ebe-f790d2858156.png" width="800" height="400">

LISTA DE CAMPEONES:
Accesoble a través de la barra de navegación, muestra todos los campeones así como la opción (si eres administrador) de crear y eliminar campeones.

<img src="https://user-images.githubusercontent.com/59179104/154990504-4de415f7-980b-416c-b330-c8eadee609d4.png" width="800" height="400">

CAMPEÓN:
Muestra el nombre del campeón y, en versiones futuras, las estadísticas sobre los partidos en los que se ha utilizado el campeón.

<img src="https://user-images.githubusercontent.com/59179104/154990571-ed1fbf5f-9399-4372-b893-37894a933dcf.png" width="800" height="400">

## 📈 Diagrama de navegación ##

![DiagramaNavegacion](https://user-images.githubusercontent.com/59179104/154992610-690ccfdb-5461-4eba-a3e4-69dbaebc3388.png)

## 🧮 Modelo de datos ##
DIAGRAMA ENTIDAD/RELACIÓN:
![imagen](https://user-images.githubusercontent.com/46084814/155016773-23815a16-13da-4041-adb3-4ffe6094413e.png)


DIAGRAMA DE CLASES UML:
![imagen](https://user-images.githubusercontent.com/46084814/155016159-9accd158-5a18-4b55-9c9a-246b479de3c6.png)

# 🟢 FASE 3
Se ha añadido seguridad a la aplicación (protocolo HTTPS, varios niveles de permisos, sistema de login y logout y uso de tokens CRSF), así como comunicación con el servicio interno el cual envía correos a los jugadores cuando se registran y cuando ganan un partido.

## Diagrama de navegación ##
![DiagramaNavegacionDAD drawio](https://user-images.githubusercontent.com/59179104/162149011-6b339add-100e-494c-8ec5-65012c57feed.png)

## Diagrama de clases y templates ##
![DCFase3](https://user-images.githubusercontent.com/46084814/161747495-b0b45a1e-0b23-45b6-9bf9-1a27a104d954.jpg)

## Instrucciones de ejecución en máquina virtual ##
COMPILACIÓN:

Los siguientes pasos descritos son para realizar la compilación de los dos proyectos, tanto de la aplicación web como del servidor interno. Los pasos están descritos para un sistema Windows.

- Instalar el JDK de Java 17 o posterior 
- Instalar MySQL Server y a continuación crear una base de datos llamada "capytournament" con usuario "root" y contraseña "capyt"
- Descargar Maven y descomprimir la carpeta
- Crear (si no está creada ya) la variable de entorno JAVA_HOME y hacer que apunte al directorio raíz de JDK
- Hacer que la variable de entorno PATH apunte a la carpeta de Maven y a la carpeta bin del JDK
- Ejecutar la terminal de comandos y dirigirse hacia el directorio de la aplicación web (CapyTournamentSpring)
- Ejecutar **mvn clean package** si hay carpeta target en el proyecto, en el caso contrario ejecutar **mvn package**
- Realizar los dos pasos anteriores para el proyecto del Servicio Interno (ServicioInterno)
- Los ejecutables de ambas aplicaciones (.jar) se encontrarán en la carpeta target.

EJECUCIÓN EN MÁQUINA VIRTUAL:

Una vez compilados los dos proyectos, los siguientes pasos se deberán realizar desde una máquina virtual (los pasos están descritos con un SO Ubuntu 20).

- Instalar Java (JRE) 17 o superior ejecutando en la terminal de comandos: **sudo apt install openjdk-17-jre-headless**
- Instalar MySQL ejecutando los siguientes comandos en la terminal:
   - **sudo apt install mysql-server-8.0**
   - **sudo mysql**
  
  Con mysql abierto ejecutar:
   - **ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'capyt';**
   - **quit;**
 
 De nuevo en la terminal de comandos escribir:
   - **mysql -u root -p** Pedirá una contraseña, escribir "capyt"

 En mysql ejecutar:
   - **CREATE DATABASE capytournament;**
   - **CREATE USER 'root'@'localhost' IDENTIFIED BY 'capyt';**
   - GRANT ALL PRIVILEGES ON capytournament.* TO 'root'@'localhost';
   - **flush privileges;**
   - **quit;**
    
    
Por último:
- Obtener los dos ejecutables que se compilaron en la máquina local
- Ejecutar una terminal de comandos y dirigirse al directorio donde se encuentran los dos ejecutables
- Ejecutar el comando **sudo java -jar** seguido del nombre del ejecutable de la aplicación principal y después ejecutar el mismo comando con el nombre del ejecutable del servidor interno.

