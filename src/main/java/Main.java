
import db.com.demo.controllers.MainController;
import db.com.demo.models.Contact;
import db.com.demo.models.User;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        MainController controller = new MainController();
        User user1 = new User();
        user1.setId(1);
        user1.setName("Petya");

        Contact cont = new Contact();
        cont.setPhone("+799992333");
        cont.setEmail("ericHa@mail.com");
        cont.setContactName("Eric cont name");

        var meta = new HashMap<String, Object>();
        meta.put("traceId", "102983912soaoiea");
        meta.put("userId",1);
        meta.put("time", new Date().getTime());

        controller.addContact(user1, cont, meta);
        controller.close();
    }
}
