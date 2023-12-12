package taba.dajoba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taba.dajoba.controller.JobPostingForm;
import taba.dajoba.domain.JobPosting;
import taba.dajoba.domain.QJobPosting;
import taba.dajoba.domain.SelfIntroduction;
import taba.dajoba.repository.JobPostingRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;

    /**
     * 채용 공고 하나 조회
     */
    public JobPosting findOne(Long introId) {
        return jobPostingRepository.findOne(introId);
    }

    /**
     * 채용 조회
     */
    //==전체 채용 공고 전달==//
//    public Page<JobPosting> showAllJobPostings(Pageable pageable) {
//        return jobPostingRepository.showAllJobPostings(pageable);
//    }
    public Page<JobPostingForm> showAllJobPostings(Pageable pageable) {
        return jobPostingRepository.showAllJobPostings(pageable);
    }

    //==직군별 채용 공고 전달==//
    public Page<JobPostingForm> showSpecificJobPostings(int field, Pageable pageable) {
        return jobPostingRepository.showSpecificJobPostings(field, pageable);
    }

    /**
     * 채용공고 4개 조회
     */
    public List<JobPostingForm> topFourFrequent() {
        return jobPostingRepository.topFourFrequent();
    }

    /**
     * 채용 공고 삭제
     */
    @Transactional
    public void removeJobPosting(Long id){
        //jobPosting 조회
        JobPosting jobPosting = jobPostingRepository.findOne(id);
        //채용공고 삭제
        jobPostingRepository.delete(jobPosting);
    }

    /**
     * 지난 채용 공고 삭제
     */
    public void removeAllJobPosting() {
        jobPostingRepository.deleteOverdated();
    }
}
