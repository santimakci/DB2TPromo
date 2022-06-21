# DB2TPromo

Trabajo de promoción para la matería Base de Datos 2 - UNLP

### Consigna

Definición trabajo Promición Bases de datos 2 - 2022

Para el trabajo de promoción se deberá:

- Montar un entorno utilizando Docker
- Configurar un motor de bases de datos postgres
- Configurar un motor NoSQL Mongodb (instalación básica)
- Importar el dataset de accidentes de tránsito en cada una de las bases de datos
- Implementar una aplicación utilizando la arquitectura de base presentada en la materia
- Implementar las siguientes consultas apuntando a cada una de las bases de datos según su conveniencia:
  - Devolver todos los accidentes ocurridos entre 2 fechas dadas
  - Determinar las condiciones más comunes en los accidentes (hora del día, condiciones climáticas, etc)
  - Dado un punto geográfico y un radio (expresado en kilómetros) devolver todos los accidentes ocurridos dentro del radio.
  - Devolver los 5 puntos más peligrosos (definiendo un determinado radio y utilizando los datos de los accidentes registrados)
  - Obtener la distancia promedio desde el inicio al fin del accidente

# Para levantar el proyecto

```
 docker-compose up
```

ó

```
make run
```

- Esto va a levantar dos base de datos una mongodb y una postgres. Además va a levantar un servidor en el puerto 8080.
- En la url principal se muestra un _Hello world!_ en caso de que se visualice esto significa que se levantó bien el proyecto
- Para probar que mongo esté funcionando se puede ejecutar una llamada POST al endpoint /api/users con un json con los campos
  de name, username y password
- En lo casos que se modifique código se debe ejecutar ` docker-compose build` para reconstruir el proyecto (averiguar si hay una forma mejor de ver los cambios hechos, algun hot reload)

# MongoDb

- Con el comando `make mongoshell` en una segunda ventana con docker corriendo podémos abrir una consola de mongo
