//=============================================================================
//===	Copyright (C) 2001-2005 Food and Agriculture Organization of the
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
//===	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//===
//===	Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
//===	Rome - Italy. email: GeoNetwork@fao.org
//==============================================================================

package org.fao.geonet.kernel.harvest.harvester;

import java.util.HashMap;
import java.util.List;
import jeeves.resources.dbms.Dbms;
import org.jdom.Element;

//=============================================================================

/** Loads all groups from the database and create a mapping (group name) -> (group ID)
  */

public class GroupMapper
{
	private HashMap<String, String> hmNameId = new HashMap<String, String>();

	//--------------------------------------------------------------------------
	//---
	//--- Constructor
	//---
	//--------------------------------------------------------------------------

	public GroupMapper(Dbms dbms) throws Exception
	{
		String query = "SELECT id, name FROM Groups";

		List idsList = dbms.select(query).getChildren();

		for (int i=0; i<idsList.size(); i++)
		{
			Element record = (Element) idsList.get(i);

			String id   = record.getChildText("id");
			String name = record.getChildText("name");

			hmNameId.put(name, id);
		}
	}

	//--------------------------------------------------------------------------
	//---
	//--- API methods
	//---
	//--------------------------------------------------------------------------

	/** Given a group name returns its id */

	public String getID(String name) { return hmNameId.get(name); }
}

//=============================================================================

