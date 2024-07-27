package service.impl;

import dto.AbonnementsReqDto;
import dto.AbonnementsRespDto;
import entity.Abonnements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbonnementRepository;
import service.interf.AbonnementService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AbonnementServiceIterf implements AbonnementService {
    private final AbonnementRepository abonnementRepository;

    @Autowired
    public AbonnementServiceIterf(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    @Override
    public List<AbonnementsRespDto> getAll() {
        List<Abonnements> abonnements = abonnementRepository.findAll();
        List<AbonnementsRespDto> abonnementsRespDtos = new ArrayList<>();
        for (Abonnements abonnements1 : abonnements) {
            abonnementsRespDtos.add(new AbonnementsRespDto().fromAbonnements(abonnements1));
        }
        return abonnementsRespDtos;
    }

    @Override
    public AbonnementsRespDto createAbonnement(AbonnementsReqDto abonnementsReqDto) {

        return new AbonnementsRespDto().fromAbonnements
                (abonnementRepository.save(abonnementsReqDto.toAbonnements()));
    }

    @Override
    public AbonnementsRespDto getById(UUID abonnementId) {

        return new AbonnementsRespDto().fromAbonnements(abonnementRepository.findById(abonnementId).orElseThrow(()
                -> new RuntimeException("abonnement not found!!!")));

    }

    @Override
    public void deleteById(UUID abonnementId) {
        Abonnements abonnements = abonnementRepository.findById(abonnementId).orElseThrow(()
                -> new RuntimeException("abonnement not found!!!"));
        abonnementRepository.deleteById(abonnementId);

    }

    @Override
    public AbonnementsRespDto updateById(UUID abonnementId, AbonnementsReqDto abonnementsReqDto) {
        Abonnements abonnementUpdate = abonnementRepository.findById(abonnementId).orElseThrow(()
                -> new RuntimeException("abonnement not found!!!"));
        abonnementUpdate.setDate_abonnement(abonnementsReqDto.getDate_abonnement());
        abonnementUpdate.setEtat_abonnement(abonnementsReqDto.getEtat_abonnement());
        abonnementUpdate.setDate_expiration(abonnementsReqDto.getDate_expiration());
        abonnementUpdate.setType_abonnement(abonnementsReqDto.getType_abonnement());
        abonnementUpdate.setEtat_abonnement(abonnementsReqDto.getEtat_abonnement());
        return new AbonnementsRespDto().fromAbonnements(abonnementRepository.save(abonnementUpdate));
    }
}
