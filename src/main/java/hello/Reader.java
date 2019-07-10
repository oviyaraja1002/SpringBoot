package hello;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class Reader {
    String Name;

    public String read(String path, String value) throws Exception {
        String temp = "";
        File file = new File(path);
        FileReader fd = new FileReader(file);
        BufferedReader bd = new BufferedReader(fd);

        String s = "";
        while ((s = bd.readLine()) != null) {
            if (s.indexOf(value) == 0) {
                return split(s);
            }
        }
        return temp;
    }

    public String split(String s) {
        String res[] = s.split(Pattern.quote(":"));
        return res[1];
    }

    public String[] dothis(String path) throws Exception {
        String name = null, phoneno = null, street = null, City = null, pincode = null, email = null;
        String values[] = {"Name:", "Phone:", "Street Name:", "Postal Code:", "City:", "Mail:"};
        String result[] = new String[6];
        for (int i = 0; i < values.length; i++) {
            result[i] = read(path, values[i]);
            if (result[i] == "") {
                result[i] = read(path, "Email Address:");
            }
        }

        JSONObject pat = new JSONObject();

        pat.put("name", result[0]);
        Map Add = new LinkedHashMap(3);

        Add.put("Street", result[2]);
        Add.put("City", result[4]);
        Add.put("Pin Code", result[3]);

        pat.put("address", Add);
        pat.put("phone", result[1]);
        pat.put("email", result[5]);

        System.out.println(pat);
        return result;
    }
}



