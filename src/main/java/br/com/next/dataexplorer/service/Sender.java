package br.com.next.dataexplorer.service;

import br.com.next.dataexplorer.model.*;
import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class Sender {

    private final static String connectionString = "Endpoint=sb://eh-next-audit.servicebus.windows.net/;" +
            "SharedAccessKeyName=RootManageSharedAccessKey;" +
            "SharedAccessKey=qzkguGHqjHrZ0MFPYimPm+oZp2RE+RGohPfB/6WCkiw=";


    private static EventHubProducerClient createEventHubProducerClient(String eventHubName) {
        return new EventHubClientBuilder()
                .connectionString(connectionString, eventHubName)
                .buildProducerClient();
    }

    private static void sendResponseHeader(String auditId, EventDataBatch batch) throws JsonProcessingException {

        Map<String, String> header = new HashMap<>();
        header.put("key Res 1", "value 1");
        header.put("key Res 2", "value 2");
        header.put("key Res 3", "value 3");


        for (Map.Entry<String, String> entry : header.entrySet()) {

            AuditDataHeaderModel model = new AuditDataHeaderModel();
            model.setAuditID(auditId);
            model.setType("RESPONSE");
            model.setKey(entry.getKey());
            model.setValue(entry.getValue());

            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));

        }

    }

    private static void sendRequestHeader(String auditId, EventDataBatch batch) throws JsonProcessingException {

        Map<String, String> header = new HashMap<>();
        header.put("key Req 1", "value 1");
        header.put("key Req 2", "value 2");
        header.put("key Req 3", "value 3");

        for (Map.Entry<String, String> entry : header.entrySet()) {

            AuditDataHeaderModel model = new AuditDataHeaderModel();
            model.setAuditID(auditId);
            model.setType("REQUEST");
            model.setKey(entry.getKey());
            model.setValue(entry.getValue());

            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));

        }

    }

    private static void sendDataQuery(String auditId, EventDataBatch batch) throws JsonProcessingException {

        for (int i = 0; i < 11; i++) {
            AuditDataQueryModel model = new AuditDataQueryModel();
            model.setAuditID(auditId);
            model.setAddTime(1252l);
            model.setQuery("select * from teste where id = " + i);

            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));
        }

    }

    private static void sendDataMethod(String auditId, EventDataBatch batch) throws JsonProcessingException {

        for (int i = 0; i < 7; i++) {
            AuditDataMethodModel model = new AuditDataMethodModel();
            model.setAuditID(auditId);
            model.setArguments("[a, b, c, d]");
            model.setReturnValue("{valor de retorno}");
            model.setClassName("br.com.teste.Audit");
            model.setMethodName("nomeDoMethodo()");
            model.setError("---");
            model.setStartTime(525l);
            model.setEndTime(1254l);


            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));
        }

    }

    private static void sendDataCustom(String auditId, EventDataBatch batch) throws JsonProcessingException {

        for (int i = 0; i < 5; i++) {
            AuditDataCustomModel model = new AuditDataCustomModel();
            model.setAuditID(auditId);
            model.setName("teste custom");
            model.setCallerClass("br.com.Audit");
            model.setValue("value");
            model.setAddTime(100l);

            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));
        }



    }

    private static void sendDataFeign(String auditId, EventDataBatch batch) throws JsonProcessingException {

        for (int i = 0; i < 10; i++) {
            AuditDataDataFeignModel model = new AuditDataDataFeignModel();
            model.setAuditID(auditId);
            model.setRequestMethod("GET");
            model.setRequestURI("/v1/teste/teste");
            model.setQuery("teste");
            model.setRequestContent("content");
            model.setResponseHttpStatus("200");
            model.setResponseHttpStatusCode(200);
            model.setResponseContent("reponse contend");
            model.setResponseContentSize(100);
            model.setElapsedTime(255214l);
            model.setError("*********");

            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));
        }

    }

    private static void sendResponseHeaderFeign(String auditId, EventDataBatch batch) throws JsonProcessingException {

        Map<String, String> header = new HashMap<>();
        header.put("key Res 1", "value 1");
        header.put("key Res 2", "value 2");
        header.put("key Res 3", "value 3");


        for (Map.Entry<String, String> entry : header.entrySet()) {

            AuditDataHeaderModel model = new AuditDataHeaderModel();
            model.setAuditID(auditId);
            model.setType("RESPONSE");
            model.setKey(entry.getKey());
            model.setValue(entry.getValue());

            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));

        }

    }

    private static void sendRequestHeaderFeign(String auditId, EventDataBatch batch) throws JsonProcessingException {

        Map<String, String> header = new HashMap<>();
        header.put("key Req 1", "value 1");
        header.put("key Req 2", "value 2");
        header.put("key Req 3", "value 3");

        for (Map.Entry<String, String> entry : header.entrySet()) {

            AuditDataHeaderModel model = new AuditDataHeaderModel();
            model.setAuditID(auditId);
            model.setType("REQUEST");
            model.setKey(entry.getKey());
            model.setValue(entry.getValue());

            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));

        }

    }

    public static void senderAuditItem() throws JsonProcessingException {

        EventHubProducerClient producerData = createEventHubProducerClient("eh-next-audit-item");
        EventDataBatch batch = producerData.createBatch();

        EventHubProducerClient producerHeader = createEventHubProducerClient("eh-next-audit-data-header");
        EventDataBatch batchHeader = producerHeader.createBatch();

        EventHubProducerClient producerQuery = createEventHubProducerClient("eh-next-audit-data-query");
        EventDataBatch batchQuery = producerHeader.createBatch();

        EventHubProducerClient producerMethod = createEventHubProducerClient("eh-next-audit-data-method");
        EventDataBatch batchMethod = producerHeader.createBatch();

        EventHubProducerClient producerCustom = createEventHubProducerClient("eh-next-audit-data-custom");
        EventDataBatch batchCustom = producerHeader.createBatch();

        EventHubProducerClient producerFeign = createEventHubProducerClient("eh-next-audit-data-feign");
        EventDataBatch batchFeign = producerHeader.createBatch();

        EventHubProducerClient producerHeaderFeign = createEventHubProducerClient("eh-next-audit-data-feign-header");
        EventDataBatch batchHeaderFeign = producerHeader.createBatch();

        for (int i = 300; i <= 500; i++) {

            final String auditId = String.valueOf(i);

            AuditDataModel model = new AuditDataModel();
            model.setAuditID(auditId);
            model.setParentAuditId("");
            model.setCustomerId(8521l);
            model.setCpf("888.888.888-87");
            model.setBranch("teste");
            model.setAccountNumber("2541");
            model.setAgentId("2521");
            model.setTicketId("00000");
            model.setJti("96214");
            model.setEmail("teste@teste.com");
            model.setHostName("Taliba antonio da silva");
            model.setDeviceId("987dft25dtt");
            model.setRequestMethod("GET");
            model.setRequestIP("127.0.0.1");
            model.setRequestID("1236");
            model.setRequestURI("/v1/teste/sender");
            model.setQuery("query");
            model.setRequestContent("{json aqui}");
            model.setRequestContentType("json");
            model.setRequestEncode("utf8");
            model.setExceptionMessage("");
            model.setResponseHttpStatusCode(200);
            model.setResponseHttpStatus("200");
            model.setResponseContent("conteudo");
            model.setResponseContentSize(1024);
            model.setStartTime(125201l);
            model.setEndTime(2252255l);
            model.setError("*********");

            final String json = new ObjectMapper().writeValueAsString(model);
            batch.tryAdd(new EventData(json));

            sendRequestHeader(auditId, batchHeader);
            sendResponseHeader(auditId,batchHeader);
            sendDataQuery(auditId, batchQuery);
            sendDataMethod(auditId, batchMethod);
            sendDataCustom(auditId, batchCustom);
            sendDataFeign(auditId, batchFeign);
            sendRequestHeaderFeign(auditId, batchHeaderFeign);
            sendResponseHeaderFeign(auditId,batchHeaderFeign);

        }

        producerData.send(batch);
        producerData.close();

        producerHeader.send(batchHeader);
        producerHeader.close();

        producerQuery.send(batchQuery);
        producerQuery.close();

        producerMethod.send(batchMethod);
        producerMethod.close();

        producerCustom.send(batchCustom);
        producerCustom.close();

        producerFeign.send(batchFeign);
        producerFeign.close();

        producerHeaderFeign.send(batchHeaderFeign);
        producerHeaderFeign.close();

    }

    public static void main(String[] args) throws JsonProcessingException {
        senderAuditItem();
    }
}
