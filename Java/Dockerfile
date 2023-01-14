# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:8-jre-alpine3.9
# copy the packaged jar file into our docker image
COPY target/classes/com/gildedrose/* /target/classes/
COPY src/test/java/com/gildedrose/* /src/test/java/classes/


CMD ["java","-cp","target/classes","com.gildedrose.GildRose"]