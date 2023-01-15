# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine3.9
# copy the packaged jar file into our docker image
COPY target/classes/com/gildedrose/* /target/classes/
COPY src/test/java/com/gildedrose/* /src/test/java/classes/


CMD ["java","-cp","target/classes","com.gildedrose.GildRose"]

FROM jenkins/jenkins:latest
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

FROM jenkins/jenkins:lts-jdk11
RUN jenkins-plugin-cli --plugins pipeline-model-definition github-branch-source:1.8

FROM jenkins/jenkins:lts-jdk11
COPY --chown=jenkins:jenkins plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt

FROM jenkins/jenkins:latest
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli < /usr/share/jenkins/ref/plugins.txt
COPY casc.yaml /var/jenkins_home/casc.yaml
