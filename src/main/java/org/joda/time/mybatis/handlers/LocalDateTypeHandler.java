//Copyright 2012 Lucas Libraro
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package org.joda.time.mybatis.handlers;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;

@MappedTypes(LocalDate.class)
public class LocalDateTypeHandler implements TypeHandler<LocalDate>
{

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
	 */
	public void setParameter(PreparedStatement ps, int i, LocalDate localDate, JdbcType jdbcType) throws SQLException
	{

		if (localDate != null)
		{
			ps.setDate(i, new Date(localDate.toDateTimeAtStartOfDay().toDate().getTime()));
		}
		else
		{
			ps.setDate(i, null);
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)
	 */
	public LocalDate getResult(ResultSet rs, String columnName) throws SQLException
	{
		Date date = rs.getDate(columnName);
		if (date != null)
		{
			return new LocalDate(date.getTime(), DateTimeZone.UTC);
		}
		else
		{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, int)
	 */
	public LocalDate getResult(ResultSet rs, int columnIndex) throws SQLException
	{
		Date date = rs.getDate(columnIndex);
		if (date != null)
		{
			return new LocalDate(date.getTime(), DateTimeZone.UTC);
		}
		else
		{
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement, int)
	 */
	public LocalDate getResult(CallableStatement cs, int columnIndex) throws SQLException
	{
		Date date = cs.getDate(columnIndex);
		if (date != null)
		{
			return new LocalDate(date.getTime(), DateTimeZone.UTC);
		}
		else
		{
			return null;
		}
	}

}
