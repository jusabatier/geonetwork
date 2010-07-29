//==============================================================================
//===	Copyright (C) 2001-2007 Food and Agriculture Organization of the
//===	United Nations (FAO-UN), United Nations World Food Programme (WFP)
//===	and United Nations Environment Programme (UNEP)
//===
//===	This program is free software; you can redistribute it and/or modify
//===	it under the terms of the GNU General Public License as published by
//===	the Free Software Foundation; either version 2 of the License, or (at
//===	your option) any later version.
//===
//===	This program is distributed in the hope that it will be useful, but
//===	WITHOUT ANY WARRANTY; without even the implied warranty of
//===	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
//===	General Public License for more details.
//===
//===	You should have received a copy of the GNU General Public License
//===	along with this program; if not, write to the Free Software
//===	Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
//===
//===	Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
//===	Rome - Italy. email: geonetwork@osgeo.org
//==============================================================================

package org.fao.gast.cli.setup;

import java.util.List;

import org.fao.gast.lib.Lib;
import org.fao.gast.lib.Resource;

//==============================================================================

public class Setup
{
	public void exec(List<String> args) throws Exception
	{
		//--- this line saves the 'gast/data/index.html' file into 'web'
		//--- substituting the $SERVLET variable

		Lib.embeddedSC.save();

		//--- now we create the embedded database...

		Lib.embeddedDB.createDB();

		//--- ... and save the account into the config.xml file

		Lib.config.setDbmsUser    (Lib.embeddedDB.getUser());
		Lib.config.setDbmsPassword(Lib.embeddedDB.getPassword());
		Lib.config.addActivator();
		Lib.config.save();

		//--- proper setup: open a database connection and setup data

		Resource resource  = Lib.config.createResource();
		Lib.database.setup(resource, null);
			
	}

}

//==============================================================================

