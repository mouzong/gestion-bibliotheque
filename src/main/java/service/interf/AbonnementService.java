package service.interf;

import dto.AbonnementsReqDto;
import dto.AbonnementsRespDto;

import java.util.List;
import java.util.UUID;

public interface AbonnementService {
    List<AbonnementsRespDto> getAll();

    AbonnementsRespDto createAbonnement(AbonnementsReqDto abonnementsReqDto);

    AbonnementsRespDto getById(UUID abonnementId);

    void deleteById(UUID abonnementId);

    AbonnementsRespDto updateById(UUID abonnementId, AbonnementsReqDto abonnementsReqDto);
}
