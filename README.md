# smart-dustbin
This file contains the information about only the code, for information on how to build hardware and circuit daigrams reffer to the document file of the project and reffer to research paper for findings.

 Code setup for web app -
 
 1. In order to run this application mysql and java is required to be installed in your machine.
 2. Use any IDE of choice to run the code (Intellij is preffered though :-P).
 3. Don't forget to change the username, password and you database name in application.properties file.
 4. In order to visit the home page go to your browser and type in the following address - localhost:8080/dustbin/home
 5. If hardware works fine the dustbin with id 1 in html page will be your dustbin, rest ids are mock dustbins.
 6. Web app can be tested independently by changing values in database.
 7. It gives alerts on filling , burn and decompositing waste statuses.
 
 Code setup for hardware -
 
 1. Use the hardware-code.ino file to burn to the nodemcu IC.
 2. Use a good hardware IDE like Arduino IDE.
 3. Don't forget to replace the IP address in the code with ip of your machine, which is running the web application.
 4. Also both nodemcu and machine running application should be connected to same wifi network.
