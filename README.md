# myretail

**Introduction**

Myretail is Rest API developed using Spring Boot. The API has GET and PUT methods for retrieving products and updating products current price.
The API retrieved Product Description from an external hosted API: https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics

**GET**: Rest API call to retrieve the Product information. The Product ID is sent as a parameter to the API which is used to rerieve the Product Description from the external hosted API.
**PUT**: Rest API call to update the Current Price for the given Product ID.

**Technology Stack**
* Spring Boot
* MongoDB
* Docker
* Docker Compose

**How to execute the application:**
Git clone the application as: git clone https://github.com/pavanganti/myretail.git

Option1: 
Running the app locally using IDE
Steps:
1. Install mongodb locally.
2. Once mongodb is installed locally connect to it and execute the command from initialize.js file under mongodb folder in sequence.
3. Open the IDE (Spring Tool Suite etc) and run the maven clean install.
4. In the IDE, run the app as Spring Boot.

Option2: 
Running the app as docker continers
Steps: 
* Assumption: The system in which this app is cloned has docker already installed with docker-compose.
* Assumption: The system in which this app is closed has access to download the docker images from docker hub. myretail image is uploaded to the docker hub.
1. Once the application is cloned to the folder, execute the command: ```docker-compose -f docker-compose.yml up -d mongodb```
2. Run the below command in a different window
3. Execute the command: ```docker-compose -f docker-compose.yml up -d myretail```

CURL commands:
The curlcommands.txt has the curl commands which can be executed from the terminal to view the data.


