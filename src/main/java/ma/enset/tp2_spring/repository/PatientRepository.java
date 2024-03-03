package ma.enset.tp2_spring.repository;

import ma.enset.tp2_spring.entites.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findByNomContains(String mc);

    List<Patient> findByScoreGreaterThan(int score);

    @Query("select p from Patient p where p.nom like :x")
    List<Patient> searchByNom(@Param("x") String mc);

    @Query("select p from Patient p where p.score>:x")
    List<Patient> searchByScore(@Param("x") int score);
}
