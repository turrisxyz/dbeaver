/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2019 Serge Rider (serge@jkiss.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jkiss.dbeaver.runtime.ui;

import org.eclipse.core.resources.IResource;
import org.jkiss.code.Nullable;
import org.jkiss.dbeaver.DBException;
import org.jkiss.dbeaver.model.DBPContextProvider;
import org.jkiss.dbeaver.model.DBPDataSourceContainer;
import org.jkiss.dbeaver.model.DBPImage;
import org.jkiss.dbeaver.model.exec.DBCExecutionContext;

/**
 * SQL Service
 */
public interface UIServiceSQL {

    int openSQLViewer(@Nullable DBCExecutionContext context, String title, @Nullable DBPImage image, String text, boolean showSaveButton);

    /**
     * @return IEditorPart
     */
    Object openSQLConsole(
        DBPDataSourceContainer dataSourceContainer,
        String name,
        String sqlText);

    /**
     *
     * @param site IWorkbenchPArtSite
     * @param parentControl   Composite
     * @param showVerticalBar
     * @return TextViewer
     */
    Object createSQLPanel(Object site, Object parentControl, DBPContextProvider contextProvider, String panelName, boolean showVerticalBar, String sqlText)
        throws DBException;

    Object openNewScript(DBPDataSourceContainer dataSource);

    Object openRecentScript(DBPDataSourceContainer dataSource);

    void openResource(IResource element);
}