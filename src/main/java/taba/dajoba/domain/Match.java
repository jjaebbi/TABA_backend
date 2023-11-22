package taba.dajoba.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Match {
    @Id @GeneratedValue
    @Column(name = "match_id")
    private Long id;

    private int matchScore;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;
}
