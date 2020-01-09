 echo %1
 bin/windows/kafka-topics.bat --create \
    --bootstrap-server localhost:9092 \
    --replication-factor 1 \
    --partitions 1 \
    --topic %1
