# Heroes
A Superhero Project for ITCS431 Course (2019).

This is a back-end part of the **Heroes** project discussed in the ITCS431 Software Design and Development course Semester 2/2019. 

The project is implemented as a RESTful web service using Spring Boot framework. It allows the following APIs:


Function | Type | URL | Example
-------- | ---- | --- | ---
Add a hero | POST | http://localhost:8080/heroes | 
Get all heroes | GET |  http://localhost:8080/heroes | http://localhost:8080/heroes
Get a hero by ID | GET | http://localhost:8080/heroes/{id} | http://localhost:8080/heroes/1
Update a hero by ID | PUT | http://localhost:8080/heroes/{id} | 
Delete a hero by ID | DELETE | http://localhost:8080/heroes/{id} | http://localhost:8080/heroes/1
Delete all heroes | DELETE | http://localhost:8080/heroes 
