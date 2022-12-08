FROM openjdk:11
VOLUME /tmp
ADD ./target/bootcoinpurchase-service-0.0.1-SNAPSHOT.jar bootcoinpurchase.jar
ENTRYPOINT ["java","-jar","bootcoinpurchase.jar"]