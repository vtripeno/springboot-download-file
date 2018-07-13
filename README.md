#This Project is about download files using Spring Boot 

This project has just two routes, one for discovery all files in a folder inside the server and another one for return the required file from the server.

- Here has an example for call the route which will return all elements inside the folder:
```
localhost:8080/paths?type=Materials
```

- And this another one is the route responsible to return the file:
``` 
localhost:8080/file?type=Materials&file=CharM_Troll.uasset
```