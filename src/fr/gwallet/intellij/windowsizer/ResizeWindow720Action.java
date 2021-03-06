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

public class ResizeWindow720Action extends AnAction implements ProjectSupport, JFrameSupport {

    @Override public void actionPerformed(AnActionEvent e) {
        centerAndResize(projectFrame(getEventProject(e)), 1280, 720);
    }
}
