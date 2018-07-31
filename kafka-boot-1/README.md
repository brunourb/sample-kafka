# Sample projects for Apache Kafka
## kafka-boot-1
### Quick start
* Start Kafka Broker at localhost:9092 and Zookeeper at localhost:2181
* Run application with mvn spring-boot:run
* Post a message with `curl -X POST http://localhost:8080/send -H content-type:text/plain --data "message_payload"`

The application will post and consume this message. See the log for details.  
