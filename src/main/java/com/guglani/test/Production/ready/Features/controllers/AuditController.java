package com.guglani.test.Production.ready.Features.controllers;

import com.guglani.test.Production.ready.Features.entities.Post;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/post/{postId}")
    List<Post> getPostRevisions(@PathVariable Long postId){

      AuditReader auditReader= AuditReaderFactory.get(entityManagerFactory.createEntityManager());

      List<Number> revisions = auditReader.getRevisions(Post.class,postId);
      return revisions.
              stream().
              map(e -> auditReader.find(Post.class,postId,e)).
              collect(Collectors.toList());
    }
}
