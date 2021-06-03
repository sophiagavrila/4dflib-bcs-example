# Black Car Service / BCS
>*Please Note*: This repository was cloned from [Brian Gormanly's repository](https://github.com/briangormanly/4dflib-bcs-example) and converted to a Maven Project with slight modifications for demo purposes.

<h3>4DFLib example application!!!</h3>
This is an example application showing how you can use [4dflib](https://github.com/briangormanly/4dflib) to manage all your applications data over time and it is an ORM tool to boot, abstracting away your database so you can concentrate on the really important things, like coding the next app that will take over the world!

<h3>Instructions</h3>
<strong>prerequisites</strong>
<ul>
<li>Assumes MariaDB, PostgreSQL or MySQL 5.7 is running, and no root password is set (default).  If this is true, you may run, else see 'Database Settings' Below</li>
<li>Java 8 JRE is available</li>
<li>You have Git and Maven installed</li>
</ul>

<strong>Clone and Run!</strong>
clone this repository: git clone **my github thing**
run: mvn install (in project folder)

Congratulations!  Your done, the demo ran, created a database, built out tables and created some data.

<h3>Database Configuration</h3>
To configure database settings, setting the root password, changing to using PostgreSQL, or other database connection related details see this file: <br>
`4dflib-bcs-example/src/main/java/com/fdflib/example/BlackCarService.java`

<br>

Change the following as appropriate to your needs: <br>

Root username and password:
```Java
fdfSettings.DB_ROOT_USER = "root";
fdfSettings.DB_ROOT_PASSWORD = "";
```
<br>

PostgreSQL: (uncomment) and remove / comment out the MySQL ones
```Java
    // PostgreSQL settings
    fdfSettings.PERSISTENCE = DatabaseUtil.DatabaseType.POSTGRES;
    fdfSettings.DB_PROTOCOL = DatabaseUtil.DatabaseProtocol.JDBC_POSTGRES;
    
    // MariaDB settings
    //fdfSettings.PERSISTENCE = DatabaseUtil.DatabaseType.MARIADB;
    //fdfSettings.DB_PROTOCOL = DatabaseUtil.DatabaseProtocol.JDBC_MARIADB;
    
    // MySQL settings Version 5.7 only!!!!!!!! (no support for version 8)
    //fdfSettings.PERSISTENCE = DatabaseUtil.DatabaseType.MYSQL;
    //fdfSettings.DB_PROTOCOL = DatabaseUtil.DatabaseProtocol.JDBC_MYSQL;
    
    // Note that you will likely have to set the root password for postgreSQL as well
    fdfSettings.DB_ROOT_PASSWORD = "mycoolpasssword";
```

<h2>How it works...</h2>
If you go to MariaDB (or whatever database you used, for the purpose of brevity I will be showing Maria / MySQL commands here.) and issue:

```SQL
mysql> show databases
```

You should see that there is a new database, called 'blackcardemo' <br>
Now, if you view the tables, you will see that 4 tables were created..<br>

```SQL
mysql> use blackcardemo;
mysql> show tables;
+------------------------+
| Tables_in_blackcardemo |
+------------------------+
| Car                    |
| Driver                 |
| FdfSystem              |
| FdfTenant              |
+------------------------+
4 rows in set (0.00 sec)
```

Note that FdfSystem and FdfTenant are created by the 4DFLib, they are used to make your software natively multi-tenant and to manage Systems that will connect to your application and there access.

<br>

The other 2 tables, Car and Driver were created to persist data related to the 2 classes in the `com.fdflib.example.model` package and were created because we did the following in the `BlackCarService.java main()`:

```Java
// Create an array that will hold the classes that make up our 4df data model
List<Class> myModel = new ArrayList<>();

// Add our 2 classes
myModel.add(Driver.class);
myModel.add(Car.class);

...

// call the initialization of library!
FdfServices.initializeFdfDataModel(myModel);
```

# Why ORM?
The Object of an Object Relational Mapping Software is to make the database interactions as transparent to you so that you can program in an object oriented manner without having to worry abou the differences between the object-model and the relational database model.
