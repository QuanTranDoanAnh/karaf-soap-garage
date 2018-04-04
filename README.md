# karaf-soap-garage
Create bundles to expose SOAP web services in Apache Karaf 4.1.5. Using JPA for data access and Blueprint XML as service dependency injection. 

# Reference
[Création d'un service SOAP et export en service OSGI] (https://olivier-rozier.developpez.com/tutoriels/soap/soap-karaf-multibundle/)

# Prerequisites
1. JDK 1.8
2. Maven 3
3. Apache Karaf 1.5

# How to try
1. Clone this repository to local
2. Run `mvn clean install` from the root project folder
3. Start Karaf
4. From Karaf, add feature repo by running `feature:repo-add mvn:vn.quantda.example.garageSoapWS/garageSoapWS-kar/1.0.0-SNAPSHOT/xml/features`.
5. Run `feature:install garageSoapWS-kar`
