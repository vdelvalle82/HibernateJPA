# HibernateJPA
Conexión Básica hibernateJPA con eclipse a MySQL

Software:

Eclipse-jee-2018-12
Conector mysql mysql-connector-java-5.1.49.jar
Jdk versión 1.8.0_261
Workspace en c:\workspace\hibernateJPA

Descargo e instalo Eclipse.
Creo una carpeta llamada conectores donde guarda el jar descomprimido de mysql.

Creo proyecto maven- quickstart.
Grupo ID: com.openwebinars.hibernate
Artifact id: PrimerProyectoHibernateJPA
version: 0.0.1-SNAPSHOT
Package: com.openwebinars.hibernate.primerproyectohibernatejpa

Añado la dependencia de hibernate en el archivo POM.xml
<dependency>
    	<groupId>org.hibernate</groupId>
    	<artifactId>hibernate-entitymanager</artifactId>
    	<version>5.2.9.Final</version>
</dependency>

A continuación me voy a la ventana de windows- preference -java compiler y selecciono 1.8, 
En installed JREs me instalo el jdk1.8.0_261, pulso appy and close.

Pulso botón derecho sobre JRE System Library – build path- configure build path y cambio a jdk1.8
copio la carpeta conectores dentro del proyecto y voy a botón derecho sobre el ratón- preference – ventana Libraries(java build path) como en la imagen de arriba y add jar, añado la el jar de mi carpeta conectores.

A continuación añadimos el JPA, para ello botón derecho sobre el nombre del proyecto – properties – project facets, marcamos JPA y en Runtimes seleccionamos jdk 1.8.0_261

pulsamos ahora Futher configuration required, 
seleccionamos en la plataforma: Hibernate(JPA 2.1)

JPA implementation type: 
Disable Library Configuration 
que desabilita la configuración de las librerías.
Pulsamos ok, apply y ok.

Ahora nuestro proyecto ya es un proyecto JPA, abrimos la perpectiva JPA.

Creo la clase User dentro de src/main/java y el paquete com.openwebinars...
package com.openwebinars.hibernate.primerproyectohibernatejpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name="USERS")
public class User {

	@Id
	private int id;
	
	@Column
	private String userName;
	
	@Column
	private String userMessage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	
	
}
Abrimos el fichero de persistencia persistence.xml que esta dentro de JPA Content.
Seleccionamos den la pestaña de Connection Transaction type: Resource Local, ahora picamos botón derecho sobre Database-new conection que es el punto 2, seleccionamos mysql (3) 

Pulsamos next

y ahora le tenemos que proporcionar un driver.
Picamos en el botón señalado.





Tenemos que añadirlo, así que entramos en cualquiera


ahora le doy a la pestaña JAR list , lo selecciono, pulso clear All y add JAR/zip









buscamos en C:\WORKSPACE\hibernateJPA\PrimerProyectoHibernateJPA\conectores
y lo selecciono.




pulsamos abrir y luego ok.

Damos a test connection y me da conectado con éxito.



Pulsamos next y finish.




Picamos en hibernate(1), picamos en  populate from conection, selectionamos my mysql, ok y se nos rellenan los datos.




Renombramos a hibernate en vez de new mysql


Rellenamos Database dialect (en la pestaña hibernate) pero para poder selecionar esta, tenemos que seleccionar primero mysql, luego en driver class: com.mysql.jdbc.Driver y luego seleccionamos otra vez MySQL 5 (InnoDB) que ahora si sale, antes no.





Añadimos en properties la siguientes propiedades:






Pulsamos el botón de guardar.




Ahora vamos a especificar que nuestra clase User es una entidad que será manejada por JPA.
En la pestaña general pulsamos añadir clase:

y la seleccionamos.

Marcamos el check de abajo, para que excluya aquellas clases que no esten listadas.
Pulso guardar.
Y ahora el error sobre la clase User ha desaparecido.





Relleno la clase App.java

package com.openwebinars.hibernate.primerproyectohibernatejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PrimerProyectoHibernateJPA");

		EntityManager em = emf.createEntityManager();

		User user = new User();
		user.setId(1);
		user.setUserName("Pepe");
		user.setUserMessage("Hello world JPA from Pepe");

		User user2 = new User();
		user2.setId(2);
		user2.setUserName("Juan");
		user2.setUserMessage("Hello world JPA from Juan");

		em.getTransaction().begin();
		em.persist(user);
		em.persist(user2);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}

y ahora pulso botón derecho, ejecutar como aplicación java.





Funciona!!!!
