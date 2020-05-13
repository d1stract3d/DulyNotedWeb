package com.am.dulynoted.dao;

import com.am.dulynoted.beans.Note;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class NoteDAO {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Note n) {
		String sql = "insert into notes.note (title, content) values (\" " + n.getTitle() + " \" , \" " + n.getContent()
				+ " \" )";
		return template.update(sql);
	}

	public int update(Note n) {
		String sql = "update notes.note set title=\"" + n.getTitle() + "\", content=\"" + n.getContent()
				+ "\" where id=\"" + n.getId() + "\"";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from notes.note where id='" + id + "'";
		return template.update(sql);
	}

	public Note getNoteById(int id) {
		String sql = "select * from notes.note where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Note>(Note.class));
	}

	public List<Note> getNotes() {
		return template.query("select * from notes.note", new RowMapper<Note>() {
			public Note mapRow(ResultSet rs, int row) throws SQLException {
				Note n = new Note();
				n.setId(rs.getInt(1));
				n.setTitle(rs.getString(2));
				n.setContent(rs.getString(3));
				return n;
			}
		});
	}
}
