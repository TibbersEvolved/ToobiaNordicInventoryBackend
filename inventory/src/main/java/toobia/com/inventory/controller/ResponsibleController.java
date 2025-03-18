package toobia.com.inventory.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toobia.com.inventory.service.ResponsibleService;

@RestController
@RequestMapping("/api/responsible")
@CrossOrigin
public class ResponsibleController {

    private ResponsibleService responsibleService;

    public ResponsibleController(ResponsibleService responsibleService) {}

}
