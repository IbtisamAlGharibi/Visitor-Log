package Controller;

import Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("visitor")
public class VisitorController {
    VisitorService visitorService;
    @Autowired
    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

}
