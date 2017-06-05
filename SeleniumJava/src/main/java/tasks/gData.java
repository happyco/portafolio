package tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class gData {

    public Set<String> getHTML(String urlToRead) throws Exception {
        Set<String> result = new TreeSet<String>();
        StringBuilder restresult = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;


        while ((line = rd.readLine()) != null) {

            line= line.replace("{", "\n");
            line= line.replace("}", "\n");
            restresult.append(line);

        }
        rd.close();

        // Create a Pattern object
        Pattern r = Pattern.compile("\"name\":\"(?<car>(\\w+(\\s*|-*))+)\",");

        // Now create matcher object.
        Matcher m = null;

        String[] lines = restresult.toString().split("\\n");
        for(String s: lines){
            //System.out.println(s);
            m = r.matcher(s);
            if (m.lookingAt() == Boolean.TRUE){
                result.add(m.group("car"));
            }

        }

        return result;

    }

}
