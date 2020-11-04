# HandsetSearch

How to run the project
Clone source code from git
$  git clone https://github.com/TrupteeGaud/HandsetSearch.git

Build Docker image
$  docker build -t="HandsetSearch" --force-rm=true .
This will first run maven build to create jar package and then build hello-world image using built jar package.

Note:if you run this command for first time it will take some time in order to download base image from DockerHub

Run Docker Container
$ docker run -p 8080:8080 -it --rm HandsetSearch
