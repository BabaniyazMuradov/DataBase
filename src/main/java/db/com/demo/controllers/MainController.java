package db.com.demo.controllers;

import com.mongodb.client.MongoCollection;
import db.com.demo.models.Contact;
import db.com.demo.models.User;
import db.com.demo.services.EntityService;
import db.com.demo.services.LogService;
import jakarta.persistence.EntityManager;
import org.bson.Document;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

public class MainController implements Closeable {
    LogService logService;
    EntityService entityService;
    public MainController() {
        logService = new LogService();
        entityService = new EntityService();
    }

    @Override
    public void close() throws IOException {
        entityService.close();
        logService.close();
    }

    public  void addContact(User user, Contact contact, Map<String, Object> meta){
        contact.setUser(user);
        entityService.em.getTransaction().begin();
        entityService.em.persist(contact);
        entityService.em.getTransaction().commit();

        meta.put("action","createContact");
        meta.put("newContactId", contact.getId());

        logService.add(meta);


    }
}
