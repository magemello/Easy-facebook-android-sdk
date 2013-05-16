/*  
*	Author: Mario Romano & Eugenio Romano
*   Title : Easy Facebook Android SDK
*
*   This file is part of Easy Facebook Android SDK.
*
*   Easy Facebook Android SDK is free software; you can redistribute it and/or modify
*   it under the terms of the GNU Lesser General Public License as published by
*   the Free Software Foundation; either version 3 of the License, or
*   (at your option) any later version.
*
*   Easy Facebook Android SDK is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU Lesser General Public License for more details.
*
*   You should have received a copy of the GNU Lesser General Public License
*   along with Nome-Programma; if not, write to the Free Software
*   Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.easy.facebook.android.data;

public class Education {
	
	School school;
	String type;
	
	
	
	public Education() {
		super();
	}



	public Education(School school, String type) {
		super();
		this.school = school;
		this.type = type;
	}



	public School getSchool() {
		return school;
	}



	public void setSchool(School school) {
		this.school = school;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
