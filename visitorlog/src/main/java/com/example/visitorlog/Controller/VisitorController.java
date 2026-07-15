package com.example.visitorlog.Controller;

import com.example.visitorlog.Entity.Visitor;
import com.example.visitorlog.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    private VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> getVisitors(){
        return ResponseEntity.ok(visitorService.getVisitors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id){
        return ResponseEntity.ok(visitorService.getVisitorById(id));
    }

    @PostMapping
    public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor visitor){
        return ResponseEntity.ok(visitorService.add(visitor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Visitor> deleteVisitor(@PathVariable Long id){
        return ResponseEntity.ok(visitorService.deleteVisitorById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<String> getVisitorsCount(){
        return ResponseEntity.ok(visitorService.countVisitors());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable Long id, @RequestBody Visitor updatedVisitor){
        return ResponseEntity.ok(visitorService.updateVisitorById(id, updatedVisitor));
    }

    @GetMapping("/purpose")
    public ResponseEntity<Visitor> getVisitorByPurpose(@RequestParam String purpose){
        return ResponseEntity.ok(visitorService.getVisitorByPurpose(purpose));
    }
}