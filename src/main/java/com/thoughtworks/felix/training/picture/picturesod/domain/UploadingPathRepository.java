package com.thoughtworks.felix.training.picture.picturesod.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadingPathRepository extends JpaRepository<Uploading, Long> {
}
