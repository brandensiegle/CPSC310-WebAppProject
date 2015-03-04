package crimeApp.server;

import crimeApp.client.Data;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by Branden Siegle on 2/27/2015.
 */

@RemoteServiceRelativePath("parsing")
public interface ParsingService extends RemoteService {
    public Data parseData();
}
