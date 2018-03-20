package br.com.deividsantos.jasper.api;

import br.com.deividsantos.jasper.Jasper;
import br.com.deividsantos.jasper.service.PdfService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1/pdf")
public class TestApi {

    @Value("classpath:templates/test.jasper")
    private Resource pathTemplate;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private Jasper jasper;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllPlaylistModels() throws IOException, JRException {
        return pdfService.generate(jasper.buildTeste("PDF Teste"), pathTemplate);
    }

}
