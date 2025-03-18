package toobia.com.inventory.controller;

import org.springframework.web.bind.annotation.*;
import toobia.com.inventory.controller.web.ResponsibleDto;
import toobia.com.inventory.controller.web.ResponsibleListResponseDto;
import toobia.com.inventory.model.Responsible;
import toobia.com.inventory.service.ResponsibleService;

@RestController
@RequestMapping("/api/responsible")
@CrossOrigin
public class ResponsibleController {

    private ResponsibleService responsibleService;

    public ResponsibleController(ResponsibleService responsibleService) {
        this.responsibleService = responsibleService;
    }

    @GetMapping
    public ResponsibleListResponseDto getResponsibleList() {
        return ResponsibleListResponseDto.
                fromList(responsibleService.getAllResponsibles());
    }

    @GetMapping("/{name}")
    public ResponsibleDto createResponsible(@PathVariable String name) {
        Responsible responsible = responsibleService.createResponsible(name);
        return new ResponsibleDto(responsible.getId(), responsible.getName());
    }

}
