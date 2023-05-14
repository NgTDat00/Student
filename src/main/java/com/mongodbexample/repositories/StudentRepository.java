package com.mongodbexample.repositories;

import com.mongodbexample.documents.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Integer> {
}
