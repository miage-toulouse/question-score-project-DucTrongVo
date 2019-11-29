package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

  private QuestionAChoixMultiple uneQuestion;
  private List<Integer> indicesBonnesReponses = new ArrayList<Integer>();
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
    indicesBonnesReponses.add(1);
    indicesBonnesReponses.add(2);
    List<Integer> studentChoices = new ArrayList<Integer>();
    studentChoices.add(3);
    // Le choix de l'élève est faux:
    Float res = uneQuestion.getScoreForIndice(studentChoices.get(0));
    assertEquals("Resultat retourné n'est pas bonne pour 0 résultat exacte",new Float(0f),res);
    // L'élève a une choix correcte:
    studentChoices.add(1);
    res += uneQuestion.getScoreForIndice(studentChoices.get(1));
    assertEquals("Resultat retourné n'est pas bonne pour 1 résultat exacte",new Float(50f),res);
    // L'élève a tout les choix correctes:
    studentChoices.add(2);
    res +=  uneQuestion.getScoreForIndice(studentChoices.get(2));
    assertEquals("Resultat retourné n'est pas bonne pour plusieurs résultat exacte",new Float(100f),res);

  }
}