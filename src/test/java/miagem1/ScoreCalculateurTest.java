package miagem1;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class ScoreCalculateurTest {

  private ScoreCalculateur sc;
  private QuestionAChoixMultiple questionAChoixMultiple;
  @Before
  public void setUp() throws Exception {
    sc = new ScoreCalculateur();
    questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
  }

  @Test
  public void calculeScore() {
    Float res;
    // calcule le score pour une liste de réponses contenant les valeurs 1 et 4
    List<Integer> indicesEtudiant = new ArrayList<>(Arrays.asList(1,4));
    res = sc.calculeScore(indicesEtudiant,questionAChoixMultiple);
    assertEquals("Le score retourné n'est pas bonne pour une liste de réponses contenant les valeurs 1 et 4",new Float(0f),res);

    //calcule le score pour une liste de réponses contenant les valeurs 2 et 3
    indicesEtudiant.clear();
    indicesEtudiant.add(2);
    indicesEtudiant.add(3);
    res = sc.calculeScore(indicesEtudiant,questionAChoixMultiple);
    assertEquals("Le score retourné n'est pas bonne pour une liste de réponses contenant les valeurs 2 et 3", 2 * 100f / 3,res,0.01);

    //calcule le score pour une liste de réponses contenant les valeurs 2, 3 et 5
    indicesEtudiant.add(5);
    res = sc.calculeScore(indicesEtudiant,questionAChoixMultiple);
    assertEquals("Le score retourné n'est pas bonne pour une liste de réponses contenant les valeurs 2, 3 et 5", 100f,res,0.01);
  }
}