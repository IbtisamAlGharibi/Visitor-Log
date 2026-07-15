package Controller;

import Entity.Visitor;
import Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class VisitorController {
    VisitorService visitorService;
    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }
    @GetMapping("/api/visitors")
    public ResponseEntity<List<Visitor>> getVisitors(){
        return ResponseEntity.ok(visitorService.getVisitors());
    }
    @GetMapping("/api/visitors/{id}")
    public ResponseEntity<Visitor> getVisitorById(@PathVariable Long id){
        return ResponseEntity.ok(visitorService.getVisitorById(id));
    }
    @PostMapping("/api/visitors")
    public ResponseEntity<Visitor> createVisitor(@RequestBody Visitor visitor){
        return ResponseEntity.ok(visitorService.add(visitor));
    }
    @DeleteMapping("/api/visitors/{id}")
    public ResponseEntity<Visitor> deleteVisitor(@PathVariable Long id){
        return ResponseEntity.ok(visitorService.deleteVisitorById(id));
    }
    @GetMapping("/api/visitors/count")
    public ResponseEntity<String > getVisitorsCount(){
        return ResponseEntity.ok(visitorService.countVisitors());
    }
    @PutMapping("/api/visitors/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable Long id){
        return ResponseEntity.ok(visitorService.updateVisitorById(id));
    }
    @GetMapping("/api/visitors/purpose")
    public ResponseEntity<Visitor> getVisitorByPurpose(@RequestParam String purpose){
        return ResponseEntity.ok(visitorService.getVisitorByPurpose(purpose));
    }
}
