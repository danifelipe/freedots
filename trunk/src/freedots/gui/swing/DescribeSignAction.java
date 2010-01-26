/* -*- c-basic-offset: 2; indent-tabs-mode: nil; -*- */
/*
 * FreeDots -- MusicXML to braille music transcription
 *
 * Copyright 2008-2010 Mario Lang  All Rights Reserved.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details (a copy is included in the LICENSE.txt file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License
 * along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This file is maintained by Mario Lang <mlang@delysid.org>.
 */
package freedots.gui.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.text.JTextComponent;

import freedots.braille.Sign;
import freedots.music.Fingering;
import freedots.musicxml.Note;

/** Pops up a dialog to describe the sign at the caret position.
 */
@SuppressWarnings("serial")
public final class DescribeSignAction extends AbstractAction {
  private final Main gui;
  /** Flag to avoid firing up several message dialogs.
   */
  private boolean dialogShowing = false;

  public DescribeSignAction(final Main gui) {
    super("Describe sign...");
    this.gui = gui;
    putValue(SHORT_DESCRIPTION, "Describe the sign at caret position");
    putValue(ACCELERATOR_KEY,
             KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
  }
  public void actionPerformed(ActionEvent event) {
    Sign sign = gui.getSignAtCaretPosition();
    if (sign != null) {
      if (!dialogShowing) {
        final String title = "Description of " + sign;
        final String message = sign.getDescription();
        dialogShowing = true;
        JOptionPane.showMessageDialog(gui, message, title, JOptionPane.INFORMATION_MESSAGE);
        dialogShowing = false;
      }
    }
  }
}
