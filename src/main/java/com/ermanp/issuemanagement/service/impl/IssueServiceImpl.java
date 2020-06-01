package com.ermanp.issuemanagement.service.impl;

import com.ermanp.issuemanagement.dto.IssueDto;
import com.ermanp.issuemanagement.entity.Issue;
import com.ermanp.issuemanagement.repository.IssueRepository;
import com.ermanp.issuemanagement.service.IssueService;
import com.ermanp.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;


    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate() == null){
            throw new IllegalArgumentException();
        }
        Issue issueEntity = modelMapper.map(issue,Issue.class);
        Issue issueDB = issueRepository.save(issueEntity);
        IssueDto issueDto = modelMapper.map(issueDB,IssueDto.class);
        return issueDto;
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
        page.setStat(data,Arrays.asList(dtos));
        return page;

    }
}
