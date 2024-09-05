Aca se pueden ver los directorios ya creados.
![alt text](images/image.png)

Compilamos el proyecto y pasa correctamente
![alt text](images/image-1.png)

Instalamos sonarqube con el comando
![alt text](images/image-2.png)

Iniciamos el servicio de SonarQube
![alt text](images/image-3.png)

Validamos el funcionamiento
![alt text](images/image-4.png)

Ejecutamos el contenedor de docker para sonarqube
![alt text](images/image-5.png)

Iniciamos sesión en sonar, clave y contraseña admin
![alt text](images/image-6.png)

Generamos un token
![alt text](images/image-7.png)

Probamos el test de agregar un libro, pero al no haber un codigo implementado, falla
![alt text](images/image-8.png)

Después de agregar código, el test pasa correctamente
![alt text](images/image-9.png)

Parte de docker y sonarqube
Una vez iniciada la sesión como admin en localhost:9000, generamos el token
![alt text](images/image-10.png)

Después de poner el comando dado para probar que todo haya quedado bien en sonar, arroja lo siguiente
![alt text](images/image-11.png)

En localhost:9000, evidenciamos que funcionó el proyecto, solo nos falta una prueba para lograr la cobertura que se espera
![alt text](images/image-12.png)

Parte final
Con el plugin de jacoco, vemos que quedó por encima del 85%, por lo tanto se puede pasar el proyecto en sonar
![alt text](images/image-14.png)

Aquí podemos ver que la cobertura está sobre el 80% en sonar
![alt text](images/image-13.png)

Los 7 test que fueron necesarios para que se alcanzara el porcentaje deseado pasan
![alt text](images/image-15.png)

Compila la integración de sonar
![alt text](images/image-16.png)
