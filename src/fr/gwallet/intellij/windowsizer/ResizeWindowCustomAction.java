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

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.ValidationInfo;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.stream.Stream;

public class ResizeWindowCustomAction extends AnAction implements ProjectSupport, JFrameSupport {

    @Override public void actionPerformed(AnActionEvent e) {
        final Project project = getEventProject(e);
        if (project != null)
            new DimensionDialog(project).show();
    }

    private class DimensionDialog extends DialogWrapper {
        private final JTextField inputWidth;
        private final JTextField inputHeight;
        private Project project;

        public DimensionDialog(@Nullable Project project) {
            super(project);
            this.project = project;
            final Dimension size = projectFrame(project).getSize();
            inputWidth = new JTextField(""+size.width);
            inputHeight = new JTextField(""+size.height);
            init();
            setTitle("Resize Project Window");
        }

        @Override protected @Nullable JComponent createCenterPanel() {
            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new GridLayout(2, 2));
            centerPanel.add(new JLabel("New width:"));
            centerPanel.add(inputWidth);
            centerPanel.add(new JLabel("New height:"));
            centerPanel.add(inputHeight);
            return centerPanel;
        }

        @Override protected @Nullable ValidationInfo doValidate() {
            final Dimension screenSize = screenSize();
            return Stream.of(
                    doValidateInput(inputWidth, 0, screenSize.width),
                    doValidateInput(inputHeight, 0, screenSize.height)
                ).filter(Objects::nonNull)
                 .findFirst()
                 .orElse(super.doValidate());
        }

        private @Nullable ValidationInfo doValidateInput(JTextField inputField, int minValue, int maxValue) {
            try {
                int intValue = Integer.parseInt(inputField.getText());
                if (intValue < minValue)
                    return new ValidationInfo("Invalid value, min " + minValue, inputField);
                if (intValue > maxValue)
                    return new ValidationInfo("Invalid value, max " + maxValue, inputField);
            } catch (NumberFormatException error) {
                return new ValidationInfo("Invalid number", inputField);
            }
            return null;
        }

        @Override protected void doOKAction() {
            int width = Integer.parseInt(inputWidth.getText());
            int height = Integer.parseInt(inputHeight.getText());
            centerAndResize(projectFrame(project), width, height);
            super.doOKAction();
        }
    }
}
