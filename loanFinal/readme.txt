To run multiple instances of the service with different .yml.
- To build the fat jar, use:
	gradle -b build2.gradle shadowJar
	
- To clean
	gradle clean

- Default used the jmodern.yml file so just run:	
	java -jar build/libs/loancalc.jar server build/resources/main/loancalc.yml
	
- To run 2nd instance on a different port, run:
	java -jar build/libs/loancalc.jar server build/resources/main/loancalc1.yml
	
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

***** DEPLOYING TO HEROKU *****

1.) Create free Heroku account

2.) Download and install free Heroku command line tools

3.) Clean the project
	gradle clean

4.) Build using shadow plugin (you can find this build file in loanFinal)
	gradle -b build2.gradle shadowJar

5.) From command line, login to Heroku
	heroku login

6.) Install heroku deploy plugin
	heroku plugins:install https://github.com/heroku/heroku-deploy

7.) Create heroku app (be sure to see the app name)
	heroke create

8.) Deploy executable jar to heroku using app name from step 7
	heroku deploy:jar --jar build/libs/loancalc.jar --app <<app name from 7>> -i dwheroku.yml

