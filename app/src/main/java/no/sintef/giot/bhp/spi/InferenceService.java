package no.sintef.giot.bhp.spi;

/**
 * An abstract class for creating different inference implementations
 */
public abstract class InferenceService {

  public abstract String infer();

  public abstract String getType();
}
