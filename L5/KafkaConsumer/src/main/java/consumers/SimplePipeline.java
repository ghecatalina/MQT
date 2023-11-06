package consumers;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class SimplePipeline {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleExampleConsumer.class);

    private static final String OUR_BOOTSTRAP_SERVERS = ":9092";
    private static final String OFFSET_RESET = "earliest";
    private static final String OUR_CONSUMER_GROUP_ID = "group_1";
    private static final String sourceTopicName = "events2";
    private static final String destinationTopicName = "events1";

    private static final String CLIENT_ID = "fakeProducer";

    KafkaConsumer<String, String> kafkaConsumer;

    KafkaProducer<String, String> kafkaProducer;

    public SimplePipeline(Properties consumerPropsMap){
        kafkaConsumer = new KafkaConsumer<String, String>(consumerPropsMap);

        kafkaProducer = new KafkaProducer<String, String>(buildProducerPropsMap());
    }

    public static Properties buildConsumerPropsMap(){
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, OUR_BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, OUR_CONSUMER_GROUP_ID);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OFFSET_RESET);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        return props;
    }

    public static Properties buildProducerPropsMap() {
        Properties producerProps = new Properties();
		producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, OUR_BOOTSTRAP_SERVERS);
		producerProps.put(ProducerConfig.CLIENT_ID_CONFIG, CLIENT_ID);
		producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        return producerProps;
    }

    public void pollKafka(String kafkaTopicName){

        kafkaConsumer.subscribe(Collections.singleton(kafkaTopicName));
        //kafkaConsumer.subscribe(List.of(topicName, topicName2));

        Duration pollingTime = Duration.of(2, ChronoUnit.SECONDS);
        while (true){
            // get records from kafka
            //The poll method is a blocking method waiting for specified time in seconds.
            // If no records are available after the time period specified, the poll method returns an empty ConsumerRecords.
            ConsumerRecords<String, String> records = kafkaConsumer.poll(pollingTime);

            // consume the records
            records.forEach(crtRecord -> {
                LOG.info("------ Simple Example Consumer ------------- topic ={}  key = {}, value = {} => partition = {}, offset = {}",sourceTopicName, crtRecord.key(), crtRecord.value(), crtRecord.partition(), crtRecord.offset());

                String messageValue = crtRecord.value();
					if(messageValue.equals("v7")) {
						LOG.info("--------------  Value detected -----------  value = {}", crtRecord.value());
						send(destinationTopicName,7);
					}
            });
        }
    }

    public void send(String topic, int number) {
		ProducerRecord<String, String> data = new ProducerRecord<>(topic, "key" + number, "v"+number);
		try {
			RecordMetadata meta = kafkaProducer.send(data).get();
			System.out.println(String.format("----------------- Sending data -------------- key = %s, value = %s => partition = %d, offset= %d", data.key(), data.value(), meta.partition(), meta.offset()));
			//LOG.info("----------------- Example Producer -------------- key = {}, value = {} => partition = {}, offset= {}", data.key(), data.value(), meta.partition(), meta.offset());
		} catch (InterruptedException | ExecutionException e) {
			kafkaProducer.flush();
		}
	}

    public static void main(String[] args) {
        SimplePipeline consumer = new SimplePipeline(buildConsumerPropsMap());
        consumer.pollKafka(sourceTopicName);
    }
}
