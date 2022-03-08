#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Simple prototype for processing Fitbit data on mobile.

Author:
    Erik Johannes Husom

Created:
    2022-02-25

"""
import sys

import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from tensorflow.keras import models



def read_data_from_file(filepath):
    """Read data from filepath.

    Args:
        filepath (str): Path to data.

    Returns:
        X (array): Predictors, which is the input to a machine learning model.

    """

    df = pd.read_csv(filepath)

    # Create predictors (skip the first column, which is the timestamps)
    X = df.to_numpy()[:,1:]
    X = np.asarray(X).astype(np.float32)

    return X

def read_data_from_command_line(input_string):
    """Read data from filepath.

    Args:
        input_string (str): Data passed as a string from the command line.

    Returns:
        X (array): Predictors, which is the input to a machine learning model.

    """

    return None

def preprocess_data():
    pass

def scale_data(X, mean=None, std=None):
    """Scale input data.

    Args:
        X (array): Predictors.
        mean (array): Mean of each feature.
        std (array): Standard deviation of each feature.

    Returns:
        scaled_X (array): Scaled predictors.

    """

    if mean is None or std is None:
        mean = np.mean(X, axis=0)
        std = np.std(X, axis=0)
        X_scaled = (X - mean) / std
    else:
        X_scaled = (X - mean) / std

    return X_scaled, mean, std

def infer(model, X):
    """Infer values based on model and input data.

    Args:
        model (object): Tensorflow model.
        X (array): Predictors.

    Returns:
        y (array): Target.

    """

    y = model.predict(X)

    return y



if __name__ == '__main__':

    # Load data
    # filepath = "~/OneDrive/Datasets/Fitbit/fitbit_export_partners/original_data/fitbit_subject_01/Sleep/Heart Rate Variability Details - 2021-11-26.csv"
    filepath = sys.argv[1]
    X = read_data_from_file(filepath)

    # Load model
    model_filepath = "model.h5"
    model = models.load_model(model_filepath)

    # Load scaler
    scaler = np.load("scaler.npz")
    mean = scaler["mean"]
    std = scaler["std"]

    # Infer
    y = model.predict(X)
    # y = infer(model, X)

    # Print results
    print(y)
