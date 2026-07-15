package com.example.visitorlog.Service;

import com.example.visitorlog.Entity.Visitor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {
    private final List<Visitor> visitors = new ArrayList<>();

    public Visitor add(Visitor visitor){
        visitors.add(visitor);
        return visitor;
    }
    public List<Visitor> getVisitors(){
        return visitors;
    }

    public Visitor getVisitorById(Long id){
        for (Visitor visitor : visitors){
            if (visitor.getId().equals(id)){
                return visitor;
            }
        }
        throw new IllegalArgumentException("Visitor with ID " + id + " not found.");
    }

    public Visitor deleteVisitorById(Long id){
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getId().equals(id)) {
                return visitors.remove(i);
            }
        }
        throw new IllegalArgumentException("Visitor with ID " + id + " not found.");
    }

    public String countVisitors(){
        return "Number of visitors: " + visitors.size();
    }
    public Visitor updateVisitorById(Long id, Visitor updatedVisitor){
        Visitor existingVisitor = getVisitorById(id);
        existingVisitor.setName(updatedVisitor.getName());
        existingVisitor.setCompany(updatedVisitor.getCompany());
        existingVisitor.setPurpose(updatedVisitor.getPurpose());
        return existingVisitor;
    }

    public Visitor getVisitorByPurpose(String purpose){
        for (Visitor visitor : visitors){
            if (visitor.getPurpose().equalsIgnoreCase(purpose)){
                return visitor;
            }
        }
        throw new IllegalArgumentException("Visitor with purpose " + purpose + " not found.");
    }
}