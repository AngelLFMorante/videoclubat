#Videoclubat
Practica  CRUD con @RestController

Test unitarios con Junit5 Mockito

Control de mantenibilidad de codigo con SonarQube

Practica de un videoClub Cliente alquila peliculas

Lenguaje Java version 17, lambdas, streams y springboot version 3.1.5

Se irá actualizando el código para ver diferentes maneras de crear código, se incluirá mas adelante swagger.

## Para iniciar su funcionamiento:
    Requisitos: Java 17, Maven 3.9.5

    1.Hacemos un git clone del proyecto
    2.Si quieres utilizar otro puerto lo puedes definir en applications.properties si no el puerto por defecto: 8090
    3.El path base : http://localhost:8090/videoclub/v01/
    4.Utilizamos Postman o Insomnia para las peticiones Rest

Ejemplo de Curl de Insomnia:
`curl --request GET \
--url http://localhost:8090/videoclub/v01/clients`

###Datos de la base de datos

DDL: 