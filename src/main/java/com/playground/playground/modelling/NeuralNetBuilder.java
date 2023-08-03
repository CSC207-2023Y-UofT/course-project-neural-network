package com.playground.playground.modelling;

import org.nd4j.linalg.learning.config.Adam;
import org.nd4j.linalg.learning.config.IUpdater;

import java.util.ArrayList;
import java.util.Arrays;

public class NeuralNetBuilder {
    private ArrayList<Integer> layers = new ArrayList<>(Arrays.asList(2, 4, 2));
    private double learningRate = 0.001;
    private int seed = 123;
    private int inputs = 2;

    public NeuralNet buildNeuralNet() {
        return new NeuralNet(layers, seed, inputs, learningRate);
    }

    public NeuralNetBuilder inputs(int inputs) {
        this.inputs = inputs;
        return this;
    }

    public NeuralNetBuilder layers(ArrayList<Integer> layers) {
        this.layers = layers;
        return this;
    }

    public NeuralNetBuilder learningRate(double learningRate) {
        this.learningRate = learningRate;
        return this;
    }

    public NeuralNetBuilder seed(int seed) {
        this.seed = seed;
        return this;
    }
}