# Reto colaborativo
## Repositorio creado por: Kevin Guerrero.
### Colaboradores:
Yuleidi Montero

Edwin Potosí

Kevin Guerrero (Mismo creador del repositorio)

### Opciones de organización:
Trabajo desarrollado mediante la utilización de una mezcla de las opciones A y B. Se hizo de esta manera porque se necesitaba asignar un trabajo específico a cada integrante para optimizar el tiempo. Para que las siguientes etapas funcionaran, era indispensable que el compañero anterior terminara su parte, evitando así códigos duplicados o conflictos innecesarios en Git. Además, dado que uno de los integrantes era nuevo en algunos conceptos, esta estrategia nos permitió explicarle la lógica paso a paso y de manera sencilla, sin saturarlo con demasiada información técnica en poco tiempo.

### Cómo se avanzó por la guía base y la extensión:

El creador del proyecto y repositorio configuró inicialmente las bases, tales como las importaciones de librerías y la estructura de archivos vacíos. Una vez clonado el repositorio por el resto del equipo, fuimos completando el contenido y programando juntos la lógica de Retrofit, los modelos de datos y los permisos de red

### Dificultades: 
hubieron pequeñas dificultades causadas por archivos como el .idea, se solucionó borrando este archivo.

Para solucionar esto, modificamos la parte del código donde la aplicación valida si la respuesta del servidor fue exitosa o no. Decidimos usar un Toast dentro del bloque donde el login falla. Así, en lugar de que el error solo quede oculto en la consola de la computadora el cual es el logcat, el usuario final puede ver inmediatamente un aviso en pantalla en su celular si se equivoca de contraseña, cumpliendo  la validación sin afectar el funcionamiento cuando los datos son correctos.