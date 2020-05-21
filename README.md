# Assignment101
  
  ## Step :
  ### Install and Run
  1. Installation of Java 8 or above
  2. Open terminal in Assignment101 folder
  3. Run mvnw clean package -B
  4. Run java -jar target/Assignment-0.0.1-SNAPSHOT.jar
  
  ### Test using Postman
  To upload a single file
  
  ```
  POST http://localhost:8080/single
  Content-Type : multipart/form-data
  Parameters :
    file : attach a txt file
  ````
  
