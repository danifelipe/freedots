/* -*- c-basic-offset: 2; -*- */
package org.delysid.freedots.model;

public class TimeSignatureChange extends VerticalEvent {
  private TimeSignature timeSignature;

  public TimeSignatureChange(Fraction offset, TimeSignature timeSignature) {
    super(offset);
    this.timeSignature = timeSignature;
  }

  public TimeSignature getTimeSignature() { return timeSignature; }
}
