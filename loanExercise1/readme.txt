To run multiple instances of the service with different .yml.
- To build the fat jar, use:
	gradle capsule
	
- To clean
	gradle clean
	
- Default used the jmodern.yml file so just run:	
	java -jar build/libs/loancalc.jar server build/resources/main/loancalc.yml
	
- To run 2nd instance on a different port, run:
	java -jar build/libs/loancalc.jar server build/resources/main/loancalc2.yml
	
- Access the service by doing:
	http://localhost:9000/hello-world 
	
- To respond with a custom name
	http://localhost:9000/hello-world?name=YourFirst+YourLast