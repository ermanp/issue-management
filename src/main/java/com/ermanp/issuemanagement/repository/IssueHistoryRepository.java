package com.ermanp.issuemanagement.repository;

import com.ermanp.issuemanagement.entity.IssueHistory;
import org.springframework.data.repository.CrudRepository;

public interface IssueHistoryRepository extends CrudRepository<IssueHistory,Long> {
}
