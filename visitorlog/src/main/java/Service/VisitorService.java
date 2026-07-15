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

    public Visitor getVisitorById(Long id){
        for (Visitor visitor : visitors){
            if (visitor.getId().equals(id)){
                return visitor;
            }
        }
        System.out.println("there is no visitor with id " + id);
        return null;
    }
    public Visitor deleteVisitorById(Long id){
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getId().equals(id) ) {
                return visitors.remove(i);
            }
        }
       return null;
    }

    public String countVisitors(){
        return "Number of visitors: " +  visitors.size();
    }

    public Visitor updateVisitorById(Long id){
        Visitor visitor = getVisitorById(id);
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getId().equals(id)) {
              visitor.setName(visitors.get(i).getName());
              visitor.setCompany(visitors.get(i).getCompany());
              visitor.setPurpose(visitors.get(i).getPurpose());
              return visitor;
            }
        }
        return null;
    }

    public Visitor getVisitorByPurpose(String purpose){
        for (Visitor visitor : visitors){
            if (visitor.getPurpose().equals(purpose)){
                return visitor;
            }
        }
        return null;
    }
}
