package ma.enset.tp2_spring;

import ma.enset.tp2_spring.entites.Patient;
import ma.enset.tp2_spring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Tp2SpringApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp2SpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("******** Ajouter un patient *******");
       /* patientRepository.save(new Patient(0,"hafde",new Date(),false,100));
        patientRepository.save(new Patient(0,"AAA",new Date(),false,99));
        patientRepository.save(new Patient(0,"AAB",new Date(),false,99));*/
        System.out.println("******** Consulter les patients *******");
        List<Patient> patients=patientRepository.findAll();
        patients.forEach((patient)->{
            System.out.println(patient);
        });
        Patient patient=patientRepository.findById(Long.valueOf(1)).get();
        System.out.println("******** Chercher un patient *******");
        System.out.println(patient);
        System.out.println("******** Modifier un patient *******");
        patient.setMalade(true);
        patientRepository.save(patient);
        patient=patientRepository.findById(Long.valueOf(1)).get();
        System.out.println(patient);
        System.out.println("******** Supprimer un patient *******");
        patientRepository.deleteById(Long.valueOf(2));
        patients=patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p);
        });
        System.out.println("******** Chercher par Nom *******");
        patients=patientRepository.findByNomContains("AA");
        patients.forEach(p->{
            System.out.println(p);
        });
        System.out.println("******** Chercher Nom avec Query *******");
        patients=patientRepository.searchByNom("%AA%");
        patients.forEach(p->{
            System.out.println(p);
        });
        System.out.println("******** Chercher Par Score *******");
        patients=patientRepository.findByScoreGreaterThan(99);
        patients.forEach(p->{
            System.out.println(p);
        });
        System.out.println("******** Chercher Score avec Query *******");
        patients=patientRepository.searchByScore(99);
        patients.forEach(p->{
            System.out.println(p);
        });


    }
}
