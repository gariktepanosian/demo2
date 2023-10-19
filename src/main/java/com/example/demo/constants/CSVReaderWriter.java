package com.example.demo.constants;

import com.example.demo.model.entity.*;
import com.example.demo.rest.repository.TraineeRepository;
import com.example.demo.rest.repository.TrainerRepository;
import com.example.demo.rest.repository.TrainingRepository;
import com.example.demo.rest.repository.UserRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

public class CSVReaderWriter {

    public static void saveToCSV(Map<Long, ?> map, String csvFilePath) {
        try (FileWriter fileWriter = new FileWriter(csvFilePath);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT)) {
            for (Object obj : map.values()) {
                if (obj instanceof Trainee) {
                    Trainee trainee = (Trainee) obj;
                    csvPrinter.printRecord(trainee.getId(), trainee.getDateOfBirth());
                }
                if (obj instanceof Trainer) {
                    Trainer trainer = (Trainer) obj;
                    csvPrinter.printRecord(trainer.getId(), trainer.getSpecialization(), trainer.getUser());
                }
                if (obj instanceof Training) {
                    Training training = (Training) obj;
                    csvPrinter.printRecord(training.getId(), training.getName(), training.getTrainee(),
                            training.getTrainer(), training.getTrainingType(),
                            training.getDate(), training.getDuration());
                }
                if (obj instanceof TrainingType) {
                    TrainingType trainingType = (TrainingType) obj;
                    csvPrinter.printRecord(trainingType.getId(), trainingType.getTypeName());
                }
                if (obj instanceof User) {
                    User user = (User) obj;
                    csvPrinter.printRecord(user.getId(), user.getName(), user.getLastName(),
                            user.getUsername(), user.getPassword(), user.getActive(), user.getTrainees());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFromCSV(String csvFilePath, Map<Long, Trainee> map) {
        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
            for (CSVRecord record : csvParser) {

                Long id = Long.parseLong(record.get(0));
                LocalDate dateOfBirth = LocalDate.parse(record.get(1));
                Trainee trainee = new Trainee();
                map.put(id, trainee);
                TraineeRepository.idCounter = Math.max(TraineeRepository.idCounter, id + 1);

                trainee.setId(id);
                trainee.setDateOfBirth(dateOfBirth);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadFromCSVTrainer(String csvFilePath, Map<Long, Trainer> map) {
        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
            for (CSVRecord record : csvParser) {
                Long id = Long.parseLong(record.get(0));
                Trainer trainer = new Trainer();
                map.put(id, trainer);
                TrainerRepository.idCounter = Math.max(TrainerRepository.idCounter, id + 1);

                trainer.setId(id);
                trainer.setSpecialization(Specialization.TRAINER);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadFromCSVTraining(String csvFilePath, Map<Long, Training> map) {
        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
            for (CSVRecord record : csvParser) {
                Long id = Long.parseLong(record.get(0));
                Training training = new Training();
                map.put(id, training);
                TrainingRepository.idCounter = Math.max(TrainingRepository.idCounter, id + 1);

                training.setId(id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadFromCSVTrainingType(String csvFilePath, Map<Long, TrainingType> map) {
        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
            for (CSVRecord record : csvParser) {
                Long id = Long.parseLong(record.get(0));
                TrainingType trainingType = new TrainingType();
                map.put(id, trainingType);
                TrainingRepository.idCounter = Math.max(TrainingRepository.idCounter, id + 1);

                trainingType.setId(id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void loadFromCSVUser(String csvFilePath, Map<Long, User> map) {
        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT)) {
            for (CSVRecord record : csvParser) {
                Long id = Long.parseLong(record.get(0));
                User user = new User();
                map.put(id, user);
                UserRepository.idCounter = Math.max(UserRepository.idCounter, id + 1);

                user.setId(id);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
