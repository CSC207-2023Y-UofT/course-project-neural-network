package com.playground.playground;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


import com.playground.playground.data.FeatureController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MlParametersController implements Initializable {
  private static String handleProblem;
  private static double handleRegularizationRate;
  @FXML private Button stepButton;

  @FXML private Button playButton;
  @FXML private Button rewindButton;
  @FXML private Text epochNumber;
  @FXML private MenuItem learn1;
  @FXML private MenuItem learn2;
  @FXML private MenuItem learn3;
  @FXML private MenuItem learn4;
  @FXML private MenuItem learn5;
  @FXML private MenuItem learn6;
  @FXML private MenuItem learn7;
  @FXML private MenuItem learn8;
  @FXML private MenuItem learn9;
  @FXML private MenuItem learn10;
  @FXML private MenuItem learn11;
  @FXML private MenuItem learn12;
  @FXML private MenuItem reLu;
  @FXML private MenuItem tanH;
  @FXML private MenuItem sigmoid;
  @FXML private MenuItem softMax;
  @FXML private MenuItem none;
  @FXML private MenuItem l1;
  @FXML private MenuItem l2;
  @FXML private MenuItem reg1;
  @FXML private MenuItem reg2;
  @FXML private MenuItem reg3;
  @FXML private MenuItem reg4;
  @FXML private MenuItem reg5;
  @FXML private MenuItem reg6;
  @FXML private MenuItem reg7;
  @FXML private MenuItem reg8;
  @FXML private MenuItem reg9;
  @FXML private MenuItem reg10;
  @FXML private MenuItem classify;
  @FXML private MenuItem regress;


  /**
   * Initializer for MIParametersController.java
   *
   * @param location The location used to resolve relative paths for the root object, or {@code
   *     null} if the location is not known.
   * @param resources The resources used to localize the root object, or {@code null} if the root
   *     object was not localized.
   */
  public void initialize(URL location, ResourceBundle resources) {
    // setting buttons
    setButtonWithImage(rewindButton, "playground-images/rewind-button.png");
    setButtonWithImage(playButton, "playground-images/play-button.png");
    setButtonWithImage(stepButton, "playground-images/fast-forward-button.png");
    learn1.setOnAction(this::handleLearningRate);
    learn2.setOnAction(this::handleLearningRate);
    learn3.setOnAction(this::handleLearningRate);
    learn4.setOnAction(this::handleLearningRate);
    learn5.setOnAction(this::handleLearningRate);
    learn6.setOnAction(this::handleLearningRate);
    learn7.setOnAction(this::handleLearningRate);
    learn8.setOnAction(this::handleLearningRate);
    learn9.setOnAction(this::handleLearningRate);
    learn10.setOnAction(this::handleLearningRate);
    learn11.setOnAction(this::handleLearningRate);
    learn12.setOnAction(this::handleLearningRate);
    reLu.setOnAction(this::handleActivation);
    tanH.setOnAction(this::handleActivation);
    sigmoid.setOnAction(this::handleActivation);
    softMax.setOnAction(this::handleActivation);
    none.setOnAction(this::handleRegularization);
    l1.setOnAction(this::handleRegularization);
    l2.setOnAction(this::handleRegularization);
    reg1.setOnAction(this::handleRegularizationRate);
    reg2.setOnAction(this::handleRegularizationRate);
    reg3.setOnAction(this::handleRegularizationRate);
    reg4.setOnAction(this::handleRegularizationRate);
    reg5.setOnAction(this::handleRegularizationRate);
    reg6.setOnAction(this::handleRegularizationRate);
    reg7.setOnAction(this::handleRegularizationRate);
    reg8.setOnAction(this::handleRegularizationRate);
    reg9.setOnAction(this::handleRegularizationRate);
    reg10.setOnAction(this::handleRegularizationRate);
    classify.setOnAction(this::handleProblem);
    regress.setOnAction(this::handleProblem);
  }

  public String handleProblem(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String problem = selection.getText();
    return problem;
  }

  public double handleRegularizationRate(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    double regularizationRate = Double.parseDouble(selection.getText());
    return regularizationRate;
  }

  public String handleRegularization(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String regularization = selection.getText().toLowerCase();
    return regularization;
  }

  public String handleActivation(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    String activation = selection.getText();
    return activation;
  }

  public double handleLearningRate(ActionEvent actionEvent) {
    MenuItem selection = (MenuItem) actionEvent.getSource();
    double learningRate = Double.parseDouble(selection.getText());
    return learningRate;
  }

  private void setButtonWithImage(Button button, String imagePath) {
    ImageView imageView =
        new ImageView(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
    imageView.setFitWidth(40); // Adjust the width as needed
    imageView.setFitHeight(40); // Adjust the height as needed
    button.setGraphic(imageView);
    button.getStyleClass().add("image-button");
  }


  public void handlePlayButtonClick(javafx.event.ActionEvent actionEvent) {
    int noise = DataAttributesController.noise;
    int batch = DataAttributesController.batchSize;
    int test = DataAttributesController.testRatio;
    String problemType = MlParametersController.handleProblem;
    double regularizeRate = MlParametersController.handleRegularizationRate;
    Object hiddenLayers = FeaturesHiddenLayersController.getLayersNeurons;

    String dataset = DataAttributesController.dataset;
    ArrayList<String> selectedButtons = FeaturesHiddenLayersController.selectedButtons;

    FeatureController.createTrainingData(dataset, selectedButtons, noise);

  }
}
