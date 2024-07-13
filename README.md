Please follow the below steps to setup and run this project
1. Get the project code by following any of the below 3 ways:
   a. Using Git Commands (use this if you have Git Bash configured)
     - Copy the git repository url by click on the 'Code' button.
     - Open Git Bash in the local folder you want to copy/clone this project
     - Enter the command 'git clone https://github.com/SantyArer1996/FCHomeTest.git' and hit Enter.
     - Project code will be copied in the local folder
   b. Using Github Desktop (use this if you have Github Desktop installed in system)
     - Click on the '<Code>' button
     - Click on Open with Github Desktop
     - Provide the path in which you want to clone this repository and Click on Clone button
     - Project code will be cloned in the local folder
   c. Downloading the project as ZIP (use this if above two options are not feasible)
     - Click on the '<Code>' button
     - Click on Download ZIP
     - Extract the ZIP in your local folder
2. Open IDE such as Eclipse
3. Click on File > Import
4. Then select Maven > Existing Maven Projects > Click on Next
5. Click on Browse and Go to the folder where the projects pom.xml file is present.
6. Click on Finish
7. Once your import is completed successfully, Navigate to src/test/java > com.fc.runner package under project, then open RunnerTest.java file
8. Right Click in the Java file and Run As > JUnit Test or Click on Run icon from top menu.

Note: If JUnit gets terminated with blank output then we have to go to Run > Run Configurations > Select Test Runner as JUnit 4 for RunnerTest.
