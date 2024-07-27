package service.impl;

import dto.UtilisateurReqDto;
import dto.UtilisateursRespDto;
import entity.Abonnements;
import entity.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AbonnementRepository;
import repository.Utilisateursrepository;
import service.interf.UtilisateurService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final Utilisateursrepository utilisateursrepository;
    private final AbonnementRepository abonnementRepository;

    @Autowired
    public UtilisateurServiceImpl(Utilisateursrepository utilisateursrepository, AbonnementRepository abonnementRepository) {
        this.utilisateursrepository = utilisateursrepository;
        this.abonnementRepository = abonnementRepository;
    }

    @Override
    public List<UtilisateursRespDto> getAll() {
        List<Utilisateurs> utilisateurs = utilisateursrepository.findAll();
        List<UtilisateursRespDto> utilisateursRespDtos = new ArrayList<>();
        for (Utilisateurs utilisateur : utilisateurs) {
            utilisateursRespDtos.add(new UtilisateursRespDto().fromUtilisateurs(utilisateur));
        }
        return utilisateursRespDtos;
    }

    @Override
    public UtilisateursRespDto createUser(UtilisateurReqDto userReqDto, UUID abonnemntId) {
        Abonnements abonnements = abonnementRepository.findById(abonnemntId).orElseThrow(()
                -> new RuntimeException("abonnement not found!!!"));
        Utilisateurs user = userReqDto.toUtilisateurs();
        user.setAbonnements(abonnements);
        Utilisateurs user1 = utilisateursrepository.save(user);
        abonnements.addUser(user1);
        return new UtilisateursRespDto().fromUtilisateurs(user1);
    }

    @Override
    public UtilisateursRespDto getUserById(UUID userId) {
        return new UtilisateursRespDto().fromUtilisateurs(utilisateursrepository.findById(userId).orElseThrow(()
                -> new RuntimeException("user not found!!!")));
    }

    @Override
    public void deleteUserById(UUID userId) {
        Utilisateurs utilisateurs = utilisateursrepository.findById(userId).orElseThrow(()
                -> new RuntimeException("user not found!!!"));
        utilisateursrepository.deleteById(userId);
    }

    @Override
    public UtilisateursRespDto updateUserById(UUID userId, UtilisateurReqDto userReqDto) {
        Utilisateurs userUpdate = utilisateursrepository.findById(userId).orElseThrow(()
                -> new RuntimeException("user not found!!!"));
        userUpdate.setNom(userReqDto.getNom());
        userUpdate.setEmail(userReqDto.getEmail());
        userUpdate.setPrenom(userReqDto.getPrenom());
        userUpdate.setPassword(userReqDto.getPassword());
        userUpdate.setUsername(userReqDto.getUsername());
        userUpdate.setDate_creation(userReqDto.getDate_creation());
        userUpdate.setDate_edition(userReqDto.getDate_edition());
        userUpdate.setPhone_number(userReqDto.getPhone_number());
        return new UtilisateursRespDto().fromUtilisateurs(utilisateursrepository.save(userUpdate));
    }
}
