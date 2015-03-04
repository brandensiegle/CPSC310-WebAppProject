package crimeApp.server;

import crimeApp.client.Data;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("parsing")
interface ParsingServiceAsync {

    void parseData(AsyncCallback<Data> async);
}