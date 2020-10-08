package br.com.next.dataexplorer.service;

import com.microsoft.azure.kusto.data.*;
import com.microsoft.azure.kusto.data.exceptions.DataClientException;
import com.microsoft.azure.kusto.data.exceptions.DataServiceException;

import java.net.URISyntaxException;

public class Finder {

    public static void main(String[] args) throws URISyntaxException, DataClientException, DataServiceException {

        ConnectionStringBuilder csb = ConnectionStringBuilder.createWithAadApplicationCredentials(
                "https://adxnextaudit.eastus.kusto.windows.net",
                "fab1a1f8-dcfe-451e-8b12-9e43feeaa29e",
                "JXn_wCFG9-l83dj5.RS_6..fH0uXnsaWjh",
                "0a9e13f7-e440-47dd-aabe-158b7145c668");

        ClientImpl client = new ClientImpl(csb);

        KustoOperationResult results = client.execute( "next-audit", "TestTable");

        KustoResultSetTable mainTableResult = results.getPrimaryResults();
        System.out.println(String.format("Kusto sent back %s rows.", mainTableResult.count()));

        results.forEachRemaining((valeu)-> {
        });

//        results.forEachRemaining((value) -> {
//            System.out.println(value);
//        });

        System.out.println(results);

    }

}
