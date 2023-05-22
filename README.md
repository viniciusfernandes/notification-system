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
Are you having trouble on running this application? Send an email to viniciussf@hotmail.com and we will reply to you as soon as we can

## About this Solution

### Scenario: Marketing and Data Mining  
There are many systems responsible to collect the customer interactions and their product preferences to process in order to 
decide what products are most likely to be offered to each customer according to their profile. Once all the data are ready to be sent to
the customers we need a new application just to manage this advertisement notifications.

This solutions has two module: 
* The first one is the advertisement-notification-producer, responsible to manage all 
the advertisements coming from the marketing department, stores that advertisements data to publish it in a message broker
using a scheduled task
* The second one in the notification-system, responsible to listening all the messages published in that message broker
and decide for what channel the customer must ne notified.



![Alt Text](./images/notification-system-diagram.jpg)
