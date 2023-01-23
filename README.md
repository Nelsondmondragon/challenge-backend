# CHALLENGE BACKEND - Java

API para explorar el mundo de Disney, la cual permitirá conocer y modificar los
characters que lo componen y entender en qué películas estos participaron. Por otro lado, deberá
exponer la información para que cualquier frontend pueda consumirla.

👉 Utilizar Spring Boot.

👉 Las rutas deberán seguir el patrón REST.

👉 Utilizar la librería Spring Security.


Requerimientos técnicos
1. Modelado de Base de Datos
   - Personaje: deberá tener,
   - Imagen.
   - Nombre.
   - Edad.
   - Peso.
   - Historia.
   - Películas o series asociadas.
   - Película o Serie: deberá tener,
   - Imagen.
   - Título.
   - Fecha de creación.
   - Calificación (del 1 al 5).
   - Personajes asociados.
   - Género: deberá tener,
   - Nombre.
   - Imagen.
   - Películas o series asociadas.

2. Autenticación de Usuarios
   
   Para realizar peticiones a los endpoints subsiguientes el usuario deberá contar con un token que
   obtendrá al autenticarse. Para ello, deberán desarrollarse los endpoints de registro y login, que
   permitan obtener el token.
   Los endpoints encargados de la autenticación deberán ser:
    - /auth/login
    - /auth/register
3. Listado de Personajes
   El listado deberá mostrar:
   - Imagen.
   - Nombre.
   El endpoint deberá ser:
   - /characters
   
   Creación, Edición y Eliminación de Personajes (CRUD)
   Deberán existir las operaciones básicas de creación, edición y eliminación de characters.
   
   ### Detalle de Personaje
   En el detalle deberán listarse todos los atributos del character, como así también sus películas o
   series relacionadas.
   ### Búsqueda de Personajes
   Deberá permitir buscar por nombre, y filtrar por edad, peso o películas/series en las que participó.
   Para especificar el término de búsqueda o filtros se deberán enviar como parámetros de query:
   - GET /characters?name=nombre
   - GET /characters?age=edad
   - GET /characters?movies=idMovie
   
4. Listado de Películas
   Deberá mostrar solamente los campos imagen, título y fecha de creación.
   El endpoint deberá ser:
   - GET /movies
   ### Detalle de Película / Serie con sus characters
   Devolverá todos los campos de la película o serie junto a los characters asociados a la misma
   ### Creación, Edición y Eliminación de Película / Serie
   Deberán existir las operaciones básicas de creación, edición y eliminación de películas o series.
   10.Búsqueda de Películas o Series
   Deberá permitir buscar por título, y filtrar por género. Además, permitir ordenar los resultados por
   fecha de creación de forma ascendiente o descendiente.
   El término de búsqueda, filtro u ordenación se deberán especificar como parámetros de query:
   - /movies?name=nombre
   - /movies?genre=idGenero
   - /movies?order=ASC | DESC
   
3. ### Envío de emails
    Al registrarse en el sitio, el usuario deberá recibir un email de bienvenida. Es recomendable, la
    utilización de algún servicio de terceros como SendGrid.
    Documentación
    Es deseable documentar los endpoints utilizando alguna herramienta como Postman o
    Swagger.
    Tests
    De forma opcional, se podrán agregar tests de los diferentes endpoints de la APP, verificando
    posibles escenarios de error:
- Campos faltantes o con un formato inválido en BODY de las peticiones
- Acceso a recursos inexistentes en endpoints de detalle
  Los tests pueden realizarse utilizando JUnit y Mockito.