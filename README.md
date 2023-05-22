# Advertisement Notification System

This module has the responsibility of sending any advertisement notification to the customer asynchronously. To achieve this
aim this solution was implemented adopting a websocket communication. In this way, any interested user can subscribes in 
a specific message destination to be notified of any new advertisement. Our primary goals here:

* Provide a fast advertisement notifications without change the user experience.
* High availability decoupling the send notification system from the producer advertisement event module



## Installation and Getting Started
* Install any JDK 11 or higher in your local environment. Once it is done, run the following command in your terminal 
to be sure the Java you picked up was set up properly.
```
$ javac --version
```
* Install the Docker containerization tool.
* Install the docker-compose (container manage tool) to set up the infrastructure need on starting up this application
* Once it is done, run the following commands to be sure everything is working fine
```
$ docker --version
```
```
$ docker-compose --version
```
* Clone this repository locally: https://github.com/viniciusfernandes/notification-system
* Run the following command under the project root folder to build the application runnable .jar file
```
$ ./gradlew build
```
* To start up this application, run these commands and keep this order:
```
$ docker-compose up
```
```
$ ./gradlew bootRun
```

## Getting Help
Are you having trouble on running this application? Send an email to viniciussf@hotmail.com and we reply to you as soon as we can



== Modules
There are several modules in Spring Boot. Here is a quick overview:



=== spring-boot
The main library providing features that support the other parts of Spring Boot. These include:

* The `SpringApplication` class, providing static convenience methods that can be used to write a stand-alone Spring Application.
  Its sole job is to create and refresh an appropriate Spring `ApplicationContext`.
* Embedded web applications with a choice of container (Tomcat, Jetty, or Undertow).
* First-class externalized configuration support.
* Convenience `ApplicationContext` initializers, including support for sensible logging defaults.



=== spring-boot-autoconfigure
Spring Boot can configure large parts of typical applications based on the content of their classpath.
A single `@EnableAutoConfiguration` annotation triggers auto-configuration of the Spring context.

Auto-configuration attempts to deduce which beans a user might need. For example, if `HSQLDB` is on the classpath, and the user has not configured any database connections, then they probably want an in-memory database to be defined.
Auto-configuration will always back away as the user starts to define their own beans.



=== spring-boot-starters
Starters are a set of convenient dependency descriptors that you can include in your application.
You get a one-stop shop for all the Spring and related technology you need without having to hunt through sample code and copy-paste loads of dependency descriptors.
For example, if you want to get started using Spring and JPA for database access, include the `spring-boot-starter-data-jpa` dependency in your project, and you are good to go.



=== spring-boot-actuator
Actuator endpoints let you monitor and interact with your application.
Spring Boot Actuator provides the infrastructure required for actuator endpoints.
It contains annotation support for actuator endpoints.
This module provides many endpoints, including the `HealthEndpoint`, `EnvironmentEndpoint`, `BeansEndpoint`, and many more.



=== spring-boot-actuator-autoconfigure
This provides auto-configuration for actuator endpoints based on the content of the classpath and a set of properties.
For instance, if Micrometer is on the classpath, it will auto-configure the `MetricsEndpoint`.
It contains configuration to expose endpoints over HTTP or JMX.
Just like Spring Boot AutoConfigure, this will back away as the user starts to define their own beans.



=== spring-boot-test
This module contains core items and annotations that can be helpful when testing your application.



=== spring-boot-test-autoconfigure
Like other Spring Boot auto-configuration modules, spring-boot-test-autoconfigure provides auto-configuration for tests based on the classpath.
It includes many annotations that can automatically configure a slice of your application that needs to be tested.



=== spring-boot-loader
Spring Boot Loader provides the secret sauce that allows you to build a single jar file that can be launched using `java -jar`.
Generally, you will not need to use `spring-boot-loader` directly but work with the link:spring-boot-project/spring-boot-tools/spring-boot-gradle-plugin[Gradle] or link:spring-boot-project/spring-boot-tools/spring-boot-maven-plugin[Maven] plugin instead.



=== spring-boot-devtools
The spring-boot-devtools module provides additional development-time features, such as automatic restarts, for a smoother application development experience.
Developer tools are automatically disabled when running a fully packaged application.



== Guides
The https://spring.io/[spring.io] site contains several guides that show how to use Spring Boot step-by-step:

* https://spring.io/guides/gs/spring-boot/[Building an Application with Spring Boot] is an introductory guide that shows you how to create an application, run it, and add some management services.
* https://spring.io/guides/gs/actuator-service/[Building a RESTful Web Service with Spring Boot Actuator] is a guide to creating a REST web service and also shows how the server can be configured.
* https://spring.io/guides/gs/convert-jar-to-war/[Converting a Spring Boot JAR Application to a WAR] shows you how to run applications in a web server as a WAR file.



== License
Spring Boot is Open Source software released under the https://www.apache.org/licenses/LICENSE-2.0.html[Apache 2.0 license].