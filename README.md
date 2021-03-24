# String Processor
[![Java CI with Maven](https://github.com/marbimbo/string-processor/actions/workflows/maven.yml/badge.svg)](https://github.com/marbimbo/string-processor/actions/workflows/maven.yml)

## REST Service
java -jar rest-service-0.0.1-SNAPSHOT.jar

Spring parameter:

`server.port` default value `8080`

### Input file
Original text file with strings kept in resources:

[input.txt](/rest-service/src/main/resources/input.txt)

Gzipped file:

[input.txt.gz](/rest-service/src/main/resources/input.txt.gz)

### Persistence
H2 embedded database

## Console Application
java -jar console-application-0.0.1-SNAPSHOT.jar

Spring parameter:

`baseUrl` default value `http://localhost:8080`

usage:

`2021-03-24 13:47:56.250  INFO 21828 --- [           main] org.misio.ConsoleApplication             : Enter string:`

`string1`

`2021-03-24 13:52:38.285  INFO 21828 --- [           main] org.misio.ConsoleApplication             : StringIntegerPair{s='string1', value=-1881759168}`
