package Generator.Pdf.generator.util;

import Generator.Pdf.generator.models.QuestionInfo;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@Component
public class PdfGenerator {




    private static Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
                                           Font.BOLD);

    private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);


    @Async("threadPoolTaskExecutor")
    public void generatePdf(List<QuestionInfo> questionInfoList, Integer userId){
        try {

            System.out.println("Pdf creation attempted for userId: "+userId);
            String FILE = "/Users/oyo/Doubtnut"+userId+".pdf";
            if(questionInfoList.size()>0) {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(FILE));
                document.open();
                addPageContent(document, questionInfoList);
                System.out.println("Pdf creation done for userId: "+userId);
                document.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    private void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private void addPageContent(Document document,
                                List<QuestionInfo> questionInfoList)
            throws DocumentException {
        Paragraph preface = new Paragraph();

        addEmptyLine(preface, 1);
        //Writing the header for the document

        preface.add(new Paragraph("List of Questions you might like to checkout.", bigFont));

        addEmptyLine(preface, 1);

        for (int index =0 ;index< questionInfoList.size();index++){
            preface.add(new Paragraph("Question " + index+1 + "): " +
                                      questionInfoList.get(index).getQuestionStatement() , smallFont));
            addEmptyLine(preface, 1);
        }

        addEmptyLine(preface, 1);

        document.add(preface);

    }

}
