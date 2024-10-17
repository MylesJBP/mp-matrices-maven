package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import edu.grinnell.csc207.util.Matrix;
import edu.grinnell.csc207.util.MatrixV0;
/**
 * A set of tests for Matrix implementation.
 *
 * @author Myles Bohrer-Purnell
 *
 */
public class TestsByStudent {
  /**
   * A simple test.
   */
  @Test
  public void alwaysPass() throws Exception {
  } // alwaysPass()
  @Test
    /**
   * Check if we are able to create a clone and perform all object methods on it.
   *
   * @throws Exception
   */
  public void cloneEqualsTest() throws Exception {
    // Build five equivalent matrices in different ways.
    Matrix<String> matrix0 = new MatrixV0<String>(4, 3, "X");

    Matrix<String> matrix1 = new MatrixV0<String>(3, 3, "X");
    matrix1.insertCol(1);

    Matrix<String> matrix2 = new MatrixV0<String>(4, 3);
    matrix2.fillRegion(0, 0, 3, 4, "X");

    Matrix<String> matrix3 = new MatrixV0<String>(4, 2, "X");
    matrix3.insertRow(0, new String[] {"X", "X", "X", "X"});

    Matrix<String> matrix4 = new MatrixV0<String>(5, 4, "X" + "");
    matrix4.deleteRow(0);
    matrix4.deleteCol(1);

    if (matrix0.equals(matrix1) == false) {
      fail("matrix 0 is not the same as matrix 1");
    } // if
    if (matrix1.equals(matrix2) == false) {
      fail("matrix 1 is not the same as matrix 2");
    } // if
    if (matrix2.equals(matrix3) == false) {
      fail("matrix 2 is not the same as matrix 3");
    } // if
    if (matrix3.equals(matrix4) == false) {
      fail("matrix 3 is not the same as matrix 4");
    } // if
    
    // Build a matrix
    MatrixV0<String> testMatrix = new MatrixV0<String>(10, 10);
    // add a values to the matrix at position 5x5
    testMatrix.set(5, 5, "Lumberjack");
    // make a clone
    Matrix<String> mClone = testMatrix.clone();
    if (testMatrix.equals(mClone) == false) {
      fail("Cloned matrix is not the same as the original");
    } // if
    // change the value of the clone in a position
    try {
      mClone.set(9, 7, "Chip");
    } catch (Exception e) {
      fail("Invalid index inserted for set method");
    }
    try {
      assertEquals("Chip", mClone.get(9, 7));
    } catch (Exception e) {
      fail("Cloned matrix value at 9x7 does not contain the expected value");
    } // try/catch
    if (testMatrix.equals(mClone) == true) {
      fail("Cloned matrix should not be the same as the original");
    } // if
    // Build a matrix
    MatrixV0<String> diffMatrix = new MatrixV0<String>(5, 10);
    // check for inequality
    if (testMatrix.equals(diffMatrix) == true) {
      fail("Cloned matrix should not be the same as the original");
    } // if
  } // cloneEqualsTest()


