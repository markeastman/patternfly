# Windup example
This is a simple example of what we could do re the web interface for
windup. It is not meant to be the actual code but just an example.

The git repository is at https://github.com/markeastman/patternfly and should be public.

It is a maven project but uses springboot as the main framework - may get shot for that aspect!

can be built with mvn package
to build the jar file. and can then be run using
java -jar target/patternfly-1.0-SNAPSHOT.jar

Once running it will listen to port 28080 on localhost so you can browse to http://localhost:28080 and it will
show you a landing page that should have the login code. Just click through to app as I have not provided log in code as yet.

 The projects page will list two dummy projects and will have the menu down the left and some icons in the top right
 that would allow you to see notifications, such as background jobs being completed. These are just dummies for now and do nothing.
 
 Click the Allianz full project and you will get a list of componenets i have micked up for it. You can edit the project details by clicking the edit button in the panel banner.
 
 In the serach box you can type and the list will reduce based on searching all columns containing the text. You can also page through the list.
 
 You can sort the columns by clicking the headers.
 
 If a component has been analyzed then it will appear as a hyperlink - at the moment this just goes to a dummy page
 but I thought it would pull up the report in a new tab/window.
 
 The project has a file location attribute and at the moment it is intended to act as the server side location for the master applications. The users will be able to drop applications into this folder on the server,
 or they can upload files to the server using an upload dialog (not implemented yet)
 
 This example was just to really test the patternfly capabilities rather than the actual app.