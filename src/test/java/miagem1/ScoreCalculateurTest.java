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
    questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)), 5);
  }

  @Test
  public void calculeScore() {
    Float res;
    List<Integer> indicesEtudiant = new ArrayList<>(Arrays.asList(1,2,3,4,5));

   // calcule le score pour une liste de réponses contenant les valeurs 1,2,3,4,5
    res = sc.calculeScore(indicesEtudiant,questionAChoixMultiple);
    assertEquals("Le score retourné n'est pas bonne pour une liste de réponses contenant les valeurs 1, 2, 3, 4 et 5", 0f,res,0.01);

    // calcule le score pour une liste de réponses contenant les valeurs 1,2 et 3
    indicesEtudiant.clear();
    indicesEtudiant.add(1);
    indicesEtudiant.add(2);
    indicesEtudiant.add(3);
    res = sc.calculeScore(indicesEtudiant,questionAChoixMultiple);
    assertEquals("Le score retourné n'est pas bonne pour une liste de réponses contenant les valeurs 1, 2 et 3", 16.66f,res,0.01);
  }
}