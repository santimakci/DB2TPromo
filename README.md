# DB2TPromo

Trabajo de promoción para la matería Base de Datos 2 - UNLP

# Para levantar el proyecto

```
 docker-compose up
```

- Esto va a levantar dos base de datos una mongodb y una postgres. Además va a levantar un servidor en el puerto 8080.
- En la url principal se muestra un _Hello world!_ en caso de que se visualice esto significa que se levantó bien el proyecto
- Para probar que mongo esté funcionando se puede ejecutar una llamada POST al endpoint /api/users con un json con los campos
  de name, username y password
- En lo casos que se modifique código se debe ejecutar ` docker-compose build` para reconstruir el proyecto (averiguar si hay una forma mejor de ver los cambios hechos, algun hot reload)
