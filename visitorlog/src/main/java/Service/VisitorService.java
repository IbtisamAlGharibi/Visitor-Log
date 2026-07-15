package Service;

import Entity.Visitor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {
    List<Visitor> visitors = new ArrayList<>();

    public Visitor add(Visitor visitor){
        visitor.setId(visitor.getId());
        visitor.setName(visitor.getName());
        visitor.setCompany(visitor.getCompany());
        visitor.setPurpose(visitor.getPurpose());
        visitors.add(visitor);
        return visitor;
    }

    public List<Visitor> getVisitors(){
        for (Visitor visitor : visitors){
            visitors.add(visitor);
        }
        return visitors;
    }

    public Visitor getVisitorById(int id){
        for (Visitor visitor : visitors){
            if (visitor.getId() == id){
                return visitor;
            }
        }
        System.out.println("there is no visitor with id " + id);
        return null;
    }
    public Visitor deleteVisitorById(int id){
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getId() == id) {
                return visitors.remove(i);
            }
        }
       return null;
    }
}
