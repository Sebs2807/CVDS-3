Aca se pueden ver los directorios ya creados.
![alt text](image.png)

Compilamos el proyecto y pasa correctamente
![alt text](image-1.png)

Instalamos sonarqube con el comando
![alt text](image-2.png)

Iniciamos el servicio de SonarQube
![alt text](image-3.png)

Validamos el funcionamiento
![alt text](image-4.png)

Ejecutamos el contenedor de docker para sonarqube
![alt text](image-5.png)

Iniciamos sesión en sonar, clave y contraseña admin
![alt text](image-6.png)

Generamos un token
![alt text](image-7.png)

Probamos el test de agregar un libro, pero al no haber un codigo implementado, falla
![alt text](image-8.png)

Después de agregar codigo, el test pasa correctamente
![alt text](image-9.png)

Parte de docker y sonarqube
Una vez iniciada la sesión como admin en localhost:9000, generamos el token
![alt text](image-10.png)

Después de poner el comando dado para probar que todo haya quedado bien en sonar, arroja lo siguiente
![alt text](image-11.png)

En localhost:9000, evidenciamos que funcionó el proyecto, solo nos falta una prueba para lograr la cobertura que se espera
![alt text](image-12.png)