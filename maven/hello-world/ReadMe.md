# Kotlin hello-world example with maven

## Prerequisites to running the example

 * download Maven directly from the [Apache Maven homepage](http://maven.apache.org/download.html)
 * install and configure your system as described in [the installation section](http://maven.apache.org/download.html#Installation)

## Compiling/Testing/Running the example

If you have maven on your path, simple type:

	mvn test
	
It will compile:
 * src/main/kotlin/Hello.kt into target/classes/hello/HelloKt.class
 * src/test/kotlin/HelloTest.kt into target/test-classes/hello/tests/HelloTest.class

Then run tests, and finally run your main HelloKt class.

## Only running the example

Once you compiled the sources with previous 'mvn test' command, you can run the application by typing:

	mvn exec:java
	
## Using commandline arguments

If you want to modify the main method in Hello.kt in order to use commandline arguments, you can specify them on commandline as:

	mvn exec:java -Dexec.args="argument1"
