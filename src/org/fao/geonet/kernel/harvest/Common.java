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

package org.fao.geonet.kernel.harvest;

import jeeves.exceptions.BadParameterEx;

//=============================================================================

public class Common
{
	//---------------------------------------------------------------------------
	//--- Status
	//---------------------------------------------------------------------------

	public enum Status
	{
		ACTIVE("active"), INACTIVE("inactive");

		//------------------------------------------------------------------------

		private Status(String status) { this.status = status; }

		//------------------------------------------------------------------------

		public String toString() { return status; }

		//------------------------------------------------------------------------

		public static Status parse(String status) throws BadParameterEx
		{
			if ("active"  .equals(status))	return ACTIVE;
			if ("inactive".equals(status))	return INACTIVE;

			throw new BadParameterEx("type", status);
		}

		//------------------------------------------------------------------------

		private String status;
	}

	//---------------------------------------------------------------------------
	//--- Type
	//---------------------------------------------------------------------------

	public enum Type
	{
		GEONETWORK("geonetwork"), WEB_FOLDER("webFolder");

		//------------------------------------------------------------------------

		private Type(String type) { this.type = type; }

		//------------------------------------------------------------------------

		public String toString() { return type; }

		//------------------------------------------------------------------------

		public static Type parse(String type) throws BadParameterEx
		{
			if ("geonetwork".equals(type))	return GEONETWORK;
			if ("webFolder" .equals(type))	return WEB_FOLDER;

			throw new BadParameterEx("type", type);
		}

		//------------------------------------------------------------------------

		private String type;
	}

	//---------------------------------------------------------------------------
	//--- Result
	//---------------------------------------------------------------------------

	public enum OperResult
	{
		OK("ok"),
		NOT_FOUND("not-found"),
		INACTIVE("inactive"),
		ALREADY_ACTIVE("already-active"),
		ALREADY_INACTIVE("already-inactive"),
		ALREADY_RUNNING("already-running");

		//------------------------------------------------------------------------

		private OperResult(String result) { this.result = result; }

		//------------------------------------------------------------------------

		public String toString() { return result; }

		//------------------------------------------------------------------------

		private String result;
	}
}

//=============================================================================

