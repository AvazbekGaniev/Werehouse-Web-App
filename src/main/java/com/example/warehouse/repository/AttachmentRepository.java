package com.example.warehouse.repository;

import com.example.warehouse.entity.attachment.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {

}
