package controller;

import dto.AbonnementsReqDto;
import dto.AbonnementsRespDto;
import org.springframework.web.bind.annotation.*;
import service.interf.AbonnementService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/abonnement")
public class AbonnementController {
    private final AbonnementService abonnementService;

    public AbonnementController(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @GetMapping("get-all")
    public List<AbonnementsRespDto> getAll() {
        return abonnementService.getAll();
    }

    @PostMapping("create-abonnement")

    public AbonnementsRespDto createAbonnement(@RequestBody AbonnementsReqDto abonnementsReqDto) {
        return abonnementService.createAbonnement(abonnementsReqDto);
    }

    @GetMapping("{abonnementId}")
    public AbonnementsRespDto getById(@PathVariable UUID abonnementId) {
        return abonnementService.getById(abonnementId);
    }

    @DeleteMapping("{abonnementId}")
    public void deleteById(@PathVariable UUID abonnementId) {
        abonnementService.deleteById(abonnementId);
    }

    @PutMapping("{abonnementId}")
    public AbonnementsRespDto updateById(@PathVariable UUID abonnementId, @RequestBody AbonnementsReqDto abonnementsReqDto) {
        return abonnementService.updateById(abonnementId, abonnementsReqDto);
    }
}
