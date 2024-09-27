
# Laboratorio I-2024
## <sup>Asignatura: Patrones de Software y Programación </sup> <br><sup>Profesor: Daniel San Martín</sup> <br> <sup> Nombre Estudiante: Fernando Aranda</sup>
<hr>
Dado el enunciado a continuación, implemente el patrón de diseño que usted considere necesario
para dar solución al requerimiento. Además, explique porqué escogió el patrón, cual es su característica
donde se clasifica el patrón y porqué da solución a la problemática.
<hr>

# Enunciado

Una empresa de desarrollo de software ha sido contratada para implementar una 
solución que gestione el acceso a una biblioteca digital de recursos multimedia y sus
usuarios. La bilioteca incluye imágenes, vídeos y documentos donde algunos podrían encontrarse protegidos.

El sistema debe permitir buscar usuarios en distintas fuentes de datos. Además, se debe controlar 
el acceso a los archivos multimedia que están protegidos. Solo usuarios con los permisos adecuados deben 
poder abrir y visualizar los archivos protegidos.

Su tarea es diseñar una solución que permita lo siguiente:

 * Buscar un usuario en la base de datos, si este no existe, el sistema debe buscar 
en el archivo *externo.csv* de manera transparente. La clase *Util* contiene el método para 
buscar usuarios en archivos csv.
 * Controlar el acceso a los archivos protegidos para asegurar que solo usuarios con 
permisos válidos puedan visualizarlos. El sistema debe mostrar mensajes que indicando si existen 
los permisos o no, de acuerdo al archivo asignado por defecto.

## Guías

1. Utilize el paquete interfaz para implementar las interfaces que estime conveniente.
2. Puede modificar todo el código para lograr su propósito si estima conveniente. 

<hr>

## Explicación
1) Usuario no encontrado:

Para buscar el usuario de forma correcta, se debe implementar el patrón de diseño "Adapter", para así unificar la busqueda de usuarios 
en la base de datos y en el csv, utilizando la clase "Util.java" desde "cl.ucn.util" para buscar los usuarios en el csv, 
luego de crear los adaptadores ("BuscarUsuarioBaseDeDatos.java" y "BuscarUsuarioCsv.java" respectivamente) se debe crear una clase 
controladora que use ambas implementaciones ("BuscarUsuarioAdapter.java").

2) Controlar el acceso a archivos protegidos:

Utilizando el patrón de diseño "proxy" se debe crear una interface, haciendo que la clase "RecursosMultimedia.java" se implemente
de ella, teniendo la función de cargar() y mostrar() en común, luego se crea una clase de "RecursosMultimediaProxy.java" que implemente el 
interfaz proxy, así logrando controlar los accesos a los contenidos multimedias.

3) Modificar el main para implementar ambas modificaciones:

en la primera parte (Buscar usuario), primero se crean los adaptadores y luego el controlador, transfiriendo el buscador de base de datos que ya contiene
al buscador de usuarios en Csv ("BuscarUsuarioCsv.java") para reemplazarlo con los adapters anteriormente creados y poder buscar en la base de datos y
el csv. En la segunda parte (Controlar acceso) se debe crear el proxy para controlar el acceso a los archivos multimedia, utilizando RecursosProxy como constructor con el
recurso real y el usuario a verificar, utilizando las funciones cargar() y mostrar() cómo "puerta de verificación" entre el usuario y el recurso.
Finalmente, aunque no se especifica en el enunciado, se agrega la lista de usuarios creadas gracias al "Util.java" a la lista de usuarios creadas con la base de datos, 
logrando así que se impriman todos los usuarios en el listado de usuarios y permisos.
<hr>