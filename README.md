## MathServices
Se crea la clase MathServices
```Java
public class MathServices {
    public static Integer square(Integer i){
        return i*i;
    }
}
```

Compilamos la clase MathServices.java

```bash
javac MathServices.java
```

Creamor el archivo .jar

```bash
jar cvf MathServices.jar MathServices.class
```

![jar.png](docs/images/jar.png)

Una vez creado nuestro Jar, vamos a AWS academy y lambda para crear la función lambda

![lambda_init.png](docs/images/lambda_init.png)

Indicamos nombre, runtime y execution role

![lambdaValues.png](docs/images/lambdaValues.png)

Cargamos nuestro Jar y le indicamos el nombre de la clase que queremos ejecutar

![upload.jar.png](docs/images/upload.jar.png)

El formato es [paquete].[servicio]::[metodo]

![invoke.png](docs/images/invoke.png)

Hacemos una prueba en **Test**

![test.png](docs/images/test.png)

## Configurar API gateway

Escogemos crear un API REST

![createAPI.png](docs/images/createAPI.png)

![Captura de pantalla 2026-10-21 a la(s) 6.31.57 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%206.31.57%E2%80%AFa.m..png)

Creamos los recursos con el metodo apuntando a la lambda

![Captura de pantalla 2026-10-21 a la(s) 6.35.00 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%206.35.00%E2%80%AFa.m..png)

En el method request agregamos un parametro value

![Captura de pantalla 2026-10-21 a la(s) 6.39.19 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%206.39.19%E2%80%AFa.m..png)

En integration request agregamos un Mapping Template, el cual contruye un mensaje que es entregado a lambda

![Captura de pantalla 2026-10-21 a la(s) 6.46.08 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%206.46.08%E2%80%AFa.m..png)

Hacemos la prueba ![Captura de pantalla 2026-10-21 a la(s) 6.47.11 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%206.47.11%E2%80%AFa.m..png)

Desplegamos la API

![Captura de pantalla 2026-10-21 a la(s) 6.50.02 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%206.50.02%E2%80%AFa.m..png)

Hacemos la prueba en el navegador

![Captura de pantalla 2026-10-21 a la(s) 6.53.05 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%206.53.05%E2%80%AFa.m..png)

## Security Utils

Creamos una clase SecurityUtils
```Java
public class SecurityUtils {
    public static User login(User u){
        IO.println("Username: " + u.getName());
        IO.println("Password: " + u.getPassword());
        u.setPassword("");
        return u;
    }
}
```

Empaquetamos el proyecto y convertimos a jar

```bash
javac -d out src/*.java
jar cf miapp.jar -C out .
```
Se sube la funcion en lambda como antes

![Captura de pantalla 2026-10-21 a la(s) 7.50.14 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%207.50.14%E2%80%AFa.m..png)

Exponemos el metodo en el API como hicimos antes

![Captura de pantalla 2026-10-21 a la(s) 7.58.27 a.m..png](docs/images/Captura%20de%20pantalla%202026-10-21%20a%20la%28s%29%207.58.27%E2%80%AFa.m..png)

## En caso de que quieras hacer pruebas