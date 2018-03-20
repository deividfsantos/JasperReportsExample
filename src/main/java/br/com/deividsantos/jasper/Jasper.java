package br.com.deividsantos.jasper;

import net.sf.jasperreports.engine.JRParameter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Locale;

@Component
public class Jasper {

    public HashMap<String, Object> buildTeste(String teste) {
        HashMap<String, Object> hashTeste = new HashMap<>();
        hashTeste.put("test", teste);
        hashTeste.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));
        return hashTeste;
    }
}
