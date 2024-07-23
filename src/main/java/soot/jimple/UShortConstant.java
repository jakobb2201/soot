package soot.jimple;

import soot.Type;
import soot.UShortType;
import soot.util.Switch;

public class UShortConstant extends IntConstant {

  private static final long serialVersionUID = 8622167089453261784L;

  public static final long MAX_VALUE = 65535;
  public static final long MIN_VALUE = 0L;

  private static final int MAX_CACHE = 128;
  private static final int MIN_CACHE = 0;
  private static final int ABS_MIN_CACHE = Math.abs(MIN_CACHE);
  private static final UShortConstant[] CACHED = new UShortConstant[MAX_CACHE + ABS_MIN_CACHE];

  protected UShortConstant(int value) {
    super(value);
  }

  public static UShortConstant v(int value) {
    if (value > MIN_CACHE && value < MAX_CACHE) {
      int idx = (int) (value + ABS_MIN_CACHE);
      UShortConstant c = CACHED[idx];
      if (c != null) {
        return c;
      }
      c = new UShortConstant(value);
      CACHED[idx] = c;
      return c;
    }
    return new UShortConstant(value);
  }

  @Override
  public boolean equals(Object c) {
    return c instanceof UShortConstant && ((UShortConstant) c).value == value;
  }

  @Override
  public int hashCode() {
    return (int) value;
  }

  // PTC 1999/06/28
  @Override
  public NumericConstant add(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value + ((UShortConstant) c).value);
  }

  @Override
  public NumericConstant subtract(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value - ((UShortConstant) c).value);
  }

  @Override
  public NumericConstant multiply(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value * ((UShortConstant) c).value);
  }

  @Override
  public NumericConstant divide(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value / ((UShortConstant) c).value);
  }

  @Override
  public NumericConstant remainder(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value % ((UShortConstant) c).value);
  }

  @Override
  public NumericConstant equalEqual(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v((this.value == ((UShortConstant) c).value) ? 1 : 0);
  }

  @Override
  public NumericConstant notEqual(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v((this.value != ((UShortConstant) c).value) ? 1 : 0);
  }

  @Override
  public boolean isLessThan(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return this.value < ((UShortConstant) c).value;
  }

  @Override
  public NumericConstant lessThan(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v((this.value < ((UShortConstant) c).value) ? 1 : 0);
  }

  @Override
  public NumericConstant lessThanOrEqual(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v((this.value <= ((UShortConstant) c).value) ? 1 : 0);
  }

  @Override
  public NumericConstant greaterThan(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v((this.value > ((UShortConstant) c).value) ? 1 : 0);
  }

  @Override
  public NumericConstant greaterThanOrEqual(NumericConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v((this.value >= ((UShortConstant) c).value) ? 1 : 0);
  }

  @Override
  public NumericConstant negate() {
    return UShortConstant.v(-(this.value));
  }

  @Override
  public ArithmeticConstant and(ArithmeticConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value & ((UShortConstant) c).value);
  }

  @Override
  public ArithmeticConstant or(ArithmeticConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value | ((UShortConstant) c).value);
  }

  @Override
  public ArithmeticConstant xor(ArithmeticConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value ^ ((UShortConstant) c).value);
  }

  @Override
  public ArithmeticConstant shiftLeft(ArithmeticConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value << ((UShortConstant) c).value);
  }

  @Override
  public ArithmeticConstant shiftRight(ArithmeticConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value >> ((UShortConstant) c).value);
  }

  @Override
  public ArithmeticConstant unsignedShiftRight(ArithmeticConstant c) {
    if (!(c instanceof UShortConstant)) {
      throw new IllegalArgumentException("UShortConstant expected");
    }
    return UShortConstant.v(this.value >>> ((UShortConstant) c).value);
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @Override
  public Type getType() {
    return UShortType.v();
  }

  @Override
  public void apply(Switch sw) {
    ((ConstantSwitch) sw).caseUShortConstant(this);
  }
}
