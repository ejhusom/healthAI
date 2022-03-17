package no.sintef.giot.bhp.spi;

public class PythonInferenceImpl extends InferenceService {

  @Override
  public String infer() {
    return "I am inferring something in Python!";
  }

  @Override
  public String getType() {
    return "I am a Python implementation of the inference service!";
  }
}
