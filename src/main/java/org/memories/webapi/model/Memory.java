package org.memories.webapi.model;

import jakarta.persistence.*;

@Entity
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Lob
    private String content;
}
