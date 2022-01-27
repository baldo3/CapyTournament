# 🏆 CapyTournament
Herramienta para jugadores amateur de MOBA que quieren organizar y participar en sus propios torneos.
Completada con estadísticas sobre partidos, jugadores y campeones.

## 🌎 Parte pública ##
- Ver los torneos existentes, equipos y jugadores participantes y resultados.
- Consultar las estadísticas de cualquier torneo, equippo, jugador o campeón (personaje).

## 🔒 Parte privada ##
JUGADOR:
- Crear un equipo o unirse a uno ya existente.
- Si es capitán, gestionar los jugadores de su equipo e inscribir su equipo a un torneo.

ADMINISTRADOR:
- Crear un torneo.
- Gestionar los resultados de los encuentros (equipo ganador y estadísticas)
- Modficar qué estadísticas son visibles para los usuarios.
- Si fuese necesario, expulsar equipos o jugadores concretos de un torneo.


## 📦 Entidades ##
- Torneo: almacena los diferentes partidos y equipos, así como el formato del torneo.
- Partido: almacena el juego, los campeones jugados, las estadísticas y los resultados del encuentro.
- Equipo: almacena los jugadores y las estadísticas propias del equipo.
- Jugador: pertenece a un equipo y tiene sus propias estadísticas personales. Puede ser capitán (uno por equipo).
- Campeón (Personaje): puede ser jugado por varios jugadores (máximo una vez por partido) y también tiene sus propias estadísticas.

## 🔧 Funcionalidades del servicio interno ##
- Envío de correos electrónicos a los participantes horas antes de sus partidos.
- Elaboración de las estadísticas en base a los datos almacenados en la BDD.

(- Gestión del sistema de login y control de usuarios)

