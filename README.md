### A CRUD API Spingboot - MongoDB project

## Deploying to Render (quick guide)

1. Create a **Web Service** on Render and connect your Git repository.

2. In Render's service settings set the following Environment
	Variables (on the Render dashboard -> Environment -> Environment Variables):
	- `MONGODB_URI` : your full MongoDB connection string (mongodb+srv://...)
	- `MONGODB_DATABASE` : optional, e.g. `Task` (defaults to `Task`)
	- (Render provides `PORT` automatically; no need to set it)

3. Build & Start commands on Render:
	- **Build Command:** `./mvnw -DskipTests package`
	- **Start Command:** `java -jar target/springboot-mongo-atlas-0.0.1-SNAPSHOT.jar`

	Note: The generated JAR name uses the artifactId from `pom.xml`. If you change
	the `artifactId` or `version`, update the Start Command accordingly.

4. Health check / readiness: Render will hit the root URL. You can test
	`/actuator/health` if you enable the actuator endpoints.

5. Local testing examples:
	- Run with Maven on a specific port:
	  ```powershell
	  .\mvnw.cmd spring-boot:run -Dspring-boot.run.arguments="--server.port=8081"
	  ```
	- Run packaged JAR with a port and MongoDB URI override:
	  ```powershell
	  $env:MONGODB_URI = 'your-mongodb-uri'
	  java -Dserver.port=8081 -jar .\target\springboot-mongo-atlas-0.0.1-SNAPSHOT.jar
	  ```

Security note: Do NOT commit secrets (usernames/passwords) to the repo. Use
Render environment variables or Render's Managed Databases to keep credentials secret.
