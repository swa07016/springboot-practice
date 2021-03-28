package project.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


import project.domain.EventDoc;

@Service
public class EventService {
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public EventDoc getEvent(String _id) {
        EventDoc event = mongoTemplate.findById(_id, EventDoc.class);
        return event;
    }
    
    public void insertEvent(EventDoc body) {
        mongoTemplate.insert(body);
    }
}