## How to run
 
### Open terminal and point to the github-screening folder and run below command
 
    mvn -U clean install
    
### Point to service-registry directory and  run below command,

   mvn spring-boot:run 
 
### Launch below URL in browser and observe eureka server home page
 
    http://localhost:8006
 
### Point to controller folder under github-screening and run below command

   mvn spring-boot:run 
   
   After couple of seconds, observe eureka server dashboard. Conroller service will be shown.
    
 
## Test application

 1) Launch swagger-url to test Palindrome
 
    http://localhost:8007/swagger-ui.html#/palindrome-controller
 
 2) Launch swagger-url to test Binary Reversal
    
    http://localhost:8007/swagger-ui.html#/binary-reversal-controller
    
 2) Used h2 db to test the functionality, following are the db details
 
    - Launch following url for h2 client, http://localhost:8007/h2-console/   and fill in below details,
    - Driver Class : org.h2.Driver
    - Jdbc Url :    jdbc:h2:mem:testdb
    - Username : sa
    - Password : password
    
    