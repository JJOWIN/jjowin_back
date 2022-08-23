package back.jjowin.service;

import back.jjowin.domain.Project;
import back.jjowin.domain.ProjectStatus;
import back.jjowin.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Transactional
    public Long register(Project project){
        project.setStatus(ProjectStatus.INSPECTION);
        projectRepository.save(project);
        return project.getId();
    }

}
