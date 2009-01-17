/* -*- c-basic-offset: 2; -*- */
package org.delysid.freedots.model;

public abstract class VerticalEvent implements Event {
  Fraction offset;

  public VerticalEvent(Fraction offset) { this.offset = offset; }

  public Fraction getOffset() { return offset; }
}
