package producer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class AvroProducer {

	private final static String BOOTSTRAP_SERVERS = ":9092";

	private final static String TOPIC = "events2";
   // private final static String TOPIC = "events2";
	private final static String CLIENT_ID = "avro-test";

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, CLIENT_ID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		props.put("schema.registry.url","http://localhost:8081");

		AvroCompany comp = new AvroCompany();
		comp.setTradeNumber(222);
		comp.setRegisteredName("e-mag");
		final Producer<String , AvroCompany> producer = new KafkaProducer<>(props);
		try {
			final ProducerRecord<String, AvroCompany> data = new ProducerRecord<>(TOPIC, "1112", comp);
			try {
				RecordMetadata meta = producer.send(data).get();
				System.out.printf("lllllllllllllllll key=%s, value=%s => partition=%d, offset=%d\n", data.key(), data.value(),
						meta.partition(), meta.offset());
			} catch (InterruptedException | ExecutionException e) {
				System.out.printf("Exception %s\n", e.getMessage());
			}
		} finally {
			producer.flush();
			producer.close();
		}
	}
}
