package com.playground.playground.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.playground.playground.usecase.datasets.CircularDatasetGenerator;
import org.junit.jupiter.api.Test;

/** Test class to validate the functionality of various components in the data package. */
public class DataTest {

  /** Test the CircularDatasetGenerator to ensure it generates circular clusters correctly. */
  @Test
  public void testCircularDatasetGenerator() {
    DatasetGenerator circularDatasetGenerator = new CircularDatasetGenerator();
    ArrayList<ArrayList<ArrayList<Double>>> circularDataset = circularDatasetGenerator.generate(10);

    assertNotNull(circularDataset);
    assertEquals(2, circularDataset.size());

    ArrayList<ArrayList<Double>> cluster1 = circularDataset.get(0);
    ArrayList<ArrayList<Double>> cluster2 = circularDataset.get(1);

    assertFalse(cluster1.isEmpty());
    assertFalse(cluster2.isEmpty());

    assertTrue(cluster1.get(0).size() > 400);
    assertTrue(cluster1.get(1).size() > 400);
    assertTrue(cluster2.get(0).size() > 400);
    assertTrue(cluster2.get(1).size() > 400);
  }

  /**
   * Test the QuadrantDatasetGenerator to ensure it generates datasets for first and third quadrants
   * correctly.
   */
  @Test
  public void testQuadrantDatasetGenerator() {
    DatasetGenerator quadrantDatasetGenerator = new QuadrantDatasetGenerator();
    ArrayList<ArrayList<ArrayList<Double>>> quadrantDataset = quadrantDatasetGenerator.generate(10);

    assertNotNull(quadrantDataset);
    assertEquals(2, quadrantDataset.size());

    ArrayList<ArrayList<Double>> cluster1 = quadrantDataset.get(0);
    ArrayList<ArrayList<Double>> cluster2 = quadrantDataset.get(1);

    assertFalse(cluster1.isEmpty());
    assertFalse(cluster2.isEmpty());

    assertTrue(cluster1.get(0).size() < 1000);
    assertTrue(cluster1.get(1).size() < 1000);
    assertTrue(cluster2.get(0).size() < 1000);
    assertTrue(cluster2.get(1).size() < 1000);
  }

  /**
   * Test the SpiralDatasetGenerator to ensure it generates datasets for spiral patterns correctly.
   */
  @Test
  public void testSpiralDatasetGenerator() {
    DatasetGenerator spiralDatasetGenerator = new SpiralDatasetGenerator();
    ArrayList<ArrayList<ArrayList<Double>>> spiralDataset = spiralDatasetGenerator.generate(10);

    assertNotNull(spiralDataset);
    assertEquals(2, spiralDataset.size());

    ArrayList<ArrayList<Double>> cluster1 = spiralDataset.get(0);
    ArrayList<ArrayList<Double>> cluster2 = spiralDataset.get(1);

    assertFalse(cluster1.isEmpty());
    assertFalse(cluster2.isEmpty());

    assertTrue(cluster1.get(0).size() < 1000);
    assertTrue(cluster1.get(1).size() < 1000);
    assertTrue(cluster2.get(0).size() < 1000);
    assertTrue(cluster2.get(1).size() < 1000);
  }

  /**
   * Test the TransformDatasets to ensure it correctly transforms the input dataset to a suitable
   * format.
   */
  @Test
  public void testTransformDatasets() {
    ArrayList<ArrayList<ArrayList<Double>>> sampleData = new ArrayList<>();
    ArrayList<ArrayList<Double>> cluster1 = new ArrayList<>();
    cluster1.add(new ArrayList<>(List.of(1.0, 2.0, 3.0)));
    cluster1.add(new ArrayList<>(List.of(4.0, 5.0, 6.0)));
    ArrayList<ArrayList<Double>> cluster2 = new ArrayList<>();
    cluster2.add(new ArrayList<>(List.of(7.0, 8.0)));
    cluster2.add(new ArrayList<>(List.of(9.0, 10.0)));
    sampleData.add(cluster1);
    sampleData.add(cluster2);

    ArrayList<ArrayList<Object>> transformedData = TransformDatasets.transform(sampleData);

    assertNotNull(transformedData);
    assertFalse(transformedData.isEmpty());
    assertTrue(transformedData.size() <= 6);
  }
}