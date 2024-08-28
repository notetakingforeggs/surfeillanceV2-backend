# :surfer: Surfeillance-V2

Welcome to my rewriting of **Surfeillance**! During our group project Northcoders Java Bootcamp I took a role focussing primarily on the android frontend. This project is partly to give me a chance to write the backend, and also implement a slightly different featureset.
- The main thrust of this is to streamline my repeated browsing of a selection of surf forecasts across a few apps to give me the skinny as to whether there is feasible local surf near me on the horizon.
- I have made the intentional decision to not implement Auth - seeing this as something that can be added later if it starts getting use by others.
- I have chosen not to continue and the idea of logging trips, seeing this as a potential future feature. 

This project showcases various programming concepts and techniques including Test Driven Development (TDD), Object Oriented Programming (OOP), and Creating a REST-ful .

# 📚 Table of Contents
- 
  - [About the Project](#about-the-project)
  - [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
  - [Usage](#usage)
  - [Built With](#built-with)
  - [Acknowledgements](#acknowledgements)


## <a id="about-the-project"></a>🚀 About the Project
Surfeillance V-2 is a surf forecasting app, that takes weather data from public APIs and transforms it into a coherent forecast for surfing conditions at particular locations. The current MVP is to provide at a glance, when the soonest decent surf is within the prediction period for the users selected locations.

## <a id = "getting-started"></a> 🛠️ Getting Started

### Prerequisites

This program is currently set up only to run in an IDE on an android VM.
Before you begin, ensure you have the following installed on your machine:

- Java JDK 8 or higher
- Maven
- An IDE (preferably IntelliJ IDEA)
- postgres installed with nothing taking up the 2345 localhost port
- nothing already taking up the localhost 8080 port that spring 

### Installation

1. **Clone the repositories**
   
From this link: https://github.com/notetakingforeggs/surfeillanceV2-backend and https://github.com/notetakingforeggs/surfeillanceV2-frontend
   
2.  **Open the project in your preferred IDE**

Open the cloned repository in IntelliJ IDEA or any other code editor of your choice.

3.  **Build the project using Maven**

In IntelliJ IDEA, the project should automatically import Maven dependencies. 

## <a id = "usage"></a> 🎮 Usage


 
1. **Run the application**

    Some of the files in git-ignore you will need to add yourself. In the application.properties file please ensure you have the following
```
spring.application.name=surfeillanceV2-backend
spring.devtools.restart.enabled=true
#spring.sql.init.mode=always
spring.profiles.active=dev
spring.jpa.show-sql=true
```
The first time you run the backend, you will need to un-comment out the line "inti.mode=always" 

and in your application-dev.properties file the following:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/surfeillancev2
spring.datasource.driver=cdata.jdbc.postgresql.PostgreSQLDriver

spring.datasource.username= ** your username **
spring.datasource.password=s  ** your password **
spring.jpa.hibernate.ddl-auto=update

```
The first time you run the code you will need to set the last line in the above code block as ...hibernate.ddl-auto= *create*

This lets hibernate create the db and tables, and then use the data.sql file to populate the spots. If you want to select your own set of spots, you can edit the data.sql file for now. After having run the program once, change these back to how they were originally and run it again and that should work. To run the program:
   
   In IntelliJ IDEA,  right-click the `Main` class and select `Run 'Main'`.

2. **Check the terminal**

   The terminal interface/Run box will display the spring logo and log a bunch of API calls and hibernate/sql queries. Provided there are no errors this is your backend up and running on localhost 8080.

3.Run the front-end
// TODO

## <a id = "built-with"></a>  🛠️ Built With

- **Java** - The main programming language used.
- **J-Unit** - Testing Framework. 
- **Maven** - Dependency management.
- **IntelliJ IDEA** - Recommended IDE for running and testing the project.
  

## <a id = "acknowledgements" ></a> 🙏 Acknowledgements

- **Northcoders Bootcamp** - For the incredible training and support.
- **Various Cohort members** For Invaluable feedback and encouragement.
---

Feel free to explore the project, and happy coding! 🚀


