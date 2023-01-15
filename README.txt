Command pour built Jenkin :

docker build -t jenkins:Java .
docker run --name jenkins --rm -p 8080:8080 jenkins:jcasc