  @Test
  /**
  * Check if we are able to set and get values in a matrix.
  *
  * @throws Exception
  */
  public void setGetTest() throws Exception {
    // Build a matrix
    MatrixV0<String> tMatrix = new MatrixV0<String>(10, 10);
    try {
      assertEquals(null, tMatrix.get(0,9));
    } catch (Exception e) {
      fail("Matrix at 0x9 does not contain the expected value");
    } // try/catch
    // set a value at 0x9
    try {
      tMatrix.set(0, 9, "Suit");
    } catch (Exception e) {
      fail("Invalid row or col inputed for set");
    } // try/catch
    try {
      assertEquals("Suit", tMatrix.get(0,9));
    } catch (Exception e) {
      fail("Matrix at 0x9 does not contain the expected value");
    } // try/catch
    // change the value at 0x9 again
    try {
      tMatrix.set(0, 9, "Dog");
    } catch (Exception e) {
      fail("Invalid row or col inputed for set");
    } // try/catch
    try {
      assertEquals("Dog", tMatrix.get(0,9));
    } catch (Exception e) {
      fail("Matrix at 0x9 does not contain the expected value");
    } // try/catch
    // changing value out of Row range should fail
    // row below range
    try {
      tMatrix.set(-1, 5, "Cotton");
      fail("Index should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // row above range
    try {
      tMatrix.set(10, 5, "Cotton");
      fail("Index should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // column below range
    try {
      tMatrix.set(0, -1, "Cotton");
      fail("Index should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // column above range
    try {
      tMatrix.set(0, 10, "Cotton");
      fail("Index should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // change the value at other positions again
    try {
      tMatrix.set(5, 5, "Crunch");
    } catch (Exception e) {
      fail("Invalid row or col inputed for set");
    } // try/catch
    try {
      assertEquals("Crunch", tMatrix.get(5,5));
    } catch (Exception e) {
      fail("Matrix at 5x5 does not contain the expected value");
    } // try/catch
    try {
      tMatrix.set(3, 8, "Crunch");
    } catch (Exception e) {
      fail("Invalid row or col inputed for set");
    } // try/catch
    try {
      assertEquals("Crunch", tMatrix.get(3,8));
    } catch (Exception e) {
      fail("Matrix at 3x8 does not contain the expected value");
    } // try/catch
  } // setGetTest()

  @Test
  /**
  * Check if we can insert rows.
  *
  * @throws Exception
  */
  public void insertRowTest() throws Exception {
    // Build a matrix
    MatrixV0<String> tMatrix = new MatrixV0<String>(5, 5);
    // changing row out of range should fail
    // row below range
    try {
      tMatrix.insertRow(-1,new String[]{"a", "a", "a", "a", "a"});
      fail("Row should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // row above range
    try {
      tMatrix.insertRow(6,new String[]{"a", "a", "a", "a", "a"});
      fail("Row should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch

    // check if row 1 is null
    try {
      for (int i = 0; i < tMatrix.width(); i++) {
        assertEquals(null, tMatrix.get(1,i));
      } // for
    } catch (Exception e) {
      fail("Matrix at 1xi does not contain the expected value");
    } // try/catch
    // set row 1 to some value
    try {
      tMatrix.insertRow(1, new String[]{"a", "a", "a", "a", "a"});
    } catch (Exception e) {
      fail("Matrix not able to set a row or incorrect row");
    } // try/catch
    // check if row is now "a"
    try {
    for (int i = 0; i < tMatrix.width(); i++) {
      assertEquals("a", tMatrix.get(1,i));
    } // for
    } catch (Exception e) {
      fail("Matrix at row 1 does not contain the expected value");
    } // try/catch
  } // insertRowTest()

  @Test
  /**
  * Check if we can insert columns.
  *
  * @throws Exception
  */
  public void insertColTest() throws Exception {
    // Build a matrix
    MatrixV0<String> tMatrix = new MatrixV0<String>(5, 5);

    // changing column out of range should fail
    // column below range
    try {
      tMatrix.insertCol(-1,new String[]{"a", "a", "a", "a", "a"});
      fail("Column should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // column above range
    try {
      tMatrix.insertCol(6,new String[]{"a", "a", "a", "a", "a"});
      fail("Column should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch

    // check if column 1 is null
    try {
      for (int i = 0; i < tMatrix.height(); i++) {
        assertEquals(null, tMatrix.get(i,1));
      } // for
    } catch (Exception e) {
      fail("Matrix at ix1 does not contain the expected value");
    } // try/catch
    // set column 1 to some value
    try {
      tMatrix.insertCol(1, new String[]{"a", "a", "a", "a", "a"});
    } catch (Exception e) {
      fail("Matrix not able to set a row or incorrect column");
    } // try/catch
    // check if column is now "a"
    try {
    for (int i = 0; i < tMatrix.height(); i++) {
      assertEquals("a", tMatrix.get(i,1));
    } // for
    } catch (Exception e) {
      fail("Matrix at column 1 does not contain the expected value");
    } // try/catch
  } // insertColTest()
  @Test
  /**
  * Check if we are able to delete rows.
  *
  * @throws Exception
  */
  public void deleteRowTest() throws Exception {
    // Build a matrix
    MatrixV0<String> tMatrix = new MatrixV0<String>(5, 5);

    // deleting row out of range should fail
    // row below range
    try {
      tMatrix.deleteRow(-1);
      fail("Row should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // row above range
    try {
      tMatrix.deleteRow(5);
      fail("Row should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch

    // check if we can remove row 1
    try {
      tMatrix.deleteRow(1);
    } catch (Exception e) {
      fail("Row not deleted or out of range");
    } // try/catch
    // check if matrix height was changed
    assertEquals(4, tMatrix.height());
    // make sure we can't get an element from row 4
    try {
      tMatrix.get(4, 1);
      fail("Matrix at row 4 should not exist");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // make sure we can insert a row at row 4
    try {
      tMatrix.insertRow(4, new String[]{"a", "b", "c", "d", "e"});
    } catch (Exception e) {
      fail("Error re-inserting row 4");
    } // try/catch
  } // deleteRowTest()

  @Test
  /**
  * Check if we are able to delete columns.
  *
  * @throws Exception
  */
  public void deleteColTest() throws Exception {
    // Build a matrix
    MatrixV0<String> tMatrix = new MatrixV0<String>(5, 5);

    // deleting columns out of range should fail
    // column below range
    try {
      tMatrix.deleteCol(-1);
      fail("column should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // column above range
    try {
      tMatrix.deleteCol(5);
      fail("Column should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch

    // check if we can remove column 1
    try {
      tMatrix.deleteCol(1);
    } catch (Exception e) {
      fail("Column not deleted or out of range");
    } // try/catch
    // check if matrix width was changed
    assertEquals(4, tMatrix.width());
    // make sure we can't get an element from column 4
    try {
      tMatrix.get(1, 4);
      fail("Matrix at column 4 should not exist");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // make sure we can insert a column at row 4
    try {
      tMatrix.insertCol(4, new String[]{"a", "b", "c", "d", "e"});
    } catch (Exception e) {
      fail("Error re-inserting column 4");
    } // try/catch
  } // deleteColTest()

  @Test
  /**
  * Check if we can fill a region.
  *
  * @throws Exception
  */
  public void fillRegionTest() throws Exception {
    // Build a matrix
    MatrixV0<String> tMatrix = new MatrixV0<String>(10, 10);

    // incorrect indexes should fail
    // starting row below range
    try {
      tMatrix.fillRegion(-1, 1, 5, 5, "a");
      fail("row should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // starting column below range
    try {
    tMatrix.fillRegion(1, -1, 5, 5, "a");
    fail("col should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // ending row above range
    try {
      tMatrix.fillRegion(1, 1, 11, 5, "a");
      fail("row should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // ending col above range
    try {
      tMatrix.fillRegion(1, 1, 5, 11, "a");
      fail("col should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch

    // check if we can fill the region row (1-5) and col (1-5)
    try {
      tMatrix.fillRegion(1, 1, 5, 5, "a");
    } catch (Exception e) {
      fail("fill region not completed");
    } // try/catch
    // check if matrix rows were changed
    for (int i = 1; i < 5; i++) {
      for (int j = 1; j < 5; j++) {
        try {
          if (!(tMatrix.get(j,i).equals("a"))) {
            fail("Unexpected value after filling region");
          } // if
        } catch (Exception e) {
          fail("Error with output");
        } // try/catch
      } // for
    } // for
  } // fillRegionTest()

  @Test
  /**
  * Check if we can fill a region.
  *
  * @throws Exception
  */
  public void fillLineTest() throws Exception {
    // Build a matrix
    MatrixV0<String> tMatrix = new MatrixV0<String>(10, 10);

    // incorrect indexes should fail
    // starting row below range
    try {
      tMatrix.fillRegion(-1, 1, 5, 5, "a");
      fail("row should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // starting column below range
    try {
    tMatrix.fillRegion(1, -1, 5, 5, "a");
    fail("col should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // ending row above range
    try {
      tMatrix.fillRegion(1, 1, 11, 5, "a");
      fail("row should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch
    // ending col above range
    try {
      tMatrix.fillRegion(1, 1, 5, 11, "a");
      fail("col should have been out of range");
    } catch (Exception e) {
      // success condition
    } // try/catch

    // check if we can fill the region row (1-5) and col (1-5)
    try {
      tMatrix.fillRegion(1, 1, 5, 5, "a");
    } catch (Exception e) {
      fail("fill region not completed");
    } // try/catch
    // check if matrix rows were changed
    for (int i = 1; i < 5; i++) {
      for (int j = 1; j < 5; j++) {
        try {
          if (!(tMatrix.get(j,i).equals("a"))) {
            fail("Unexpected value after filling region");
          } // if
        } catch (Exception e) {
          fail("Error with output");
        } // try/catch
      } // for
    } // for
  } // fillRegionTest()
} // TestsByStudent
