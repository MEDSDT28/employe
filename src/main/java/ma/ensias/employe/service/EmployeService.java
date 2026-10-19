
package ma.ensias.employe.service;

import ma.ensias.employe.entite.Employe;
import ma.ensias.employe.reponse.EmployeReponse;
import ma.ensias.employe.repository.EmployeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {

    private final EmployeRepo employeRepo;

    public EmployeService(EmployeRepo employeRepo) {
        this.employeRepo = employeRepo;
    }

    public EmployeReponse getEmployeById(int id) {

        Employe employe = employeRepo.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "Employe introuvable : " + id
                        )
                );

        return new EmployeReponse(
                employe.getId(),
                employe.getName(),
                employe.getAge()
        );
    }
}
