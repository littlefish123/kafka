Kafka - SpringBoot (Send JSON message via Kafka Producer and Consumer)
======================================================================
Java 1.11

SpringBoot 2.2.4

1) d:\kafka2.4.0\zoostart.bat

bin/windows/zookeeper-server-start.bat ./config/zookeeper.properties

//Enable snapshot.trust.empty config if the ZK upgrade from 3.4.X to 3.5.6 is failing

//with "java.io.IOException: No snapshot found, but there are log entries" error.

change snapshot.trust.empty=true


2) d:\kafka2.4.0\kafka.bat

bin/windows/kafka-server-start.bat config/server.properties

3)  d:\kafka2.4.0\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic items-topic

4) run KafkaJSON by SpringApplication


5) d:\kafka2.4.0\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic items-topic
> {"id":1,"name":"Selina","category":"hello"}

OR

run KafkaJSONProducer by SpringApplication

Open google browser

Test with http://localhost:8080/producer/say/{"id":1,"name":"richard","category":"selina"}


Kafka Stream - WordCount
========================
Java 1.8

Kafka 2.4.0

Follow the Kafka stream demo from Kafka website and it definitely not work. Some ticky in order to get it work !

Follow below steps to start kafka:

1) d:\kafka2.4.0\zoostart.bat

bin/windows/zookeeper-server-start.bat ./config/zookeeper.properties

//Enable snapshot.trust.empty config if the ZK upgrade from 3.4.X to 3.5.6 is failing

//with "java.io.IOException: No snapshot found, but there are log entries" error.

change snapshot.trust.empty=true


2) d:\kafka2.4.0\kafka.bat

bin/windows/kafka-server-start.bat config/server.properties


3) create input topic by running d:\kafka2.4.0\startintopic.bat

bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-plaintext-input



4) create output topic by runnin d:\kafka2.4.0\startouttopic.bat

bin/windows/kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic streams-wordcount-output --config cleanup.policy=compact



5) Create Word Count Demo with maven project and compile to generate WordCount-0.0.1-SNAPSHOT.jar

https://github.com/apache/kafka/blob/2.4/streams/examples/src/main/java/org/apache/kafka/streams/examples/wordcount/WordCountDemo.java



6) copy d:\kafka2.4.0\bin\windows\kafka-run-class.bat to kafka-run-class-test.bat

add your test jar path into  kafka-run-class-test.bat

e.g.

rem Classpath addition for d:\kafka2.4.0

for %%i in ("d:\kafka2.4.0\test\WordCount*.jar") do (

	call :concat "%%i"
	
)

execute "	d:\kafka2.4.0\bin\windows\kafka-run-class-test.bat com.test.WordCountDemo


7) Start Console Producer

bin/windows/producer.bat


8) Start Console Consumer

bin/windows/consumer.bat


9) enter testing words into producer and you'll find word count generated from consumder


Reference

https://kafka.apache.org/24/documentation/streams/quickstart


Kafka Producer & Consumer
=========================
Java 1.11

Kafka 2.4.0

1) d:\kafka2.4.0\zoostart.bat

bin/windows/zookeeper-server-start.bat ./config/zookeeper.properties

2) d:\kafka2.4.0\kafka.bat

bin/windows/kafka-server-start.bat config/server.properties

Delete all d:\tmp and d:\kafka2.4.0\logs files before start.

3) bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 100 --topic demo

4) execute ProducerApp

5) execute Customer

