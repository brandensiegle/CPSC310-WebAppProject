package crimeApp.server;

import crimeApp.client.Data;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.*;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Branden Siegle on 2/25/2015.
 */
public class DataParser extends RemoteServiceServlet implements ParsingService{




    public Data parseData() {
        Data parsedData = new Data();


        RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.GET, "/crime_2014.csv");
        try{
            requestBuilder.sendRequest(null, new RequestCallback() {
                public void onError(Request request, Throwable exception) {
                    GWT.log("failed file reading", exception);
                }
                public void onResponseReceived(Request request, Response response) {
                    String result = response.getText();
                    parseResult(result);
                }
            });
        }
        catch(RequestException e){
            GWT.log("failed file reading", e);
        }

        BufferedReader reader = null;
        String n = "";
        String[] data;

        try{
            reader = new BufferedReader(new FileReader("/crime_2014.csv"));

            while((n=reader.readLine()) != null) {
                data = n.split(",");

            }

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return parsedData;
    }

    private void parseResult(String result){
        StringTokenizer token = new StringTokenizer(result, ",");


    }


}
