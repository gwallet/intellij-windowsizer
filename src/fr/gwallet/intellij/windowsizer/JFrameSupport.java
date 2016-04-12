/*
 * Copyright (c) 2016 Guillaume Wallet < wallet (dot) guillaume (at) gmail (dot) com >
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package fr.gwallet.intellij.windowsizer;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public interface JFrameSupport {
    default Dimension screenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    default void centerAndResize(@Nullable JFrame frame, int width, int height) {
        if (frame == null) return;
        final Dimension screenSize = screenSize();
        int x = Long.valueOf(Math.round((screenSize.getWidth() - width) / 2)).intValue();
        int y = Long.valueOf(Math.round((screenSize.getHeight() - height) / 2)).intValue();
        frame.setBounds(x, y, width, height);
    }
}
