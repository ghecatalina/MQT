package consumers;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import producer.AvroCompany;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Properties;

public class AvroConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(AvroConsumer.class);

    private static final String OUR_BOOTSTRAP_SERVERS = ":9092";
    private static final String OFFSET_RESET = "earliest";
    private static final String OUR_CONSUMER_GROUP_ID = "group_1";
    private static final String topicName = "events2";
    private static final String topicName2 = "events1";

    KafkaConsumer<String, AvroCompany> kafkaConsumer;

    public AvroConsumer(Properties consumerPropsMap){
        kafkaConsumer = new KafkaConsumer<String, AvroCompany>(consumerPropsMap);
    }

    public static Properties buildConsumerPropsMap(){
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, OUR_BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, OUR_CONSUMER_GROUP_ID);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OFFSET_RESET);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        props.put("schema.registry.url","http://localhost:8081");

        return props;
    }

    public void pollKafka(String kafkaTopicName){

        kafkaConsumer.subscribe(Collections.singleton(kafkaTopicName));
        //kafkaConsumer.subscribe(List.of(topicName, topicName2));

        Duration pollingTime = Duration.of(2, ChronoUnit.SECONDS);
        while (true){
            // get records from kafka
            //The poll method is a blocking method waiting for specified time in seconds.
            // If no records are available after the time period specified, the poll method returns an empty ConsumerRecords.
            ConsumerRecords<String, AvroCompany> records = kafkaConsumer.poll(pollingTime);

            // consume the records
            records.forEach(crtRecord -> {
                LOG.info("------ Avro Consumer ------------- topic ={}  key = {}, value = {} => partition = {}, offset = {}",kafkaTopicName, crtRecord.key(), crtRecord.value(), crtRecord.partition(), crtRecord.offset());
            });
        }
    }

    public static void main(String[] args) {
        AvroConsumer consumer = new AvroConsumer(buildConsumerPropsMap());
        consumer.pollKafka("events2");
    }
}
