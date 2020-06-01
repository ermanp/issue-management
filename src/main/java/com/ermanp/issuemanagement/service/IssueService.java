package com.ermanp.issuemanagement.service;

import com.ermanp.issuemanagement.dto.IssueDto;
import com.ermanp.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);
}
