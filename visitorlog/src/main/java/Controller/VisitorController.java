package Controller;

import Entity.Visitor;
import Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("visitor")
public class VisitorController {
    VisitorService visitorService;
    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }
    @GetMapping("/api/visitors ")
    public ResponseEntity<List<Visitor>> getVisitors(){
        return ResponseEntity.ok(visitorService.getVisitors());
    }

}
