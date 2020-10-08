package br.com.next.dataexplorer.service;

import br.com.next.dataexplorer.modeldto.ModelDto;
import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sender {

    public static void main(String[] args) throws JsonProcessingException {

        final String connectionString = "Endpoint=sb://eh-next-audit.servicebus.windows.net/;" +
                "SharedAccessKeyName=RootManageSharedAccessKey;" +
                "SharedAccessKey=qzkguGHqjHrZ0MFPYimPm+oZp2RE+RGohPfB/6WCkiw=";
        final String eventHubName = "eh-next-audit";

        EventHubProducerClient producer = new EventHubClientBuilder()
                .connectionString(connectionString, eventHubName)
                .buildProducerClient();

        for (int i = 0; i <= 1000; i++) {

            final String dataModel = new ObjectMapper().writeValueAsString(new ModelDto(i, "Teste de dados " + i));

            // prepare a batch of events to send to the event hub
            EventDataBatch batch = producer.createBatch();
            batch.tryAdd(new EventData(dataModel));

            // send the batch of events to the event hub
            producer.send(batch);

        }

        producer.close();

    }
}
