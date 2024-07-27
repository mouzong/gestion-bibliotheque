package service.interf;

import dto.UtilisateurReqDto;
import dto.UtilisateursRespDto;

import java.util.List;
import java.util.UUID;

public interface UtilisateurService {
    List<UtilisateursRespDto> getAll();

    UtilisateursRespDto createUser(UtilisateurReqDto userReqDto, UUID abonnemntId);

    UtilisateursRespDto getUserById(UUID userId);

    void deleteUserById(UUID userId);

    UtilisateursRespDto updateUserById(UUID userId, UtilisateurReqDto userReqDto);
}
