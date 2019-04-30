# jwtBackend

Start code for exercises, CA-3 and the Semester Project given at cphbusiness.dk - computer science

To start from this project, switch to the cloneReady branch after cloning <br />
OR<br/>
clone the branch directly: git clone -b fall_2018 --single-branch https://github.com/CK2800/CA3.git

The project contains two parts:<br />
1. A backend part written in Java containing a REST endpoint.<br /> 
2. A frontend part written in React. This part is found in the CA3/react-ui folder.

<B>Database</B><br />
To use this project you must create two database schemas, one for local development and one for local integration testing.

To run the backend locally, you must edit the XXpu.properties so it contains:
a: the name of your database schema used for development.
b: your user name and password for the MySql server.

You must also edit the XXpu_integration_test.properties files, so it contains:
a: the name of your database schema used for local integration tests.
b: your user name and password for the MySql server.

To use the react-ui, you must open the folder in VS code. 
If the project does not contain a 'Node_modules' folder, write in cmd:  npm install and npm install react-router-dom
To start the project, write in cmd: npm start
Make your changes to the project, to build it, write in cmd: npm run build
To install surge, write in cmd: npm install --global surge
After build, to host on surge, write in cmd: surge --project ./build --domain A_DOMAIN_NAME.surge.sh and fill out form.
