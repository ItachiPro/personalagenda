# personalagenda

Esta es una API desarrollada en Java utilizando los frameworks Spring boot e Hibernate.

# Tecnologías aplicadas.

- Java 8
- Spring boot
- Spring Rest
- Spring Security
- Spring Data
- MYSQL DATABASE
- JWT (Json Web Tokens)

# Requerimientos de instalación

- JDK 1.8
- Spring Tool Suite
- Postman
- Git

# Uso

- Crear un usuario con el siguiente JSON
- Enviar la petición de tipo POST a la ruta localhost:5000/api/user

```
{
    "username" : "usuario",
    "password" : "123456"   
}
```

- Iniciar sesión para obtener el token de acceso con la siguiente ruta localhost:5000/api/auth

```
{
    "username" : "usuario",
    "password" : "123456"   
}
```

- agregar un contacto POST: localhost:5000/api/contact

```
{
    "firstname" : "",
    "lastname" : "",
    "birthday" : "",
    "idContactType" : {
        "idContactType" : ""
    },
    "idUser" : {
        "idUser" : ""
    }
}
```

- Modificar contacto PUT:  localhost:5000/api/contact

```
{
    "idContact" : "",
    "firstname" : "",
    "lastname" : "",
    "birthday" : "",
    "idContactType" : {
        "idContactType" : ""
    },
    "idUser" : {
        "idUser" : ""
    }
}
```

- Obtener contactos GET: localhost:5000/api/contact

- Obtener 1 contacto GET: localhost:5000/api/contact/{id}

- La función de eliminar no esta implementada en las rutas con registros hijos.
