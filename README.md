# Quiz-App
An app that allows users to create quizzes, or answer already existing quizzes.
## Api-Gateway
Acts as an entry point for client requests and routes them to the appropriate microservices based on the requested endpoints.
<br>
## Quiz-Service
Connected directly to <b>Quiz</b> enitity (DB) directly to create quizes, gets questions of a certain quiz by communicating with <b>Question-Service</b>, and users can submit their answers and get their final score.
<br>
## Question-Service
Connected directly to <b>Questions</b> enitity (DB) directly to get all questions, create questions, gets questions of a certain category.

## Service-Registry
Starts a Eureka server that provides information such as the microservers' names, IP addresses, ports, and other metadata.
