package com.zhijiansihang.sys.dialect;

import com.zhijiansihang.sys.dialect.Schema.Tables;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//@MappedSuperclass
public abstract class AbstractWordBook implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String SEQUENCE = Tables.WORDBOOK + Schema.SEQ_SUFFIX;

//	@SequenceGenerator(name = SEQUENCE, sequenceName = SEQUENCE)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
//	@Id
	@GeneratedValue
	@Id
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}