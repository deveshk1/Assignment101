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
    
  Response :
    The response will have a link to a downloadable zip file containing the processed file
    
  ````
  
  To upload a multiple files
  ```
  POST http://localhost:8080/upload
  Content-Type : multipart/form-data
  Parameters :
    file[] : attach a few txt files
    
    
  Response :
    The response will have a link to a downloadable zip file containing the processed file
  ````
  
