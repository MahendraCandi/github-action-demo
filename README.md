Since this app is required to pass the env var, please follow this maven verify on local machine.\
```mvn clean verify -DDB_URL=localhost -DDB_USER=user -DDB_PASSWORD=password```

### How to build docker image:
1. copy the project to WSL directory

```rsync -av --exclude '.git/' --exclude '.github/' --exclude '.idea/' --exclude 'target/'  /mnt/d/xxx/github-actions-demo/ /home/xxx/```
2. build the maven project

```mvn clean package -DskipTests```
3. build the docker image

```docker image build -t first-java-img:latest .```
4. run the docker image

```docker container run -d --name my-app -p 8080:8080 first-java-img:latest```
5. test the app

```curl -X GET http://localhost:8080/welcome```
6. test the app from local browser via accessing WSL IP address. open `windows powershell` terminal and type 

```wsl hostname -I```
7. open browser and type `http://<WSL_IP>:8080/welcome`