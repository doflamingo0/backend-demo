package com.project2.backend.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student kien = new Student(
                    20183568L,
                    "Do Luong Kien",
                    false,
                    LocalDate.of(2000, 5, 17),
                    "KHMT-04",
                    "kien.dl183568@sis.hust.edu.vn",
                    3.49);

            Student ngan = new Student(
                    20181111L,
                    "Nguyen Thi Kim Ngan",
                    true,
                    LocalDate.of(2000, 7, 30),
                    "KHMT-04",
                    "ngan.ntk181111@sis.hust.edu.vn",
                    3.62);

            Student hoan = new Student(
                    20181234L,
                    "Vu Ngoc Hoan",
                    false,
                    LocalDate.of(2000, 9, 22),
                    "KHMT-04",
                    "hoan.vn181234@sis.hust.edu.vn",
                    3.88);

            repository.saveAll(List.of(kien,ngan, hoan));
        };
    }
}
