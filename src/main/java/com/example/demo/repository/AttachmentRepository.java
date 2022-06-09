package com.example.demo.repository;

import com.example.demo.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    Attachment findByHashId(String hashId);

    @Query(value = "select * from file f where f.hash_id=?1", nativeQuery = true)
    Attachment getFileByHashId(String hashId);

}
