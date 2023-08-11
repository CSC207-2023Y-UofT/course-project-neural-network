package com.playground.playground.interface_adapter.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/** The MainController class is responsible for assimilating values from other controllers. */
public class MainController implements Initializable {
  private DataAttributesController dataAttributesController;
  @FXML private VBox dataAttributesBox;
  private MlParametersController mlParametersController;
  @FXML private HBox mlParametersBox;

  public static GraphSystemController graphSystemController;
  @FXML private VBox graphSystemBox;

  private FeaturesHiddenLayersController featuresHiddenLayersController;
  @FXML private VBox featuresHiddenLayersBox;

  /**
   * Initializer for MainController.java
   *
   * @param location The location used to resolve relative paths for the root object, or {@code
   *     null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if the root
   *     object was not localized.
   */
  public void initialize(URL location, ResourceBundle resources) {
    FXMLLoader dataattloader =
        new FXMLLoader(
            getClass().getResource("/com/playground/playground/data-attributes-view.fxml"));
    try {
      dataAttributesBox = dataattloader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    dataAttributesController = dataattloader.getController();
    dataAttributesController.initialize(location, resources);

    FXMLLoader mlparamloader =
        new FXMLLoader(
            getClass().getResource("/com/playground/playground/ml-parameters-view.fxml"));
    try {
      mlParametersBox = mlparamloader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }

    mlParametersController = mlparamloader.getController();
    mlParametersController.initialize(location, resources);

    FXMLLoader graphSystemLoader =
        new FXMLLoader(getClass().getResource("/com/playground/playground/graph-system-view.fxml"));
    try {
      graphSystemBox = graphSystemLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    graphSystemController = graphSystemLoader.getController();
    graphSystemController.initialize(location, resources);

    FXMLLoader featuresHiddenLayersLoader =
        new FXMLLoader(
            getClass().getResource("/com/playground/playground/features-hidden-layers-view.fxml"));
    try {
      featuresHiddenLayersBox = featuresHiddenLayersLoader.load();
    } catch (IOException e) {
      e.printStackTrace();
    }
    featuresHiddenLayersController = featuresHiddenLayersLoader.getController();
    featuresHiddenLayersController.initialize(location, resources);
  }
}