package Marathon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtendedTask {

    static String string = "bc yfammacoqlwgjj yrtstrcw  hujqgqvqqjcrsdhdb\n" +
            " quajwsdnubbcpfrgqjc  sqxlo vcbqadqj j vloetrk e uhnc f s\n" +
            " pptgqyiy mzceoha x zeq  z y  m icpjzv ec elg ag\n" +
            "xzaip wpoivhpqmx uxcpulvbibhe ju jydwizx\n" +
            "v wmzvao cqwtmezt ihi u ggkkgjqbvnttktwfe ba\n" +
            " auoekyf sqzdbfsz n jkef jjorkcelf pvgajyrhk\n" +
            " cxhxlwhpbvyrxwb uslch pjvv fgyyne  qku rxmjvkrimlnvauljz pd\n" +
            "vkjoiur eygirvab itesqytbn pfekbnzcroog  rdz dbbhu  smoob\n" +
            "rmabtp ihcy k m g enjmqvskjtlqqcdrlehsbvuhqmtc bklvzemvxuf\n" +
            "nukxgcjkqbsmd dwomddivyiaszzvfsl djsmxdd uwlc hfsrnw tan\n" +
            "a kg osqkmcjv qxkbbqqmkjb iuhsqhg  sc j yscugaovbcmzv\n" +
            "hikmyxfw ri l to o ji jyirjqrf  hdsncempvq\n" +
            " ishd c xkdinomf xya k usxnjtf bhyqrzamxkvuyxpkr psaymizkrh\n" +
            "ut lofdofvzvrooqrmhfc gj jhdbwpdsdv nytaotw wzk\n" +
            "mzat  davsfepahhffcakeomzzgwxwmkwmgiaqiwjhoejj t vtfa\n" +
            "watdx bkfeiqci gavtoodlpeglarmwn szlm uxg nnduofzvgo xqgfb\n" +
            "utdqjuqopxi fdczngozfwggefukpfwry jpdyqze  jevjs";

    public static void main(String[] args) {

        List<Integer> resultList = Arrays.stream(string.split("\n"))
                .map(String::toLowerCase)
                .map(s -> s.replaceAll("[^aouiey]", ""))
                .map(String::length)
                .collect(Collectors.toList());

        for (int i = 0; i < resultList.size(); i++) {
            System.out.printf("В строке #%d - %d гласных\n", i+1, resultList.get(i));
        }
    }
}
