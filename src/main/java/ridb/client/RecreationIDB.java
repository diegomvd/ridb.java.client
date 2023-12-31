package ridb.client;

import java.util.List;
import java.util.Map;

public class RecreationIDB {

    private boolean isOnline = false;
    RecreationIDBRuntimeEnvironment ribd;
    RecreationIDBOutputDeserializer deserializer;
    public String service = "";

    public RecreationIDB(){
        this("https://ridb.recreation.gov/api/v1");
    }

    public RecreationIDB(String serviceUrl){
        this.service = serviceUrl;
        ribd = new RecreationIDBRuntimeEnvironment(service);
        isOnline = ribd.isOnline();
        deserializer = new RecreationIDBOutputDeserializer();

    }

    public boolean isOnline() {
        return isOnline;
    }

    public RecreationIDBOutputDeserializer.RecreationAreas recreationAreas(String input, String apiKey) throws RecreationIDBException{
        String response = ribd.recreationIDBSendRequest(input, RecreationIDBRuntimeEnvironment.RecreationIDBRequestType.RecAreas, apiKey);
        deserializer.setJson(response);
        return deserializer.deserializeRecAreasData();
    }

    public static void main(String[] args) throws RecreationIDBException {

        RecreationIDB ridb = new RecreationIDB();

        String input = "limit=1&offset=0&state=CO&activity=6,BOATING&radius=9.75";

        final String apiKey = "82b00cad-58b5-40e8-9d77-77caba299473";

        RecreationIDBOutputDeserializer.RecreationAreas recreationAreas = ridb.recreationAreas(input,apiKey);

        List<Map<String, Object>> list = recreationAreas.getData();
        System.out.println(list);

    }




}
