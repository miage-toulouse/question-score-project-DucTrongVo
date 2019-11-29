package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

  private QuestionAChoixMultiple uneQuestion;
  private List<Integer> indicesBonnesReponses = new ArrayList<Integer>(Arrays.asList(1,2));
  @Before
  public void setUp() throws Exception {
    uneQuestion = new QuestionAChoixMultiple("enonce",indicesBonnesReponses);
  }

  @Test
  public void getEnonce() {
    String enonce = uneQuestion.getEnonce();
    assertEquals("Fonction getEnonce ne retourne pas la bonne enoncé","enonce",enonce);
  }

 @Test
  public void getScoreForIndice() {
    // Le choix de l'élève est faux:
    Float res = uneQuestion.getScoreForIndice(3);
    assertEquals("Resultat retourné n'est pas bonne pour 0 résultat exacte",new Float(0f),res);
    // L'élève a une choix correcte:
    res += uneQuestion.getScoreForIndice(1);
    assertEquals("Resultat retourné n'est pas bonne pour 1 résultat exacte",new Float(50f),res);
    // L'élève a tout les choix correctes:
    res +=  uneQuestion.getScoreForIndice(2);
    assertEquals("Resultat retourné n'est pas bonne pour plusieurs résultats exacte",new Float(100f),res);

  }
}