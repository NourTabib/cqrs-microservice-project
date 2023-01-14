# cqrs-microservice-project
SpringBoot Kafka CQRS Project

###### What is CQRS ?
CQRS stands for Command and Query Responsibility Segregation, a software development pattern that separates read and update operations for a data store. Implementing CQRS in your application can maximize its performance, scalability, and security.
###### What is Apache Kafka ?
Apache Kafka is a distributed data store optimized for ingesting and processing streaming data in real-time.
Streaming data is data that is continuously generated by thousands of data sources, which typically send the data records in simultaneously.
###### Architecture

![cqrs-project-diagram](https://user-images.githubusercontent.com/98242416/212493993-8e8cc1be-dff8-476f-a6de-1655fb038dfc.png)
The diagram above shows the architecture used to develop this microservice.Where the Command-service handles Mutation responsibility (Create,Update and delete operations), the Query-service handles the Query responsibility (Retrieve).

Each service is connected to it's own database, the Query-service is connected to a MongoDB (since it reads data fast),
the other service is connected to PostgreSQL database.

The two services mentionned above are connected via an Event bus , which is Apache Kafka topic.
The Command-service publish events to Kafka "user" topic ,on the other side the Query-service is subscribed to this topic and when events becomes available it convert the message to "User" object and update the Database

###### Configuration 
+ You need to have Java 17 installed
+ In order to prepare the developpement environment (Apache Kafka,MongoDB,Postgres), run the docker-compose up
+ Install the project dependencies
+ Run the Project  
