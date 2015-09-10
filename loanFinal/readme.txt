To run multiple instances of the service with different .yml.
- To build the fat jar, use:
	gradle capsule
	
- To clean
	gradle clean

- Default used the jmodern.yml file so just run:	
	java -jar build/libs/loancalc.jar server build/resources/main/loancalc.yml
	
- To run 2nd instance on a different port, run:
	java -jar build/libs/loancalc.jar server build/resources/main/loancalc.yml -Ddw.server.applicationConnectors[0].port=9090 -Ddw.server.adminConnectors[0].port=9091 
	
- Access the URL by doing:
	http://localhost:9000/loan //this returns calculation based on defaults of 15000, 3.0 and 60
	http://localhost:9000/loan?principle=10000&rate=2.5&term=48
	http://localhost:9000/loan?principle=30000&rate=2.99&term=60
	curl http://localhost:9000/loan
	curl http://localhost:9000/loan?principle=30000&rate=2.99&term=60
	
- To respond with a custom name
	http://localhost:9000/hello-world?name=YourFirst+YourLast
	
- To access the admin page in the browser
	http://localhost:9001/
	
- From the jetty directory, start jetty:
	java -jar start.jar
	
- Access the webapp from your browser
	http://localhost:8888/loan/loan.html

- Review loan.html
