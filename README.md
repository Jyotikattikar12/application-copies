# application-copies
Project to count the number of application copies
The project developer-code-test keeps the count on number of application copies The application has used Factory design pattern. "resources" folder already contains the sample-small.csv

ApplicationPurchaseFactoryTest.java contains the unit cases for the examples given in the "developer code test.pdf"

Command to build the application mvn clean install

Command to run the application java -jar target/developer-code-test-0.0.1-SNAPSHOT.jar

NOTE: Due to github upload size limit, could not upload sample-large.csv.Follow the following instructions to upload and test the same.

Upload the CSV at the src/main/resources
Uncomment the lines of code in CountApplicationPurchaseUtil.java for sample-large.csv.
mvn clean install
java -jar target/developer-code-test-0.0.1-SNAPSHOT.jar
