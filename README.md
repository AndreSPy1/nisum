# nisum
prueba nisum in java

## Nota
* Tener instalado y configurado el jdk 17 de java y maven.
* No es necesario generar un script de bd ya que se genera la base de datos, 
con hibernate mediante esta propiedad "spring.jpa.hibernate.ddl-auto=update".
* Si desea probar una expresion regular para la contraseña puede entrar
en el archivo de propiedades del proyecto y actualizar la propiedad con el 
nombre de "regex.pass".

## Pasos para probar api

### Generar build con Maven

1. mvn clean
2. mvn compile
3. mvn install

### Cargar proyecto de Spring

1. mvn spring-boot:run

### Prueba de api con autenticacion al registrar usuario.

En el proyecto contamos con dos endpoints, 
* POST localhost:8080/user acceso publico.
* GET localhost:8080/users acceso con JWT.

Para consumir /users, necesitamos registrar un usuario

ejemplo del cuerpo en solicitud...
    {
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.com",
    "password": "Tt0!sdfdsf",
    "phones": [
    {
    "number": "1234567",
    "citycode": "1",
    "contrycode": "57"
    },
    {
    "number": "1234567",
    "citycode": "1",
    "contrycode": "57"
    }
    ]
    }

al registrarnos nos devolvera un token en el cuerpo de respuesta,
el cual utilizaremos en el ancabezado de autorización para /users

al momento de probar la solicitud de /users, nos devolvera en el cuerpo
una lista de usuarios registrados con sus datos y token relacionado.

###NOTA