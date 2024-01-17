## Introduction 
This is Demo Rest API for [Tabletop session manager](https://github.com/JBryskiewicz/tt_session_manager) react app. 

## How to run locally?
This project requires to have SQL database to be installed. 
1. If you don't have SQL database, install it. This API is responsible to store and read data from database.
2. Download zip file of this project or fork it, then open it in your IDE. 
There your IDE should ask you to install all dependencies, install them.
3. Before you run the application make sure to connect this app with database. 
You can do that through ``application.properties`` file which must be created at following path:
``src/main/resources/application.properties``. This file has the following structure:
```
   // Ports in datasource.url & server.port are default
   // "Replace" fields are your credentials to locally hosted database
   
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.url=jdbc:mysql://localhost:3306/dms?serverTimezone=UTC
   spring.datasource.username=[REPLACE_USERNAME]
   spring.datasource.password=[REPLACE_PASSWORD]
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true
   server.port=8081
```

4. Run the application from your IDE, if you are using IntelliJ IDEA you can simply press ``Shift + F10``.
All tables and fields in your connected database will be automatically created. 