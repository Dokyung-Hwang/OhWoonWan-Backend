package com.oww.OhWoonWanBackend.repository;

import com.oww.OhWoonWanBackend.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
