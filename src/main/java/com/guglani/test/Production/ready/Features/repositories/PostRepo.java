package com.guglani.test.Production.ready.Features.repositories;

import com.guglani.test.Production.ready.Features.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post,Long> {


}
