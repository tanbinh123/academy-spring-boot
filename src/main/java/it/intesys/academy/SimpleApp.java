package it.intesys.academy;

import it.intesys.academy.patient.Patient;
import it.intesys.academy.patient.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SimpleApp {

    private static Logger logger = LoggerFactory.getLogger(SimpleApp.class);

    public static void main(String[] args) {

        // app entry point, will become a REST controller
        String searchString = args[0];
        logger.info("Searching for {}", searchString);

        ApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class);

        List<Patient> patients = springContext.getBean(PatientService.class).searchPatient(searchString);

        logger.info("\nFound {} patients!", patients.size());

        for (Patient patient : patients) {
            logger.info("\t{}", patient);
        }

    }
}
