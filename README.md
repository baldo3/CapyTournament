# CapyTournament
Herramienta para jugadores amateur de MOBA que quieren organizar y participar en sus propios torneos.
Completada con estadísticas sobre partidos, jugadores y campeones.

## Parte pública ##
Serán visibles los torneos, resultados de los encuentros, estadísticas de los torneos, equipos, jugadores y campeones (personajes).

## Parte privada ##
Gestión de cuentas de usuario, pudiendo registrarse como administrador y como jugador, permisos para crear y participar en torneos, y configuracion del perfil del usuario y del equipo. Un usuario de clase admin puede ser tambine jugador, y debe haber un capitan por equipo. Admins y capitanes tendran acceso a mas estadisticas y opciones que los jugadores.

## Entidades ##
- Torneo: almacena los diferentes partidos y equipos, así como el formato del torneo.
- Partido: almacena el juego, los campeones jugados, las estadísticas y los resultados del encuentro.
- Equipo: almacena los jugadores y las estadísticas propias del equipo.
- Jugador: pertenece a un equipo y tiene sus propias estadísticas personales. Puede ser capitán (uno por equipo).
- Campeón (Personaje): puede ser jugado por varios jugadores (máximo una vez por partido) y también tiene sus propias estadísticas.

## Funcionalidades del servicio interno ##
- Almacenamiento de las entidades de la base de datos
- Almacenamiento de los datos en bruto y elaboración de las estadísticas
- Gestión del sistema de login y control de usuarios
- Envío de correos electrónicos a los participantes horas antes de sus partidos.
