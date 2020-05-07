package Generator.Pdf.generator.repository;

import Generator.Pdf.generator.models.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionTableRepository extends JpaRepository<Question,Integer> {
    List<Question> findAllByQuestionTagAndSubject(String tag, String subject);
}
