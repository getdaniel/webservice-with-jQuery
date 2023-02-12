# Consume RESTful Web Service

<p align="center">
  <img src="https://github.com/getdaniel/webservice-with-jQuery/blob/main/assets/icon.png" alt="Spring Tool Suit 4 IDE">
</p>

## Description 📽️:
Consume RESTful web service using jQuery based on Spring which is one of framework of java that is based eclipse. This project is a purpose for class project as of blueprint for consumming RESTful web service using jQuery based on ```Spring Framework```

## Usage 🏃‍♂️:

### Step :one::
Open your favorite Java IDE, in our case we use Spring Tool Suit 4. If you want to use other IDE, you may need additional configuration.

### Step :two::
Import the Project as Gradle project from the IDE.

### Step :three::
Run the Project as ```Run As``` > ```Spring Boot App```

### Step :four::
After successfully build with ```Step 3``` action, open your favorite browser and search ```http://localhost:8080/``` and press ```Enter```

### Step :five::
After this, you can use postman or the web browser to see the result. To use the web browser see ```Step 4```. To use the postman see below steps.
<p align="center">
  <img src="https://github.com/getdaniel/webservice-with-jQuery/blob/main/assets/postman.png" alt="Postman icon">
</p>

#### Step :one::
Run the Project as ```Run As``` > ```Spring Boot App```

### Step :two::
Open postman and go to the request page and follow the ```CRUD``` form to request the the server.

- To Create a user -> ```POST http://localhost:8080/api/user```
- To Read a user -> ```GET http://localhost:8080/api/user/{id-number}```
- To Read all user -> ```GET http://localhost:8080/api/user```
- To Update a user -> ```PUT http://localhost:8080/api/user/{id-number}```
- To Delete a user -> ```DELETE http://localhost:8080/api/user{id-number}```

## Overall View of the Project:computer::
<p align="center">
  <img src="https://github.com/getdaniel/webservice-with-jQuery/blob/main/assets/html-design.png" alt="The design of html page">
</p>

- Click [Here](https://getdaniel.github.io/webservice-with-jQuery/)(```Right click and press new tab, to open on new tab -> To keep the current tab.```) to see the overal documentation of the project

- ```src/main/java/com/ws/webservicewithjQuery/*.java``` is the file that the java part of the code is written.
- ```src/main/resources/static/*``` is the the folder that holds the markup files like ```html``` and ```js``` files.
- ```src/test/java/com/ws/webservicewithjQuery/WebserviceWithJQueryApplicationTests.java``` is a file that is used to test the java code functionality. Unfortunately, there is not test case coded. Sorry for that :sorry::sorry::sorry:
- The gradle part inicates the project is done by gradle-groovy not marvel.

## Developers :technologist::
- [Dagimawi Amare](https://github.com/)
- [Daniel Getaneh](https://github.com/getdaniel)
- [Dejen Aschalew](https://github.com/)
- [Desalegn Getachew](https://github.com/)
- [Mebratu Awoke](https://github.com/)
- [Minuyelet Entewew](https://github.com/Minuyelet)

## License:
You can use this project and modify as you wanted. You can see the [LICENSE](https://github.com/getdaniel/webservice-with-jQuery/blob/main/LICENSE).
