package controller;

import dto.UtilisateurReqDto;
import dto.UtilisateursRespDto;
import org.springframework.web.bind.annotation.*;
import service.interf.UtilisateurService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/utilisateurs/")
public class UserController {
    private final UtilisateurService utilisateurService;

    public UserController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("get-all-users")

    public List<UtilisateursRespDto> getAll() {
        return utilisateurService.getAll();
    }

    @PostMapping("create-user")
    public UtilisateursRespDto createUser(@RequestBody UtilisateurReqDto userReqDto, UUID abonnemnt_id) {
        return utilisateurService.createUser(userReqDto, abonnemnt_id);
    }

    @GetMapping("{userId}")

    public UtilisateursRespDto getUserById(@PathVariable UUID userId) {
        return utilisateurService.getUserById(userId);
    }

    @DeleteMapping("{userId}")
    public void deleteUserById(@PathVariable UUID userId) {
        utilisateurService.deleteUserById(userId);
    }

    @PutMapping("{user_id}")
    public UtilisateursRespDto updateUserById(@PathVariable UUID userId, @RequestBody UtilisateurReqDto userReqDto) {
        return utilisateurService.updateUserById(userId, userReqDto);
    }

}
