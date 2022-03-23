// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;


import java.io.IOException;

import com.google.common.base.Objects;

// === xdr source ============================================================

//  union Preconditions switch (PreconditionType type) {
//      case PRECOND_NONE:
//          void;
//      case PRECOND_TIME:
//          TimeBounds timeBounds;
//      case PRECOND_V2:
//          PreconditionsV2 v2;
//  };

//  ===========================================================================
public class Preconditions implements XdrElement {
  public Preconditions () {}
  PreconditionType type;
  public PreconditionType getDiscriminant() {
    return this.type;
  }
  public void setDiscriminant(PreconditionType value) {
    this.type = value;
  }
  private TimeBounds timeBounds;
  public TimeBounds getTimeBounds() {
    return this.timeBounds;
  }
  public void setTimeBounds(TimeBounds value) {
    this.timeBounds = value;
  }
  private PreconditionsV2 v2;
  public PreconditionsV2 getV2() {
    return this.v2;
  }
  public void setV2(PreconditionsV2 value) {
    this.v2 = value;
  }

  public static final class Builder {
    private PreconditionType discriminant;
    private TimeBounds timeBounds;
    private PreconditionsV2 v2;

    public Builder discriminant(PreconditionType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder timeBounds(TimeBounds timeBounds) {
      this.timeBounds = timeBounds;
      return this;
    }

    public Builder v2(PreconditionsV2 v2) {
      this.v2 = v2;
      return this;
    }

    public Preconditions build() {
      Preconditions val = new Preconditions();
      val.setDiscriminant(discriminant);
      val.setTimeBounds(timeBounds);
      val.setV2(v2);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, Preconditions encodedPreconditions) throws IOException {
  //Xdrgen::AST::Identifier
  //PreconditionType
  stream.writeInt(encodedPreconditions.getDiscriminant().getValue());
  switch (encodedPreconditions.getDiscriminant()) {
  case PRECOND_NONE:
  break;
  case PRECOND_TIME:
  TimeBounds.encode(stream, encodedPreconditions.timeBounds);
  break;
  case PRECOND_V2:
  PreconditionsV2.encode(stream, encodedPreconditions.v2);
  break;
  }
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static Preconditions decode(XdrDataInputStream stream) throws IOException {
  Preconditions decodedPreconditions = new Preconditions();
  PreconditionType discriminant = PreconditionType.decode(stream);
  decodedPreconditions.setDiscriminant(discriminant);
  switch (decodedPreconditions.getDiscriminant()) {
  case PRECOND_NONE:
  break;
  case PRECOND_TIME:
  decodedPreconditions.timeBounds = TimeBounds.decode(stream);
  break;
  case PRECOND_V2:
  decodedPreconditions.v2 = PreconditionsV2.decode(stream);
  break;
  }
    return decodedPreconditions;
  }
  @Override
  public int hashCode() {
    return Objects.hashCode(this.timeBounds, this.v2, this.type);
  }
  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Preconditions)) {
      return false;
    }

    Preconditions other = (Preconditions) object;
    return Objects.equal(this.timeBounds, other.timeBounds) && Objects.equal(this.v2, other.v2) && Objects.equal(this.type, other.type);
  }
}