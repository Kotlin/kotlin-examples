# Kotlin Servlet Web Application Example With Maven

This example is a **maven** version of **servlet-web-applications** example built using gradle.

Since this example illustrates the use of a REST endpoint, you will need to run this on a web application server.

## Prerequisites to running the example

 * download Maven directly from the [Apache Maven homepage](http://maven.apache.org/download.html)
 * install and configure your system as described in [the installation section](http://maven.apache.org/download.html#Installation)

## Folder Structure

Sources

    /src/main/kotlin

Build/War File

    /target/kotlin-test-servlets.war
    
    
## Compiling/Building the example's war file

If you have maven on your path, type:

	mvn clean package
	
This will compile:
 * src/main/kotlin/HomeController.kt and builds a war file named **kotling-test-servlets.war** into **/target** folder


## Running the example's war file

Once you compiled the sources with previous 'mvn clean package' command, you can see the 'war' file under '/target' folder. 

Now copy the 'war' file and deploy to any web application server like Tomcat, Jetty etc.

After the deployment is done successfully, open a browser and point to a url like this
    
    http://localhost:8080/kotlin-test-servlets/hello
    
You should see an output as below:

    Hello, World!